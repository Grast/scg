package com.seuminterface.scg;

import java.util.ArrayList;

/**
 * 메소드 체이닝 및 람다 익명함수를 사용하기 위한 체이닝 제네릭 클래스
 * 
 * @author PurplelightFullmoon
 */
public class ChainList<E> extends ArrayList<E> {
	private static final long serialVersionUID = -1873308807877493752L;
	
	public ChainList() {}
	public ChainList(E e) {
		this.add(e);
	}
	
	/**
	 * 엘리먼트 추가 후 체인리스트 객체를 다시 반환. 연쇄 cat 가능.
	 * @param item	추가할 엘리먼트 객체
	 * @return	체인리스트 객체 재귀호출
	 */
	public ChainList<E> cat(E item) {
		this.add(item);
		
		return this;
	}
	
	/**
	 * 지정하고자 하는 리턴타입이 있을 경우 사용.
	 * @param <C>	리턴타입으로 지정된 클래스 타입
	 * @param index	추출하기 위한 엘리먼트 인덱스번호
	 * @param type	리턴타입으로 지정하기 위한 클래스 타입
	 * @return		리턴타입으로 캐스팅된 엘리먼트 아이템
	 */
	@SuppressWarnings("unchecked")
	public <C> C get(int index, Class<C> type) {
		return (C) this.get(index);
	}
	
	/**
	 * 문자열 출력
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.getClass().getName() + " [");
		for(int count=0 ; count<size() ; count++) {
			sb.append("\n\t" + get(count).toString());
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