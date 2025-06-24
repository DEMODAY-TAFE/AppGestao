package com.example.tafers.telas.gestao

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InicioGestaoScreen(navController: NavController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Gestão - Início") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = { navController.navigate("checklist_epi_funcionario/João/23-06-2025") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Checklist EPI")
            }
            // Adicione outras opções de checklist aqui
        }
    }
}

