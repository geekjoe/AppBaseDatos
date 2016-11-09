package com.evoldig.mascotashop.JavaMail;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.evoldig.mascotashop.JavaMail.Config;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * Created by jazocar on 22/10/16.
 */

public class Sendmail extends AsyncTask <Void,Void, Void> {

    //Declarar Variables
    private Context context;
    private Session session;


    //Information to Send email
    private String email;
    private String subject;
    private String message;

    //Progressdialog to show While Sending Email
    private ProgressDialog progressDialog;
    // Class Constructor


    public Sendmail(Context context,String email, String subject, String message) {
        this.context = context;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        //Mostrar dialogo de Progreso mientras mandas email
        progressDialog = ProgressDialog.show(context,"Mandando Mensaje", "Por favor epere ...", false, false);

    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        //Dimissing the progress dialog
        progressDialog.dismiss();
        //Showing a sucess message
        Toast.makeText(context, "Correo Enviado", Toast.LENGTH_LONG).show();
    }


    @Override
    protected Void doInBackground(Void... params) {

        //Crating properties
        Properties props = new Properties();
        //Configuraring properties for gmail
        //If you are not using gmail you may need to change the values
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port","465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.port","465");

        //Creating a New Session

        //Creating a New Session


        session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            //Authenticating the password
            protected PasswordAuthentication getPasswordAuthentication () {
                return new PasswordAuthentication(Config.EMAIL, Config.PASSWORD);
            }

        } );

        try {
            //Creating MimeMessage Object
            MimeMessage mm = new MimeMessage(session);

            //Setting sender address
            mm.setFrom(new InternetAddress(Config.EMAIL));
            //Adding Receiver
            mm.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(email));
            //adding Subject
            mm.setSubject(subject);
            //Adding message
            mm.setText(message);
            //Sendig email
            Transport.send(mm);

        } catch (MessagingException e) {
            e.printStackTrace();
        }


        return null;
    }



}
