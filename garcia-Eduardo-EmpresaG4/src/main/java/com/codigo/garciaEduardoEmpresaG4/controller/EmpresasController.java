package com.codigo.garciaEduardoEmpresaG4.controller;

import com.codigo.garciaEduardoEmpresaG4.entity.EmpresasEntity;
import com.codigo.garciaEduardoEmpresaG4.service.EmpresasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/empresas")
@AllArgsConstructor
@Tag(
        name   ="Api de Empresa",
        description = "Implementa todos los metodos para la entidad Empresas"
)
public class EmpresasController {

    private final EmpresasService empresasService;

    @PostMapping("/create")
    @Operation(
            summary = "Registra una empresa en la base de datos",
            description = "Se debe de enviar un json de la entidad empresa para registrar los datos"
            //parameters = { Empresas.class}
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 - Registro Exitoso"
    )
    public ResponseEntity<EmpresasEntity> create(@RequestBody EmpresasEntity entity){

        EmpresasEntity empresasEntity =  empresasService.create(entity);
        return ResponseEntity.ok(empresasEntity);

    }


    @GetMapping("/searchById/{id}")
    @Operation(
            summary = "Busca la empresa por id",
            description = "Se debe de enviar el id"
            //parameters = { Empresas.class}
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 - Registro Exitoso"
    )
    public ResponseEntity<EmpresasEntity> searchById(@PathVariable Long id){

        EmpresasEntity empresa =  empresasService.searchById(id);
        return ResponseEntity.ok(empresa);

    }

    @GetMapping("/searchAll")
    @Operation(
            summary = "Lista todas las empresas",
            description = "No se envia ningun parametro"
            //parameters = { Empresas.class}
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 - Registro Exitoso"
    )
    public ResponseEntity<List<EmpresasEntity>> searchAll(){

        List<EmpresasEntity> listEmpresa =  empresasService.searchAll();
        return ResponseEntity.ok(listEmpresa);

    }

    @PutMapping("/update/{id}")
    @Operation(
            summary = "Actualiza los datos de una empresa",
            description = "Se envia como parametro el id"
            //parameters = { Empresas.class}
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 - Registro Exitoso"
    )
    public ResponseEntity<EmpresasEntity> update(@PathVariable Long id,@RequestBody EmpresasEntity entity){

        EmpresasEntity empresasEntity =  empresasService.update(id,entity);
        return ResponseEntity.ok(empresasEntity);

    }

    @DeleteMapping("/delete/{id}")
    @Operation(
            summary = "Anula una empresa",
            description = "Se envia como parametro el id"
            //parameters = { Empresas.class}
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 - Registro Exitoso"
    )
    public ResponseEntity<EmpresasEntity> delete(@PathVariable Long id){

        EmpresasEntity empresasEntity =  empresasService.delete(id);
        return ResponseEntity.ok(empresasEntity);

    }



}
