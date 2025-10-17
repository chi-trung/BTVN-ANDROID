package com.example.baitaptuan3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.baitaptuan3.ui.screen.Screen_Box
import com.example.baitaptuan3.ui.screen.Screen_CheckBox
import com.example.baitaptuan3.ui.screen.Screen_CheckBox2
import com.example.baitaptuan3.ui.screen.Screen_Column
import com.example.baitaptuan3.ui.screen.Screen_Image
import com.example.baitaptuan3.ui.screen.Screen_Row
import com.example.baitaptuan3.ui.screen.Screen_TextDetail
import com.example.baitaptuan3.ui.screen.Screen_Textfield
import com.example.baitaptuan3.ui.screen.Screen_TextfieldPass
import com.example.baitaptuan3.ui.screen.Screen_components_list
import com.example.baitaptuan3.ui.theme.BaiTapTuan3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BaiTapTuan3Theme {
                Scaffold(modifier = Modifier.windowInsetsPadding(WindowInsets.safeDrawing)) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        App()
                    }

                }
            }
        }
    }
}

@Composable
fun App() {
    val controllScreen = rememberNavController()
    NavHost(
        navController = controllScreen, startDestination = "Screen_Home"
    ) {
        composable("Screen_Home") { ScreenHome(controllScreen) }
        composable("Screen_components_list") { Screen_components_list(controllScreen) }
        composable("Screen_TextDetail"){ Screen_TextDetail(controllScreen) }
        composable ("Screen_Image"){ Screen_Image(controllScreen) }
        composable ("Screen_Textfield"){ Screen_Textfield(controllScreen) }
        composable("Screen_TextfieldPass"){ Screen_TextfieldPass(controllScreen) }
        composable ("Screen_Column"){ Screen_Column(controllScreen) }
        composable ("Screen_Row"){ Screen_Row(controllScreen) }
        composable("Screen_Box"){ Screen_Box(controllScreen) }
        composable("Screen_CheckBox"){ Screen_CheckBox(controllScreen) }
        composable ("Screen_CheckBox2") {Screen_CheckBox2(controllScreen)}
    }

}



@Composable
fun ScreenHome(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),

        verticalArrangement = Arrangement.spacedBy(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,


        )
    {
        Image(
            painter = painterResource(id = R.drawable.jetpack_compose_logo),
            contentDescription = "JetpackCompose logo",
            modifier = Modifier
                .padding(top = 50.dp)
        )
        Text(
            "Jetpack Compose ", fontSize = 24.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 50.dp)
        )

        Text(
            text = "Jetpack Compose is a modern UI toolkit for building native Android" +
                    " applications using a declartive programming approach",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
        )

        Button(
            onClick = {
                navController.navigate("Screen_components_list")

            }, modifier = Modifier
                .width(250.dp)
                .padding(top = 60.dp),
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2899F7)
            )
        ) {
            Text("I'm ready")
        }

    }
}


