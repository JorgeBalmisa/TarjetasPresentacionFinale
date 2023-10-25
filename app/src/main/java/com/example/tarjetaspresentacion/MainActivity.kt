package com.example.tarjetaspresentacion

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tarjetaspresentacion.ui.theme.TarjetasPresentacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TarjetasPresentacionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}
fun main() {
// cómo instanciar objetos de la clase TarjetaPresentacion

}
class TarjetaPresentacion {
    @Composable
    fun TarjetaPresentacion(
        imagenPersona: Painter,
        nombrePersona: String,
        infoPersona: String,
        gifPersona: Painter,
        info1: String,
        info2: String,
        info3: String,
        modifier: Modifier = Modifier
    ) {
        Column(modifier = modifier) {
            Image(painter = imagenPersona, contentDescription = null)
            Text(
                text = nombrePersona,
                fontSize = 16.sp,
                modifier = modifier.padding(16.dp),
                textAlign = TextAlign.Center,
            )

            Image(painter = gifPersona, contentDescription = null)

            Text(
                text = infoPersona,
                fontSize = 16.sp,
                modifier = modifier.padding(16.dp),
                textAlign = TextAlign.Center,
            )

            Text(
                text = info1,
                fontSize = 16.sp,
                modifier = modifier.padding(16.dp),
                textAlign = TextAlign.Center,
            )

            Text(
                text = info2,
                fontSize = 16.sp,
                modifier = modifier.padding(16.dp),
                textAlign = TextAlign.Center,
            )

            Text(
                text = info3,
                fontSize = 16.sp,
                modifier = modifier.padding(16.dp),
                textAlign = TextAlign.Center,
            )

            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Previous",
                    fontSize = 16.sp,
                    modifier = modifier.padding(24.dp),
                    textAlign = TextAlign.Left,
                )

                Text(
                    text = "Next",
                    fontSize = 16.sp,
                    modifier = modifier.padding(24.dp),
                    textAlign = TextAlign.Left,
                )
            }


        }

    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TarjetasPresentacionTheme {

    }
}