package com.seuminterface.scg;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 메소드 체이닝 및 람다 익명함수를 사용하기 위한 체이닝 제네릭 클래스
 * 
 * @author PurplelightFullmoon
 */
public class ChainSet<T> extends HashSet<T> {
	private static final long serialVersionUID = -7467016154927683631L;

	public ChainSet() {}
	public ChainSet(T t) {
		this.add(t);
	}
	
	/**
	 * 엘리먼트 추가 후 체인리스트 객체를 다시 반환. 연쇄 cat 가능.
	 * @param item	추가할 엘리먼트 객체
	 * @return	체인셋 객체 재귀호출
	 */
	public ChainSet<T> cat(T item) {
		this.add(item);
		
		return this;
	}
	
	/**
	 * 문자열 출력
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		List<T> list = new ArrayList<T>(this);
		
		sb.append(this.getClass().getName() + " [");
		for(int count=0 ; count<size() ; count++) {
			sb.append("\n\t" + list.get(count).toString());
		}
		sb.append("\n]");
		
		return sb.toString();
	}

	/**
	 * 객체 일치여부 판단용 오버라이딩
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	/**
	 * 객체 일치여부 판단용 오버라이딩
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		return true;
	}
}