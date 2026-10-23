# AppVuelos_CAPEBE - App de Vuelos Recreativos para Socios

**Integrantes:** Álvaro Ramírez y Fernando Reyes  
**Asignatura:** Desarrollo de Aplicaciones Móviles (DSY1105) - Duoc UC  
**Tablero Trello (Planificación):** https://trello.com/b/scpeGVeb

## ¿De qué trata el proyecto?
Pensamos esta app para los socios del Club Aéreo del Personal del BancoEstado (CAPEBE). El problema que tienen en el club es que hoy hacen todo en papel o planillas de Excel manuales cuando están en la misma pista de aterrizaje (en Tobalaba o Talcahuano).

Con nuestra app, cualquier socio puede crearse una cuenta, iniciar sesión, revisar el calendario de vuelos disponibles, aceptar los términos del servicio, confirmar su reserva y ver sus vuelos guardados. Además, sumamos herramientas del teléfono que sirven cuando estás en la losa.

## Funcionalidades implementadas (pantalla por pantalla)
- **Bienvenida:** Pantalla de inicio con el logo del club aéreo.
- **Registro e Inicio de Sesión:** Formularios para registrarse o entrar a la app. Los usuarios se guardan en el teléfono con base de datos SQLite (Room), para que funcione aunque no haya señal en la pista. Incluye validaciones en el ViewModel (campos vacíos, formato de correo, contraseña de mínimo 8 caracteres y confirmación).
- **Menú Principal:** Saluda al socio con el nombre que registró en la base de datos y da acceso a Vuelos, Mis Vuelos Guardados y Recursos Nativos.
- **Calendario de Vuelos:** Muestra los próximos vuelos de prueba en Tobalaba y Talcahuano con fecha, horario y aeronave. Al tocar uno se habilita el botón para seleccionarlo.
- **Términos y Condiciones:** Muestra las condiciones del servicio antes de pasar a la confirmación de la reserva.
- **Confirmación de Vuelo:** Muestra el nombre del socio y el detalle del vuelo elegido para guardarlo.
- **Mis Vuelos Guardados:** Lista los vuelos que el socio ya confirmó en la aplicación.
- **Recursos Nativos:**
  - **Linterna:** Enciende y apaga el flash de la cámara para revisar documentos con poca luz.
  - **Vibración:** Vibra por 500 ms con animación de temblor en la tarjeta para dar aviso táctil cuando hay ruido de motores en la pista.
  - **Batería:** Muestra el porcentaje actual de batería del teléfono en terreno.
  - **Brújula:** Usa el sensor del dispositivo para mostrar los grados y dirección del rumbo magnético en la losa.

## Arquitectura y herramientas utilizadas
- **Lenguaje y UI:** Kotlin y Jetpack Compose (Material Design 3).
- **Arquitectura:** Patrón MVVM separado en paquetes (`data`, `model`, `ui/components`, `ui/navigation`, `ui/screen` y `ui/viewModel`).
- **Base de datos local:** Room (SQLite) con `AppDatabase`, `UsuarioDao` y `UsuarioEntity`.
- **Trabajo colaborativo:** Git / GitHub y planificación de tareas en Trello (https://trello.com/b/scpeGVeb).

## Pasos para ejecutar el proyecto
1. Clonar este repositorio en el computador.
2. Abrir la carpeta del proyecto en Android Studio.
3. Esperar a que termine la sincronización de Gradle (Sync Project with Gradle Files).
4. Ejecutar con el botón Run en un emulador o dispositivo físico Android (SDK 26 o superior).
