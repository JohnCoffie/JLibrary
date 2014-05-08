<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <%@ include file="../include/frameHead.jsp" %>
    <script type="text/javascript">
       $(document).ready(function() {     
           $('#publishDate').datepicker({dateFormat: 'yy-mm-dd'});     
       });
    </script>
</head>
<body>

<div class="frame">
    <div class="subpage-main-title">+ ADD A NEW BOOK</div>
    <form action="${pageContext.request.contextPath}/book/new" name="bookForm" method="post">
        <div class="subpage-input-row"><span style="float: left;">BOOK NAME:</span><input name="bookName" type="text" class="subpage-add-input-box"></div>
        <div class="subpage-input-row"><span style="float: left;">AUTHOR:</span><input name="author" type="text" class="subpage-add-input-box"></div>
        <div class="subpage-input-row"><span style="float: left;">CATEGORY:</span>
            <select name="category" class="subpage-add-input-box">
	            <c:forEach items="${categoryList}" var="u">
	            <option value="${u.bookCategoryId}" ><c:out value="${u.bookCategoryName}"/></option>
	            </c:forEach>
            </select>
        </div>
        <div class="subpage-input-row"><span style="float: left;">PRICE:</span><input name="price" type="text" class="subpage-add-input-box"></div>
        <div class="subpage-input-row"><span style="float: left;">PUBLISH DATE:</span><input id="publishDate" name="publishDate" type="text" class="subpage-add-input-box"></div>
        <div class="subpage-input-row"><span style="float: left;">BRIEF INTRO:</span><input name="intro" type="text" class="subpage-add-input-box"></div>
    
	    <div class="subpage-action-row">
	        <input class="subpage-action-btn" type="button" value="cancel" >
	        &nbsp;
	        <input class="subpage-action-btn" type="submit" value="submit" >
	    </div>
    </form>
</div>

</body>
</html>