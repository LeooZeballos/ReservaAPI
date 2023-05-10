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
### Recursos
- GET `/api/v1/recursos`: Devuelve todos los recursos.
- GET `/api/v1/recursos/{id}`: Devuelve el recurso con el id especificado.
- POST `/api/v1/recursos`: Crea un nuevo recurso.
- PUT `/api/v1/recursos/{id}`: Actualiza el recurso con el id especificado.
- DELETE `/api/v1/recursos/{id}`: Elimina el recurso con el id especificado.

### Espacios físicos
- GET `/api/v1/espacios`: Devuelve todos los espacios físicos.
- GET `/api/v1/espacios/{id}`: Devuelve el espacio físico con el id especificado.
- POST `/api/v1/espacios`: Crea un nuevo espacio físico.
- PUT `/api/v1/espacios/{id}`: Actualiza el espacio físico con el id especificado.
- DELETE `/api/v1/espacios/{id}`: Elimina el espacio físico con el id especificado.