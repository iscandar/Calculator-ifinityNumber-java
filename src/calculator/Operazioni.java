package calculator;
class Operazioni {
//gestori delle operazioni sui numeri--------------------------------------------------------------------------------
	public static Numero Somma_Differenza(Numero n1,Numero n2,boolean segno) {
		Numero n3 = new Numero ("0");
		if(n1.getSegno() && n2.getSegno() && segno)
			n3=sommaN(n1,n2);
		else if(!n1.getSegno() && !n2.getSegno()&& segno ){
			n3=sommaN(n1,n2);
			n3.setSegno(n2.getSegno());
		}else if (n1.getSegno()&& !n2.getSegno()&& segno)
			n3=sottrazioneN(n1,n2);
		else if (!n1.getSegno() && n2.getSegno() && segno){
				if (n1.getTesta() == minore(n1.getTesta(),n2.getTesta())) {
					n3=sottrazioneN(n1,n2);
					n3.setSegno(n2.getSegno());
				}else if (n2.getTesta() == minore(n1.getTesta(),n2.getTesta())) {
					n3=sottrazioneN(n1,n2);
					n3.setSegno(n1.getSegno());}
		}else if (n1.getSegno() && n2.getSegno() && !segno)
			n3=sottrazioneN(n1,n2);
		else if (!n1.getSegno() && n2.getSegno() && !segno){
			n3=sommaN(n1,n2);
			n3.setSegno(n1.getSegno());
		}else if(n1.getSegno() && !n2.getSegno() && !segno){
			n2.setSegno(true);
			n3=sommaN(n1,n2);
		}else if(!n1.getSegno() && n2.getSegno() && !segno){
			n3=sommaN(n1,n2);
			n3.setSegno(n1.getSegno());
		}
		if(n3.getSegno())
			System.out.print("+");
		else
			System.out.print("-");
		return n3;
	}
	//colleziona i dati da due numeri, chiama la somma tra le due cifre raccolte e stocca il risulatato in un terzo numero.
	public static Numero sommaN (Numero n1,Numero n2) {
		Numero n3 = new Numero ();
		n3.setTesta (somma (n1.getTesta(),n2.getTesta()));
		return n3;
	}
	public static Numero sottrazioneN(Numero n1,Numero n2){
		    Numero risultato = new Numero();
		    Cifra n3=copy( n1.getTesta());
		    Cifra n4=copy( n2.getTesta());
		    if(minore(n1.getTesta(),n2.getTesta())==n1.getTesta()) {
		        risultato=sottrazioneN(n2,n1);
			} else {
		        risultato.setTesta( sottrazione(  n3,n4 ) );
			}
		    return risultato;
    }
	public static Numero prodottoN (Numero n1,Numero n2) {
		Numero n3 = new Numero ();
		n3.setTesta (prodotto (n1.getTesta(),n2.getTesta()));
		if ((!n1.getSegno() && n2.getSegno()) || (n1.getSegno() && !n2.getSegno()))
			n3.setSegno(false);
		if(n3.getSegno())
			System.out.print("+");
		else
			System.out.print("-");
		return n3;
	}
	public static Numero quozienteN (Numero n1,Numero n2 ) {
			Numero n3 = new Numero();
			n3.setTesta(quoziente(n1.getTesta(),n2.getTesta()));
			if ((!n1.getSegno() && n2.getSegno()) || (n1.getSegno() && !n2.getSegno()))
				n3.setSegno(false);
			if(n3.getSegno())
				System.out.print("+");
			else
				System.out.print("-");
			return n3;
	}
	public static Numero fattorialeN(Numero n1){
		Numero copia = new Numero();
		copia.setTesta( fattoriale( n1.getTesta()));
		return copia;
	}
	public static Numero minoreN (Numero n1, Numero n2) {
		Numero n3 = null;
		if (n1.getSegno() && !n2.getSegno())
			n3=n2;
		else if (!n1.getSegno() && n2.getSegno())
			n3=n1;
		else if (!n1.getSegno() && !n2.getSegno()) {
			if (n1.getTesta()==minore( n1.getTesta(),n2.getTesta() ))
				n3=n2;
			else if (n2.getTesta()==minore( n1.getTesta(),n2.getTesta() ))
				n3=n1;
		}
		else if (n1.getTesta()==minore( n1.getTesta(),n2.getTesta() ))
			n3=n1;
		else if (n2.getTesta()==minore( n1.getTesta(),n2.getTesta() ))
			n3=n2;
		return n3;
	}
//gestori delle operazioni sulle cifre--------------------------------------------------------------------------------------------------------------------------------------
	 //somma tra due numeri, prevede la possibilita di ricevere riferimenti non validi da parte di una delle due cifr1.
	public static Cifra somma (Cifra n1,Cifra n2) {
		Cifra n3 = new Cifra ();
		if (n1==null || n2==null) {
			if (n1==null) {
				n3=copy(n2);
			}else {
				n3=copy(n1);
			}
		}
		else {
			Cifra n4 = new Cifra ("1");
			boolean riporto = false;
			if (n1.getInfo()+n2.getInfo()<=9) {
				n3.setInfo(n1.getInfo()+n2.getInfo());
			}
			else {
				n3.setInfo((n1.getInfo()+n2.getInfo())%10);
				riporto = true;
			}
			if (n1.getNext()==null && n2.getNext()==null) {
				if (riporto) {
					n3.setNext(n4);
				}
			}
			else if (n1.getNext()==null) {
				if (riporto) {
					n3.setNext(somma(n4,n2.getNext()));
					n3.getNext().setNext(n2.getNext().getNext());
				}
				else {
					n3.setNext(n2.getNext());
				}
			}
			else if (n2.getNext()==null) {
				if (riporto) {
					n3.setNext(somma(n1.getNext(),n4));
					n3.getNext().setNext(n3.getNext().getNext());
				}
				else {
					n3.setNext(n1.getNext());
				}
			}
			else {
				n3.setNext(somma(n1.getNext(),n2.getNext()));
				if (riporto) {
					n3.setNext(somma(n3.getNext(),n4));
				}
			}
		}
		return n3;
	}
	public static Cifra sottrTotC (Cifra n1,Cifra n2) {
		Numero.cancellaZeri(n1);
		Cifra contatore = new Cifra ("0");
		if (n1==minore(n1,n2)) {}
		else {
				n1=sottrazione(n1,n2);
				contatore=sottrTotC(n1,n2);
				contatore=incremento(contatore);}
		return contatore;
	}
	public static Cifra sottrazione (Cifra n1,Cifra n2) {
		if (n1==null || n2==null) {
			if (n1==null)
				n1=n2;

		}
		else {
			Numero.cancellaZeri(n1);
			if (n2.getNext()==null) {
				if (n1.getInfo()==0 || n1.getInfo()<n2.getInfo()) {
						n1.setInfo(n1.getInfo()-n2.getInfo()+10);
						n1.setNext(sottrazione(n1.getNext(),new Cifra ("1")));
					}else {
						n1.setInfo(n1.getInfo()-n2.getInfo());
					}
			}else {
				n1.setNext(sottrazione (n1.getNext(),n2.getNext()));
				n1.setInfo(n1.getInfo()-n2.getInfo());}
			}
			Numero.cancellaZeri(n1);
			return n1;
		}
	public static Cifra prodotto (Cifra n1,Cifra n2) {
			Cifra n3 = new Cifra ("0");
			if (n2.getNext()!=null)
				n3.setNext(prodotto(n1,n2.getNext()));
			if (n3.getNext()==null) {
				n3=prodottoCif(n1,n2);
			}else{
				n3=somma(n3,prodottoCif(n1,n2));
			}
			return n3;
		}
	public static Cifra prodottoCif (Cifra n1,Cifra n2) {
			Cifra n3 = new Cifra ("0");
			int prodotto;
			if (n1.getNext()!=null)
				n3.setNext(prodottoCif(n1.getNext(),n2));
	        Cifra n4=copy(n3);
			prodotto = n1.getInfo()*n2.getInfo();
			if (prodotto>9) {
				n3=new Cifra (""+prodotto);
				Cifra supp=new Cifra("0");
				if (n3.getNext()==null)
					n3.setNext(supp);
				else
					n3.setNext(somma(n3.getNext(),supp));
				n3=somma (n4,n3);
				}
			else {
				n3=somma (n3,new Cifra (""+prodotto));
			}
			return n3;
	}
	public static Cifra quoziente (Cifra n1, Cifra n2) {
			Cifra quoziente = new Cifra("0");
			if (n1.getNext()!=null){
				quoziente.setNext(quoziente(n1.getNext(),n2));
			}
			if (n1==minore(n1,n2)) {}
			else {
				quoziente=somma(sottrTotC(n1,n2),quoziente);
			}
			Numero.cancellaZeri(quoziente);
			return quoziente;
		}
	public static Cifra fattoriale(Cifra n1){
		Cifra risultato = new Cifra("0");
		if (n1.getInfo() == 0 && n1.getNext()==null) {
			risultato.setInfo(1);
		}
		else {
			risultato =prodotto(n1,fattoriale(decremento2(n1)));
		}
		return risultato;
	}
//metodi di utilita--------------------------------------------------------------------------------------------------------------
	//decrementa una singola cifra di una unita. restituisce 0 se la cifra immessa a 0.
	public static Cifra decremento(Cifra n1) {
		Cifra n2 = copy(n1);
		if (n2.getInfo()!=0) {
			n2.setInfo(n2.getInfo()-1);
		}
		return n2;
	}
	//decrementa una catena di cifre di una unita. amplia le funzioni del metodo decremento in quanto capace di gestire i riporti.
	public static Cifra decremento2(Cifra n1) {
		Cifra n2 = copy(n1);
		Numero.cancellaZeri(n2);
		if (n2.getInfo()!=0) {
			n2.setInfo(n2.getInfo()-1);
		}
		else if (n2.getNext()!=null) {
			n2.setInfo(9);
			n2.setNext( decremento2( n2.getNext()));
		}
		else if (n2.getNext()==null) {
			n2.setInfo(0);
		}
		Numero.cancellaZeri(n2);
		return n2;
	}
	public static Cifra incremento (Cifra n1) {
			if (n1.getNext()==null) {
				if (n1.getInfo()==9) {
					n1.setInfo(0);
					n1.setNext(new Cifra ("1"));
				}else
					n1.setInfo(n1.getInfo()+1);
			}else {
				if (n1.getInfo()==9) {
					n1.setInfo(0);
					n1.setNext(incremento(n1.getNext()));
				}else
					n1.setInfo(n1.getInfo()+1);
			}
			return n1;
		}
	public static void scorri(Cifra n1) {
		n1=n1.getNext();
	}
	public static Cifra copy(Cifra n1) {
			Cifra n2 = new Cifra();
			if (n1.getNext()!=null) {
				n2.setInfo(n1.getInfo());
				n2.setNext(copy(n1.getNext()));
			}
			else if (n1.getNext()==null)
				n2.setInfo(n1.getInfo());
			return n2;
	}
	public static Cifra minore (Cifra n1,Cifra n2) {
			Cifra n3 = n1;
			Cifra n4 = n2;
			Cifra ritorno = null;
			while (n3.getNext()!=null && n4.getNext()!=null) {
				if (n3.getInfo()<n4.getInfo())
					ritorno=n1;
				else if (n3.getInfo()>n4.getInfo())
					ritorno=n2;
				n3=n3.getNext();
				n4=n4.getNext();
			}
			if (n3.getNext()==null && n4.getNext()!=null)
				ritorno=n1;
			else if (n4.getNext()==null && n3.getNext()!=null)
				ritorno=n2;
			else {
				if (n3.getInfo()<n4.getInfo())
					ritorno=n1;
				else if (n3.getInfo()>n4.getInfo())
					ritorno=n2;
			}
			return ritorno;
		}
	public static boolean equalLength(Cifra n1,Cifra n2) {
			boolean equals;
			if (n1.getNext()!= null && n2.getNext()!= null)
				equals = equalLength(n1.getNext(),n2.getNext());
			else if (n1.getNext()== null && n2.getNext()== null)
				equals = true;
			else
				equals = false;
			return equals;
		}
	public static boolean equals(Cifra n1,Cifra n2) {
			boolean equals = true;
			if (n1.getNext()!=null && n2.getNext()!=null) {
				if (!(n1.getInfo()==n2.getInfo()))
					equals=false;
				else
					equals = equals(n1.getNext(),n2.getNext());
			}
			return equals;
		}
}