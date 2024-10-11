package uts.c14220331.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class addTabungan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_tabungan)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        BACK BUTTON
        var _backButton = findViewById<Button>(R.id.backButton)
        _backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

//        ADD MONEY
        var _inputTabungan = findViewById<EditText>(R.id.inputTabungan)
        var _textTabungan = findViewById<TextView>(R.id.textTabungan)

        var tabunganNow = intent.getStringExtra("tabungan")
        _textTabungan.text = tabunganNow

        var _addButton = findViewById<Button>(R.id.addButton)
        _addButton.setOnClickListener {
            var input = _inputTabungan.text.toString().toIntOrNull() ?: 0
            var oldAmount = tabunganNow.toString().toInt()

            var add = oldAmount + input

            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("tabungan", add.toString())
            }
            startActivity(intent)
            finish()
        }

    }
}