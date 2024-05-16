# Agrix API 🚜
<!-- Olá, Tryber!
Esse é apenas um arquivo inicial para o README do seu projeto.
É essencial que você preencha esse documento por conta própria, ok?
Não deixe de usar nossas dicas de escrita de README de projetos, e deixe sua criatividade brilhar!
:warning: IMPORTANTE: você precisa deixar nítido:
- quais arquivos/pastas foram desenvolvidos por você; 
- quais arquivos/pastas foram desenvolvidos por outra pessoa estudante;
- quais arquivos/pastas foram desenvolvidos pela Trybe.
-->
### Introduction
Agrix is an API developed for educational purposes in Java and Spring, aimed at facilitating farm management, including tasks such as crop and fertilizer management.

### Features
* User Authentication:
  * Users can sign up for new accounts and log in to existing ones securely.
* Farm Management:
  * Authenticated users can create new farms and add crops to it.
  * Users can search for farms, either retrieving all farms or a specific one by its unique ID.
* Crop Management:
  * Users can search for crops, either retrieving all crops or a specific one by its unique ID.
  * Users can link fertilizers to their crops and search for then.
* Fertilizer Management:
  * Authenticated users can create new Fertilizers.
  * Users can search for all fertilizers.

### Usage
Using Docker
* Clone this repository.
* Run ```docker compose up -d``` or ```docker compose up``` to see the logs.
* After all build up you can test the application in your API Client on port 8080.

### API Endpoints
| HTTP Verbs | Endpoints | Action | Body
| --- | --- | --- | --- |
| POST | /persons| To create a new user | username: string, password: string, role: enum (ADMIN, MANAGER OR USER)
| POST | /login | To login an existing user account | 
| POST | /farms | To create a new farm | name: string, size: int
| GET | /farms | To retrieve all farms | 
| GET | /farms/:farmId | To retrieve details of a single farm |
| POST | /farms/:farmId/crops | To add a crop to the farm | name: string, plantedArea: double, plantedDate: date, harvestDate: date. ex("2022-12-05")
| GET | /farms/:farmId/crops | Retrieve all crops belonging to the specified farm |
| GET | /crops | To retrieve all crops | 
| GET | /crops/:cropId | To retrieve details of a single crop |
| POST | /crops/:cropId/fertilizers/:fertilizerId | To add a fertilizer to the crop |
| GET | /crops/:cropId/fertilizers | Retrieve all fertilizers belonging to the specified crop |
| POST | /fertilizers | To create a new fertilizer | name: string, brand: string, composition: string
| GET | /fertilizers | To retrieve all fertilizers |

### Technologies Used
* Java
* Spring
* Maven
* MySQL
* JWT 
  
