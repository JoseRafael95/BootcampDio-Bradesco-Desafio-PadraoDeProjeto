# BOOTCAMP DIO - Bradesco - Java Cloud Native
## Descrição
Este projeto foi desenvolvido para o bootcamp Dio, Com o objetivo de estudar os conceitos de Java Spring e padrões de projeto.
O projeto é um sistema de cadastro de cliente consultando seu respecitvio endereço via API Viacep.

## Funcionalidades
- CRUD completo de cliente.
- Integração com API Viacep para rastear o endereço.
- Armazenamento dos dados do cliente em banco de dados.
- Relacionamento entre entidades.
  
## Tecnologias
- Java
- Spring Boot
- Spring Data JPA
- Feign Client (para integração com ViaCEP)
- Maven (gerenciamento de dependências)

## Estrutura do Projeto
``` 
src/
├── main/
│   ├── java/
│   │   └── com/example/PadraoDeProjeto/
│   │       ├── Controle/
│   │       │   └── ClienteEnderecoControle.java       # Endpoints da API
│   │       ├── Modelo/
│   │       │   ├── Cliente.java                      # Entidade JPA
│   │       │   ├── Endereco.java                     # Entidade JPA 
│   │       │   ├── ClienteRepositorio.java           # Repository
│   │       │   └── EnderecoRepositorio.java          # Repository
│   │       ├── Servico/
│   │       │   ├── ClienteEnderecoServico.java       # Lógica de negócio
│   │       │   └── ViaCep.java                       # Feign Client
│   │       └── PadraoDeProjetoApplication.java       # Classe main
│   └── resources/
│       └── application.properties                    # Configurações
└── test/                                             # Testes (a implementar)
```
## Exemplo de Uso
Via Postman
1. Cadastrar um novo cliente (POST):
Endpoint: POST http://localhost:8080/cliente

Headers:
```
Content-Type: application/json
```
Body (raw - JSON):
````
{
  "nome": "Maria Silva",
  "endereco": {
    "cep": "01001000"  // O sistema completa automaticamente com dados do ViaCEP
  }
}

````
(O sistema buscará o endereço completo do CEP no ViaCEP)


## Referências e Links Úteis
https://github.com/digitalinnovationone/lab-padroes-projeto-spring
