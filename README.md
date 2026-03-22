# Programación I – Módulo 4: Interfaces gráficas, patrones de diseño y acceso a datos (Java)

Repositorio académico correspondiente al **Módulo 4** de la asignatura **Programación I**, impartida en el **Instituto Tecnológico de las Américas (ITLA)**.

El contenido apoya la clase impartida por el **Profesor Kelyn Tejada Belliard**, con el acompañamiento de **Christian Gil** como **monitor de la asignatura** y responsable de explicaciones y demostraciones técnicas del código.

---

## Objetivo del módulo

Aplicar conceptos de **interfaces gráficas**, **patrones de diseño** y **persistencia en base de datos** mediante un ejemplo práctico de **CRUD** en Java (Swing + JDBC + MySQL), de forma que el estudiante relacione teoría, arquitectura y código ejecutable.

---

## Contenidos y conceptos

### 1. Formularios en Java y otros lenguajes (componentes y consideraciones)

Un **formulario** es la parte de la aplicación donde el usuario introduce o visualiza datos (campos de texto, etiquetas, botones, listas, etc.).

- **En Java (Swing):** ventanas (`JFrame`), paneles (`JPanel`), etiquetas (`JLabel`), campos de texto (`JTextField`), botones (`JButton`), diálogos (`JOptionPane`), entre otros.
- **Consideraciones:** claridad de etiquetas, validación de entrada (números, campos vacíos), mensajes de error comprensibles, tamaño y disposición de componentes (por ejemplo `GroupLayout` en NetBeans o `null` layout con coordenadas), y cierre correcto de la ventana (`EXIT_ON_CLOSE`).
- **En otros entornos:** la idea es la misma (captura y presentación de datos); cambian el lenguaje y la biblioteca (por ejemplo formularios web con HTML/CSS/JS, Windows Forms, Android con vistas XML, etc.).

### 2. Qué son los patrones de diseño en Java

Los **patrones de diseño** son **soluciones reutilizables** a problemas que se repiten al diseñar software. No son código copiable tal cual, sino **plantillas de estructura y colaboración** entre clases.

En Java se aplican igual que en otros lenguajes orientados a objetos: ayudan a que el código sea más **mantenible**, **claro** y **coherente** cuando el proyecto crece.

### 3. Patrones de diseño más usados (con ejemplos breves)

| Patrón | Idea | Ejemplo típico en Java |
|--------|------|-------------------------|
| **Singleton** | Una sola instancia de una clase en toda la aplicación. | Un gestor de configuración o conexión compartida (con cuidado en aplicaciones concurrentes). |
| **Factory / Factory Method** | Crear objetos sin acoplar el cliente a la clase concreta. | `DocumentBuilderFactory.newInstance()`. |
| **Observer** | Un sujeto notifica a varios observadores cuando cambia. | Listeners en Swing (`ActionListener`, `addActionListener`). |
| **Strategy** | Intercambiar algoritmos en tiempo de ejecución mediante una interfaz común. | Diferentes estrategias de cálculo o validación implementando la misma interfaz. |
| **MVC (Modelo–Vista–Controlador)** | Separar datos, interfaz y lógica de coordinación. | Este proyecto: **Modelo** (`Producto`, `dbConnection`), **Vista** (`ProductCRUD`), **Controlador** (`ProductoController`). |

### 4. Qué es un entorno gráfico

Un **entorno gráfico** (o **GUI**, *Graphical User Interface*) es el conjunto de **herramientas y bibliotecas** que permiten construir interfaces visuales: ventanas, iconos, menús, botones, etc., en lugar de limitarse a texto en consola.

Incluye el **toolkit** del sistema o del lenguaje (por ejemplo **Swing** o **JavaFX** en Java) y las convenciones de interacción (eventos de ratón y teclado, foco, diálogos).

### 5. Diferencia entre patrones de diseño y entornos gráficos

| | **Patrones de diseño** | **Entornos gráficos (GUI)** |
|---|------------------------|-----------------------------|
| **Qué son** | Ideas y estructuras para organizar clases y responsabilidades. | Medios para **dibujar** la interfaz y **recibir eventos** del usuario. |
| **Ejemplo** | MVC, Observer, Singleton. | Swing, JavaFX, HTML/CSS en web. |
| **Relación** | Puedes usar **ambos a la vez**: una ventana Swing (entorno gráfico) puede seguir el patrón MVC (patrón de diseño). No son lo mismo ni se excluyen. |

### 6. Entornos gráficos según tecnología

- **Escritorio:** Swing, JavaFX, Windows Forms (.NET), WPF, Qt, etc.
- **Web:** HTML/CSS/JavaScript, frameworks como React, Angular, Vue; en servidor, páginas que generan formularios.
- **Móvil:** Android (Activities, Jetpack Compose), iOS (SwiftUI, UIKit).
- **Híbridos / multiplataforma:** Flutter, .NET MAUI, etc.

Cada plataforma tiene su toolkit, pero los conceptos de formulario, eventos y validación se repiten.

### 7. Qué es un CRUD en programación y en el desarrollo de aplicaciones

**CRUD** son las operaciones básicas sobre datos persistentes:

- **C**reate — **Crear** (insertar registros).
- **R**ead — **Leer** (consultar / listar).
- **U**pdate — **Actualizar** (modificar registros existentes).
- **D**elete — **Eliminar** (borrar registros).

En el desarrollo de aplicaciones, casi toda pantalla de mantenimiento (productos, usuarios, citas) se modela como CRUD sobre una base de datos o API.

### 8. Cómo se hace una conexión a una base de datos en Java

1. **Driver JDBC** adecuado (por ejemplo **MySQL Connector/J**) añadido al proyecto.
2. **Cadena JDBC** (`jdbc:mysql://host:puerto/baseDeDatos`) y credenciales (usuario/contraseña).
3. En código: **`DriverManager.getConnection(...)`** devuelve un objeto **`Connection`**.
4. Sobre la conexión se crean **`PreparedStatement`** (recomendado, con parámetros `?`) o **`Statement`** para ejecutar SQL.
5. Cerrar recursos (`Connection`, `Statement`, `ResultSet`) con **try-with-resources** o `finally` para no dejar conexiones abiertas.

En este repositorio, la clase `Modelo.dbConnection` centraliza URL, usuario y contraseña y expone un método estático `conectar()` que devuelve `Connection`.

---

## Ejemplo en este proyecto: crear, editar, guardar y borrar con base de datos

La aplicación de escritorio **`Vista.ProductCRUD`** (Swing) permite:

| Acción | Vista (botón) | Controlador | SQL típico |
|--------|-----------------|---------------|------------|
| **Guardar (crear)** | Guardar | `ProductoController.guardar` | `INSERT INTO producto ...` |
| **Buscar (leer)** | Buscar | `ProductoController.buscarPorId` | `SELECT ... WHERE id = ?` |
| **Editar (actualizar)** | Editar | `ProductoController.editar` | `UPDATE producto SET ... WHERE id = ?` |
| **Eliminar (borrar)** | Eliminar | `ProductoController.eliminar` | `DELETE FROM producto WHERE id = ?` |

Flujo recomendado: la **vista** solo lee y muestra datos; el **controlador** usa `Connection` y `PreparedStatement`; el **modelo** (`Producto`) representa la fila en memoria.

---

## Estructura del proyecto (paquetes)

- `Modelo` — Entidad `Producto` y conexión JDBC (`dbConnection`).
- `Controlador` — `ProductoController`: operaciones CRUD contra MySQL.
- `Vista` — `ProductCRUD`: formulario Swing enlazado al controlador.

---

## Requisitos

<p align="center">
  <a href="https://skillicons.dev" title="Skill Icons">
    <img src="https://skillicons.dev/icons?i=java,mysql&perline=6" alt="Java, MySQL" />
  </a>
</p>

- **Java JDK 8 o superior** — lenguaje y APIs estándar (**Swing** para la interfaz, **JDBC** para la base de datos).
- **MySQL** con la base y tabla usadas en el curso (por ejemplo `itla_db` / `producto`, según tu script SQL).
- **MySQL Connector/J** configurado como librería en el proyecto (NetBeans: *Libraries*).
- IDE recomendado: **Apache NetBeans** (proyecto Ant con `build.xml`).

---

## Ejecución

1. Abrir el proyecto en NetBeans (carpeta que contiene `build.xml` y `nbproject`).
2. Ajustar en `dbConnection` la URL, usuario y contraseña de tu servidor MySQL.
3. Ejecutar la clase con `main` configurada (por ejemplo `Vista.ProductCRUD`).

---

## Público objetivo

- Estudiantes de **Programación I** que cursan el módulo de interfaces y datos.
- Quienes ya vieron Java básico y quieren pasar de consola a aplicación con formulario y base de datos.

---

## Créditos académicos

- **Asignatura:** Programación I  
- **Institución:** Instituto Tecnológico de las Américas (ITLA)  
- **Profesor:** Kelyn Tejada Belliard  
- **Monitor y apoyo académico:** Christian Gil  

---

## Nota

Este repositorio tiene fines **estrictamente educativos**. El código prioriza claridad y aprendizaje; en un entorno de producción se reforzarían seguridad (no hardcodear contraseñas), manejo de errores y diseño de capas adicionales según el caso.
