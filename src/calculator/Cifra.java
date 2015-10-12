
package calculator;
public class Cifra {
	private int info;
	private Cifra next = null;
	public Cifra (){}
	public Cifra (String s) throws NumberFormatException {
		if (s.length()==1)
			this.info = Integer.parseInt(s);
		else {
			this.info = Integer.parseInt(s.substring(s.length()-1));
			this.next= new Cifra (s.substring(0,s.length()-1));}
	}
	public int getInfo () {
		return this.info;
	}
	public void setInfo (int num) {
		if (num>=0 && num<=9)
			this.info=num;
	}
	public Cifra getNext() {
		return this.next;
	}
	public void setNext(Cifra n) {
		this.next=n;
	}
	public String stampaCif() {
		return ""+info;
	}
}