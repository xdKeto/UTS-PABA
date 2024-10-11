package uts.c14220331.app

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        SEND EMAIL
        var _sendEmail = findViewById<Button>(R.id.sendEmail)
        _sendEmail.setOnClickListener {
            val intent = Intent(this, sendEmail::class.java)
            startActivity(intent)
        }

//        CALL PHONE
        var _callPhone = findViewById<Button>(R.id.buttonPhone)
        _callPhone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:08123460265"))
            startActivity(intent)
        }

//        JADWAL KULIAH
        var _buttonKuliah = findViewById<ImageButton>(R.id.buttonKuliah)
        _buttonKuliah.setOnClickListener {
            val intent = Intent(this, jadwalKuliah::class.java)
            startActivity(intent)
        }

//        TAMBAH TABUNGAN
        var _textTabungan = findViewById<TextView>(R.id.textTabungan)
        var _buttonTabungan = findViewById<ImageButton>(R.id.buttonTabungan)
        _buttonTabungan.setOnClickListener {
            val intent = Intent(this, addTabungan::class.java).apply {
                putExtra("tabungan", tabungan.amount.toString())
            }
            startActivity(intent)
        }

        var tabunganNow = intent.getStringExtra("tabungan")?.toIntOrNull() ?: tabungan.amount
        tabungan.amount = tabunganNow
        _textTabungan.text = tabungan.amount.toString()


    }

    companion object {
        var tabungan : Tabungan = Tabungan(1000)
    }
}