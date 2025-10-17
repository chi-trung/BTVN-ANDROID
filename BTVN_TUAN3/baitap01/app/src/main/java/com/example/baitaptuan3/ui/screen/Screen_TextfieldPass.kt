package com.example.baitaptuan3.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.baitaptuan3.R


@Composable
fun Screen_TextfieldPass(navController: NavController) {
    var text_pass by remember { mutableStateOf("") }
    var password_check by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),

        horizontalAlignment = Alignment.CenterHorizontally


    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Image(
                painter = painterResource(R.drawable.back_icon),
                contentDescription = "Icon",
                modifier = Modifier
                    .align (Alignment.CenterStart)
                    .size(20.dp)
                    .clickable{navController.popBackStack()}
            )
            Text(
                "TextField Password",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF87C9E1),
                modifier = Modifier
                    .align (Alignment.Center)

            )

        }








        Spacer(modifier = Modifier.height(250.dp))
        OutlinedTextField(
            shape = RoundedCornerShape(15.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xFFC9F0FF),
                focusedContainerColor = Color.White
            ),
            value = text_pass,
            onValueChange = { text_pass = it },
            placeholder = {
                Text(
                    text = "Nhập Password ...",
                    color = Color.LightGray,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 5.dp)

                )
            }, modifier = Modifier
                .height(56.dp), // holder
            visualTransformation = if (password_check) VisualTransformation.None
            else PasswordVisualTransformation(),
            trailingIcon = {
                val icon_check = if (password_check) {
                    painterResource(id = R.drawable.visibility_on)
                } else {
                    painterResource(id = R.drawable.visibility_off)
                }
                IconButton(onClick = { password_check = !password_check }
                ) {
                    Icon(
                        painter = icon_check,
                        contentDescription = "Hiển thị mật khẩu",
                        modifier = Modifier
                            .size(20.dp)
                    )
                }


            },  keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)

        )

    }


}