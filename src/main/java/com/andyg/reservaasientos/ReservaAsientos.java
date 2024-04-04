package com.andyg.reservaasientos;

import java.util.Scanner;

public class ReservaAsientos {

    public static void main(String[] args) {
        
        //Declaracion de variables
        char asientos [][] = new char [10][10];
        boolean bandera = false;
        int fila=0, asiento=0;
        Scanner teclado = new Scanner(System.in);
        String respuesta, asientosDisponibles;
       
        //Cargamos matriz
        for(int f=0; f<asientos.length; f++){
            for(int c=0; c<asientos.length; c++){
                asientos[f][c] = 'L';
            }
        }
        
        System.out.println("---------------------------------");
        System.out.println("Bienvenido al sistema de reservas");
        System.out.println("---------------------------------\n");
        
        
        //Reserva de asientos
        while(bandera!=true){
            
            
            //Visualizacion de mapa
            System.out.println("¿Desea ver los asientos disponibles? "
                    + "Si(S) - No(otra letra)");
            asientosDisponibles = teclado.next();
            if (asientosDisponibles.equalsIgnoreCase("S")){
                dibujarMapa(asientos);
            }
            
            //reserva
            boolean estaOk=false;
            while(estaOk!=true){
                System.out.println("Ingrese fila y asiento a reservar");
                System.out.println("Fila (entre 0 y 9): ");
                fila = teclado.nextInt();
                System.out.println("Asienta (entre 0 y 9): ");
                asiento = teclado.nextInt();
                
                if (fila<=9 && fila<=0){
                    if (asiento<=9 && asiento>=0){
                        estaOk = true;
                    }
                    else {
                        System.out.println("El numero de asiento no es valido");
                    }
                }
                else {
                    System.out.println("El nuemro de fila no es valido");
                }
            }
            
            if (asientos[fila][asiento] == 'L'){
                
                asientos[fila][asiento] = 'X';
                System.out.println("El asiento fue reservado correctamente.");
                
                
                
            }
            else {
                System.out.println("El asiento se encuantra reservado. Elija otro.");
            }
            
            System.out.println("¿Deseas finalizar la reserva? Si(S) - No(otra letra)");
            respuesta = teclado.next();
            
            if (respuesta.equalsIgnoreCase("S")){
                bandera = true;
            }
           
        }
        
    }
    
    static void dibujarMapa (char asientos[][]){
        for(int f=0; f<10; f++){
            System.out.print("Fila " + f + "\n");
            for(int c=0; c<10; c++){
                System.out.print(c +"[" + asientos[f][c] + "]");
            }
            System.out.print("\n");
        }
    }
    
}
 