package neit.IntentPractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {  // control O highlight and find finish void

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
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

        Bundle extras = getIntent().getExtras();  ////////
        String inputstring = extras.getString("yourkey"); // if had more than 1 need extra Strings
        TextView mytext = (TextView)findViewById(R.id.textView);  ///////////
        mytext.setText(inputstring);  /////////////



    }

    @Override

    public void finish() {  /////////////
        Intent i = new Intent();  // create intent
        EditText mytext = (EditText)findViewById(R.id.txt2); // put data in it
        String ResultString = mytext.getText().toString();
        i.putExtra("returnkey",ResultString);
        setResult(RESULT_OK, i);
        super.finish();

    }

    public void GoBack(View view){  ///////////////
        finish();



    }
}
