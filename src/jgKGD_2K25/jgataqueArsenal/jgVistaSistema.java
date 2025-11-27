package jgKGD_2K25.jgataqueArsenal;
public class jgVistaSistema {
    public void jgMostrarBarraCarga() {
        // Loading para "caso contrario" (1 y 8): - +
        try {
            System.out.print("Loading ");
            for (int i = 0; i <= 100; i += 10) {
                String charLoading = (i / 10) % 2 == 0 ? "-" : "+";
                System.out.print(charLoading);
                Thread.sleep(100); // Simula carga
            }
            System.out.println(" 100%");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void jgMostrarCabecera(String nombre, String cedula) {
        System.out.println("[+] INFORMACIÓN:");
        System.out.println("\tNombre: " + nombre);
        System.out.println("\tCédula : " + cedula);
        System.out.println();
        System.out.println("[+] COORDENADAS UCRANIANAS:");
        System.out.println("Loading | Geoposición | Lunes | Martes | Miércoles | Jueves | Viernes | Tipo Arsenal");
    }

    public void jgMostrarResultado(String coordenada, String lunes, String martes, String miercoles, String jueves, String viernes, String arsenal) {
        // Formato de tabla
        System.out.printf("100%%    | %-11s | %-5s | %-6s | %-9s | %-6s | %-7s | %s%n", 
            coordenada, 
            lunes == null ? "" : lunes, 
            martes == null ? "" : martes, 
            miercoles == null ? "" : miercoles, 
            jueves == null ? "" : jueves, 
            viernes == null ? "" : viernes, 
            arsenal);
    }
}
