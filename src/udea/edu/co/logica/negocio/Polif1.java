package udea.edu.co.logica.negocio;

public class Polif1{
	
	public int[] sumarPolVf1(int[] pol1, int[] pol2){
		
		int grado = pol1[0]; // Asigna el grado del primer polinomio.
		int pos = 0;
		
		if(pol2[0] > grado){ // Se define cual de los dos grados de los polinomios es mayor.
			grado = pol2[0];
		}
		
		int[] resul = new int[grado+2]; // Se define el tamaño del vector con el grado mayor+2.
		
		resul[0] = grado;
		
		for(int i = grado;i>=0;i--){
			pos++;
			
			int posPol1 = pol1[0]-i+1;
			int posPol2 = pol2[0]-i+1;
			
			if(posPol1 > 0 && posPol2 > 0){ // Si los exponentes son iguales.
				resul[pos] = pol1[posPol1]+pol2[posPol2];
			}else if(posPol1 > 0 && posPol2 <= 0){ // Si el exponente del primer polinomio es mayor al segundo
				resul[pos] = pol1[posPol1];
			}else if(posPol2 > 0 && posPol1 <= 0){ // Si el exponente del segundo es mayor al primero.
				resul[pos] = pol2[posPol2];
			}
		}
		
		return resul;
	}
	
	
	public int[] multiplicarPolVf1(int[] pol1, int[] pol2){
		
		int tamaR = pol1[0]+pol2[0]+2;
		int[] resul = new int[tamaR];
		int tamPol1 = pol1[0]+2;
		int tamPol2 = pol2[0]+2;
		int ta,Pol2 = pol2[0]+2;
		int expPol1 = pol1[0];
		int expPol2, expResul, pos;
		int i = 1, j;
		
		for(int k = 0;k<=tamaR;k++){ // Asigana a todos los espacios del vector ceros;
			resul[k] = 0;
		}
		
		resul[0] = tamaR-2; // Grado del polinomio.
		
		while(i <= tamPol1){
			j = 1;
			expPol2 = pol2[0];
			
			while(j <= tamPol2){
				expResul = expPol1 + expPol2;
				pos = resul[0] - expResul+1;
				j++;
				expPol2--;
			}
			
			i++;
			expPol1--;
			
		}
		
		return resul;
	}
	
	

}
