package com.lgy.paging_search_oracle.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Criteria {
	private int pageNum; //페이지 번호
	private int amount;	//페이지 당 글 개수
	
	private String type;
	private String keyword;	//검색 단어
	
	public Criteria() {
//		초기 페이지는 1이고, 10개씩 출력
//		@AllArgsConstructor 에서 생성자 매개변수가 4개라서 오류->2개의 매개변수를 갖는 생성자 추가 필요
		this(1, 10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public String[] getTypeArr() {
//		type이 없으면 빈 스트링 객체(기본 목록 조회), 있으면 분리
		return type == null ? new String[] {} : type.split("");
	}

}
