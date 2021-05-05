# Java Script 

Java was developed at Netscape in 10 days and one key design decision is its a forgiving language in sense that it will make certain assumptions on 
your behalf and still run your code without giving an error.

The designer called it Live Script but since Java was popular to gain marketing buzz as well they started calling it Java Script.

The standard version of Java Script is called ECMA Script and its current version is 11 as of year 2020.


https://www.youtube.com/playlist?list=PLqq-6Pq4lTTYFJxC9NLJ7dSTI5Z1WWB6K
In JS function is treated as first class citizens i.e you can treat functions just as objects.

The most common runtime environment for Java Script is a Browser.

With JS one can do :
	client side development i.e normally browser based using frameworks like angular,React,JQuery etc 
	server side development using Node JS 



# JS Script Environmet setup

In Firefox console one can use Multi-line mode to write JS.  

## Fuctions:

1. Funtions Expression : Assinging function to a variable.


2. Function hoisting : Calling a function before declaring it.



3. Function self invoke/Annonymous Functions : When function call itself without declaring it explicitly. 


## Type Coercion 

  It automatically converts some data types i.e 123+"4" will be converted to "1234"
  
## the === operator  
As JS does implicit type conversion wherever possible i.e the following will be equal 
```
var a = 10;
var b = "10";
if ( a == b ) {
  console.log("both are equal");
  }
```  
Hence if you don't want implicit conversion then use "==="
```
var a = 10;
var b = "10";
if ( a === b ) {
  console.log("both are equal");
  }
```  



online JS +HTML editor : https://codepen.io/huange/pen/rbqsD


----------------- Helpful JS functions --------------------

Object.keys(objectName) : lists all the keys present in the oject
typeof(objectName) : prints type of object
JSON.stringify(objectName)	: The JSON.stringify() method converts a JavaScript object or value to a JSON string
						JSON.stringify(objectName, null, 4); // Indented 4 spaces
						JSON.stringify(objectName, null, "\t"); // Indented with tab
						


-------- Debugging -----------------------------
Just put a command "debugger;" at any line where you want to create a breakpoint.
then from console you can access the list of variables
