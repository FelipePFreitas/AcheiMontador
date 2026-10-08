# AcheiMontador

Plataforma para aproximar clientes de montadores de móveis disponíveis na região.

## Como a plataforma funciona

- O cliente encontra montadores próximos e consulta seus perfis.
- Cliente e montador conversam diretamente para combinar o serviço, a data e o valor.
- A negociação e o pagamento são feitos diretamente entre cliente e montador, sem intermediação da plataforma.

O objetivo do AcheiMontador é facilitar a busca e o contato entre as partes. A plataforma não define preços nem participa do acordo entre cliente e montador.

## Configuração local

A aplicação usa MySQL e lê as configurações sensíveis por variáveis de ambiente:

- `DB_URL` (opcional; padrão: `jdbc:mysql://localhost:3306/acheimontador`)
- `DB_USERNAME` (opcional; padrão: `root`)
- `DB_PASSWORD` (opcional)
- `JWT_SECRET` (obrigatória; use uma chave forte com pelo menos 32 caracteres)
- `JWT_EXPIRATION_MILLIS` (opcional; padrão: `28800000`)

Configure uma chave JWT nova no ambiente antes de iniciar a aplicação; não armazene segredos no repositório.
