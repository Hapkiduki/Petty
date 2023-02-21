package com.hapkiduki.petty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hapkiduki.petty.ui.theme.PettyTheme
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.components.SingletonComponent

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PettyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
    viewModel: MainViewModel = hiltViewModel()
) {
    Text(text = "Hello $name!")
    if (viewModel.loading)
        Text(text = "CArgando ...")
    LazyColumn {
        items(viewModel.razas.toList()) { cat ->
            Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 15.dp)) {
                Text(text = cat.name)
                Text(text = cat.description)
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PettyTheme {
        Greeting("Android")
    }
}