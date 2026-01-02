# foodtech-fraud-alerts

Microserviço back-end em Java projetado para processamento assíncrono de alertas de fraude , aplicando arquitetura orientada a eventos , mensageria e boas práticas de sistemas distribuídos.

O projeto simula cenários reais de plataformas de alta escala , com foco em confiabilidade, escalabilidade, tolerância a falhas e observabilidade , competências essenciais para ambientes de restaurantes.

---

## 📌 Desafio Técnico

Em sistemas críticos, o processamento síncrono de eventos sensíveis pode comprometer performance e experiência do usuário. 
Este projeto resolve esse problema ao desacoplar a ingestão do processamento , utilizando comunicação assíncrona e filas de mensagens.

---

## 🧱 Arquitetura da Solução

Fluxo assíncrono orientado a eventos:

1. Cliente envia alerta de fraude 
2. API REST valida e persiste os dados 
3. Evento é publicado em uma fila (SQS) 
4. Worker consome e processa a mensagem 
5. Falhas são tratadas com retry e DLQ 

Essa abordagem garante resiliência, escalabilidade e isolamento de falhas .
