package com.example.socialx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity  implements
        AdapterView.OnItemSelectedListener{
    Button registerBtn,loginToolbar;
    EditText name,email,phone,password;
    String mName,mEmail,mPhone,mPassword,emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String[] numbers = { "+91", "222", "+63"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        checkLogin();
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_sign_up);

        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the numbers list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,numbers);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);

        registerBtn = findViewById(R.id.registerBtn);
        loginToolbar = findViewById(R.id.loginToolbar);
        name = findViewById(R.id.signInName);
        email = findViewById(R.id.signInEmail);
        phone = findViewById(R.id.signInMobNo);
        password = findViewById(R.id.signInPassword);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });

        loginToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        //Toast.makeText(getApplicationContext(),numbers[position] , Toast.LENGTH_LONG).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    private void validate(){
        mName = name.getText().toString();
        mEmail = email.getText().toString();
        mPhone = phone.getText().toString();
        mPassword = password.getText().toString();

        if(mEmail.matches(emailPattern) && mPhone.length()==10)
        {
            Toast.makeText(SignUpActivity.this, "validated!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
            finishAffinity();
            sharedPreferences= getSharedPreferences("mypref", Context.MODE_PRIVATE);
            editor = sharedPreferences.edit();
            editor.putString("email", mEmail);
            editor.putString("password", mPassword);
            editor.putBoolean("isLogin",true);
            editor.commit();
        }
        else
        {
            Toast.makeText(SignUpActivity.this, "Enter all fields correctly!", Toast.LENGTH_SHORT).show();
        }
    }

    private void checkLogin() {
        if(sharedPreferences == null)
        {
            sharedPreferences = getSharedPreferences("mypref", Context.MODE_PRIVATE);
        }
        String loginEmail = sharedPreferences.getString("email",mEmail);

        if (loginEmail != null && !loginEmail.equals("")) {
            Intent i = new Intent(SignUpActivity.this, MainActivity.class);
            startActivity(i);
            finishAffinity();
        }
    }
}