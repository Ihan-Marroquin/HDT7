# Diccionario Inglés - Español

Este es un programa Java que implementa un diccionario inglés - español utilizando árboles binarios de búsqueda (BST). Permite cargar un archivo de diccionario que contiene asociaciones de palabras en inglés y su equivalente en español, y luego traducir un archivo de texto en inglés utilizando este diccionario.

## Estructura del proyecto

El proyecto está organizado de la siguiente manera:

- `src/main/java/com/hdt7/`: Contiene el código fuente del programa.
    - `App.java`: Clase principal que carga el diccionario y traduce el texto.
    - `BinaryTree.java`: Implementación de un árbol binario de búsqueda.
    - `TreeNode.java`: Clase para representar un nodo en un árbol binario.
    - `Association.java`: Clase para representar una asociación entre una palabra en inglés y su traducción al español.
- `src/test/java/com/hdt7/`: Contiene las pruebas unitarias para el programa.
    - `AppTest.java`: Pruebas unitarias para la funcionalidad del programa.

## Uso

1. **Compilación**: Puedes compilar el programa utilizando un IDE como IntelliJ IDEA o desde la línea de comandos con Maven.

2. **Ejecución**: Una vez compilado, puedes ejecutar el programa proporcionando los archivos de diccionario y texto como argumentos.

    ```bash
    java -cp <ruta-al-programa-compiled.jar> com.hdt7.App <ruta-al-diccionario.txt> <ruta-al-texto.txt>
    ```

3. **Resultados**: El programa imprimirá la traducción del texto en la consola.

## Ejemplo de archivos

- `diccionario.txt`: Contiene las asociaciones de palabras en inglés y su traducción al español. El formato es `<palabra_en_inglés>, <traducción_en_español>`.

    ```
    house, casa
    dog, perro
    homework, tarea
    woman, mujer
    town, pueblo
    yes, si
    ```

- `texto.txt`: Contiene el texto en inglés que se traducirá utilizando el diccionario.

    ```
    The woman asked me to do my homework about my town.
    ```

## Contribuciones

¡Las contribuciones son bienvenidas! Si encuentras algún problema o deseas agregar nuevas características, no dudes en abrir un problema o enviar una solicitud de extracción.

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más detalles.
