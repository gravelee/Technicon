package com.technicon.renovationcontractorapp.jpautil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * 	It helps us instantiate the the persistance unit
 * 	that is defined within the persistance.xml and its
 * 	name is Persistance. It instantiates an entity 
 * 	manager factory with lazy instatiation and gives
 * 	us an entity manager when need.  
 * 
 * 	@author Grproth, skroutzzz, Chris394
 */
public class JpaUtil {
	
	private static final String PERSISTENCE_UNIT_NAME = "Persistence";
	private static EntityManagerFactory factory;
	 
	public static EntityManagerFactory getEntityManagerFactory() {
      
		if (factory == null) {
	      factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		
		return factory;
  }

	 
  public static EntityManager getEntityManager(){
      
	  return getEntityManagerFactory().createEntityManager();
  }

  
  public static void shutdown() {
      
	  if (factory != null) {
          factory.close();
          factory = null;
      }
  }
}
