package com.hapkiduki.petty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hapkiduki.petty.ui.theme.PettyTheme
import dagger.hilt.android.AndroidEntryPoint

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
                    Greeting()
                }
            }
        }
    }
}


@Composable
fun Greeting(
    viewModel: MainViewModel = hiltViewModel()
) {
    Column(

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { viewModel.getDogsBreeds() }) {
                Text(text = "Perros")
            }
            Button(onClick = { viewModel.getCatsBreeds() }) {
                Text(text = "Gatos")
            }
        }
        if (viewModel.loading)
            Text(text = "CArgando ...")
        if (!viewModel.perrosActivos) {
            if (viewModel.gatos.isNullOrEmpty())
                Text(text = "No hay gatos pa mostrar")
            LazyColumn {

                items(viewModel.gatos.toList()) { cat ->
                    Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 15.dp)) {
                        Text(text = cat.name)
                        Text(text = cat.description)
                    }

                }
            }
        } else {
            if (viewModel.perros.isNullOrEmpty())
                Text(text = "No hay Perros pa mostrar")
            LazyColumn {
                items(viewModel.perros.toList()) { dog ->
                    Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 15.dp)) {
                        Text(text = dog.name)
                        Text(text = dog.description ?: dog.history ?: "Sin info")
                    }

                }
            }
        }
    }

}
