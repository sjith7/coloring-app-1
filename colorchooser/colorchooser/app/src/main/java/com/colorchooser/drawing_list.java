package com.colorchooser;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class drawing_list extends AppCompatActivity{
    private String[] textOnList = {"tiger","wolf","giraffe","elephant","crocodile"};
    private int[] bgimages = {R.drawable.tiger,R.drawable.wolf,R.drawable.giraffe,R.drawable.elephant,R.drawable.crocodile};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_drawing_list);
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.card_info,textOnList);
        ListView listView =(ListView) findViewById(R.id.drawingList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> parent, View view, int position, long id) {
                log("selected   "+position);
            }
        });


    }

 /*   @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        log("item selected "+position);
        Intent intent = new Intent(drawing_list.this,DrawImage.class);
        intent.putExtra("numbers",bgimages[position]);
        startActivity(intent);

    }
*/
    private void log(String s) {

        Log.e("","Logging::"+s);
    }

}
