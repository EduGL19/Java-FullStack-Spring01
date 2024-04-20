package com.codigo.garciaEduardoEmpresaG4.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "Empresa")
@Getter
@Setter
public class EmpresasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String razon_social;

    private String tipo_documento;

    private String numero_documento;

    private String condicion;

    private String direccion;

    private String distrito;

    private String provincia;

    private String departamento;

    private Boolean es_agente_retencion;

    private Integer estado;

    private String usua_crea;

    private Timestamp date_create;

    private String usua_modif;

    private Timestamp date_modif;

    private String usua_delet;

    private Timestamp date_delet;

}
