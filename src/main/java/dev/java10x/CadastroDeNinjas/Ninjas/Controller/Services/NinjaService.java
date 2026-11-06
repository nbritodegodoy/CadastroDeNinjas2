package dev.java10x.CadastroDeNinjas.Ninjas.Controller.Services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {


    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //listas todos os meus ninjas
    public List<NinjaModel> listarNinja(){
        return ninjaRepository.findAll();

    }
    //listar todos os meus ninjas por ID
    public NinjaModel listarNinjaPorID(Long id){
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        return ninjaModel.orElse(null);
    }
    //criar um ninja
    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }
}
