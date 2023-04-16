package Project;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.util.random.*;


public class TicTacToe implements ActionListener {
	
	JFrame frame;
	Random random;
	JPanel title_panel;
	JPanel button_panel;
	JLabel textfield;
	JButton[] buttons = new JButton[9];
	JButton resetButton;
	boolean player1_turn;
	
	TicTacToe() {
		frame = new JFrame();
		frame.setSize(600,650);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		frame.setResizable(true);
		//frame.getContentPane().setBackground(new Color(255, 255, 153));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textfield = new JLabel();
		textfield.setBackground(new Color(255, 255, 204));
		textfield.setForeground(new Color(255, 204, 204));
		textfield.setFont(new Font("Ink.free",Font.BOLD,55));
		textfield.setText("TicTacToe");
		textfield.setHorizontalTextPosition(JLabel.CENTER);
		textfield.setVerticalTextPosition(JLabel.CENTER);
		textfield.setOpaque(true);
		
		title_panel = new JPanel();
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,25);
		
		
		button_panel = new JPanel();
		button_panel.setLayout(new GridLayout(3,3));
		//button_panel.setBackground(Color.ORANGE);
		
		resetButton = new JButton();
		title_panel.add(resetButton, BorderLayout.EAST);
		resetButton.setText("Reset");
		resetButton.setForeground(new Color(255, 255, 204));
		resetButton.setLayout(null);
		resetButton.setFont(new Font("SansSerif",Font.BOLD,40));
		resetButton.setBackground(new Color(255, 204, 204));
		resetButton.addActionListener(this);
		resetButton.setFocusable(false);
		
		
		for(int i = 0;i < 9;i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("Sansserif",Font.BOLD,120));
			buttons[i].setBackground(new Color(255, 229, 204));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		title_panel.add(textfield);
		frame.add(title_panel, BorderLayout.NORTH );
		frame.add(button_panel);
		
	    firstTurn();
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0;i < 9;i++) {
			if(e.getSource() == buttons[i]) {  // check which button was clicked
				if(player1_turn) {
					if(buttons[i].getText() == "") {  // if the clicked button is empty
						buttons[i].setForeground(new Color(255, 204, 153));  // set the text color of the button to X
						buttons[i].setText("X");   // set the text of the button to X
						player1_turn = false;  //computer's turn
						textfield.setText("O turn");  // change the label to show it's computer's turn
						check();    // check if anyone has won
					}
				}
			
				else {    //computer's turn
					boolean foundEmptyButton = false;
				    while (!foundEmptyButton) {    // keep looking for an empty button
				       int rand = (int) (Math.random() * 9);
				       if (buttons[rand].getText().equals("")) {   // if an empty button is found
				          buttons[rand].setForeground(new Color(255, 153, 153)); // color of "O"
				          buttons[rand].setText("O");
				          player1_turn = true;
				          textfield.setText("X turn");
				          check();
				          foundEmptyButton = true;
				    }
				}
				
		}	}	}
		for(int i = 0;i < 9;i++) {
			if(e.getSource() == resetButton) {
		  		   for (i = 0; i < 9; i++) {
				        buttons[i].setText("");
				        buttons[i].setBackground(new Color(255, 229, 204));
				      // textfield.setText("NEW GAME");
				        buttons[i].setEnabled(true);}
				   firstTurn(); }
		}
		}
	
	
	public void firstTurn() {
			try {
		    	Thread.sleep(2000);
			}catch(InterruptedException e) {
				e.printStackTrace();	
			}
		
	if((int)(Math.random()*2) == 0) {
			player1_turn = true;
			textfield.setText("X turn");
			textfield.setHorizontalAlignment(JLabel.CENTER);
		}
		
	else {
			player1_turn = false;
			textfield.setText("O turn");
			textfield.setHorizontalAlignment(JLabel.CENTER);
		}
	}
		
	public void check() {
			
			//verif pt X
			
			if( (buttons[0].getText() == "X") && 
				(buttons[1].getText() == "X") && 
				(buttons[2].getText() == "X")) {
				    xWins(0,1,2);
			}
			
			if( (buttons[3].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[5].getText() == "X")) {
				    xWins(3,4,5);
			}
			
			if( (buttons[6].getText() == "X") &&
				(buttons[7].getText() == "X") &&
				(buttons[8].getText() == "X")) {
					 xWins(6,7,8);
			}
			
			if( (buttons[0].getText() == "X") &&
				(buttons[3].getText() == "X") &&
				(buttons[6].getText() == "X")) {
					 xWins(0,3,6);
				}
			
			if( (buttons[1].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[7].getText() == "X")) {
					xWins(1,4,7);
				}
			
			if( (buttons[2].getText() == "X") &&
				(buttons[5].getText() == "X") &&
				(buttons[8].getText() == "X")) {
					xWins(2,5,8);
				}
			
			if( (buttons[0].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[8].getText() == "X")) {
			        xWins(0,4,8);
				}
			
			if( (buttons[2].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[6].getText() == "X")) {
					xWins(2,4,6);
				}
			
			//verif pt O
			
			if( (buttons[0].getText() == "O") && 
				(buttons[1].getText() == "O") && 
				(buttons[2].getText() == "O")) {
					    oWins(0,1,2);
				}
				
			if( (buttons[3].getText() == "O") &&
				(buttons[4].getText() == "O") &&
				(buttons[5].getText() == "O")) {
					    oWins(3,4,5);
				}
				
			if( (buttons[6].getText() == "O") &&
				(buttons[7].getText() == "O") &&
				(buttons[8].getText() == "O")) {
						 oWins(6,7,8);
				}
				
			if( (buttons[0].getText() == "O") &&
				(buttons[3].getText() == "O") &&
				(buttons[6].getText() == "O")) {
						 oWins(0,3,6);
					}
				
			if( (buttons[1].getText() == "O") &&
				(buttons[4].getText() == "O") &&
				(buttons[7].getText() == "O")) {
						oWins(1,4,7);
					}
				
			if( (buttons[2].getText() == "O") &&
				(buttons[5].getText() == "O") &&
				(buttons[8].getText() == "O")) {
						oWins(2,5,8);
					}
				
			if( (buttons[0].getText() == "O") &&
				(buttons[4].getText() == "O") &&
				(buttons[8].getText() == "O")) {
				        oWins(0,4,8);
					}
				
			if( (buttons[2].getText() == "O") &&
				(buttons[4].getText() == "O") &&
				(buttons[6].getText() == "O")) {
						oWins(2,4,6);
					}
			
				
				//check for draw
				
			boolean draw = true;
			for(int i = 0;i < 9;i++) {
				if(buttons[i].getText() == "") {
					draw = false;
					break;
					}
				}
				
				if(draw) {
					draw();
				}
				
		}
		
	public void xWins(int a, int b, int c) {
			
			buttons[a].setBackground(new Color(204, 255, 153));
			buttons[b].setBackground(new Color(204, 255, 153));
			buttons[c].setBackground(new Color(204, 255, 153));
			
			for(int i = 0;i < 9;i++) {
				buttons[i].setEnabled(false);
			}
			
			textfield.setFont(new Font("Sanserif",Font.BOLD,50));
			textfield.setText("X WINS");
			textfield.setHorizontalAlignment(JLabel.CENTER);
		}
		
	public void oWins(int a, int b, int c) {
			
			buttons[a].setBackground(new Color(204, 255, 153));
			buttons[b].setBackground(new Color(204, 255, 153));
			buttons[c].setBackground(new Color(204, 255, 153));
			
			for(int i = 0;i < 9;i++) {
				buttons[i].setEnabled(false);
			}
			
			textfield.setText("O WINS");
			textfield.setHorizontalAlignment(JLabel.CENTER);
		}
		
	public void draw() {
			
			textfield.setText("IT'S A DRAW");
			for(int i = 0;i < 9;i++) {
				buttons[i].setEnabled(false);
			}
		}
		
		
}
		
		
		

