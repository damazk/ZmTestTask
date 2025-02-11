package com.bulat.zmtesttask.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bulat.zmtesttask.ui.model.TabItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TabCard(
    tabs: List<TabItem>,
    modifier: Modifier = Modifier
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(370.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0x360A1A2F)) // Темный фон
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            TabRow(
                modifier = Modifier.fillMaxWidth(),
                selectedTabIndex = selectedTabIndex,
                containerColor = Color.Transparent,
                indicator = { tabPositions ->
                    Box(
                        Modifier
                            .tabIndicatorOffset(tabPositions[selectedTabIndex])
                            .height(2.dp)
                            .background(Color.White)
                    )
                }
            ) {
                tabs.forEachIndexed { index, tab ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        text = {
                            Text(
                                tab.title,
                                color = if (selectedTabIndex == index) Color.White else Color.LightGray
                            )
                        }
                    )
                }
            }

            Text(
                text = tabs[selectedTabIndex].title,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = tabs[selectedTabIndex].content,
                modifier = Modifier.padding(bottom = 16.dp),
                color = Color.White
            )

            Row(
                modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row {
                    tabs.indices.forEach { index ->
                        Box(
                            modifier = Modifier
                                .size(15.dp)
                                .padding(4.dp)
                                .background(
                                    color = if (selectedTabIndex == index) Color.White else Color.Gray,
                                    shape = CircleShape
                                )
                        )
                    }
                }

                Row {
                    IconButton(
                        onClick = { if (selectedTabIndex > 0) selectedTabIndex-- },
                        modifier = Modifier
                            .size(25.dp)
                            .background(Color(0xFF26495B), shape = CircleShape)
                    ) {
                        Icon(Icons.Default.KeyboardArrowLeft, contentDescription = "Back", tint = Color.White)
                    }

                    Spacer(modifier = Modifier.width(30.dp))

                    IconButton(
                        onClick = { if (selectedTabIndex < tabs.size - 1) selectedTabIndex++ },
                        modifier = Modifier
                            .size(25.dp)
                            .background(Color(0xFF26495B), shape = CircleShape)
                    ) {
                        Icon(Icons.Default.KeyboardArrowRight, contentDescription = "Back", tint = Color.White)
                    }
                }
            }
        }
    }
}
