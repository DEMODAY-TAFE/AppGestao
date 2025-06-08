package com.example.tafers.telas.gestao

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckListEPIFuncionarioScreen(navController: NavController, data: String) {
    // Exemplo de funcionários e EPIs
    val funcionarios = listOf("João", "Maria", "Carlos")
    val epis = listOf("Capacete", "Luva", "Bota")

    Scaffold(
        topBar = { TopAppBar(title = { Text("Funcionários - $data") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            funcionarios.forEach { funcionario ->
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = funcionario, style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(8.dp))
                        epis.forEach { epi ->
                            Row(
                                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                                modifier = Modifier.padding(vertical = 4.dp)
                            ) {
                                Checkbox(checked = false, onCheckedChange = {})
                                Text(text = epi)
                            }
                        }
                    }
                }
            }
        }
    }
}