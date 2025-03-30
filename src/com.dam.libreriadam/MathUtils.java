package com.dam.libreriadam;

import java.util.Random;

public class MathUtils {

    // Redondeo de un número a un número específico de decimales
    public static double round(double valor, int decimales) {
        double scale = Math.pow(10, decimales);
        return Math.round(valor * scale) / scale;
    }

    // Verificar si un numero es primo
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // Obtener el maximo común divisor (MCD) de dos números (Gretaest Common Divisor)
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // Obtener el mínimo común múltiplo (MCM) de dos números (Least Common Multiple)
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    // Generar un número aleatorio en un rango específico
    public static int randomInRange(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    // Tirar dado de n lados
    public static int rollDice(int lados) {
        return randomInRange(1, lados);
    }

    // Obtener el área y volumen de un cubo
    public static int[] getSize(int ancho,int alto,int profundo) {
        int area = 2*(ancho*alto+ancho*profundo+alto*profundo);
        int volume = ancho*alto*profundo;
        return new int[] {area,volume};
    }

    // Obetener 2 numeros que su suma sea igual al objetivo
    public static int[] findTwoSum(int[] nums, int objetivo) {
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if(nums[j] == objetivo - nums[i]){
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {};
    }
}
