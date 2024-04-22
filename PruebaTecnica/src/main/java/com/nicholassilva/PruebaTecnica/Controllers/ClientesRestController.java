package com.nicholassilva.PruebaTecnica.Controllers;

import com.nicholassilva.PruebaTecnica.Services.IClientesService;
import com.nicholassilva.PruebaTecnica.models.Entity.Clientes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
@Api(value = "ApiClientes")
public class ClientesRestController {

    @Autowired
    private IClientesService clientesService;

    @GetMapping("/clientes")
    @ApiOperation(value = "Obtener Clientes", notes = "Devuelve Todos los Clientes")
    public List<Clientes> index() {
        return clientesService.findAll();
    }

    @PostMapping("/cliente-new")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Crear clientes", notes = "Crea un cliente")
    public ResponseEntity<?> create(@Valid @RequestBody Clientes clientes, BindingResult result) {
        Clientes clienteNew = null;

        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El Campo '" + err.getField() +"' "+ err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            clienteNew = clientesService.save(clientes);
        }catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar insert a la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El cliente ha sido creado con exito");
        response.put("cliente", clienteNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/clientes/{id}")
    @ApiOperation(value = "Obtener Cliente", notes = "Devuelve un cliente por su Id")
    public ResponseEntity<?> update(@Valid @RequestBody Clientes clientes, BindingResult result, @PathVariable Long id) {
        Clientes clienteActual = clientesService.findById(id);
        Clientes clienteUpdate = null;

        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El Campo '" + err.getField() +"' "+ err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        if(clienteActual == null) {
            response.put("mensaje", "Error: el cliente ID no se pudo editar: ". concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try {
            clienteActual.setNombre(clientes.getNombre());
            clienteActual.setApellidos(clientes.getApellidos());
            clienteActual.setNumeroContacto(clientes.getNumeroContacto());
            clienteActual.setCorreoContacto(clientes.getCorreoContacto());

            clienteUpdate = clientesService.save(clienteActual);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar insert a la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El cliente ha sido editado con exito");
        response.put("cliente", clienteUpdate);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/clientes/{id}")
    @ApiOperation(value = "Eliminar clientes", notes = "Elimina un cliente por su Id")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            Clientes clientes = clientesService.findById(id);
            clientesService.delete(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el cliente de la base de datos, es posible que tenga Envios viculados");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El cliente se ha eliminado con exito");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/clientes/page/{page}")
    @ApiOperation(value = "Paginacion de los Clientes", notes = "Clientes por paginas")
    public Page<Clientes> index(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 4);
        return clientesService.findAll(pageable);
    }
}
