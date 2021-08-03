package com.psvoid.whappens.presentation.views.compose

import androidx.annotation.StringRes
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.android.material.composethemeadapter.MdcTheme
import com.psvoid.whappens.R

@Composable
fun TimeSelectDialog() {

    val mainButtonColor = ButtonDefaults.buttonColors(
        backgroundColor = colorResource(id = R.color.primaryLightColor)
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
                text = getString(R.string.select_range),
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
                    text = getString(R.string.future),
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
                    text = getString(R.string.today),
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
                    text = getString(R.string.week),
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
                    text = getString(R.string.month),
                    style = MaterialTheme.typography.h6,
                )
            }
        }
    }
}

@Composable
private fun getString(@StringRes resId: Int) = LocalContext.current.getString(resId)

//<!--        <com.google.android.material.button.MaterialButton-->
//<!--            android:id="@+id/button_range"-->
//<!--            style="@style/ButtonLight"-->
//<!--            android:layout_width="match_parent"-->
//<!--            android:layout_height="@dimen/button_height_big"-->
//<!--            android:text="@string/select_range"-->
//<!--            android:textSize="@dimen/font_big"-->
//<!--            app:icon="@drawable/ic_date_range_white_24dp"-->
//<!--            app:iconSize="@dimen/icon_medium"-->
//<!--            app:layout_constraintStart_toStartOf="parent"-->
//<!--            app:layout_constraintTop_toTopOf="parent" />-->

@Preview
@Composable
private fun TimeSelectDialogPreview() {
    ProvideWindowInsets {
        MdcTheme {
            TimeSelectDialog()
        }
    }
}
