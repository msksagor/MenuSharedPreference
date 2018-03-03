package com.example.fondn.menusharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout  = (LinearLayout) findViewById(R.id.containerLayoutID);

        if(loadColor()!=getResources().getColor(R.color.colorPrimary)){
            linearLayout.setBackgroundColor(loadColor());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.custommenu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.sabuj){
            linearLayout.setBackgroundColor(getResources().getColor(R.color.blue));
            storeColor(getResources().getColor(R.color.blue));

        }
        else if(item.getItemId()==R.id.khan){
            linearLayout.setBackgroundColor(getResources().getColor(R.color.y));


            storeColor(getResources().getColor(R.color.y));

        }else if(item.getItemId()==R.id.sagor){
            linearLayout.setBackgroundColor(getResources().getColor(R.color.dark));
            storeColor(getResources().getColor(R.color.dark));

        }else if(item.getItemId()==R.id.sabuj){
            linearLayout.setBackgroundColor(getResources().getColor(R.color.youlo));
            storeColor(getResources().getColor(R.color.youlo));

        }

        return super.onOptionsItemSelected(item);
    }

    private void storeColor(int color){
        SharedPreferences sharedPreferences = getSharedPreferences("SagorsColor", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("color",color);
        editor.commit();
    }
    private int loadColor(){
        SharedPreferences sharedPreferences = getSharedPreferences("SagorsColor", Context.MODE_PRIVATE);
        int s = sharedPreferences.getInt("color",getResources().getColor(R.color.colorAccent));
        return s;
    }
}
