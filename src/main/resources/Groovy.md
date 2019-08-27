Groovy scripts  are compiled at runtime, and the bytecode is run, not the script itself. 
The performance overhead you get is not because of this, but because of the invocations in Groovy: 
everything is done through reflectionm, be it calling a method or accessing properties. 

You can execute a Groovy class or script from your IDE but Groovy provides other options. You can run Groovy code via:

- the Groovy shell: groovysh
- the Groovy interpreter: groovy
- the Groovy Console : groovyConsole
- the Groovy Compiler : To create Java bytecode, run the groovyc Hello.groovy command and run it via the Java virtual machine

https://www.vogella.com/tutorials/Groovy/article.html

### Differences

#### Equals, == and the method is()
One difference between Java and Groovy is that the == operator will check for equality and not for identity. 
Java checks if both variables points to the same object while Groovy checks if both variables are equals. 
To check for identify you can use in Groovy the is() method.

In Groovy null == null returns true. If two references point to the same object it is also true. 
If an object implements the compareTo method, Comparable this method is used, otherwise the equals method

#### Optional parameters in methods
Groovy allows to have optional parameter values. Optional parameter values are indicated by =0.
e.g : sum( a,b,c=5) where c=5 is optional value.


#### Default parameters in methods
In Groovy you assign default values to parameters in a method. If a default value for a parameter is defined, 
Groovy offers two method signatures: one with all parameters and one where the parameter with a default value is omitted. 
If you use multiple parameters with default values then the right most parameter with a default value is 
first eliminated then the next, etc.

### Features

#### GPath
GPath is a path expression language integrated into Groovy which allows parts of nested structured data to be identified. 
In this sense, it has similar aims and scope as XPath does for XML. The two main places where you use GPath expressions 
is when dealing with nested POJOs or when dealing with XML.

For example the a.b.c statement is equivalent to a.getB().getC().

GPath navigation works also in complex structures like XML or JSON.

#### GString
Java offers some very basic templating through printf, but Groovy goes deeper, offering string interpolation, 
the process of templating strings with variables


```
def name = "Kacper"
def result = "Hello ${name}!"
assertEquals("Hello Kacper!", result.toString())
```
We can interpolate a double-quoted string by surrounding expressions with `${}` or with $ for dotted expressions.

Its evaluation is lazy, though – it won’t be converted to a String until it is passed to a method that requires a String.

Hidden in this example is a little wrinkle – why are we calling toString()?
***Actually, result isn’t of type String, even if it looks like it.***

Because ***the String class is final***, Groovy’s string class that supports interpolation, GString, doesn’t subclass it. In other words, for Groovy to provide this enhancement, it has its own string class, GString, which can’t extend from String.

Simply put, if we did:
```
assertEquals("Hello Kacper!", result)
```
we get an error :

```
java.lang.AssertionError: expected: java.lang.String<Hello Kacper!>
  but was: org.codehaus.groovy.runtime.GStringImpl<Hello Kacper!>
Expected :java.lang.String<Hello Kacper!> 
Actual   :org.codehaus.groovy.runtime.GStringImpl<Hello Kacper!>
```

Note : hashCode in GString and String
Java Strings are immutable, and so calling hashCode on a given string always returns the same value.

But, GString hashcodes can vary since the String representation depends on the interpolated values.

And actually, even for the same resulting string, they won’t have the same hash codes:
```
def string = "2+2 is 4"
def gstring = "2+2 is ${4}"
assertTrue(string.hashCode() != gstring.hashCode())
```
***Thus, we should never use GString as a key in a Map!***

#### Regular expressions
Groovy is based on Java regular expression support and add the addition support operators to make the usage of regular expressions easier.

Groovy adds the Slashy string as String declaration. Slashy strings are Strings between two "/" signs. 
They don’t need escape backslashes in regular expressions.

## Data Types :

### String :
  https://www.baeldung.com/groovy-strings
  
### Numbers


### Ranges
Groovy supports the Range data type is a Collection. Ranges consists of two values separated by two dots. 
Ranges can for example be used to define a loop statement.  
  
### List  


#### Spreaddot operator
The spread dot operator (spread-dot operator) `*.` is used to invoke a method on all members of a Collection. 
The result of this operation is another Collection object.

```
def list = ["Hello", "Test", "Lars"]

// calculate the length of every String in the list
def sizeList = list*.size()
assert sizeList = [5, 4, 4]
```
TODO

#### Searching in a list with find, findall and grep

You can search in a list.
- findAll `{closure}` - returns all list elements for which the closure validates to true
- find `{closure}` - returns the list element for which the closure validates to true
- grep(Object filter) - Iterates over the collection of items and returns each item that matches the given filter - calling the Object#isCase. This method can be used with different kinds of filters like regular expressions, classes, ranges etc.



### Map


#### Each, any and the every method
You can call closures on the elements, via the each(), any() and every() method. 
The any() and every() methods return a boolean depending whether any or every entry in the map satisfies 
a condition defined by a closure.


### GPath TODO