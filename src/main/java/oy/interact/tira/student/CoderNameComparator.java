package oy.interact.tira.student;

import java.util.Comparator;

import oy.interact.tira.model.Coder;

public class CoderNameComparator implements Comparator<Coder> {

    // CONSTRUCTOR =================================
    public CoderNameComparator() {

    }

    /*
     * Vertailee koodareita "coder name":n eli lempinimen mukaan luonnollisesssa
     * järjestyksessä.
     */
    @Override
    public int compare(Coder name, Coder other) {
        return name.getCoderName().compareTo(other.getCoderName());
    }
}
