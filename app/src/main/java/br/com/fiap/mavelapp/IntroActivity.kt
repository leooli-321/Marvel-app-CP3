package br.com.fiap.mavelapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        // Exibe a tela de introdução por 3 segundos antes de redirecionar para MainActivity
        Handler(Looper.getMainLooper()).postDelayed({
            // Inicia a MainActivity
            val intent = Intent(this@IntroActivity, MainActivity::class.java)
            startActivity(intent)
            finish()  // Fecha a IntroActivity para que não volte a ela ao pressionar 'Voltar'
        }, 2000) // Tempo em milissegundos (2 segundos)
    }
}
