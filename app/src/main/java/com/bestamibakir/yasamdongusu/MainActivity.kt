package com.bestamibakir.yasamdongusu

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bestamibakir.yasamdongusu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun sonrakiSayfa(view : View){
        val kullaniciGirdisi = binding.editText.text.toString()
        val intent = Intent(this,SecondActivity::class.java)
        intent.putExtra("isim",kullaniciGirdisi)
        startActivity(intent)

        //finish()  <-- bu fonksiyon onDestroy'u manuel olarak çağırır.
        //val kullaniciGirdisi = binding.editText.text.toString()
        //binding.textView.text = "Name : $kullaniciGirdisi"
    }
}