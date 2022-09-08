
public class Fatorial {
	private int n;
	private int fat;
	
	public void calcFat(int numero) {
		setN(numero);
		int fat = 1;
		if(n >= 0) {
			for(int i = 1; i <= n; i++) {
				fat *= i;
			}
		} else {
			System.out.println("Digite um numero maior que zero!");
		}
		this.fat = fat;
	}

	
	public int getFat() {
		return fat;
	}


	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	

}
