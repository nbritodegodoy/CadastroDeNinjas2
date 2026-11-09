package dev.java10x.CadastroDeNinjas.Ninjas.Controller.Services;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas(){return "Essa é minha primeira mensagem";}

    // adicionar
    @PostMapping("/criar")
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){
        return ninjaService.criarNinja(ninja);
    }
    //mostrar todos os ninjas
    @GetMapping("/listar")
    public List<NinjaModel> listarNinja(){
        return ninjaService.listarNinja();
    }
    //mostrar ninja por id

    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjaPorID(@PathVariable Long id) {
        return ninjaService.listarNinjaPorID(id);
    }

    @PutMapping("/alterar/{id}")
    public NinjaModel alterarNinjas(@PathVariable Long id ,@RequestBody NinjaModel ninjaAtualizado){
        return ninjaService.atualizarNinja(id ,ninjaAtualizado);
    }
    //deletar ninja
    @DeleteMapping("/deletar/{id}")
    public void deletarOsNinjasPorId(@PathVariable Long id){

        ninjaService.deletarNinjaPorid(id);
    }




}
