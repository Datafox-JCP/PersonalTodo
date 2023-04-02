package mx.datafox.personaltodo.ui.screens.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import mx.datafox.personaltodo.R
import mx.datafox.personaltodo.ui.theme.BIG_ICON_SIZE
import mx.datafox.personaltodo.ui.theme.MediumGray

@Composable
fun EmptyContent() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.size(BIG_ICON_SIZE),
            painter = painterResource(id = R.drawable.sentiment_face),
            contentDescription = stringResource(R.string.smile_face_icon),
            tint = MediumGray
        )

        Text(
            stringResource(R.string.no_pending_tasks),
            color = MediumGray,
            fontWeight = FontWeight.SemiBold,
            fontSize = MaterialTheme.typography.h5.fontSize
        )
    }
}

@Composable
@Preview
fun EmptyContentPreview() {
    EmptyContent()
}