<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>书籍列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@ include file="../include/frameHead.jsp" %>
</head>
  
<body>
    <div style="width: 120px; margin-bottom: 10px;">
    <div class="tbl-tr-action" style="float:left;"><a href="<%=request.getContextPath()%>/book/new"> new</a></div>
    &nbsp;
    <div class="tbl-tr-action" style="float:right;"><a href="<%=request.getContextPath()%>/book/delete/${u.bookId}"> delete</a></div>
    </div>
${message }
	
	<table width="100%" border="0" cellspacing="0" cellpadding="5">
        <tr class="tbl-title">
            <td>NAME</td>
            <td>AUTHOR</td>
            <td>PUBLISH DATE</td>
            <td>ENTRY DATE</td>
            <td>PRICE</td>
            <td>CATEGORY</td>
            <td>&nbsp;</td>
        </tr> 
		<c:forEach items="${bookList}" var="u">
		<tr class="tbl-tr">
		    <td>${u.bookName}</td>
		    <td>${u.author}</td> 
		    <td><fmt:formatDate value="${u.publishDate}" pattern="yyyy-MM-dd"/></td>
		    <td><fmt:formatDate value="${u.entryDate}" pattern="yyyy-MM-dd"/></td>
		<!--         <td>
		            <c:forEach items="${deptList}" var="d">
		                <c:if test="${d.id == u.deptId}">
		                    ${d.name}
		                </c:if>
		           </c:forEach>
		        </td> -->
            <td>${u.price}</td> 
            <td>${u.bookCategory.bookCategoryName}</td> 
            <td>
                <span class="tbl-tr-action2"><a href="<%=request.getContextPath()%>/book/update/${u.bookId}">edit</a></span>
		    </td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>