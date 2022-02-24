# Injection

1. SQL Injection :
     Use prepared statement.
	 
2. XXE Processing :
      Disable external referencing of document elements.

3. Command Injection :
		Avoiding user input in command arguments is the only way to completely avoid command injection attacks. If user input is necessary for the command, then use the whitelist of allowed characters to minimize the possibility of command injection.	

4. Session Fixation :
		Using a different session ID before and after the authentication allows avoiding session fixation.
		
5. Use Of Insufficiently Random Values :
			If session ID is not sufficiently random, it could be predicted, thus allowing to hijack user accounts

#Cross-Site Scripting
			
1. Reflected Xss
         using additional security controls like HTTPOnly cookie flag, Content Security Policy HTTP Header, and X-XSS-Protection HTTP Header can also help to protect from XSS attacks.

2. Stored (Persistent) XSS 		 
 XSS attacks is by escaping all unstrusted user input.
 
3. DOM Cross Site Scripting
		

4. Directory (Path) Traversal
    As with any user-supplied input, it is important to ensure that there is a context-specific input validation strategy in place. 


5. Privileged Interface Exposure


6.Authentication Credentials In URL

7. Session Exposure within URL

8. User Enumeration
      When it is possible to determine whether a user name is valid or not, it is known as a Username Enumeration vulnerability.
	  
	  a simple change to the application to return the following message (whether or not the user exists) would suffice:

		"A forgotten password reminder email has been sent to the address on file (if the username is valid). Please check your emails." 

9. Horizontal Privilege Escalation


10. Vertical Privilege escalation



11. Cross Site Request Forgery (GET)

		the following model is in line with the best practice for CRUD operations in a database-centric application:

		1. Use HTTP GET for Read operations (SQL SELECT)		
		2. Use HTTP POST for Create operations (SQL INSERT)
		3. Use HTTP PUT for Update operations (SQL UPDATE)
		4. Use HTTP DELETE for Delete operations (SQL DELETE) 
		
		
		
		

	