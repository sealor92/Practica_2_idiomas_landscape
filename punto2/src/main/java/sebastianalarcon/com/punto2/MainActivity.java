package sebastianalarcon.com.punto2;

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
    int bandera=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText eNum1=(EditText) findViewById(R.id.eNum1);
        final EditText eNum2=(EditText) findViewById(R.id.eNum2);
        final TextView tResultado=(TextView) findViewById(R.id.tResultado);
        Button boton = (Button) findViewById(R.id.boton);


        boton.setOnClickListener(new View.OnClickListener()
                {
                        public void onClick(View v)
                        {
                            double num1=0,num2=0;
                            int error=0;
                            if(eNum1.getText().toString().isEmpty()==false && eNum2.getText().toString().isEmpty()==false) {
                                 num1 = Double.parseDouble(eNum1.getText().toString());
                                 num2 = Double.parseDouble(eNum2.getText().toString());
                            }
                            else
                                error = 1;

                            if(error==0) {
                                if (bandera == 1) {
                                    double result = num1 + num2;
                                    tResultado.setText(String.valueOf(result));
                                }

                                if (bandera == 2) {
                                    double result = num1 - num2;
                                    tResultado.setText(String.valueOf(result));
                                }

                                if (bandera == 3) {
                                    double result = num1 * num2;
                                    tResultado.setText(String.valueOf(result));
                                }

                                if (bandera == 4) {
                                    if (num2 == 0)
                                        tResultado.setText("Error->División por cero no esta permitida");
                                    else {
                                        double result = num1 / num2;
                                        tResultado.setText(String.valueOf(result));
                                    }
                                }
                            }
                            else
                            {
                                tResultado.setText("Por favor ingrese todos los numeros");
                                error=0;
                            }

                        }
                });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rsuma:
                if (checked)
                    bandera=1;
                break;
            case R.id.rresta:
                if (checked)
                    bandera=2;
                break;
            case R.id.rmultiplicacion:
                if (checked)
                    bandera=3;
                break;
            case R.id.rdivision:
                if (checked)
                    bandera=4;
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
