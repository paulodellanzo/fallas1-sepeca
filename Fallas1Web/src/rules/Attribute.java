package rules;

import java.util.ArrayList;

public class Attribute {
	
	private String name;
	ArrayList<String> optionList = new ArrayList<String>();
	ArrayList<Integer> valueList = new ArrayList<Integer>();
	private String description;
	private double value;
	private String number;
	private int level;
	private int fatherValue;
	private String father = null;
	
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Attribute(){
	}
	
	public Attribute(String name,double value){
		this.name=name;
		this.value=value;
	}
	
	public Attribute(String name,String description,String number,int level){
		this.name=name;
		this.description=description;
		this.number=number;
		this.level=level;
	}
	
	public Attribute(String name,String description,String number,int level,String father,int fatherValue){
		this.name=name;
		this.description=description;
		this.number=number;
		this.level=level;
		this.setFatherValue(fatherValue);
		this.setFather(father);
	}
	
	
	public ArrayList<String> getOptionsList() {
		return optionList;
	}
	
	public ArrayList<Integer> getValueList() {
		return valueList;
	}

	public void addOption(String option,int value) {
		this.optionList.add(option);
		this.valueList.add(value);
	}
	
	public void addOptions(String ...options){
		for (int i=0;i<options.length;i++){
			addOption(options[i], i);
		}
		
	}

	public void setName(String name){
		this.name=name;
	}
	
	public String getName(){
		return this.name;
	}

	public String getDescription() {
		
		return this.description;
	}
	public String getHtml(){
		String html = new String();
		html=html.concat("<div class=\"attribute\" id=\""+this.getName()+"\">");
		html=html.concat("<a class=\"attdesc\">"+this.getNumber()+") "+this.getDescription()+"</a></br>");
		html=html.concat("<select onchange=\"changeOptions()\" class=\"select\" name=\""+this.getName()+"\">");
		int attListSize = this.getOptionsList().size();
		for(int j=0;j<attListSize;j++){
			html=html.concat("<option value=\""+this.getValueList().get(j)+"\">"+this.getOptionsList().get(j)+"</option>");	
		}
		html=html.concat("</select>");
		html=html.concat("</div>");
		return html;
	}
	
	public String getScript(){
		String html = new String();
		
		if(this.getFather()==null)
			html=html.concat("if(level>="+this.getLevel()+"){");
		else			
			html=html.concat("if(level>="+this.getLevel()+" && $('#"+this.getFather()+" select').val()=="+this.getFatherValue()+"){");
		
		html=html.concat("$('#"+this.getName()+"').show();");
		html=html.concat("}");
		
		html=html.concat("else{");
		html=html.concat("$('#"+this.getName()+"').hide();");
		html=html.concat("$('#"+this.getName()+" select').val(0);");
		html=html.concat("}");

		return html;
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getFatherValue() {
		return fatherValue;
	
	}

	public void setFatherValue(int fatherValue) {
		this.fatherValue = fatherValue;
	}

	public String getFather() {
		return father;

	}

	public void setFather(String father) {
		this.father = father;
	}
}
