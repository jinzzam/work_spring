package com.lgy.paging_oracle.dto;

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
	
	public Criteria() {
//		초기 페이지는 1이고, 10개씩 출력
		this(1, 10);
	}
}
