# API de Amigo Secreto

Esta é uma API REST desenvolvida em Spring Boot para gerenciar e realizar sorteios de Amigo Secreto. Com ela, é possível criar grupos, adicionar participantes, realizar o sorteio e consultar quem cada participante deve presentear.

# API Endpoints

```
POST /criarGrupo - Cria um novo grupo para o amigo secreto.

POST /adicionarParticipante - Adiciona um participante no grupo.

POST /grupos/{id}/sorteio - Realiza o sorteio dos amigos secretos para o grupo identificado pelo id.

GET /participantes/{id} -  Retorna o participante a ser presenteado.

```
