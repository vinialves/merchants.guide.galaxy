# Merchant's Guide to the Galaxy

## Problem 
 
You decided to give up on earth after the latest financial collapse left 99.99% of the earth's population with 0.01% of the wealth. Luckily, with the scant sum of money that is left in your account, you are able to afford to rent a spaceship, leave earth, and fly all over the galaxy to sell common metals and dirt (which apparently is worth a lot).
Buying and selling over the galaxy requires you to convert numbers and units, and you decided to write a program to help you.
The numbers used for intergalactic transactions follows similar convention to the roman numerals and you have painstakingly collected the appropriate translation between them.
Input to your program consists of lines of text detailing your notes on the conversion between intergalactic units and roman numerals.
 
---------------------------------------------------------------------------------------------------------------------------------------

## Assumptions

 - The input data ends when an empty line is informed.
 - The system is case sensitive.
 - Reserved words and the pattern of the queries informed in the input data example must be respected.
 
------------------------------------------------------------------------------------------------------------

### Some examples of input/expected output

These examples were implemented as unit tests.
 - This can be verified in the test code.

Also, it is possible build the jar file and run the application in the command line.
 - The jar file can be executed in the command line using a command like this: "java -jar merchants_guide_galaxy.jar".
 - See screenshots: merchants_guide_galaxy_jar_test.PNG and merchants_guide_galaxy_jar_test_2.PNG

```
=== Test Input 1 ===

glob is I
prok is V
pish is X
tegj is L
glob glob Silver is 34 Credits
glob prok Gold is 57800 Credits
pish pish Iron is 3910 Credits
how much is pish tegj glob glob ?
how many Credits is glob prok Silver ?
how many Credits is glob prok Gold ?
how many Credits is glob prok Iron ?
how much wood could a woodchuck chuck if a woodchuck could chuck wood ?

 
=== Test Output 1 ===

pish tegj glob glob is 42
glob prok Silver is 68 Credits
glob prok Gold is 57800 Credits
glob prok Iron is 782 Credits
I have no idea what you are talking about

------------------------------------------------------------------------------
=== Test Input 2 ===

Fus is X
Roh is I
Dah is V
Fus Roh Dah DragonShout is 14 Credits
how much is Fus Roh Dah ?
how many Credits is Fus Roh Dah DragonShout ?
Dragon Shouts are an ancient form of magic prominently used in Skyrim


=== Test Output 2 ===

Fus Roh Dah is 14
Fus Roh Dah DragonShout is 14 Credits
I have no idea what you are talking about
```

