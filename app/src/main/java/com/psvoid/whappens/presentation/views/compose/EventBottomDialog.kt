package com.psvoid.whappens.presentation.views.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gowtham.ratingbar.RatingBar
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

    BottomSheetScaffold(scaffoldState = bottomSheetScaffoldState, sheetPeekHeight = 166.dp, sheetContent = {
        Column(Modifier.padding(8.dp)) {
            Row { // Image with date, title, type and buttons
                Image(
                    modifier = Modifier.size(
                        dimensionResource(R.dimen.default_image_height), dimensionResource(R.dimen.default_image_width)
                    ),
                    painter = painterResource(R.drawable.discoveries),
                    contentDescription = stringResource(id = R.string.event_image)

                )
                Column {
                    Row { // Date and rating
                        Text(text = "17:00 - 19:00, 04 Dec", color = MaterialTheme.colors.secondary)
                        RatingBar(
                            value = 2.5f, numStars = 3,
                            size = 16.dp,
                            activeColor = MaterialTheme.colors.secondary
                        ) {}
                    }
                    Text(text = "Event Title and there is The Second Line", style = MaterialTheme.typography.h6)
                    Text(text = "conference, science", style = MaterialTheme.typography.body1)
                }
                Button(onClick = { /*TODO*/ }) {}
                Button(onClick = { /*TODO*/ }) {}
                Button(onClick = { /*TODO*/ }) {}
            }
            Text(text = stringResource(id = R.string.no_address), style = MaterialTheme.typography.h6)
//            LazyColumn(content = )
            Text(text = stringResource(id = R.string.mock_description), style = MaterialTheme.typography.h6)
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