package com.example.iconwordofwisdom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults.color
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarDefaults.color
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.iconwordofwisdom.ui.theme.IconWordOfWisdomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var icon_fname by remember {
                mutableStateOf("")
            }
            
            var words_of_wisdom by remember {
                mutableStateOf("")
            }
            
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFFF5733)),

            ) {
                Text(
                    text = "Icon Word of Wisdom",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Black,
                    fontFamily = FontFamily.Serif
                )

                Divider()
                Spacer(modifier = Modifier.size(30.dp))

                OutlinedTextField(
                    value = icon_fname, 
                    onValueChange = {text ->
                        icon_fname = text
                    },
                    placeholder = {
                        Text(text = "Enter first name of SA icon")
                    }
                )

                Spacer(modifier = Modifier.size(30.dp))
                Row {
                    Button(onClick = {
                        words_of_wisdom = when(icon_fname){
                            "Nelson" -> "It always seems impossible until it's done."
                            "Miriam" -> "Girls are the future mothers of our society, and it is important that we focus on their well-being."
                            "Lucas" -> "I want to be remembered as someone who gave everything for his country and the game."
                            else -> "Invalid icon first name! Try again"
                        }
                    }) {
                        Text(text = "Search")
                    }
                    Button(onClick = {
                        icon_fname = ""
                        words_of_wisdom = ""
                    }) {
                        Text(text = "Clear")
                    }
                }

                Text(text = "Word of wisdom by $icon_fname is:")
                Text(text = words_of_wisdom)
            }
        }
    }
}