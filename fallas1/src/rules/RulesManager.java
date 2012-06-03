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
	
	public Car getBestCar(){
		final StatefulKnowledgeSession ksession = knowledgeBase.newStatefulKnowledgeSession();
		ksession.setGlobal( "list",new ArrayList<Object>() );

		final Car car = new Car();
		car.setBrand( "Fiat" );
		car.setModel("Palio");
		
		final Car car2 = new Car();
		car2.setBrand( "Ford" );
		car2.setModel("Fiesta");
		ksession.insert(car);
		ksession.insert(car2);
		ksession.fireAllRules();
		ksession.dispose();
		return car;
		
	}

}
