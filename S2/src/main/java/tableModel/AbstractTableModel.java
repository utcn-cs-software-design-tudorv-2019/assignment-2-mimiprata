package tableModel;

import java.util.List;

import javax.swing.JTable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
public abstract class AbstractTableModel {
	
	public JTable createTable(List<Object> objects) {
		if (objects.size() == 0)
			return null;
		JTable table = null;
		int numberOfColumns = objects.get(0).getClass().getDeclaredFields().length;
		System.out.println(numberOfColumns);
		String columns[] = new String[numberOfColumns];
		int i = 0;
		for (Field field : objects.get(0).getClass().getDeclaredFields()) {
			columns[i] = field.getName();
			i++;
		}
		String data[][] = new String[objects.size()][numberOfColumns];
		int row = 0;
		for (Object obj : objects) {
			int col = 0;
			for (Field field : obj.getClass().getDeclaredFields()) {
				field.setAccessible(true);
				Object value;
				try {
					value = field.get(obj);
					data[row][col] = value.toString();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				col++;
			}
			row++;
		}
		table = new JTable(data,columns);
		return table;
	}
	
}
