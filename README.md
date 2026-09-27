VectorApp

Mini-proyecto Android (Java) con la clase `Vector` y una interfaz simple para probar operaciones de vectores.

Archivos:
- `src/main/java/com/example/vectorapp/Vector.java` - implementación de la clase Vector con las operaciones solicitadas.
- `src/main/java/com/example/vectorapp/MainActivity.java` - actividad principal con botones para invocar operaciones.
- `src/main/res/layout/activity_main.xml` - layout con campos y botones.
- `src/main/AndroidManifest.xml` - manifest mínimo.

Cómo usar:
1. Crea un nuevo proyecto Android en Android Studio (Java, min API 19+).
2. Copia los archivos en las rutas equivalentes dentro del módulo `app`.
3. Abre y ejecuta en un emulador o dispositivo.

Notas:
- `inputValues` acepta números separados por comas para `Cargar` (ej: "3,4,5,6").
- Para `Insertar` use el formato "indice:valor" (ej: "2:99").
- Para `Rotar`, `Adicionar`, `Obtener`, `Busqueda` ingrese un solo número.
- `BusquedaBin` asume que el vector está ordenado.

Limitaciones:
- Interfaz muy básica pensada para pruebas y demostración.
- No incluye gradle files; integra manualmente en tu proyecto Android existente.

Si quieres, puedo empaquetar esto como un proyecto Android Studio completo (con Gradle) y ejecutable. Indica si lo deseas.
