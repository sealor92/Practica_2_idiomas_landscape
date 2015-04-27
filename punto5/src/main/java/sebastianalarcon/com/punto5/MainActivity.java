package sebastianalarcon.com.punto5;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;


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
        final TextView tCiudad=(TextView) findViewById(R.id.tCiudad);
        final TextView tHobbies=(TextView) findViewById(R.id.tHobbies);
        Button boton=(Button) findViewById(R.id.boton);
        final CheckBox check1=(CheckBox) findViewById(R.id.check1);
        final CheckBox check2=(CheckBox) findViewById(R.id.check2);
        final CheckBox check3=(CheckBox) findViewById(R.id.check3);
        final CheckBox check4=(CheckBox) findViewById(R.id.check4);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.ciudades, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cadena="Hobbies:";

                tName.setText("Nombre:"+eNombre.getText());
                tMail.setText("Correo:"+eCorreo.getText());
                tTel.setText("Telefono:"+eTelefono.getText());

                if(bandera==1)
                    tSexo.setText("Sexo:Masculino");
                else
                    if(bandera==2)
                        tSexo.setText("Sexo:Femenino");

                tCiudad.setText("Ciudad:"+spinner.getSelectedItem().toString());

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
                    tHobbies.setText("Hobbies: No se ingresaron Hobbies");


            }
        });
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker

            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it

            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            final TextView tFecha = (TextView) getActivity().findViewById(R.id.tFecha);
            //System.out.println(day);
            String smonth = "";
            final String syear = String.valueOf(year);
            final String sday = String.valueOf(day);
            if(month==0){smonth="Enero";}
            if(month==1){smonth="Febrero";}
            if(month==2){smonth="Marzo";}
            if(month==3){smonth="Abril";}
            if(month==4){smonth="Mayo";}
            if(month==5){smonth="Junio";}
            if(month==6){smonth="Julio";}
            if(month==7){smonth="Agosto";}
            if(month==8){smonth="Septiembre";}
            if(month==9){smonth="Octubre";}
            if(month==10){smonth="Noviembre";}
            if(month==11){smonth="Diciembre";}
            Button bFecha = (Button) getActivity().findViewById(R.id.bFecha);
            final String finalSmonth = smonth;
            // btnsubmit.setOnClickListener(new View.OnClickListener() {
            //  @Override
            //   public void onClick(View v) {
            tFecha.setText("Fecha de Nacimiento:"+sday+" / "+ finalSmonth +" / "+syear);
            // }
            //});
        }
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(),"datePicker");

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
