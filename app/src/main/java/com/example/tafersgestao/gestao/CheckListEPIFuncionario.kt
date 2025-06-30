package com.example.tafers.telas.gestao

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tafersgestao.FakeNavController
import com.example.tafersgestao.gestao.CustomBottomBar
import com.example.tafersgestao.ui.theme.AzulEscuro

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckListEPIFuncionarioScreen(navController: NavController, data: String) {
    // Exemplo de funcionários e EPIs
    val routes = listOf(
        "checklist_epi_funcionario/João/$data",
        "checklist_epi_funcionario/Maria/$data",
        "checklist_epi_funcionario/Carlos/$data",
    )
    val funcionarios = listOf("João", "Maria", "Carlos")

    val selectedItem = remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Checklist",
                            fontFamily = poppinsBold,
                            fontSize = 38.sp,
                            style = MaterialTheme.typography.headlineMedium
                        )
                        Text(
                            text = " Funcionarios",
                            fontFamily = poppinsRegular,
                            fontSize = 30.sp,
                            style = MaterialTheme.typography.headlineMedium.copy(
                                color = AzulEscuro
                            )
                        )
                    }
                }
            )
        },
        bottomBar ={
            CustomBottomBar(
                selectedIndex = selectedItem.value,
                onItemSelect = { selectedItem.value = it },
                navController = navController
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            funcionarios.forEachIndexed { index, funcionario ->
                Card(
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .width(500.dp)
                        .height(90.dp)
                        .border(
                            width = 1.dp,
                            color = Color.Black,
                            shape = MaterialTheme.shapes.medium
                        )
                        .fillMaxWidth(),
                    onClick = { navController.navigate(routes[index]) }
                ) {
                    Column(
                        modifier = Modifier.padding(10.dp)
                    ) {
                        
                        Text(
                            text = funcionario,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun PreviewChecklistFuncionarios(){
    CheckListEPIFuncionarioScreen(FakeNavController(LocalContext.current), data = "23-06-2025")
}