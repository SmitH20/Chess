import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Player {

	private ChessTable ct;

	private JLabel player1;

	private JLabel player2;

	private String name1;

	private String name2;

	int bb = JOptionPane.OK_OPTION;

	public Player(ChessTable ct) {
		this.ct = ct;
	

		name1 = JOptionPane.showInputDialog(null, "Enter Player 1 name [max. 18 characters]", "Player 1", 1);
		if (name1 == null) 
			System.exit(0);
		
		while (name1.isEmpty() == true) {
			name1 = JOptionPane.showInputDialog(null, "You must enter Player 1 name! [max. 18 characters]", "Player 1",
					1);

			if (name1 == null) 
				System.exit(0);
		}

		for (int i = 0; i < name1.length(); i++) {
			if (i >= 18) {
				name1 = JOptionPane.showInputDialog(null, "Name is too long! Enter Player 1 name again!", "Player 1",
						1);

			}

			while (name1.isEmpty() == true) {
				name1 = JOptionPane.showInputDialog(null, "You must enter Player 1 name! [max. 18 characters]",
						"Player 1", 1);
			}
		}

		name2 = JOptionPane.showInputDialog(null, "Enter Player 2 name [max. 18 characters]", "Player 2", 1);
		if (name2 == null)
			System.exit(0);

		while (name2.isEmpty() != false) {
			name2 = JOptionPane.showInputDialog(null, "You must enter Player 2 name! [max. 18 characters]", "Player 2",
					1);
			
			if (name2 == null)
				System.exit(0);
		}

		for (int i = 0; i < name2.length(); i++) {
			if (i >= 18) {
				name2 = JOptionPane.showInputDialog("Name is too long! Enter Player S2 name again!");
			}
			while (name2.isEmpty() != false) {
				name2 = JOptionPane.showInputDialog(null, "You must enter Player 2 name! [max. 18 characters]",
						"Player 2", 1);
				
				if (name2 == null)
					System.exit(0);
			}
		}

		while (name1.equals(name2)) {
			JOptionPane.showMessageDialog(null, "Player2's name's same as Player1's");
			name2 = JOptionPane.showInputDialog(null, "Enter Player 2 name [max. 18 characters]", "Player 2", 1);

			if (name2 == null) {
				System.exit(0);
			}

		}

		player1 = new JLabel(name1);
		player1.setBounds(60, 70, 150, 40);
		player1.setBorder(new LineBorder(Color.BLACK));
		player1.setOpaque(true);
		player1.setBackground(Color.WHITE);
		player1.setFont(new Font("", Font.BOLD, 15));
		player1.setHorizontalAlignment(SwingConstants.CENTER);
		this.ct.panel.add(player1);

		player2 = new JLabel(name2);
		player2.setBounds(60, 130, 150, 40);
		player2.setBorder(new LineBorder(Color.BLACK));
		player2.setOpaque(true);
		player2.setBackground(Color.WHITE);
		player2.setFont(new Font("", Font.BOLD, 15));
		player2.setHorizontalAlignment(SwingConstants.CENTER);
		this.ct.panel.add(player2);

	}

}

