package com.dam.libreriadam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    // pasar a mayusculas un String eliminando o no espacios
    public static String toUpperCase(String texto, boolean espacios) {
        if (texto == null) return null;
        return espacios ? texto.trim().toUpperCase() : texto.toUpperCase();
    }

    // pasar a minusculas un String eliminando o no espacios
    public static String toLowerCase(String texto, boolean espacios) {
        if (texto == null) return null;
        return espacios ? texto.trim().toLowerCase() : texto.toLowerCase();
    }

    // contar el número de palabras iguales en un String
    public static int countOccurrences(String texto, String palabra) {
        if (texto == null || palabra == null || palabra.isEmpty()) return 0;
        String regex = "\\b" + Pattern.quote(palabra) + "\\b";
        Matcher matcher = Pattern.compile(regex, Pattern.CASE_INSENSITIVE).matcher(texto);
        int counter = 0;
        while (matcher.find()) counter++;
        return counter;
    }

    // extraer numeros de un String y devolverlos en una lista
    public static List<String> extractNumbers(String texto) {
        if (texto == null) return Collections.emptyList();
        List<String> numeros = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\d+(\\.\\d+)?").matcher(texto);
        while (matcher.find()) numeros.add(matcher.group());
        return numeros;
    }

    // generar un String aleatorio de longitud especificada
    public static String generateRandomString(int longitud, boolean usarLetras, boolean usarNumeros, boolean usarSimbolos) {
        if (longitud <= 0 || (!usarLetras && !usarNumeros && !usarSimbolos)) return "";

        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String numeros = "0123456789";
        String simbolos = "!@#$%^&*()_+-=[]{}|;:,.<>?";

        String chars = (usarLetras ? letras : "") + (usarNumeros ? numeros : "") + (usarSimbolos ? simbolos : "");
        StringBuilder resultado = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < longitud; i++) {
            resultado.append(chars.charAt(random.nextInt(chars.length())));
        }

        return resultado.toString();
    }

    // convertir un String a formato CamelCase
    public static String toCamelCase(String texto) {
        if (texto == null || texto.isEmpty()) return texto;
        String[] palabras = texto.split("\\s+");
        StringBuilder resultado = new StringBuilder();

        for (String palabra : palabras) {
            resultado.append(Character.toUpperCase(palabra.charAt(0))).append(palabra.substring(1).toLowerCase());
        }

        return resultado.toString();
    }

    public static String toLowerCamelCase(String texto) {
        if (texto == null || texto.isEmpty()) return texto;
        String[] palabras = texto.toLowerCase().split("\\s+");
        StringBuilder resultado = new StringBuilder(palabras[0]);

        for (int i=1; i<palabras.length; i++) {
            resultado.append(Character.toUpperCase(palabras[i].charAt(0))).append(palabras[i].substring(1).toLowerCase());
        }

        return resultado.toString();
    }

    // convertir un String a formato SnakeCase
    public static String toSnakeCase(String texto) {
        if (texto == null || texto.isEmpty()) return texto;
        return texto.toLowerCase().replaceAll("\\s+", "_");
    }

    // abreviar un String a una longitud máxima y añadir "..." al final
    public static String abbreviate(String texto, int maxLongitud) {
        if (texto == null || maxLongitud <= 0) return "";
        return texto.length() > maxLongitud ? texto.substring(0, maxLongitud) + "..." : texto;
    }

    // String al reves
    public static String reverse(String texto) {
        return new StringBuilder(texto).reverse().toString();
    }

    // comprobar si un String es un número
    public static boolean isNumeric(String texto) {
        return texto != null && texto.matches("\\d+");
    }

    // comprobar si es palindromo
    public static boolean isPalindrome(String texto) {
        if (texto == null) return false;
        String cleanText = texto.replaceAll("\\s+", "").toLowerCase();
        return cleanText.equals(reverse(cleanText));
    }

    // capitalizar primera letra de un String
    public static String capitalize(String texto) {
        if (texto == null || texto.isEmpty()) return texto;
        return texto.substring(0, 1).toUpperCase() + texto.substring(1).toLowerCase();
    }

    // contar el número de palabras en un String
    public static int countWords(String texto) {
        if (texto == null || texto.trim().isEmpty()) return 0;
        return texto.trim().split("\\s+").length;
    }

    // Reemplazar vocales por "!"
    public static String replaceVowel(String palabra) {
        return palabra.replaceAll("[aeiouAEIOU]","!");
    }
}
