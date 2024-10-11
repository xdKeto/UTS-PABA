package uts.c14220331.app

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class sendEmail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_send_email)
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

//        EMAIL
        var _emailAddress = findViewById<TextView>(R.id.emailAddress)
        var _emailSubject = findViewById<EditText>(R.id.emailSubject)
        var _inputEmail = findViewById<EditText>(R.id.inputEmail)

        var _sendButton = findViewById<Button>(R.id.sendEmail)

        _sendButton.setOnClickListener {
            val recipient = _emailAddress.text.toString()
            val subject = _emailSubject.text.toString()
            val body = _inputEmail.text.toString()

            sendEmail(recipient, subject, body)
        }
    }

    private fun sendEmail (recipient: String?, subject: String?, body: String?){
        val intent = Intent(Intent.ACTION_SEND)
        intent.data = Uri.parse("mailto:")
        intent.type = "text/plain"

        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(Intent.EXTRA_TEXT, body)

        try {
            startActivity(intent)
        }
        catch (e: Exception){
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }
    }
}