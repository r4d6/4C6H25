package ca.qc.cstj.composables.ui.screens.title

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import ca.qc.cstj.composables.R
import ca.qc.cstj.composables.ui.theme.ButtonBlue
import ca.qc.cstj.composables.ui.theme.TextWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleScreen(modifier: Modifier = Modifier,
                     viewModel: TitleScreenViewModel = viewModel(),
                navigateToMain:(name:String) -> Unit
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value

    Column(modifier = modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background),
horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(painter = painterResource(R.drawable.knight), contentDescription = stringResource(R.string.knight))
        Text(text = stringResource(R.string.knight), style = MaterialTheme.typography.displayLarge)
        OutlinedTextField(
            value = uiState.name,
            onValueChange = {viewModel.updateName(it)},
            label = {
                Text(text = stringResource(R.string.name))
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        OutlinedTextField(
            value = uiState.password,
            onValueChange = {viewModel.updatePassword(it)},
            label = {
                Text(text = stringResource(R.string.password))
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if(uiState.isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation('█'),
            trailingIcon = {
                IconButton(
                    onClick = {viewModel.togglePasswordVisibility()}
                ) {
                    if(uiState.isPasswordVisible)
                        Icon(imageVector = Icons.Filled.VisibilityOff, contentDescription = null)
                    else
                        Icon(imageVector = Icons.Filled.Visibility, contentDescription = null)
                }
            }
        )
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = ButtonBlue,
                contentColor = TextWhite
            ),
            onClick = {
                viewModel.login()
                if(!uiState.isError)
                    navigateToMain(uiState.name)
            }
        ){
            Text(
                text = stringResource(R.string.login),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}