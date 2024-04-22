# ApiRestFull
# Tecnologia y lenguaje
*Java 17, Spring 3, JPA, Hibernate, patron de diseño DAO*
## Base de datos
*PostgreSQL*

## Para ejecutar el proyecto:
*Actualizar la base de datos, el usuario y la contraseña en el application.properties segun esten configurados en el equipo*

# EndPoints clase Clientes
### Consultar todos los clientes GET:
**http://localhost/api/clientes**

### Crear un cliente POST:
**http://localhost/api/cliente-new**

### Actualizar un cliente PUT:
**http://localhost/api/cliente-new/clientes/{id}**

### Eliminar un cliente Delete:
**http://localhost/api/cliente-new/clientes/{id}**


# EndPoints clase Envios
### ver los envios por paginas GET:
**http://localhost/api/envios/page/{page}**

### crear un envio POST:
**http://localhost/api/envio-new**


# EndPoints clase Plan de entrega Terrestre
### Crea un plan de entrega POST:
**http://localhost/api/planEntregaTerrestre-new**

### Ver los planes de entrega por paginas GET:
**http://localhost/api/planEntregaTerrestre/page/{page}
