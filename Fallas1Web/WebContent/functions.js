
function getResult(){
	
	result = document.getElementById('result').innerHTML ='<p class="message">Procesando consulta <img src="loadingcircle.gif" align="center"></p>';

	var criteria = document.getElementById('criteria').getElementsByTagName('select');
	var parametros = "";
	
	
	for(var i=0;i<criteria.length;i++){
		if(i==0){
			parametros=parametros+"?";
		}
		else{
			parametros=parametros+"&";
		}
		parametros=parametros+criteria[i].name+"="+criteria[i][criteria[i].selectedIndex].value;
	}
	
	$('#result').load('result.jsp'+parametros);
	
	
}
function changeOptions(){
	
	changeOptionsDo($('#level').val());
	
}

$(document).ready(function(){
	changeOptions();
});


