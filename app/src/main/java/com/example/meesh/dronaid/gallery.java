package com.example.meesh.dronaid;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class gallery extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth firebaseAuth;
    private TextView useremail;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        firebaseAuth=FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this,login.class));
        }

        FirebaseUser user=firebaseAuth.getCurrentUser();

        useremail=(TextView)findViewById(R.id.useremail);
        useremail.setText("Welcome"+user.getEmail());
        logout=(Button)findViewById(R.id.logout);

        logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == logout){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this,login.class));
        }

    }
}
