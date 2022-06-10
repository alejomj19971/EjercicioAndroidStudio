package com.example.entregafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.entregafinal.databinding.ActivityAddProductBinding;
import com.example.entregafinal.databinding.ActivityCheckProductBinding;

public class CheckProductActivity extends AppCompatActivity {
    private ActivityCheckProductBinding checkProductBinding;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkProductBinding = ActivityCheckProductBinding.inflate(getLayoutInflater());
        View view = checkProductBinding.getRoot();
        setContentView(view);
        dbHelper = new DBHelper(this);
    }

    public void Consult(View view) {
        String productReference = checkProductBinding.etProductreference1.getText().toString();

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = String.format("SELECT *FROM products WHERE productReference='%s'", productReference);
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.getCount() > 0) {

            Toast.makeText(this, "the product exists", Toast.LENGTH_SHORT).show();
            cursor.moveToNext();
            String productNameResult = cursor.getString(1);
            String productReferenceResult = cursor.getString(2);
            int productIdentificationResult = cursor.getInt(3);
            int idProductResult = cursor.getInt(0);
            String prodDescriptionResult = cursor.getString(4);
            checkProductBinding.txtProductName.setText(productNameResult);
            checkProductBinding.txtProductReference.setText(productReferenceResult);
            checkProductBinding.txtProductIdentification.setText(String.valueOf(productIdentificationResult));
            checkProductBinding.txtIdProd.setText(String.valueOf(idProductResult));
            checkProductBinding.txtProductDescription.setText(prodDescriptionResult);

        }
    }

    public void goAddNewProduct(View view) {
        Intent intent=new Intent(this,AddProductActivity.class);
        startActivity(intent);
    }
    public void goHome(View view){
        Intent intent=new Intent(this,HomeActivity.class);
        startActivity(intent);
    }
}