package com.example.tafers.telas.gestao


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tafers.telas.gestao.poppinsBold
import com.example.tafersgestao.FakeNavController
import com.example.tafersgestao.R

val poppinsLight = FontFamily(
    Font(R.font.poppins_light),
)

val poppinsBold = FontFamily(
    Font(R.font.poppins_bold)
)

val poppinsRegular = FontFamily(
    Font(R.font.poppins_regular)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChecklistEPIFuncionarioDetalheScreen(
    navController: NavController,
    funcionario: String,
    data: String
) {
    val epis = listOf(
        "Capacete de Segurança",
        "Luva de Segurança",
        "Máscara ou respirador",
        "Botina de Segurança",
        "Cinto de Segurança",
        "Óculos de proteção"
    )

    val checkedStates =
        remember { mutableStateListOf(*Array(epis.size) { false }) } //variavel que guarda valor falso da checkbox

    val selectAll = remember { mutableStateOf(false) } //variavel para selecionar todas as opções

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row {
                Text(
                    text = "Checklist",
                    fontFamily = poppinsBold,
                    fontSize = 38.sp,
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    text = " Diária",
                    fontFamily = poppinsLight,
                    fontSize = 38.sp,
                    style = MaterialTheme.typography.headlineMedium.copy(
                        color = Color(
                            0xFFFF5722
                        )
                    )
                )
            }



            Row {
                Text(
                    text = "Funcionário: $funcionario   ",
                    fontFamily = poppinsRegular,
                    fontSize = 18.sp,
                    style = MaterialTheme.typography.titleMedium
                )



                Text(
                    text = "|    Data: $data",
                    fontFamily = poppinsRegular,
                    fontSize = 18.sp,
                    style = MaterialTheme.typography.titleMedium
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "EPIs",
                    fontFamily = poppinsBold,
                    fontSize = 35.sp,
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "Selecionar Tudo",
                    fontFamily = poppinsRegular,
                    fontSize = 18.sp,
                    style = MaterialTheme.typography.titleMedium
                )
                Checkbox(
                    checked = selectAll.value,
                    onCheckedChange = { isChecked ->
                        selectAll.value = isChecked
                        checkedStates.indices.forEach { index ->
                            checkedStates[index] = isChecked
                        }
                    },
                    modifier = Modifier.scale(1.5f),
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(0xFFFF5722)
                    )
                )
            }

            epis.forEachIndexed { index, epi ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Text(
                        text = epi,
                        fontFamily = poppinsRegular,
                        fontSize = 23.sp,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Checkbox(
                        checked = checkedStates[index],
                        onCheckedChange = { checkedStates[index] = it },
                        modifier = Modifier.scale(1.5f),
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color(0xFFFF5722)
                        )
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = { /* Salvar checklist ou voltar */ },
                    modifier = Modifier
                        .width(120.dp)
                        .height(55.dp),
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFF5722)
                    )
                ) {
                    Text(text = "Concluir", style = MaterialTheme.typography.titleMedium)
                }
            }
        }
    }
}

@Composable
@Preview
fun PreviewChecklist() {
    ChecklistEPIFuncionarioDetalheScreen(
        FakeNavController(LocalContext.current),
        "João",
        data = "23-06-2025"
    )
}