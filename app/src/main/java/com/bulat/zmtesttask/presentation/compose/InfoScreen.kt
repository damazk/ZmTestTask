package com.bulat.zmtesttask.presentation.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bulat.zmtesttask.R
import com.bulat.zmtesttask.core.components.TabCard
import com.bulat.zmtesttask.ui.model.TabItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoScreen(
    onBackClick: () -> Unit
) {
    val tabs = listOf(
        TabItem(
            title = "Benefit",
            content = "It is rich in omega-3 fatty acids, which strengthen the heart and blood vessels. " +
                    "It contains protein, vitamin D, selenium and antioxidants."
        ),
        TabItem(
            title = "Reproduction",
            content = "It spawns in fresh water. After spawning, adults often die, and juveniles migrate " +
                    "to the ocean for further growth."
        )
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                title = {},
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
                .paint(painterResource(R.drawable.info_bg))
                .padding(paddings)
                .padding(16.dp)
        ) {

            Text(
                modifier = Modifier.padding(top = 200.dp, bottom = 16.dp),
                text = "Salmon",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = "Anadromous fish, migrates from oceans to rivers to spawn. " +
                        "It reaches a length of up to 150 cm and a weight of up to 40 kg. " +
                        "It lives in the northern seas and rivers.",
                color = Color.White
            )

            Spacer(modifier = Modifier.height(16.dp))

            TabCard(tabs = tabs)
        }
    }
} 