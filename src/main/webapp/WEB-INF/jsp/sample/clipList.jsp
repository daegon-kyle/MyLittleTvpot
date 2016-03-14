<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Clip List Test</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
</head>

<body>
<div class="container">
<h2>클립 목록 </h2>
</div>

<table style="border:1px solid #ccc">
    <colgroup>
        <col width="10%"/>
        <col width="*"/>
        <col width="15%"/>
        <col width="20%"/>
    </colgroup>
    <thead>
        <tr>
            <th scope="col">클립 ID </th>
            <th scope="col">클립 VID</th>
            <th scope="col">닉네임 </th>
            <th scope="col">출처 <th>
            <th scope="col">제목 </th>
            <th scope="col">좋아요수 </th>
            <th scope="col">재생시간 </th>
            <th scope="col">재생횟수 </th>
            <th scope="col">등록시간 </th>
        </tr>
    </thead>
    <tbody>
        <c:choose>
            <c:when test="${fn:length(list) > 0}">
                <c:forEach items="${list }" var="row">
                    <tr>
                        <td>${row.id }</td>
                        <td>${row.vid }</td>
                        <td>${row.ownerName }</td>
                        <td>${row.thumbUrl }</td>
                        <td>${row.title }</td>
                        <td>${row.numOfLike }</td>
                        <td>${row.playTime }</td>
                        <td>${row.numOfPlay }</td>
                        <td>${row.regDttm }</td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="4">조회된 결과가 없습니다.</td>
                </tr>
            </c:otherwise>
        </c:choose>
         
    </tbody>
</table>
</body>

</html>