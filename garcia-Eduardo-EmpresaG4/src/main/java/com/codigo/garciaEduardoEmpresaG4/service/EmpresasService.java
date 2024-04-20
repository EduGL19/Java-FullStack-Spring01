package com.codigo.garciaEduardoEmpresaG4.service;

import com.codigo.garciaEduardoEmpresaG4.entity.EmpresasEntity;

import java.util.List;

public interface EmpresasService {

    EmpresasEntity create(EmpresasEntity empresasEntity);

    EmpresasEntity searchById(Long id);

    List<EmpresasEntity> searchAll();

    EmpresasEntity update(Long id,EmpresasEntity empresasEntity);

    EmpresasEntity delete(Long id);

}
