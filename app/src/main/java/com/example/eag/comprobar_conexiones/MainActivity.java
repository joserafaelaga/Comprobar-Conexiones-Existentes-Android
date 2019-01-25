package com.example.eag.comprobar_conexiones;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView comprobar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        comprobar = (TextView) findViewById(R.id.comprobar);


        //Recuperamos información de las conexiones
        ConnectivityManager connectivityManager = (ConnectivityManager ) getSystemService(Context.CONNECTIVITY_SERVICE);

        //Recuperamos las conexiones activas
        NetworkInfo conexionesActivas = connectivityManager.getActiveNetworkInfo();

        //Comprobamos si hay una conexión a Internet activa
        /*if(conexionesActivas != null){
            comprobar.setText("¡Hay una conexión activa!");
        }else{
            comprobar.setText("No hay ninguna conexión");
        }*/

        //Comprobamos si hay una conexión y de qué tipo es
        if(conexionesActivas != null && conexionesActivas.getType() == ConnectivityManager.TYPE_MOBILE){
            comprobar.setText("Es una conexión de datos móviles");
        }else if(conexionesActivas != null && conexionesActivas.getType() == ConnectivityManager.TYPE_WIFI) {
            comprobar.setText("Es una conexión WiFi");
        }else{
            comprobar.setText("No hay ninguna conexión");
        }
    }
}
