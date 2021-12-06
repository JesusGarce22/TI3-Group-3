package model;

public class Challenge {

	private int answer;

	public Challenge(int answer) {
		
		this.answer = answer;
	}
	
	public Challenge() {}

	public String operators() {

		int r = (int) (Math.random() * 4);

		int num1 = (int) (Math.random() * 100);
		int num2 = (int) (Math.random() * 100);

		String problema = "";

		if (r == 0){

			answer = num1 + num2;
			problema = num1 + "+" + num2;

		}
		if (r == 1) {

			answer = num1 - num2;
			problema = num1 + "-" + num2;

		} 
		if (r == 2) {

			answer = num1 * num2;
			problema = num1 + "*" + num2;

		} 
		if (r == 3) {

			int divisor = (int) (Math.random() * 100);
			int cociente = (int) (Math.random() * 100);
			int dividendo = divisor * cociente;

			problema = dividendo + "/" + divisor;
			answer = cociente;

		}
		
		return problema;
		

	}

	public int ramdonBotton() {

		int botton = (int) (Math.random() * 4);
		return botton;
	}

	public int getAnswer() {
		return answer;
	}

}
