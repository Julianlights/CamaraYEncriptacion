package com.example.primeraplicacion;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.EditText;

import java.math.BigInteger;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    private EditText etOutPut, lolOutPut;
    private String publicKey = "";
    private String privateKey = "";
    private byte[] encodeData = null;
    @Override
    protected  void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etOutPut = (EditText) findViewById(R.id.etOutput); // desencriptar
        lolOutPut = (EditText) findViewById(R.id.lolOutput); // es el de encriptar
        try {
            Map<String, Object> keyMap = rsa.initKey();
            publicKey = rsa.getPublicKey(keyMap);
            privateKey = rsa.getPrivateKey(keyMap);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void encrypt(View v){
        byte [] rsaData = lolOutPut.getText().toString().getBytes();
        try{
            encodeData = rsa.encryptByPublicKey(rsaData, getPublicKey());
            String encodeStr = new BigInteger(1, encodeData).toString();
            lolOutPut.setText(encodeStr);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public void decrypt (View v){

        try{
            byte [] decodeData = rsa.encryptByPrivateKey(encodeData, getPrivateKey());
            String decodeStr = new String(decodeData);
            etOutPut.setText(decodeStr);
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public String getPublicKey(){
        return publicKey;

    }
    public String getPrivateKey(){
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public void setPublicKey(String publicKey){
        this.publicKey = publicKey;
    }
}
