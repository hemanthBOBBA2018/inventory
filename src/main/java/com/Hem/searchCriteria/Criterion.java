package com.hemanth.search;

import java.util.Arrays;

public class Criterion {
	
	private String key;
	
	private String value;
	
	private Criterion() {
	}
	
	public static Criterion build(final String str) {
		Opertation opCode = Arrays.stream(Opertation.values())
		.filter(op -> str.contains(op.opCode))
		.findFirst()
		.get();
		
		String[] values = str.split(opCode.opCode);
		Criterion criteria = new Criterion();
		criteria.key = values[0];
		criteria.value = values[1];
		criteria.op = opCode;
		return criteria;
	}
	
	public enum Opertation {
		EQ(":eq:"),NEQ(":neq:"),LT(":lt:"),GT(":gt:");
		
	
		private String opCode;
		
		private Opertation(String opCode) {
			this.opCode = opCode;
		}
		
		public String getOpCode() {
			return opCode;
		}
		
	}
	
	private Opertation op;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Opertation getOp() {
		return op;
	}

	public void setOp(Opertation op) {
		this.op = op;
	}

	@Override
	public String toString() {
		return "Criterion [key=" + key + ", value=" + value + ", op=" + op + "]";
	}

}
