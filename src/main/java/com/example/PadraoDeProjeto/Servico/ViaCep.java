package com.example.PadraoDeProjeto.Servico;

import com.example.PadraoDeProjeto.Modelo.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCep {

    @GetMapping("/{cep}/json")
    public Endereco consulta(@PathVariable("cep") String cep);
}
