package com.titan.guide_fran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btn_guide;
    Button btn_helper;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView =findViewById(R.id.imageview_main);
        //imageView.setImageResource(R.drawable.title_flag);


        btn_guide=findViewById(R.id.button_guide);
        btn_helper=findViewById(R.id.button_helper);

        btn_guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Guide.class));
            }
        });

        btn_helper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Helper.class));
            }
        });



    }
}
