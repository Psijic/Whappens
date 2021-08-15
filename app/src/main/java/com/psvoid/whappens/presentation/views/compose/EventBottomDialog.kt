package com.psvoid.whappens.presentation.views.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.psvoid.whappens.R
import com.psvoid.whappens.presentation.themes.MainTheme

/**
 *  In the View system, ConstraintLayout was the recommended way to create large and complex layouts, as a flat view
 *  hierarchy was better for performance than nested views are. However, this is not a concern in Compose, which is
 *  able to efficiently handle deep layout hierarchies.
 */
@ExperimentalMaterialApi
@Composable
fun EventBottomDialog() {
    val coroutineScope = rememberCoroutineScope()

    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(
            initialValue = BottomSheetValue.Collapsed
        )
    )

    BottomSheetScaffold(scaffoldState = bottomSheetScaffoldState, sheetPeekHeight = 0.dp, sheetContent = {
        Column(Modifier.padding(8.dp)) {
            Row {
                Image(painter = painterResource(R.drawable.discoveries), contentDescription = stringResource(id = R.string.event_image) )
            }
        }
    }) {
        TopAppBar()
    }

//    coroutineScope.launch {
//        bottomSheetScaffoldState.bottomSheetState.collapse()
//    }

}

@ExperimentalMaterialApi
@Composable
@Preview
fun EventBottomDialogPreview() {
    MainTheme {
        EventBottomDialog()
    }
}