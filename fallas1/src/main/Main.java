package main;

import java.util.ArrayList;
import java.util.Collection;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.definition.KnowledgePackage;
import org.drools.event.rule.DebugAgendaEventListener;
import org.drools.event.rule.DebugWorkingMemoryEventListener;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;


public class Main {


	public static void main(String[] args) {

		final KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add( ResourceFactory.newClassPathResource( "Car.drl",Car.class ),ResourceType.DRL );

		if ( kbuilder.hasErrors() ) {
			throw new RuntimeException( "Unable to compile \"Car.drl\"." );
		}
		
		final Collection<KnowledgePackage> pkgs = kbuilder.getKnowledgePackages();

		final KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages( pkgs );

		final StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
		ksession.setGlobal( "list",new ArrayList<Object>() );

		ksession.addEventListener( new DebugAgendaEventListener() );
		ksession.addEventListener( new DebugWorkingMemoryEventListener() );

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

	}

}
