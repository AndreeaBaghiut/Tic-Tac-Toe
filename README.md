# Tic-Tac-Toe
This is a Java program that creates a Tic Tac Toe game with a graphical user interface. The game uses a JFrame to display a grid of 3x3 JButtons that represent the Tic Tac Toe board. The game starts with a random player to make the first move (X or O) and the user can click on a JButton to make a move. The computer (opponent) will automatically make its move and the game continues until one player wins or a draw is reached.

The program is implemented as a class named "TicTacToe" that implements the ActionListener interface to listen for button clicks. The constructor creates the user interface and initializes the game state. The firstTurn method randomly selects the player to make the first move. The actionPerformed method handles button clicks and alternates between the user and computer turns. Finally, the check method checks if the game is over and whether one player has won. If the game is over, the program displays a message that shows the winner or if it's a draw.

The code also includes some graphical elements such as colors and fonts to improve the user interface. The reset button allows the user to restart the game after it is finished.


![tic-tac-toe](https://user-images.githubusercontent.com/128622173/232533426-7f47069a-f902-48dd-92df-645289d21720.PNG)
