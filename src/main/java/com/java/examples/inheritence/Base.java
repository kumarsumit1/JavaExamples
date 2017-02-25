package com.java.examples.inheritence;
public class Base {
	public int baseVar=1;
	public int baseVar2=2;
	
    public void callBoth() {
        foo();
        bar();
    }

    private void foo() {
        System.out.println("Base.foo: ");
    }

    protected void bar() {
        System.out.println("Base.bar :"+baseVar+baseVar2);
    }
   public void test(){
	   System.out.println("in base");
   }

}

