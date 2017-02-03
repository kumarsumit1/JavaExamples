package com.java.examples.comparison;
 
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;
 
public class SortedSetTest {
    public static void main(String[] args) {
       // SortedSet<Employee> set = new TreeSet<Employee>();
        SortedSet<Employee> set = new TreeSet<Employee>(Employee.AgeComparator);
        Employee e1 = new Employee(1, "aTestName", 56, 34);
        Employee e2 = new Employee(2, "nTestName", 54, 30);
        Employee e3 = new Employee(3, "kTestName", 67, 31);
        Employee e4 = new Employee(4, "dTestName", 47, 25);
 
        set.add(e2);
        set.add(e3);
        set.add(e1);
        set.add(e4);
 
        System.out.println(set);
        
      // Collections.sort(set, Employee.SalaryComparator);
    }
}