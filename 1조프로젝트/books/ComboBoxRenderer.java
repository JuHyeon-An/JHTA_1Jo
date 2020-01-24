package books;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

class ComboBoxRenderer extends DefaultListCellRenderer {


	@Override
    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {
		
        JLabel label = (JLabel) super.getListCellRendererComponent(list,
                value, index, isSelected, cellHasFocus);
        j_GroupVo vo = (j_GroupVo) value;
        label.setText(vo.getgCode()+" | "+vo.getgName());
        
        return label;
    }
}

