import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jgKGD_2K25.*; 

public class App {
    public static void main(String[] args) {
        jgVistaSistema vista = new jgVistaSistema();
        jgAntCiberDron dron = new jgAntCiberDron();
        
        String nombre = "Garcia Jhostin";
        String cedula = "1750750018";
        String csvFile = "GarciaJhostin.csv";
        String line = "";
        String cvsSplitBy = ";";

        vista.jgMostrarCabecera(nombre, cedula);

        List<String[]> rows = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Leer cabecera del CSV y saltarla
            if ((line = br.readLine()) != null) {
                // Cabecera
            }

            while ((line = br.readLine()) != null) {
                String[] datos = line.split(cvsSplitBy);
                // Asegurar que el array tenga el tamaño correcto rellenando con vacíos si es necesario
                // El CSV tiene 7 columnas: Geoposición;Lunes;Martes;Miércoles;Jueves;Viernes;Tipo Arsenal
                // split puede ignorar los vacíos al final, así que hay que tener cuidado.
                // Mejor usar un parser más robusto o manejarlo manualmente.
                // Aquí asumiremos que el formato es consistente con lo generado.
                
                String geoposicion = datos.length > 0 ? datos[0] : "";
                String lunes = datos.length > 1 ? datos[1] : "";
                String martes = datos.length > 2 ? datos[2] : "";
                String miercoles = datos.length > 3 ? datos[3] : "";
                String jueves = datos.length > 4 ? datos[4] : "";
                String viernes = datos.length > 5 ? datos[5] : "";
                String tipoArsenal = datos.length > 6 ? datos[6] : "";

                rows.add(new String[]{geoposicion, tipoArsenal});

                vista.jgMostrarBarraCarga();
                vista.jgMostrarResultado(geoposicion, lunes, martes, miercoles, jueves, viernes, tipoArsenal);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nCOORDENADAS UCRANIANAS A DESTRUIR:");
        System.out.println("Geoposición | Tipo Arsenal | Acción");
        
        for (String[] row : rows) {
            String geo = row[0];
            String arsenal = row[1];
            boolean destruir = dron.jgBuscar(arsenal);
            if (destruir) {
                System.out.printf("%-11s | %-12s | %s%n", geo, arsenal, destruir);
            }
        }

        // Demostración de Hormiga
        System.out.println("\n[+] SIMULACIÓN HORMIGA:");
        jgHRastreadora hormiga = new jgHRastreadora();
        jgHerbivoro alimentoVivo = new jgHerbivoro();
        // jgCarnivoro alimentoMuere = new jgCarnivoro(); // No creado, pero conceptualmente
        System.out.println("Hormiga: " + hormiga.jgToString());
        System.out.println("Alimento: " + alimentoVivo.jgToString());
        boolean vive = hormiga.jgComer(alimentoVivo);
        System.out.println("¿La hormiga vive al comer? " + (vive ? "VIVE" : "MUERE"));
    }
}

