package com.cookandroid.a1025;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout baseLayout;
    Button button1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("1025 게임프로그래밍");

        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemnum:
                Toast.makeText(getApplicationContext(), "2017748065", Toast.LENGTH_LONG).show();
                return true;
            case R.id.itemname:
                Toast.makeText(getApplicationContext(), "이도건", Toast.LENGTH_LONG).show();

                return true;
            case R.id.iteminfo:
                Toast.makeText(getApplicationContext(), "2017748065 이도건", Toast.LENGTH_LONG).show();
                return true;
        }
        return false;
    }

}