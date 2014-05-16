<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include/import.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
$(function(){
	$("#chk-selectAll").click(function(){
		$("input[name='bookId']").each(function() {
		    this.checked = !this.checked;
		});
	});
	
	$("#btn-edit").click(function(){
		var length = $("input[name='bookId']:checked").length;
		
		if ( length < 1 ) {
			$("#dialog-msg").html("no book is selected.");
			$("#dialog").dialog({
	            width: "auto",
	            height:"auto",
	            show: { duration: 300 },
	            modal: true,
	            buttons: {
	                "Ok": function() {
	                    $(this).dialog('close');
	                }
	            }
	        });
		} else if ( length > 1 ) {
			$("#dialog-msg").html("only one can be selected.");
			$("#dialog").dialog({
	            width: "auto",
	            height:"auto",
	            show: { duration: 300 },
	            modal: true,
	            buttons: {
	                "Ok": function() {
	                    $(this).dialog('close');
	                }
	            }
	        });
		} else {
			  var selected = $("input[name='bookId']:checked");
			  var action = "${pageContext.request.contextPath}/book/update";
			  $("#actionForm").attr("action",action);
			  $("#actionForm").submit();
		}
	});
	
	$("#btn-delete").click(function(){
		var length = $("input[name='bookId']:checked").length;
		
		if ( length < 1 ) {
            $("#dialog-msg").html("no book is selected.");
            $("#dialog").dialog({
                width: "auto",
                height:"auto",
                show: { duration: 300 },
                modal: true,
                buttons: {
                    "Ok": function() {
                        $(this).dialog('close');
                    }
                }
            });
        } else {
        	var bookIdList = new Array();
        	$("input[name='bookId']:checked").each(function(){
        		bookIdList.push( $(this).val() );
        	});
        	
			$.ajax({
			    type: "POST",
			    url: "${pageContext.request.contextPath}/book/remove",
			    data: {'bookIdList':bookIdList.toString()}, 
			    //dataType:"json",
			    async: false,   
			    success: function(data){
			    	afterDeletion();
			    }
			});
        }
	});
	
	function afterDeletion() {
		$("#dialog-msg").html("the selected books are deleted successfully.");
        $("#dialog").dialog({
            width: "auto",
            height:"auto",
            show: { duration: 300 },
            modal: true,
            buttons: {
                "Ok": function() {
                    $(this).dialog('close');
                    $("#actionForm").attr("action","${pageContext.request.contextPath}/book/list");
                    $("#actionForm").submit();
                }
            }
        });
	}
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
    <form id="actionForm" action="">
        <div style="width: 100%; margin-bottom: 10px;">
	       <div class="tbl-tr-action" style="float:left;"><a href="<%=request.getContextPath()%>/book/new"> new</a></div>&nbsp;
	       <div class="tbl-tr-action" style="float:left; margin-left: 10px;" id="btn-edit"><a href="#">edit</a></div>&nbsp;
	       <div class="tbl-tr-action" style="float:right; margin-left: 10px;" id="btn-delete"><a href="#">delete</a></div>
	    </div>
	    
	    <table width="100%" border="0" cellspacing="0" cellpadding="5">
	        <tr class="tbl-title">
	            <td>NAME</td>
	            <td>AUTHOR</td>
	            <td>PUBLISH DATE</td>
	            <td>ENTRY DATE</td>
	            <td>PRICE</td>
	            <td>CATEGORY</td>
	            <td><input type="checkbox" id="chk-selectAll" /></td>
	        </tr> 
	        <c:forEach items="${bookList}" var="u">
	        <tr class="tbl-tr">
	            <td>${u.bookName}</td>
	            <td>${u.author}</td> 
	            <td><fmt:formatDate value="${u.publishDate}" pattern="yyyy-MM-dd"/></td>
	            <td><fmt:formatDate value="${u.entryDate}" pattern="yyyy-MM-dd"/></td>
	            <td>${u.price}</td> 
	            <td>${u.bookCategory.bookCategoryName}</td> 
	            <td><input type="checkbox" name="bookId" value="${u.bookId}"/></td>
	        </tr>
	        </c:forEach>
	    </table>
    </form>
    </div>
    
</div>

<!-- container for dialog -->
<div id="dialog" title="dialog" ><p id="dialog-msg"></p></div>

	
</body>
</html>