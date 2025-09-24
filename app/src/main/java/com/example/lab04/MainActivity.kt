package com.example.lab04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab04.ui.theme.DarkGray
import com.example.lab04.ui.theme.Lab04Theme
import com.example.lab04.ui.theme.OrangeJBL
import com.example.lab04.ui.theme.White
import com.example.lab04.ui.theme.Black

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab04Theme {
                var sliderPosition by remember { mutableStateOf(0f) }
                val backgroundColor = lerp(DarkGray, White, sliderPosition)

                Scaffold(
                    topBar = {
                        // Nuevo TopAppBar agregado aquí
                        TopAppBar(
                            title = {
                                Text(
                                    text = "Lab04_OVIEDO",
                                    color = OrangeJBL,
                                    fontWeight = FontWeight.Bold
                                )
                            },
                            colors = TopAppBarDefaults.topAppBarColors(containerColor = DarkGray)
                        )
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(backgroundColor)
                            .padding(innerPadding),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            // Elemento de imagen
                            Image(
                                painter = painterResource(id = R.drawable.oso),
                                contentDescription = "oso",
                                modifier = Modifier
                                    .size(100.dp)
                                    .padding(bottom = 16.dp)
                            )

                            // Texto principal "Android"
                            Text(
                                text = "Android",
                                fontSize = 48.sp,
                                fontWeight = FontWeight.Black,
                                color = Black,
                                modifier = Modifier.padding(bottom = 32.dp)
                            )

                            // Tarjeta para el commit
                            Card(
                                modifier = Modifier
                                    .size(width = 150.dp, height = 50.dp)
                                    .clip(RoundedCornerShape(8.dp)),
                                colors = CardDefaults.cardColors(
                                    containerColor = OrangeJBL,
                                    contentColor = Black
                                )
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxSize(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "COMMIT 4",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }

                            // Slider para la opacidad del fondo
                            Slider(
                                value = sliderPosition,
                                onValueChange = { sliderPosition = it },
                                modifier = Modifier.padding(top = 32.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    // This composable is no longer used directly in setContent,
    // but remains for preview purposes. The main logic is now in the setContent block.
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab04Theme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(DarkGray)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Título del proyecto
            Text(
                text = "LAB04 - Proyecto de Ejemplo",
                fontSize = 20.sp,
                color = White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Elemento de imagen
            Image(
                painter = painterResource(id = R.drawable.oso),
                contentDescription = "oso",
                modifier = Modifier
                    .size(100.dp)
                    .padding(bottom = 16.dp)
            )

            // Texto principal "Android"
            Text(
                text = "Android",
                fontSize = 48.sp,
                fontWeight = FontWeight.Black,
                color = White,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            // Tarjeta para el commit
            Card(
                modifier = Modifier
                    .size(width = 150.dp, height = 50.dp)
                    .clip(RoundedCornerShape(8.dp)),
                colors = CardDefaults.cardColors(
                    containerColor = OrangeJBL,
                    contentColor = Black
                )
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "COMMIT 1",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}