package com.titan.guide_fran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

import java.lang.reflect.Array;
import java.util.List;

public class Guide extends AppCompatActivity {

    ListView listView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);



        toolbar= findViewById(R.id.toolbar_guide);
        toolbar.setTitle("Guide");

        listView= findViewById(R.id.listView);

        final ArrayAdapter<String> listAdapter = new ArrayAdapter<String>
                (
                        Guide.this,
                        android.R.layout.simple_list_item_1,
                        getResources().getStringArray(R.array.places)
                );

        final String links[]=getResources().getStringArray(R.array.links);


        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Guide.this, PlaceDetails.class);

                Bundle extras = new Bundle();
                extras.putString("PLACE_NAME", listView.getItemAtPosition(i).toString());
                extras.putString("PLACE_LINK",links[i]);

                intent.putExtras(extras);

                startActivity(intent);
            }
        });
    }
}
