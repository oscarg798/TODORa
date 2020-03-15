package com.todora

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.todora.common.GetTodoraInteractor
import com.todora.common.TodoClientRepository
import com.todora.common.createApplicationScreenMessage
import com.todora.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val interactor = GetTodoraInteractor(TodoClientRepository())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {

                val description = etDescription.text.toString()
                val todo = withContext(Dispatchers.IO) {
                    interactor.invoke(description)
                }

                Toast.makeText(this@MainActivity, "$todo", Toast.LENGTH_LONG).show()
            }

        }


    }


}