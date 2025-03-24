package com.example.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val primaryBlue = Color(0xFF1E88E5)

            var num1 by remember { mutableStateOf("0") }
            var num2 by remember { mutableStateOf("0") }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Calculator",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = primaryBlue,
                    modifier = Modifier.padding(bottom = 24.dp)
                )

                TextField(
                    value = num1,
                    onValueChange = { num1 = it },
                    label = { Text("First Number", color = primaryBlue) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedIndicatorColor = primaryBlue,
                        unfocusedIndicatorColor = primaryBlue,
                        cursorColor = primaryBlue
                    )
                )

                TextField(
                    value = num2,
                    onValueChange = { num2 = it },
                    label = { Text("Second Number", color = primaryBlue) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedIndicatorColor = primaryBlue,
                        unfocusedIndicatorColor = primaryBlue,
                        cursorColor = primaryBlue
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = {
                            val result = num1.toInt() + num2.toInt()
                            Toast.makeText(applicationContext, "Result is $result", Toast.LENGTH_SHORT).show()
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = primaryBlue)
                    ) {
                        Text(text = "+ Add", color = Color.White)
                    }

                    Button(
                        onClick = {
                            val result = num1.toInt() - num2.toInt()
                            Toast.makeText(applicationContext, "Result is $result", Toast.LENGTH_SHORT).show()
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = primaryBlue)
                    ) {
                        Text(text = "- Sub", color = Color.White)
                    }

                    Button(
                        onClick = {
                            val result = num1.toInt() * num2.toInt()
                            Toast.makeText(applicationContext, "Result is $result", Toast.LENGTH_SHORT).show()
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = primaryBlue)
                    ) {
                        Text(text = "× Mul", color = Color.White)
                    }

                    Button(
                        onClick = {
                            val result = num1.toInt() / num2.toInt()
                            Toast.makeText(applicationContext, "Result is $result", Toast.LENGTH_SHORT).show()
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = primaryBlue)
                    ) {
                        Text(text = "÷ Div", color = Color.White)
                    }
                }
            }
        }
    }
}