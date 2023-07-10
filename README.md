# ReservaAPI
Aplicación de Reservas para la cátedra 'Desarrollo de Aplicaciones Web' de la UTN Facultad Regional Villa María.

## Autores

- Leonel Zeballos
- Gregorio Meloni

## Diagrama de clases

![Model.png](images%2FModel.png)

## Endpoints de la API

Por defecto, la aplicación corre en el puerto 8080. Para cambiarlo, modificar el archivo `application.properties`.
Además, todos los endpoints comienzan con `/api`, seguido de la versión de la API, que por defecto es `v1`.

### Documentación

- GET `/swagger-ui/index.html`: Documentación de la API generada con Swagger.

### Reserva

| Method | Endpoint                            | Description                       | Parameters                                                                                      |
|--------|-------------------------------------|-----------------------------------|-------------------------------------------------------------------------------------------------|
| GET    | `/api/v1/reserva`                   | Retrieves all reservations        | `?duracion=Integer`, `?comentario=String`, `?clienteId=String`, `?motivoReserva=String`, `?estadoId=String`, `?motivoRechazo=String`, `?espacioFisicoId=String` |
| GET    | `/api/v1/reserva/{id}`              | Retrieves a reservation by ID     | `id`                                                                                            |
| POST   | `/api/v1/reserva`                   | Creates a new reservation         | N/A                                                                                             |
| PUT    | `/api/v1/reserva/{id}`              | Updates a reservation by ID       | `id`                                                                                            |
| DELETE | `/api/v1/reserva/{id}`              | Deletes a reservation by ID       | `id`                                                                                            |

### Clientes

| Method | Endpoint                            | Description                       | Parameters                                                                                      |
|--------|-------------------------------------|-----------------------------------|-------------------------------------------------------------------------------------------------|
| GET    | `/api/v1/cliente`                   | Retrieves all clients             | `?nombre=String`, `?apellido=String`, `?nroTelefono=String`, `?email=String`, `?dni=Integer`, `?rolId=String` |
| GET    | `/api/v1/clientes/{id}`             | Retrieves a client by ID          | `id`                                                                                            |
| POST   | `/api/v1/clientes`                  | Creates a new client              | N/A                                                                                             |
| PUT    | `/api/v1/clientes/{id}`             | Updates a client by ID            | `id`                                                                                            |
| DELETE | `/api/v1/clientes/{id}`             | Deletes a client by ID            | `id`                                                                                            |

### Espacios físicos

| Method | Endpoint                            | Description                       | Parameters                                                                                      |
|--------|-------------------------------------|-----------------------------------|-------------------------------------------------------------------------------------------------|
| GET    | `/api/v1/espacio-fisico`            | Retrieves all physical spaces     | `?nombre=String`, `?descripcion=String`, `?capacidad=Integer`, `?habilitado=Boolean`             |
| GET    | `/api/v1/espacio-fisico/{id}`       | Retrieves a physical space by ID  | `id`                                                                                            |
| POST   | `/api/v1/espacio-fisico`            | Creates a new physical space      | N/A                                                                                             |
| PUT    | `/api/v1/espacio-fisico/{id}`       | Updates a physical space by ID    | `id`                                                                                            |
| DELETE | `/api/v1/espacio-fisico/{id}`       | Deletes a physical space by ID    | `id`                                                                                            |

### Recursos

| Method | Endpoint                            | Description                       | Parameters                                                                                      |
|--------|-------------------------------------|-----------------------------------|-------------------------------------------------------------------------------------------------|
| GET    | `/api/v1/recurso`                   | Retrieves all resources           | `?nombre=String`, `?descripcion=String`                                                         |
| GET    | `/api/v1/recurso/{id}`              | Retrieves a resource by ID        | `id`                                                                                            |
| POST   | `/api/v1/recurso`                   | Creates a new resource            | N/A                                                                                             |
| PUT    | `/api/v1/recurso/{id}`              | Updates a resource by ID          | `id`                                                                                            |
| DELETE | `/api/v1/recurso/{id}`              | Deletes a resource by ID          | `id`                                                                                            |

### Estados

| Method | Endpoint                            | Description                       | Parameters                                                                                      |
|--------|-------------------------------------|-----------------------------------|-------------------------------------------------------------------------------------------------|
| GET    | `/api/v1/estado`                    | Retrieves all statuses            | `?nombre=String`, `?descripcion=String`                                                         |
| GET    | `/api/v1/estado/{id}`               | Retrieves a status by ID          | `id`                                                                                            |
| POST   | `/api/v1/estado`                    | Creates a new status              | N/A                                                                                             |
| PUT    | `/api/v1/estado/{id}`               | Updates a status by ID            | `id`                                                                                            |
| DELETE | `/api/v1/estado/{id}`               | Deletes a status by ID            | `id`                                                                                            |

### Rol

| Method | Endpoint                            | Description                       | Parameters                                                                                      |
|--------|-------------------------------------|-----------------------------------|-------------------------------------------------------------------------------------------------|
| GET    | `/api/v1/rol`                       | Retrieves all roles               | `?nombre=String`, `?descripcion=String`, `?color=String`                                        |
| GET    | `/api/v1/rol/{id}`                  | Retrieves a role by ID            | `id`                                                                                            |
| POST   | `/api/v1/rol`                       | Creates a new role                | N/A                                                                                             |
| PUT    | `/api/v1/rol/{id}`                  | Updates a role by ID              | `id`                                                                                            |
| DELETE | `/api/v1/rol/{id}`                  | Deletes a role by ID              | `id`                                                                                            |
