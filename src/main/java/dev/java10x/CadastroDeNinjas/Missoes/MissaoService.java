package dev.java10x.CadastroDeNinjas.Missoes;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {

    private MissoesRepository missoesRepository;

    public MissaoService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    //Criar missão
    public MissoesModel criarMissao(@RequestBody MissoesModel missao){
        return missoesRepository.save(missao);
    }
    //listar todas as missoes
    public List<MissoesModel> listarTodasMissoes(){
        return missoesRepository.findAll();
    }
    //listar por id
    public MissoesModel listaPorID (Long id){
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);
        return  missoesModel.orElse(null);
    }
    //deletar por id
    public void deletarMissaoPorID(Long id){
        missoesRepository.deleteById(id);
    }
    //atualizar missao

    public MissoesModel atualizarMissao( Long id ,MissoesModel atualizarMissao){
        if (missoesRepository.existsById(id)){
            atualizarMissao.setId(id);
            missoesRepository.save(atualizarMissao);
        }
        return null;
    }

}
