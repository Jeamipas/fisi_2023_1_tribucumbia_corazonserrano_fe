package HistorialIE

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TableLayout
import android.widget.TextView
import com.example.ingresogastos.R

class ld_EgresosActivity : AppCompatActivity() {

    var matriz = arrayOf(
        arrayOf("Fecha","Hora","Monto"),
        arrayOf("12-03-2023","12:30pm","-S/.50.00"),
        arrayOf("12-04-2023","1:30pm","-S/.60.00")
    )
    var tl_historial_egresos:TableLayout?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ld_egresoshistorial)
        tl_historial_egresos=findViewById(R.id.tl_historial_egresos)
        tl_historial_egresos?.removeAllViews()
        for(i in (0 until matriz.count())){
            val registro = LayoutInflater.from(this).inflate(R.layout.ld_tabla_egresos,null,false)
            val fecha = registro.findViewById<View>(R.id.fecha) as TextView
            val hora= registro.findViewById<View>(R.id.hora) as TextView
            val monto = registro.findViewById<View>(R.id.monto) as TextView

            fecha.text=matriz[i][0].toString()
            hora.text=matriz[i][1].toString()
            monto.text=matriz[i][2].toString()
            tl_historial_egresos?.addView(registro)
        }
    }






}