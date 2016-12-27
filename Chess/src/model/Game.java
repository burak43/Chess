package model;

public class Game {

	/* input iki tane string berk burak al return olarak game objesi dön
	 * Game g = new Game("burak", "berk");
	 * bundan sonraki her method game objesinden çağırılacak, gameobjesi.ilgilimethod şeklinde */
	public Game(String player1, String player2) {
		
	}

	/* method input yok, output bir tane array arrayin her elemanı ise üçlü array (2 boyutlu string array)
	 * [["bishop", "a", "2"], ["pawn", "h", "8"], ["bishop", "a", "2"]]
	 * (string olarak taşın tipi, string olarak char pos, string olarak int pos)
	 * String[][] piecesPos = g.getPiecesPositions(); */
	public String[][] getPiecesPositions() {
		
		String[][] go = new String[32][3];
		
		return go;
		
	}
	
	/* method input yok, output 3 olasılık int olarak
	 * (player 1 kazandı -> 1 / player 2 kazandı -> 2 / oyun devam ediyor -> 0)
	 * int result = g.getStatus(); */
	public int getStatus() {
		
		int stat = 0;
		
		return stat;
		
	}
	
	/* method input char ve int ('A', 2) eğer o pozisyonda bir taş varsa, o pozisyondaki taşın tipini bulup, o taşın gidebileceği pozisyonları 2d string array olarak dönecek
	 * arraydaki her eleman ikili olacak, string olarak char pos ve string olarak int pos
	 * [["h", "8"], ["b", "4"], ["c", "6"]]
	 * input olarak aldığı pozisyonda taş yoksa boş array dönecek
	 * String[][] possible = g.getPossible('A', 2); */
	public String[][] getPossible(char cp, int ip) {
		
		String[][] go = new String[64][2];
		
		return go;
		
	}

	/* method 4 input char int char int ('A', 2, 'A', 4), eğer a2 deki taşı a4 e götürebiliyorsa götürüp true dönecek; götüremiyorsa false dönecek
	 * boolean gone = g.move('A', 2, 'A', 4); */
	public boolean move(char cp1, int ip1, char cp2, int ip2) {
		
		boolean gone = false;
		
		return gone;
		
	}
	
}
