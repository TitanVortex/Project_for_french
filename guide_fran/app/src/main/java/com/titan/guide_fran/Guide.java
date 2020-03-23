package com.titan.guide_fran;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
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

        int[] images = {R.drawable.p0,R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5,R.drawable.p6};
        String mTitle;


        toolbar= findViewById(R.id.toolbar_guide);
        toolbar.setTitle("Guide");

        listView= findViewById(R.id.listView);





        /**
        final ArrayAdapter<String> listAdapter = new ArrayAdapter<String>
                (
                        Guide.this,
                        android.R.layout.simple_list_item_1,
                        getResources().getStringArray(R.array.places)
                );
        */

        /** listView.setAdapter(listAdapter); */

        final String links[]=getResources().getStringArray(R.array.links);

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


            MyAdapter adapter = new MyAdapter(this, getResources().getStringArray(R.array.places), images);
            listView.setAdapter(adapter);


    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String[] rTitle;

        int[] rImgs;

        MyAdapter (Context c, String[] title, int[] imgs) {
            super(c, R.layout.item_view, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rImgs = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View item_view = layoutInflater.inflate(R.layout.item_view, parent, false);
            ImageView images = item_view.findViewById(R.id.image);
            TextView myTitle = item_view.findViewById(R.id.textView1);


            // now set our resources on views
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);

            return item_view;
        }
    }


}
