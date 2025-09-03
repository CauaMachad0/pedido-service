# 🛒 Projeto Spring MVC Java - Pedido Service

![Java](https://img.shields.io/badge/Java-17-red?logo=java&logoColor=white)
![Spring MVC](https://img.shields.io/badge/Spring-MVC-brightgreen?logo=spring&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-Build-blue?logo=gradle&logoColor=white)
![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow)

---

## 📖 Sobre o Projeto
Este repositório contém uma aplicação web desenvolvida em **Java com Spring MVC**, utilizando **Gradle** como ferramenta de build.  

O sistema implementa um CRUD simples para **gestão de pedidos**, permitindo cadastrar novos pedidos e consultar todos os pedidos registrados.

---

## 🛠️ Tecnologias Utilizadas
- **Java 17+**
- **Spring MVC**
- **Spring Data JPA**
- **Gradle**
- **H2 Database (ou outro configurado)**
- **REST APIs (JSON)**

---

## 📂 Estrutura do Projeto
```
pedido-service/
│── src/
│   ├── main/
│   │   ├── java/       
│   │   │   └── br/com/fiap/pedidoservice/
│   │   │       ├── config/          # Configurações
│   │   │       ├── controller/      # Controllers (PedidoController)
│   │   │       ├── dto/             # DTOs (ex: ProdutoDTO)
│   │   │       ├── model/           # Entidades (Pedido, ItemPedido)
│   │   │       ├── repository/      # Repositórios (PedidoRepository)
│   │   │       └── service/         # Serviços (PedidoService)
│   │   └── resources/               # Configurações e properties
│── build.gradle         
│── settings.gradle      
│── README.md            
```

---

## ▶️ Como Executar o Projeto

### 1️⃣ Clonar o repositório
```bash
git clone https://github.com/CauaMachad0/pedido-service.git
cd pedido-service
```

### 2️⃣ Construir o projeto
```bash
./gradlew build
```

### 3️⃣ Rodar aplicação
```bash
./gradlew bootRun
```

---

## 🌐 Endpoints Implementados

### 📦 PedidoController

#### ➕ Criar Pedido
```http
POST /pedidos
Content-Type: application/json
```
**Request Body**
```json
{
  "cliente": "João Silva",
  "itens": [
    { "produto": "Notebook", "quantidade": 1, "preco": 3500.00 },
    { "produto": "Mouse", "quantidade": 2, "preco": 80.00 }
  ],
  "valorTotal": 3660.00
}
```

**Response (201 Created)**
```json
{
  "id": 1,
  "cliente": "João Silva",
  "itens": [
    { "produto": "Notebook", "quantidade": 1, "preco": 3500.00 },
    { "produto": "Mouse", "quantidade": 2, "preco": 80.00 }
  ],
  "valorTotal": 3660.00
}
```

---

#### 📋 Listar Pedidos
```http
GET /pedidos
```

**Response (200 OK)**
```json
[
  {
    "id": 1,
    "cliente": "João Silva",
    "valorTotal": 3660.00
  },
  {
    "id": 2,
    "cliente": "Maria Souza",
    "valorTotal": 150.00
  }
]
```

---

## ✅ Melhorias Futuras
- Adicionar atualização (`PUT /pedidos/{id}`)  
- Adicionar exclusão (`DELETE /pedidos/{id}`)  
- Implementar paginação e ordenação de pedidos  
- Testes unitários com JUnit e Mockito  
- Deploy em nuvem (Heroku, Azure ou AWS)  

---

## 👨‍💻 Autor
**Cauã Marcelo Machado**  
📌 Estudante de TI | Backend Developer (Java & Spring) | Cloud Enthusiast  

🔗 [LinkedIn]([https://www.linkedin.com/in/cauã-machado)](https://www.linkedin.com/in/caua-machado-dev)  
🔗 [GitHub](https://github.com/CauaMachad0)

---

## 📜 Licença
Este projeto é de uso acadêmico/estudo, livre para consultas e melhorias.  
