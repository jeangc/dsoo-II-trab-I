package app.view.table;


import app.entity.EntryEntity;
import app.entity.IStringArrayConvertible;

import java.util.ArrayList;
import java.util.List;

public class EntryTableDataModel extends AbstractEntityTableDataModel {

    public EntryTableDataModel(List<EntryEntity> list) {
        setData(new ArrayList<IStringArrayConvertible>(list));
    }

    public String[] getColumns() {
        return new String[]{"Placa", "Horário de chegada"};
    }
}
