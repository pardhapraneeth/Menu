package com.example.cse15u006.menu;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 private EditText input;
 private EditText output;
    private ClipboardManager myClipboard;
    private ClipData myClip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input= (EditText) findViewById(R.id.inputText);
        output=(EditText) findViewById(R.id.outputtext);
        myClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);

    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_option, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        String inputText= input.getText().toString();
        //respond to menu item selection
        switch (item.getItemId()) {
            case R.id.clear:
                input.setText("");

                return true;

                          case R.id.action3_sub1:

                              input.setText("");


                              return true;

                          case R.id.action3_sub2:
                              String text;
                              text = input.getText().toString();
                              myClip = ClipData.newPlainText("text", text);
                              myClipboard.setPrimaryClip(myClip);


                              return true;

                          case R.id.action3_sub3:
                              //output.setText(inputText);
                              ClipData abc = myClipboard.getPrimaryClip();
                              ClipData.Item itemClip = abc.getItemAt(0);

                              String textt = itemClip.getText().toString();
                              output.setText(textt);
                              return true;



            case R.id.exit:
                Toast.makeText(getApplicationContext(), "Application has been exited", Toast.LENGTH_SHORT).show();
                finish();
                System.exit(0);


                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


}
