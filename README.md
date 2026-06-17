# InnovaTech - Microservicio de Recursos

## Descripción

Microservicio encargado de la gestión de recursos dentro de la plataforma InnovaTech.

Permite administrar la información relacionada con recursos, facilitando la creación, consulta, actualización y eliminación de registros mediante una API REST.

Forma parte de una arquitectura de microservicios compuesta por:

- Frontend
- Backend For Frontend (BFF)
- Microservicio de Proyectos
- Microservicio de Recursos
-Microservicio de monitoreo

---

## Tecnologías

- Java 23
- Spring Boot
- Spring Data JPA
- Maven
- REST API
- MySQL
- JUnit 5
- Mockito

---

## Arquitectura

                                 Frontend
                                    │ 
                                    ▼
                                   BFF
                                    │
Microservicio Recursos  ────────────├──────────── Microservicio Monitoreo
                                    ├
                                    ├
                          Microservicio Proyectos


## Persistencia

La persistencia de datos se implementa mediante Spring Data JPA.

Las entidades son almacenadas en una base de datos relacional utilizando repositorios JPA, permitiendo operaciones CRUD sobre los recursos registrados.



