package com.example.ingresogastos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TableLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var matriz = arrayOf(
        arrayOf("Fecha","Hora","Monto"),
        arrayOf("12-03-2023","12:30pm","S/.50.00"),
        arrayOf("12-04-2023","1:30pm","S/.60.00")
    )
    var tl_historial_ingresos:TableLayout?=null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tl_historial_ingresos=findViewById(R.id.tl_historial_ingresos)
        tl_historial_ingresos?.removeAllViews()
        for(i in (0 until matriz.count())){
            val registro = LayoutInflater.from(this).inflate(R.layout.tabla_ingresos,null,false)
            val fecha = registro.findViewById<View>(R.id.fecha) as TextView
            val hora= registro.findViewById<View>(R.id.hora) as TextView
            val monto = registro.findViewById<View>(R.id.monto) as TextView

            fecha.text=matriz[i][0].toString()
            hora.text=matriz[i][1].toString()
            monto.text=matriz[i][2].toString()
            tl_historial_ingresos?.addView(registro)
        }
    }






}