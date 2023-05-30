package Model.operation;

import Model.Polynomial;

public interface Operation {
    Polynomial apply(Polynomial P1, Polynomial P2);
}
