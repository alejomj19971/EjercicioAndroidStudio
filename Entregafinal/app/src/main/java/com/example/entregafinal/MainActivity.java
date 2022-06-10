package com.example.entregafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.entregafinal.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding ;
    private Button btnSubmit;
    private DBHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding= ActivityMainBinding.inflate(getLayoutInflater());
        View view= mainBinding.getRoot();
        dbhelper=new DBHelper(this);
        setContentView(view);


    }
//btnSingIn
    public void onClick(View view){

        String email=mainBinding.etEmail.getText().toString();
        String password=mainBinding.etPassword.getText().toString();
        SQLiteDatabase db=dbhelper.getWritableDatabase();
        String query=String.format("SELECT *FROM users WHERE email='%s' and password='%s'",email,password);
        Cursor cursor= db.rawQuery(query,null);

        if (cursor.getCount()>0){

            Toast.makeText(this,"El usuario existe",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,HomeActivity.class);
            startActivity(intent);
        }

        else{
            Intent intent=new Intent(this,RegisterActivity.class);
            startActivity(intent);
        }
        cursor.moveToNext();


    }
    //btnSingUp
    public void goRegisterUser(View view){
        Intent intent=new Intent(this,RegisterActivity.class);
        startActivity(intent);


    }
}