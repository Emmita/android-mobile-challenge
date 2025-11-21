package emmanuel.avila.androidchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import emmanuel.avila.androidchallenge.navigation.NavigationHost
import emmanuel.avila.androidchallenge.ui.theme.AndroidChallengeTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidChallengeTheme {
                Scaffold(topBar = {
                    TopAppBar(
                        title = {
                            Text("Gallery")
                        },
                    )
                }) { innerPadding ->

                    Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
                        NavigationHost()
                    }
                }
            }
        }
    }
}
