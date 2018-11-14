package com.example.paras.latticeinnovations.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.paras.latticeinnovations.R;
import com.example.paras.latticeinnovations.SignedIn;
import com.example.paras.latticeinnovations.helper.DatabaseHelper;

import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {

    private static final Pattern Password_Pattern=
            Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*).{8,15}$");
    private  static  final Pattern PhnNumber_Pattern= Pattern.compile("^([0-9]){10,12}$");

    DatabaseHelper db = new DatabaseHelper(this);
   String name,address,email,number,password;

    EditText et_Name, et_Address, et_Number, et_Password, et_Email;
    Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);


        et_Name = (EditText) findViewById(R.id.etName);
        et_Address = (EditText) findViewById(R.id.etAddress);
        et_Email = (EditText) findViewById(R.id.etEmail);
        et_Number = (EditText) findViewById(R.id.etNumber);
        et_Password = (EditText) findViewById(R.id.etPassword);
        signUp = (Button) findViewById(R.id.btnSignUp);


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(getBaseContext(),"fill details",Toast.LENGTH_LONG).show();
                register();

                String name = et_Name.getText().toString();
                String address = et_Address.getText().toString();
                String email = et_Email.getText().toString();
                String number = et_Number.getText().toString();
                String password = et_Password.getText().toString();

                boolean isInserted = db.insertData(name,address,email,number,password);
                if(isInserted == true)
                    Toast.makeText(SignUp.this,"Data Inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(SignUp.this,"Data not Inserted",Toast.LENGTH_LONG).show();



//
//                User u = new User();
//                u.setId();
//                u.setName(name);
//                u.setAddress(address);
//                u.setEmail(email);
//                u.setNumber(number);
//                u.setPassword(password);
//
//                db.insertUser(u);

               // Toast.makeText(getBaseContext(), "Done", Toast.LENGTH_LONG).show();

//                if(!validate()){
//                    Toast.makeText(getBaseContext(),"SignUp failed",Toast.LENGTH_LONG).show();
//                }
//                else{
//                    onSignUpSuccess();
//                }




            }
        });
    }
    public void register()
    {
        initialize();
        if(!validate()){
            Toast.makeText(getBaseContext(),"SignUp failed",Toast.LENGTH_LONG).show();
        }
        else{
            Intent i = new Intent(SignUp.this,SignedIn.class);
            startActivity(i);

        }
    }
    public void onSignUpSuccess(){

    }
    public boolean validate()
    {
        boolean valid =true;
        if(name.isEmpty()||name.length()<4){
            et_Name.setError("Please Enter Valid Name");
            valid=false;
        }
        if(address.isEmpty()||address.length()<10){
            et_Address.setError("Please Enter Valid Address");
            valid=false;
        }
        if(email.isEmpty()||!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            et_Email.setError("Please enter valid Email");
            valid=false;
        }
        if(number.length()<10||!PhnNumber_Pattern.matcher(number).matches()){
            et_Number.setError("Please Enter Valid Phone Number");
            valid=false;
        }
        if(password.isEmpty()||!Password_Pattern.matcher(password).matches()){
            et_Password.setError("Please Enter Valid Password");
            valid=false;
        }
        return valid;
    }
    public  void initialize(){
        name = et_Name.getText().toString();
        address = et_Address.getText().toString();
        email = et_Email.getText().toString();
        number = et_Number.getText().toString();
        password = et_Password.getText().toString();
    }


}

