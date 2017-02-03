package com.java.examples.design.pattern.creational.singleton;

import java.io.Serializable;



public class DemoSingletonTest implements Serializable {
private volatile static DemoSingletonTest instance = null;

public static DemoSingletonTest getInstance() {
	if (instance == null) {
		instance = new DemoSingletonTest();
	}
	return instance;
}


/*protected Object readResolve() {
return instance;
}
*/
private int i = 10;

public int getI() {
	return i;
}

public void setI(int i) {
	this.i = i;
}
}
