package net.allacalle.android.prototipourgencyassist2;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.math.BigDecimal;


public class MainActivity extends ActionBarActivity {
    //private TextView txtNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creamos el layout dinamico como pros!
        final LinearLayout lm = (LinearLayout) findViewById(R.id.LytContenedor);

        //Abrimos la base de datos 'DBUsuarios' en modo escritura
        FormulasSQLiteHelper usdbh =
                new FormulasSQLiteHelper(this, "DBPrueba", null, 1);

        SQLiteDatabase db = usdbh.getWritableDatabase();


        //Si hemos abierto correctamente la base de datos


        if(db != null)
        {
            Cursor c = db.rawQuery(" SELECT  COUNT(*) FROM Formulas  ", null);
            c.moveToFirst();
            String nCampos = c.getString(0);
            //Vamos a ponerle a un nombre el resultado de un select
            //txtNombre = (TextView)findViewById(R.id.TxtNombre);
            //txtNombre.setText(nCampos);

            //Comprobamos si la tabla esta vacia. Insertamos solo el listado de formulas
            // en una tabla vacia.

            //Esta vacio pues insertamos

            //Mucho cuidado con los espacios en blanco entre parametros

            if( nCampos.equals("0") )
            {
                db.execSQL("INSERT INTO Formulas (IdFormula,NombreCompleto,Abreviatura,Expresion)  VALUES ('1','Child- Pugh(con birumina total no colestatica)','Child-Pugh','escala');");
                db.execSQL("INSERT INTO Formulas (IdFormula,NombreCompleto,Abreviatura,Expresion)  VALUES ('2','Glasgow, Escala de Coma','Glasgow','escala');");
                db.execSQL("INSERT INTO Formulas (IdFormula,NombreCompleto,Abreviatura,Expresion)  VALUES ('3','CHA2DS2-VASc, Escala de Riesgo de AVC por Fibrilacion Atrial','CHA2DS2-VASc','escala');");
                db.execSQL("INSERT INTO Formulas (IdFormula,NombreCompleto,Abreviatura,Expresion)  VALUES ('4','Pneumonia Severity Index diagnostico inicial','PSI inicial','escala');");
                db.execSQL("INSERT INTO Formulas (IdFormula,NombreCompleto,Abreviatura,Expresion)  VALUES ('5','Pneumonia Severity Index puntuacion','PSI puntuacion','escala');");
                db.execSQL("INSERT INTO Formulas (IdFormula,NombreCompleto,Abreviatura,Expresion)  VALUES ('6','TIMI indice de Riesgo','TIMI','(FC * edad/10) /PS');");
                db.execSQL("INSERT INTO Formulas (IdFormula,NombreCompleto,Abreviatura,Expresion)  VALUES ('7','Wells Score para Embolismo Pulmonar','Wells Score Embolismo','escala');");
                db.execSQL("INSERT INTO Formulas (IdFormula,NombreCompleto,Abreviatura,Expresion)  VALUES ('8','Wells, Score para Trombosis Venosa Profunda','Wells Score Trombosis','escala');");
                db.execSQL("INSERT INTO Formulas (IdFormula,NombreCompleto,Abreviatura,Expresion)  VALUES ('9','BUN:Creatinina (S) relacion','BUN','Urea/2.14');");
                db.execSQL("INSERT INTO Formulas (IdFormula,NombreCompleto,Abreviatura,Expresion)  VALUES ('10','Aclaramiento de creatinina, formula de Cockcroft-Gault (hombre)','Aclaramiento de creatinina (hombre)','((140-Edad)*Peso)/(Crp*72)');");
                db.execSQL("INSERT INTO Formulas (IdFormula,NombreCompleto,Abreviatura,Expresion)  VALUES ('11','Aclaramiento de creatinina, formula de Cockcroft-Gault (mujer)','Aclaramiento de creatinina (mujer)','((140-Edad)*Peso)/(Crp*72)*0.85');");
                db.execSQL("INSERT INTO Formulas (IdFormula,NombreCompleto,Abreviatura,Expresion)  VALUES ('12','Agua Libre, Exceso','Agua Libre, Exceso','Agua*Peso*(1-Na/140)');");
                db.execSQL("INSERT INTO Formulas (IdFormula,NombreCompleto,Abreviatura,Expresion)  VALUES ('13','Agua Corporal, Deficit','Agua Corporal, Deficit','Agua*Peso*((Na/140)-1)');");
                db.execSQL("INSERT INTO Formulas (IdFormula,NombreCompleto,Abreviatura,Expresion)  VALUES ('14','Cloro,Deficit','Cloro, Deficit','Peso*CLVD*(Cl_d  - Cl_m )');");
                db.execSQL("INSERT INTO Formulas (IdFormula,NombreCompleto,Abreviatura,Expresion)  VALUES ('15','Superficie Corporal Total','Superficie Corporal Total','Peso^0.425/Estatura^0.725 * 0.007184');");
                db.execSQL("INSERT INTO Formulas (IdFormula,NombreCompleto,Abreviatura,Expresion)  VALUES ('16','Gasto de Energia Basal (hombre)','GEB hombre',' 66.47 +(13.75*Peso) + (5.00*Estatura) -(6.76*Edad)');");
                db.execSQL("INSERT INTO Formulas (IdFormula,NombreCompleto,Abreviatura,Expresion)  VALUES ('17','Gasto de Energia Basal (mujer)','GEB mujer','65.51 + (9.56 *Peso) + (1.85*Estatura) – (4.68*Edad)');");
                db.execSQL("INSERT INTO Formulas (IdFormula,NombreCompleto,Abreviatura,Expresion)  VALUES ('18','Osmolaridad, calculada','Osmolaridad, calculada','2(Na +K) +(Glucemia/18) + (Urea/6)');");
                db.execSQL("INSERT INTO Formulas (IdFormula,NombreCompleto,Abreviatura,Expresion)  VALUES ('19','Agua Corporal Total','Agua Corporal Total','H2O*Peso');");
                db.execSQL("INSERT INTO Formulas (IdFormula,NombreCompleto,Abreviatura,Expresion)  VALUES ('20','Bicarbonato, Exceso','Bicarbonato, Exceso','Peso*VDHCO3*(HCO3m – HCO3d)');");
                db.execSQL("INSERT INTO Formulas (IdFormula,NombreCompleto,Abreviatura,Expresion)  VALUES ('21','Bicarbonato, Deficit','Bicarbonato, Deficit','Peso*VDHCO3*(HCO3d - HCO3m )');");
                db.execSQL("INSERT INTO Formulas (IdFormula,NombreCompleto,Abreviatura,Expresion)  VALUES ('22','Gradiente A-a de O2','Gradiente A-a de O2','(FIO2*(PB-PH2O)) – (PACO2/R)');");
                db.execSQL("INSERT INTO Formulas (IdFormula,NombreCompleto,Abreviatura,Expresion)  VALUES ('23','Tension Inspirada de Oxigeno','Tension Inspirada de Oxigeno','FIO2*(PB-PH2O)');");
                db.execSQL("INSERT INTO Formulas (IdFormula,NombreCompleto,Abreviatura,Expresion)  VALUES ('24','Calculo de la insulinizacion: dosis de insulina (DI) al dia.','Dosis de insulina al dia','Ul*Peso');");
                db.execSQL("INSERT INTO Formulas (IdFormula,NombreCompleto,Abreviatura,Expresion)  VALUES ('25','TIMI Puntuacion de riesgo','TIMI Puntuacion de riesgo','escala');");


            }

            //Cambiar el peso en minuscula en la documentacion y la UL a Ul.

            c.close();
            c = db.rawQuery(" SELECT  COUNT(*) FROM Parametros  ", null);
            c.moveToFirst();
            nCampos = c.getString(0);
            if( nCampos.equals("0") )
            {
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('1','Billirumina','1','escalaB','mg/100 ml');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('2','Albumina serica','1','escalaB','g/l');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('3','Tiempo de protombina','1','escalaB','%');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('4','Ascitis','1','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('5','Encefalopatia de origen hepatico','1','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('6','Ojos,apertura','2','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('7','Verbal (mejor)','2','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('7','Verbal (mejor)','2','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('8','Motor (mejor)','2','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('9','Insuficiencia cardiaca congestiva/disfuncion ventricular izquierda','3','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('10','Hipertension arterial','3','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('11','Edad >75 años','3','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('12','Edad entre 65 y 74 años','3','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('13','Diabetes mellitus','3','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('14','Accidente cerebrovascular/tromboembolia','3','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('15','Enfermedad vascular','3','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('16','Sexo femenino','3','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('17','Edad > 50 años','4','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('18','Enfermedad neoplasica','4','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('19','Enfermedad hepatica','4','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('20','Insuficiencia cardiaca','4','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('21','Enfermedad cerebrobascular','4','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('22','Enfermedad renal','4','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('23','Confusion','4','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('24','TA sistotica < 90 mmHg','4','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('25','FC >= 125','4','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('26','FR >= 30','4','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('27','Tª axilar <35 o >40 ºC','4','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('28','Sexo femenino','5','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('29','Edad','5','escalaB','años');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('30','Procedente de residencia','5','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('31','Enfermedad neoplastica','5','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('32','Enfermedad hepatica','5','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('33','Insuficiencia cardiaca congestiva','5','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('34','Enfermedad cerebrovascular','5','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('35','TA sistolica < 90 mmHg','5','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('36','FC >= 125','5','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('37','FR >= 30','5','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('38','Tª axilar <35 o >40ºC','5','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('39','Ph arterial < 7.35','5','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('40','PO2 < 60 mmHg o Sat O2 <90%','5','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('41','Urea >64 mg/dl o Cr > 1.5 mg/dl','5','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('42','Sodio <130 mEq/l','5','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('43','Glucemia > 250 mg/dl','5','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('44','Hematocrito <30%','5','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('45','Derrame pleural','5','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('46','FC','6','general','lpm');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('47','PS','6','general','mmHg');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('48','Edad','6','general','años');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('49','Historia previa de ETV','7','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('50','Frecuencia cardiaca >100 lat/min','7','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('51','Cirugia reciente/ inmovilizacion','7','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('52','Hemoptisis','7','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('53','Cancer no controlado','7','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('54','Signos clinicos de TVP','7','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('55','Otra alternativa diagnostica es menos probable que TEP','7','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('56','Cancer activo (tratamiento en los ultimos 6 meses o en tratamiento paliativo)','8','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('57','Paralisis, paresia o inmovilizacion reciente de miembros inferiores','8','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('58','Encamamiento de 3 días (o mayor) o cirugia con anestesia general','8','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('59','Hinchazon de toda la pierna','8','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('60','Hinchazon de la pantorilla  de 3 cm  (o mayor) respecto a la pierna asintomatica','8','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('61','Edema con fovea en la pierna sintomatica','8','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('62','Venas superficiales colaterales (no varicosas)','8','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('63','Venas superficiales colaterales (no varicosas)','8','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('64','Urea','9','general','mg');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('65','Edad','10','general','años');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('66','Peso','10','general','kg');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('67','Crp','10','general');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('68','Edad','11','general','años');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('69','Peso','11','general','kg');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('70','Crp','11','general');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('71','H2O','12','general','%');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('72','Peso','12','general','kg');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('73','Na','12','general','mEq/l');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('74','H2O','13','general','%');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('75','Peso','13','general','kg');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('76','Na','13','general','mEq/l');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('77','Peso','14','general','kg');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('78','Cl_d','14','general','mEq/l');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('79','Cl_m','14','general','mEq/l');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('80','CLVD','14','general','%');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('81','Peso','15','general','kg');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('82','Estatura','15','general','cm');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('83','Peso','16','general','kg');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('84','Estatura','16','general','cm');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('85','Edad','16','general','años');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('86','Peso','17','general','kg');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('87','Estatura','17','general','cm');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('88','Edad','17','general','años');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('89','Na','18','general','mEq/l');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('90','K','18','general','mEq/l');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('91','Glucemia','18','general','mg/dl');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('92','Urea','18','general','mg/dl');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('93','Peso','19','general','kg');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('94','H2O','19','general','%');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('95','HCO3m','20','general','mEq/l');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('96','HCO3d','20','general','mEq/l');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('97','VDHCO3','20','general','%');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('98','Peso','20','general','kg');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('99','HCO3m','20','general','mEq/l');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('100','HCO3d','20','general','mEq/l');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('101','VDHCO3','20','general','%');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('102','Peso','20','general','kg');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('103','FIO2','22','general','fraccion');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('104','PB','22','general','mmHg');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('105','PH2O','22','general','mmHg');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('106','R','22','general','fraccion');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('107','PACO2','22','general','mmHg');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('108','PaO2','22','general','mmHg');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('109','FIO2','23','general','fraccion');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('110','PB','23','general','mmHg');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('111','PH2O','23','general','mmHg');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('112','Ul','24','general','kg/dia');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('113','Peso','24','general','kg');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('114','Edad : >75 años','25','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('115','Edad: 65-74 años','25','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('116','DM o HTA o angina','25','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('117','PAS<100mmHg','25','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('118','FC >100 lat/min','25','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('119','Killip III o IV','25','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('120','Peso <67 kg','25','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('121','lAM anterior o BRI','25','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('122','Retraso en la terapia >4 h','25','escalaA');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('123','ChildPugh','1','resultado');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('124','Glasgow','2','resultado');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('125','CHA2DS2-VASc','3','resultado');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('126','PSI-Inicial','4','resultado');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('127','PSI-Puntuacion','5','resultado');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('128','TIMI Puntuacion de riesgo','25','resultado');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('129','TIMI Indice de riesgo','6','resultado');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('130','Wells Score Embolismo ','7','resultado');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('131','Wells, Score Trombosis','8','resultado');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('132','BUN','9','resultado','mg');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('133','Ccr','10','resultado','ml/min');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('134','Ccr ','11','resultado','ml/min');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('135','H20xs','12','resultado','l');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('136','H20def','13','resultado','l');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('137','Cl_def','14','resultado','mEq');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('138','SCT','15','resultado','metros cuadrados');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('139','GEB','16','resultado');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro)  VALUES ('140','GEB','17','resultado');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('141','Osmolaridad','18','resultado','mOsm/l');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('142','TBW','19','resultado','l');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('143','HCO3_xs','20','resultado','mEq');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('144','HCO3_def','21','resultado','mEq');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('145','PAO2','22','resultado','mmHg');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('146','PIO2','23','resultado','mmHg');");
                db.execSQL("INSERT INTO Parametros (IdParametro,NombreParametro,IdFormula,TipoParametro,Medida)  VALUES ('147','DI','24','resultado','UI');");
            }

            c = db.rawQuery(" SELECT  COUNT(*) FROM CriterioPuntuacion  ", null);
            c.moveToFirst();
            nCampos = c.getString(0);
            if( nCampos.equals("0") )
            {
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('1','1','< 2.0','1');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('2','1','>= 2.0 && <= 3.0','2');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('3','1','> 3.0','3');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('4','2','> 35','1');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('5','2','>= 30 && <= 35','2');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('6','2','< 30','3');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('7','3','>= 0 && <40','1');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('8','3','>= 40 && < 60','2');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('9','3','>= 60','3');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('10','4','Ninguna','1');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('11','4','Control facil','2');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('12','4','Control inadecuado','3');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('13','5','Ninguna','1');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('14','5','Minima','2');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('15','5','Fase avanzada.','3');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('16','6','De forma espontanea','4');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('17','6','Tras una orden verbal','3');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('18','6','Al estimulo doloroso','2');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('19','6','No los abre','1');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('20','7','Orientado','5');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('21','7','Conversacion  confusa','4');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('22','7','Palabras inapropiadas','3');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('23','7','Sonido incomprensibles','2');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('24','7','Ninguna','1');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('25','8','Obedece la orden','6');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('26','8','Localiza el estimulo','5');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('27','8','Retira','4');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('28','8','Flexion anormal','3');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('29','8','Extension','2');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('30','8','Ninguna','1');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('31','9','Insuficiencia cardiaca congestiva/disfuncion ventricular izquierda','1');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('32','10','Hipertension arterial','2');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('33','11','Edad >75 años','1');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('34','12','Edad entre 65 y 74 años','1');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('35','13','Diabetes mellitus','1');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('36','14','Accidente cerebrovascular/tromboembolia','2');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('37','15','Enfermedad vascular','1');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('38','16','Sexo femenino','1');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('39','17','Edad > 50 años','1');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('40','18','Enfermedad neoplasica','1');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('41','19','Enfermedad hepatica','1');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('42','20','Insuficiencia cardiaca','1');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('43','21','Enfermedad cerebrobascular','1');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('44','22','Enfermedad renal','1');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('45','23','Confusion','1');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('46','24','TA sistotica < 90 mmHg','1');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('47','25','FC >= 125','1');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('48','26','FR >= 30','1');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('49','27','Tª axilar <35 o >40 ºC','1');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('50','28','Sexo femenino','-10');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('51','29','Edad ','Edad');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('52','30','Procedente de residencia','10');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('53','31','Enfermedad neoplastica','30');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('54','32','Enfermedad hepatica','20');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('55','33','Insuficiencia cardiaca congestiva','10');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('56','34','Enfermedad cerebrovascular','10');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('57','35','TA sistolica < 90 mmHg','20');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('58','36','FC >= 125','10');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('59','37','FR >= 30','20');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('60','38','Tª axilar <35 o >40ºC','15');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('61','39','Ph arterial < 7.35','30');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('62','40','PO2 < 60 mmHg o Sat O2 <90%','10');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('63','41','Urea >64 mg/dl o Cr > 1.5 mg/dl','20');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('64','42','Sodio <130 mEq/l','20');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('65','43','Glucemia > 250 mg/dl','10');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('66','44','Hematocrito <30%','10');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('67','45','Derrame pleural','10');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('68','49','Historia previa de ETV','1.5');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('69','50','Frecuencia cardiaca 1,5 >100 lat/min','1.5');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('70','51','Cirugia reciente/ 1,5 inmovilizacion','1.5');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('71','52','Hemoptisis','1');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('72','53','Cancer no controlado','1');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('73','54','Signos clinicos de TVP','3');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('74','55','Otra alternativa diagnostica es menos probable que TEP','3');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('75','56','Cancer activo (tratamiento en los ultimos 6 meses o en tratamiento paliativo)','1');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('76','57','Paralisis, paresia o inmovilizacion reciente de miembros inferiores','1');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('77','58','Encamamiento de 3 días (o mayor) o cirugia con anestesia general','1');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('78','59','Hinchazon de toda la pierna','1');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('79','60','Hinchazon de la pantorilla  de 3 cm  (o mayor) respecto a la pierna asintomatica','1');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('80','61','Edema con fovea en la pierna sintomatica','1');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('81','62','Venas superficiales colaterales (no varicosas)','1');");
                db.execSQL("INSERT INTO CriterioPuntuacion (IdCriterioPuntuacion,IdParametro,Criterio,Puntuacion) VALUES ('82','63','Diagnostico alternativo al menos tan probable como trombosis venosa profunda','-2');");
            }

            //Agregar variable x a todas las consultas de criterio puntuacion.


 /*
            else
            {
                 txtNombre = (TextView)findViewById(R.id.TxtNombre);
                 txtNombre.setText("La base de datos sigue igual");
            }
*/



            //Leemos las formulas insertadas en la base de datos y cogemos las abreviaturas.
            Cursor abreviatura = db.rawQuery(" SELECT  Abreviatura FROM Formulas  ", null);
            //Button botonazo = new Button(this);
            int numeroFormulas;
            numeroFormulas = abreviatura.getCount();
            abreviatura.moveToFirst();



            final String Nombreabreviatura = abreviatura.getString(0);

            for(int i=0;i< numeroFormulas; i++)
            {
                final Button boton = new Button(this);
                boton.setId(i);

                if (i == 0)
                    abreviatura.moveToFirst();
                else
                    abreviatura.moveToNext();

                boton.setText(abreviatura.getString(0));
                lm.addView(boton);

                boton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Creamos el Intent
                        Intent intent =
                                new Intent(MainActivity.this, Detalles.class);

                        //Creamos la información a pasar entre actividades
                        Bundle b = new Bundle();
                        b.putString("NOMBRE", (String) boton.getText());

                        //Añadimos la información al intent
                        intent.putExtras(b);

                        //Iniciamos la nueva actividad
                        startActivity(intent);
                    }
                });


            }


            abreviatura.close();
            c.close();
            db.close();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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