package com.bulat.zmtesttask.presentation.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import com.bulat.zmtesttask.presentation.Fish

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizScreen(onBackClick: () -> Unit, ) {
    val fishes = listOf(
        Fish(
            "Walleye",
            R.drawable.walleye
        ),
        Fish(
            "Pike",
            R.drawable.pike
        ),
        Fish(
            "Salmon",
            R.drawable.salmon
        ),
        Fish(
            "Tuna",
            R.drawable.tuna
        )
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                title = { },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
                navigationIcon = {
                    IconButton(
                        onClick = onBackClick,
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = Color.White,
                            contentColor = Color.DarkGray
                        )
                    ) {
                        Icon(Icons.Default.Home, contentDescription = "Back")
                    }
                }
            )
        },
    ) { paddings ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .paint(painterResource(R.drawable.quiz_bg))
                .padding(paddings)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Quiz",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(vertical = 16.dp),
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "What kind of fish migrates from the ocean to the rivers to spawn?",
                    modifier = Modifier.padding(vertical = 16.dp),
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                ) {
                    items(fishes) { fish ->
                        Column(
                            modifier = Modifier.padding(10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(fish.img),
                                contentDescription = "fish"
                            )
                            Text(
                                fish.name,
                                modifier = Modifier.padding(top = 20.dp),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
} 