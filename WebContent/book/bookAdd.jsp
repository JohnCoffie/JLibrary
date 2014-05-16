<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include/import.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    
<script type="text/javascript">
   $(document).ready(function() {     
       $('#publishDate').datepicker({dateFormat: 'yy-mm-dd'});
       $("#btn-submit").click(function(){
           $("#bookForm").submit();
       });
   });
</script>
</head>
<body>

<div class="include-head">
    <%@ include file="/include/head.jsp" %>
</div>

<div class="include-body">

    <div id="include-nav">
        <%@ include file="/include/nav.jsp" %>
    </div>
    
    <div id="include-content" >
		<div class="frame">
		    <div class="subpage-main-title">+ ADD A NEW BOOK</div>
		    <form action="${pageContext.request.contextPath}/book/new" name="bookForm" id="bookForm" method="post">
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
			        <div class="subpage-action-btn" id="btn-submit" style="float:right;"><a href="#">submit</a></div>
                    <div class="subpage-action-btn" id="btn-cancel" style="float:right; margin-right: 10px;"><a href="#">cancel</a></div>
			    </div>
		    </form>
		</div>
    </div>
    
</div>

</body>
</html>