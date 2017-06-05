<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<title>ArtBox for KIDS</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="fonts/LoraFont.css">
</head>

<body>

<table class="noLayout" style="width: 100%">
  <tr>
    <td rowspan=5 class="noLayout" style="width: 20%"></td>
    <td colspan=3 class="baseLayout" style="padding: 0px"><img src="img/art-box-title.jpg" class="fillingImage alignCenterImg" width="60%"></td>
    <td rowspan=5 class="noLayout" style="width: 20%"></td>
  </tr>
  <tr>
    <td style="width: 20%" class="loraFont backgroundColorCells baseLayout"><a href="home">Home</a></td>
    <td style="width: 20%" class="loraFont backgroundColorCells baseLayout">Add</td>
    <td style="width: 20%" class="loraFont backgroundColorCells baseLayout"><a href="list">Dashboard</a></td>
  </tr>
  <tr>
    <td colspan=3 class="loraFont baseLayout">
		<form method="post" action="add">
 			<fieldset class="baseLayout">
  			  <legend class="textColorGray">Define ArtBoxSet</legend>
  				<br>
  				<p class="${textColor}">${message}</p>
    			<br>
   			    <table style="width: 100%" class="noLayout">
    				<tr class="noLayout">
    					<td style="width: 10%" class="noLayout"></td>
    					<td style="width: 80%" class="noLayout">
    						<table style="width: 100%" class="noLayout">
    							<tr class="noLayout noPadding">
    								<td class="alignRight noLayout">ArtBox set name:</td>
    								<td class="noLayout noPadding alignLeft"><input type="text" name="theme" value="BEARS"><br></td>
    							</tr>
    							<tr class="noLayout noPadding">
        							<td class="alignRight noLayout">Recommended age from:</td>
    								<td class="noLayout noPadding alignLeft"> <input type="text" name="age" value="3"><br></td>
    							</tr>
    							<tr class="noLayout noPadding">
        							<td class="alignRight noLayout">Recommended cost (UAH):</td>
    								<td class="noLayout noPadding alignLeft"><input type="text" name="cost" value="215"><br></td>
    							</tr>
    							<tr class="noLayout">
    								<td colspan=3 class="alignCenter noLayout">
    									<br>
    									<input type="submit" value="Add" class="addPadding">
    								</td>
    							</tr>
    						</table>
    					</td>
    					<td style="width: 10%" class="noLayout"></td>
    			  </tr>
    			</table>
  			 <br>
  			</fieldset>
		</form>

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