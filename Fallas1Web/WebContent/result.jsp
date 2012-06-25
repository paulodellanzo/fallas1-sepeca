<%@page import="fallas.*" import="java.util.*" import="rules.*" contentType="text/html" pageEncoding="UTF-8"%>
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
	
	
	for(Attribute att : inputAttributes){
		out.println(att.getName()+" : "+att.getValue());
	}
	
	
	RulesManager rulesManager = new RulesManager();
	ArrayList<Car> cars = rulesManager.getBestCars(inputAttributes);
	out.println("Size:"+cars.size());
	
%> 



   		<ul id="slider">
   			<li class="car">
   				
   		   		
   				<div class="image">
   				<img src="9728_20111201065634.jpg">
   				</div>
   		   		<div class="description">
   		   			aaaa
   		   		
   		   		</div>
   				
   			</li>

   			<li class="car">
   				
   		   		
   				<div class="image">
   				<img src="9680_20111108102412.jpg">
   				</div>
   				<div class="description">
   		   			bbbbb
   		   		</div>
   		   		
   				
   			</li>

   			<li class="car">
   				
   				<div class="image">
   				<img src="8799_20110921150453.jpg">
   				</div>
   				<div class="description">
   					cccccc
   				</div>
   			</li>
		</ul>
		
<script>
$(function(){
	$('#slider').anythingSlider({
		 resizeContents      : true, 
		 buildArrows         : true,
		 buildNavigation     : true,
		 hashTags			 : false,
		 startText           : "Correr", 
		 stopText            : "Parar"
	});
});
</script>		
