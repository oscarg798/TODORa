import com.todora.common.com.todora.domain.entities.Todo
import com.todora.data.entities.APITodo

interface TodoService {

    suspend fun getTodos(): List<APITodo>

    suspend fun createTodo(description: String): APITodo
}