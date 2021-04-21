<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
</head>
<body>
	<table border="1"> 
		<tr> 
			<th>아이디</th> 
			<th>비밀번호</th> 
			<th>이름</th> 
			<th>성별</th>
			<th>이메일</th> 
			<th>가입일</th> 
			<th>삭제</th> 
		</tr>
		<c:forEach var="member"  items="${membersList}">
		<!-- MemberControllerImpl->listMembers()->mav 값을 받아옴 -->
			<tr> 
				<td><a href="${contextPath}/member/memberDetail.do?memberid=${member.memberId}">${member.memberId}</a></td> 
				<td>${member.memberPw }</td> 
				<td>${member.memberName }</td>
				<!-- eq : equals()와 같은 역할
					EL태그에서는 eq와 ==연산자 둘 다 사용 가능 -->
				<c:if test="${member.gender eq 'F' }">
					<td>여</td> 
				</c:if>
				<c:if test="${member.gender eq 'M' }">
					<td>남</td> 
				</c:if>
				
				<%-- <c:choose>
					<c:when test="${member.gender=='F' }">
						<td>남</td> 
					</c:when>
					<c:when test="${member.gender=='M' }">
						<td>여</td> 
					</c:when>
				</c:choose>  --%>
				<td>${member.memberEmail }</td> 
				<td>${member.joinDate }</td>
				<td>
					<!-- onclick>> confirm의 not은 삭제하지 않겠다는 의미. -->
					<input type="button" value="삭제" 
					onclick="if(!confirm('삭제하시겠습니까? ')) { return false;} 
						location.href='${contextPath}/member/deleteMember.do?memberid=${member.memberId}'"/>
				</td> 
			</tr>
		</c:forEach>
		<tr>
			<td colspan="7" style="text-align:right"> 
				<form method="post" action="${contextPath}/member/memberForm.do"> 
					<input type="hidden" name="method" value="addMember.do"/>
					<input type="submit" value="회원가입"/>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>