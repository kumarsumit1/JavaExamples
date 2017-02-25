package com.java.examples.inheritence;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Dogs extends Animal {
// Rule no 1 : Only inherited methods can be overridden	hence private methods cant be overridden
	@Override
	public void move() {
        // dog moving code...
    }
	@Override
    protected void eat() {
        // dog eating code...
    }
	
	//drink cant be overridden as it is private 
    //	@Override
	private void drink(){
		
	}
	
// Rule #2: Final and static methods cannot be overridden.
	
	/*@Override
    final void walk(){
		
	}*/
	
    //  @Override
    static void runing(){
		
	}
	
 //Rule #3: The overriding method must have same argument list else it is overloading
    
    
    
 //  Rule #4: The overriding method must have same return type (or subtype).
    
    
 // Rule #5: The overriding method must not throw new or broader checked exceptions i.e exception should be subtype  
   //--> Adding unchecked or runtime exception is fine
    @Override
    protected void speak() throws IOException,IllegalArgumentException {
        // Dog moving code...
    }
   
    //--> Adding checked or compile time exception is not ok
    /*@Override
    protected void spoke() throws IOException,InterruptedException  {
        // Dog moving code...
    }*/
    
    //--> Adding a subtype or narrower exception 
    @Override
    protected void speaker() throws FileNotFoundException,IllegalArgumentException {
        // Dog moving code...
    }
   
    
    
    //--> Adding a super or broader exception is not allowed
   /* @Override
    protected void speaking() throws IOException {
        // Dog moving code...
    }*/
    
    
    
    //Rule #6: The overriding method must not have more restrictive access modifier.   
    
    
    //Rule #7: Use the super keyword to invoke the overridden method from a subclass.
    
    
   // Rule #8: Constructors cannot be overridden.
    
   // Rule #9: Abstract methods must be overridden by the first concrete (non-abstract) subclass.
    
   // Rule #10: A static method in a subclass may hide another static one in a superclass, and that’s called hiding.
    
    //Rule #11: The synchronized modifier has no effect on the rules of overriding.
    
    
    
}
