package com.example.testloginwithgoogle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.testloginwithgoogle.ActivityTestLogin.Companion.EXTRA_NAME
import com.example.testloginwithgoogle.databinding.ActivityGoogleSignInBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.io.Serializable


class GoogleSignInActivity : AppCompatActivity(), Serializable {

    private lateinit var binding: ActivityGoogleSignInBinding
    private lateinit var p: Person

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoogleSignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textDisplayName.text = intent.getStringExtra(EXTRA_NAME)

        p = intent.getSerializableExtra("Person") as Person

        Log.d("MOSTRAR MI PERSONA RECIBIDA", p.toString())
        Log.d("MOSTRAR Nombre", p.nombre)
        Log.d("MOSTRAR Email", p.email)


        //binding.idImageView.setImageURI(Uri.parse(intent.getStringExtra("IMG")))

        binding.logout.setOnClickListener {
            Firebase.auth.signOut()
            val intent = Intent(applicationContext, SplashActivity::class.java)
            startActivity(intent)
        }
    }
}

