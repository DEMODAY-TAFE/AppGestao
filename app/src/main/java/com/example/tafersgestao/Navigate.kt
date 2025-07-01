package com.example.tafersgestao

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tafers.telas.gestao.CheckListEPIFuncionarioScreen
import com.example.tafers.telas.gestao.ChecklistEPIFuncionarioDetalheScreen
import com.example.tafers.telas.gestao.InicioGestaoScreen

class FakeNavController(context: Context) : NavController(context) //classe para rodar nos preview

@Composable
fun Navigate(
    selectedIndex: Int,
    onItemSelect: (Int) -> Unit,
    navController: NavHostController = rememberNavController()
) {

    NavHost(
        navController = navController,
        startDestination = "inicio_gestao" //inicia pela tela "Inicio Gestão"
    ) {

        composable("inicio_gestao") {
            InicioGestaoScreen(
                navController = navController,
                selectedIndex = selectedIndex,
                onItemSelect = onItemSelect
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
                data = data,
                selectedIndex = selectedIndex,
                onItemSelect = onItemSelect
            )
        }

    }
}