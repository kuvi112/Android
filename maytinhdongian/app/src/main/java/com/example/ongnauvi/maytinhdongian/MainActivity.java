package com.example.ongnauvi.maytinhdongian;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtso1, edtso2;
    TextView txtvkq;
    Button btncong, btntru, btnnhan, btnchia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        edtso1 = (EditText)findViewById(R.id.nb1);
        edtso2 = (EditText)findViewById(R.id.nb2);
        txtvkq = (TextView)findViewById(R.id.txtvkq);
        btncong = (Button)findViewById(R.id.btncong);
        btntru = (Button)findViewById(R.id.btntru);
        btnnhan = (Button)findViewById(R.id.btnnhan);
        btnchia = (Button)findViewById(R.id.btnchia);
        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chuoi1 = edtso1.getText().toString();
                int so1 = Integer.parseInt(chuoi1);
                String chuoi2 = edtso2.getText().toString();
                int so2 = Integer.parseInt(chuoi2);

                int tong = so1 +so2;
                txtvkq.setText(String.valueOf(tong));
            }
        });
        btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chuoi1 = edtso1.getText().toString();
                int so1 = Integer.parseInt(chuoi1);
                String chuoi2 = edtso2.getText().toString();
                int so2 = Integer.parseInt(chuoi2);

                int hieu = so1 - so2;
                txtvkq.setText(String.valueOf(hieu));
            }
        });
        btnnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chuoi1 = edtso1.getText().toString();
                int so1 = Integer.parseInt(chuoi1);
                String chuoi2 = edtso2.getText().toString();
                int so2 = Integer.parseInt(chuoi2);

                int tich = so1 * so2;
                txtvkq.setText(String.valueOf(tich));
            }
        });
        btnchia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chuoi1 = edtso1.getText().toString();
                int so1 = Integer.parseInt(chuoi1);
                String chuoi2 = edtso2.getText().toString();
                int so2 = Integer.parseInt(chuoi2);

                //float thuong = so1 / so2;
                txtvkq.setText(String.valueOf(1.0*so1/so2));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
