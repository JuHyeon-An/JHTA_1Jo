package books;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 

//���� ���� - ȯ�漳������ ����
// ( ������ ��� �̸��� ���� )

public class SendEmail {
    static final String FROM = "hyunni_ellen@naver.com"; // ������ ��� �̸���
    static final String FROMNAME = "JHTA������"; // ������ ��� �̸�
    static final String TO = "wkymonk@gmail.com"; // �޴� ��� �̸���
 
    static final String SMTP_USERNAME = "hyunni_ellen@naver.com"; // ������ ��� �̸��ϰ� ��ġ
    static final String SMTP_PASSWORD = "1whehtjrhks"; // 1�� ������
    
    static final String HOST = "smtp.naver.com";
    static final int PORT = 587; // naver�� ��� 587, gmail�� ��� 465 ����? 25
    
    static final String SUBJECT = "[JHTA������] ��ü���� �ȳ�";
    
    static final String BODY = String.join(
        System.getProperty("line.separator"),
        "<h1>JHTA ������ ��ü���� �ȳ�</h1>",
        "<p>���� �ݳ����ּ���!!!������!!!</p>."
    );
    // ��й�ȣ ���� ������
    static final String BODY_sendPwd(String pwd) {
    	return String.join(
    	        System.getProperty("line.separator"),
    	        "<h1>JHTA ������ ��й�ȣ �ȳ�</h1>",
    	        "<p>��й�ȣ�� "+pwd +"�Դϴ�.</p>."
    	    );
    }

}