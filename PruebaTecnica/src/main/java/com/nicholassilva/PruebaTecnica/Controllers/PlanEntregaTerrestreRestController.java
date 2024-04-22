package com.nicholassilva.PruebaTecnica.Controllers;

import com.nicholassilva.PruebaTecnica.Services.IPlanEntregaTerrestreService;
import com.nicholassilva.PruebaTecnica.models.Entity.PlanEntregaTerrestre;
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
@Api(value = "ApiPlanEntregaTerrestre")
public class PlanEntregaTerrestreRestController {
    @Autowired
    private IPlanEntregaTerrestreService planEntregaTerrestreService;

    @PostMapping("/planEntregaTerrestre-new")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Crea plan de entrega", notes = "Se crea un plan de entrega terrestre")
    public ResponseEntity<?> create(@Valid @RequestBody PlanEntregaTerrestre planEntregaTerrestre, BindingResult result) {
        PlanEntregaTerrestre planEntregaTerrestreNew = null;

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
            planEntregaTerrestreNew = planEntregaTerrestreService.save(planEntregaTerrestre);
            planEntregaTerrestre.calcularDescuento();
            planEntregaTerrestre.totalEnvio();
        }catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar insert a la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El plan de entrega se ha creado");
        response.put("cliente", planEntregaTerrestreNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping("/planEntregaTerrestre/page/{page}")
    @ApiOperation(value = "paginas de planes de entrega", notes = "Planes de entrega terrestre por paginas")
    public Page<PlanEntregaTerrestre> index(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 4);
        return planEntregaTerrestreService.findAll(pageable);
    }
}
