package com.example.keystoresample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var btn_ecrypt : Button? = null
    var btn_decrypt : Button? = null

    var txt_ecrypt : TextView? = null
    var txt_decrypt : TextView? = null

    var editText : EditText? = null

    var encrypted_code : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cipherManager: CipherManager = CipherManagerImpl()

        btn_ecrypt = findViewById(R.id.button_enc)
        btn_decrypt = findViewById(R.id.button_dec)

        txt_ecrypt = findViewById(R.id.tv_encrypt)
        txt_decrypt = findViewById(R.id.tv_decrypt)

        editText = findViewById(R.id.editText)

        btn_ecrypt?.setOnClickListener {
            if (editText?.text.toString().trim().isEmpty()){
                editText?.error = "Please enter any character for encryption"
                editText?.requestFocus()
            }else{
                editText?.error = null
                encrypted_code = cipherManager.encrypt(editText?.text.toString())
                txt_ecrypt?.text = "${encrypted_code}"
            }
        }


        btn_decrypt?.setOnClickListener {
            if (encrypted_code!=null){
                txt_decrypt?.text = "${cipherManager.decrypt(encrypted_code!!)}"
            }
        }
    }

}