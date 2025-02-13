package com.bulat.zmtesttask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.bulat.zmtesttask.navigation.ZmNavigation
import com.bulat.zmtesttask.ui.theme.ZmTestTaskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ZmTestTaskTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    ZmNavigation()
                }
            }
        }
    }
}