package org.kanakM;

public class Main {
    public static void main(String[] args) {

        System.out.println("Starting to send out Mails !");

        MailHandler mailHandler = new MailHandler();
        mailHandler.sendMail();
    }
}