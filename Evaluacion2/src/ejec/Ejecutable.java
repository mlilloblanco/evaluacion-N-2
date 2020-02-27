package ejec;

import electrodomesticos.*;

public class Ejecutable {

    public static void main(String[] args) {
	// TODO Auto-generated method stub

	Electrodomestico[] electrodomesticos = new Electrodomestico[10];
	int sumaLavadora = 0;
	int sumaTelevision = 0;
	int sumaElectrodomesticos = 0;

	electrodomesticos[0] = new Electrodomestico();
	electrodomesticos[1] = new Electrodomestico(100000, 60);
	electrodomesticos[2] = new Electrodomestico(100000, "Verde", 'T', 30);
	electrodomesticos[3] = new Lavadora();
	electrodomesticos[4] = new Lavadora(100000, 15);
	electrodomesticos[5] = new Lavadora(31);
	electrodomesticos[6] = new Television();
	electrodomesticos[7] = new Television(100000, 90);
	electrodomesticos[8] = new Television(20, false);
	electrodomesticos[9] = new Television(40, true);

	for (int i = 0; i < electrodomesticos.length; i++) {
	    sumaElectrodomesticos += electrodomesticos[i].precioFinal();
	    
	    if (electrodomesticos[i] instanceof Lavadora) {
		System.out.println("el precio de la lavadora es: " + electrodomesticos[i].precioFinal());
		sumaLavadora += electrodomesticos[i].precioFinal(); 
	    } else if (electrodomesticos[i] instanceof Television) {
		sumaTelevision += electrodomesticos[i].precioFinal(); 
		System.out.println("el precio del televisor es: " + electrodomesticos[i].precioFinal());
	    } else {
		System.out.println("el precio del electrodomestico es: " + electrodomesticos[i].precioFinal());
	    }

	}
	//dgdfgdgdfgdfgdf
	System.out.println("El precio total de los electrodomesticos es: " + sumaElectrodomesticos);
	System.out.println("El precio total de las lavadoras es: " + sumaLavadora);
	System.out.println("El precio total de los televisores es: " + sumaTelevision);
    }

}
