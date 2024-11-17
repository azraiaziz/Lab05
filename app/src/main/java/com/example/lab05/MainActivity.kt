package com.example.lab05

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab05.databinding.ActivityMainBinding

//depend on page
class MainActivity : AppCompatActivity() {

    //ActivityMain => Reverse of our Activity name(MainActivity)
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //binding.buttonPlus
        binding.button.setOnClickListener {
            var pizzaSizePrice = 0.0 // type double
            var toppingsPrice = 0.0 // type double (implicit typing)

            //hanya yang akan dipilih, kita gunakan if else if
            when{
                //isCHeck is the property to see if an item is selected
                binding.smallRadioButton.isChecked -> pizzaSizePrice = 5.0
                binding.mediumRadioButton.isChecked -> pizzaSizePrice = 7.0
                binding.largeRadioButton.isChecked -> pizzaSizePrice = 10.0
            }

            //multiple toppings can be selected, if, (not if else if)
            if(binding.olivesBox.isChecked){
                toppingsPrice += 2.0
            }
            if(binding.onionsBox.isChecked){
                toppingsPrice += 1.0
            }
            if(binding.tomatoesBox.isChecked){
                toppingsPrice += 3.0
            }

            binding.totalTextView.text = "Total Price is RM ${pizzaSizePrice + toppingsPrice}"

        }
    }
    /*
    enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    */
}