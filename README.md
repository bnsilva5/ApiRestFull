# ApiRestFull
# Tecnologia y lenguaje
*Java 17, Spring 3, JPA, Hibernate, patron de diseño DAO*
## Base de datos
*PostgreSQL*

## Para ejecutar el proyecto:
*Actualizar la base de datos, el usuario y la contraseña en el application.properties segun esten configurados en el equipo*

# EndPoints clase Clientes
### Consultar todos los clientes GET:
**http://localhost:8090/api/clientes**

### Crear un cliente POST:
**http://localhost:8090/api/cliente-new**

### Actualizar un cliente PUT:
**http://localhost:8090/api/cliente-new/clientes/0**

### Eliminar un cliente Delete:
**http://localhost:8090/api/cliente-new/clientes/0**


# EndPoints clase Envios
### ver los envios por paginas GET:
**http://localhost:8090/api/envios/page/0**

### crear un envio POST:
**http://localhost:8090/api/envio-new**


# EndPoints clase Plan de entrega Terrestre
### Crea un plan de entrega POST:
**http://localhost:8090/api/planEntregaTerrestre-new**

### Ver los planes de entrega por paginas GET:
**http://localhost:8090/api/planEntregaTerrestre/page/0**
