package com.psvoid.whappens.presentation.views.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.psvoid.whappens.R

@Composable
fun FragmentMap() {
    DrawerLayout()
}

@Composable
fun DrawerLayout() {
    val result = remember { mutableStateOf("") }

    Scaffold(
        topBar = {
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
        },

        content = {
            Box(
                Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
            ) {
                Text(
                    text = result.value + "TEXT",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    )
}

@Preview
@Composable
private fun FragmentMapPreview() {
    FragmentMap()
}