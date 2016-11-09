package com.evoldig.mascotashop.Menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.evoldig.mascotashop.R;
import com.evoldig.mascotashop.JavaMail.Sendmail;

public class Contacto extends AppCompatActivity implements View.OnClickListener {

    //Declare EditText
    private EditText editTextEmail;
    private EditText editTextSubject;
    private EditText editTextMessage;

    //Send button
    private Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        //Función de Toolbar
        Toolbar miActionBarConta = (Toolbar) findViewById(R.id.miActionBarConta);
        miActionBarConta.setTitle("");
        setSupportActionBar(miActionBarConta);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Initializing the views
        editTextEmail = (EditText) findViewById(R.id.txt_email);
        editTextMessage = (EditText) findViewById(R.id.txt_comentario);
        editTextSubject = (EditText) findViewById(R.id.txt_name);

        buttonSend = (Button) findViewById(R.id.button_envio);

        //Adding click listener
        buttonSend.setOnClickListener(this);


    }

    private void sendEmail() {
        //Getting Content for email
        String email = editTextEmail.getText().toString().trim();
        String subject = editTextSubject.getText().toString().trim();
        String message = editTextMessage.getText().toString().trim();

        //Creating SenMail Object
        Sendmail sm = new Sendmail(this, email, subject, message);
        //Executing sendmail to send email
        sm.execute();

    }

    @Override
    public void onClick(View v) {

        sendEmail();

    }
}
