# CodaHertz

## 1. Descripción general del proyecto

CodaHertz es una aplicación web para descubrir, calificar y organizar música. No reproduce canciones: funciona como una plataforma de reseñas y recomendaciones. Los usuarios pueden registrar canciones con su título, una breve descripción y el lugar donde encontrarlas (por ejemplo, un enlace a una plataforma de streaming), calificarlas con estrellas, escribir reseñas y guardar sus canciones favoritas en playlists personales.

El objetivo es ofrecer una comunidad donde las personas compartan su opinión sobre la música y encuentren qué escuchar a partir de los rankings y reseñas de otros usuarios.

## 2. Integrantes del equipo

- Ramírez Gutiérrez Alondra Yuritzi 
- Leija Vargas Nelly Lizeth
- Rodriguez Zarate Fernando Alberto
## 3. Requerimientos (primeros 5)

| ID | Requerimiento | Tipo | Prioridad |
|----|---------------|------|-----------|
| R1 | El sistema debe permitir registrar canciones con título, breve descripción y enlace o lugar donde encontrarla. | Funcional | Alta |
| R2 | El usuario debe poder calificar una canción con un puntaje de 1 a 5 estrellas. | Funcional | Alta |
| R3 | El usuario debe poder escribir, editar y eliminar reseñas sobre una canción. | Funcional | Alta |
| R4 | El usuario debe poder crear playlists y agregar o quitar canciones de ellas. | Funcional | Alta |
| R5 | El sistema debe mostrar un ranking de canciones ordenado por su calificación promedio. | Funcional | Media |

## 4. Funcionalidades que podrían resolverse con paquetes de Spring Boot

| Funcionalidad | Paquete / Starter de Spring Boot |
|---------------|----------------------------------|
| Registro e inicio de sesión de usuarios | Spring Security |
| Conexión y persistencia en base de datos (canciones, reseñas, playlists) | Spring Data JPA |
| Validación de datos (estrellas de 1 a 5, campos obligatorios) | Spring Validation |
| Registro de eventos y errores (logs) | Logback (incluido) / Spring Boot Actuator |
| Documentación de la API | springdoc-openapi (Swagger) |
| Construcción de la API REST | Spring Web |
| Pruebas automatizadas | Spring Boot Starter Test |