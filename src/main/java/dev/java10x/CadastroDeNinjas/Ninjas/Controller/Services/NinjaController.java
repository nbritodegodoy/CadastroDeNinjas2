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
    public String criarNinja(){
        return "Ninja criado";
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

    @PutMapping("/alterarID")
    public String alteraOsNinjas(){
        return "Ninja alterado";
    }

    @DeleteMapping("/deletarID")
    public String deletarOsNinjasPorId(){
        return "O ninja foi deletado";
    }




}
