package com.example.PadraoDeProjeto.Servico;

import com.example.PadraoDeProjeto.Modelo.Cliente;
import com.example.PadraoDeProjeto.Modelo.ClienteRepositorio;
import com.example.PadraoDeProjeto.Modelo.Endereco;
import com.example.PadraoDeProjeto.Modelo.EnderecoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteEnderecoServico {
    @Autowired
    ClienteRepositorio clienteRepositorio;
    @Autowired
    EnderecoRepositorio enderecoRepositorio;
    @Autowired
    ViaCep viaCep;

    public List<Cliente> obterTodos(){
        return clienteRepositorio.findAll();
    }

    public Cliente obterPorId(Long id){
        Optional<Cliente> cliente = clienteRepositorio.findById(id);
        return cliente.get();
    }

    public void inserir(Cliente cliente){
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepositorio.findById(cep).orElseGet(()->{
                Endereco enderecoNovo = viaCep.consulta(cep);
                enderecoRepositorio.save(enderecoNovo);
            return enderecoNovo;
        });
        cliente.setEndereco(endereco);
        clienteRepositorio.save(cliente);

        clienteRepositorio.save(cliente);
    }

    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clientePesquisa = clienteRepositorio.findById(id);
        Cliente clienteExistente = clientePesquisa.get();
        clienteExistente.setNome(cliente.getNome());
        clienteExistente.setEndereco(cliente.getEndereco());
        clienteRepositorio.save(clienteExistente);
    }


    public void deletar(Long id){
        clienteRepositorio.deleteById(id);
    }

}
