package com.example.ejercicio1evaluacion2;

import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.ejercicio1evaluacion2.Model.ModelQuestion;


import java.util.ArrayList;
import java.util.List;

public class question1 extends AppCompatActivity {

    // inicializamos una lista de preguntas
    private List<ModelQuestion> ListQuestions = new ArrayList<ModelQuestion>();

    // creando objetos para asignar los que usaremos en la lista
    RadioGroup rdbGroup1;
    RadioButton rdtQuestion1, rdtQuestion2, rdtQuestion3,rdtAnswerd;
    TextView NameQuestion, NumQuestion,CountView,SumPoint;
    Button Nextquestion, OutApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        // Asignamos data a la lista creada
        AsignarList();

        //asignacion de objetos de la vista
        //Radiobuttons
        rdbGroup1 = (RadioGroup) findViewById(R.id.rdbGroup1);
        rdtQuestion1 = (RadioButton) findViewById(R.id.rdbOpcion1);
        rdtQuestion2 = (RadioButton) findViewById(R.id.rdbOpcion2);
        rdtQuestion3 = (RadioButton) findViewById(R.id.rdbOpcion3);

        //TextView
        NameQuestion = (TextView) findViewById(R.id.QuestionName);
        NumQuestion = (TextView) findViewById(R.id.NumQuestion);
        CountView = (TextView) findViewById(R.id.Count);
        SumPoint = (TextView) findViewById(R.id.Points);

        //Buttons
        Nextquestion = (Button) findViewById(R.id.btnNext);
        OutApp = (Button) findViewById(R.id.btnOut);

        //Inicializar con la primer pregunta
        AsignarPregunta(Integer.parseInt(CountView.getText().toString()));

        Nextquestion.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                SumarPuntos();
            }
        });
        OutApp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                System.exit(0);
            }
        });

    }

    // Metodo encargado de mostrar las preguntas en pantalla y hacer evalucion final
    private void AsignarPregunta(int PreguntaActual)
    {
        String Estado = "Aprobado";
        int NotaMinima = 6;
        int ActualPoint = Integer.parseInt(SumPoint.getText().toString());
        int converPregunt = PreguntaActual;
        int count = converPregunt + 1;
        int TotalPreguntas = 5;

        if (count <= TotalPreguntas)
        {
            NameQuestion.setText(ListQuestions.get(converPregunt).getNamequestion());
            NumQuestion.setText("Pregunta # "+ ListQuestions.get(converPregunt).getNumberquestion());
            rdtQuestion1.setText(ListQuestions.get(converPregunt).getAnswerText1());
            rdtQuestion2.setText(ListQuestions.get(converPregunt).getAnswerText2());
            rdtQuestion3.setText(ListQuestions.get(converPregunt).getAnswerText3());
            CountView.setText(Integer.toString(count));
        }
    else
        {
            NumQuestion.setText("Nota Obtenida: " + ActualPoint +".00");

            if (ActualPoint < NotaMinima)
            {
                Estado = "Reprobado";
            }
            NameQuestion.setText("Estado: " + Estado);

            Nextquestion.setVisibility(View.INVISIBLE);
            rdtQuestion1.setVisibility(View.INVISIBLE);
            rdtQuestion2.setVisibility(View.INVISIBLE);
            rdtQuestion3.setVisibility(View.INVISIBLE);
        }

    }

    // Método encargado de evaluar la puntuacion de las preguntas
    private void SumarPuntos()
    {
        int valorCorrecto = 2;
        int SinEspecificar = -1;
        int RespuestaPreguntaActual;
        rdtAnswerd = (RadioButton) findViewById(rdbGroup1.getCheckedRadioButtonId());
        int Respuesta = rdbGroup1.indexOfChild(rdtAnswerd);
        int ActualPoint = Integer.parseInt(SumPoint.getText().toString());
        int PreguntaActual = Integer.parseInt(CountView.getText().toString());

        if (Respuesta != SinEspecificar){
            int calcularposicionenlista = PreguntaActual -1 ;
            RespuestaPreguntaActual = ListQuestions.get(calcularposicionenlista).getAnswerIdValue();

            if (Respuesta == RespuestaPreguntaActual)
            {
                ActualPoint += valorCorrecto;
                SumPoint.setText(Integer.toString(ActualPoint));
            }
            rdtAnswerd.setChecked(false);
            AsignarPregunta(PreguntaActual);
        }else{
            Toast.makeText(this, "Por favor seleccione una respuesta", Toast.LENGTH_LONG).show();
        }
    }

    // Método encargado de asignar data de las preguntas
    private void AsignarList()
    {
        ModelQuestion Pregunta1 = new ModelQuestion();
            Pregunta1.setIdquestion(0);
            Pregunta1.setNumberquestion(1);
            Pregunta1.setNamequestion("¿setText es para?");
            Pregunta1.setAnswerText1("Borrar Texto");
            Pregunta1.setAnswerText2("Asignar Texto");
            Pregunta1.setAnswerText3("Ocultar texto");
            Pregunta1.setAnswerIdValue(1);
        ListQuestions.add(Pregunta1);

        ModelQuestion Pregunta2 = new ModelQuestion();
            Pregunta2.setIdquestion(1);
            Pregunta2.setNumberquestion(2);
            Pregunta2.setNamequestion("¿getText es para?");
            Pregunta2.setAnswerText1("Borrar Texto");
            Pregunta2.setAnswerText2("Asignar Texto");
            Pregunta2.setAnswerText3("Recuperar texto");
            Pregunta2.setAnswerIdValue(2);
        ListQuestions.add(Pregunta2);

        ModelQuestion Pregunta3 = new ModelQuestion();
            Pregunta3.setIdquestion(2);
            Pregunta3.setNumberquestion(3);
            Pregunta3.setNamequestion("¿Toast es para?");
            Pregunta3.setAnswerText1("Cerrar la app");
            Pregunta3.setAnswerText2("Mostrar mensajes");
            Pregunta3.setAnswerText3("Sumar numeros");
            Pregunta3.setAnswerIdValue(1);
        ListQuestions.add(Pregunta3);

        ModelQuestion Pregunta4 = new ModelQuestion();
            Pregunta4.setIdquestion(3);
            Pregunta4.setNumberquestion(4);
            Pregunta4.setNamequestion("¿Finish es para?");
            Pregunta4.setAnswerText1("Borrar Texto");
            Pregunta4.setAnswerText2("Asignar Texto");
            Pregunta4.setAnswerText3("Cerrar Actividad");
            Pregunta4.setAnswerIdValue(2);
        ListQuestions.add(Pregunta4);

        ModelQuestion Pregunta5 = new ModelQuestion();
            Pregunta5.setIdquestion(4);
            Pregunta5.setNumberquestion(5);
            Pregunta5.setNamequestion("¿TextView es para?");
            Pregunta5.setAnswerText1("Mostrar Texto");
            Pregunta5.setAnswerText2("Multiplicar");
            Pregunta5.setAnswerText3("Dividir");
            Pregunta5.setAnswerIdValue(0);
        ListQuestions.add(Pregunta5);
    }

}
