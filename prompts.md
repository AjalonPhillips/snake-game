Prompt 1:
I'm building a Snake game in Java using Swing. Create a single file called SnakeGame.java. It should have a main method that opens a JFrame window that is 600 by 600 pixels and titled Snake. Inside the frame, add a JPanel subclass called GamePanel. Do not add any game logic yet. Just get the window to open correctly.

Prompt 2:
 Now extend SnakeGame.java. Keep it as one file. Add a dark background grid and draw a starting snake that is three segments long near the center of the board, facing right. Each cell should be a 30x30 pixel square. Draw the snake in green and the background in dark gray. Do not add movement yet.

 Prompt 3
 Make the snake move automatically using a Swing timer that ticks every 150 milliseconds. Add arrow key controls so the player can steer, but don't allow the snake to reverse direction. For now, have the snake wrap around the edges instead of dying. Make sure the panel can receive keyboard input.

 Prompt 4
 Add a food pellet that spawns at a random empty cell. When the snake eats it, grow by one segment and spawn new food. Add collision detection: hitting a wall or the snake's own body should end the game, stop movement, and show a "Game Over" message with the final score. Display the current score in the top-left corner during play. When the game is over, let the player press R to reset everything and play again.

 Prompt 5 
 I encountered that the keyPressed section starting on line 113, does not work properly. When I press R to reset the game it doesn't do anything. In addition could you add W(up), A(left), S(down),D(right) in addition the controls that already exist?

 Prompt 6 
 I still cant seem to get the game started. It loads up on the game over screen prompting to press R to restart but it doesn't do anything.

 Promt 7 
 I got it to work. The only bug im seeing consistently is to start a new game. I was able to consistly repeat the bug. The new game only starts when R and W,S,or down arrow is pressed simultaneously. How can this be fixed? To be clear, when losing a game the R key does correctly clear the screen back the beginning it just doesnt start a new game by itself.

 Promt 8 
 I cant seem to get the game to start now. Unlike before it does not start wehn pressing any keys or combination of keys

 Prompt 9 
 Okay now R restarts the game but it instantly ends and to prevent that, I have to quickly press a directional key to move at the same time the game starts. There also seems to be a bug where if conflicting directional keys are pressed in quick succession the game ends almost like theres a collision happening

 Prompt 10
 the game still instantly ends after pressing R. it loads up like it wants to start but instantly ends

 Prompt 11
Could you add a start button when the program first runs then after each game after pressing R for the rest it brings you back to the screen with a start button?