package com.java.examples.inheritence;
public  class Sub extends Base {
	public int baseVar=5;
	public int baseVar2=5;
	//public int subVar=6;
	
	
	
	//Note here foo method is not overriden here as the base class has same method with private access modified and hence can't be overwritten.
	//@Override
    public void foo() {
        System.out.println("Sub.foo ");
    }
   
    @Override
    public void bar() {
        System.out.println("Sub.bar :" +baseVar+baseVar2);
    }
 
    //  Cannot reduce the visibility of the inherited method from Base
 /* private void test(){
	 System.out.println("in sub");
   }*/

}
