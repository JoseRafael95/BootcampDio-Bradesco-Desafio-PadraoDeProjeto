package com.example.PadraoDeProjeto.Controle;

import com.example.PadraoDeProjeto.Modelo.Cliente;
import com.example.PadraoDeProjeto.Servico.ClienteEnderecoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cliente")
public class ClienteEnderecoControle {
    @Autowired
    ClienteEnderecoServico servico;

    @GetMapping
    public List<Cliente> obterTodos(){
        return servico.obterTodos();
    }

    @GetMapping("/{id}")
    public Cliente obterPorId(@PathVariable Long id){
        return servico.obterPorId(id);
    }

    @PostMapping
    public void inserir(@RequestBody Cliente cliente){
        servico.inserir(cliente);
    }

    @PutMapping("/{id}")
    public void atualizacao(@PathVariable Long id, @RequestBody Cliente cliente){
        servico.atualizar(id,cliente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        servico.deletar(id);
    }

}
