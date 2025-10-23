package com.lgy.paging_search_oracle.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
//	페이지 번호가 10개씩 보이게 (1~10, 11~20)
	private int startPage; //시작 페이지: 1, 11
	private int endPage;   //끝 페이지 : 10, 20
	private boolean prev, next;
	private int total;
	private Criteria cri; //화면에 출력 개수
	
//	@Override
//	public String toString() {
//		String toStr = "@#startPage=>" + getStartPage()
//					  +"@#endPage=>" + getEndPage()
//					  +"@#prev=>" + prev
//					  +"@#next=>" + next
//					  +"@#total=>" + getTotal()
//					  +"@#cri=>" + getCri();
//		return toStr;
//	}
	
	public PageDTO(int total, Criteria cri) {
		this.total = total;
		this.cri = cri;
		
//		3페이지 = 3/10->0.3->1*10=10 (끝페이지)
//		11페이지 = 11/10->1.1->2*10=20 (끝페이지)
		this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0)) * 10;
//		10-9=1페이지
//		20-9=2페이지
		this.startPage = this.endPage - 9;
		
//		total : 70, 현재페이지:3->endPage:10=>70*1.0/10 =>7페이지
		int realEnd = (int)(Math.ceil((total * 1.0) / cri.getAmount()));
		
		if(realEnd <= this.endPage) {
			this.endPage = realEnd;
		}
		
//		1페이지보다 크면 존재 -> 참이고 아님 거짓으로 없음
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
}
