package com.example.alcoolougasolina

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var percentual:Double = 0.7
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putDouble("percentual",percentual)
        super.onSaveInstanceState(outState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) {
            percentual=savedInstanceState.getDouble("percentual")
        }

        Log.i("PDM24.1","No onCreate, $percentual")

        val btCalc: Button = findViewById(R.id.btCalcular)
        val textMsg: TextView = findViewById(R.id.textMsg)

        btCalc.setOnClickListener(View.OnClickListener {
            // VERIFICANDO SE SWITCH ESTA ATIVADO 75%
            percentual = 0.7
            val switchPercentual: Switch = findViewById(R.id.swPercentual)
            val switchAtivado: Boolean = switchPercentual.isChecked
            if (switchAtivado) percentual = 0.75

            // TRATANDO VALOR DA GASOLINA
            val EditTextGasolina: EditText? = findViewById(R.id.edGasolina)
            val vlrGasolinaStr: String = EditTextGasolina?.text?.toString() ?: "0.0"

            val vlrGasolina: Double = if (vlrGasolinaStr.isNotEmpty() && vlrGasolinaStr.toDoubleOrNull() != null) {
                vlrGasolinaStr.toDouble()
            }
            else { 0.0 }

            // TRATANDO VALOR DO ALCOOL
            val EditTextAlcool: EditText? = findViewById(R.id.edAlcool)
            val vlrAlcoolStr: String = EditTextAlcool?.text?.toString() ?: "0.0"

            val vlrAlcool: Double = if (vlrAlcoolStr.isNotEmpty() && vlrAlcoolStr.toDoubleOrNull() != null) {
                vlrAlcoolStr.toDouble()
            }
            else { 0.0 }

            val porcentagemGasolina: Double = vlrGasolina.toDouble() * percentual

            var retorno = "Gasolina compensa mais."
            if (vlrAlcool <= porcentagemGasolina) retorno = "Álcool compensa mais."

            textMsg.text = retorno
            Log.d("PDM24","No btCalcular, $percentual")
        })
    }
override fun onResume(){
    super.onResume()
    Log.d("PDM24","No onResume, $percentual")
}
override fun onStart(){
    super.onStart()
    Log.v("PDM24","No onStart")
}
override fun onPause(){
    super.onPause()
    Log.e("PDM24","No onPause")
}
override fun onStop(){
    super.onStop()
    Log.w("PDM24","No onStop")
}
override fun onDestroy(){
    super.onDestroy()
    Log.wtf("PDM24","No Destroy")
}
}