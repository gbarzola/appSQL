package app.upc.com.appsql;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static app.upc.com.appsql.Constants.*;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AlertDialog dialog;
    private AlertDialog.Builder builder;
    private View view;
    private Button agregar_telefono, ordenar_telefonos;
    private EditText titulo_input;
    private EditText telefono_input;
    private SQLiteDatabase basedatos;
    private SQLiteCrud sqLiteCrud;
    private Cursor cursor;
    DbHelper dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titulo_input = findViewById(R.id.et_titulo);
        telefono_input = findViewById(R.id.et_telefono);
        dbHandler = new DbHelper(this, null, null, 1);
        agregar_telefono = findViewById(R.id.agregar_telefono);
        ordenar_telefonos = findViewById(R.id.ordenar_telefonos);
        agregar_telefono.setOnClickListener(this);
        ordenar_telefonos.setOnClickListener(this);

        // CREACION DE LA BASE DE DATOS
        SQLiteHelper administrador = new SQLiteHelper(this,Constants.DATABASE_NAME,null,1);
        basedatos = administrador.getWritableDatabase();
        sqLiteCrud = new SQLiteCrud(basedatos);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.agregar_telefono:
                limpiarDialogos();
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
                break;
            case R.id.aceptar_nuevo_telefono:
                if(titulo_input.getText().toString().trim().equals("") || telefono_input.getText().toString().trim().equals("")){
                    Toast.makeText(getApplicationContext(),"Campos vacios",Toast.LENGTH_LONG).show();
                }else{
                    Telefono telf = new Telefono(titulo_input.getText().toString().trim(),telefono_input.getText().toString().trim());
                    String respuesta = sqLiteCrud.registrarTelefono(TABLA_TELEFONOS,telf);
                    Toast.makeText(getApplicationContext(),respuesta,Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.cancelar_crear_telefono:
                limpiarDialogos();
                break;
            default:
                break;
        }
    }

    public void limpiarDialogos(){
        if (dialog!= null){
            dialog.hide();
        }
    }
}
