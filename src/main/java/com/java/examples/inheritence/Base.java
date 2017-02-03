package com.java.examples.inheritence;
public class Base {
    public void callBoth() {
        foo();
        bar();
    }

    private void foo() {
        System.out.println("Base.foo");
    }

    protected void bar() {
        System.out.println("Base.bar");
    }
   public void test(){
	   System.out.println("in base");
   }

}

