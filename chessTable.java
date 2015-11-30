import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChessTable {
	/**
	 * @wbp.parser.entryPoint
	 */
	private JFrame frame = new JFrame("Chess");

	private JToolBar tools = new JToolBar();

	private JLabel label = new JLabel("hh");

	private JLabel charPos;

	private JLabel intPos;

	private ChessPieces cp;

	Player p;
	Game g;

	JButton chessSquares[][] = new JButton[8][8];

	JPanel panel = new JPanel();

	private JLabel time = new JLabel();

	public ChessTable() {
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public void paintComponent() {

		this.p = new Player(this);
		panel.add(time);
		time.setBounds(50, 250, 160, 50);
		time.setOpaque(true);
		time.setBackground(Color.WHITE);
		time.setBorder(new LineBorder(Color.BLACK));

		for (int j = 0; j < 8; j++) {
			intPos = new JLabel(String.valueOf(j + 1));
			intPos.setVisible(true);
			intPos.setBounds(280, 80 + (j * 70), 560, 50);
			panel.add(intPos);

			charPos = new JLabel(String.valueOf((char) (65 + j)));
			charPos.setVisible(true);
			charPos.setBounds(360 + (j * 70), 10, 560, 50);
			panel.add(charPos);
		}

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				JButton chessPiece = new JButton("");
				chessPiece.setBounds(325 + (i * 70), 70 + (j * 70), 70, 70);
				panel.add(chessPiece);
				if ((j % 2 == 1 && i % 2 == 1)
						// ) {
						|| (j % 2 == 0 && i % 2 == 0)) {
					chessPiece.setBackground(Color.WHITE);
				} else {
					chessPiece.setBackground(Color.BLACK);
				}
				chessSquares[i][j] = chessPiece;
			}
		}

		frame.setBounds(150, 5, 900, 700);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().add(tools, BorderLayout.PAGE_START);
		frame.getContentPane().add(panel);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		JButton startG = new JButton("Start");
		startG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cp.starGame();
				
				
			}
		});
		tools.add(startG);

		JButton exitG = new JButton("Exit game");
		exitG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int decBut = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (decBut == JOptionPane.YES_OPTION)
					System.exit(0);
				

			}
		});
		tools.add(exitG);
		label.setBounds(325, 70, 560, 560);
		label.setBorder(new LineBorder(Color.BLACK));
		panel.add(label);
		Image board = new ImageIcon("C:/Users/SmitH/workspace/Chess/Chess/img/chessboard.jpg").getImage();
		board = board.getScaledInstance(560, 560, Image.SCALE_DEFAULT);
		label.setIcon(new ImageIcon(board));

		this.cp = new ChessPieces(this);
		this.g = new Game(this);

	}
}
