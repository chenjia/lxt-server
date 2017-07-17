package com.lxt.common.plugin.captcha;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.patchca.background.SingleColorBackgroundFactory;
import org.patchca.color.ColorFactory;
import org.patchca.filter.predefined.WobbleRippleFilterFactory;
import org.patchca.font.RandomFontFactory;
import org.patchca.service.AbstractCaptchaService;
import org.patchca.text.renderer.BestFitTextRenderer;
import org.patchca.utils.encoder.EncoderHelper;
import org.patchca.word.RandomWordFactory;

import com.lxt.common.bean.Response;
import com.lxt.common.utils.JWTUtils;
import com.lxt.common.utils.UUIDUtils;

import sun.misc.BASE64Encoder;

public class CaptchaServlet extends HttpServlet implements Serializable {
	private static MyCaptchaService cs = null;
	private static Random random = new Random();
	private static BASE64Encoder encoder = new sun.misc.BASE64Encoder();
	public static String CAPTCHA = "CAPTCHA";

	public void init() throws ServletException {
		super.init();
		// 可直接使用ConfigurableCaptchaService，然后修改配置
		cs = new MyCaptchaService();
	}

	public CaptchaServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Response resp = new Response();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		cs.setFilterFactory(new WobbleRippleFilterFactory());
		String captcha = EncoderHelper.getChallangeAndWriteImage(cs, "png", out);
		byte[] bytes = out.toByteArray();
		String base64Img = encoder.encodeBuffer(bytes).trim();
		Map<String, String> claimMap = new HashMap<String, String>();
		claimMap.put(CAPTCHA, captcha);
		resp.getHead().setToken(JWTUtils.sign(claimMap));
		resp.getBody().setData(base64Img);
		
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(resp.toJson());
		response.getWriter().flush();
		response.getWriter().close();
	}

	public void destroy() {
		cs = null;
		super.destroy();
	}

	private class MyWordFactory extends RandomWordFactory {
		public MyWordFactory() {
			// 文本范围和长度
			characters = "1234567890";
			minLength = 4;
			maxLength = 4;
		}
	}

	private class MyCaptchaService extends AbstractCaptchaService {
		public MyCaptchaService() {
			// 文本内容
			wordFactory = new MyWordFactory();
			// 字体
			fontFactory = new RandomFontFactory(30,new String[]{"宋体"});
			// 效果
			textRenderer = new BestFitTextRenderer();
			// 背景
			backgroundFactory = new SingleColorBackgroundFactory();
			// 字体颜色
			colorFactory = new ColorFactory() {
				@Override
				 public Color getColor(int x) {
	                int[] c = new int[3];
	                int i = random.nextInt(c.length);
	                for (int fi = 0; fi < c.length; fi++) {
	                    if (fi == i) {
	                        c[fi] = random.nextInt(71);
	                    } else {
	                        c[fi] = random.nextInt(256);
	                    }
	                }
	                return new Color(c[0], c[1], c[2]);
	            }
			};
			
			// 图片长宽
			width = 100;
			height = 36;
		}
	}
}
