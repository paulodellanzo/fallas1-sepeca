package rules;

import java.util.ArrayList;

public class PruebaMain {


	public static void main(String[] args) {
		ArrayList<Attribute> attributes = new ArrayList<Attribute>();
		attributes.add(new Attribute("Uso",3));
		attributes.add(new Attribute("Combustible",1));
		attributes.add(new Attribute("Precio",5));
		
		RulesManager rulesManager = new RulesManager();
		ArrayList<Car> cars = rulesManager.getBestCars(attributes);
		
		System.out.println("Autos:");
		for(Car car:cars){
			System.out.println(car.getMarca()+" "+car.getModelo()+" : "+car.getPotenciaDrl()+" : "+car.getSeguridadDrl()+" : "+car.getConfortDrl()+" : "+car.getEntretenimientoDrl()+" : "+car.getDesignDrl()+" : "+car.getAptitud());
		}
			
		
	}

}
