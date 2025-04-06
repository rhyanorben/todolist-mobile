package br.edu.satc.todolistcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import br.edu.satc.todolistcompose.persistence.database.TaskDatabase
import br.edu.satc.todolistcompose.persistence.repository.TaskRepository
import br.edu.satc.todolistcompose.persistence.viewModel.TaskViewModel
import br.edu.satc.todolistcompose.persistence.viewModel.TaskViewModelFactory
import br.edu.satc.todolistcompose.preferences.ThemePreference
import br.edu.satc.todolistcompose.preferences.ThemeViewModel
import br.edu.satc.todolistcompose.ui.screens.HomeScreen
import br.edu.satc.todolistcompose.ui.theme.ToDoListComposeTheme

class MainActivity : ComponentActivity() {

    private lateinit var taskViewModel: TaskViewModel
    private lateinit var themeViewModel: ThemeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = TaskDatabase.getDatabase(applicationContext)
        val repository = TaskRepository(database.taskDao())
        val factory = TaskViewModelFactory(repository)

        taskViewModel = ViewModelProvider(this, factory)[TaskViewModel::class.java]

        val prefs = ThemePreference(applicationContext)
        themeViewModel = ThemeViewModel(prefs)

        setContent {
            ToDoListComposeTheme (themeViewModel.themeMode.value) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen(
                        taskViewModel = taskViewModel,
                        themeViewModel = themeViewModel,
                        onThemeChange = { themeViewModel.setThemeMode(it) }
                    )
                }
            }
        }
    }
}