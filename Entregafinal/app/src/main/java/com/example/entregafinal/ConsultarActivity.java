package com.example.entregafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.entregafinal.databinding.ActivityConsultarproductoBinding;
import com.example.entregafinal.databinding.ActivityMainBinding;

public class ConsultarActivity extends AppCompatActivity {
    private ActivityConsultarproductoBinding consultarproductoBinding ;
    private Button btnConsultar;
    private DBHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        consultarproductoBinding= ActivityConsultarproductoBinding.inflate(getLayoutInflater());
        View view= consultarproductoBinding.getRoot();
        dbhelper=new DBHelper(this);
        setContentView(view);

    }

    public void Consult(View view){
        String email=consultarproductoBinding.etEmail2.getText().toString();
        String password=consultarproductoBinding.etPassword3.getText().toString();
        SQLiteDatabase db=dbhelper.getWritableDatabase();
        String query=String.format("SELECT *FROM users WHERE email='%s' and password='%s'",email,password);
        Cursor cursor= db.rawQuery(query,null);

        if (cursor.getCount()>0){

            Toast.makeText(this,"El usuario existe",Toast.LENGTH_SHORT).show();
            cursor.moveToNext();
            String emailResult=cursor.getString(2);
            String nameResult=cursor.getString(1);
            int identificationResult=cursor.getInt(3);
            int idTablaResult=cursor.getInt(0);
            consultarproductoBinding.txtVerEmail.setText(emailResult);
            consultarproductoBinding.txtVerNombre.setText(nameResult);
            consultarproductoBinding.txtVerIdentification.setText((String.valueOf(identificationResult)));
            consultarproductoBinding.txtidTabla.setText(String.valueOf(idTablaResult));

        }


    }
    public void backHome(View view){
        Intent intent=new Intent(this,HomeActivity.class);
        startActivity(intent);
    }
    public void addNewUser(View view){
        Intent intent=new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }




}