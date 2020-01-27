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
 

//먼저 메일 - 환경설정에서 세팅
// ( 보내는 사람 이메일 기준 )

public class SendEmail {
    static final String FROM = "hyunni_ellen@naver.com"; // 보내는 사람 이메일
    static final String FROMNAME = "JHTA도서관"; // 보내는 사람 이름
    static final String TO = "wkymonk@gmail.com"; // 받는 사람 이메일
 
    static final String SMTP_USERNAME = "hyunni_ellen@naver.com"; // 보내는 사람 이메일과 일치
    static final String SMTP_PASSWORD = "1whehtjrhks"; // 1조 도서관
    
    static final String HOST = "smtp.naver.com";
    static final int PORT = 587; // naver일 경우 587, gmail의 경우 465 공용? 25
    
    static final String SUBJECT = "[JHTA도서관] 연체도서 안내";
    
    static final String BODY = String.join(
        System.getProperty("line.separator"),
        "<h1>JHTA 도서관 연체도서 안내</h1>",
        "<p>빨리 반납해주세요!!!빨리요!!!</p>."
    );
    // 비밀번호 메일 보내기
    static final String BODY_sendPwd(String pwd) {
    	return String.join(
    	        System.getProperty("line.separator"),
    	        "<h1>JHTA 도서관 비밀번호 안내</h1>",
    	        "<p>비밀번호는 "+pwd +"입니다.</p>."
    	    );
    }

}