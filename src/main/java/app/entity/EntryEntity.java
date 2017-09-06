package app.entity;

import java.util.Arrays;
import java.util.List;

public class EntryEntity implements IStringArrayConvertible {
    private String placa;
    private String entrada;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public List<String> asArrayList() {
        return Arrays.asList(getPlaca());
    }
}
