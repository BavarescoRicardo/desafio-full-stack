# Desafio Programador Fullstack Unoesc

Esse é o nosso desafio para a vaga de programador fullstack na [Unoesc](https://www.unoesc.edu.br/). Serão testadas as habilidades e qualidade de código ao transformar requisitos limitados em uma aplicação web.

## DESAFIO

Você terá que desenvolver uma aplicação web responsável por registrar pessoas e seus dados de contato e endereço. Para esse cadastro é muito importante que o endereço preenchido seja um endereço válido. Portanto, torna-se necesária a validação do CEP e preenchimento do endereço através da API ViaCEP. 

Documentação da API disponível aqui: https://viacep.com.br

### ESCOPO DO DESAFIO

**Requisitos**
- O cadastro de pessoas deve conter: Nome, CPF, data de nascimento e gênero; 
- O cadastro de contato deve conter: Telefone e enderereço de e-mail;
- O cadastro de endereço deve conter: CEP, logradouro, número, bairro, município e estado;
  -  O CEP deve ser validado e o endereço deve ser autocompletado pela API;
  - Após o preenchimento do CEP apenas as inforamções que não são retornadas da API podem ser editadas, as demais devem ser bloqueadas para edição. 
- Deve ser possível consultar, editar e excluir os cadastros;
- A aplicação deve ser protegida por um login. Porém, não é necessário que exista uma tela para cadastro de usuários.

**Atenção!**
- Não há requisitos quando ao formato de exibição das telas de cadastro e consulta, fica livre a escolha do candidato.
- Versionar o projeto realizando commits com comentários do que está sendo implementado;
- Soluções parciais serão aceitas, porém o que for submetido deve estar funcionando.
- Documentar todas as suposições realizadas sobre o desafio no arquivo README.md.
  - Exemplo de suposição: "Não é obrigatório o preenchimento do endereço de e-mail no cadastro do endereço". 

Para auxiliar no entendimento, elaboramos um diagrama de classes simples contendo apenas classes e atributos: 

![diagramadeclasse](https://user-images.githubusercontent.com/4011040/197817709-3e4cfb77-e863-4096-a610-8290f71b8aef.png)

**Tecnologias a serem utilizadas:**
- Java;
- Spring Boot;
- Maven;
- Thymeleaf;
- MySQL 5.7.X;
- GIT;

### AVALIAÇÃO

**O código será avaliado de acordo com os critérios:**
- Build e execução da aplicação;
- Completude das funcionalidades;
- Qualidade de código (design pattern, manutenibilidade, clareza); 
- Histórico do GIT; 
- Boas práticas de UI (Interface com o Usuário);
- Sentido e coerência nas respostas aos questionamentos na entrevista de apresentação do desafio realizada pelo candidato.

**Não esqueça de documentar o processo necessário para rodar a aplicação.**
## Necessário para rodar a aplicação.
** Atualizar repositório
** Baixar as dependencias do maven
** Configurar seu banco em - application.properties



## Minha implementação
* Criados modelos e repositórios
* configuração banco local
* incluidas bibliotecas lombok, jpa
