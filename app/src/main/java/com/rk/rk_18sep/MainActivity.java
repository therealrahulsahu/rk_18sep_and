package com.rk.rk_18sep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText num,mess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void send(View v)
    {
        num = findViewById(R.id.number);
        mess = findViewById(R.id.message);
        String nm = num.getText().toString();
        if(nm.length()==10)
        {
            String ms = mess.getText().toString();
            SmsManager sm = SmsManager.getDefault();
            sm.sendTextMessage(nm, null, ms, null, null);
        }
        else
        {
            num.setText("");
        }
    }
    public void call(View v)
    {
        num = findViewById(R.id.number);
        String nm = num.getText().toString();
        if(nm.length()==10)
        {
            Intent in = new Intent(Intent.ACTION_DIAL);
            in.setData(Uri.parse("tel:"+nm));
            startActivity(in);
        }
        else
        {
            num.setText("");
        }
    }
}
