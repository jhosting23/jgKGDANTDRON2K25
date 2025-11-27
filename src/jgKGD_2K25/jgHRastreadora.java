package jgKGD_2K25;

public class jgHRastreadora extends jgHormiga implements jgIHormiga {
    @Override
    public boolean jgComer(jgAlimento alimento) {
        // HRastreadora es Herbivoro
        if (alimento instanceof jgHerbivoro) {
            return true;
        }
        return false;
    }

    @Override
    public String jgToString() {
        return "HRastreadora";
    }
}
