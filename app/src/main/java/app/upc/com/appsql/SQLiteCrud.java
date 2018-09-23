package app.upc.com.appsql;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import static app.upc.com.appsql.Constants.COLUMN_TELEFONO;
import static app.upc.com.appsql.Constants.COLUMN_TITULO;
import static app.upc.com.appsql.Constants.TABLA_TELEFONOS;

public class SQLiteCrud {

    private String table;
    private SQLiteDatabase db;

    public SQLiteCrud(SQLiteDatabase db) {
        this.db = db;
    }

    public void select(){

    }

    public void insert(){

    }

    public void update(){

    }

    public void delete(){

    }

    public String registrarTelefono(String table, Telefono telefono){
        this.table = table;
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITULO, telefono.getTitulo());
        values.put(COLUMN_TELEFONO, telefono.getTelefono());
        return  String.valueOf(db.insert(TABLA_TELEFONOS, null, values));
    }
}
