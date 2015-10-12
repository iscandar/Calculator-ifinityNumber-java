/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author iscandar
 */
import butler.Lettore;
import org.fusesource.jansi.*;
class Calcolatrice {
	public static void main (String [] args) throws Exception {
		String s, s2;
		boolean finito = false;
		char scelta;
		while(finito == false) {
			Numero cifra1;
			Numero cifra2;
			clearScreen();
			System.out.println("====================================");
			System.out.println("|           Calcolatrice           |");
			System.out.println("====================================");
			System.out.println("| Operatori: + , - , * , / , !     |");
			System.out.println("====================================");
			System.out.println("Primo numero: ");
			s = Lettore.in.leggiString();
			cifra1 = new Numero(s);
			System.out.println("Inserire l'operatore");
			scelta = Lettore.in.leggiChar();
			switch(scelta) {
				case '+': {
					System.out.println("Secondo numero: ");
					s2 = Lettore.in.leggiString();
					cifra2 = new Numero(s2);System.out.print("Il risultato = ");
					System.out.print(stampaN(Operazioni.Somma_Differenza(cifra1,cifra2,true)));
				} break;
				case '-': {
					System.out.println("Secondo numero: ");
					s2 = Lettore.in.leggiString();
					cifra2=new Numero(s2);System.out.print("Il risultato = ");
					System.out.print(stampaN(Operazioni.Somma_Differenza(cifra1,cifra2,false)));
				} break;
				case '*': {
					System.out.println("Secondo numero: ");
					s2 = Lettore.in.leggiString();
					cifra2 = new Numero(s2);System.out.print("Il risultato = ");
					System.out.print(stampaN(Operazioni.prodottoN(cifra1,cifra2)));
				} break;
				case '/': {
					System.out.println("Secondo numero: ");
					s2 = Lettore.in.leggiString();
					cifra2 = new Numero(s2);
					System.out.print("Il risultato = ");
					System.out.print(stampaN(Operazioni.quozienteN(cifra1,cifra2)));
				} break;
				case '!': {
					System.out.println("Attendere prego");
					System.out.println("Il fattoriale e' =   "+stampaN(Operazioni.fattorialeN(cifra1)));
				} break;
				default: {
					System.out.println("Inserire un operatore corretto");
				} break;
			}
			System.out.println("\nRicominciare? [s\\n]");
			scelta = Lettore.in.leggiChar();
			if (scelta!='s')
				finito = true;
		}
	}

   public static void clearScreen() {
		String ANSI_CLS = "\u001b[2J"; // Sequenza di escape per clear screen tramite libreria jansi. ATTENZIONE: Cancella solo ciò che viene correntemente visualizzato in finestra, non ciò che è già uscito dallo schermo. Ma su Windows sembra essere l'unico modo.
		String ANSI_HOME = "\u001b[H"; // Sequenza di escape per riportare il cursore in (0,0) in jansi.
		AnsiConsole.out.print(ANSI_CLS);
		AnsiConsole.out.print(ANSI_HOME);

	}
	public static String stampaN(Numero n)  {
			return stampaAll(n.getTesta());
			}
		public static String stampaAll(Cifra numero) {
			String s = "" ;

			while(numero.getNext()!=null){

				s=numero.stampaCif()+s;
				numero=numero.getNext();
			}
			s=numero.stampaCif()+s;
			return s;
	}
}