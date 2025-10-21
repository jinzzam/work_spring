<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#uploadBtn").on("click", function() {
			var inputFile = $("input[name='uploadFile']");
			var files = inputFile[0].files;
			console.log(files);
		});//end of click function
	});//end of ready function
</script>
</head>
<body>
	<h1>Upload with Jquery</h1>
	
	<div class="uploadDiv">
		<input type="file" name="uploadFile" multiple>
	</div>
	
	<button id="uploadBtn">Upload</button>
</body>
</html>