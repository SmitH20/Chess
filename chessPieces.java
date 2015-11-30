import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ChessPieces {
	
	private ChessTable chessT;
	
	 Image[][] chessPiecesImage = new Image[2][6];
	
	private final int QUEEN = 0, KING = 1, BISHOP = 2, KNIGHT = 3, ROOK = 4, PAWN = 5;
	
	private int startinRow[] = { ROOK, KNIGHT, BISHOP, KING, QUEEN, BISHOP, KNIGHT, ROOK };
	
	private int BLACK = 0, WHITE = 1;
	
	Game g;

	public ChessPieces(ChessTable chessT) {
		this.chessT = chessT;
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(
					this.getClass().getResourceAsStream("/chess_figures.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++) {
				
				chessPiecesImage[i][j] = bi.getSubimage(j * 170, i * 170, 170, 170).getScaledInstance(70, 70, Image.SCALE_DEFAULT);

			}
		}
		
	}
	
	public void starGame(){
		for (int i = 0; i < startinRow.length; i++) {
			this.chessT.chessSquares[i][0].setIcon(new ImageIcon(chessPiecesImage[BLACK][startinRow[i]]));
		}
		for (int i = 0; i < startinRow.length; i++) {
			this.chessT.chessSquares[i][1].setIcon(new ImageIcon(chessPiecesImage[BLACK][PAWN]));
		}
		for (int i = 0; i < startinRow.length; i++) {
			this.chessT.chessSquares[i][6].setIcon(new ImageIcon(chessPiecesImage[WHITE][PAWN]));
		}
		for (int i = 0; i < startinRow.length; i++) {
			this.chessT.chessSquares[i][7].setIcon(new ImageIcon(chessPiecesImage[WHITE][startinRow[i]]));
		}
		this.g= new Game(this);
	}
	
	

}
