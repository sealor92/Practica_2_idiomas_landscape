package sebastianalarcon.com.punto3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"onCreate()",Toast.LENGTH_SHORT).show();

        final EditText eQuices=(EditText) findViewById(R.id.eQuices);
        final EditText eExposiciones=(EditText) findViewById(R.id.eExposiciones);
        final EditText ePracticas=(EditText) findViewById(R.id.ePracticas);
        final EditText eProyecto=(EditText) findViewById(R.id.eProyecto);
        final TextView nota_final=(TextView) findViewById(R.id.nota_final);
        Button boton = (Button) findViewById(R.id.boton);


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double temp,nota1,nota2,nota3,nota4;
                if(eQuices.getText().toString().isEmpty()==false && eQuices.getText().toString().isEmpty()==false && eQuices.getText().toString().isEmpty()==false && eQuices.getText().toString().isEmpty()==false) {
                    nota1=Double.parseDouble(eQuices.getText().toString());
                    nota2=Double.parseDouble(eExposiciones.getText().toString());
                    nota3=Double.parseDouble(ePracticas.getText().toString());
                    nota4=Double.parseDouble(eProyecto.getText().toString());

                    if(nota1<=5 && nota2<=5 && nota3<=5 && nota4<=5) {
                        temp = nota1 * 0.15 + nota2 * 0.10 + nota3 * 0.40 + nota4 * 0.35;
                        nota_final.setText(String.valueOf(temp));
                    }
                    else
                        nota_final.setText("Las notas deben ser menores a 5.0");
                }
                else
                    nota_final.setText("Ingrese todas las notas");
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart()",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestart()",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume()",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop()",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"onDestroy()",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"onPause()",Toast.LENGTH_SHORT).show();
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
       switch(id)
       {
           case R.id.settings:
               Intent s = new Intent(this, SettingsActivity.class);
               s.putExtra("pQuiz",15);
               s.putExtra("pExp",10);
               s.putExtra("pPra",40);
               s.putExtra("pPro",30);
               startActivityForResult(s,1234);
               return true;

           case R.id.aboutUs:
               Intent i = new Intent(this,AboutActivity.class);
               startActivity(i);
               return true;

       }

        return super.onOptionsItemSelected(item);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode ==1234 && resultCode== RESULT_OK){
            String quiz = data.getExtras().getString("prQuiz");
            String expo = data.getExtras().getString("prExp");
            String prac = data.getExtras().getString("prPra");
            String proy = data.getExtras().getString("prPro");

            Toast.makeText(this,"Quiz: "+ quiz +"Expo: "+ expo +"Practica: "+ prac +"Proyecto:"+ proy,Toast.LENGTH_SHORT).show();
        }



    }
}
