# Curso Kotlin Multiplatform - Windows 95

Este proyecto es una implementación con Kotlin Multiplatform (KMP) del icónico sistema de menús de clic derecho de Windows 95. Combina prácticas modernas de desarrollo con una interfaz nostálgica.
<p align="center"> <img src="https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=Kotlin&logoColor=white" alt="Kotlin">  <img src="https://img.shields.io/badge/Kotlin-Multiplatform-%237f52ff?style=for-the-badge&logo=kotlin"> <img src="https://img.shields.io/badge/Windows%2095-%F0%9F%96%BC-lightgrey?style=for-the-badge" alt="Windows 95"> </p>

----------

## Aprende a PROGRAMAR aplicaciones en Kotlin Multiplataforma.

Temario: 
<br />
- [Capítulo 1 - Configuración del proyecto]()
- [Capítulo 2 - Preparando el Splash]()
- [Capítulo 3 - Tipografía]()
- [Capítulo 4 - Windows Bar]()
- [Capítulo 5 - Menú inferior]()
- [Capítulo 6 - Carpetas]()
- [Capítulo 7 - Ventanas]()
- [Capítulo 8 - PopUp]()
- [Capítulo 9 - Ordenar carpetas]()
- [Capítulo 10 - Retoques finales]()


----------

## 🛠 Instalación

### Requisitos

-   **Kotlin 2.0.21+**
-   **Compose Multiplatform 1.7.0+**
-   **IDE compatible con KMP**: Fleet o Android Studio.
-   Conocimientos básicos de Kotlin y KMP.

### Configuración

1.  Clona este repositorio:

    ```bash
    git clone https://github.com/ArisGuimera/kmp-windows95.git
    
    ```

2.  Abre el proyecto en Android Studio o Fleet.
3.  Sincroniza el proyecto Gradle para descargar las dependencias.

## Imágenes del proyecto.

|                               Pantalla principal                               | 
|:------------------------------------------------------------------------------:|
|  <img src="img/win95-1.png" style="height: 50%; width:70%;"/>  | 

|                               Menú inferior                               | 
|:------------------------------------------------------------------------------:|
|  <img src="img/win95-2.png" style="height: 50%; width:70%;"/>  | 

|                               Click derecho                               | 
|:------------------------------------------------------------------------------:|
|  <img src="img/win95-3.png" style="height: 50%; width:70%;"/>  | 

----------

## ✏️ Estructura del proyecto

### Componentes

Puedes acceder a `ComposeApp/src/desktopMain/kotlin/com/aristidevs/myWindows95/components` para acceder a todos los componentes que se han ido creando durante el curso. Se han programado lo más genéricos posibles para poder personalizarlos y reutilizarlos en cualquier lugar. Por ejemplo **WindowsButton**

```kotlin
WindowsButton(){
    Text("Ejemplo básico")
}

WindowsButton(Modifier.height(60.dp), onClick = {print("Example"}, dotPadding = 6.dp)){
    //Cualquier vista
}

```

### Helpers

Desde `ComposeApp/src/desktopMain/kotlin/com/aristidevs/myWindows95/helper` dispones del `SoundManager`, el encargado de reproducir la música del splash.

### Extensions

En `ComposeApp/src/desktopMain/kotlin/com/aristidevs/myWindows95/extensions` tendrás todas las funciones de extensión generadas para el proyecto. 

```kotlin

Modifier.onRightClick {}

Modifier.clickableWithoutRipple {}

Modifier.rotateVertically()

//Entre otras

```

### Model

Todos los modelos de datos se encuentran en `ComposeApp/src/desktopMain/kotlin/com/aristidevs/myWindows95/model`.

### Model

Todos los modelos de datos se encuentran en `ComposeApp/src/desktopMain/kotlin/com/aristidevs/myWindows95/model`.

### Splash Screen

Primera vista del proyecto que se lanzará siempre que se ejecute la app. `ComposeApp/src/desktopMain/kotlin/com/aristidevs/myWindows95/splash/`.

### Windows 95

Vista principal del proyecto `ComposeApp/src/desktopMain/kotlin/com/aristidevs/myWindows95/windows95`.


## 🌍 Plataformas Soportadas

-   **Windows**
-   **MacOS**
-   **Linux**

----------

## 🤝 Contribuir

Si quieres apoyar mi trabajo puedes hacerlo a través de los siguientes medios:

- Dale a FAV al proyecto (Star)
- Comparte el [tuit original]() para que llegue a más gente
- Sígueme en mis [redes sociales](https://aristi.dev)

¡Toda ayuda es bienvenida y me permite seguir creando contenido y proyectos open source!

----------

## 👨‍💻 Autor

Desarrollado por **AristiDevs**.

-   [YouTube](https://www.youtube.com/@ArisGuimera)
-   [Twitter](https://twitter.com/ArisGuimera)
-   [LinkedIn](https://www.linkedin.com/in/arisguimera/)

----------

## 🚀 AppCademy.dev


<p align="center">
<a href="https://appcademy.dev"><img src="img/appcademy.webp" style="height: 35%; width:35%;"/></center></a></p>

Este curso está patrocinado por [AppCademy.dev](https://appcademy.dev) mi plataforma de cursos premium donde no solo aprendemos tecnologías sino que profundizamos en sus desarrollos a través de buenas prácticas y contenido avanzado.

----------

## 📦 Otros Proyectos

Si te gustó este proyecto, no olvides echar un vistazo a otros repositorios:

-   [Android Expert](https://github.com/ArisGuimera/Android-Expert)
-   [Compose Tutorial](https://github.com/ArisGuimera/Compose-Tutorial)

----------
