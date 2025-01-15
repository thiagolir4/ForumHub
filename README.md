# **ForumHub**

## 🚀 **Sobre o Projeto**
O **ForumHub** é uma aplicação de fórum construída com Java e Spring Boot, projetada para criar, listar, atualizar e excluir tópicos, além de implementar autenticação com JWT.

---

## 🛠️ **Tecnologias Utilizadas**
- **Backend:**
  - Java 17
  - Spring Boot 3
  - Spring Security (JWT)
  - Hibernate (JPA)
- **Banco de Dados:** MySQL
- **Ferramentas:**
  - Maven
  - IntelliJ IDEA

---

## 📚 **Funcionalidades**
- **Gerenciamento de Tópicos:**
  - Criar, listar, atualizar e excluir tópicos.
- **Autenticação:**
  - Geração e validação de tokens JWT.
- **Gerenciamento de Dados:**
  - Autor e curso vinculados aos tópicos.

---

## ⚙️ **Configuração do Ambiente**

### 1. **Pré-requisitos**
- Java 17 instalado
- Maven configurado
- Banco de dados H2 (ou outro configurado no `application.properties`)

### 2. **Clone o Repositório**
```markdown
git clone https://github.com/thiagolir4/ForumHub.git
cd ForumHub
````

---
 ## 🎯 **Endpoints Principais**
### **Autenticação**
- `POST /auth/login`: Realiza login e retorna o token JWT.

### **Tópicos**
- `POST /topics`: Cria um novo tópico.
- `GET /topics`: Lista todos os tópicos.
- `GET /topics/{id}`: Detalha um tópico específico.
- `PUT /topics/{id}`: Atualiza um tópico.
- `DELETE /topics/{id}`: Exclui um tópico.

### **Exemplo de Requisição POST (Criar Tópico)**
POST /topics
{
  "titulo": "Como aprender Spring Boot?",
  "mensagem": "Gostaria de saber como começar com Spring Boot.",
  "estado": "ABERTO",
  "autor": {
    "id": 1
  },
  "curso": {
    "id": 2
  }
}


---
 ## 🔒 ** Segurança**
- O projeto usa **JWT (JSON Web Token)** para autenticação.
- Para acessar endpoints protegidos:
  1. Faça login em `POST /auth/login` com as credenciais.
  2. Use o token JWT no cabeçalho das requisições:
     Authorization: Bearer <seu_token>

