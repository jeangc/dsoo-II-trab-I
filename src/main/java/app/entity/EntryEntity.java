package app.entity;

import java.util.Arrays;
import java.util.List;

public class EntryEntity implements IStringArrayConvertible {
    private String placa;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public List<String> asArrayList() {
        return Arrays.asList(getPlaca());
    }
}
