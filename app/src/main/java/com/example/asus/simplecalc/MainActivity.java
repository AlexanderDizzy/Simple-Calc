package com.example.asus.simplecalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editText1, editText2;
    Button buttonadd, buttonminus, buttonprod, buttondel, buttonstep;
    TextView textView;
    String sigh;
    final int MENU_RESET_ID = 1;
    final int MENU_QUIT_ID = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);

        buttonadd = (Button) findViewById(R.id.buttonadd);
        buttonminus = (Button) findViewById(R.id.buttonminus);
        buttonprod = (Button) findViewById(R.id.buttonprod);
        buttondel = (Button) findViewById(R.id.buttondel);
        buttonstep = (Button) findViewById(R.id.buttonstep);

        textView = (TextView) findViewById(R.id.textView);

        buttonadd.setOnClickListener(this);
        buttonminus.setOnClickListener(this);
        buttonprod.setOnClickListener(this);
        buttondel.setOnClickListener(this);
        buttonstep.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        double numberone = 0;
        double numbertwo = 0;
        double result = 0;

        if (TextUtils.isEmpty(editText1.getText().toString())
                || (TextUtils.isEmpty(editText1.getText().toString()))){
            return ;
        }

        numberone = Float.parseFloat(editText1.getText().toString());
        numbertwo = Float.parseFloat(editText2.getText().toString());

        switch (v.getId()){
            case R.id.buttonadd:
                sigh="+";
                result=numberone+numbertwo;
                break;
            case R.id.buttonminus:
                sigh="-";
                result=numberone-numbertwo;
                break;
            case R.id.buttonprod:
                sigh="x";
                result=numberone*numbertwo;
                break;
            case R.id.buttondel:
                sigh="/";
                result=numberone/numbertwo;
                break;
            case R.id.buttonstep:
                sigh="^";
                result=Math.pow(numberone,numbertwo);
                default:
                    break;

        }
        textView.setText(numberone+" " + sigh+ " " + numbertwo + " = " + result);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_RESET_ID, 0,"Reset" );
        menu.add(0, MENU_QUIT_ID, 0,"Quit" );
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case MENU_RESET_ID:
                editText1.setText("");
                editText2.setText("");
                textView.setText("");
                break;
            case MENU_QUIT_ID:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
