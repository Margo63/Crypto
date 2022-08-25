package com.example.crypto

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.crypto.ui.theme.Pink
import com.example.crypto.ui.theme.Purple

@Composable
fun StartScreen(navHostController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Purple), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(id = R.drawable.cloud),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            "Convert cash into crypto, simply",
            textAlign = TextAlign.Center,
            fontSize = 32.sp,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 47.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            "Connect your bank account and get access to more than 76000 crypto\n" +
                    "currencies and tokens.",
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 70.dp)
        )
        Spacer(modifier = Modifier.height(50.dp))
        Button(onClick = {
            navHostController.navigate(Screen.Main.route) {
                popUpTo(Screen.Main.route) {
                    inclusive = true
                }
            }

        }, colors = ButtonDefaults.buttonColors(Pink), shape = RoundedCornerShape(40.dp)) {
            Row(horizontalArrangement = Arrangement.Center) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(50.dp))
                        .background(Purple)
                        .size(57.dp)
                        .align(CenterVertically),
                )
                Text(
                    "Get Started",
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 32.dp)
                )
            }
        }
    }
}