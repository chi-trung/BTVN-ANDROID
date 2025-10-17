package com.example.baitaptuan3.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.baitaptuan3.R


@Composable
fun Screen_Column(navController: NavController) {
    val scroll = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
            .verticalScroll(scroll),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)

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
                "Column layout",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF87C9E1),
                modifier = Modifier
                    .align (Alignment.Center)

            )

        }




        Spacer(modifier = Modifier.height(20.dp))

        Image(
            painter = painterResource(id = R.drawable.image_2),
            contentDescription = "image_2",
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))

        )

        Image(
            painter = painterResource(id = R.drawable.image_3),
            contentDescription = "image_3",
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))

        )

        Image(
            painter = painterResource(id = R.drawable.image_4),
            contentDescription = "image_4",
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
        )

        Image(
            painter = painterResource(id = R.drawable.image_5),
            contentDescription = "image_5",
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
        )
    }
}