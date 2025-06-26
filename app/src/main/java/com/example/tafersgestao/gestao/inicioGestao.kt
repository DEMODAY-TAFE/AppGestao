package com.example.tafers.telas.gestao

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.FlowRowScopeInstance.weight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tafersgestao.FakeNavController
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.BottomAppBar
import androidx.compose.ui.res.painterResource
import com.example.tafersgestao.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.draw.shadow

@Composable
fun BottomNavItem(
    icon: Int,
    isSelect: Boolean,
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier.size(50.dp)
    ) {
        Icon(
            modifier = Modifier.size(30.dp),
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = if (isSelect) Color(0xFF003366) else Color(0xFFFC6600)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InicioGestaoScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Gestão - Início")
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 60.dp, vertical = 40.dp)
                    .height(70.dp)
                    .shadow(15.dp, RoundedCornerShape(50.dp)),
                containerColor = Color.White

            ){
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(50.dp),

                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        BottomNavItem(
                            icon = R.drawable.home_icon,
                            isSelect = true,
                            onClick = { }
                        )
                        BottomNavItem(
                            icon = R.drawable.clipboard_icon,
                            isSelect = false,
                            onClick = { }
                        )
                        BottomNavItem(
                            icon = R.drawable.marktplace_icon,
                            isSelect = false,
                            onClick = { }
                        )
                        BottomNavItem(
                            icon = R.drawable.profile_icon,
                            isSelect = false,
                            onClick = { }
                        )
                    }
                }
            }
        }
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



@Composable
@Preview
fun PreviewInicioGestao() {

    InicioGestaoScreen(FakeNavController(LocalContext.current))

}