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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab04.R // Asegúrate de que esta línea esté presente
import com.example.lab04.ui.theme.DarkGray
import com.example.lab04.ui.theme.Lab04Theme
import com.example.lab04.ui.theme.OrangeJBL
import com.example.lab04.ui.theme.White
import com.example.lab04.ui.theme.Black

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab04Theme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(DarkGray)
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(DarkGray)
                            .padding(innerPadding),
                        contentAlignment = Alignment.Center
                    ) {
                        Greeting(name = "Android")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(16.dp),
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

        // Elemento de imagen (nuevo)
        Image(
            painter = painterResource(id = R.drawable.oso), // Referencia a tu archivo oso.png
            contentDescription = "oso",
            modifier = Modifier.size(100.dp).padding(bottom = 16.dp)
        )

        // Texto principal "Android"
        Text(
            text = name,
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
                    text = "COMMIT 2",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab04Theme {
        Greeting("Android")
    }
}
