package sebastianalarcon.com.punto3;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;


public class SettingsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        final EditText Quiz = (EditText) findViewById(R.id.eQuices_settings);
        final EditText Expo = (EditText) findViewById(R.id.eExposiciones_settings);
        final EditText Pract = (EditText) findViewById(R.id.ePracticas_settings);
        final EditText Proy = (EditText) findViewById(R.id.eProyecto_settings);
        final Button calcular =(Button) findViewById(R.id.boton_settings);

        Bundle extras=getIntent().getExtras();
        Quiz.setText(String.valueOf(extras.getInt("pQuiz")));
        Expo.setText(String.valueOf(extras.getInt("pExp")));
        Pract.setText(String.valueOf(extras.getInt("pPra")));
        Proy.setText(String.valueOf(extras.getInt("pPro")));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
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
