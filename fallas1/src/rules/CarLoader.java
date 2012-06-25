package rules;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CarLoader {


	public static List<Car> loadFile(){
		List<Car> autos = new ArrayList<Car>();
		File file = null;
		FileReader fr = null;
		BufferedReader reader= null;
		
		try {

			
			file=new File("C:\\Users\\Sebastián\\Documents\\base");
			fr=new FileReader(file);
			reader = new BufferedReader(fr);
			
			String line;
			
			while((line=reader.readLine())!=null){
				String[] characteristics = line.split(";");
				autos.add(new Car(characteristics));
				
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
		
		return autos;
		
	}
}
