package com.example.tafers.telas.gestao

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChecklistEPIScreen(navController: NavController) {
    // Exemplo de datas
    val datas = listOf("02/02/2024", "03/02/2024", "04/02/2024")
    Scaffold(
        topBar = { TopAppBar(title = { Text("Checklist EPI - Datas") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            datas.forEach { data ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { navController.navigate("checklist_epi_funcionario/$data") }
                ) {
                    Text(
                        text = data,
                        modifier = Modifier.padding(24.dp)
                    )
                }
            }
        }
    }
}