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

### Reserva

- GET `/api/v1/reserva`: Devuelve todas las reservas.
  - `?duracion=Integer`: Filtra las reservas por duración.
  - `?comentario=String`: Filtra las reservas por comentario.
  - `?clienteId=String`: Filtra las reservas por cliente. El cliente puede ser un único id o un array de ids.
    Ejemplo: `1` o `1,2,3`.
  - `?motivoReserva=String`: Filtra las reservas por motivo de reserva.
  - `?estadoId=String`: Filtra las reservas por estado. El estado puede ser un único id o un array de ids. Ejemplo: `1`
    o `1,2,3`.
  - `?motivoRechazo=String`: Filtra las reservas por motivo de rechazo.
  - `?espacioFisicoId=String`: Filtra las reservas por espacio físico. El espacio físico puede ser un único id o un
    array de ids. Ejemplo: `1` o `1,2,3`.
- GET `/api/v1/reserva/{id}`: Devuelve la reserva con el id especificado.
- POST `/api/v1/reserva`: Crea una nueva reserva.
- PUT `/api/v1/reserva/{id}`: Actualiza la reserva con el id especificado.
- DELETE `/api/v1/reserva/{id}`: Elimina la reserva con el id especificado.

### Clientes

- GET `/api/v1/cliente`: Devuelve todos los clientes.
  - `?nombre=String`: Filtra los clientes por nombre.
  - `?apellido=String`: Filtra los clientes por apellido.
  - `?nroTelefono=String`: Filtra los clientes por su número de teléfono.
  - `?email=String`: Filtra los clientes por su email.
  - `?dni=Integer`: Filtra los clientes por su DNI.
  - `?rolId=String`: Filtra los clientes por su rol. El rol puede ser un único id o un array de ids. Ejemplo: `1`
    o `1,2,3`.
- GET `/api/v1/clientes/{id}`: Devuelve el cliente con el id especificado.
- POST `/api/v1/clientes`: Crea un nuevo cliente.
- PUT `/api/v1/clientes/{id}`: Actualiza el cliente con el id especificado.
- DELETE `/api/v1/clientes/{id}`: Elimina el cliente con el id especificado.

### Espacios físicos

- GET `/api/v1/espacio-fisico`: Devuelve todos los espacios físicos.
  - `?nombre=String`: Filtra los espacios físicos por nombre.
  - `?descripcion=String`: Filtra los espacios físicos por descripción.
  - `?capacidad=Integer`: Filtra los espacios físicos por capacidad.
  - `?habilitado=Boolean`: Filtra los espacios físicos por si están habilitados o no.
- GET `/api/v1/espacio-fisico/{id}`: Devuelve el espacio físico con el id especificado.
- POST `/api/v1/espacio-fisico`: Crea un nuevo espacio físico.
- PUT `/api/v1/espacio-fisico/{id}`: Actualiza el espacio físico con el id especificado.
- DELETE `/api/v1/espacio-fisico/{id}`: Elimina el espacio físico con el id especificado.

### Recursos

- GET `/api/v1/recurso`: Devuelve todos los recursos.
  - `?nombre=String`: Filtra los recursos por nombre.
  - `?descripcion=String`: Filtra los recursos por descripción.
- GET `/api/v1/recurso/{id}`: Devuelve el recurso con el id especificado.
- POST `/api/v1/recurso`: Crea un nuevo recurso.
- PUT `/api/v1/recurso/{id}`: Actualiza el recurso con el id especificado.
- DELETE `/api/v1/recurso/{id}`: Elimina el recurso con el id especificado.

### Estados

- GET `/api/v1/estado`: Devuelve todos los estados.
  - `?nombre=String`: Filtra los estados por nombre.
  - `?descripcion=String`: Filtra los estados por descripción.
- GET `/api/v1/estado/{id}`: Devuelve el estado con el id especificado.
- POST `/api/v1/estado`: Crea un nuevo estado.
- PUT `/api/v1/estado/{id}`: Actualiza el estado con el id especificado.
- DELETE `/api/v1/estado/{id}`: Elimina el estado con el id especificado.

### Rol

- GET `/api/v1/rol`: Devuelve todos los roles.
  - `?nombre=String`: Filtra los roles por nombre.
  - `?descripcion=String`: Filtra los roles por descripción.
  - `?color=String`: Filtra los roles por su color. El color debe ser un código hexadecimal. Ejemplo: `FFFFFF`.
- GET `/api/v1/rol/{id}`: Devuelve el rol con el id especificado.
- POST `/api/v1/rol`: Crea un nuevo rol.
- PUT `/api/v1/rol/{id}`: Actualiza el rol con el id especificado.
- DELETE `/api/v1/rol/{id}`: Elimina el rol con el id especificado.
