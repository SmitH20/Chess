import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicTreeUI.SelectionModelPropertyChangeHandler;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JTextPane;
import java.awt.SystemColor;

import javax.imageio.ImageIO;
import javax.swing.DropMode;
import javax.swing.Icon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChessBoard {
	public JPanel panel = new JPanel(new BorderLayout(3, 3));
	public JToolBar tools = new JToolBar();
	public JButton[][] chessBoardSquares = new JButton[8][8];
	public String cols = "ABCDEFGH";
	public JFrame frame = new JFrame();
	private Image[][] chessPieceImages = new Image[2][6];
	JPanel chessBoard;
	private JLabel message = new JLabel("Ready");
	private final JLabel lblNewLabel_1 = new JLabel("1");
	private final JLabel lblNewLabel_2 = new JLabel("2");
	private final JLabel label = new JLabel("3");
	private final JLabel label_1 = new JLabel("4");
	private final JLabel label_2 = new JLabel("5");
	private final JLabel label_3 = new JLabel("6");
	private final JLabel label_4 = new JLabel("7");
	private final JLabel label_5 = new JLabel("8");
	private final int QUEEN = 0, KING = 1, BISHOP = 2, KNIGHT = 3, ROOK = 4, PAWN = 5;
	private int startinRow[] = { ROOK, KNIGHT, BISHOP, KING, QUEEN, BISHOP, KNIGHT, ROOK };
	private int BLACK = 0, WHITE = 1;
	private final JButton btnNewButton = new JButton("New button");

	public ChessBoard() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setBounds(15, 10, 800, 700);
		frame.setVisible(true);
		frame.getContentPane().add(panel);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.getContentPane().add(tools, BorderLayout.PAGE_START);
		tools.addSeparator();
		JButton bt1 = new JButton("New");
		bt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				message.setText("Play!");
				for (int i = 0; i < startinRow.length; i++) {
					chessBoardSquares[i][0].setIcon(new ImageIcon(chessPieceImages[BLACK][startinRow[i]]));
				}
				for (int i = 0; i < startinRow.length; i++) {
					chessBoardSquares[i][1].setIcon(new ImageIcon(chessPieceImages[BLACK][PAWN]));
				}
				for (int i = 0; i < startinRow.length; i++) {
					chessBoardSquares[i][6].setIcon(new ImageIcon(chessPieceImages[WHITE][PAWN]));
				}
				for (int i = 0; i < startinRow.length; i++) {
					chessBoardSquares[i][7].setIcon(new ImageIcon(chessPieceImages[WHITE][startinRow[i]]));
				}

			}
		});
		tools.add(bt1);

		tools.addSeparator();
		tools.add(message);
		chessBoard = new JPanel();
		chessBoard.setBorder(new LineBorder(Color.BLACK));
		panel.add(chessBoard);
		chessBoard.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/chessboard.jpg")).getImage();
		img = img.getScaledInstance(560, 560, Image.SCALE_DEFAULT);

		lblNewLabel.setBounds(220, 65, 560, 560);

		chessBoard.add(lblNewLabel);
		tools.setFloatable(false);
		lblNewLabel.setVisible(true);
		lblNewLabel.setIcon(new ImageIcon(img));

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				JButton but = new JButton("");
				chessBoard.add(but);
				but.setBounds(220 + (i * 70), 65 + (j * 70), 70, 70);

				if ((j % 2 == 1 && i % 2 == 1)
						// ) {
						|| (j % 2 == 0 && i % 2 == 0)) {
					but.setBackground(Color.WHITE);
				} else {
					but.setBackground(Color.BLACK);
				}

				chessBoardSquares[i][j] = but;

			}
		}

		chessBoardSquares[1][0].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				chessBoardSquares[0][2].setBackground(Color.ORANGE);
				
				chessBoardSquares[0][2].addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						chessBoardSquares[0][2].setIcon(new ImageIcon(chessPieceImages[0][3]));
						chessBoardSquares[1][0].setIcon(null);
						chessBoardSquares[0][2].setBackground(Color.WHITE);
						

					}
				});

			}
		});

		BufferedImage bi = null;
		try {
			bi = ImageIO.read(this.getClass().getResourceAsStream("/chess_figures.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int ii = 0; ii < 2; ii++) {
			for (int jj = 0; jj < 6; jj++) {
				chessPieceImages[ii][jj] = bi.getSubimage(jj * 170, ii * 170, 170, 170).getScaledInstance(64, 64,
						Image.SCALE_DEFAULT);

			}
		}

		// chessBoardSquares[0][0].setEnabled(true);
		// chessBoardSquares[0][0].setVisible(true);

		/*
		 * Image img2 = new
		 * ImageIcon(this.getClass().getResource("/rook.png")).getImage(); img2
		 * = img2.getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		 * chessBoardSquares[0][0].setIcon(new ImageIcon(img2));
		 */

		JLabel labelAbcd = new JLabel("Ahoj");
		labelAbcd.setHorizontalAlignment(SwingConstants.CENTER);
		chessBoard.add(labelAbcd);
		labelAbcd.setBounds(220, 10, 560, 50);
		labelAbcd.setText(cols.replace("", "                     ").trim());
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		chessBoard.add(lblNewLabel_1);
		lblNewLabel_1.setBounds(140, 91, 46, 14);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);

		chessBoard.add(lblNewLabel_2);
		lblNewLabel_2.setBounds(140, 161, 46, 14);
		label.setHorizontalAlignment(SwingConstants.CENTER);

		chessBoard.add(label);
		label.setBounds(140, 231, 46, 14);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);

		chessBoard.add(label_1);
		label_1.setBounds(140, 297, 46, 14);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);

		chessBoard.add(label_2);
		label_2.setBounds(140, 370, 46, 14);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);

		chessBoard.add(label_3);
		label_3.setBounds(140, 443, 46, 14);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);

		chessBoard.add(label_4);
		label_4.setBounds(140, 511, 46, 14);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);

		chessBoard.add(label_5);
		label_5.setBounds(140, 583, 46, 14);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		btnNewButton.setBounds(35, 65, 89, 23);

		chessBoard.add(btnNewButton);

	}
}
