# Android Mobile Challenge (Gallery App)

Un proyecto de aplicación Android que muestra un listado de álbumes y, dentro de cada álbum, un carrusel con sus respectivas fotos.

## Características

Las funcionalidades principales de la aplicación son:

*   Ver una lista de álbumes con sus respectivas fotos en forma de carrusel.
*   Navegar a una pantalla de detalle de foto al hacer clic en una imagen, mostrando el título, la imagen completa y la descripción.

## API

https://jsonplaceholder.typicode.com/
**Disclaimer:** El dominio donde la api tenía las fotos ya no existe y son tomadas desde otro punto. Las imágenes que se muestran
En la aplicación provienen de [https://picsum.photos/]. La cantidad de fotos no es proporcional entre ambas apis, es por eso que a partir
de cierta posición, no será cargada ninguna imagen dentro de los carruseles y solo se verá la card vacía.

## Tecnologías Utilizadas

La aplicación fue desarrollada utilizando la siguiente pila tecnológica:

*   **Lenguaje:** Kotlin
*   **UI Framework:** Jetpack Compose
*   **Arquitectura:** MVVM + Clean Architecture
*   **Networking:** Retrofit + OkHttp
*   **Inyección de Dependencias:** Hilt
*   **Serialización de Datos:** Moshi
*   **Concurrencia:** Coroutines y Flow
*   **Navegación:** Navigation Compose
*   **Carga de Imágenes:** Coil
*   **Pruebas Unitarias:** JUnit

## Requerimientos y Prerrequisitos

Para poder clonar, compilar y ejecutar el proyecto localmente, necesitarás:

*   **Android Studio:** Configuración básica.
*   **SDK Mínimo:** Nivel 24 (Android 7.0 Nougat).

## Instrucciones de Uso

Es muy sencillo poner en marcha este proyecto:

1.  Clona el repositorio en tu máquina local.
2.  Abre el proyecto en Android Studio.
3.  Sincroniza las dependencias de Gradle.
4.  Ejecuta la aplicación en un emulador o dispositivo físico.

¡No se requieren pasos adicionales ni claves API externas!