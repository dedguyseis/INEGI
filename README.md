# Proyecto de Censo de Población - INEGI

Este es un proyecto de aplicación de escritorio en Java desarrollado para gestionar información de censos de población, basado en el patrón de diseño Modelo-Vista-Controlador (MVC) y utilizando conexión a una base de datos MySQL. La aplicación permite registrar, consultar, actualizar y eliminar información relacionada con viviendas, habitantes y actividades económicas.

## Características

- **CRUD Completo**: Gestión de viviendas, habitantes y actividades económicas mediante operaciones CRUD.
- **Patrón MVC**: Estructura de código organizada en modelos, vistas y controladores.
- **Patrones de Diseño**: Implementación de los patrones Singleton (gestión de conexión a la base de datos) y DAO (acceso a datos).
- **Login de Usuario**: Interfaz de inicio de sesión con control de acceso.
- **Dashboard Ejecutivo**: Gráficos y resúmenes estadísticos sobre viviendas y población.
- **Conexión a MySQL**: Base de datos relacional para almacenar y consultar la información censal.

## Estructura del Proyecto

El proyecto está dividido en los siguientes paquetes:

- **Modelo**: Clases que representan las entidades del sistema (`Vivienda`, `Habitante`, `Usuario`) y gestionan la lógica de negocio (`DashboardDAO`, `ViviendaDAO`, `UsuarioDAO`).
- **Controlador**: Clases para gestionar las operaciones de cada entidad en la base de datos (`RegistroController`, `LoginController`, `DashboardController`).
- **Vista**: Interfaces gráficas para interactuar con los datos censales (`LoginView`, `DashboardView`, `RegistroView`).
- **Util**: Contiene `ConexionDB`, que implementa el patrón Singleton para gestionar la conexión a la base de datos.

## Funcionalidades Principales

1. **Gestión de Viviendas**:
   - Registro y modificación de viviendas.
   - Eliminación segura de registros.

2. **Gestión de Habitantes**:
   - Registro de habitantes asociados a una vivienda.
   - Consulta y actualización de datos personales.

3. **Dashboard Ejecutivo**:
   - Visualización de gráficos sobre estadísticas poblacionales y económicas.

4. **Inicio de Sesión**:
   - Login para garantizar el acceso seguro al sistema.

5. **Reportes y Consultas**:
   - Consultas por localidad, municipio y clasificación de viviendas.
   - Generación de reportes detallados.

## Requisitos

- **Java**: JDK 8 o superior.
- **MySQL**: Configuración de una base de datos MySQL con las tablas necesarias (archivo `Base/CensoPoblacion.sql` incluido).
- **IDE**: Opcionalmente, puedes utilizar NetBeans para facilitar la ejecución y gestión del proyecto.

## Instalación

1. **Clona el repositorio**:

   ```bash
   git clone https://github.com/tu-usuario/nombre-del-repositorio.git
   cd nombre-del-repositorio
   ```

2. **Configura la base de datos**:
   - Importa el archivo `Base/CensoPoblacion.sql` en tu servidor MySQL.

3. **Ejecuta el proyecto**:
   - Abre el proyecto en NetBeans u otro IDE compatible.
   - Configura la conexión a la base de datos en la clase `ConexionDB`.

## Uso

- Ejecuta la aplicación para acceder al menú principal.
- Utiliza las opciones disponibles para gestionar viviendas, habitantes y reportes.

---

**Nota:** Este proyecto fue desarrollado como parte de una actividad educativa y puede requerir ajustes para entornos de producción.

--- 
