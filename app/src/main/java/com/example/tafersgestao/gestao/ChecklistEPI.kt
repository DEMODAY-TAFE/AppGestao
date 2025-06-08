package com.example.tafers.telas.gestao

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChecklistEPIFuncionarioDetalheScreen(
    navController: NavController,
    funcionario: String,
    data: String
) {
    val epis = listOf("Capacete", "Luva", "Bota")
    val checkedStates = remember { mutableStateListOf(*Array(epis.size) { false }) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Checklist EPI - $funcionario") }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("Data: $data", style = MaterialTheme.typography.titleMedium)
            epis.forEachIndexed { index, epi ->
                Row(
                    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 4.dp)
                ) {
                    Checkbox(
                        checked = checkedStates[index],
                        onCheckedChange = { checkedStates[index] = it }
                    )
                    Text(text = epi)
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = { /* Salvar checklist ou voltar */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Salvar")
            }
        }
    }
}