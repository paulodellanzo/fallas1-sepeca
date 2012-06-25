package rules;

import java.util.ArrayList;
import java.util.Collection;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.definition.KnowledgePackage;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;


public class RulesManager {

	private KnowledgeBase knowledgeBase;
	
	public RulesManager(){
		final KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add( ResourceFactory.newClassPathResource( "Car.drl",Car.class ),ResourceType.DRL );
		if ( kbuilder.hasErrors() ) {
			throw new RuntimeException( "Unable to compile \"Car.drl\"." );
		}
		final Collection<KnowledgePackage> pkgs = kbuilder.getKnowledgePackages();
		knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
		knowledgeBase.addKnowledgePackages( pkgs );
		
	}
	
	public ArrayList<Car> getBestCars(ArrayList<Attribute> attributes){
		final StatefulKnowledgeSession ksession = knowledgeBase.newStatefulKnowledgeSession();
		ksession.setGlobal( "list",new ArrayList<Object>() );
		ArrayList<Car> cars = (ArrayList<Car>) CarLoader.loadFile();
		
		for(Car car: cars)
			ksession.insert(car);
		ksession.fireAllRules();
		ksession.dispose();
		return cars;
		
	}

}
