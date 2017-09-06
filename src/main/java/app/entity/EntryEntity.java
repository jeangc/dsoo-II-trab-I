package app.entity;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

public class EntryEntity implements IStringArrayConvertible {
    private int id;
    private String placa;
    private Timestamp entrada;
    private Timestamp saida;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setEntrada(Timestamp entrada) {
        this.entrada = entrada;
    }

    public Timestamp getEntrada() {
        return entrada;
    }

    public Timestamp getSaida() {
        return saida;
    }

    public void setSaida(Timestamp saida) {
        this.saida = saida;
    }

    public List<String> asArrayList() {
        String entrada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(getEntrada());

        return Arrays.asList(getPlaca(), entrada);
    }
}
