package com.todora

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.todora.common.com.todora.domain.interactors.CreateTodoInteractor
import com.todora.common.com.todora.data.TodoClientRepository
import com.todora.common.com.todora.domain.entities.Todo
import com.todora.common.com.todora.presentation.createtodo.CreateTodoContract
import com.todora.common.com.todora.presentation.createtodo.TodoPresenter
import com.todora.data.repositories.KtorTodoService
import com.todora.databinding.ActivityMainBinding
import com.todora.domain.interactors.GetTodosInteractor
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

class MainActivity : AppCompatActivity(), CreateTodoContract.View {

    private lateinit var binding: ActivityMainBinding

    val repository = TodoClientRepository(KtorTodoService())
    val presenter = TodoPresenter(
        CreateTodoInteractor(repository),
        GetTodosInteractor((repository))
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.bind(this)

        binding.btnAdd.setOnClickListener {
            val description = binding.etDescription.text?.toString() ?: return@setOnClickListener
            presenter.create(description)
        }

    }

    override fun show(todos: List<Todo>) {
        Toast.makeText(this@MainActivity, "$todos", Toast.LENGTH_LONG).show()
    }

    override fun show(todo: Todo) {
        Toast.makeText(this@MainActivity, "$todo", Toast.LENGTH_LONG).show()
    }

}

public inline fun <R, T> Result<T>.foldWithException(
    onSuccess: (value: T) -> R,
    onFailure: (exception: Exception) -> R
): R {
    return fold({
        onSuccess(it)
    }, {
        when (it) {
            is Exception -> onFailure(it)
            else -> throw it
        }
    })
}