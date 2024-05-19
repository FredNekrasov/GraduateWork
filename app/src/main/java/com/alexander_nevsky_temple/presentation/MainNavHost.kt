package com.alexander_nevsky_temple.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alexander_nevsky_temple.data.di.utils.DIStrings
import com.alexander_nevsky_temple.presentation.screens.*
import com.alexander_nevsky_temple.presentation.viewModels.ArticleVM
import org.koin.androidx.compose.koinViewModel
import org.koin.core.qualifier.qualifier

@Composable
fun MainNavHost(
    controller: NavHostController,
    navItems: List<String>,
    modifier: Modifier = Modifier,
    articleVM: ArticleVM = koinViewModel(qualifier(DIStrings.ARTICLE + DIStrings.VIEWMODEL))
) {
    Column(modifier) {
        NavHost(controller, startDestination = navItems[0]) {
            composable(navItems[0]) { MainScreen(articleVM) }
            composable(navItems[1]) { ParishLife(articleVM) }
            composable(navItems[2]) { Schedule(articleVM) }
            composable(navItems[3]) { Box(modifier) { CircularProgressIndicator(Modifier.align(Alignment.Center)) } } // spirit talk https://hramalnevskogo.ru/page40967215.html
            composable(navItems[4]) { YouthClub(articleVM) }
            composable(navItems[5]) { Priesthood(articleVM) }
            composable(navItems[6]) { Advices(articleVM) }
            composable(navItems[7]) { History(articleVM) }
            composable(navItems[8]) { Sacraments(articleVM) }
            composable(navItems[9]) { Contacts(articleVM) }
            composable(navItems[10]) { Box(modifier) { LinearProgressIndicator(Modifier.align(Alignment.Center)) } } // information https://hramalnevskogo.ru/page42533272.html
            composable(navItems[11]) { Volunteerism(articleVM) }
        }
    }
}