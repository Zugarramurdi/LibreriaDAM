package com.dam.libreriadam;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    // Leer un archivo y devolver su contenido como String
    public static String readFile(String ruta) throws IOException {
        return new String(Files.readAllBytes(Paths.get(ruta)));
    }

    // Leer un archivo y devolver su contenido como una lista de líneas
    public static List<String> readFileLines(String ruta) throws IOException {
        return Files.readAllLines(Paths.get(ruta));
    }

    // Escribir un String en un archivo, con opción de anexar o sobrescribir (True = anexar | False = sobrescribir)
    public static void writeToFile(String ruta, String contenido, boolean anexo) throws IOException {
        try (FileWriter writer = new FileWriter(ruta, anexo)) {
            writer.write(contenido);
            writer.write(System.lineSeparator()); // Nueva línea al final
        }
    }

    // Eliminar un archivo
    public static boolean deleteFile(String ruta) throws IOException {
        return Files.deleteIfExists(Paths.get(ruta));
    }

    // Verificar si un archivo existe
    public static boolean fileExists(String ruta) {
        return Files.exists(Paths.get(ruta));
    }

    // Obtener tamaño de un archivo en KB
    public static long getFileSize(String ruta) throws IOException {
        return Files.size(Paths.get(ruta)) / 1024;
    }

    // Obtener lista de archivos en un directorio
    public static List<String> listFilesInDirectory(String rutaDirectorio) {
        File dir = new File(rutaDirectorio);
        List<String> fileNames = new ArrayList<>();

        if (dir.exists() && dir.isDirectory()) {
            for (File file : dir.listFiles()) {
                fileNames.add(file.getName());
            }
        }
        return fileNames;
    }

    // Crear un directorio
    public static boolean createDirectory(String rutaDirectorio) throws IOException {
        return Files.createDirectories(Paths.get(rutaDirectorio)) != null;
    }

    // Copiar un archivo
    public static boolean copyFile(String rutaFuente, String rutaDestino) throws IOException {
        Files.copy(Paths.get(rutaFuente), Paths.get(rutaDestino));
        return true;
    }

    public static boolean moveFile(String rutaFuente, String rutaDestino) throws IOException {
        Files.move(Paths.get(rutaFuente), Paths.get(rutaDestino));
        return true;
    }

    // Renombrar un archivo
    public static boolean renameFile(String rutaNombreActual, String rutaNombreDestino) {
        File oldFile = new File(rutaNombreActual);
        File newFile = new File(rutaNombreDestino);
        return oldFile.renameTo(newFile);
    }

    // Borra el contenido de un archivo
    public static void clearFile(String ruta) throws IOException {
        new FileWriter(ruta, false).close();  // Sobreescribe con nada
    }

    // Muestra el contenido de un directorio y sus subdirectorios
    static void printContent(String ruta) {
        try {
            File directorio = new File(ruta);
            File[] ficheros = directorio.listFiles();
            for (File f : ficheros) {
                System.out.println(f.getName());
                if (f.isDirectory()) {
                    System.out.println("\n"+f.getAbsolutePath());
                    printContent(f.getAbsolutePath());
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}
