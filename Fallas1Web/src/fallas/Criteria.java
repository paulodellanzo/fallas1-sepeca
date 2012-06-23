package fallas;

import java.util.ArrayList;


public class Criteria {

	ArrayList<Attribute> attributeList = new ArrayList<Attribute>();
	
	public Criteria(){
		Attribute attribute=new Attribute("Precio","AAaaaaaaaaaaaaaaaa");
		attribute.addOption("Precio 1",1);
		attribute.addOption("Precio 2",2);
		attributeList.add(attribute);
		
		attribute=new Attribute("Seguridad","BBbbbbbbbbbbbbbbbbbbbbbbbbbb");
		attribute.addOption("Seguridad 1",3);
		attribute.addOption("Seguridad 2",4);
		attributeList.add(attribute);
		
		attribute=new Attribute("Marca","CCccccccccccccccccccccccccccc");
		attribute.addOption("Fiat",5);
		attribute.addOption("Ford",6);
		attributeList.add(attribute);
	}

	public String getHTML(){
		String html = new String();
		
		int listSize = attributeList.size();
		
		for(int i=0;i<listSize;i++){
			html=html.concat("<div class=\"attribute\">");
			html=html.concat("<a>"+attributeList.get(i).getDescription()+"</a>");
			html=html.concat("<div class=\"divselect\">");
			html=html.concat("<select class=\"select\" name=\""+attributeList.get(i).getName()+"\">");
			int attListSize = attributeList.get(i).getOptionsList().size();
			for(int j=0;j<attListSize;j++){
				html=html.concat("<option value=\""+attributeList.get(i).getValueList().get(j)+"\">"+attributeList.get(i).getOptionsList().get(j)+"</option>");	
			}
			html=html.concat("</select>");
			html=html.concat("</div>");
			html=html.concat("</div>");
		}
		return html;
		
	}
	
	public ArrayList<Attribute> getAttributeList() {
		return attributeList;
	}

	public void setAttributeList(ArrayList<Attribute> attributeList) {
		this.attributeList = attributeList;
	}
	
}
