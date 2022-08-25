package com.example.crypto

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.crypto.ui.theme.*

data class Actions(val color: Color, val image: Int, val text: String)
data class Movers(val procent: String, val dollar: String, val color: Color, val image: Int)

@Composable
fun HomeScreen() {
    val listActions = listOf(
        Actions(Pink, R.drawable.hands, "Receive"),
        Actions(LightPurple, R.drawable.ca, "Send"),
        Actions(PurpleGray, R.drawable.half, "Swap"),
    )
    val listMovers = listOf(
        Movers("+34.98%", "$21.58", Purple, R.drawable.graphpu),
        Movers("+66.25%", "$35.16", Pink, R.drawable.graphp),

        )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
            .verticalScroll(state = rememberScrollState())
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp, horizontal = 24.dp)
        ) {
            Column(horizontalAlignment = Alignment.Start) {
                Text(
                    "Hello Anna",
                    textAlign = TextAlign.Start,
                    fontSize = 24.sp,
                    color = Pink,
                )
                Text(
                    "Welcome Back!",
                    textAlign = TextAlign.Start,
                    fontSize = 32.sp,
                    color = Black,
                )
            }
            IconButton(
                onClick = { /*TODO*/ }, modifier = Modifier.align(CenterVertically)
                    .clip(RoundedCornerShape(8.dp))
                    .size(44.dp)
                    .background(LightGray)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.not),
                    contentDescription = null,
                    tint = Purple,
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .size(20.dp)
                        .background(LightGray),
                )
            }

        }

        Spacer(modifier = Modifier.height(55.dp))

        Box(
            Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.bacimage),
                contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterEnd),
                contentScale = ContentScale.Crop,

                )
            Image(
                painter = painterResource(id = R.drawable.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
                modifier = Modifier
                    .height(194.dp)
                    .width(127.dp)
                    .align(Alignment.CenterEnd)
            )
            Column(modifier = Modifier.padding(start = 20.dp, top = 40.dp)) {
                Text(
                    "2.70% Today",
                    textAlign = TextAlign.Start,
                    fontSize = 13.sp,
                    color = Pink,
                )
                Text(
                    "$12,670.90",
                    textAlign = TextAlign.Center,
                    fontSize = 32.sp,
                    color = Color.White,
                )
                Spacer(modifier = Modifier.height(40.dp))
                IconButton(
                    onClick = { /*TODO*/ }, modifier = Modifier
                        .clip(RoundedCornerShape(50.dp))
                        .size(49.dp)
                        .background(Pink)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }


            }


        }
        Spacer(modifier = Modifier.height(45.dp))
        Text(
            "Actions",
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            color = Black,
        )
        LazyRow() {
            items(listActions.size) { index ->
                Card(
                    Modifier.padding(8.dp),
                    backgroundColor = listActions[index].color,
                    shape = RoundedCornerShape(30.dp)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp)) {
                        Image(
                            painter = painterResource(id = listActions[index].image),
                            contentDescription = null,
                            modifier = Modifier
                                .align(Alignment.End)
                                .size(110.dp)
                        )
                        Spacer(modifier = Modifier.height(18.dp))
                        Row(horizontalArrangement = Arrangement.Center) {
                            Text(listActions[index].text, color = Color.White, fontSize = 16.sp, textAlign = TextAlign.Center, modifier = Modifier.align(CenterVertically))
                            IconButton(onClick = { /*TODO*/ },modifier = Modifier.align(CenterVertically),) {
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowRight,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(15.dp).align(CenterVertically)
                                )
                            }
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            "Top Movers",
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            color = Black,
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyRow() {
            items(listMovers.size) { index ->
                Card(
                    Modifier
                        .padding(8.dp)
                        .width(161.dp)
                        .height(88.dp),
                    backgroundColor = LightGray,
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Column( modifier = Modifier.padding(top=12.dp,start=14.dp,end=12.dp)) {


                        Text(listMovers[index].procent, color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Start)
                        Text("BTC "+ listMovers[index].dollar, color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Start)
                        Image(
                            painter = painterResource(id = listMovers[index].image),
                            contentDescription = null,
                            modifier = Modifier
                                .align(End)
                                .height(24.dp)
                                .width(72.dp),
                            contentScale = ContentScale.Crop
                        )

                    }
                }
            }
        }
        Spacer(Modifier.height(100.dp))
    }

}

@Composable
fun MarketScreen() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Icon(
            imageVector = Icons.Default.ShoppingCart,
            contentDescription = null,
            tint = LightPurple
        )
    }
}

@Composable
fun WalletScreen() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Icon(imageVector = Icons.Default.ThumbUp, contentDescription = null, tint = LightPurple)
    }
}

@Composable
fun SettingsScreen() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Icon(imageVector = Icons.Default.Settings, contentDescription = null, tint = LightPurple)
    }
}