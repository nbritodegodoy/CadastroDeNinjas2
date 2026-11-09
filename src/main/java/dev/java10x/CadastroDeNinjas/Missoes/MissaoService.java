package dev.java10x.CadastroDeNinjas.Missoes;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {

    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissaoService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    //Criar missão
    public MissoesDTO criarMissao(MissoesDTO missoesDTO){
        MissoesModel missoesModel = missoesMapper.map(missoesDTO);
        missoesModel=missoesRepository.save(missoesModel);
        return missoesMapper.map(missoesModel);
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
