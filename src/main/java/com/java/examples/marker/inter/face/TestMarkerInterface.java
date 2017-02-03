package com.java.examples.marker.inter.face;

public class TestMarkerInterface {
/* 
 1.Marker interface in Java is interfaces with no field or methods or in simple word empty interface 
  in java is called marker interface.
 2.A marker interface in Java is an anti-pattern which is used to add metadata to a class.
 3.Example of market interface is Serializable, Clonnable and Remote interface
 4. After introduction of Annotation on Java5, Annotation is better choice than marker interface 
    and JUnit is a perfect example of using Annotation e.g. @Test for specifying a Test Class. 
    Same can also be achieved by using Test marker interface.
 5. Q. Marker interface won't contain any method then how the objects will get that special ability?
    Ans. JVM is responsible to provide required ability in marker interfaces

 6. Q. Is it possible to create our own marker interface?
     Ans. Yes. But customization of JVM is required. However we can simulate the functionality by doing something as below 
    
     public interface Allopathic{}
     public interface Homeopathic{}
     public interface Ayurvedic{}  

And then using the below checks in our implemented code while this kind of functionality is implemented by JVM for Serialization or Cloning

for (Medicine medicine : allMedicines) {
if (medicine instanceof Allopathic) {
//... update stats accordingly
}
else if (medicine instanceof Homeopathic) {
//... update stats accordingly
}
else if (medicine instanceof Ayurvedic) {
//... update stats accordingly
}
else {
//... handle stats for general items
}
}


 */
	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		ClassImplementingClone cp=new ClassImplementingClone();
		cp.clone();

		//Since we have not implements Cloneable despite the fact we have overridden clone method it throws an error
		//Hence the JMV must be doing some extra work when clone() method gets called having marker interface
		// So, effectively marker interfaces kind of send out a signal to the corresponding external/internal entity (JVM in case of Cloneable) 
		//for them to arrange for the necessary functionality.

		ClassNotImplementingClone cnp=new ClassNotImplementingClone();
		cnp.clone();
		
	/*	If you notice the object class must have implemented clone function something like this to check if
	 * the implemented class is an intance of Cloneable or not .
	 * 
	   public Object clone() throws CloneNotSupportedException {
		 if (this implements Cloneable)
		     return nativeCloneImpl();
		 else
		     throw new CloneNotSupportedException();
		}
    */
		
	}

}
