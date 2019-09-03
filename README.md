### PROJETO PARA SELEÇÃO SANTANDER

#### Antes de executar o projeto você precisa:
1. Ter um banco de dados postgres sendo executado remotamente na porta (Pode ser via docker)
2. 

#### Url para autenticar o usuário e receber o token:
http://localhost:8081/login

#### Json para autenticar
{
	"username": "email@email.com",
	"password": "123"
}
OU
{
	"username": "dev@email.com",
	"password": "123"
}

#### Comando para executar o projeto:
mvn spring-boot:run