//Sophia Xia
//APCS2 pd1
//HW12 -- +3R|\/|1|\|4|_  1|_|_|\|3$$
//2018-03-01

Q0: What do you make of the multiple class definitions in a single .java file?
Boardasaurus is not public or private. Due to the lack of public in the declaration of class Boardasaurus I believe that Boardasaurus can only be accessed within Demo.java. I don't see this file compliling due to having multiple class definitions.


Q1: How are the command line arguments processed?
There is a try and catch block to take care of any exceptions. For instance, an exception will be thrown if the command line arguments are negative.


Q2: What happens if no command line arguments are given?
If no command line arguments are given, the default board size and delay time will be used.


Q3: What is the nature/purpose of the recursion? Is it necessary for the animation?
The recursion is used to place numbers at random places on the board. The number it places corresponds to the number of moves done.


Q4: What do you expect to see when you run it?
I expect there to be a compiling error due to the multiple class definitions.


Q5: What does ANSI stand for? (You are permitted some intertubes searching hereâ€¦). What is it good for?
ANSI stands for American National Standards Institute. This organization is good due to the fact that it creates one standard for programming languages and protocols. This is beneficial because if people use different versions of a language or they use compilers that differently, it becomes difficult to share work and collaborate.


Q7: How did your expectations compare to your observations?
The file did compile which was the opposite of my expectations. Once I ran the code, there was an outline of negative ones and zeros in the middle. Then the numbers began to randomly appear on the board and the new number placed was one larger than the previous number.


Q8: How might you adapt this framework to animate a probing for a Knightâ€™s Tour?
Instead of adding the numbers in randomly, they have to be added according to an L shape which results in 8 possible moves. I think that animating the entire process of finding the answer to the Knight's tour requires too much computing power and is unnecessary. Therefore it would make sense to only animate the correct answer. In QueenBoard.java, the answer was printed once it was found. I believe the same applies to KnightsTour. The method go should be modified to test all the possible cases and animate the correct one. The current code animates the moves as they occur so there needs to be a way to store the correct answer and animate that.

Knights Algo:

Use a Recursive Brute Force Approach

Use a For loop and go through every single space on a quarter of the Chess board for starting points.
Put in a counter for moves, Knight's move order will be marked down with this
Then add the Knight and do a recursive call for every single move the
Knight can make.
Make sure to remove the Knight after each recursive call to make room
for the next one.
If the number of moves are made is equal to the total number of spaces
then print the solution and return true.
If no more moves can be made and less than the number of spaces of moves
have been made, return false.