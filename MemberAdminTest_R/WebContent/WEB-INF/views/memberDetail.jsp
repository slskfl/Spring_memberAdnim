<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 정보 보기</title>
</head>
<body>
	<table border="1">
		<tr> <th>아이디</th> <td>${member.memberId}</td> </tr>
		<tr> <th>비밀번호</th> <td>${member.memberPw}</td> </tr>
		<tr> <th>이름</th> <td>${member.memberName}</td> </tr>
		<tr> 
			<th>성별</th> 
			<c:if test="${member.gender eq 'F' }">
				<td>여</td> 
			</c:if>
			<c:if test="${member.gender eq 'M' }">
				<td>남</td> 
			</c:if>
		</tr>
		<tr> <th>이메일</th> <td>${member.memberEmail}</td> </tr>
		<tr> <th>가입일</th> <td>${member.joinDate}</td> </tr>
		<tr> 
			<td colspan="2"> 
			<form name="go_update" action="${contextPath}/member/memberForm.do">
				<input type="hidden" name="method" value="updateMember.do"/>
				<input type="hidden" name="memberid" value="${member.memberId}" /> 
				<input type="submit" value="수정" /> 
			</form>
			<form name="go_delete" action="${contextPath}/member/deleteMember.do">
				<input type="hidden" name="memberid" value="${member.memberId}" />
				<input type="submit" value="삭제" /> 
			</form>
			<input type="button" value="목록" 
				onclick="location.href='${contextPath}/member/listMembers.do'" />
			</td> 
		</tr>
	</table>
</body>
</html>