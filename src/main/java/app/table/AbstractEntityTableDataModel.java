package app.table;

import app.entity.IStringArrayConvertible;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public abstract class AbstractEntityTableDataModel extends AbstractTableModel {
    private List<IStringArrayConvertible> data;

    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public int getRowCount() {
        return data.size();
    }

    public int getColumnCount() {
        return getColumns().length;
    }

    public String getColumnName(int i){
        return getColumns()[i];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            List<String> list = getEntity(rowIndex).asArrayList();

            return list.get(columnIndex);
        } catch (Exception e) {
            return null;
        }
    }

    public IStringArrayConvertible getEntity(int rowIndex) {
        return data.get(rowIndex);
    }

    void setData(List<IStringArrayConvertible> data) {
        this.data = data;
    }

    abstract String[] getColumns();
}
