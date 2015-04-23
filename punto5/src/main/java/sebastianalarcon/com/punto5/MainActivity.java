package sebastianalarcon.com.punto5;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    int bandera=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText eNombre=(EditText) findViewById(R.id.eNombre);
        final EditText eCorreo=(EditText) findViewById(R.id.eCorreo);
        final EditText eTelefono=(EditText) findViewById(R.id.eTelefono);
        final TextView tName= (TextView) findViewById(R.id.tNombre);
        final TextView tMail= (TextView) findViewById(R.id.tCorreo);
        final TextView tTel= (TextView) findViewById(R.id.tTelefono);
        final TextView tSexo= (TextView) findViewById(R.id.tSexo);
        final TextView tHobbies=(TextView) findViewById(R.id.tHobbies);
        Button boton=(Button) findViewById(R.id.boton);
        final CheckBox check1=(CheckBox) findViewById(R.id.check1);
        final CheckBox check2=(CheckBox) findViewById(R.id.check2);
        final CheckBox check3=(CheckBox) findViewById(R.id.check3);
        final CheckBox check4=(CheckBox) findViewById(R.id.check4);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cadena="";

                tName.setText(eNombre.getText());
                tMail.setText(eCorreo.getText());
                tTel.setText(eTelefono.getText());

                if(bandera==1)
                    tSexo.setText("Masculino");
                else
                    if(bandera==2)
                        tSexo.setText("Femenino");

                if(check1.isChecked())
                    cadena=cadena+"-VideoJuegos-";
                if(check2.isChecked())
                    cadena=cadena+"-Deportes-";
                if(check3.isChecked())
                    cadena=cadena+"-Ciencia-";
                if(check4.isChecked())
                    cadena=cadena+"-Automoviles-";

                if(check1.isChecked() || check2.isChecked() || check3.isChecked() || check4.isChecked())
                    tHobbies.setText(cadena);
                else
                    tHobbies.setText("No se ingresaron Hobbies");


            }
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rmasculino:
                if (checked)
                    bandera=1;
                break;
            case R.id.rfemenino:
                if (checked)
                    bandera=2;
                break;
        }
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
