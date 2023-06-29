<%@page import="com.yedam.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
	<h3>상세화면</h3>


	
    <c:choose>
    	<c:when test="${empty board}">
	  <p>조회된 결과가 없습니다</p>
	  </c:when>
	  <c:otherwise>
	  <form name="myFrm" method="post">
    	<input type = "hidden" name = "bno" value="${board.brdNo }">
	  <table border="1" class="table">
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" value="${board.brdTitle }"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer" value="${board.brdWriter }"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content" cols="30" rows="10">${board.brdContent }</textarea></td>
		</tr>
	 	<tr>
			<th>작성시간</th>
			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.createDate }" /></td>
		</tr> 
	  </table>
	</form>
	  </c:otherwise>
	</c:choose>
	
    
    
	
    <a href="boardList.do">목록으로 이동</a>
    
   
