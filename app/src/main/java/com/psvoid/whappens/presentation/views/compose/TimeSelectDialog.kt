package com.psvoid.whappens.presentation.views.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.ProvideWindowInsets
import com.psvoid.whappens.R
import com.psvoid.whappens.presentation.themes.MainTheme

@Composable
fun TimeSelectDialog() {

    val mainButtonColor = ButtonDefaults.buttonColors(
        backgroundColor = MaterialTheme.colors.primaryVariant,
        contentColor = MaterialTheme.colors.onPrimary
    )
    Column {
        OutlinedButton(
            onClick = {},
            colors = mainButtonColor,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
        ) {
            Icon(
                Icons.Filled.DateRange,
                contentDescription = null,
                modifier = Modifier.size(dimensionResource(R.dimen.icon_medium))
            )
            Text(
                text = stringResource(R.string.select_range),
                style = MaterialTheme.typography.h6,
            )
        }
        Row {
            OutlinedButton(
                onClick = {},
                colors = mainButtonColor,
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    Icons.Filled.DateRange,
                    contentDescription = null,
                    modifier = Modifier.size(dimensionResource(R.dimen.icon_medium))
                )
                Text(
                    text = stringResource(R.string.future),
                    style = MaterialTheme.typography.h6,
                )
            }
            OutlinedButton(
                onClick = {},
                colors = mainButtonColor,
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    Icons.Filled.DateRange,
                    contentDescription = null,
                    modifier = Modifier.size(dimensionResource(R.dimen.icon_medium))
                )
                Text(
                    text = stringResource(R.string.today),
                    style = MaterialTheme.typography.h6,
                )
            }
        }
        Row {
            OutlinedButton(
                onClick = {},
                colors = mainButtonColor,
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    Icons.Filled.DateRange,
                    contentDescription = null,
                    modifier = Modifier.size(dimensionResource(R.dimen.icon_medium))
                )
                Text(
                    text = stringResource(R.string.week),
                    style = MaterialTheme.typography.h6,
                )
            }
            OutlinedButton(
                onClick = {},
                colors = mainButtonColor,
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    Icons.Filled.DateRange,
                    contentDescription = null,
                    modifier = Modifier.size(dimensionResource(R.dimen.icon_medium))
                )
                Text(
                    text = stringResource(R.string.month),
                    style = MaterialTheme.typography.h6,
                )
            }
        }
    }
}

@Preview
@Composable
private fun TimeSelectDialogPreview() {
    ProvideWindowInsets {
        MainTheme {
            TimeSelectDialog()
        }
    }
}
