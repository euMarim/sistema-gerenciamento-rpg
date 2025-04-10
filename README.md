# Sistema de Gerenciamento de RPG

Sistema de gerenciamento para um jogo de RPG, permitindo o CRUD de personagens e itens mágicos.

## Funcionalidades
- Cadastrar Personagem
- Cadastrar Item Mágico
- Listar Personagens
- Buscar Personagem por ID
- Atualizar Nome de Aventureiro por ID
- Remover Personagem
- Listar Itens Mágicos
- Buscar Item Mágico por ID
- Adicionar Item Mágico ao Personagem
- Listar Itens Mágicos por Personagem
- Remover Item Mágico do Personagem
- Buscar Amuleto do Personagem

## Regras
- Personagens têm 10 pontos para distribuir entre força e defesa.
- Força e defesa dos itens mágicos são somados aos atributos do personagem.
- Apenas um amuleto por personagem.
- Armas têm defesa 0, armaduras têm força 0.

## Como Executar
1. Clone o repositório: `git clone <URL>`
2. Navegue até o diretório: `cd sistema-gerenciamento-rpg`
3. Execute: `mvn spring-boot:run`
4. Acesse a API em `http://localhost:8080`
5. Documentação Swagger: `http://localhost:8080/swagger-ui.html`

## Tecnologias
- Java 11
- Spring Boot
- JPA/Hibernate
- Banco H2 (em memória)
- Swagger
