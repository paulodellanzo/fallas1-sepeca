<%@page import="rules.*" import="java.util.*" import="rules.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    	               "http://www.w3.org/TR/html4/loose.dtd">
<%
	Criteria criteria = new Criteria();
	ArrayList<Attribute> attributeList = criteria.getAttributeList();	
	int attributeListSize =  attributeList.size();
	ArrayList<Attribute> inputAttributes = new ArrayList<Attribute>();
	
	
	for(int i=0;i<attributeListSize;i++){
		String parameter = attributeList.get(i).getName();
		String value = request.getParameter(parameter);
		Attribute attribute = new Attribute(parameter,Integer.parseInt(value));	
		inputAttributes.add(attribute);
		
	}
	
	RulesManager rulesManager = new RulesManager();
	ArrayList<Car> cars = rulesManager.getBestCars(inputAttributes);
	
	%>
	<ul id="slider">
	<%
	for (Car car:cars){
		%>
		<li class="car"> 		
   			<div class="image">
   		<%
   			out.println("<img src=\"carimages/"+car.getFoto()+"\">");
   		%> 		
   			</div>
   		   	<div class="description">
   		<%
   			out.println("Marca: "+car.getMarca());
   			out.println("<br/>");
   			out.println("Modelo: "+car.getModelo());
   			out.println("<br/>");   
   			out.println("Versión: "+car.getVersion());
   			out.println("<br/>");
   			out.println("Precio: "+Integer.toString(car.getPrecio()));
   		%> 	   			
   		   	</div>		
   		</li>
		<%
	}
	
	  
%>  
	</ul>
		
		
<script>
$(function(){
	$('#slider').anythingSlider({
		 resizeContents      : true, 
		 buildArrows         : true,
		 buildNavigation     : true,
		 hashTags			 : false,
		 startText           : "Go", 
		 stopText            : "Stop"
	});
});
</script>		
