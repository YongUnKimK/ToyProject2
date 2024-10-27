<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Todo List</title>

  <%-- css 파일 연결 (webapp 폴더 기준으로 경로 작성)--%>
  <link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>
  <h1>학생 관리 프로그램</h1>

  <h3>전체 학생 수 : ?  </h3>

  <hr>

  <h4>새로운 학생 추가</h4>
  <form action="/todo/add" method="post" id="addForm">
    
    <button>추가</button>
  </form>

  <hr>

  <table id="toyProject" border="1">
    <thead>
      <tr>
        <th>학생 번호</th> <!-- 페이지에서 보이는 용도의 단순 출력 번호 -->
        <th>학생 이름</th> <!-- 실제 이 데이터의 todoNo 고유번호 -->
        <th>학생 나이</th>
        <th>학생 성별</th>
        <th>학생 성적</th>
      </tr>
    </thead>
  
    <tbody>
      <c:forEach items="${toyProject_2}"  var="student">
        <tr>
          <td>${student.stuNo}</th> <%-- 단순 출력 번호 --%>
          <td>
            <a href="/stu/detail?stuNo=${student.stuNo}">${student.stuName}</a>
          </td>
					<td>${student.stuAge}</td>
					<td>${student.gender}</td>
					<td>${student.score}</td>
          <%-- 완료 여부 --%>     
        </tr>
       </c:forEach>
    </tbody>
  </table>
  
  <%-- session 범위에 message가 있을 경우 --%>
  <c:if test="${not empty sessionScope.message}">
  	<script>
  		alert("${message}");
  		// JSP 해석 우선순위
  		// 1 순위 : Java(EL/JSTL)
  		// 2 순위 : Front(HTML,CSS,JS)
  	</script>
  	
  	<%-- message를 한 번만 출력하고 제거 --%>
  	<c:remove var="message" scope="session"/>
  </c:if>


  <%-- JS 연결 --%>
  <script src="/resources/js/main.js"></script>
</body>
</html>