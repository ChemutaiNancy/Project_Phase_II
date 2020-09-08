package com.example.leaderboad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgLaunch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        imgLaunch = findViewById(R.id.launcher_image);

        imgLaunch.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
//                bundle.putInt(ViewPagerFragment.KEY_LEADERBOAD_INDEX, index);
                getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_layout, new ViewPagerFragment())
                        .addToBackStack(null).commit();
            }
        } );
    }
}