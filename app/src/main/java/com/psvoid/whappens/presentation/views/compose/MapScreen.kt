package com.psvoid.whappens.presentation.views.compose

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.psvoid.whappens.R
import com.psvoid.whappens.presentation.themes.MainTheme

@ExperimentalMaterialApi
@Composable
fun MapScreen() {
    //TopAppBar()
    EventBottomDialog()
}

@Composable
fun MapTopBar() {
    val result = remember { mutableStateOf("") }
    TopAppBar(
        title = {},
        navigationIcon = {
            // Drawer icon
            IconButton(
                onClick = {
                    result.value = "Drawer icon clicked"
                }
            ) {
                Icon(Icons.Filled.Menu, contentDescription = "")
            }
        },
        actions = {
            IconButton(onClick = {
                result.value = " Play icon clicked"
            }) {
                Icon(painterResource(R.drawable.ic_domain_24dp), contentDescription = "")
            }
            IconButton(onClick = {}) {
                Icon(Icons.Filled.DateRange, contentDescription = "")
            }
            IconButton(onClick = {}) {
                Icon(Icons.Filled.Search, contentDescription = "")
            }
            IconButton(onClick = {}) {
                Icon(painterResource(R.drawable.ic_list_alt_24), contentDescription = "")
            }
        },
    )
}

@Preview
@Composable
private fun FragmentMapPreview() {
    MainTheme {
        MapTopBar()
    }
}