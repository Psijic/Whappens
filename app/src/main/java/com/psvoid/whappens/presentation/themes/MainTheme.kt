/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.psvoid.whappens.presentation.themes

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val secondaryTextColor = Color(0xFFF1F1F1)

//<color name="primaryColor">#1a237e</color>
//<color name="primaryLightColor">#534bae</color>
//<color name="primaryDarkColor">#000051</color>
//<color name="secondaryColor">#c2185b</color>
//<color name="secondaryLightColor">#fa5788</color>
//<color name="secondaryDarkColor">#8c0032</color>
//<color name="primaryTextColor">#ffffff</color>
//<color name="secondaryTextColor">#f1f1f1</color>

private val darkColors = darkColors(
    primary = Color(0xFF000051),
    primaryVariant = Color(0xFF1A237E),
    secondary = Color(0xFF8C0032),
    secondaryVariant = Color(0xFFC2185B),
    onPrimary = Color.White,
    onSecondary = Color(0xFFF1F1F1),
    onBackground = Color.White,
    onSurface = Color.White,
    onError = Color.White,
    background = Color(0xFF000051),
//    surface = Color(0xFF121212),
//    error = Color(0xFFCF6679)
)

private val lightColors = lightColors(
    primary = Color(0xFF1A237E),
    primaryVariant = Color(0xFF534BAE),
    secondary = Color(0xFFC2185B),
    secondaryVariant = Color(0xFFFA5788),
    background = Color(0xFF1A237E),
)

@Composable
fun MainTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) =
//    MaterialTheme(colors = if (darkTheme) darkColors else lightColors) {
    MaterialTheme(colors = darkColors) {
        content()
    }
