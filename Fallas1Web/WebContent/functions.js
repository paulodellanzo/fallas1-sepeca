
function getResult(){
	

	result = document.getElementById('result').innerHTML ='<p class=%22message%22>Procesando consulta...</p>';

	
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