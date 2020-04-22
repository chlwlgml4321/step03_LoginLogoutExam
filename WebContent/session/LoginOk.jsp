<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    response.setHeader("Cache-Control","no-store");//크롬 캐시 저장하지 말라는거 
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>


<script type="text/javascript">
$(function(){
	$("input[type=button]").click(function(){
		//로그아웃 버튼 클릭 
		if(confirm("정말 로그아웃???? ")){
			//세션의 정보를 모두 지운기 위해 페이지 이동 
			location.href="<%=application.getContextPath()%>/Logout";
			
		}
	
	
	});
});

</script>
</head>
<body>
<%

	response.setHeader("Cache-Control","no-store");
	if(session.getAttribute("sessionName")!=null){ 	//인증한거
		%>
		<h3>
		접속 시간:<%=session.getAttribute("sessionTime")%><p>
		 <%=session.getAttribute("sessionName")%> 님 로그인 성공 !!</p>
		 <img src="images/cal.png">
		  <input type="button" value="로그아웃" />
		
		
		</h3> 
	<% 
	 
	}else{ //인증안된거 
		%>
		<script type="text/javascript">
			alert("로그인하고 이용해주세요 ");
		location.href="LoginForm.html";
		</script>
		<% 
	}
%>
</body>
</html>