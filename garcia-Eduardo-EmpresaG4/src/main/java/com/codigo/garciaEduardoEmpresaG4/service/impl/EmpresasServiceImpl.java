package com.codigo.garciaEduardoEmpresaG4.service.impl;

import com.codigo.garciaEduardoEmpresaG4.entity.EmpresasEntity;
import com.codigo.garciaEduardoEmpresaG4.repository.EmpresasRepository;
import com.codigo.garciaEduardoEmpresaG4.service.EmpresasService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresasServiceImpl implements EmpresasService {

    private final EmpresasRepository empresasRepository;

    public EmpresasServiceImpl(EmpresasRepository empresasRepository) {
        this.empresasRepository = empresasRepository;
    }

    @Override
    public EmpresasEntity create(EmpresasEntity empresasEntity) {
        //Auditoria
        empresasEntity.setUsua_crea("EGARCIA");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        empresasEntity.setDate_create(timestamp);

        return empresasRepository.save(empresasEntity);
    }

    @Override
    public EmpresasEntity searchById(Long id) {
        return empresasRepository.findById(id).get();
    }

    @Override
    public List<EmpresasEntity> searchAll() {
        return empresasRepository.findAll();
    }

    @Override
    public EmpresasEntity update(Long id, EmpresasEntity empresasEntity) {

        boolean existe = empresasRepository.existsById(id);
        if(existe){

            Optional usuario = empresasRepository.findById(id);

            EmpresasEntity empresas = empresasRepository.save(getEmpresaById((EmpresasEntity) usuario.get(),empresasEntity));

            return empresas;
        }

        return null;

    }

    private EmpresasEntity getEmpresaById(EmpresasEntity update, EmpresasEntity request){

        update.setRazon_social(request.getRazon_social());
        update.setTipo_documento(request.getTipo_documento());
        update.setNumero_documento(request.getNumero_documento());
        update.setCondicion(request.getCondicion());
        update.setDireccion(request.getDireccion());
        update.setDistrito(request.getDistrito());
        update.setProvincia(request.getProvincia());
        update.setDepartamento(request.getDepartamento());
        update.setEs_agente_retencion(request.getEs_agente_retencion());
        update.setEstado(request.getEstado());
        //Auditoria
        update.setUsua_modif("EGARCIA");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        update.setDate_modif(timestamp);

        return update;
    }

    @Override
    public EmpresasEntity delete(Long id) {

        Optional<EmpresasEntity> empresa = empresasRepository.findById(id);

        if(empresa.isPresent()){

            empresa.get().setEstado(0);
            //Auditoria
            empresa.get().setUsua_delet("EGARCIA");
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            empresa.get().setDate_delet(timestamp);

            return empresasRepository.save(empresa.get());

        }

        return null;
    }


}
