# Proyecto de Censo de Población - INEGI

Este es un proyecto de aplicación de escritorio en Java desarrollado para gestionar información de censos de población, basado en el patrón de diseño Modelo-Vista-Controlador (MVC) y utilizando conexión a una base de datos MySQL. La aplicación permite registrar, consultar, actualizar y eliminar información relacionada con viviendas, habitantes y actividades económicas.

## Características

- **CRUD Completo**: Gestión de viviendas, habitantes y actividades económicas mediante operaciones CRUD.
- **Patrón MVC**: Estructura de código organizada en modelos, vistas y controladores.
- **Patrones de Diseño**: Implementación de patrones Singleton y Factory para gestionar la conexión a la base de datos y la creación de modelos.
- **Login de Usuario**: Interfaz de inicio de sesión con control de acceso básico.
- **Conexión a MySQL**: Base de datos relacional para almacenar y consultar la información censal.

## Estructura del Proyecto

El proyecto está dividido en los siguientes paquetes:

- **Modelo**: Clases que representan las entidades del sistema (`ActividadEconomica`, `Habitante`, `Vivienda`) y el patrón Factory (`ModeloFactory`) para la creación de instancias de modelos.
- **Controlador**: Clases para gestionar las operaciones de cada entidad en la base de datos (`ActividadEconomicaController`, `HabitanteController`, `ViviendaController`).
- **Vista**: Interfaces gráficas para interactuar con los datos censales (clases `MainFrame`, `LoginFrame`, y frames específicos para cada entidad).
- **Util**: Contiene `DatabaseConnection`, que implementa el patrón Singleton para gestionar la conexión a la base de datos.

## Requisitos

- **Java**: JDK 8 o superior.
- **MySQL**: Configuración de una base de datos MySQL con las tablas necesarias para almacenar la información del censo.
- **IDE**: Opcionalmente, puedes utilizar NetBeans para facilitar la ejecución y gestión del proyecto.

## Instalación

1. **Clona el repositorio**:

   ```bash
   git clone https://github.com/tu-usuario/nombre-del-repositorio.git
   cd nombre-del-repositorio
