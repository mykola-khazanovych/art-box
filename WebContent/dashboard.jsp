<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title>ArtBox for KIDS</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="fonts/LoraFont.css">
</head>


<body>

<table class="noLayout" style="width: 100%">
  <tr>
    <td rowspan=5  class="noLayout" style="width: 20%"></td>
    <td colspan=3 class="baseLayout" style="padding: 0px"><img src="img/art-box-title.jpg" class="fillingImage alignCenterImg" width="60%"></td>
    <td rowspan=5  class="noLayout" style="width: 20%"></td>
  </tr>
  <tr>
    <td style="width: 20%" class="loraFont backgroundColorCells baseLayout"><a href="home">Home</a></td>
    <td style="width: 20%" class="loraFont backgroundColorCells baseLayout"><a href="add">Add</a></td>
    <td style="width: 20%" class="loraFont backgroundColorCells baseLayout">Dashboard</td>
  </tr>
  <tr>
    <td colspan=3 class="loraFont">
    	<br>
			<p style="font-size: 0.8em">
				ArtBox set name (<i>left blank to see full list</i>):
				<form action="find" method="get">
					<input type="text" name="theme" size=20  class="loraFont">
					<input type="submit" value="Search">
				</form>
			</p>
				
		
			<br/>
			<p class=${textColor}>${message}</p>
			<p style="font-size: 0.8em">${artbox}</p>
	
		<!-- if database is empty we do not need to print empty table -->
		<c:if test="${not empty products}">
			
		<!-- JSTL version of result table -->
		<table class="baseLayout" style="width: 100%">
				<tr>
					<td>id</td>
					<td>theme</td>
					<td>age</td>
					<td>cost</td>
					<td></td>
				</tr>		
		
				<c:forEach items="${products}" var="product">
        		
        		<tr>
            		<td>${product.key}</td>
         		    <td>${product.value.theme}</td>
                    <td>${product.value.age}</td>
       		        <td>${product.value.cost}</td>
       		        
       		        <td>
       		        <form action="remove" method="post">
       		        	<input type="submit" value="Delete">
       		        	<input type="hidden" name="id" value="${product.key}">
       		        	</form>
       		        </td>
    		    </tr>
    			</c:forEach>
			</table>	
		</c:if>
		<p class="textColorFooter loraFont">Make your life happier with kids, make your kids happier with art!</p>
    </td>
  </tr>
  <tr>
   <td colspan=3 class="backgroundColorCells baseLayout">
    	<fieldset style="border: 1px solid #9999ff">
    		<legend class="textColorFooter" >Find us in social networks</legend>
    		<a href="https://www.facebook.com/babyartbox/?fref=ts">
    			<img src="img/facebook-icon-40x40.png" class="alignCenterImg">
    		</a>
    	</fieldset>
    </td>
  </tr>
</table>
</body>
</html>