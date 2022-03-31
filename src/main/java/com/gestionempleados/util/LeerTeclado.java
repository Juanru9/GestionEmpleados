package com.gestionempleados.util;

import java.util.Scanner;

public class LeerTeclado {

	@SuppressWarnings("resource") // Eliminar Warnings
	public static String leerString() {
		
		Scanner teclado = new Scanner(System.in);
		return teclado.nextLine();
	}
	
	public static String leerString(String msg) throws Exception {
		System.out.println(msg);
		// Tiramos pa el metodo de arriba pa leer
		return leerString();
	}
	
	@SuppressWarnings("resource") // Eliminar Warnings
	public static Byte leerByte() {
			
			Scanner teclado = new Scanner(System.in);
			return teclado.nextByte();
		}
		
		public static Byte leerByte(String msg) throws Exception {
			System.out.println(msg);
			// Tiramos pa el metodo de arriba pa leer
			return leerByte();
		}
		
		@SuppressWarnings("resource") // Eliminar Warnings
		public static int leerInt() {
				
				Scanner teclado = new Scanner(System.in);
				return teclado.nextInt();
			}
			
			public static int leerInt(String msg) throws Exception {
				System.out.println(msg);
				// Tiramos pa el metodo de arriba pa leer
				return leerInt();
			}
			
			@SuppressWarnings("resource") // Eliminar Warnings
			public static double leerDouble() {
					
					Scanner teclado = new Scanner(System.in);
					return teclado.nextDouble();
				}
				
				public static double leerDouble(String msg) throws Exception {
					System.out.println(msg);
					// Tiramos pa el metodo de arriba pa leer
					return leerDouble();
				}
}
