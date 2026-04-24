package com.green.board.vo;

public class DataVo {
//	field
	private String a;
	private int b;

//	constructor
	public DataVo() {}
	public DataVo(String a, int b) {
		this.a = a;
		this.b = b;
	}

//	get / set
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}

//	toString
	@Override
	public String toString() {
		return "DataVo [a=" + a + ", b=" + b + "]";
	}

	
} //
