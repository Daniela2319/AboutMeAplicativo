package com.minhaempresa.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.minhaempresa.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //criado uma variavel em cima do oncreate para o objetivo de ligação = chamado de binding e instanciado onCreate
    //objetivo da ligação como uma camada de cola entre um layout e suas visualizações e os dados deixando código mais limpo
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main) é substituido outra intrução criar uma ligação vai conecta o layout com a atividade
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.doneButton.setOnClickListener{ //acessar o botão atraves do objeto de ligação
            addApelido(it)
        }
       //findViewById<Button>(R.id.btn_button).setOnClickListener{
         //   addApelido(it)
       // }
    }

    private fun addApelido(view: View){
        //aqui pode ser acessar as visualização dentro da função de apelido,
        //usando apply do kotlin torna nosso código mais fácil de ler.
        binding.apply {
            nicknameText.text = binding.nicknameEdit.text
            invalidateAll() // para atualizar a IU com os novos dados, precisamos invalidar todas as expressões de vinculação para que sejam recriadas com os dados corretos
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE

        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }



}