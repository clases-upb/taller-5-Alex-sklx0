/*
 * This source file was generated by the Gradle 'init' task
 */
package taller5;

import java.text.DecimalFormat;

public class App {

    public static void main(String[] args) {

        try {
            System.out.println(adivinador_numero(9999));
            System.out.println(Simular_ventas());
            System.out.println(Calcular_empaque(500));
            System.out.println(Jugar_21(5));
        } catch (Exception e) {
            // TODO: handle exception
        }
    }


    /*
    
        1.	Desarrolle un algoritmo e impleméntelo en Java que: le pida al usuario un número entero positivo 
        entre 1000 y 9999. En un ciclo genere números de manera aleatoria y cuente los intentos que hizo antes 
        de hallar el número exactamente.
     */
    public static int adivinador_numero(int num) {
        try {
            final int min = 1000, max = 9999, const_suma = 1;
            int adivinador = 0, contador = 0;
            if (num < min || num > max) {
                return -1;
            }
            do {
                adivinador = (int) Math.round(Math.random() * (max - min) + min + const_suma);
                contador++;
            } while (adivinador != num);
            return contador;

        } catch (Exception e) {
            return -1;
        }

    }

    /* 
     
        2.	Se requiere una función en java que simule las ventas de tres años para un almacén. Para cada año, deberá generar 
        un aleatorio para cada mes hasta completar los 12 meses. La función se llamará Simular_ventas, y debe retornar un String 
        al final que muestre las ventas de cada año, así:
        
            Año 1
            Ventas Mes 1: $##.###.###
            :
            Ventas Mes 12: $##.###.###
            Total ventas Año 1:  $##.###.###
            
            Año 2
            Ventas Mes 1: $##.###.###
            :
            Ventas Mes 12: $##.###.###
            Total ventas Año 2: $##.###.###
            
            Año 3
            Ventas Mes 1: $##.###.###
            :
            Ventas Mes 12: $##.###.###

            Total ventas Año 3: $##.###.###
            
            Investigue sobre la clase DecimalFormat para mostrar bien la salida. 
            import java.text.DecimalFormat;
            DecimalFormat form_pesos = new DecimalFormat("$#,###.00");*/
    public static String Simular_ventas() {
        try {
            final int total_meses = 12, total_anos = 3, const_rango = 100000000;
            DecimalFormat form_pesos = new DecimalFormat("$#,###.00");
            int mes = 0, contador_mes = 0, total_ventas_num = 0, ano = 0;
            for (int anos = 0; anos < total_anos; anos++) {
                ano++;
                System.out.println("Año " + (ano));
                for (int meses = 0; meses < total_meses; meses++) {
                    mes = (int) (Math.random() * (const_rango));
                    total_ventas_num += mes;
                    contador_mes++;
                    System.out.println("Ventas Mes " + contador_mes + ":" + form_pesos.format(mes));

                }
                System.out.println("total ventas año " + ano + " : " + form_pesos.format(total_ventas_num));

            }

            return "";
        } catch (Exception e) {
            return "Hubo un error inesperado" + e.toString();
        }
    }

    /*  
     
        3.	En una fábrica se tiene el siguiente patrón de empaque: En una estiba(o pallet) caben 16  cajas y en cada caja, 
        caben 30 bombillas. Desarrolle una función que se llame: Calcular_empaque que: reciba como argumento la cantidad de 
        bombillas que se deben empacar y a partir de allí: calcule cuántas cajas necesita, cuántas estibas o pallets necesita. 
        Luego escriba lo siguiente: 

        Para ### bombillas, se necesitan ## cajas y ## pallets. Se quedan ### bombillas sin empacar. Se empacará así:

        Pallet 1 --> Caja1, Caja2……,Caja16
        Pallet2 -->  Caja17, Caja18…..Caja 32
        .
        Pallet n -- > Caja m, caja m+1…..
        
        La función retornará un texto, con la información anterior. Pruebe la función llamándola desde el programa principal: solicite al usuario el número de bombillas e invoque la función para imprimir en el main, los resultados
     */
    public static String Calcular_empaque(int bombillas_para_empacar) {
        try {
            final int cajasXestibas = 16, bombillasXcajas = 30, bombillasXestibas = 480, constante = 1;
            int contador_cajas = 0, contadors_estibas = 0, txt_sobrantes = 0, bombillas_sobrantes = 0, estibas_necesarias = (int) Math.ceil(bombillas_para_empacar / bombillasXestibas), cajas_necesarias = (int) Math.ceil(estibas_necesarias * cajasXestibas);

            String txt_estibas = "", txt_cajas = "", txt_final = "";

            if (bombillas_para_empacar <= 0) {
                return "No ingrese numeros negativos o cero";
            } else {

                if (estibas_necesarias < constante) {
                    estibas_necesarias = constante;
                }
                if (cajas_necesarias <= 0) {
                    cajas_necesarias = constante;
                }

                for (int itera = 0; itera < estibas_necesarias; itera++) {

                    contadors_estibas++;
                    txt_cajas = "";
                    for (int itera2 = 0; itera2 < cajasXestibas; itera2++) {
                        contador_cajas++;

                        if (contador_cajas % cajasXestibas == 0) {
                            txt_cajas += "Caja " + contador_cajas + "\n";
                        } else {
                            txt_cajas += "Caja " + contador_cajas + " , ";
                        }
                    }
                    txt_estibas += "Pallet " + contadors_estibas + " ---> " + txt_cajas;

                }
                bombillas_sobrantes = (bombillas_para_empacar - (cajas_necesarias * bombillasXcajas));

                if (bombillas_sobrantes > 0) {
                    txt_sobrantes = bombillas_sobrantes;
                } else {
                    txt_sobrantes = 0;

                }

                txt_final = "Para " + bombillas_para_empacar + " bombillas, se necesitan " + contador_cajas + " cajas y " + contadors_estibas + " pallets. Se quedan " + txt_sobrantes + " bombillas sin empacar. Se empacará así: \n";
                return txt_final + txt_estibas;

            }
        } catch (Exception e) {
            return "Hubo un error inesperado " + e.toString();
        }
    }


    /* 
    

        4.	En un juego, cada jugador tiene 3 intentos para sacar cartas de una baraja. Las cartas van numeradas entre 1 y 10. 
        Una función Jugar_21, deberá simular el juego para una cantidad de usuarios que enviará el usuario desde el main entre 1 y 6.

        Para cada uno de los jugadores, el programa le calculará 3 cartas al azar y al final imprimirá el juego para cada jugador basado en las siguientes reglas: 
        
        Si saca 21 exactos: juego perfecto
        Si saca más de 21: se pasó
        Si saca menos de 21: faltaron puntos

        La función deberá imprimir los puntos de cada jugador junto con la regla anterior, como muestra el ejemplo:

        Jugador X, puntos 21 -- > juego perfecto
        Jugador Y, puntos 26 -- > se pasó
        .
        .


     */
    public static String Jugar_21(int cant_usu) {
        try {
            final int perfecto = 21, min_usu = 1, max_usu = 6, min_carta = 1, max_carta = 10, cant_intentos = 3, constante = 1;
            int num_carta = 0, orden_usu = 0;
            String txt_ganar = "", txt_caso = "";

            if (cant_usu < min_usu || cant_usu > max_usu) {
                return "Solo hay espacio  entre 1 y 6 jugadores";
            }

            for (int jugador = 0; jugador < cant_usu; jugador++) {
                num_carta = 0;
                txt_caso = "";

                for (int intento = 0; intento < cant_intentos; intento++) {
                    num_carta += (int) Math.round(Math.random() * (max_carta - min_carta) + min_carta + constante);
                }
                if (num_carta == perfecto) {
                    txt_caso = "juego perfecto"; 
                }else if (num_carta > perfecto) {
                    txt_caso = "se pasó"; 
                }else if (num_carta < perfecto) {
                    txt_caso = "faltaron puntos";
                }

                orden_usu++;
                txt_ganar += "Jugador " + orden_usu + " , puntos " + num_carta + " --> " + txt_caso + "\n";
            }
            return txt_ganar;
        } catch (Exception e) {
            return "Hubo un error inesperado " + e.toString();

        }

    }

}

