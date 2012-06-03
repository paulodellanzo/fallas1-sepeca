
function getResult(){
	
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

$(document).ready(function(){	

    if (!$.browser.opera) {

        $('select.select').each(function(){
            var title = $(this).attr('title');
            if( $('option:selected', this).val() != ''  ) title = $('option:selected',this).text();
            $(this)
                .css({'z-index':10,'opacity':0,'-khtml-appearance':'none'})
                .after('<span class="select">' + title + '</span>')
                .change(function(){
                    val = $('option:selected',this).text();
                    $(this).next().text(val);
                    })
        });

    };
		
});