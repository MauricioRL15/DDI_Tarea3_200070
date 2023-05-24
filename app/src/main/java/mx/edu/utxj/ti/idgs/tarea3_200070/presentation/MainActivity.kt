/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package mx.edu.utxj.ti.idgs.tarea3_200070.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import mx.edu.utxj.ti.idgs.tarea3_200070.R
import mx.edu.utxj.ti.idgs.tarea3_200070.presentation.theme.Tarea3_200070Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           FondoPersonalizado()
        }
    }
}

@Composable
fun FondoPersonalizado(){
    Box(modifier = Modifier.fillMaxSize()){
        val imagenFondo = painterResource(R.drawable.img1)
        Image(
            painter = imagenFondo,
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        CambiaColor("Tarea3_200070 Mau!")
    }
}

@Composable
fun CambiaColor(text: String){
    var esVisible by remember { mutableStateOf(true) }

    val color by animateColorAsState(
        targetValue = if (esVisible) Color.Green else Color.White,
        animationSpec = tween(durationMillis = 100)
    )
    AnimatedVisibility(visible = esVisible) {
        Text(
            text = text,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            color = color,
            fontFamily = FontFamily.Serif,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 75.dp)
        )
    }
    LaunchedEffect(key1 = esVisible) {
        esVisible = !esVisible
    }

}