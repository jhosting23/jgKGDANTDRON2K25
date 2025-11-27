package jgKGD_2K25;

public class jgAntCiberDron implements jgIA {
    private jgBombaBBA bomb;

    public jgAntCiberDron() {
        this.bomb = new jgBombaBBA();
    }

    @Override
    public boolean jgBuscar(String tipoArsenal) {
        // Refactor: Delegamos la validación al autómata finito determinista (AFD) de la bomba.
        // Si el autómata retorna true, el dron activa la acción.
        return bomb.jgExplotar(tipoArsenal);
    }
}
