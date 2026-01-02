# foodtech-fraud-alerts

Microserviço **back-end em Java** projetado para o **processamento assíncrono de alertas de fraude**, utilizando **Spring Boot**, conceitos de **AWS**, **arquitetura orientada a eventos** e **boas práticas de sistemas distribuídos**.

O projeto demonstra como projetar, desenvolver e operar um **microserviço desacoplado, confiável e escalável**, comum em plataformas de alta escala como foodtechs e marketplaces.

---

## 📌 Contexto do Problema

Em sistemas que processam grandes volumes de dados, tratar alertas críticos (como fraude) de forma imediata pode deixar tudo mais lento e prejudicar a experiência do usuário.  

Para evitar isso, adotamos um modelo **assíncrono e orientado a eventos**:  
- O alerta é enviado separado do processamento  
- O sistema ganha **velocidade, escalabilidade e resiliência**  
- Continua funcionando mesmo diante de falhas  

## 👥 Cliente do Serviço (Client System)

Este microserviço **não é consumido diretamente por usuários finais (pessoa física)**.

O **cliente da API** é um **sistema interno da plataforma foodtech**, responsável por domínios como:
- pedidos
- pagamentos
- antifraude
- backoffice e operações

Esses sistemas detectam eventos suspeitos e enviam alertas para este serviço, que realiza o processamento de forma **assíncrona**, sem interface gráfica ou interação humana direta.

Essa abordagem reflete arquiteturas reais de **plataformas distribuídas de alta escala**, como o iFood.

---

## 🧱 Visão Geral da Arquitetura

### Fluxo assíncrono orientado a eventos

1. Um sistema cliente envia uma requisição de alerta de fraude  
2. A API valida e persiste o alerta no banco de dados PostgreSQL  
3. Um evento é publicado em uma fila de mensagens  
4. O serviço Worker consome a mensagem de forma assíncrona  
5. O alerta é processado conforme regras de negócio  
6. Em caso de falha, a mensagem é redirecionada para uma **Dead Letter Queue (DLQ)**  

Essa arquitetura promove:
- desacoplamento entre serviços
- escalabilidade horizontal
- isolamento de falhas
- confiabilidade operacional

---

## 🛠️ Stack Tecnológica

### Back-end
- Java 21
- Spring Boot 3
- Spring Web
- Spring Data JPA
- APIs REST
- Programação Orientada a Objetos
- Princípios SOLID

### Mensageria e Processamento Assíncrono
- AWS SQS (simulado localmente com LocalStack)
- Dead Letter Queue (DLQ)
- Arquitetura orientada a eventos
- Retry e tolerância a falhas

### Banco de Dados
- PostgreSQL
- JPA / Hibernate

### Infraestrutura & DevOps
- Docker
- Docker Compose
- Terraform (Infraestrutura como Código – roadmap)
- GitHub Actions (CI/CD – roadmap)
- Conceitos de Cloud AWS

### Observabilidade
- Spring Boot Actuator
- Health checks
- Logs estruturados
- Monitoramento básico

---

## 📂 Estrutura do Projeto (Monorepo)
```text
foodtech-fraud-alerts/
│
├── api-service/          # Microserviço Spring Boot responsável pela ingestão de alertas de fraude
│   ├── src/main/java     # Código-fonte da aplicação
│   ├── src/main/resources# Configurações (application.yml)
│   └── pom.xml           # Gerenciamento de dependências (Maven)
│
├── worker-service/       # (Roadmap) Serviço consumidor de mensagens para processamento assíncrono
├── infra/                # (Roadmap) Infraestrutura como Código (Terraform)
├── docker-compose.yml    # (Roadmap) Ambiente local com PostgreSQL/LocalStack
│
├── README.md             # Documentação técnica do projeto
├── LICENSE               # Licença do projeto
└── .gitignore            # Arquivos ignorados pelo Git


