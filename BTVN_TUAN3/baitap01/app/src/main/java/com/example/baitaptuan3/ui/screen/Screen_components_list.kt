package com.example.baitaptuan3.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.baitaptuan3.R


@Composable
fun Screen_components_list(navController: NavController) {
    val scroll = rememberScrollState()
    Column(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxSize()
            .verticalScroll(scroll),
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
                "UI Components list",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF87C9E1),
                modifier = Modifier
                    .align (Alignment.Center)

            )

        }




        Text(
            "Display", fontSize = 18.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 40.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .border(1.dp, Color.Transparent, RoundedCornerShape(8.dp))
                .background(Color(0xFFBBDEFC), shape = RoundedCornerShape(8.dp))
                .padding(10.dp)

        ) {
            Column() {

                Text(
                    "Text", fontSize = 16.sp, fontWeight = FontWeight.Bold,
                    modifier = Modifier


                )

                Text(
                    "Displays text",
                    color = Color(0xFF25ABE8),
                    textDecoration = TextDecoration.Underline,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .clickable { navController.navigate("Screen_TextDetail") }

                )
            }
        } // box display text
        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .border(1.dp, Color.Transparent, RoundedCornerShape(8.dp))
                .background(Color(0xFFBBDEFC), shape = RoundedCornerShape(8.dp))
                .padding(10.dp)

        ) {
            Column() {

                Text(
                    "Image", fontSize = 16.sp, fontWeight = FontWeight.Bold,
                    modifier = Modifier

                )

                Text(
                    "Displays an image",
                    color = Color(0xFF25ABE8),
                    textDecoration = TextDecoration.Underline,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .clickable { navController.navigate("Screen_Image") }

                )
            }
        } // box display Image

        Text(
            "Input", fontSize = 18.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 30.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .border(1.dp, Color.Transparent, RoundedCornerShape(8.dp))
                .background(Color(0xFFBBDEFC), shape = RoundedCornerShape(8.dp))
                .padding(10.dp)

        ) {
            Column() {

                Text(
                    "TextField", fontSize = 16.sp, fontWeight = FontWeight.Bold,
                    modifier = Modifier

                )

                Text(
                    "Input field for text",
                    color = Color(0xFF25ABE8),
                    textDecoration = TextDecoration.Underline,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .clickable { navController.navigate("Screen_Textfield") }

                )
            }
        } // box display TextField
        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .border(1.dp, Color.Transparent, RoundedCornerShape(8.dp))
                .background(Color(0xFFBBDEFC), shape = RoundedCornerShape(8.dp))
                .padding(10.dp)

        ) {
            Column() {

                Text(
                    "PasswordField", fontSize = 16.sp, fontWeight = FontWeight.Bold,
                    modifier = Modifier

                )

                Text(
                    "Input field for passwords",
                    color = Color(0xFF25ABE8),
                    textDecoration = TextDecoration.Underline,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .clickable { navController.navigate("Screen_TextfieldPass") }

                )
            }
        } // box display PasswordField

        Text(
            "Layout", fontSize = 18.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 30.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .border(1.dp, Color.Transparent, RoundedCornerShape(8.dp))
                .background(Color(0xFFBBDEFC), shape = RoundedCornerShape(8.dp))
                .padding(10.dp)

        ) {
            Column() {

                Text(
                    "Column", fontSize = 16.sp, fontWeight = FontWeight.Bold,
                    modifier = Modifier


                )

                Text(
                    "Arranges elements vertically",
                    color = Color(0xFF25ABE8),
                    textDecoration = TextDecoration.Underline,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .clickable { navController.navigate("Screen_Column") }

                )
            }
        } // box display column

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .border(1.dp, Color.Transparent, RoundedCornerShape(8.dp))
                .background(Color(0xFFBBDEFC), shape = RoundedCornerShape(8.dp))
                .padding(10.dp)

        ) {
            Column() {

                Text(
                    "Row", fontSize = 16.sp, fontWeight = FontWeight.Bold,
                    modifier = Modifier

                )

                Text(
                    "Arranges elements horizontally",
                    color = Color(0xFF25ABE8),
                    textDecoration = TextDecoration.Underline,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .clickable { navController.navigate("Screen_Row") }

                )
            }
        } // box display row

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .border(1.dp, Color.Transparent, RoundedCornerShape(8.dp))
                .background(Color(0xFFBBDEFC), shape = RoundedCornerShape(8.dp))
                .padding(10.dp)

        ) {
            Column() {

                Text(
                    "Box", fontSize = 16.sp, fontWeight = FontWeight.Bold,
                    modifier = Modifier

                )

                Text(
                    "Display Box layout",
                    color = Color(0xFF25ABE8),
                    textDecoration = TextDecoration.Underline,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .clickable { navController.navigate("Screen_Box") }

                )
            }
        } // box display Box

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .border(1.dp, Color.Transparent, RoundedCornerShape(8.dp))
                .background(Color(0xFFBBDEFC), shape = RoundedCornerShape(8.dp))
                .padding(10.dp)

        ) {
            Column() {

                Text(
                    "Checkbox", fontSize = 16.sp, fontWeight = FontWeight.Bold,
                    modifier = Modifier

                )

                Text(
                    "Display Checkbox layout",
                    color = Color(0xFF25ABE8),
                    textDecoration = TextDecoration.Underline,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .clickable { navController.navigate("Screen_CheckBox") }

                )
            }
        } // box display Checkbox

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .border(1.dp, Color.Transparent, RoundedCornerShape(8.dp))
                .background(Color(0xFFBBDEFC), shape = RoundedCornerShape(8.dp))
                .padding(10.dp)

        ) {
            Column() {

                Text(
                    "Checkbox", fontSize = 16.sp, fontWeight = FontWeight.Bold,
                    modifier = Modifier

                )

                Text(
                    "Display Box layout",
                    color = Color(0xFF25ABE8),
                    textDecoration = TextDecoration.Underline,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .clickable { navController.navigate("Screen_CheckBox2") }

                )
            }
        } // box display Checkbox2
    } // main column

}
