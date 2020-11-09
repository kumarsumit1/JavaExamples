
Tip :
1. start with space of character,if any, and idenfiy the first character group ().
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

#List of patterns :
```
	abc… 		Letters
	123… 		Digits
	\d 			Any Digit
	\D 			Any Non-digit character
	. 			Any Character
	\. 			Period
	[abc] 		Only a, b, or c
	[^abc] 		Not a, b, nor c
	[a-z] 		Characters a to z
	[0-9] 		Numbers 0 to 9
	\w 			Any Alphanumeric character
	\W 			Any Non-alphanumeric character
	\b 			Any word boundary
	{m} 		m Repetitions
	{m,n} 		m to n Repetitions
	* 			Zero or more repetitions
	+ 			One or more repetitions
	? 			Optional character
	\s 			Any Whitespace
	\S 			Any Non-whitespace character
	^…$ 		Starts and ends
	(…) 		Capture Group
	(a(bc)) 	Capture Sub-group
	(.*) 		Capture all
	(abc|def) 	Matches abc or def
```	

# Common patterns

```
	(a|b) 	a or b
	a? 		Zero or one of a
	a* 		Zero or more of a
	a+ 		One or more of a
	a{3} 	Exactly 3 of a
	a{3,} 	3 or more of a
	a{3,6} 	Between 3 and 6 of a
```

# Useful patterns

1. (.*) VS (.*?)

(.*)  : match everything in a greedy/reluctant way and capture it. i.e stops after the first match

(.*?) : match everything in a non-greedy way and capture it. i.e stops at the last match


Given the following input:

eeeAiiZuuuuAoooZeeee

The patterns yield the following matches:

    A.*Z yields 1 match: AiiZuuuuAoooZ 
    A.*?Z yields 2 matches: AiiZ and AoooZ 
	
eeeAiiZuuuuAoooZeeee
   \__/r   \___/r      r = reluctant
    \____g____/        g = greedy

https://stackoverflow.com/questions/3075130/what-is-the-difference-between-and-regular-expressions

2. .+ and .+?
Both will match any sequence of one or more characters. The difference is that:

    .+ is greedy and consumes as many characters as it can.
    .+? is reluctant and consumes as few characters as it can.

string: "extend cup end table"

    The pattern e.+d finds: "extend cup end"
    The pattern e.+?d finds: "extend" and "end"



3. (.+?) vs (.*?)

The .+? form requires at least one character to match, while .*? can match none at all. Both operations are non-greedy, so they will try to find the shortest possible matching string.



4. Balanced string
A string is composed of only a, b, c, d.

The string is said to be balanced if:

sum of occurence of a and c is even
sum of occurence of b and d is even

(?=^(([ac]*[bd]){2})*[ac]*$)(?=^(([bd]*[ac]){2})*[bd]*$).*

	
# References :	
https://regexone.com	
https://www.youtube.com/watch?v=TZoyfkZ6PdQ {helpful tips}