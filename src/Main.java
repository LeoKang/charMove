import java.util.Scanner;

public class Main {
	static Board[][] b;
	static int curX = 0;
	static int curY = 0;
	static final int BOARD_SIZE = 5;

	public static void init() {
		System.out.println("init method...");
		b = new Board[BOARD_SIZE][];
		for (int i = 0; i < b.length; i++) {
			b[i] = new Board[BOARD_SIZE];
		}

		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				b[i][j] = new Board();
			}
		}
		b[curY][curX] = new BHero();
		b[1][1] = new BWall();
		b[1][2] = new BWall();
		b[1][3] = new BWall();
	}

	public static void print_b() {
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				System.out.print(b[i][j].getCh() + " ");
			}
			System.out.println();
		}
		System.out.println("Input number... (0 = Quit) ");
	}

	public static void swap_b(int AY, int AX, int BY, int BX) {
		Board tmp = b[BY][BX];
		b[BY][BX] = b[AY][AX];
		b[AY][AX] = tmp;
	}

	public static boolean moveAvail(int BY, int BX) {
		if (b[BY][BX].getCAT() == Board.CAT.WALL)
			return false;
		else
			return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int inp;
		init();

		do {
			System.out.println("curY : " + curY + ", curX : " + curX);
			print_b();
			inp = sc.nextInt();
			switch (inp) {
			case 2:
				if ((curY < b.length - 1) && (moveAvail(curY + 1, curX))) {
					swap_b(curY, curX, curY + 1, curX);
					curY++;
				}
				break;
			case 4:
				if ((curX > 0) && (moveAvail(curY, curX - 1))) {
					swap_b(curY, curX, curY, curX - 1);
					curX--;
				}
				break;
			case 6:
				if ((curX < b[curY].length - 1) && (moveAvail(curY, curX + 1))) {
					swap_b(curY, curX, curY, curX + 1);
					curX++;
				}
				break;
			case 8:
				if ((curY > 0) && (moveAvail(curY - 1, curX))) {
					swap_b(curY, curX, curY - 1, curX);
					curY--;
				}
				break;
			}
		} while (inp != 0);
		sc.close();
	}
}