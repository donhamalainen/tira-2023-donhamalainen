package oy.interact.tira.student;

import java.util.Comparator;

import oy.interact.tira.model.Coder;

public class CoderFullNameComparator implements Comparator<Coder> {

    // CONSTRUCTOR =================================
    public CoderFullNameComparator() {

    }

    @Override
    public int compare(Coder name, Coder other) {
        return name.getFullName().compareTo(other.getFullName());
    }
}
