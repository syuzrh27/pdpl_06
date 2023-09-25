package com.example.spinnerdatetimepicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.R
import com.example.spinnerdatetimepicker.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val jenistiket = arrayOf(
            "Economy Class",
            "Business Class",
            "First Class"
        )

        with(binding){
            val jenistiketAdapter = ArrayAdapter(this@MainActivity, R.layout.support_simple_spinner_dropdown_item,jenistiket)

            jenistiketAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            )

            dropjenistiket.adapter= jenistiketAdapter

            submit.setOnClickListener(){
                val jenisTiketData:String = dropjenistiket.selectedItem.toString()

                //set tahun bulan hari
                val tahun:Int = dropwaktu.year
                val bulan:Int = dropwaktu.month
                val hari:Int = dropwaktu.dayOfMonth

                //set jam dan menit
                val jam:Int = dropjam.hour
                val menit:Int = dropjam.minute

                //set calendar
                val calendar = Calendar.getInstance()
                calendar.set(tahun,bulan,hari,jam,menit)

                //mengatur Toast
                val message:String = "Jenis Tiket = " + jenisTiketData + "\n" +
                        "Waktu Keberangkatan = " + "$tahun/$bulan/$hari $jam:$menit"

                Toast.makeText(this@MainActivity, message, Toast.LENGTH_LONG).show()

            }
}
}
}