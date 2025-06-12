# API de Microserviço E-commerce com Spring Boot



## 📌 O Projeto
API RESTful para gerenciamento de produtos em um sistema e-commerce básico, desenvolvida com Spring Boot.

## 🚀 Como Executar

### Pré-requisitos
- Java 17+ instalado
- Maven 3.6+
- Opcional: Postman ou similar para testar endpoints

### Instalação
```bash
#Clone o repositorio
git clone https://github.com/IamEduardok/Desenvolvimento-de-um-Microservico-com-Spring-Boot.git
```
```bash
#Entre dentro da pasta clonada e do projeto
cd desenvolvimento-de-um-microserviço/demo
```
```bash
#instale as dependências
mvn clean install
```
```bash
#Rode o servidor
mvn spring-boot:run
```

# 📚 Documentação da API
Acesse a documentação interativa:

- Swagger UI: http://localhost:8080/swagger-ui.html

- OpenAPI JSON: http://localhost:8080/v3/api-docs

---
## 🔗 Endpoints Principais

| Método | Endpoint         | Descrição          |
| :----- | :--------------- | :----------------- |
| `GET`    | `/api/produtos`  | Lista todos os produtos |
| `POST`   | `/api/produtos`  | Cria um novo produto |
| `GET`    | `/api/produtos/{id}` | Busca um produto por ID |
| `PUT`    | `/api/produtos/{id}` | Atualiza um produto existente |
| `DELETE` | `/api/produtos/{id}` | Remove um produto     |


## 🛠 Tecnologias Utilizadas

- [VS Code](https://code.visualstudio.com/) | IDE principal com extensões para Angular, ESLint e Debugging
- [Git Bash](https://git-scm.com/downloads) | Terminal otimizado para controle de versionamento com Git


---
