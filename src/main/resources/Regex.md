
Tip :
1. start with sparce of character and idenfiy the firs character group ().
2. within character group the simplest patterns to start with is gropus i.e []
3. within [] start identifying patterns
4. Also notice anything outside capture group {()} will be ignored.

Access Log Sample

in24.inetnebr.com rfc931 authuser [01/Aug/1995:00:00:01 -0400] "GET /shuttle/missions/sts-68/news/sts-68-mcc-05.txt HTTP/1.0" 200 1839

(\S+) (\S+) (\S+) \[([\d\/A-Za-z\:\s\-]*)\] \"([A-Z]*) (\S*) ([A-Z\/0-9\.]+)\" ([0-9]+) ([0-9]*)

Match any character seperated by space/tab
Wo.r-ld Cu/p 2=0`14

(.*) (.*) (.*)


Fixed witdh regexone

Fixed width

1652401101720123930621977TuplesXYZ

(.{5})(.{2})(.{8})(.{10})(.{6}).*

  Note : XYZ will be ignored as it is not part of any character group

#List of Common patterns :
```
	abc… 	Letters
	123… 	Digits
	\d 	Any Digit
	\D 	Any Non-digit character
	. 	Any Character
	\. 	Period
	[abc] 	Only a, b, or c
	[^abc] 	Not a, b, nor c
	[a-z] 	Characters a to z
	[0-9] 	Numbers 0 to 9
	\w 	Any Alphanumeric character
	\W 	Any Non-alphanumeric character
	{m} 	m Repetitions
	{m,n} 	m to n Repetitions
	* 	Zero or more repetitions
	+ 	One or more repetitions
	? 	Optional character
	\s 	Any Whitespace
	\S 	Any Non-whitespace character
	^…$ 	Starts and ends
	(…) 	Capture Group
	(a(bc)) 	Capture Sub-group
	(.*) 	Capture all
	(abc|def) 	Matches abc or def
```	
	
# References :	
https://regexone.com	