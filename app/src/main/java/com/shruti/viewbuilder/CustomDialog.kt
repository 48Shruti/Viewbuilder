package com.shruti.viewbuilder


import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.shruti.viewbuilder.databinding.ActivityCustomDialogBinding
import org.w3c.dom.Text

class CustomDialog : AppCompatActivity() {
     lateinit var binding :ActivityCustomDialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btclick.setOnClickListener {
        AlertDialog.Builder(this )
            .setTitle("Add char")
            .setMessage("Do you want to add char ")
            .setPositiveButton("Add 3 char"){_,_ ->
             Toast.makeText(this,"Random three numbers ",Toast.LENGTH_SHORT).show()
            for (i in 0..2){
                val randomchar = ('a'..'z').random()
                binding.etthree.setText(binding.etthree?.text.toString()+ randomchar?.toString())
            }
            }
            .setNegativeButton("Add 4 char"){_,_,->
                Toast.makeText(this,"add four char",Toast.LENGTH_SHORT).show()
                for (i in 0..3){
                    val randomchar1 = ('a'..'z').random()
                    binding.etfour.setText(binding.etfour?.text.toString()+ randomchar1?.toString())
                }
            }
            .setNeutralButton("Cancel"){_,_,->
                Toast.makeText(this,"Cancel to add three  and four random character",Toast.LENGTH_SHORT).show()
            }
            .show()
    }
    }
}


