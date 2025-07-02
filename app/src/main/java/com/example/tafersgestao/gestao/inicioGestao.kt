package com.example.tafers.telas.gestao

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tafersgestao.FakeNavController
import com.example.tafersgestao.gestao.CustomBottomBar
import com.example.tafersgestao.ui.theme.AzulEscuro
import com.example.tafersgestao.ui.theme.poppinsRegular
import com.example.tafersgestao.ui.theme.poppinsLight
import com.example.tafersgestao.ui.theme.poppinsBold


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InicioGestaoScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    ) {
                        Text(
                            text = "Gestão",
                            fontFamily = poppinsBold,
                            fontSize = 38.sp,
                            style = MaterialTheme.typography.headlineMedium
                        )
                        Text(
                            text = " Inicio",
                            fontFamily = poppinsRegular,
                            fontSize = 38.sp,
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
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Adicione outras opções de checklist aqui
        }
    }
}


@Composable
@Preview
fun PreviewInicioGestao() {

    InicioGestaoScreen(
        FakeNavController(LocalContext.current))

}