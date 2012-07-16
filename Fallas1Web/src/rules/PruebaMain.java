package rules;

import java.util.ArrayList;

public class PruebaMain {


	public static void main(String[] args) {
		ArrayList<Attribute> attributes = new ArrayList<Attribute>();
		attributes.add(new Attribute("Uso",1));
		attributes.add(new Attribute("Combustible",1));
		attributes.add(new Attribute("Precio",8));
		
		RulesManager rulesManager = new RulesManager();
		ArrayList<Car> cars = rulesManager.getBestCars(attributes);
		
		System.out.println("Autos:");
		for(Car car:cars){
			System.out.println(car.getMarca()+" "+car.getModelo()+" : "+car.getCombustible()+" : "+car.getAptitud());
		}
			
		
	}

}
