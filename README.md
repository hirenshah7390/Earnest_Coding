BattleShipGame

This Game has mainly 5 classes
./src/java/Classes

•	Start:- To initiate Game
•	Game: To generate players and assign Game borad.
•	Board:- To generate grid and ships along with positions
•	Ship:- for ship related arrangmenets
•	Postition:- To maintain properties of grid (row,col) position (like Hit,Miss,Pending)

Functions:-

•	This game has implemented mainly an attach function and rest of the code is been surrounded to that function. 
•	The function updates player's board with users' input and prints below results

1.	Hit:- if it hits the ship
2.	Miss:- if it misses the ship
3.	AlreadTaken:- if it hits at the same location again.
4.	Win:- if it hit all the ships before maximum number of chances get over.
5.	Lose:- if it fails to hit all the ships in given number of total chances.

Test Cases (.src/Tests):- /input has all the input files which gets tested against the testing class.
Mainly used the assertion from Junit to check the outcome of user input.




