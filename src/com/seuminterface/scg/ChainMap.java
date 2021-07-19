package com.seuminterface.scg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 메소드 체이닝 및 람다 익명함수를 사용하기 위한 체이닝 제네릭 클래스
 * 
 * @author PurplelightFullmoon
 *
 * @param <K>	키 타입 패러미터
 * @param <V>	값 타입 패러미터
 */
public class ChainMap<K, V> extends HashMap<K, V> {
	private static final long serialVersionUID = 8379469399252374801L;
	
	public ChainMap() {}
	public ChainMap(K k, V v) {
		this.put(k, v);
	}
	
	/**
	 * 엘리먼트 추가 후 체인리스트 객체를 다시 반환. 연쇄 cat 가능.
	 * @param k	키
	 * @param v	값
	 * @return	체인맵 객체 재귀호출
	 */
	public ChainMap<K, V> add(K k, V v) {
		this.put(k, v);
		
		return this;
	}
	
	/**
	 * 지정하고자 하는 리턴타입이 있을 경우 사용.
	 * @param <C>	리턴타입으로 지정된 클래스 타입
	 * @param key	추출하기 위한 엘리먼트 키
	 * @param type	리턴타입으로 지정하기 위한 클래스 타입
	 * @return		리턴타입으로 캐스팅된 엘리먼트 값
	 */
	@SuppressWarnings("unchecked")
	public <C> C get(K key, Class<C> type) {
		return (C) this.get(key);
	}
	
	/**
	 * 문자열 출력
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		List<K> keyList = new ArrayList<K>(this.keySet());
		
		sb.append(this.getClass().getName() + "[");
		for(int count=0 ; count<keyList.size() ; count++) {
			sb.append("\n\t" + keyList.get(count).toString() + " = " + this.get(keyList.get(count)).toString());
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