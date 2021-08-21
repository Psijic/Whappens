package com.psvoid.whappens.presentation.views.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Domain
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LocationCity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

    BottomSheetScaffold(scaffoldState = bottomSheetScaffoldState,
        sheetPeekHeight = 0.dp, //166
        sheetBackgroundColor = MaterialTheme.colors.background,
        sheetContent = { EventView() }) { TopAppBar() }

//    coroutineScope.launch {
//        bottomSheetScaffoldState.bottomSheetState.collapse()
//    }

}

@Composable
fun EventView() {
    Column(Modifier.padding(8.dp)) {
        Row { // Image with date, title, type and buttons
            Image(
                modifier = Modifier.size(147.dp, 147.dp),
                painter = painterResource(R.drawable.discoveries),
                contentDescription = stringResource(id = R.string.event_image)
            )
            Column(
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) { // Date and rating
                    Text(
                        text = "17:00 - 19:00, 04 Dec",
                        color = MaterialTheme.colors.secondary,
                        style = MaterialTheme.typography.body2
                    )
                    RatingBar(
                        Modifier.padding(end = 0.dp),
                        value = 2.5f, numStars = 3,
                        size = 16.dp,
                        activeColor = MaterialTheme.colors.secondary
                    ) {}
                }
                Text(
                    modifier = Modifier.height(52.dp),
                    text = "Event Title and there is The Second Line",
                    style = MaterialTheme.typography.h6,
                    maxLines = 2

                )
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 6.dp)) {
                    Icon(Icons.Default.Domain, contentDescription = null)
                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        text = "Conference, Science",
                        style = MaterialTheme.typography.body1,
                        maxLines = 1
                    )
                }
                Row(modifier = Modifier.padding(top = 8.dp)) {
                    Button(onClick = { /*TODO*/ }) {
                        Icon(Icons.Default.FavoriteBorder, contentDescription = null)

                    }
                    Button(onClick = { /*TODO*/ }) {
                        Icon(painterResource(R.drawable.ic_today_white_24dp), contentDescription = null)
                    }
                    Button(onClick = { /*TODO*/ }) {
                        Icon(painterResource(R.drawable.ic_star_border_white_24dp), contentDescription = null)
                    }
                }
            }
        }
        Row(modifier = Modifier.padding(top = 8.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.LocationCity, contentDescription = null)
            Text(
                text = stringResource(id = R.string.no_address),
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
//            LazyColumn(content = )
        Text(modifier = Modifier.padding(top = 8.dp), text = stringResource(id = R.string.mock_description), style = MaterialTheme.typography.body2)
    }
}

@ExperimentalMaterialApi
@Composable
@Preview
fun EventBottomDialogPreview() {
    MainTheme {
        EventView()
    }
}