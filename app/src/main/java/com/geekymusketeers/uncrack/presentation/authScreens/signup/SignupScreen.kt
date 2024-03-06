package com.geekymusketeers.uncrack.presentation.authScreens.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.geekymusketeers.uncrack.R
import com.geekymusketeers.uncrack.components.UCButton
import com.geekymusketeers.uncrack.components.UCTextField
import com.geekymusketeers.uncrack.ui.theme.DMSansFontFamily
import com.geekymusketeers.uncrack.ui.theme.OnPrimaryContainerLight
import com.geekymusketeers.uncrack.ui.theme.PrimaryLight
import com.geekymusketeers.uncrack.ui.theme.UnCrackTheme
import com.geekymusketeers.uncrack.ui.theme.medium16

class SignupScreen : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                Color.White.toArgb(), Color.White.toArgb()
            ),
            navigationBarStyle = SystemBarStyle.light(
                Color.White.toArgb(), Color.White.toArgb()
            )
        )
        super.onCreate(savedInstanceState)

        setContent {
            UnCrackTheme {
                SignupContent()
            }
        }
    }
}

@Composable
fun SignupContent(modifier: Modifier = Modifier) {

    val name by remember {
        mutableStateOf("")
    }

    val email by remember {
        mutableStateOf("")
    }

    val password by remember {
        mutableStateOf("")
    }

    var passwordVisibility by remember {
        mutableStateOf(false)
    }

    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {

            Text(
                text = "Sign In",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = DMSansFontFamily,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(60.dp))

            UCTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                headerText = stringResource(R.string.name_header),
                hintText = stringResource(R.string.name_hint),
                value = name,
                onValueChange = {

                }
            )

            Spacer(modifier = Modifier.height(30.dp))


            UCTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                headerText = stringResource(R.string.email_header),
                hintText = stringResource(R.string.email_hint),
                value = email,
                onValueChange = {

                }
            )

            Spacer(modifier = Modifier.height(30.dp))

            UCTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                headerText = stringResource(R.string.password_header),
                hintText = stringResource(R.string.password_hint),
                value = password,
                onValueChange = {},
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (passwordVisibility)
                        painterResource(id = R.drawable.visibility_on)
                    else painterResource(id = R.drawable.visibility_off)

                    IconButton(onClick =
                    { passwordVisibility = passwordVisibility.not() }
                    ) {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            painter = image,
                            contentDescription = null
                        )
                    }
                }
            )

            Spacer(modifier = Modifier.weight(1f))

            UCButton(
                modifier = Modifier
                    .fillMaxWidth(),
                text = stringResource(id = R.string.register),
                onClick = {
                    // TODO: Perform req operation and navigate to Home Screen
                },
                enabled = false
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row {
                Text(
                    text = stringResource(id = R.string.already_have_an_account),
                    style = medium16.copy(color = OnPrimaryContainerLight)
                )

                Text(
                    text = stringResource(id = R.string.login),
                    style = medium16.copy(color = PrimaryLight)
                )
            }
        }
    }
}