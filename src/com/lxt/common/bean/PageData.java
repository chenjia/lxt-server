package com.lxt.common.bean;

import java.util.ArrayList;
import java.util.List;

public class PageData<POJO> {
	private List<POJO> rows = new ArrayList<POJO>();
	private int total;

	public List<POJO> getRows() {
		return rows;
	}

	public void setRows(List<POJO> rows) {
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
