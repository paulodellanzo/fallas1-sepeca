<%@page import="fallas.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    	               "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<link rel="stylesheet" type="text/css" href="index.css"/>
    	<script src="jquery.js"></script>
    	<script src="functions.js"></script>
    	<link rel="stylesheet" href="css/anythingslider.css">
		<script src="js/jquery.anythingslider.js"></script>
    	<title>SEPECA</title>
  </head>
  <body>
   
   	<div id="header">
   		<h1>Sistema Experto para elección de compra de automóvil</h1>
   	</div>
   
   	<div id="body">
    	<div id="criteria">
    	<% 
		Criteria criteria = new Criteria();
		out.println(criteria.getHTML());
   		%> 
   		<button id="submit" type="button" onClick="getResult()">
   		Obtener auto
   		</button>
   		</div>
   		
   		
   		<div id="result">  
   			Resultado
   			   		
   		</div>
   
   	</div>
   


  </body>
</html> 
