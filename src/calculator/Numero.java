package calculator;
class Numero {
	private Cifra testa = null;
	private boolean segno = true;
	public Numero () {
		testa = new Cifra();
	}
	public Numero (String s) {
		if (s.charAt(0)=='-')
			this.segno=false;
		s=s.replaceAll("[^0-9]","");
		s=noZeri(s);
		this.testa = new Cifra (s);
	}
	public Cifra getTesta() {
		return this.testa;
	}
	public void setTesta(Cifra cif) {
		this.testa=cif;
	}
	public boolean getSegno() {
		return segno;
	}
	public void setSegno (boolean s) {
		this.segno =s;
	}
	public static void cancellaZeri (Cifra n) {
		if (n.getNext()!=null) {
			cancellaZeri(n.getNext());
			if (n.getNext().getInfo()==0 && n.getNext().getNext()==null)
				n.setNext(null);
		}
	}
	public String noZeri (String s) {
		if (s.charAt(0)=='0' && s.length()>1)
			s=noZeri (s.substring(1));
		return s;
	}
}