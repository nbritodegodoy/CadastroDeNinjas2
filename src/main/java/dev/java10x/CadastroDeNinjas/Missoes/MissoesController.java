package dev.java10x.CadastroDeNinjas.Missoes;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissaoService missaoService;

    public MissoesController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }
    //Criar missao
    @PostMapping("/criar")
    public MissoesDTO criarMissao(@RequestBody MissoesDTO missao){
        return missaoService.criarMissao(missao);
    }
    //Listar todas as missoes

    @GetMapping("/listar")
    public List<MissoesModel> listarTodasMissoes(){
        return missaoService.listarTodasMissoes();
    }
    //Listar a missão por ID
    @GetMapping("/listar/{id}")
    public MissoesModel listarPorID(@PathVariable Long id){
        return missaoService.listaPorID(id);
    }
    //Deletar missao
    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id){
        missaoService.deletarMissaoPorID(id);
    }
    //atualizar missao
    @PutMapping("/atualizar/{id}")
    public MissoesModel atualizarMissao(@PathVariable Long id ,@RequestBody MissoesModel missaoAtualizada){
        return missaoService.atualizarMissao(id, missaoAtualizada);
    }
}
