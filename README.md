📚 Índice
Tecnologias Utilizadas
Requisitos
Configuração do Projeto
Endpoints da API
Autenticação
Contribuições
🛠 Tecnologias Utilizadas
Java 17
Spring Boot 3.x
Spring Security
JWT (JSON Web Token)
JPA/Hibernate
H2 Database (ou outro banco configurado)
Lombok
✅ Requisitos
Java 17+ instalado
Maven instalado
Postman/Insomnia (para testes de API)
Banco de dados configurado (H2 ou outro definido em application.properties)
🚀 Configuração do Projeto
1. Clone o repositório:
   bash
   Copiar código
   git clone https://github.com/seu-usuario/forumhub.git
   cd forumhub
2. Configure o banco de dados:
   No arquivo src/main/resources/application.properties, configure as credenciais do banco de dados (exemplo com H2):

properties
Copiar código
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
3. Execute o projeto:
   bash
   Copiar código
   mvn spring-boot:run
4. Acesse o console H2 (se habilitado):
   URL: http://localhost:8080/h2-console
   Driver Class: org.h2.Driver
   JDBC URL: jdbc:h2:mem:testdb
   User Name: sa
   Password: password
   📃 Endpoints da API
1. Autenticação
   Login
   POST /auth/login
   Body:
   json
   Copiar código
   {
   "username": "admin",
   "password": "123456"
   }
   Retorno:
   json
   Copiar código
   {
   "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
   }
2. Tópicos
   Criar Tópico
   POST /topics
   Body:
   json
   Copiar código
   {
   "titulo": "Título do Tópico",
   "mensagem": "Mensagem do Tópico",
   "estado": "ABERTO",
   "autor": {
   "id": 1
   },
   "curso": {
   "id": 1
   }
   }
   Listar Tópicos
   GET /topics
   Detalhar Tópico
   GET /topics/{id}
   Atualizar Tópico
   PUT /topics/{id}
   Body:
   json
   Copiar código
   {
   "titulo": "Novo Título",
   "mensagem": "Nova Mensagem",
   "estado": "FECHADO"
   }
   Excluir Tópico
   DELETE /topics/{id}
3. Cursos
   Criar Curso
   POST /cursos
   Body:
   json
   Copiar código
   {
   "nome": "Curso de Java"
   }
4. Autores
   Criar Autor
   POST /autores
   Body:
   json
   Copiar código
   {
   "nome": "João da Silva",
   "email": "joao@email.com"
   }
   🔒 Autenticação
   JWT Token
   Para acessar os endpoints protegidos, envie o token no cabeçalho da requisição:
   http
   Copiar código
   Authorization: Bearer {SEU_TOKEN}
   🤝 Contribuições
   Fork este repositório.
   Crie uma branch para a sua feature (git checkout -b minha-feature).
   Faça commit das suas alterações (git commit -m 'Adiciona nova feature').
   Envie o push para a branch (git push origin minha-feature).
   Abra um Pull Request.
