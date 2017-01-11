package com.webdesarrollador.animationtutorial;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final ImageView carta = (ImageView)findViewById(R.id.carta);
        final ImageView carta2 = (ImageView)findViewById(R.id.carta2);

        //Declaramos el ValueAnimator cargando el XML animation_x
        ValueAnimator va = (ValueAnimator) AnimatorInflater.loadAnimator(this,R.animator.animation_x);
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {

                carta.setX((int)animation.getAnimatedValue());
            }
        });
        va.start();

        //Rotación
        ObjectAnimator oa = (ObjectAnimator) AnimatorInflater.loadAnimator(this,R.animator.animation_rotation);
        oa.setTarget(carta2);
        oa.start();

        //Desplazamiento
        ObjectAnimator oa2 = ObjectAnimator.ofFloat(carta2, "x", 0f, 300f);
        oa2.setDuration(3000);
        //oa.start();

        AnimatorSet as = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.animation_set);
        as.setTarget(carta2);
        as.start();

    }
    //Vamos a las animaciones programaticamente
    public void goToProgram(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}