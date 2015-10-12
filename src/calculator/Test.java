package calculator;
import butler.Lettore;
class Test {
	static Numero numero0 = new Numero("0");
	static Numero numero1 = new Numero("003600");
	static Numero numero2 = new Numero("0010");
	static Numero numero3 = new Numero("0021");
	static Numero numero4 = new Numero("002000");
	static Numero numero5 = new Numero("0012345");
	static Numero numero6 = new Numero("00123456");
	static Numero numero7 = new Numero("001234567");
	static Numero numero8 = new Numero("0012345678");
	static Numero numero9 = new Numero("00123456789");
	static Numero numero10 = new Numero("0012345678901234567812345678916513489713561786135713280973810956347805617893275381465017583965348716501349758139581306503495901234567890123456789012345678902143735215643798561758913475893478046356348753578342706432050342564736583279657345632785602367620738573458203626523487035278133222222222222222222222222222222222222229877777777777777777777777777777777777777777611111111111111111111111177777777777777777777777777777777777777222222222222222222222222228888888888888888888888888860325353647869235643259800");
	static Numero numero11 = new Numero("001234567801123463281975259243281057125647931461345136578356137895613560158347885789137581346510345718937583456039417589368318590734815787034175048936581437509348751389570139857143980573148957349153895777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777406666666666666666666666516460213857430795691873568134672316495817654310564301574319621398750217512094674012356347112735126195617648");
	static Numero numero12 = new Numero("10901");
	static Numero numero13 = new Numero("99");
	static Numero numero14 = new Numero("8090");
	static Numero numero15 = new Numero("1010");
	static Numero numero16 = new Numero("103");
	static Numero numero17 = new Numero("10");
	static Numero numero18 = new Numero("1111");



	public static void main (String [] args) {
		System.out.println("Numero0: " + stampaN(numero0));
		System.out.println("\nNumero1: " + stampaN(numero1));
		System.out.println("\nNumero2: " + stampaN(numero2));
		System.out.println("\nNumero3: " + stampaN(numero3));
		System.out.println("\nNumero4: " + stampaN(numero4));
		System.out.println("\nNumero5: " + stampaN(numero5));
		System.out.println("\nNumero6: " + stampaN(numero6));
		System.out.println("\nNumero7: " + stampaN(numero7));
		System.out.println("\nNumero8: " + stampaN(numero8));
		System.out.println("\nNumero9: " + stampaN(numero9));
		System.out.println("\nNumero10: " + stampaN(numero10));
		System.out.println();

		 System.out.println("SOMMA");
		 System.out.println(stampaN(Operazioni.sommaN(numero2,numero3)));
		 System.out.println("SOTTRAZIONE");
		 System.out.println(stampaN(Operazioni.sottrazioneN(numero2,numero3)));
		 System.out.println("PRODOTTO");
		 System.out.println(stampaN(Operazioni.prodottoN(numero2,numero3)));
		 System.out.println("QUOZIENTE");
		 System.out.println(stampaN(Operazioni.quozienteN(numero2,numero3)));
		 System.out.println("FATTORIALE");
		 System.out.println(stampaN(Operazioni.fattorialeN(numero1)));


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