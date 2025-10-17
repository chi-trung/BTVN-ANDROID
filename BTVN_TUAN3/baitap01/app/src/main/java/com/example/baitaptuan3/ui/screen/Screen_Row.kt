package com.example.baitaptuan3.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.baitaptuan3.R

@Composable
fun Screen_Row(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)

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
                "Row layout",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF87C9E1),
                modifier = Modifier
                    .align (Alignment.Center)

            )

        }


        Spacer(modifier = Modifier.height(80.dp))



        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .background(Color(0xFFA4D1E1), shape = RoundedCornerShape(15.dp))
                .padding(10.dp),
        ) {
            image(R.drawable.icon_1)
            image(R.drawable.icon_2)
            image(R.drawable.icon_3)
            image(R.drawable.icon_4)
            image(R.drawable.icon_5)
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .background(Color(0xFFC7A885), shape = RoundedCornerShape(15.dp))
                .padding(10.dp),
        ) {
            image(R.drawable.icon_6)
            image(R.drawable.icon_7)
            image(R.drawable.icon_8)
            image(R.drawable.icon_9)
            image(R.drawable.icon_10)
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .background(Color(0xFFD23762), shape = RoundedCornerShape(15.dp))
                .padding(10.dp),
        ) {
            image(R.drawable.icon_11)
            image(R.drawable.icon_12)
            image(R.drawable.icon_13)
            image(R.drawable.icon_14)
            image(R.drawable.icon_15)

        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .background(Color(0xFFD497E0), shape = RoundedCornerShape(15.dp))
                .padding(10.dp),
        ) {
            image(R.drawable.icon_6)
            image(R.drawable.icon_7)
            image(R.drawable.icon_8)
            image(R.drawable.icon_9)
            image(R.drawable.icon_10)
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .background(Color(0xFFDCAB55), shape = RoundedCornerShape(15.dp))
                .padding(10.dp),
        ) {
            image(R.drawable.icon_1)
            image(R.drawable.icon_2)
            image(R.drawable.icon_3)
            image(R.drawable.icon_4)
            image(R.drawable.icon_5)
        }
    }
}

@Composable
fun image(painter1: Int) {

    Image(
        painter = painterResource(painter1),
        contentDescription = "Icon",
        modifier = Modifier
            .size(50.dp)
    )


}