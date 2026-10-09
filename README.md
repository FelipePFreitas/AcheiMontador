# AcheiMontador

Plataforma para aproximar clientes de montadores de móveis disponíveis na região.

## Como a plataforma funciona

- O cliente encontra montadores próximos e consulta seus perfis.
- Cliente e montador conversam diretamente para combinar o serviço, a data e o valor.
- A negociação e o pagamento são feitos diretamente entre cliente e montador, sem intermediação da plataforma.

O objetivo do AcheiMontador é facilitar a busca e o contato entre as partes. A plataforma não define preços nem participa do acordo entre cliente e montador.

## Configuração local

A aplicação usa PostgreSQL e lê as configurações por variáveis de ambiente:

- `DB_URL` (opcional; padrão: `jdbc:postgresql://localhost:5432/acheimontador`)
- `DB_USERNAME` (opcional; padrão: `acheimontador`)
- `DB_PASSWORD` (obrigatória; forneça no ambiente, sem gravar o valor no repositório)
- `JWT_SECRET` (obrigatória; use uma chave forte com pelo menos 32 caracteres)
- `JWT_EXPIRATION_MILLIS` (opcional; padrão: `28800000`)

O `compose.yaml` inicia PostgreSQL 17, cria o banco `acheimontador` e persiste os dados no volume `postgres_data`. A senha do banco é obrigatória também no Compose e não possui valor padrão.

Exemplo no PowerShell para iniciar o banco e a aplicação localmente:

```powershell
$env:DB_PASSWORD = "informe-uma-senha-local"
$env:JWT_SECRET = "informe-uma-chave-forte-com-pelo-menos-32-caracteres"
docker compose up -d postgres
.\mvnw spring-boot:run
```

No Linux/macOS, exporte `DB_PASSWORD` e `JWT_SECRET` antes de executar `docker compose up -d postgres` e `./mvnw spring-boot:run`. Configure uma chave JWT nova no ambiente antes de iniciar a aplicação; não armazene segredos no repositório. Para usar credenciais diferentes do padrão, defina `DB_USERNAME` no ambiente tanto para o Compose quanto para a aplicação.

## Organização dos pacotes

Os módulos de negócio ficam agrupados por funcionalidade dentro de `com.felipefreitas.acheimontador`. A estrutura inicial abaixo já existe em `src/main/java`; a classe `AcheiMontadorApplication` permanece no pacote-base.

```text
com.felipefreitas.acheimontador
├── configuracao
│   ├── persistencia
│   └── seguranca
├── autenticacao
│   ├── controller
│   ├── dto
│   └── service
├── usuario
│   ├── dto
│   ├── entity
│   └── repository
├── perfil
│   ├── cliente
│   │   ├── controller
│   │   ├── dto
│   │   └── service
│   └── montador
│       ├── controller
│       ├── dto
│       ├── entity
│       ├── repository
│       └── service
├── busca
│   ├── controller
│   ├── dto
│   ├── repository
│   └── service
├── avaliacao
│   ├── controller
│   ├── dto
│   ├── entity
│   ├── repository
│   └── service
└── assinatura
    ├── controller
    ├── dto
    ├── entity
    ├── repository
    └── service
```

Os pacotes internos separam entrada HTTP (`controller`), modelos de entrada e saída (`dto`), regras da funcionalidade (`service`), persistência (`repository` e `entity`) e configurações técnicas. Use nomes que expressem a ação ou o dado: `BuscarMontadoresController`, `BuscarMontadoresService`, `MontadorRepository`, `MontadorEntity`, `BuscarMontadoresRequest` e `MontadorResumoResponse`. A assinatura é a relação comercial do montador com a plataforma; negociação e pagamento do serviço continuam diretamente entre cliente e montador.
