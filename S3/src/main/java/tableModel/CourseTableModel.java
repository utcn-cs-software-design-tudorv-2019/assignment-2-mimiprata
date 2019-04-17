package tableModel;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.Teacher;

public class CourseTableModel extends AbstractTableModel {
	

	public JTable teacherTable(List<Object> t)
	{
		DefaultTableModel model=new DefaultTableModel(new Object[] {"IdTeacher", "Teacher","Course"},0);
		
		for(Object temp1:t) {
			
			model.addRow(new Object[] {((Teacher)temp1).getIdteacher(),((Teacher)temp1).getName(),((Teacher)temp1).getCourseName()});
			}
		
		JTable table=new JTable();
		
		 table.setModel(model);
		 return table;
	}
	

}
