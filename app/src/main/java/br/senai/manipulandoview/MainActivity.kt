package br.senai.manipulandoview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.viewbinding.ViewBinding
import br.senai.manipulandoview.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // variável para receber a activity
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // atribuir a activit à varável criada (binding)
        binding = ActivityMainBinding.inflate(layoutInflater)

        // utilizar a referência à activity por meio do binding
        setContentView(binding.root)

        val toastButton = findViewById<Button>(R.id.toast) // forma correta de chamar a view
        toastButton.setOnClickListener { mensagemToast() }

        alert.setOnClickListener { mensagemAlert() } // não utilizar a extensão

        binding.snack.setOnClickListener { mensagemSnack() }
    }

    private fun mensagemToast() {
        Toast.makeText(this, "Exemplo de mensagem TOAST", Toast.LENGTH_LONG)
            .show()
    }

    private fun mensagemSnack() {
        val snackButton = findViewById<Button>(R.id.snack)
        Snackbar.make(snackButton, "Mensagem usanda o no SNACKBAR", Snackbar.LENGTH_INDEFINITE)
            .setAction("SAIR") { finish() }
            .show()
    }

    private fun mensagemAlert() {
        AlertDialog.Builder(this)
            .setTitle("Atenção")
            .setMessage("Deseja sair do APP?")
            .setPositiveButton("SIM") { _,_ -> finish() }
            .setNegativeButton("NÃO") { _,_ -> }
            .show()
    }
}