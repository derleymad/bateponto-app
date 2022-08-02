package com.github.derleymad.bateponto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.derleymad.bateponto.databinding.ActivityCalcBinding
import com.github.derleymad.bateponto.model.Calc

class CalcActivity : AppCompatActivity() {
    private  lateinit var binding : ActivityCalcBinding
    private lateinit var list : MutableList<Calc>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalcBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list = mutableListOf()

        binding.goBtn.setOnClickListener {

            if(!wrong()){
                generate(binding.swTarde.isChecked)

            }else{
                Toast.makeText(this@CalcActivity,"Insira valores válidos!",Toast.LENGTH_SHORT).show()
            }
        }

        binding.rvCalc.adapter = Adapter(list)
        binding.rvCalc.layoutManager = LinearLayoutManager(this@CalcActivity)
    }

    fun wrong() : Boolean{
        return (binding.editText.text?.isEmpty() ?: false || binding.editText.text?.isBlank() ?: false)
    }

    fun generate(isTarde:Boolean){
        list.clear()
        if (!isTarde){
            var totalOfAll = 0
            for(i in 0 until binding.editText.text.toString().toInt()){
                val entradaHoraRandom = (470..490).random()
                val saidaHoraRandom = (720..740).random()


                val totalRandom = saidaHoraRandom - entradaHoraRandom
                totalOfAll += totalRandom

                val entradaHora = (entradaHoraRandom / 60)
                val entradaMinutos = (entradaHoraRandom%60).toString().padStart(2,'0')

                val saidaHora = (saidaHoraRandom / 60)
                val saidaMinutos = (saidaHoraRandom%60).toString().padStart(2,'0')

                val totalHoras = (totalRandom/60)
                val totalMinutos = (totalRandom%60).toString().padStart(2,'0')

                list.add(Calc(i+1,
                    "$entradaHora:$entradaMinutos",
                    "$saidaHora:$saidaMinutos",
                    "$totalHoras:$totalMinutos"))
            }

            val totalOfAllHoras = (totalOfAll/60)
            val totalOfAllMinutos = (totalOfAll%60).toString().padStart(2,'0')

            binding.rvCalc.adapter?.notifyDataSetChanged()
            binding.totalOfAll.text = getString(R.string.total_of_all,"$totalOfAllHoras:$totalOfAllMinutos")

        }else{
            var totalOfAll = 0
            for(i in 0 until binding.editText.text.toString().toInt()){
                val entradaHoraRandom = (770..790).random()
                val saidaHoraRandom = (1010..1030).random()
                val totalRandom = saidaHoraRandom - entradaHoraRandom

                totalOfAll += totalRandom

                val entradaHora = (entradaHoraRandom / 60)
                val entradaMinutos = (entradaHoraRandom%60).toString().padStart(2,'0')

                val saidaHora = (saidaHoraRandom / 60)
                val saidaMinutos = (saidaHoraRandom%60).toString().padStart(2,'0')

                val totalHoras = (totalRandom/60)
                val totalMinutos = (totalRandom%60).toString().padStart(2,'0')

                list.add(Calc(i+1,
                    "$entradaHora:$entradaMinutos",
                    "$saidaHora:$saidaMinutos",
                    "$totalHoras:$totalMinutos"))
            }
            val totalOfAllHoras = (totalOfAll/60)
            val totalOfAllMinutos = (totalOfAll%60).toString().padStart(2,'0')

            binding.rvCalc.adapter?.notifyDataSetChanged()
            binding.totalOfAll.text = getString(R.string.total_of_all,"$totalOfAllHoras:$totalOfAllMinutos")
        }
    }
}