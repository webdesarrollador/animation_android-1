package com.webdesarrollador.animationtutorial;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView carta = (ImageView)findViewById(R.id.carta);
        final ImageView carta2 = (ImageView)findViewById(R.id.carta2);

        //Declaramos el ValueAnimator con los valores inicial y final de la animación
        ValueAnimator va = ValueAnimator.ofInt(0, 300);
        //Tiempo de la animación en milisegundos
        int mDuration = 3000;
        va.setDuration(mDuration);
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {

                carta.setX((int)animation.getAnimatedValue());
            }
        });
        va.start();

        //Rotación
        ObjectAnimator oa = ObjectAnimator.ofFloat(carta2, "rotationY", 0, 180);
        oa.setDuration(3000);
        //oa.start();

        //Desplazamiento
        ObjectAnimator oa2 = ObjectAnimator.ofFloat(carta2, "x", 0f, 300f);
        oa2.setDuration(3000);

        AnimatorSet as = new AnimatorSet();
        //Hacemos que las animaciones corran a la vez
        as.playTogether(oa,oa2);
        as.start();

    }
    //Vamos a la actividad donde las animaciones estan definidas en XML
    public void goToXML(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}

