package com.nicholassilva.PruebaTecnica.Controllers;

import com.nicholassilva.PruebaTecnica.Services.IEnviosService;
import com.nicholassilva.PruebaTecnica.models.Entity.Envios;
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
@Api(value = "ApiEnvios")
public class EnviosRestController {
    @Autowired
    private IEnviosService enviosService;

    @PostMapping("/envio-new")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Crear envios", notes = "Crea un envio de plan de entrega")
    public ResponseEntity<?> create(@Valid @RequestBody Envios envios, BindingResult result) {
        Envios envioNew = null;

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
            envioNew = enviosService.save(envios);
        }catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar insert a la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El envio ha sido creado con exito");
        response.put("Envio", envioNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping("/envios/page/{page}")
    @ApiOperation(value = "Paginas envios", notes = "Lista los envios por paginas")
    public Page<Envios> index(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 4);
        return enviosService.findAll(pageable);
    }
}
