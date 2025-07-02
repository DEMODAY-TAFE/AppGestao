package com.example.tafers.telas.gestao

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tafersgestao.FakeNavController
import com.example.tafersgestao.R
import com.example.tafersgestao.gestao.CustomBottomBar
import com.example.tafersgestao.ui.theme.AzulEscuro
import com.example.tafersgestao.ui.theme.poppinsRegular
import com.example.tafersgestao.ui.theme.poppinsLight
import com.example.tafersgestao.ui.theme.poppinsBold

val funcionarios = listOf("João", "Maria", "Carlos")

val fotos = listOf(R.drawable.joao, R.drawable.maria, R.drawable.carlos)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckListEPIFuncionarioScreen(
    navController: NavController,
    data: String
) {
    // Exemplo de funcionários e EPIs
    val routes = listOf(
        "checklist_epi_funcionario/João/$data",
        "checklist_epi_funcionario/Maria/$data",
        "checklist_epi_funcionario/Carlos/$data",
    )

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
                            fontSize = 30.sp,
                            style = MaterialTheme.typography.headlineMedium
                        )
                        Text(
                            text = " Funcionarios",
                            fontFamily = poppinsRegular,
                            fontSize = 28.sp,
                            style = MaterialTheme.typography.headlineMedium.copy(
                                color = AzulEscuro
                            )
                        )
                    }
                }
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
                        .padding(horizontal = 40.dp, vertical = 10.dp)
                        .width(350.dp)
                        .height(90.dp)
                        .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                    onClick = { navController.navigate(routes[index]) }
                ) {
                    Row(
                        modifier = Modifier.padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier.size(80.dp)
                        ){
                            Image(
                                painter = painterResource(id = fotos[index]),
                                contentDescription = "foto de perfil",
                                modifier = Modifier
                                    .background(Color.LightGray, CircleShape)
                                    .size(70.dp)
                                    .clip(CircleShape)
                            )
                        }
                        Text(
                            text = "    $funcionario",
                            style = MaterialTheme.typography.titleMedium,
                            fontSize = 20.sp
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
fun PreviewChecklistFuncionarios() {
    CheckListEPIFuncionarioScreen(
        FakeNavController(LocalContext.current),
        data = "23-06-2025"
        )
}