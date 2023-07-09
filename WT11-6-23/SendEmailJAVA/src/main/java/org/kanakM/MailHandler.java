package org.kanakM;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailHandler {

    void sendMail() {

        Properties sysProperties = System.getProperties();

        System.out.println(sysProperties);

        sysProperties.put("mail.smtp.host", MailMetaData.HostServer);
        sysProperties.put("mail.smtp.port", MailMetaData.port);
        sysProperties.put(MailMetaData.sslProperty, "true");
        sysProperties.put(MailMetaData.authPerm, "true");

        Authenticator mailAuthenticator = new CustomizedMailAuthentication();
        Session mailSession = Session.getInstance(sysProperties,mailAuthenticator);

        MimeMessage mailMessage = new MimeMessage(mailSession);

        try{
            mailMessage.setFrom(MailMetaData.myUserMail);
            mailMessage.setSubject("This is my JAVA Code Testing !");
            mailMessage.setText("I am KANAK, Trying to mail you using JAVA");


            Address receiverMail = new InternetAddress(MailMetaData.receiverMail);
            mailMessage.setRecipient(Message.RecipientType.TO, receiverMail);

            Transport.send(mailMessage);
        }
    catch(
    Exception mailException)

    {
        System.out.println(mailException.toString());
    }
}
}
