/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilapc;

import java.util.Scanner;

/**
 *
 * @author David
 */
public class ALQUILAPC {
static Scanner entradaDatos = new Scanner(System.in);
    static String nom;
    static int opcion=0;
    static int equipos;
    static double domicilio;
    static int diasal;
    static int diasad;
    static double alqui;
    static String Tipo;
    static double descuentos=0;
    static double domi=0;
    static double diasd=0;
    static double total=0;
    static boolean detener=false;
    //Existe la necesidad de crear otra variable para almacenar los descuentos de una 
    //manera mas organizada y poder operarlos con exito
    static double descuentoperar=0;
     static void Ciudad(){
        
    }
     static void CalcularValores(){
       alqui=CalculoAlquiler(); 
       //Cambiamos Calcular valor de dias adicionales por el metodo calcular descuento
       descuentos=CalculoDescuento();
       diasd=CalculoAlquilerAdicionalDto();
		if(opcion==2)
			domi=CalculoDomicilio();
		else
			domi=0;
        
	total=diasd+alqui+domi-descuentoperar;
    }
    static void Fuera(){
    }
    static double CalculoAlquilerAdicional(){
        double a;
        double b;
        a=(diasad*35000*equipos);
        b=(diasad*35000*equipos);
        b= b*0.02;
    	return (a-b);
    }
    static double CalculoAlquilerAdicionalDto(){
        double x;
        //Necesitamos saber el costo del alquiler en un dia adicional 
        //de la siguiene manera:
        x=35000-(35000*0.02);
        //Hacemos el calculo que nos permite hallar el valor de los dias adicionales
        //con el descuento
        x=x*diasad*equipos;
        return x;
    }
    static double CalculoAlquiler(){
        double x;
        //Cambiar dias adicionales por dias de alquiler 
        x=(diasal*35000)*equipos;
        alqui=x;
        return x;
    }
    static double CalculoDomicilio(){
       //No es necesario volver a validar ya que si llega a este metodo
       //es porque el domicilio es fuera de la ciudad.
       //
        domi=(alqui+diasd)*0.05;
      
        return domi;
    }
    static double CalculoDescuento(){
        double x = 0;
        double a=0;
        //Es necesario tener en cuenta que si el servicio es dentro del establecimiento
        //existe un descuento del 5% del valor final
        if(opcion==3 && diasad>0){
             //Debemos realizar la resta necesaria para hallar el descuento
            a=(alqui+CalculoAlquilerAdicional())*0.05;
            x=(alqui-CalculoAlquilerAdicional())+a;
            descuentoperar=x-(alqui-CalculoAlquilerAdicional());
        }
        //Es necesario validar que los dias adicionales sean mayores a cero
        //para poder realizar la operación con exito
        if(opcion==1 && diasad>0){
         x=(alqui-CalculoAlquilerAdicional());
         
        }
        if(opcion==2 && diasad>0){
         x=(alqui-CalculoAlquilerAdicional());
         
        }
        if(opcion==3 && diasad==0){
             //Debemos realizar la resta necesaria para hallar el descuento
           x=alqui*0.05;
          descuentoperar=x;
        }
        return (x);
    }
    
    static void Encabezado(){
        //for (int i = 0; i < 100; ++i) System.out.println();
     	System.out.println("\t\t\t**************SENA PRUEBAS DE SOFTWARE 2020************");
	System.out.println("\t\t\tANALISIS Y DESARROLLO DE SISTEMAS DE INFORMACION CGMLTI\n\n");   
    }
    static void TipoServicio(){
                System.out.println("\nTipos de servicios ofrecidos");
        System.out.println("[1] Dentro de la Ciudad");
        System.out.println("[2] Fuera de la ciudad");
        System.out.println("[3] Dentro del Establecimiento");
        System.out.print("Tipo de servicio tomado por el cliente  :");
        opcion = entradaDatos.nextInt();
        if(opcion==1)
            Tipo="Dentro de la Ciudad";
        else if(opcion==2)
            Tipo="Fuera de la ciudad";
        else if(opcion==3)
            Tipo="Dentro del Establecimiento";

    }
    static void EquiposAlquiler(){
        System.out.print("Número de equipos que desea alquilar:");
        equipos = entradaDatos.nextInt();        
    }
    static void DiasAlquiler(){
        System.out.print("Número de días que desea tomar el alquiler:");
        diasal = entradaDatos.nextInt();        
    }
    static void DiasAdicionales(){
        System.out.print("Número de días adicionales que toma el alquiler:");
        diasad = entradaDatos.nextInt();        
    }
    static void DatosBasicos(){
        System.out.print("Nombre Cliente:");
        nom = entradaDatos.nextLine();
        EquiposAlquiler();
           if(equipos>=2){
         DiasAlquiler();
         DiasAdicionales();
           }else{
               System.out.println("Lo sentimos...!!!\nno podemos procesar su solicitud, El minimo de equipos a alquilar debe ser mayor o igual a dos");
               detener=true;
           }
        
        
    }
    static void MostrarDatos(){
        System.out.println("\t\t\tA L Q U I L A P C");
        System.out.println("Nombre:"+nom);
        System.out.println("Tipo de servicio:"+Tipo);
        System.out.println("Numero de Equipos:"+equipos);
        System.out.println("No. Días Iniciales:"+diasal);
        System.out.println("Valor Alquiler:"+alqui);
        System.out.println("No. Días adicionales:"+diasad);
        System.out.println("Valor días adicionales: $"+CalculoAlquilerAdicionalDto());
        System.out.println("Descuentos: $"+descuentos);
        System.out.println("Domicilio: $"+domi);
        System.out.println("Total a pagar: $"+total);
        System.out.println("Factura generada por el  S  E  N  A");
        System.out.println("Gracias por utilizar nuestros servicios...!!!");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Encabezado();
         DatosBasicos();
         if(detener==false){
          TipoServicio();
         CalcularValores();
         MostrarDatos();
         }
         
        
         
    }
    
}
