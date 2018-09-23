package app.upc.com.appsql;


import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private AlertDialog dialog;
    private AlertDialog.Builder builder;
    private View view;
    private Button agregar_telefono, ordenar_telefonos;
    private EditText titulo_input;
    private EditText telefono_input;
    DbHelper dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titulo_input = findViewById(R.id.et_titulo);
        telefono_input = findViewById(R.id.et_telefono);
        dbHandler = new DbHelper(this, null, null, 1);

        agregar_telefono.setOnClickListener(this);
        ordenar_telefonos.setOnClickListener(this);

    }

    public void onClick(View v){

        switch (v.getId()) {
            case R.id.agregar_telefono:
                dialog.hide();
                builder = new AlertDialog.Builder(MainActivity.this,R.style.CustomDialog);
                view = getLayoutInflater().inflate(R.layout.view_crear_telefono,null,false);
                Button aceptar = view.findViewById(R.id.aceptar_nuevo_telefono);
                Button cancelar = view.findViewById(R.id.cancelar_crear_telefono);
                titulo_input = view.findViewById(R.id.et_titulo);
                telefono_input = view.findViewById(R.id.et_telefono);
                aceptar.setOnClickListener(this);
                cancelar.setOnClickListener(this);
                builder.setView(view);
                dialog = builder.create();
                dialog.setCancelable(false);
                dialog.show();

                break;
            case R.id.ordenar_telefonos:

        }
    }



}
