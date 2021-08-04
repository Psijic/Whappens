package com.psvoid.whappens.presentation.views.compose.samples

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainContent()
        }
    }
}

@Composable
fun MainContent() {
    val result = remember { mutableStateOf("") }
    val expanded = remember { mutableStateOf(false) }
    val liked = remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Top app bar")
                },

                navigationIcon = {
                    // show drawer icon
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
                        Icon(Icons.Filled.AddCircle, contentDescription = "")
                    }

                    IconToggleButton(
                        checked = liked.value,
                        onCheckedChange = {
                            liked.value = it
                            if (liked.value) {
                                result.value = "Liked"
                            } else {
                                result.value = "Unliked"
                            }
                        }
                    ) {
                        val tint by animateColorAsState(
                            if (liked.value) Color(0xFF7BB661)
                            else Color.LightGray
                        )
                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = "Localized description",
                            tint = tint
                        )
                    }

                    Box(
                        Modifier
                            .wrapContentSize(Alignment.TopEnd)
                    ) {
                        IconButton(onClick = {
                            expanded.value = true
                            result.value = "More icon clicked"
                        }) {
                            Icon(
                                Icons.Filled.MoreVert,
                                contentDescription = "Localized description"
                            )
                        }

                        DropdownMenu(
                            expanded = expanded.value,
                            onDismissRequest = { expanded.value = false },
                        ) {
                            DropdownMenuItem(onClick = {
                                expanded.value = false
                                result.value = "First item clicked"
                            }) {
                                Text("First Item")
                            }

                            DropdownMenuItem(onClick = {
                                expanded.value = false
                                result.value = "Second item clicked"
                            }) {
                                Text("Second item")
                            }

                            Divider()

                            DropdownMenuItem(onClick = {
                                expanded.value = false
                                result.value = "Third item clicked"
                            }) {
                                Text("Third item")
                            }

                            Divider()

                            DropdownMenuItem(onClick = {
                                expanded.value = false
                                result.value = "Fourth item clicked"
                            }) {
                                Text("Fourth item")
                            }
                        }
                    }
                },

                backgroundColor = Color(0xFDCD7F32),
                elevation = AppBarDefaults.TopAppBarElevation
            )
        },

        content = {
            Box(
                Modifier
                    .background(Color(0XFFE3DAC9))
                    .padding(16.dp)
                    .fillMaxSize(),
            ) {
                Text(
                    text = result.value,
                    fontSize = 22.sp,
                    fontFamily = FontFamily.Serif,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    )
}


@Preview
@Composable
fun ComposablePreview() {
    MainContent()
}
//}