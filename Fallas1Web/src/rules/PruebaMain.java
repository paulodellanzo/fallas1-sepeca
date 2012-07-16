package rules;

import java.util.ArrayList;

public class PruebaMain {


	public static void main(String[] args) {
		Attribute attribute = new Attribute("Sexo",2);
		ArrayList<Attribute> attributes = new ArrayList<Attribute>();
		attributes.add(attribute);
		
		RulesManager rulesManager = new RulesManager();
		ArrayList<Car> cars = rulesManager.getBestCars(attributes);
		
		System.out.println("Autos:");
		for(Car car:cars){
			System.out.println(car.getModelo()+" : "+car.getPotenciaDrl()+" : "+car.getSeguridadDrl()+" : "+car.getConfortDrl()+" : "+car.getEntretenimientoDrl());
		}
			
		
	}

}
