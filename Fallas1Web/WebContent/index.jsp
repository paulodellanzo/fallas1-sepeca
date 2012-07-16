<%@page import="rules.*" contentType="text/html" pageEncoding="UTF-8"%>
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
   		<h3><img src="bannerfans_4666614.png" align="left"></h3>
   	</div>
   
   	<div id="body">
   		<div id="lateral">
	   		<div id="select">
	   			<a>Seleccione el nivel del cuestionario</a>
		   		<select onchange="changeOptions()" id="level">
		   			<option value=1>Básico </option>
		   			<option value=2>Intermedio </option>
		   			<option value=3>Avanzado </option>
		   		</select>
		   	</div>
	    	<div id="criteria">
		    	<%
		    		Criteria criteria = new Criteria();
		    	    out.println(criteria.getHTML());
		    	%>
	    	</div>
	    	<div id="envio">
				<button id="submit" type="button" onClick="getResult()">
		   		Mostrar autos recomendados
		   		</button>
	   		</div>
	   	</div>
	   		
   		<div id="result">  
   			<p class="message">
   			Contestar las preguntas y presionar el botón "Mostrar autos recomendados"
   			</p> 		
   		</div>
   	</div>
   


  </body>
</html> 
