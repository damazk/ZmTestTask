package com.bulat.zmtesttask.presentation.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bulat.zmtesttask.R

@Composable
fun HomeScreen(
    onInfoClick: () -> Unit,
    onQuizClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(painterResource(R.drawable.home_bg))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 200.dp)
                .padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Fish Info",
                modifier = Modifier.padding(bottom = 5.dp),
                color = Color.White,
                fontSize = 29.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                "Immerse yourself in the amazing\nunderwater world",
                color = Color.White,
                textAlign = TextAlign.Start,
                fontSize = 16.sp
            )

            Button(
                modifier = Modifier.padding(top = 15.dp),
                onClick = onInfoClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color(0xFF133850)
                ),
                contentPadding = ButtonDefaults.ContentPadding
            ) {
                Text(
                    "Read",
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = "Fish Quiz",
                modifier = Modifier.padding(top = 80.dp, bottom = 5.dp),
                color = Color.White,
                fontSize = 29.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                "Immerse yourself in the amazing\nunderwater world",
                color = Color.White,
                textAlign = TextAlign.Start,
                fontSize = 16.sp
            )

            Button(
                modifier = Modifier.padding(top = 15.dp),
                onClick = onQuizClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color(0xFF133850)
                )
            ) {
                Text(
                    "Play",
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
} 