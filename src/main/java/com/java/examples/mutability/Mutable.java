package com.java.examples.mutability;

public class Mutable extends Immutable {
	 private int realValue;

     public Mutable(int value) {
         super(value);

         realValue = value;
     }

     public int getValue() {
         return realValue;
     }
     public void setValue(int newValue) {
         realValue = newValue;
     }

}
