Proyecto gestion de Facultad de Humanidades

**---------------------------------------------**


En este proyecto se realizó un script con conexión a mySQL el cual permite almacenar datos de suma relevancia para gestionar una facultad de humanidades.
El script consiste de 3 paquetes:

Utilidades: Paquete utilizado exclusivamente para la conexión del Programa con mySQL

Clases: Todas las clases necesarias para el funcionamiento del programa

Tests: para probar la efectividad/funcionamiento de los métodos implementados en la clase.

Lamentablemente el proyecto no dispone de los siguientes elementos/funciones/métodos:

*1* Generador de certificado de alumno regular

*2* Generador de resultados de lista de Examenes

*3 y 4* consideraciones a la hora de almacenar las notas  e inscribirse a  2 examenes que se realizan al mismo tiempo

*5* Gui/ FrameWork / App / Web

**DISEÑO**
El diseño que se utilizo para la creación de este programa fue principalmente una Clase llamada Menu, en la cual por medio de consola se le da a elegir al programador varias opciones.

El código funciona de la siguiente manera:

al iniciarlo por terminal, te da a elegir las opciones que dispone el programa (hay una seleccion oculta para administradores).
Dentro de las opciones esta el registro del usuario, el inicio de sesión y el salir del programa.
En caso de elegir registro, se le pedirá al usuario que ingrese varios datos personales para el almacenamiento de los mismos en mySQL.
Luego se vuelve a la primera impresión (las opciones de registro/inicio/salida).
Una vez registrado se puede iniciar sesion (verificando si la contraseña y el correo son las mismas).
Luego del inicio, se puede inscribir a una carrera, ver las materias de las carreras, inscribirse a una mesa de examén y/o darse de baja.

Para tener la funcion de ADMINISTRADOR se necesita que : al iniciar la terminal, poner "ADMINBANANA".

Una vez dentro en la interfaz del administrador, el mismo podra:
1-crear una carrera
2-crear una materia (y anexarla a una carrera)
3-crear una mesa de examen con la materia y la fecha en la que se especifica.



**OPINION PERSONAL**

El proyecto pudo haber tenido un avance mas seguro, pero debido a factores internos del grupo, se complicó bastante.
Es muy probable que haya mucho codigo basura por limpiar, pero por falta de tiempo, se lo dejará en el estado actual que provee el "Main".

