package com.example.tafers.telas.gestao

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tafersgestao.FakeNavController
import com.example.tafersgestao.R
import com.example.tafersgestao.gestao.CustomBottomBar
import com.example.tafersgestao.gestao.PerfilMenuItem
import com.example.tafersgestao.ui.theme.AzulEscuro
import com.example.tafersgestao.ui.theme.poppinsRegular
import com.example.tafersgestao.ui.theme.poppinsLight
import com.example.tafersgestao.ui.theme.poppinsBold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerfilGestao(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Perfil") },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Voltar",
                            tint = Color.Black
                        )
                    }
                },
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            Box(
                modifier = Modifier.size(100.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = "foto de perfil",
                    modifier = Modifier
                        .background(Color.LightGray, CircleShape)
                        .size(100.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.Black, CircleShape)
                )
                Icon(
                    imageVector = Icons.Default.Edit,
                    tint = Color.White,
                    contentDescription = "Editar",
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .size(28.dp)
                        .background(AzulEscuro, CircleShape)
                        .padding(5.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Isabel da Silva",
                style = MaterialTheme.typography.titleLarge,
                fontFamily = poppinsRegular
            )
            Text(
                text = "Engenheira",
                style = MaterialTheme.typography.titleMedium,
                fontFamily = poppinsLight,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(24.dp))

            PerfilMenuItem("Informções da conta", Icons.Default.Settings)
            PerfilMenuItem("Certificados", Icons.Default.CheckCircle)
            PerfilMenuItem("Planos", Icons.Default.Star)
        }
    }
}

@Composable
@Preview
fun PreviewPerfil() {
    PerfilGestao(
        FakeNavController(LocalContext.current)
    )
}

