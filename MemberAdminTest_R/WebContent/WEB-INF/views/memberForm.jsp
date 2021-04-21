<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원</title>
</head>
<body>
	<c:if test="${method eq 'addMember.do'}">
		<h1>회원가입</h1>
	</c:if>
	<c:if test="${method eq 'updateMember.do'}">
		<h1>회원정보 수정</h1>
	</c:if>
	<form name="frmMember" method="post" action="${contextPath }/member/${method}">
		<table border="1"> 
			<tr>
				<td>아이디*</td> 
				<td> 
				<!-- required>> 필수항목을 의미 -->
				<c:if test="${method eq 'addMember.do'}">
					<input type="text" name="memberid" required/> 
				</c:if>
				<c:if test="${method eq 'updateMember.do'}">
					<input type="text" name="memberid" value="${member.memberId}" readonly />
				</c:if>
				</td>
			</tr>
			<tr>
				<td>비밀번호*</td> 
				<td> 
					<input type="password" name="memberpw" value="${member.memberPw}" required/> 
				</td>
			</tr>
			<tr>
				<td>이름*</td> 
				<td> 
					<input type="text" name="membername" value="${member.memberName}" required/> 
				</td>
			</tr>
			<tr> 
				<td>성별</td> 
				<td> 
					<c:if test="${member.gender == 'M'}"> 
						<input type="radio" name="gender" value="M" checked />남
						<input type="radio" name="gender" value="F" />여 
					</c:if>
					<c:if test="${member.gender == 'F'}"> 
						<input type="radio" name="gender" value="M" />남
						<input type="radio" name="gender" value="F" checked />여 
					</c:if>
					<c:if test="${method eq 'addMember.do'}"> 
						<input type="radio" name="gender" value="M" />남 
						<input type="radio" name="gender" value="F" />여 
					</c:if>
				 </td> 
			 </tr>
			 <tr>
				<td>이메일</td> 
				<td> 
					<input type="email" name="memberemail" value="${member.memberEmail}"/> 
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="등록"/>
					<input type="reset" value="재입력"/>
					<input type="button" value="목록" onclick="location.href='${contextPath}/member/listMembers.do'"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>