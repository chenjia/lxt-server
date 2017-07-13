package com.lxt.dao.ext;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lxt.model.vo.ChatRecordVO;

public interface ChatExtMapper {
	
	public List<ChatRecordVO> queryChatRecords(@Param("sendId")String sendId, @Param("receiveId")String receiveId, @Param("beforeDate")Date beforeDate, @Param("count")Integer count);
}
