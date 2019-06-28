//¿Ãª€ ¡÷ºÆ3
public class Board {
	static public enum CAT {
		BOARD, HERO, WALL
	};

	protected CAT c;
	protected char ch;

	Board() {
		c = CAT.BOARD;
		ch = '.';
	}

	public char getCh() {
		return ch;
	}

	public CAT getCAT() {
		return c;
	}
}
