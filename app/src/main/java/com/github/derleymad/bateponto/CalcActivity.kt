package com.github.derleymad.bateponto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
                binding.editText.text
                generate(binding.swTarde.isActivated)

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

        if (isTarde){
            val entradaMinutesRandom = (0..10).random()
            val saidaMinutesRandom = (10..20).random()
            for(i in 0 until binding.editText.text.toString().toInt()){
            }
        }else{

        }


    }
}