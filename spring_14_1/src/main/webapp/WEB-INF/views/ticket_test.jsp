<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#checkJson").click(function () {
				var member = {tno:"777",owner:"홍길동", grade:"A"};
				$.ajax({
					type:"post"
// 					,url:"프로젝트명/sample/ticket"
					,url:"${contextPath}/sample/ticket"
					,contentType:"application/json"
// 						JSON.stringify : 객체를 json 문자열 형태로 변환
					,data:JSON.stringify(member)
					,success:function(data){
						alert("@# data=>"+data)
					}
					,error:function(){
						alert("오류가 발생했습니디")						
					}
				}); // end ajax
			}); //end click function
		});//end of function
	</script>
</head>
<body>
	<input type="button" id="checkJson" value="회원 정보 보내기">
</html>