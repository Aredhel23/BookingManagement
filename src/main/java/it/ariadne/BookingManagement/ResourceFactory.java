package it.ariadne.BookingManagement;

import it.ariadne.BookingManagement.resources.Car;
import it.ariadne.BookingManagement.resources.Projector;

public class ResourceFactory {
	/***
	 * method to create a resource
	 * @param ResourceType (type of resource you want)
	 * @return the resource if is present
	 */
	   public Resource getResource(String ResourceType){
	      if(ResourceType == null){
	         return null;
	      }		
	      if(ResourceType.equalsIgnoreCase("PROJECTOR")){
	         return new Projector();
	         
	      } else if(ResourceType.equalsIgnoreCase("CAR")){
	         return new Car();
	         
	      } 
	      
	      return null;
	   }

}
