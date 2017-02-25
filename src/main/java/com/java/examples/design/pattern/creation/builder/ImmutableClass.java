package com.java.examples.design.pattern.creation.builder;
import java.util.HashMap;
 
public class ImmutableClass {
     
    //required fields
    private int id;
    private String name;
     
    //optional fields
    private HashMap<String, String> properties;
    private String company;
     
    public int getId() {
        return id;
    }
 
    public String getName() {
        return name;
    }
 
    //If the immutable class attributes are not immutable, for example HashMap, 
    //we should perform deep copy or cloning to avoid modification of its attributes.
    public HashMap<String, String> getProperties() {
        //return cloned object to avoid changing it by the client application
        return (HashMap<String, String>) properties.clone();
    }
 
    public String getCompany() {
        return company;
    }
 
    //Make private constructor
    private ImmutableClass(ImmutableClassBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.properties = builder.properties;
        this.company = builder.company;
    }
     
        //Builder class
    public static class ImmutableClassBuilder{
        //required fields
        private int id;
        private String name;
         
        //optional fields
        private HashMap<String, String> properties;
        private String company;
         
        public ImmutableClassBuilder(int i, String nm){
            this.id=i;
            this.name=nm;
        }
       
        //All the param setter class return the object itself
        public ImmutableClassBuilder setProperties(HashMap<String,String> hm){
            this.properties = (HashMap<String, String>) hm.clone();
            return this;
        }
         
        public ImmutableClassBuilder setCompany(String comp){
            this.company = comp;
            return this;
        }
         
        //And a final build method returning a new instance of the class
        public ImmutableClass build(){
            return new ImmutableClass(this);
        }
    }
}