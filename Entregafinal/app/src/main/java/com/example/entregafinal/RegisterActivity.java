package com.example.entregafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.entregafinal.databinding.ActivityMainBinding;
import com.example.entregafinal.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding registerBinding;
    private  DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       registerBinding = ActivityRegisterBinding.inflate(getLayoutInflater());
        View view= registerBinding.getRoot();
        setContentView(view);
        dbHelper =new DBHelper(this);


    }
    public void registerUser(View view){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues userData=new ContentValues();
        String name=registerBinding.etName.getText().toString();
        String email=registerBinding.etEmail1.getText().toString();
        String identification=registerBinding.etIdentification.getText().toString();
        String password=registerBinding.etPassword1.getText().toString();
        userData.put("name",name);
        userData.put("email",email);
        userData.put("identification",identification);
        userData.put("password",password);
        long newUser=db.insert("users",null,userData);
        if((name==null)|| (email==null)||(identification==null)||(password==null) ) {
            Toast.makeText(this, " Por favor ingrese correctamente los campos" , Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(this, " Ahora inicie sesión" + newUser, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }







    }
    public void back(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}