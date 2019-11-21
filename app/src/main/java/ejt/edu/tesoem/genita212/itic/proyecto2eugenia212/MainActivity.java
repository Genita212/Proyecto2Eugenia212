package ejt.edu.tesoem.genita212.itic.proyecto2eugenia212;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText txt;
    Button save;
    Spinner opcion;

    ArrayList<String> addArray = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt=(EditText)findViewById(R.id.txtInColor);
        save=(Button)findViewById(R.id.btnEnviar);
        opcion=(Spinner)findViewById(R.id.Colores);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, addArray);
        opcion.setAdapter(adapter);
        opcion.setPrompt("Muestra las opciones");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = txt.getText().toString();
                if(addArray.contains(getInput)){
                    Toast.makeText(getBaseContext(),"Elemento ya existente", Toast.LENGTH_SHORT).show();
                }
                else if(getInput.trim().equals("")){
                    Toast.makeText(getBaseContext(),"Debes de ingresar un color", Toast.LENGTH_SHORT).show();
                }
                else if(!addArray.contains(getInput)){
                    addArray.add(getInput);
                    ((EditText)findViewById(R.id.txtInColor)).setText("");
                }
            }
        });
    }
}
