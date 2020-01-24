package books;

import javax.print.attribute.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class JTextFieldLimit extends PlainDocument{
	private int limit; // 제한할 길이

	public JTextFieldLimit(int limit) { // 생성자 : 제한할 길이를 인자로 받음
		super();
		this.limit = limit;
	}

	public void insertString(int offset, String str, javax.swing.text.AttributeSet attr) throws BadLocationException {
		if (str == null)
			return;

		if (getLength() + str.length() <= limit)
			super.insertString(offset, str, attr);
	}
	
}
