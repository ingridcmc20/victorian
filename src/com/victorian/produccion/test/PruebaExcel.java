package com.victorian.produccion.test;

public class PruebaExcel {

	public static void main(String[] args) throws Exception {
		
		
		String archivoOrigen = "C:/Users/JHON/Documents/copia.xlsx";
		 System.out.println("Constructor: pkg, sheetRowCallbackHandler, sheetCallback");
		 //List<String> lista = LeerExcel2.leer(archivoOrigen);
		//System.out.println("Al final: "+ lista.size());
		//LeerExcelXlsx.leerExcelBanco(archivoOrigen);
         //System.out.println("Imprimiendo la lista:");
		String cadena="051353778";
		  
		 String [] arreglo = cadena.split("\\|");
		 for(int i = 0; i < arreglo.length; i++){
			 System.out.println(arreglo[i]);
			 System.out.println(arreglo[i].charAt(0));
		}
		
	}

}
