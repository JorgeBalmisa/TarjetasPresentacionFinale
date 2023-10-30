package com.example.tarjetaspresentacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.*
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

                // Crear una lista de tarjetas
                val tarjetas = mutableListOf(
                    Tarjeta(
                        imagenPersona = painterResource(id = R.drawable.chasy),
                        nombrePersona = "Chasy",
                        infoPersona = "Top Laner",
                        gifPersona = painterResource(id = R.drawable.mad_lionslogo_profile),
                        info1 = "informacion1",
                        info2 = "informacion22",
                        info3 = "informacion33"
                    ),
                    Tarjeta(
                        imagenPersona = painterResource(id = R.drawable.elyoya),
                        nombrePersona = "Elyoya",
                        infoPersona = "Jungler",
                        gifPersona = painterResource(id = R.drawable.mad_lionslogo_profile),
                        info1 = "informacion1",
                        info2 = "informacion2",
                        info3 = "informacion3"
                    ),
                    Tarjeta(
                        imagenPersona = painterResource(id = R.drawable.nisqy),
                        nombrePersona = "Nisqy",
                        infoPersona = "Midlaner",
                        gifPersona = painterResource(id = R.drawable.mad_lionslogo_profile),
                        info1 = "informacion1",
                        info2 = "informacion2",
                        info3 = "informacion3"
                    ),
                    Tarjeta(
                        imagenPersona = painterResource(id = R.drawable.carzzy),
                        nombrePersona = "Carzzy",
                        infoPersona = "Bot Laner",
                        gifPersona = painterResource(id = R.drawable.mad_lionslogo_profile),
                        info1 = "informacion1",
                        info2 = "informacion2",
                        info3 = "informacion3"
                    ),
                    Tarjeta(
                        imagenPersona = painterResource(id = R.drawable.hylissang),
                        nombrePersona = "Hylissang",
                        infoPersona = "Support",
                        gifPersona = painterResource(id = R.drawable.mad_lionslogo_profile),
                        info1 = "informacion1",
                        info2 = "informacion2",
                        info3 = "informacion3t"
                    ),

                )

                // Estado para rastrear el índice actual
                var currentIndex by remember { mutableStateOf(0) }

                // Función para manejar la navegación "Next"
                val navigateNext: () -> Unit = {
                    if (currentIndex < tarjetas.size - 1) {
                        currentIndex++
                    } else {
                        currentIndex = 0
                    }
                }

                // Función para manejar la navegación "Previous"
                val navigatePrevious: () -> Unit = {
                    if (currentIndex > 0) {
                        currentIndex--
                    } else {
                        currentIndex = tarjetas.size - 1
                    }
                }

                // Renderizar la tarjeta actual
                TarjetaPresentacion(
                    imagenPersona = tarjetas[currentIndex].imagenPersona,
                    nombrePersona = tarjetas[currentIndex].nombrePersona,
                    infoPersona = tarjetas[currentIndex].infoPersona,
                    gifPersona = tarjetas[currentIndex].gifPersona,
                    info1 = tarjetas[currentIndex].info1,
                    info2 = tarjetas[currentIndex].info2,
                    info3 = tarjetas[currentIndex].info3,
                    modifier = Modifier,
                    navigateNext = navigateNext,
                    navigatePrevious = navigatePrevious
                )
            }
        }
    }
}


data class Tarjeta(
    val imagenPersona: Painter,
    val nombrePersona: String,
    val infoPersona: String,
    val gifPersona: Painter,
    val info1: String,
    val info2: String,
    val info3: String
)


    @Composable
    fun TarjetaPresentacion(
        imagenPersona: Painter,
        nombrePersona: String,
        infoPersona: String,
        gifPersona: Painter,
        info1: String,
        info2: String,
        info3: String,
        modifier: Modifier = Modifier,
        navigateNext: () -> Unit,
        navigatePrevious: () -> Unit
    ) {
        Column(
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column {
                Image(
                    imagenPersona,
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                        .clip(CircleShape)
                )
            }
            Text(
                text = nombrePersona,
                fontSize = 16.sp,
                modifier = modifier.padding(16.dp),
                textAlign = TextAlign.Center,
            )

            Image(painter = gifPersona,
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
            )

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
            Spacer(modifier = Modifier.height(16.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Previous",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(24.dp)
                        .clickable {
                            navigatePrevious()
                        },
                    textAlign = TextAlign.Left
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "Next",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(24.dp)
                        .clickable {
                            navigateNext()
                        },
                    textAlign = TextAlign.Left
                )
            }


        }

   }




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TarjetasPresentacionTheme {
        // Crear una lista de tarjetas
        val tarjetas = listOf(
            Tarjeta(
                imagenPersona = painterResource(id = R.drawable.peepo56),
                nombrePersona = "Alexelcapo",
                infoPersona = "Streamer",
                gifPersona = painterResource(id = R.drawable.gif2),
                info1 = "informacion1",
                info2 = "informacion2",
                info3 = "informacion3"
            ),

            Tarjeta(
                imagenPersona = painterResource(id = R.drawable.peepo),
                nombrePersona = "UwU",
                infoPersona = "Streamer",
                gifPersona = painterResource(id = R.drawable.gif1),
                info1 = "informacion1",
                info2 = "informacion2",
                info3 = "informacion3"
            ),

            // Agrega más tarjetas según tus necesidades
        )

        // Estado para rastrear el índice actual
        var currentIndex by remember { mutableStateOf(0) }

        // Función para manejar la navegación "Next"
        val navigateNext: () -> Unit = {
            if (currentIndex < tarjetas.size - 1) {
                currentIndex++
            } else {
                currentIndex = 0
            }
        }

        // Función para manejar la navegación "Previous"
        val navigatePrevious: () -> Unit = {
            if (currentIndex > 0) {
                currentIndex--
            } else {
                currentIndex = tarjetas.size - 1
            }
        }

        // Renderizar la tarjeta actual
        TarjetaPresentacion(
            imagenPersona = tarjetas[currentIndex].imagenPersona,
            nombrePersona = tarjetas[currentIndex].nombrePersona,
            infoPersona = tarjetas[currentIndex].infoPersona,
            gifPersona = tarjetas[currentIndex].gifPersona,
            info1 = tarjetas[currentIndex].info1,
            info2 = tarjetas[currentIndex].info2,
            info3 = tarjetas[currentIndex].info3,
            modifier = Modifier,
            navigateNext = navigateNext,
            navigatePrevious = navigatePrevious
        )
    }
}