package com.example.animationapp;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonTranslate, buttonRotate, buttonScale, buttonAlpha, buttonSet, b1, b2, b3, b4;
    ImageView imageAnimation;
    private Bitmap bmp;
    private Bitmap operation;
    Animation animTranslate,animRotate,animScale,animAlpha,animSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() {

        buttonTranslate = findViewById(R.id.button_translate);
        buttonRotate =findViewById(R.id.button_rotate);
        buttonScale =findViewById(R.id.button_scale);
        buttonAlpha =findViewById(R.id.button_alpha);
        buttonSet =findViewById(R.id.button_set);
        imageAnimation = findViewById(R.id.imageAnimation);

        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        BitmapDrawable abmp = (BitmapDrawable) imageAnimation.getDrawable();
        bmp = abmp.getBitmap();


        buttonTranslate.setOnClickListener(this);
        buttonRotate.setOnClickListener(this);
        buttonScale.setOnClickListener(this);
        buttonAlpha.setOnClickListener(this);
        buttonSet.setOnClickListener(this);


        animTranslate = AnimationUtils.loadAnimation(this,R.anim.translate);
        animRotate = AnimationUtils.loadAnimation(this,R.anim.rotate);
        animScale = AnimationUtils.loadAnimation(this,R.anim.scale);
        animAlpha = AnimationUtils.loadAnimation(this,R.anim.alpha);
        animSet = AnimationUtils.loadAnimation(this,R.anim.set);

    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.button_translate:

                imageAnimation.startAnimation(animTranslate);

                break;

            case R.id.button_rotate:

                imageAnimation.startAnimation(animRotate);

                break;

            case R.id.button_scale:

                imageAnimation.startAnimation(animScale);

                break;

            case R.id.button_alpha:

                imageAnimation.startAnimation(animAlpha);

                break;

            case R.id.button_set:

                imageAnimation.startAnimation(animSet);

                break;
        }
    }

    public void gray(View view) {
        operation = Bitmap.createBitmap(bmp.getWidth(),bmp.getHeight(), bmp.getConfig());
        double red = 0.33;
        double green = 0.59;
        double blue = 0.11;

        for (int i = 0; i < bmp.getWidth(); i++) {
            for (int j = 0; j < bmp.getHeight(); j++) {
                int p = bmp.getPixel(i, j);
                int r = Color.red(p);
                int g = Color.green(p);
                int b = Color.blue(p);

                r = (int) red * r;
                g = (int) green * g;
                b = (int) blue * b;
                operation.setPixel(i, j, Color.argb(Color.alpha(p), r, g, b));
            }
        }
        imageAnimation.setImageBitmap(operation);
    }

    public void dark(View view) {
        operation= Bitmap.createBitmap(bmp.getWidth(),bmp.getHeight(),bmp.getConfig());

        for(int i=0; i<bmp.getWidth(); i++){
            for(int j=0; j<bmp.getHeight(); j++){
                int p = bmp.getPixel(i, j);
                int r = Color.red(p);
                int g = Color.green(p);
                int b = Color.blue(p);
                int alpha = Color.alpha(p);

                r =  r - 50;
                g =  g - 50;
                b =  b - 50;
                alpha = alpha -50;
                operation.setPixel(i, j, Color.argb(Color.alpha(p), r, g, b));
            }
        }
        imageAnimation.setImageBitmap(operation);
    }

    public void gama(View view) {
        operation = Bitmap.createBitmap(bmp.getWidth(),bmp.getHeight(),bmp.getConfig());

        for(int i=0; i<bmp.getWidth(); i++){
            for(int j=0; j<bmp.getHeight(); j++){
                int p = bmp.getPixel(i, j);
                int r = Color.red(p);
                int g = Color.green(p);
                int b = Color.blue(p);
                int alpha = Color.alpha(p);

                r =  r + 150;
                g =  0;
                b =  0;
                alpha = 0;
                operation.setPixel(i, j, Color.argb(Color.alpha(p), r, g, b));
            }
        }
        imageAnimation.setImageBitmap(operation);

    }

    public void green(View view) {
        operation = Bitmap.createBitmap(bmp.getWidth(),bmp.getHeight(), bmp.getConfig());

        for(int i=0; i<bmp.getWidth(); i++){
            for(int j=0; j<bmp.getHeight(); j++){
                int p = bmp.getPixel(i, j);
                int r = Color.red(p);
                int g = Color.green(p);
                int b = Color.blue(p);
                int alpha = Color.alpha(p);

                r =  0;
                g =  g+150;
                b =  0;
                alpha = 0;
                operation.setPixel(i, j, Color.argb(Color.alpha(p), r, g, b));
            }
        }
        imageAnimation.setImageBitmap(operation);
    }
}