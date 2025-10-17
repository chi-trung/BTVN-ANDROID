package com.example.baitaptuan3.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.baitaptuan3.R


@Composable
fun Screen_TextDetail(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {

        Column(
            modifier = Modifier.align(Alignment.TopCenter)
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
                    "Text Detail",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF87C9E1),
                    modifier = Modifier
                        .align (Alignment.Center)

                )

            }
        }

        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)

            ) {
                Text("The", fontSize = 24.sp)
                Text("quick", textDecoration = TextDecoration.LineThrough, fontSize = 24.sp)
                Text("Brown ", fontSize = 34.sp, color = Color(0xFFB87333))
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)

            ) {
                Text("fox", fontSize = 24.sp)
                Text("jumps", letterSpacing = 6.sp, fontSize = 24.sp)
                Text(
                    "over",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)

            ) {
                Text("the", fontSize = 24.sp, textDecoration = TextDecoration.Underline)
                Text(
                    "lazy",
                    fontSize = 24.sp,
                    fontFamily = FontFamily.Serif,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold
                )
                Text("dog.", fontSize = 24.sp)
            }
        }
    }
}
