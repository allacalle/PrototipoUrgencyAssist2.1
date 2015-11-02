package net.allacalle.android.prototipourgencyassist2;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class FormulasSQLiteHelper extends SQLiteOpenHelper {

    //Sentencia SQL para crear la tabla de Usuarios
    String sqlCreateFormula = "CREATE TABLE Formulas ( IdFormula INTEGER,NombreCompleto TEXT, Abreviatura TEXT, Expresion TEXT)";
    String sqlCreateParametro = "CREATE TABLE Parametros (IdParametro INTEGER, NombreParametro TEXT, IdFormula Integer, TipoParametro TEXT, Medida TEXT) ";
    String sqlCreateCriterioPuntuacion = "CREATE TABLE CriterioPuntuacion(IdCriterioPuntuacion INTEGER, IdParametro INTEGER, Criterio TEXT, Puntuacion TEXT)";




    public FormulasSQLiteHelper(Context contexto, String nombre,
                                CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Se ejecuta la sentencia SQL de creaci�n de la tabla
        db.execSQL(sqlCreateFormula);
        db.execSQL(sqlCreateParametro);
        db.execSQL(sqlCreateCriterioPuntuacion);
        //Este comentario deberia borrarse
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        //NOTA: Por simplicidad del ejemplo aqu� utilizamos directamente la opci�n de
        //      eliminar la tabla anterior y crearla de nuevo vac�a con el nuevo formato.
        //      Sin embargo lo normal ser� que haya que migrar datos de la tabla antigua
        //      a la nueva, por lo que este m�todo deber�a ser m�s elaborado.

        //Se elimina la versi�n anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS Formulas");
        db.execSQL("DROP TABLE IF EXISTS Parametros");
        db.execSQL("DROP TABLE IF EXISTS CriterioPuntuacion");

        onCreate(db);

    }
}