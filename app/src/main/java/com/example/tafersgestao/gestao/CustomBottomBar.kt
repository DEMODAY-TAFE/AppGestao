package com.example.tafersgestao.gestao

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tafersgestao.R
import com.example.tafersgestao.ui.theme.AzulEscuro
import com.example.tafersgestao.ui.theme.Laranja
import com.example.tafersgestao.ui.theme.poppinsRegular
import com.example.tafersgestao.ui.theme.poppinsLight
import com.example.tafersgestao.ui.theme.poppinsBold

@Composable
fun CustomBottomBar(
    selectedIndex: Int,
    onItemSelect: (Int) -> Unit,
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 32.dp, start = 32.dp, end = 32.dp),
        contentAlignment = Alignment.Center
    ) {

        val icons = listOf(
            R.drawable.home_icon,
            R.drawable.clipboard_icon,
            R.drawable.marktplace_icon,
            R.drawable.profile_icon
        )

        val routes = listOf(
            "inicio_gestao",
            "checklist_epi/30-06-2025",
            "marketplace",
            "perfil"
        )

        Surface(
            modifier = Modifier
                .padding(vertical = 20.dp)
                .fillMaxWidth()
                .height(70.dp),
            shape = RoundedCornerShape(50.dp),
            color = Color.White,
            shadowElevation = 10.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                icons.forEachIndexed { index, icon ->
                    IconButton(
                        onClick = {
                            onItemSelect(index)
                            navController.navigate(routes[index])
                        },
                        modifier = Modifier.size(50.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = icon),
                            contentDescription = null,
                            modifier = Modifier.size(32.dp),
                            tint = if (index == selectedIndex)
                                AzulEscuro
                            else
                                Laranja
                        )
                    }
                }
            }
        }
    }
}