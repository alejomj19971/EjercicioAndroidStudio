package com.example.entregafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.entregafinal.databinding.ActivityAddProductBinding;
import com.example.entregafinal.databinding.ActivityRegisterBinding;

public class AddProductActivity extends AppCompatActivity {
    private ActivityAddProductBinding productBinding;
    private  DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productBinding = ActivityAddProductBinding.inflate(getLayoutInflater());
        View view= productBinding.getRoot();
        setContentView(view);
        dbHelper =new DBHelper(this);


    }

    public void registerProduct(View view) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues userData = new ContentValues();
        String productName = productBinding.etProductName.getText().toString();
        String productReference = productBinding.etProductReference.getText().toString();
        String productId = productBinding.etProductIdentification.getText().toString();
        String description = productBinding.etProductDescription.getText().toString();
        userData.put("productName", productName);
        userData.put("productReference", productReference);
        userData.put("productId", productId);
        userData.put("description", description);
        long newUser = db.insert("products", null, userData);
        if ((productName == null) || (productReference == null) || (productId == null) || (description == null)) {
            Toast.makeText(this, " Por favor ingrese correctamente los campos", Toast.LENGTH_SHORT).show();

        }
        else
        {
            Toast.makeText(this, " Productoinsertado" + newUser, Toast.LENGTH_SHORT).show();

        }

        }
        public void goCheck (View view){
            Intent intent = new Intent(this, CheckProductActivity.class);
            startActivity(intent);
        }
        public void goHome1(View view){
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
















}

