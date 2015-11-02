package net.allacalle.android.prototipourgencyassist2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Detalles extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        //Recuperamos la información pasada en el intent
        Bundle bundle = this.getIntent().getExtras();

        //Construimos el mensaje a mostrar
        final String valorRecibido = bundle.getString("NOMBRE");

        //creamos el layout dinamico como pros!
        final LinearLayout lm = (LinearLayout) findViewById(R.id.LytContenedorDetalles);



        // Para obtener el tipo de cada formula deberiamos movernos al cursor de cada formula y obtener el getString(1);
        //Abro la base de datos.
        FormulasSQLiteHelper usdbh =
                new FormulasSQLiteHelper(this, "DBPrueba", null, 1);

        SQLiteDatabase db = usdbh.getReadableDatabase();

        //creamos un cursos, en el string(0) tenemos el parametro, en el string(1) tenemos el tipo de formula
        Cursor c = db.rawQuery("SELECT IdFormula,NombreCompleto,Expresion FROM Formulas  WHERE Abreviatura = '" + valorRecibido + "'  ", null);
        c.moveToFirst();
        //Cogemos el identificador de la formula
        String idFormula = c.getString(0);
        //Cogemos el nombre completo de la formula
        String nombreFormula = c.getString(1);

        //Obtenemos la expresion de esa formula si la tiene sino simplemente obtendra null
        final String expresion = c.getString(2);

        c.close();
        //Creamos la formula con la que trabajaremos
        final Formula formulaActual = new Formula(idFormula,getBaseContext());


        //Evaluamos si el tipo de la formula es escala

        if ( formulaActual.getExpresion().equals("escala") )
        {

        }

        //Sino será de tipo generico
        else
        {
            final List<EditText> allEds = new ArrayList<EditText>();
            final int numeroParametros = formulaActual.contarParametros();

            for(int i=0;i< numeroParametros ; i++)
            {
                //Creamos un campo para el nombre del parametro
                TextView label = new TextView(this);
                label.setText(formulaActual.getParametro(i).getNombre());
                //creamos un campo de texto para introducir el valor del parametro
                EditText ed;
                ed = new EditText(this);
                allEds.add(ed);
                ed.setId( formulaActual.getParametro(i).getIdParametro() );
                //Mostrar solo teclado numerico
                ed.setInputType(InputType.TYPE_CLASS_PHONE);
                lm.addView(label);
                lm.addView(ed);
            }

            Button botonEcuacion = new Button(this);
            botonEcuacion.setText("Calcular formula");
            lm.addView(botonEcuacion);
            final TextView mensaje = new TextView(this);
            lm.addView(mensaje);
            final int[] valorI = {0};

            botonEcuacion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //Primero vamos a comprobar que no se han dejado valores en blanco en el formulario
                    boolean valoresEnBlanco = false;
                    String cadenaEvaluar;
                    for (int i = 0; i < numeroParametros; i++) {
                        cadenaEvaluar = allEds.get(i).getText().toString();
                        //Ponemos el valor del campo en cada parametro
                        formulaActual.getParametro(i).setValor(cadenaEvaluar);
                        if (cadenaEvaluar.equals(""))
                            valoresEnBlanco = true;
                    }

                    //Si el formulario tiene valores sin rellenar.
                    if (valoresEnBlanco) {
                        mensaje.setText("No es posible calcular la formula con valores en blanco");
                    } else {
                        Expression expression = new Expression(formulaActual.getExpresion());


                        for (int i = 0; i < numeroParametros; i++) {

                            if(i == 0 )
                                expression.with(formulaActual.getParametro(i).getNombre(), formulaActual.getParametro(i).getValor() );
                            else
                                expression.and(formulaActual.getParametro(i).getNombre(), formulaActual.getParametro(i).getValor());

                            valorI[0] =i;
                        }

                        //mensaje.setText("Primer parametro" + formulaActual.getParametro(0).getNombre() +  " su valor" +formulaActual.getParametro(0).getValor()+ ". Segundo parametro" +formulaActual.getParametro(1).getNombre()+ " su valor" +formulaActual.getParametro(1).getValor()+ " y la i llego hasta"  + valorI[0] + ""  );
                        //BigDecimal resultadoEcuacion = expression.eval();
                        mensaje.setText( expression.eval().toString() );
                    }
                }
            });


        }

        //Si es tipo generica la tratamos de una forma
            //Creamos campos editText y metemos el nombre de los parametros en ellos.
            //Se crea un boton que calcule la formula dependiendo del tiempo y evaluando sus campos.


        //Si es tipo escala la tratamos de otra forma.
            //Creamos contenedores para los campos EditText y los campos RadioGroup
            //Vemos que tipo de escala es

            //Si es tipo A
                //Creamos botones radiales y metemos el nombre de los parametros y sus valores en ellos.


            //Si es tipo B
                //Creamos campos editText y metemos el nombre de los parametros en ellos.

/*
        //Se muestra el titulo de la formula.
        //String cadena ="";
        //TextView titulo = new TextView(this);
        //titulo.setText("La formula es" + formulaActual.getIdFormula() + " su nombre completo es " +formulaActual.getNombreCompleto() + " y su expresion es " + formulaActual.getExpresion() +   " el nombre de su primer parametro es"
                //+ formulaActual.getParametro(0).getNombre() + " su primer criterio es " + formulaActual.getParametro(0).getCriterioPuntuacion(0).getCriterio()  +   " "  );
        //titulo.setText(" El primer parametro encontra tiene id " + formulaActual.getParametro(1).getIdParametro() + " .");

        TextView titulo2 = new TextView(this);
        titulo2.setText("");
        lm.addView(titulo);
        lm.addView(titulo2);

        */

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detalles, menu);
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
