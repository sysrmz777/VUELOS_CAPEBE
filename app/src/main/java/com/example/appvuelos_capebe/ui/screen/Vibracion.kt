package com.example.appvuelos_capebe.ui.screen


import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import android.util.Log
import android.widget.Toast
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@Composable
fun TarjetaVibracion(context: Context) {
    val duracion = 500L
    var vibrando by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    // animación de temblor
    val transicion = rememberInfiniteTransition(label = "temblor")
    val desplazamiento by transicion.animateFloat(
        initialValue = -8f,
        targetValue = 8f,
        animationSpec = infiniteRepeatable(tween(40), RepeatMode.Reverse),
        label = "desplazamiento"
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .offset { IntOffset(if (vibrando) desplazamiento.roundToInt() else 0, 0) },
        colors = CardDefaults.cardColors(
            containerColor = if (vibrando) MaterialTheme.colorScheme.tertiaryContainer
            else MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Vibración", style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(8.dp))
            Text(if (vibrando) "📳 Vibrando..." else "En reposo")
            Spacer(Modifier.height(8.dp))
            Button(
                enabled = !vibrando,
                onClick = {
                    vibrar(context, duracion)
                    Toast.makeText(context, "Vibrando $duracion ms", Toast.LENGTH_SHORT).show()
                    scope.launch {
                        vibrando = true
                        delay(duracion)
                        vibrando = false
                    }
                }
            ) {
                Text("Vibrar $duracion ms")
            }
        }
    }
}

fun vibrar(context: Context, milisegundos: Long) {
    val vibrador: Vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        val manager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
        manager.defaultVibrator
    } else {
        @Suppress("DEPRECATION")
        context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    }

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        vibrador.vibrate(
            VibrationEffect.createOneShot(milisegundos, VibrationEffect.DEFAULT_AMPLITUDE)
        )
    } else {
        @Suppress("DEPRECATION")
        vibrador.vibrate(milisegundos)
    }
    Log.d("Vibracion", "Vibrando $milisegundos ms")
}