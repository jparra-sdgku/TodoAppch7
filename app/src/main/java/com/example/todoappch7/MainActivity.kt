package com.example.todoappch7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.todoappch7.ui.screens.TodoScreen
import com.example.todoappch7.ui.theme.TodoAppch7Theme

class MainActivity : ComponentActivity() {
    // viewModels() it creates the viewModel and keeps it alive during configuration changes
    private val viewModel: TodoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoAppch7Theme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    TodoScreen(viewModel = viewModel)
                }
            }
        }
    }
}


