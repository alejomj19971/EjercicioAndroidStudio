package com.example.entregafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.entregafinal.databinding.ActivityHomeBinding;
import com.example.entregafinal.databinding.ActivityMainBinding;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding homeBinding ;
    private Button btnSubmit;
    private DBHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeBinding= ActivityHomeBinding.inflate(getLayoutInflater());
        View view= homeBinding.getRoot();
        dbhelper=new DBHelper(this);
        setContentView(view);


    }
    public void nuevoProducto(View view){
        Intent intent=new Intent(this,AddProductActivity.class);
        startActivity(intent);
    }
    public void infoPersonal(View view){
        Intent intent=new Intent(this,ConsultarActivity.class);
        startActivity(intent);
    }
    public void inBuscarProducto(View view){
        Intent intent=new Intent(this,CheckProductActivity.class);
        startActivity(intent);
    }
    public void logOut(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}