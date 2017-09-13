package neit.IntentPractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity { // control o  onActivityResult

    private static final int REQUEST_CODE = 10; ////////

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) { ////////
            //need to check if you have data
        if(data.hasExtra("returnkey")){
            String result = data.getExtras().getString("returnkey");
            Toast.makeText(this,result, Toast.LENGTH_LONG).show();
        }


        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


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

    public void GoToResult(View view){    ///////////////
        EditText txt1 = (EditText)findViewById(R.id.txt1);
        String passTest = txt1.getText().toString();
        Intent i = new Intent(this, neit.IntentPractice.ResultActivity.class);
        i.putExtra("yourkey", passTest);
        startActivityForResult(i,REQUEST_CODE);
    }

}
