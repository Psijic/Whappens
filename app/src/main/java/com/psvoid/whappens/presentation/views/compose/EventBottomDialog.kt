package com.psvoid.whappens.presentation.views.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Domain
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LocationCity
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material.icons.filled.Today
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gowtham.ratingbar.ComposeStars
import com.gowtham.ratingbar.RatingBarStyle
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
        sheetPeekHeight = 166.dp,
        sheetBackgroundColor = MaterialTheme.colors.background,
        sheetContent = { EventView() }) { TopAppBar() }

//    coroutineScope.launch {
//        bottomSheetScaffoldState.bottomSheetState.collapse()
//    }

}

@Composable
fun EventView() {
    Column(Modifier.padding(8.dp)) {
        Row {
            // Image with date, title, type and buttons
            Image(
                modifier = Modifier.size(144.dp, 144.dp),
                painter = painterResource(R.drawable.discoveries),
                contentDescription = stringResource(id = R.string.event_image)
            )
            Column(
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Date and rating
                    Text(
                        text = "17:00 - 19:00, 04 Dec",
                        color = MaterialTheme.colors.secondary,
                        style = MaterialTheme.typography.body2
                    )
                    ComposeStars(
                        // RatingBar
                        value = 2.5f,
                        numStars = 3,
                        size = 16.dp,
                        padding = 1.dp,
                        activeColor = MaterialTheme.colors.secondary,
                        inactiveColor = MaterialTheme.colors.secondaryVariant,
                        ratingBarStyle = RatingBarStyle.Normal,
                    )
                }
                Text(
                    modifier = Modifier.height(52.dp),
                    text = "Event Title and there is The Second Line",
                    style = MaterialTheme.typography.h6,
                    maxLines = 2

                )
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 4.dp)) {
                    Icon(Icons.Default.Domain, contentDescription = null)
                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        text = "Conference, Science",
                        style = MaterialTheme.typography.body1,
                        maxLines = 1
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(onClick = { /*TODO*/ }) {
                        Icon(Icons.Default.FavoriteBorder, contentDescription = null)

                    }
                    Button(onClick = { /*TODO*/ }) {
                        Icon(Icons.Default.Today, contentDescription = null)
                    }
                    Button(onClick = { /*TODO*/ }) {
                        Icon(Icons.Default.StarBorder, contentDescription = null)
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
        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = stringResource(id = R.string.mock_description),
            style = MaterialTheme.typography.body2
        )
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