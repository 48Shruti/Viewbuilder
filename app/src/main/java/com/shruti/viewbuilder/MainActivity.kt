package com.shruti.viewbuilder

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.shruti.viewbuilder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btupdate.setOnClickListener {
            var dialog = Dialog(this )
            dialog.setContentView(R.layout.dialog_layout)
            var name = dialog.findViewById<EditText>(R.id.etname)
            var roll = dialog.findViewById<EditText>(R.id.etroll)
            var done = dialog.findViewById<Button>(R.id.btdone)
            done.setOnClickListener {
            if(name?.text.isNullOrEmpty())
            {
                name?.error = ("Enter your name")
            }else if (roll?.text.isNullOrEmpty()){
                roll ?. error = "Enter your roll number"
            }
            else
            {
                binding.tvname.text = name.text
                binding.tvroll.text = roll.text
                dialog.dismiss()
            }
            }
            dialog.show()
            }
         binding.btdelete.setOnClickListener {
             AlertDialog.Builder(this)
                 .setTitle("Delete")
                 .setMessage("Do you want to delete this text")
                .setPositiveButton("yes") {_,_->
                    Toast.makeText(this, "text is deleted ", Toast.LENGTH_SHORT).show()
                    binding.tvname.text = "Enter your name"
                    binding.tvroll.text = "Enter your roll number"
                }
                 .setNegativeButton("No"){_,_->
                     Toast.makeText(this,"text is not delete",Toast.LENGTH_SHORT).show()
                 }
                 .setCancelable(false)
             . show()
             }
         }
        }







