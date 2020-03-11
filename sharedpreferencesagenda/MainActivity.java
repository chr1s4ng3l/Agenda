package google.tamayo.christopher.sharedpreferencesagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre, etDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etDatos=(EditText)findViewById(R.id.txt_datos);
        etNombre=(EditText)findViewById(R.id.txt_nombre);
    }
    public void Guardar(View view){
        String Nombre = etNombre.getText().toString();
        String Datos = etDatos.getText().toString();

        SharedPreferences preferences = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor= preferences.edit();
        obj_editor.putString(Nombre, Datos);
        obj_editor.commit();
        Toast.makeText(this, "El contacto ha sido guardado", Toast.LENGTH_SHORT).show();
    }
    public void Buscar(View view){
        String nombre = etNombre.getText().toString();


        SharedPreferences preferences = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String datos = preferences.getString(nombre,"");

        if(datos.length()==0){
            Toast.makeText(this, "No se encontro el contacto", Toast.LENGTH_SHORT).show();

        }else{
            etDatos.setText(datos);
        }
    }
}
