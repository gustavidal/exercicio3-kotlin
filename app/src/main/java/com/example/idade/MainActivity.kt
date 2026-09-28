package com.example.idade

import android.R.attr.onClick
import android.R.attr.text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.idade.ui.theme.IdadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IdadeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    var idade by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF9F8FC)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Qual é a sua idade?",
            fontSize = 28.sp,
            color = Color(0xFF4958B1)
        )
        Text(
            text = "Aperte os botões para informar sua idade",
            fontSize = 16.sp,
            color = Color(0xFF313138)
        )

        Spacer(
            modifier = Modifier
                .height(20.dp)
        )

        Text(
            text = "$idade",
            fontSize = 30.sp,
            color = Color(0xFF2F3238)
        )

        Spacer(
            modifier = Modifier
                .height(20.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    if (idade > 0) {
                        idade--
                    } else {
                        idade = 180
                    }
                },
                modifier = Modifier
                    .size(60.dp),
                shape = RoundedCornerShape(
                    topStart = 10.dp,
                    topEnd = 10.dp,
                    bottomStart = 10.dp,
                    bottomEnd = 10.dp
                )
            ) {
                Text(
                    text = "-",
                    fontSize = 32.sp,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(
                modifier = Modifier
                    .width(16.dp)
            )

            Button(
                onClick = {
                    if (idade < 180) {
                        idade++
                    } else {
                        idade = 0
                    }
                },
                modifier = Modifier
                    .size(60.dp),
                shape = RoundedCornerShape(
                    topStart = 10.dp,
                    topEnd = 10.dp,
                    bottomStart = 10.dp,
                    bottomEnd = 10.dp
                )
            ) {
                Text(
                    text = "+",
                    fontSize = 32.sp,
                    textAlign = TextAlign.Center
                )
            }
        }

        Spacer(
            modifier = Modifier
                .height(20.dp)
        )

        var statusIdade: String = if (idade < 18) {
            "MENOR"
        } else {
            "MAIOR"
        }

        Text(
            text = "Você é $statusIdade de idade",
            fontSize = 28.sp,
            color = Color(0xFF4958B1)
        )
    }
}