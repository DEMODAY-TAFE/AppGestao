package com.example.tafersgestao

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tafers.telas.gestao.CheckListEPIFuncionarioScreen
import com.example.tafers.telas.gestao.ChecklistEPIFuncionarioDetalheScreen
import com.example.tafers.telas.gestao.InicioGestaoScreen
import com.example.tafers.telas.gestao.PerfilGestao
import com.example.tafersgestao.gestao.ChecklistConcluidaScreen
import com.example.tafersgestao.gestao.CustomBottomBar

class FakeNavController(context: Context) : NavController(context) //classe para rodar nos preview

@Composable
fun Navigate() {

    val navController = rememberNavController()

    val backStack = navController.currentBackStackEntryAsState()
    val currentRoute = backStack.value?.destination?.route

    val routes = listOf(
        "inicio_gestao",
        "checklist_epi/{date}",
        "marketplace",
        "perfil"
    )

    val selectedIndex = routes.indexOfFirst { route ->
        currentRoute?.startsWith(route.substringBefore("/")) == true
    }.takeIf { it >= 0 } ?: 0

    Scaffold(
        bottomBar = {
            CustomBottomBar(
                selectedIndex = selectedIndex,
                onItemSelect = { idx ->
                    navController.navigate(routes[idx]) {
                        launchSingleTop = true
                        restoreState = true
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                    }
                },
                navController = navController
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "inicio_gestao", //inicia pela tela "Inicio Gestão"
            modifier = Modifier.padding(innerPadding)
        ) {

            composable("inicio_gestao") {
                InicioGestaoScreen(
                    navController = navController,
                )
            }

            composable("checklist_epi_funcionario/{funcionario}/{data}") { backStackEntry -> //caixa que guarda dados a cada tela nova enviada quando clicar o botão
                val funcionario = backStackEntry.arguments?.getString("funcionario") ?: ""
                val data = backStackEntry.arguments?.getString("data") ?: ""
                ChecklistEPIFuncionarioDetalheScreen(
                    navController = navController,
                    funcionario = funcionario,
                    data = data
                )
            }

            composable("checklist_epi/{data}") { backStackEntry ->
                val data = backStackEntry.arguments?.getString("data") ?: ""
                CheckListEPIFuncionarioScreen(
                    navController = navController,
                    data = data
                )
            }

            composable("perfil") {
                PerfilGestao(
                    navController = navController,
                )
            }

            composable("concluidoChecklist"){
                ChecklistConcluidaScreen(
                    onConcluirClick = {
                        navController.navigate("checklist_epi/04-07-2025")
                    }

                )
            }

        }
    }
}