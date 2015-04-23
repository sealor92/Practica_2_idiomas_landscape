package sebastianalarcon.com.punto4;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    int bandera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView result =(TextView) findViewById(R.id.resultado);
        final TextView text1=(TextView) findViewById(R.id.t1);
        final TextView text2=(TextView) findViewById(R.id.t2);
        final EditText edit1=(EditText) findViewById(R.id.e1);
        final EditText edit2=(EditText) findViewById(R.id.e2);
        Button boton = (Button) findViewById(R.id.boton);

        text1.setVisibility(View.GONE);
        text2.setVisibility(View.GONE);
        edit1.setVisibility(View.GONE);
        edit2.setVisibility(View.GONE);

        /*switch(bandera)
        {
            case 1:
                text1.setVisibility(View.VISIBLE);
                text1.setText("Radio:");
                break;
            case 2:
                text1.setVisibility(View.VISIBLE);
                text1.setText("Lado:");
                break;
            case 3:
                text1.setVisibility(View.VISIBLE);
                text2.setVisibility(View.VISIBLE);
                text1.setText("Base:");
                text2.setText("Altura:");
                break;
            case 4:
                text1.setVisibility(View.VISIBLE);
                text2.setVisibility(View.VISIBLE);
                text1.setText("Lado 1:");
                text2.setText("Lado 2:");
                break;
            default:
                text1.setVisibility(View.GONE);
                text2.setVisibility(View.GONE);
        }*/



        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double resultado;
                switch(bandera)
                {
                    case 1:
                        if(edit1.getText().toString().isEmpty()==false) {
                            resultado = Math.PI * Math.pow(Double.valueOf(edit1.getText().toString()), 2);
                            result.setText(String.valueOf(resultado));
                        }
                        else
                            result.setText("Ingrese el radio");
                        break;
                    case 2:
                        if(edit1.getText().toString().isEmpty()==false) {
                            resultado = Double.valueOf(edit1.getText().toString()) * Double.valueOf(edit1.getText().toString());
                            result.setText(String.valueOf(resultado));
                        }
                        else
                            result.setText("Ingrese el lado");
                        break;
                    case 3:
                        if(edit1.getText().toString().isEmpty()==false && edit2.getText().toString().isEmpty()==false) {
                            resultado = (Double.valueOf(edit1.getText().toString()) * Double.valueOf(edit2.getText().toString())) / 2;
                            result.setText(String.valueOf(resultado));
                        }
                        else
                            result.setText("Faltan datos por ingresar");
                        break;
                    case 4:
                        if(edit1.getText().toString().isEmpty()==false && edit2.getText().toString().isEmpty()==false) {
                            resultado = Double.valueOf(edit1.getText().toString()) * Double.valueOf(edit2.getText().toString());
                            result.setText(String.valueOf(resultado));
                        }
                        else
                            result.setText("Faltan datos por ingresar");
                        break;
                    default:
                        result.setText("Elija una de las 4 opciones");
                }

            }
        });
    }


    public void onRadioButtonClicked(View view) {
        final TextView result=(TextView) findViewById(R.id.resultado);
        final TextView text1=(TextView) findViewById(R.id.t1);
        final TextView text2=(TextView) findViewById(R.id.t2);
        final EditText edit1=(EditText) findViewById(R.id.e1);
        final EditText edit2=(EditText) findViewById(R.id.e2);
        Button boton = (Button) findViewById(R.id.boton);

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        result.setText(" ");
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rcirculo:
                if (checked)
                    bandera = 1;
                    text2.setVisibility(View.GONE);
                    text1.setVisibility(View.VISIBLE);
                    edit2.setVisibility(View.GONE);
                    edit1.setVisibility(View.VISIBLE);
                    text1.setText("Radio:");
                break;
            case R.id.rcuadrado:
                if (checked)
                    bandera = 2;
                    text2.setVisibility(View.GONE);
                    text1.setVisibility(View.VISIBLE);
                    edit2.setVisibility(View.GONE);
                    edit1.setVisibility(View.VISIBLE);
                    text1.setText("Lado:");
                break;
            case R.id.rtriangulo:
                if (checked)
                    bandera = 3;
                    text1.setVisibility(View.VISIBLE);
                    text2.setVisibility(View.VISIBLE);
                    edit2.setVisibility(View.VISIBLE);
                    edit1.setVisibility(View.VISIBLE);
                    text1.setText("Base:");
                    text2.setText("Altura:");
                break;
            case R.id.rrectangulo:
                if (checked)
                    bandera = 4;
                    text1.setVisibility(View.VISIBLE);
                    text2.setVisibility(View.VISIBLE);
                    edit2.setVisibility(View.VISIBLE);
                    edit1.setVisibility(View.VISIBLE);
                    text1.setText("Lado 1:");
                    text2.setText("Lado 2:");
                break;
            default:
                text1.setVisibility(View.GONE);
                text2.setVisibility(View.GONE);
                edit1.setVisibility(View.GONE);
                edit2.setVisibility(View.GONE);

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
