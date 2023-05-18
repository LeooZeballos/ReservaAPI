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
  - `?nombre=String`: Filtra los recursos por nombre.
  - `?descripcion=String`: Filtra los recursos por descripción.
- GET `/api/v1/recursos/{id}`: Devuelve el recurso con el id especificado.
- POST `/api/v1/recursos`: Crea un nuevo recurso.
- PUT `/api/v1/recursos/{id}`: Actualiza el recurso con el id especificado.
- DELETE `/api/v1/recursos/{id}`: Elimina el recurso con el id especificado.

### Espacios físicos
- GET `/api/v1/espacios`: Devuelve todos los espacios físicos.
  - `?nombre=String`: Filtra los espacios físicos por nombre.
  - `?descripcion=String`: Filtra los espacios físicos por descripción.
  - `?capacidad=Integer`: Filtra los espacios físicos por capacidad.
  - `?habilitado=Boolean`: Filtra los espacios físicos por si están habilitados o no.
- GET `/api/v1/espacios/{id}`: Devuelve el espacio físico con el id especificado.
- POST `/api/v1/espacios`: Crea un nuevo espacio físico.
- PUT `/api/v1/espacios/{id}`: Actualiza el espacio físico con el id especificado.
- DELETE `/api/v1/espacios/{id}`: Elimina el espacio físico con el id especificado.

### Estados
- GET `/api/v1/estados`: Devuelve todos los estados.
  - `?nombre=String`: Filtra los estados por nombre.
  - `?descripcion=String`: Filtra los estados por descripción.
- GET `/api/v1/estados/{id}`: Devuelve el estado con el id especificado.
- POST `/api/v1/estados`: Crea un nuevo estado.
- PUT `/api/v1/estados/{id}`: Actualiza el estado con el id especificado.
- DELETE `/api/v1/estados/{id}`: Elimina el estado con el id especificado.

### Rol
- GET `/api/v1/roles`: Devuelve todos los roles.
  - `?nombre=String`: Filtra los roles por nombre.
  - `?descripcion=String`: Filtra los roles por descripción.
  - `?color=String`: Filtra los roles por su color. El color debe ser un código hexadecimal. Ejemplo: `FFFFFF`.
- GET `/api/v1/roles/{id}`: Devuelve el rol con el id especificado.
- POST `/api/v1/roles`: Crea un nuevo rol.
- PUT `/api/v1/roles/{id}`: Actualiza el rol con el id especificado.
- DELETE `/api/v1/roles/{id}`: Elimina el rol con el id especificado.
