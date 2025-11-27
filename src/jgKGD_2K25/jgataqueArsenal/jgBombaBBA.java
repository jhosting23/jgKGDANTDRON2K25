package jgKGD_2K25.jgataqueArsenal;


public class jgBombaBBA {
    
    public boolean jgExplotar(String arsenal) {
        if (arsenal == null || arsenal.isEmpty()) return false;
// Refactorización: Se implementa la lógica del diagrama de estados (AFD) mediante una estructura switch-case
// para validar estrictamente las transiciones q0->q1->q2->q3 definidas en el diseño manual.
        int estadoActual = 0; // q0 es el estado inicial

        // Recorremos la cadena caracter por caracter
        for (char caracter : arsenal.toCharArray()) {
            switch (estadoActual) {
                case 0: // Estado q0 (Inicio)
                    if (caracter == 'a') {
                        estadoActual = 1;
                    } else {
                        estadoActual = -1; // qError
                    }
                    break;

                case 1: // Estado q1 
                    if (caracter == 'a') {
                        estadoActual = 1; 
                    } else if (caracter == 'b') {
                        estadoActual = 2; 
                    } else {
                        estadoActual = -1; // qError
                    }
                    break;

                case 2: // Estado q2 
                    if (caracter == 'c') {
                        estadoActual = 3; // q2 -> c -> q3
                    } else {
                        estadoActual = -1; // qError
                    }
                    break;

                case 3: // Estado q3 
                    // Una vez en q3, si viene algo más, ya no es valido 
                    estadoActual = -1; 
                    break;
                    
                default: 
                    return false;
            }
            
            if (estadoActual == -1) return false; // Si cae en error, termina
        }
        return (estadoActual == 1 || estadoActual == 3);
    }
}