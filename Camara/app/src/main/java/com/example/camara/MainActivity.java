package com.example.camara;
//173211
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btn;
    ImageView img;
    Intent i;
    Bitmap bmp;
    final static int cons = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView) findViewById(R.id.img_web);
        btn = (Button) findViewById(R.id.camara);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                switch (id){
                    case R.id.camara:
                        i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        System.out.println(i);
                        startActivityForResult(i,cons);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK){
            Bundle ext = data.getExtras();
            bmp = (Bitmap) ext.get("data"); // convierte la imagen a texto, le baja la calidad y te permite utilizarla
            img.setImageBitmap(bmp);  // setImageDrawable no me se la diferencia

        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
    @Override
    protected void onStop() {
        super.onStop();

    }
    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }





}
