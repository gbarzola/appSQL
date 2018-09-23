package app.upc.com.appsql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static app.upc.com.appsql.Constants.*;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME , factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLA_TELEFONOS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITULO + " TEXT, " +
                COLUMN_TELEFONO + " TEXT " +
                ");";

        sqLiteDatabase.execSQL(query);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLA_TELEFONOS);
        onCreate(sqLiteDatabase);
    }

    //CRUD Telefono

    //Añadir
    public void addTelefono(Telefono telefonos) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_TITULO, telefonos.getTitulo());
        values.put(COLUMN_TELEFONO, telefonos.getTelefono());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLA_TELEFONOS, null, values);
        db.close();

    }

    //Actualizar
    public void updateTelefono(Telefono telefonos){
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITULO, telefonos.getTitulo());
        values.put(COLUMN_TELEFONO, telefonos.getTelefono());
        SQLiteDatabase db = getWritableDatabase();
        db.update(TABLA_TELEFONOS, values, COLUMN_ID + "= ?", new String[] { String.valueOf(telefonos.getId())});
        db.close();

    }

    //Borrar
    public void borrarTelefono(int persona_id){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLA_TELEFONOS + " WHERE " + COLUMN_ID + " = " + persona_id + ";");
        db.close();
    }

    //Listar todos
    public Cursor listarTelefonos(){
        SQLiteDatabase db = getReadableDatabase();
        String query = ("SELECT * FROM " + TABLA_TELEFONOS + " WHERE 1 ORDER BY " + COLUMN_TITULO + ";");
        Cursor c = db.rawQuery(query, null);

        if (c != null) {
            c.moveToFirst();
        }

        return c;
    }
}
