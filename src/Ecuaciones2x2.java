//Santiago Yeomans
//A01251000

public class Ecuaciones2x2 {
	
	public static void main(String[] args) {
		
		// * ax1 + bx2 = c
		// * dx1 + ex2 = f
		//Encontrar valor de x1 y x2
		
		//Solucion usando método de Cramer
		
		//Variables
		float a = 1,
			  b = 1,
		 	  c = 1,
		 	  d = 1,
		 	  e = 1,
		 	  f = 1;
		
		//Determinantes
		float DS = (a * e) - (b * d),
			  DX = (c * e) - (b * f),
			  DY = (a * f) - (c * d);
		
		float x1 = DX/DS;
		float x2 = DY/DS;

		System.out.println("El valor de x1 es: " + x1);
		System.out.println("El valor de x2 es: " + x2);	
	}
}
