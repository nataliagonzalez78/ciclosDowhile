package org.example;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        Scanner teclado=new Scanner(System.in);
        Random generador=new Random();

        Boolean esAdministrador;
        String respuestaPerfil;
        Double tarifaEnergia;
        Integer opcion;
        final String contraseña="admin123*";
        String contraseñaUsuario;
        Integer contadorDePicos=0;
        Integer contadorEnergia=0;
        double  totalApagar;




        System.out.println("Bienvenido");
        System.out.println("Eres administrador: ");
        respuestaPerfil=teclado.nextLine();

        //PROCESO PARA EL LOGIN
        if (respuestaPerfil.equalsIgnoreCase("si")) {
            //admin y me van a pedir la contraseña
            System.out.println("Digita tu contraseña");
            contraseñaUsuario = teclado.nextLine();

            //COMPARAMOS LA CONTRASEÑA QUE ESCRIBIERON CON LA CONSTANTE ALMACENADA
            if (contraseñaUsuario.equals(contraseña)) {

                //FELICITACIONES USTED ES ADMINISTRADOR
                System.out.println("usted es un admin");
                //USTED ES ADMIN PUEDO ACTUALIZAR LA TARIFA DEENERGIA
                System.out.print("Ingresa el valor de kwh: ");
                tarifaEnergia = teclado.nextDouble();
                System.out.println("la tarifa de energia quedo en: $" + tarifaEnergia);
                //GENERANDO DATOS PARA UNA EMPRESA
                //generar un ciclo que de 30 vueltas
                Integer numeroVueltas=0;  //contador

                do{
                    numeroVueltas=numeroVueltas+1;
                    Integer numeroGenerador= generador.nextInt(401);
                    contadorEnergia=contadorEnergia+numeroGenerador;
                    if (numeroGenerador>300){
                        System.out.println("pico detectado");
                        contadorDePicos=contadorDePicos +1;

                    }else {
                        System.out.println("operando normalmente");
                    }
                }while (numeroVueltas<30);
                System.out.println(numeroVueltas);
                System.out.println(contadorDePicos);

                //MENU
                System.out.println("1. ver tarifa");
                System.out.println("2. mostrar consumo promedio");
                System.out.println("3. mostrar consumo picos");
                System.out.println("4.  mostrar factura");
                System.out.println("5. salir");

                //REPITIENDO EL MENU
                do {
                    System.out.println("Apreciado cliente, digita una opcion: ");
                    opcion= teclado.nextInt();
                    switch (opcion){
                        case 1:
                            System.out.println("La tarifa kwh es: "+tarifaEnergia);
                            break;
                        case 2:
                            System.out.println("El consumo total fue: ");
                            double promedioConsumo=contadorEnergia/30.0;
                            System.out.println("el consumo promedio es:"+promedioConsumo);
                            break;

                        case 3:
                            System.out.println("La cantidad de picos fue: "+contadorDePicos);
                            break;
                        case 4:
                            System.out.println("El resumen de tu factura es ");
                            double totalApagar=contadorEnergia*tarifaEnergia;
                            System.out.println("...."+totalApagar);
                            break;
                        default:
                            System.out.println();
                    }
                }while (opcion!=5);


            } else {
                System.out.println("Usted es un hacker...");
            }
            //empresa

        }else {
            System.out.println("usted es una empresa");
        }
    }
}