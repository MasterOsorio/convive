package com.bit.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bit.management.catalogs.screen.MenuItemView;
import com.bit.management.catalogs.screen.MenuWrapperView;

public class ConviveUtils {

	public static final String ID_PARENT = "ID_PARENT";
	public static final String ID_CHILD = "ID_CHILD";
	public static final Integer DEFAULT_VALUE = null;
	public static final String[] UNIDADES = { "UNO", "DOS", "TRES", "CUATRO", "CINCO", "SEIS", "SIETE", "OCHO",
			"NUEVE" };
	public static final String[] DECENAS = { "DIEZ", "VEINTE", "TREINTA", "CUARENTA", "CINCUENTA", "SESENTA", "SETENTA",
			"OCHENTA", "NOVENTA" };
	public static final String[] CENTENAS = { "CIEN", "DOSCIENTOS", "TRESCIENTOS", "CUATROCIENTOS", "QUINIENTOS",
			"SEISCIENTOS", "SIETECIENTOS", "OCHOCIENTOS", "NOVECIENTOS" };

//	esta variable se llena en ConfigBeanListener
	public static List<MenuWrapperView> menus = new ArrayList<>();

	public static Map<String, Integer> findHierarchy(int idMenu) {

		Map<String, Integer> hierarchy = new HashMap<>();
		hierarchy.put(ID_PARENT, DEFAULT_VALUE);
		hierarchy.put(ID_CHILD, DEFAULT_VALUE);

		parents: for (MenuWrapperView menu : menus) {
			if (menu.getParent().getId().intValue() == idMenu) {
//				System.out.println("El id: " + menu.getParent().getId() + " es menu padre");
				hierarchy.put(ID_PARENT, menu.getParent().getId());
				break parents;
			} else {
				for (MenuItemView submenu : menu.getChildren()) {
					if (submenu.getId().intValue() == idMenu) {
//						System.out.println("El id: " + submenu.getId() + " es submenu, hijo de: " + menu.getParent().getId() );
						hierarchy.put(ID_CHILD, submenu.getId());
						hierarchy.put(ID_PARENT, menu.getParent().getId());
						break parents;
					}
				}
			}
		}

		return hierarchy;
	}

//	vesrion 1 del codigo
//	public static String numeroLetra(int numero) {
////		
//		int cociente = 0;
//		int residuo = 0;
//
//		if (numero >= 1 && numero <= 9) {
////			System.out.println(numero + " es unidad");
//			cociente = (numero / 1);
//			System.out.println(cociente);
//
//		} else if (numero >= 10 && numero <= 99) {
////			System.out.println(numero + " son decenas");
//			cociente = (numero / 10);
//			residuo = (numero % 10);
//			System.out.println(cociente);
//			if (residuo >= 1 && residuo <= 9) {
//				residuo = (residuo / 1);
//				System.out.println(residuo);
//			}
//
//		} else if (numero >= 100 && numero <= 999) {
////			System.out.println(numero + "son centenas");
//			cociente = (numero / 100);
//			residuo = (numero % 100);
//			System.out.println(cociente);
//			if (residuo >= 10 && residuo <= 99) {
//				cociente = (residuo / 10);
//				residuo = (residuo % 10);
//				System.out.println(cociente);
//			} if (residuo >= 1 && residuo <= 9) {
//				cociente = (residuo / 1);
//				System.out.println(cociente);
//			}
//
//		} else if (numero >= 1000 && numero <= 9999) {
////			System.out.println(numero + "son millares");
//			cociente = (numero / 1000);
//			residuo = (numero % 1000);
//			System.out.println(cociente);
//			if (residuo >= 100 && residuo <= 999) {
//				cociente = (residuo / 100);
//				residuo = (residuo % 100);
//				System.out.println(cociente);
//			} if (residuo >= 10 && residuo <= 99) {
//				cociente = (residuo / 10);
//				residuo = (residuo % 10);
//				System.out.println(cociente);
//			} if (residuo >= 1 && residuo <= 9) {
//				cociente = (residuo / 1);
//				System.out.println(cociente);
//			}
//
//		} else {
//			System.out.println("escribe un numero");
//		}
//		return null;
//	}
//
//	public static void main(String[] args) {
//
//		numeroLetra(7489);
//	}

	public static String numeroLetra(int numero) {

		int cociente = 0;
		int residuo = 0;
		String s = "";

		if (numero >= 100 && numero <= 999) {

//			System.out.println(numero + " son centenas");

			cociente = (numero / 100);
			residuo = (numero % 100);
			s = CENTENAS[cociente - 1];

			if (residuo != 0 && cociente == 1) {
				s = s + "TO " + numeroLetra(residuo);
			} else {
				s = s + " " + numeroLetra(residuo);
			}

			System.out.println(cociente);

		} else if (numero >= 10 && numero <= 99) {

//			System.out.println(numero + " son decenas");

			cociente = (numero / 10);
			residuo = (numero % 10);
			s = DECENAS[cociente - 1];

			if (residuo == 1 && cociente == 1) {
				s = "ONCE";
			} else if (residuo == 2 && cociente == 1) {
				s = "DOCE";
			} else if (residuo == 3 && cociente == 1) {
				s = "TRECE";
			} else if (residuo == 4 && cociente == 1) {
				s = "CATORCE";
			} else if (residuo == 5 && cociente == 1) {
				s = "QUINCE";
			} else if (residuo == 6 || residuo == 7 || residuo == 8 || residuo == 9 && cociente == 1) {
				s = "DIECI" + numeroLetra(residuo);
			} else if (residuo != 0 && cociente == 2) {
				s = "VEINTI" + numeroLetra(residuo);
			} else if (residuo != 0) {
				s = s + " Y " + numeroLetra(residuo);
			}

			System.out.println(cociente);

		} else if (numero >= 1 && numero <= 9) {

//			System.out.println(numero + " son unidades");

			cociente = (numero / 1);
			residuo = (numero % 1);
			s = UNIDADES[cociente - 1];

			System.out.println(cociente);

		} else {

			System.out.println("escribe un numero");
		}

		return s;
	}

	public static void main(String[] args) {

		System.out.println(numeroLetra(20));
	}
}
