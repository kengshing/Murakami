package net.orcacreation.murakami;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set the toolbar
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        ImageView mainView = findViewById(R.id.view_main);
        //mainView.setBackgroundResource(R.drawable.img_agony_uncle);
        mainView.setImageResource(R.drawable.img_agony_uncle);

        TextView buttonMain = findViewById(R.id.button_main);
        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent infoIntent = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(infoIntent);
            }
        });
    }
}
