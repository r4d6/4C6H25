package ca.qc.cstj.composables.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.NightsStay
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.SelfImprovement
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import ca.qc.cstj.composables.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBar() {
    NavigationBar (
        containerColor = Color.Transparent


    ){
        NavigationBarItem(
            selected = false,
            onClick = {},
            label = {
                Text(text = stringResource(R.string.home))
            },
            icon = {
                Icon(imageVector = Icons.Default.Home, contentDescription = stringResource(R.string.home))
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            label = {
                Text(text = stringResource(R.string.meditate))
            },
            icon = {
                Icon(imageVector = Icons.Default.SelfImprovement, contentDescription = stringResource(R.string.meditate))
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            label = {
                Text(text = stringResource(R.string.sleep))
            },
            icon = {
                Icon(imageVector = Icons.Default.NightsStay, contentDescription = stringResource(R.string.sleep))
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            label = {
                Text(text = stringResource(R.string.music))
            },
            icon = {
                Icon(imageVector = Icons.Default.MusicNote, contentDescription = stringResource(R.string.music))
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            label = {
                Text(text = stringResource(R.string.profile))
            },
            icon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = stringResource(R.string.profile))
            }
        )
    }
}