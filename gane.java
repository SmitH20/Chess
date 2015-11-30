import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.stream.Collector.Characteristics;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Game implements MouseListener {
	private ChessPieces cp;
	private ChessTable ct;

	public Game(ChessTable ct) {
		this.ct = ct;

	}

	public Game(ChessPieces cp) {
		this.cp = cp;

	}

	public static void main(String[] args) {

		ChessTable ct = new ChessTable();
		ChessPieces cp = new ChessPieces(ct);
		ct.paintComponent();
		
		ct.chessSquares[1][0].addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				ct.chessSquares[0][2].setIcon(new ImageIcon(cp.chessPiecesImage[0][3]));
				ct.chessSquares[1][0].setIcon(null);
				
			}
		});
				

	}

	@Override
	public void mouseClicked(MouseEvent e) {
	
			
				
				
	

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
