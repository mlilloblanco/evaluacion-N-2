package ejec;

import electrodomesticos.*;

/**
 * El programa genera un array del objeto Electrodomestico de largo 10, en el
 * cual se hace ingreso de 10 distintos electrodomesticos o sus clases hija
 * (lavadora y television) se calcula el precio final de cada producto
 * individualmente y luego se suman los totales por cada clase y se muestran por
 * pantalla.
 * 
 * @author Manuel Lillo Blanco
 * @version 1.0
 * @since 2020-02-27
 *
 */
public class Ejecutable {

	public static void main(String[] args) {

		Electrodomestico[] electrodomesticos = new Electrodomestico[10];
		int sumaLavadora = 0;
		int sumaTelevision = 0;
		int sumaElectrodomesticos = 0;

		// decidi agregarlo individualmente para darle uso a cada constructor de las
		// clases Electrodomestico, Television y Lavadora
		electrodomesticos[0] = new Electrodomestico();
		electrodomesticos[1] = new Electrodomestico(100, 60);
		electrodomesticos[2] = new Electrodomestico(75, "Verde", 'T', 30);
		electrodomesticos[3] = new Lavadora();
		electrodomesticos[4] = new Lavadora(125, 15);
		electrodomesticos[5] = new Lavadora(31);
		electrodomesticos[6] = new Television();
		electrodomesticos[7] = new Television(150, 90);
		electrodomesticos[8] = new Television(20, false);
		electrodomesticos[9] = new Television(40, true);

		for (int i = 0; i < electrodomesticos.length; i++) {
			sumaElectrodomesticos += electrodomesticos[i].precioFinal();

			if (electrodomesticos[i] instanceof Lavadora) {
				System.out.println(
						"el precio de la lavadora en la posicion " + i + " es: " + electrodomesticos[i].precioFinal());
				sumaLavadora += electrodomesticos[i].precioFinal();
			} else if (electrodomesticos[i] instanceof Television) {
				sumaTelevision += electrodomesticos[i].precioFinal();
				System.out.println(
						"el precio del televisor en la posicion " + i + " es: " + electrodomesticos[i].precioFinal());
			} else {
				System.out.println("el precio del electrodomestico en la posicion " + i + " es: "
						+ electrodomesticos[i].precioFinal());
			}

		}

		System.out.println("\n" + "El precio total de los electrodomesticos es: " + sumaElectrodomesticos);
		System.out.println("El precio total de las lavadoras es: " + sumaLavadora);
		System.out.println("El precio total de los televisores es: " + sumaTelevision);
	}

}
