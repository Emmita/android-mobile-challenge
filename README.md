# Android Mobile Challenge (Gallery App)

Un proyecto de aplicación Android que muestra un listado de álbumes y, dentro de cada álbum, un carrusel con sus respectivas fotos.

<img width="425" height="910" alt="image" src="https://github.com/user-attachments/assets/db3d5fcf-11e7-4965-b58b-207724c4f0fe" />
<img width="430" height="922" alt="image" src="https://github.com/user-attachments/assets/d081cda3-29a9-4802-a2d5-86987b6e74ef" />
<img width="429" height="922" alt="image" src="https://github.com/user-attachments/assets/cb8fbd29-7323-4572-9060-e3d67745d6d2" />

## Características

Las funcionalidades principales de la aplicación son:

*   Ver una lista de álbumes con sus respectivas fotos en forma de carrusel.
*   Navegar a una pantalla de detalle de foto al hacer clic en una imagen, mostrando el título, la imagen completa y la descripción.

## API

https://jsonplaceholder.typicode.com/

**Disclaimer:** El dominio donde la api tenía las fotos ya no existe y son tomadas desde otro punto. Las imágenes que se muestran
En la aplicación provienen de https://picsum.photos/. La cantidad de fotos no es proporcional entre ambas apis, es por eso que a partir
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

## Instrucciones de Uso

1.  Clona el repositorio en tu máquina local.
2.  Abre el proyecto en Android Studio.
3.  Sincroniza las dependencias de Gradle.
4.  Ejecuta la aplicación en un emulador o dispositivo físico.
