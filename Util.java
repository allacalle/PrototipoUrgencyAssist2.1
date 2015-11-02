package net.allacalle.android.prototipourgencyassist2;

import java.math.BigDecimal;

/**
 * Created by Alfonso on 21/09/2015.
 */
public final  class Util {

    private Util() {
    }


    //Para llamarlo seria Util.DevuelveUno()
    public static String funciono() {
        return "Funciono";
    }


    //Esta funcion elimina los corchetes y el nombre del parametro de un parametro de tipo Score
    public static String filtrarParametro (String Parametro)
    {
        int posicionInicial =0;
        int posicionFinal =0;
        String parametroFiltrado;

        for(int i=0;i < Parametro.length();i++)
        {
            if ( Parametro.charAt(i) == ']')
            {
                //Obtenemos la posicion donde se encontra el corchete
                posicionFinal = i;
            }

            if (Parametro.charAt(i) == '[')
            {
                //Obtenemos la posicion donde se encontra el corchete
                posicionInicial = i +1;
            }
        }

        parametroFiltrado =  Parametro.substring(posicionInicial, posicionFinal);

        return parametroFiltrado;

    }

    //Para que esta funcion de un valor acertado debe ser una Formula ScoreBCompleto
    // <valorMenor:punt,intervalo:punt,>valorMayor:punt
    public static String sacarValorMenorDeIntervalo (String parametroFiltrado)
    {

        //Primero tomamos la parte del condicion:score para  el parametro por ejemplo
        // <valorMenor:punt,intervalo:punt,>valorMayor:punt
        String condicionConScore [] =parametroFiltrado.split(",");

        // Tomamos solo la parte de <valorMenor de la cadena  <valorMenor:punt
        String  condicion [] = condicionConScore[0].split(":");
        //Tomamos la primera parte <valorMenor
        String valor = condicion[0];
        valor = valor.substring(1);
        //int valorMenor =0;
        // valorMenor = Integer.parseInt(valor);
        return  valor;

    }

    //Para que esta funcion de un valor acertado debe ser una Formula ScoreBCompleto
    // <valorMenor:punt,intervalo:punt,>valorMayor:punt

    public static String sacarValorMayorDeIntervalo (String parametroFiltrado)
    {

        //Primero tomamos la parte del condicion:score para  el parametro por ejemplo
        // <valorMenor:punt,intervalo:punt,>valorMayor:punt
        String condicionConScore [] =parametroFiltrado.split(",");

        // Tomamos solo la parte de <valorMenor de la cadena  >valorMenor:punt
        String  condicion [] = condicionConScore[2].split(":");
        //Tomamos la primera parte >valorMenor
        String valor = condicion[0];
        valor = valor.substring(1);

        return  valor;

    }

    //Para que esta funcion de un valor acertado debe ser una Formula ScoreBCompleto
    // <valorMenor:punt,intervalo:punt,>valorMayor:punt
    public static String crearFormatoIntervalo (String parametroFiltrado)
    {

        String valorMenor = sacarValorMenorDeIntervalo(parametroFiltrado);
        String valorMayor = sacarValorMayorDeIntervalo(parametroFiltrado);

        return "<= " +valorMayor+ " && " +valorMenor+ " <=" ;
    }

    //Para que esta funcion de un valor acertado debe ser una Formula ScoreBCompleto
    // <valorMenor:punt,intervalo:punt,>valorMayor:punt
    public static String cambiarFormatoIntervaloAParametroFiltrado (String parametroFiltrado )
    {
        String condicionConScore [] =parametroFiltrado.split(",");
        String valorIntervalo[] = condicionConScore[1].split(":");
        String puntuacionIntervalo = ":" + valorIntervalo[1] + "";
        String nuevoIntervalo = crearFormatoIntervalo(parametroFiltrado);


        return  "" +condicionConScore[0]+ "," +nuevoIntervalo+ "" + puntuacionIntervalo +  "," + condicionConScore[2] +""  ;
    }









}