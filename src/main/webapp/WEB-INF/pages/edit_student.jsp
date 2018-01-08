<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<style>
table{border-collapse:collapse;font-family: Trebuchet MS;width:auto;margin:0px auto;}

input[type=text]{
height:40px;width:450px;padding-left:10px
}
.btn{border:none;
font-size:20px;margin:20px auto;text-align:center;color:#fff;display:block;text-decoration:none;width:450px;height:40px;line-height:40px;background:#5a8e07;
}
td{font-weight:bold}
.btn:hover{border:2px solid #5a8e07;background:#fff;color:#5a8e07}
#menu{
height:50px;max-width:100%;background:#113d84}
ul li{display:block;height:50px;line-height:50px;width:100px;text-align:center}
ul li:hover{background:red}
ul li a{color:#fff;text-decoration:none;font-size:19px}


</style>
<div id="menu">
<ul><li><a href="listStuds.htm" >Home</a></li></ul>
</div>
<table cellpadding=7px>
<caption><h1 style="color:#113d84;text-align:center;border-bottom:2px solid #113d84;width:450px">Edit Student Details </h1>
<form:form method="POST" commandName="stCmd">
</caption>
<tr><td>Number:</td><td><form:input path="sno" readonly="true" disabled="true"/></td></tr>
<tr><td>name: </td><td><form:input path="sname"/><form:errors cssStyle="color:red" path="sname" /></td></tr>
<tr><td>Address:</td><td><form:input path="sadd"/><form:errors path="sadd"/></td></tr>
<tr><td>Branch:</td><td><form:input path="sbranch"/><form:errors path="sadd"/></td></tr>
<tr><td>fee:</td><td><form:input path="sfee"/><form:errors path="sadd"/></td></tr>
<tr><td colspan="2"><input type="Submit" class="btn" value="Update details"/></td></tr>
</form:form>
</table>

<br>
<hr>
<p style="text-align:center">Designed By : <b>Ravi Pratap Srivastav</b></p>
