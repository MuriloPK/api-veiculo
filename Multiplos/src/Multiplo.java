public class Multiplo {
	private int x;

	public void calcMult(int x) {
		x = this.x - 1;
		int soma = 0;

		while (x > 0) {
			if (x % 3 == 0 || x % 5 == 0) {
				soma += x;
			}
			x--;
		}
		System.out.println("Total da Soma dos Multiplos de 3 ou 5 " + soma);
	}

	public Multiplo(int x) {
		super();
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
}