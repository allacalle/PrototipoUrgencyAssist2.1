package net.allacalle.android.prototipourgencyassist2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Alfonso on 20/10/2015.
 */




public class Formula
{
    private Integer IdFormula;
    private String tipoFormula;
    private String nombreCompleto;
    private String abreviatura;
    private String expresion;
    private  Parametro [] parametros;
    private String resultado;

    public Formula(String idFormula, Context context)
    {

        FormulasSQLiteHelper usdbh =
                new FormulasSQLiteHelper(context ,"DBPrueba", null, 1);
        SQLiteDatabase db = usdbh.getReadableDatabase();

        //Inicializo el curso para recorrer las formulas
        Cursor cursorFormulas = db.rawQuery("SELECT NombreCompleto,Abreviatura,Expresion FROM Formulas  WHERE IdFormula = '" + idFormula + "'  ", null);
        cursorFormulas.moveToFirst();

        //Aignamos el id
        setIdFormula(Integer.parseInt(idFormula));

        //Asignamos el nombre completo
        setNombreCompleto(cursorFormulas.getString(0));
        //Asignamos la abreviatura
        setAbreviatura(cursorFormulas.getString(1));

        //Asignamo la expresion
        setExpresion(cursorFormulas.getString(2));

        //Cerramos el cursor de Formulas
        cursorFormulas.close();

        Cursor cursorParametros ;
        Cursor cursorCriterioPuntuacion;

        cursorParametros = db.rawQuery("SELECT  COUNT(*) -1 FROM Parametros WHERE IdFormula = "+ idFormula +"", null);
        cursorParametros.moveToFirst();

        int contadorParametros = Integer.parseInt(cursorParametros.getString(0));
        cursorParametros.close();


                //Usamos el cursor de Parametros para sacar los parametros de las formulas, contamos uno menos para excluir los parametros resultados
        cursorParametros = db.rawQuery(" SELECT  IdParametro,NombreParametro,TipoParametro,Medida  FROM Parametros WHERE IdFormula = "+ getIdFormula()+" ", null);

        //Nos movemos al primer campo del cursor.
        cursorParametros.moveToFirst();


        //Array de parametros donde iran los parametros de la formula
        Parametro parametroArray[] = new Parametro[contadorParametros] ;



        for (int i =0; i < contadorParametros; i++ )
        {
            Parametro parametroFormula = new Parametro();
            //Asignamos el identificador al parametro
            parametroFormula.setIdParametro(Integer.parseInt(cursorParametros.getString(0)));
            //Asignamos el nombre al parametro
            parametroFormula.setNombre(cursorParametros.getString(1));
            //Asignamos el tipo
            parametroFormula.setTipo(cursorParametros.getString(2));
            //Asignamos la medida
            parametroFormula.setMedida(cursorParametros.getString(3));

            //Obtenemos el numero de Criterios de Puntuacion para ese parametro
            cursorCriterioPuntuacion = db.rawQuery("SELECT  COUNT(*)  FROM CriterioPuntuacion WHERE IdParametro = "+ parametroFormula.getIdParametro() +"", null);
            cursorCriterioPuntuacion.moveToFirst();
            int contadorCriterioPuntuacion = Integer.parseInt(cursorCriterioPuntuacion.getString(0));
            cursorCriterioPuntuacion.close();
            cursorCriterioPuntuacion = db.rawQuery(" SELECT  IdCriterioPuntuacion,Criterio,Puntuacion  FROM CriterioPuntuacion WHERE IdParametro = "+ parametroFormula.getIdParametro() +" ", null);
            //Nos colocamos en el primer valor del criterio
            cursorCriterioPuntuacion.moveToFirst();
            CriterioPuntuacion criterioPuntuacionArray[] = new CriterioPuntuacion[contadorCriterioPuntuacion];

            for (int j =0; j < contadorCriterioPuntuacion; j++ )
            {
                CriterioPuntuacion criterioPuntuacionParametro = new CriterioPuntuacion();
                //Asignamos el identificador al criterio
                criterioPuntuacionParametro.setIdCriterioPuntuacion(cursorCriterioPuntuacion.getInt(0));
                //Asignamos el criterio
                criterioPuntuacionParametro.setCriterio(cursorCriterioPuntuacion.getString(1));
                //Asignamos el valor
                criterioPuntuacionParametro.setValor(cursorCriterioPuntuacion.getString(2));
                criterioPuntuacionArray[j] = criterioPuntuacionParametro;
                cursorCriterioPuntuacion.moveToNext();
            }

            //Metemos el array de criterios dentro del parametro
            parametroFormula.setCriterio(criterioPuntuacionArray);

            //Agregamos el parametro a un array de Parametros
            parametroArray[i] = parametroFormula;
            cursorParametros.moveToNext();
        }

        cursorParametros.close();
        //Asignamos a nuestra Formula el array de parametros creado anteriormente.
        setParametros(parametroArray);


    }
    //Aqui empiezan los getter y setters sencillos de la clase.

    public String getTipoFormula()
    {
        return tipoFormula;
    }

    public String getNombreCompleto()
    {
        return nombreCompleto;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public String getExpresion() {
        return expresion;
    }


    public void setTipoFormula(String tipoFormula) {
        this.tipoFormula = tipoFormula;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public void setExpresion(String expresion) {
        this.expresion = expresion;
    }


    public Parametro[] getParametros() {
        return parametros;
    }

    public void setParametros(Parametro[] parametros) {
        this.parametros = parametros;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public void setIdFormula(Integer idFormula) {
        IdFormula = idFormula;
    }

    public Integer getIdFormula() {
        return IdFormula;
    }

    public int buscarPosicionDeParametro (Integer idParametro)
    {
        int posicion =-1;

        for(int i =0; i < contarParametros();i++ )
        {
            if (parametros[i].getIdParametro().equals(idParametro) )
                posicion = i;
        }

       return posicion ;

    }

    public Parametro getParametro (Integer posicion)
    {
        return parametros[posicion];
    }

    //Aqui acaban los getter y setter sencillos de la clase


    /*

    PROC contarPametros() DEV int
    REQUIERE:
    MODIFICA:
    EFECTOS: Muestra el numero de parametros de una formula

     */

    public int contarParametros()
    {
        return parametros.length ;

    }




    //Funcion Rellenar formula que devuelva una Formula totalmente rellena.




}

