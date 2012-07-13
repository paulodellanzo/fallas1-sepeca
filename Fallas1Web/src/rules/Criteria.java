package rules;

import java.util.ArrayList;



public class Criteria {

	ArrayList<Attribute> attributeList = new ArrayList<Attribute>();
	
	public Criteria(){
		Attribute attribute=new Attribute("Precio","�Cuanto es el precio m�ximo que est� dispuesto a pagar (en pesos)?","1",1);
		attribute.addOptions("NS/NC","60.000","74.000","88.000","102.000","116.000","130.000","144.000","158.000","172.000","186.000","200.000");
		attributeList.add(attribute);

		attribute=new Attribute("Sexo","�Cual es su g�nero?","2",1);
		attribute.addOptions("NS/NC","Masculino","Femenino");
		attributeList.add(attribute);
		
		attribute=new Attribute("Uso","�Para que utilizar� el auto?","3",1);
		attribute.addOptions("NS/NC","Ir a trabajar","Para los fines de semana","Para vacaciones a largas distancias","Para trabajar");
		attributeList.add(attribute);
		
		attribute=new Attribute("DistanciaTrabajo","�A cu�ntos kil�metros se encuentra su lugar de trabajo?","3.1",2,"Uso",1);
		attribute.addOptions("NS/NC","0 a 10 km","10 a 30 km","30 a 100 km","M�s de 100 km");
		attributeList.add(attribute);
		
		attribute=new Attribute("RutaTrabajo","�Viaja al trabajo por ruta o autopista?","3.2",2,"Uso",1);
		attribute.addOptions("NS/NC","S�","No");
		attributeList.add(attribute);
		
		attribute=new Attribute("DistanciaFinesDeSemana","�Qu� distancia recorre los fines de semana?","3.1",2,"Uso",2);
		attribute.addOptions("NS/NC","0 a 50 km","50 a 200 km","M�s de 200 km");
		attributeList.add(attribute);
		
		attribute=new Attribute("CantVacaciones","�Cu�ntas veces al a�o viaja?","3.1",2,"Uso",3);
		attribute.addOptions("NS/NC","1 vez","2 veces","M�s de 2 veces");
		attributeList.add(attribute);

		attribute=new Attribute("KmViaje1","�Cu�ntos kil�metros realiza por cada viaje?","3.1.1",3,"CantVacaciones",1);
		attribute.addOptions("NS/NC","0 a 200","200 a 400","400 a 700","700 a 1.000","1.000 a 1.500","1.500 a 3.000","M�s de 3.000");
		attributeList.add(attribute);
		
		attribute=new Attribute("KmViaje2","�Cu�ntos kil�metros realiza por cada viaje?","3.1.1",3,"CantVacaciones",2);
		attribute.addOptions("NS/NC","0 a 200","200 a 400","400 a 700","700 a 1.000","1.000 a 1.500","1.500 a 3.000","M�s de 3.000");
		attributeList.add(attribute);
		
		attribute=new Attribute("KmViaje3","En promedio, �Cu�ntos kil�metros anuales realiza?","3.1.1",3,"CantVacaciones",3);
		attribute.addOptions("NS/NC","0 a 500","500 a 1.000","1.000 a 3.000","3.000 a 10.000","10.000 a 20.000","M�s de 20.000");
		attributeList.add(attribute);
		
		attribute=new Attribute("DiarioTrabajo","�Viaja diariamente por su trabajo?","3.1",2,"Uso",4);
		attribute.addOptions("NS/NC","S�","No");
		attributeList.add(attribute);
		
		attribute=new Attribute("TransporteTrabajo","�Qu� debe transportar para desarrollar su actividad?","3.2",2,"Uso",4);
		attribute.addOptions("NS/NC","Personas","Carga","Nada");
		attributeList.add(attribute);
		
		attribute=new Attribute("CantPasajeros","�Hasta cu�ntos pasajeros transporta?","3.2.1",3,"TransporteTrabajo",1);
		attribute.addOptions("NS/NC","1","2 a 5","6 a 8","M�s de 8");
		attributeList.add(attribute);
	
		attribute=new Attribute("CantCarga","�Cu�ntos kilos de carga transporta?","3.2.1",3,"TransporteTrabajo",2);
		attribute.addOptions("NS/NC","Menos de 500","Entre 500 y 1.000","8","M�s de 1.000");
		attributeList.add(attribute);
		
		attribute=new Attribute("RutaOAutopistaTrabajo","�Viajar� habitualmente por ruta o autopista?","3.3",2,"Uso",4);
		attribute.addOptions("NS/NC","S�","No");
		attributeList.add(attribute);
		
		attribute=new Attribute("Menores","�Transportar� habitualmente menores de edad?","4",1);
		attribute.addOptions("NS/NC","S�","No");
		attributeList.add(attribute);
		
		attribute=new Attribute("CantMenores","�Cu�ntos menores transportar� simult�neamente?","4.1",2,"Menores",1);
		attribute.addOptions("NS/NC","1 a 3","M�s de 3");
		attributeList.add(attribute);
		
		attribute=new Attribute("Edad","�Qu� edad tiene?","5",1);
		attribute.addOptions("NS/NC","18 a 25 a�os","26 a 45 a�os","46 a 59 a�os","M�s de 60 a�os");
		attributeList.add(attribute);
		
		attribute=new Attribute("Experiencia","�Cu�ntos a�os de experiencia de manejo tiene?","6",2);
		attribute.addOptions("NS/NC","0 a 2 a�os","2 a 8 a�os","M�s de 8 a�os");
		attributeList.add(attribute);
		
		attribute=new Attribute("Combustible","�Qu� tipo de cumbustible prefiere?","7",2);
		attribute.addOptions("NS/NC","Nafta","Diesel","Indiferente");
		attributeList.add(attribute);

		attribute=new Attribute("Hibrido1","�Est� dispuesto a utilizar un veh�culo h�brido?","7.1",3,"Combustible",1);
		attribute.addOptions("NS/NC","S�","No");
		attributeList.add(attribute);

		attribute=new Attribute("Hibrido2","�Est� dispuesto a utilizar un veh�culo h�brido?","7.1",3,"Combustible",3);
		attribute.addOptions("NS/NC","S�","No");
		attributeList.add(attribute);
		
		attribute=new Attribute("Musica","�Qu� forma de escuchar m�sica prefiere?","8",2);
		attribute.addOptions("NS/NC","Radio","CD","MP3","No escucho m�sica");
		attributeList.add(attribute);
		
		attribute=new Attribute("Tecnologia","Califique su relaci�n con la tecnolog�a","9",2);
		attribute.addOptions("NS/NC","Muy buena","Buena","Mala","Regular");
		attributeList.add(attribute);
		
		attribute=new Attribute("Importante","Entre las siguientes caracter�sticas, �a cual le d� m�s importancia?","10",2);
		attribute.addOptions("NS/NC","Potencia del motor","Aspecto","Confort","Entretenimiento","Seguridad");
		attributeList.add(attribute);
		
		attribute=new Attribute("Gasto","�Qu� gastos mensuales de mantenimiento est� dispuesto a afrontar como m�ximo?","11",2);
		attribute.addOptions("NS/NC","800","1.200","1.600","2.000","2.400","2.800","3.200","3.600","4.000","4.400","4.800","5.200","5.600","6.000");
		attributeList.add(attribute);
		
		attribute=new Attribute("Noche","�Viaja con mayor frecuencia de noche que de d�a?","12",3);
		attribute.addOptions("NS/NC","S�","No");
		attributeList.add(attribute);

		attribute=new Attribute("Transmision","�Qu� tipo de transmisi�n prefiere?","13",3);
		attribute.addOptions("NS/NC","Manual","Autom�tica");
		attributeList.add(attribute);
		
		attribute=new Attribute("Seguro","�Qu� tipo de seguro desea contratar?","14",3);
		attribute.addOptions("NS/NC","Solo de responsabilidad civil","Terceros completo","Todo riesgo");
		attributeList.add(attribute);
	}

	public String getHTML(){
		String html = new String();
		
		int listSize = attributeList.size();
		
		for(int i=0;i<listSize;i++){
			html=html.concat(attributeList.get(i).getHtml());
		}
		
		html=html.concat("<script>");
		html=html.concat("function changeOptionsDo(level){");

		for(int i=0;i<listSize;i++){
			html=html.concat(attributeList.get(i).getScript());
		}
		html=html.concat("}");
		html=html.concat("</script>");
		return html;
		
	}
	
	public ArrayList<Attribute> getAttributeList() {
		return attributeList;
	}

	public void setAttributeList(ArrayList<Attribute> attributeList) {
		this.attributeList = attributeList;
	}
	
}
