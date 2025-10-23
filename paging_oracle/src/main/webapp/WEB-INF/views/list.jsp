<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	
	<style type="text/css">
		.div_page ul{
			display: flex;
			list-style: none;
		}
	</style>
</head>
<body>
	<table width="500" border="1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td>히트</td>
		</tr>
<!-- 		조회결과 -->
<!-- 		list : 모델객체에서 보낸 이름 -->
		<c:forEach var="dto" items="${list}">
			<tr>
				<td>${dto.boardNo}</td>
				<td>${dto.boardName}</td>
<%-- 				<td>${dto.boardTitle}</td> --%>
				<td>
				<!-- 			content_view : 컨트롤러단 호출 -->
<%-- 					<a href="content_view?boardNo=${dto.boardNo}">${dto.boardTitle}</a> --%>
					<a class="move_link" href="${dto.boardNo}">${dto.boardTitle}</a>
				</td>
				<td>${dto.boardDate}</td>
				<td>${dto.boardHit}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5">
			<!-- write_view : 컨트롤러단 호출 -->
				<a href="write_view">글작성</a>
			</td>
		</tr>
	</table>
	
	<h3>${pageMaker}</h3>
	
	<div class="div_page">
		<ul>
			<c:if test="${pageMaker.prev}">
				<li class="paginate_button">
					<a href="${pageMaker.startPage -1}">
						[Previous]
					</a>
				</li>
			</c:if>
			<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
<%-- 				<li>${num}</li> --%>
<%-- 				<li class="paginate_button" ${pageMaker.cri.pageNum == num ? "style='color:red'":""}> --%>
<!-- 				현재 페이지 배경색은 노란색으로 표시 -->
				<li class="paginate_button" ${pageMaker.cri.pageNum == num ? "style='background-color:yellow'":""}>
					<a href="${num}">
						[${num}]
					</a>
				</li>
			</c:forEach>
			<c:if test="${pageMaker.next}">
				<li class="paginate_button">
					<a href="${pageMaker.endPage +1}">
						[Next]
					</a>
				</li>
			</c:if>
		</ul>
	</div>
		
<!-- 		<form method="get" id="actionForm" action="list"> -->
		<form method="get" id="actionForm">
			<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
			<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
		</form>
	
</body>
</html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	var actionForm = $("#actionForm");
	
	//페이지 번호 처리
	$(".paginate_button a").on("click", function(e) {
		e.preventDefault();
// 		console.log("click~!");
		console.log("@# href=>" + $(this).attr("href"));
		
		var bno = actionForm.find("input[name='boardNo']").val();
		console.log("@# bno=>"+bno);
		
// 		게시글 클릭 후 뒤로가기 누르고 페이지 번호 누를 때 &boardNo=번호 계속 누적되는 거 방지
		if(bno != ""){
			actionForm.find("input[name='boardNo']").remove();
		}
		
		actionForm.find("input[name='pageNum']").val($(this).attr("href"));
// 		actionForm.submit();
		actionForm.attr("action", "list").submit();
	});

	//게시글 처리
	$(".move_link").on("click", function(e) {
		e.preventDefault();
		console.log("move click~!");
		console.log("@# href=>" + $(this).attr("href"));
		var targetBno = $(this).attr("href");
		
		var bno = actionForm.find("input[name='boardNo']").val();
		console.log("@# bno=>"+bno);
		
// 		게시글 클릭 후 뒤로가기 누르고, 글 번호 누를 때 &boardNo=번호 계속 누적되는 거 방지
		if(bno != ""){
			actionForm.find("input[name='boardNo']").remove();
		}
		
		actionForm.append("<input type='hidden' name='boardNo' value='"+targetBno+"'>");
		
// 		actionForm.attr("action", "content_view");
// 		컨트롤러에 content_view로 찾아감
		actionForm.attr("action", "content_view").submit();
	});
	
	
</script>















