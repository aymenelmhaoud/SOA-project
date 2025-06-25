# Projet SOA - Gestion Employés, Départements et Paiements

Ce projet est une application Java Spring Boot orientée services (SOA) exposant des API REST permettant la gestion des employés, des départements et des paiements.

## Objectif

Fournir une couche de services REST pour :

- Gérer les employés (ajout, modification, suppression, consultation)
- Gérer les départements
- Gérer les paiements liés aux employés
- Exposer les relations entre employés et départements
- Assurer une architecture claire en couches (Controller, Service, Repository)

## Technologies utilisées

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Web
- Base de données PostgreSQL ou H2
- Maven
- Swagger (pour la documentation API)
- Lombok (pour réduire le code boilerplate)

## Structure du projet

- model : contient les entités JPA (Employe, Departement, Paiement)
- repository : interfaces JPA pour l'accès aux données
- service : logique métier
- controller : API REST exposée
- dto : objets de transfert de données (optionnel)
- config : configuration générale (CORS, Swagger, etc.)

## Endpoints principaux

Employés :

- GET /api/employes : liste des employés
- GET /api/employes/{id} : détails d’un employé
- POST /api/employes : ajouter un employé
- PUT /api/employes/{id} : modifier un employé
- DELETE /api/employes/{id} : supprimer un employé

Départements :

- GET /api/departements
- POST /api/departements
- etc.

Paiements :

- GET /api/paiements
- POST /api/paiements
- etc.

## Installation

1. Cloner le projet
   git clone https://github.com/aymenelmhaoud/soa-employe.git
   cd soa-employe

2. Configurer la base de données dans src/main/resources/application.properties

   Exemple :
   spring.datasource.url=jdbc:postgresql://localhost:5432/soa_db
   spring.datasource.username=postgres
   spring.datasource.password=motdepasse

3. Lancer l'application
   ./mvnw spring-boot:run

4. Accéder à la documentation Swagger (si activée)
   http://localhost:8080/swagger-ui.html

## Exemple de relations

- Un département peut contenir plusieurs employés
- Un employé peut avoir plusieurs paiements
- Les paiements sont associés à un employé

## Licence

Ce projet est open source et peut être utilisé librement à des fins d’apprentissage ou de démonstration.

