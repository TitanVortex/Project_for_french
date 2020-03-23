package com.titan.guide_fran;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import static com.titan.guide_fran.R.id.tv_helper_en_id;

public class Helper extends AppCompatActivity {

    Toolbar toolbar;
    Button btn_reverso;
    Button btn_francaisfacile;
    ListView listView;

    //public String listContent[] = {"audio1", "audio2", "audio3", "audio4", "audio5", "audio6", "audio7"};
    //String raw_ref = "guide_fran -> App -> src -> main -> res -> raw";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper);

        toolbar= findViewById(R.id.toolbar_guide);
        toolbar.setTitle("Assistante communication");


        /** listview */
        listView= findViewById(R.id.listView_helper);



        MyAdapter1 adapter = new MyAdapter1(this, getResources().getStringArray(R.array.helper_tv_fr),
                getResources().getStringArray(R.array.helper_tv_en)

        );
        listView.setAdapter(adapter);

        /*
         final ArrayAdapter<String> listAdapter = new ArrayAdapter<String>
         (
         Helper.this,
         android.R.layout.simple_list_item_1,
         getResources().getStringArray(R.array.helper_tv_aud)
         );


         listView.setAdapter(listAdapter);
        */

        /** listview */


        /** buttons */
        btn_reverso=(Button)findViewById(R.id.btn_reverso);
        btn_francaisfacile=(Button)findViewById(R.id.btn_francais_facile);

        final String links[]=getResources().getStringArray(R.array.links_helper);

        btn_reverso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Helper.this, PlaceDetails.class);

                Bundle extras = new Bundle();
                extras.putString("PLACE_LINK",links[0]);

                intent.putExtras(extras);

                startActivity(intent);

            }
        });

        btn_francaisfacile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Helper.this, PlaceDetails.class);

                Bundle extras = new Bundle();
                extras.putString("PLACE_LINK",links[1]);

                intent.putExtras(extras);

                startActivity(intent);
            }
        });
        /** buttons */

    }


    class MyAdapter1 extends ArrayAdapter<String> {

        Context context;
        String[] fr;
        String[] en;

        int IDs[]={R.raw.audio1,R.raw.audio2,R.raw.audio3,R.raw.audio4,R.raw.audio5,R.raw.audio6,R.raw.audio7};

        //Button btn_aud;

        MyAdapter1 (Context c, String[] s_fr, String[] s_en ) {
            super(c, R.layout.helper_item_view, R.id.tv_helper_fr_id, s_fr );
            this.context = c;
            this.fr=s_fr;
            this.en=s_en;
            //this.btn_aud=b_aud;
        }


        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View item_view = layoutInflater.inflate(R.layout.helper_item_view, parent, false);

            TextView tvfr = item_view.findViewById(R.id.tv_helper_fr_id);
            TextView tven = item_view.findViewById(tv_helper_en_id);


            Button btn_aud=item_view.findViewById(R.id.button_play);

            btn_aud.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){

                    MediaPlayer audio_player = MediaPlayer.create(Helper.this, IDs[position]);
                    audio_player.start();
                }
            });


            tvfr.setText(fr[position]);
            tven.setText(en[position]);




            return item_view;
        }
    }





}


