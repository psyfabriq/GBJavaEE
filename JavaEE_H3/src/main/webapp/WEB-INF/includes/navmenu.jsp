<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav>
	<ul class="nav nav-justified">
		<c:forEach items="${navigatemenu}" var="url">
			<li>${url}</li>
		</c:forEach>
	</ul>
</nav>
