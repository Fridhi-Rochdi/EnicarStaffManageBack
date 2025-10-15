# 🎓 ENICarthage Staff Manager - Backend# 🎓 ENICarthage Staff Manager - Backend



<div align="center"><div align="center">



![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen?style=for-the-badge&logo=spring-boot)![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen?style=for-the-badge&logo=spring-boot)

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk)![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk)

![Maven](https://img.shields.io/badge/Maven-3.8+-red?style=for-the-badge&logo=apache-maven)![Maven](https://img.shields.io/badge/Maven-3.8+-red?style=for-the-badge&logo=apache-maven)

![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)



**API REST moderne et sécurisée pour la gestion du personnel de l'ENI Carthage****API REST moderne et sécurisée pour la gestion du personnel de l'ENI Carthage**



[Documentation API](#-api-endpoints) • [Installation](#-installation) • [Fonctionnalités](#-fonctionnalités)[Documentation API](#-api-endpoints) • [Installation](#-installation) • [Fonctionnalités](#-fonctionnalités)



</div></div>



------



## 📋 Table des matières## 📋 Table des matières



- [À propos](#-à-propos)- [À propos](#-à-propos)

- [Fonctionnalités](#-fonctionnalités)- [Fonctionnalités](#-fonctionnalités)

- [Technologies](#-technologies)- [Technologies](#-technologies)

- [Prérequis](#-prérequis)- [Prérequis](#-prérequis)

- [Installation](#-installation)- [Installation](#-installation)

- [Configuration](#-configuration)- [Configuration](#-configuration)

- [Démarrage](#-démarrage)- [Démarrage](#-démarrage)

- [API Endpoints](#-api-endpoints)- [API Endpoints](#-api-endpoints)

- [Sécurité](#-sécurité)- [Sécurité](#-sécurité)

- [Base de données](#-base-de-données)- [Base de données](#-base-de-données)

- [Stockage de fichiers](#-stockage-de-fichiers)- [Stockage de fichiers](#-stockage-de-fichiers)



------



## 🎯 À propos## 🎯 À propos



Le **ENICarthage Staff Manager Backend** est une API REST développée avec Spring Boot pour gérer les opérations administratives de l'École Nationale d'Ingénieurs de Carthage. Le système offre une solution complète pour la gestion des tickets d'impression, des utilisateurs, des réservations de salles et des périodes d'examens.Le **ENICarthage Staff Manager Backend** est une API REST développée avec Spring Boot pour gérer les opérations administratives de l'École Nationale d'Ingénieurs de Carthage. Le système offre une solution complète pour la gestion des tickets d'impression, des utilisateurs, des réservations de salles et des périodes d'examens.



### Objectifs du projet### Objectifs du projet

- ✅ Centraliser la gestion des demandes d'impression- ✅ Centraliser la gestion des demandes d'impression

- ✅ Automatiser les processus administratifs- ✅ Automatiser les processus administratifs

- ✅ Sécuriser les accès avec JWT- ✅ Sécuriser les accès avec JWT

- ✅ Fournir une API RESTful documentée- ✅ Fournir une API RESTful documentée

- ✅ Gérer les fichiers avec MinIO- ✅ Gérer les fichiers avec MinIO



------



## ✨ Fonctionnalités## ✨ Fonctionnalités



### 🔐 Authentification & Autorisation### 🔐 Authentification & Autorisation

- **JWT Authentication** - Tokens sécurisés avec expiration- **JWT Authentication** - Tokens sécurisés avec expiration

- **Gestion des rôles** - ADMIN, STAFF, PROFESSOR- **Gestion des rôles** - ADMIN, STAFF, PROFESSOR

- **Endpoints protégés** - Contrôle d'accès basé sur les rôles- **Endpoints protégés** - Contrôle d'accès basé sur les rôles

- **Refresh tokens** - Session persistante- **Refresh tokens** - Session persistante



### 📄 Gestion des Tickets### � Gestion des Tickets

- ✅ Création de tickets avec upload de fichiers (PDF, images, documents)- ✅ Création de tickets avec upload de fichiers (PDF, images, documents)

- ✅ Suivi de statut (PENDING, IN_PROGRESS, APPROVED, REJECTED, COMPLETED)- ✅ Suivi de statut (PENDING, IN_PROGRESS, APPROVED, REJECTED, COMPLETED)

- ✅ Téléchargement et visualisation des documents- ✅ Téléchargement et visualisation des documents

- ✅ Historique complet des modifications- ✅ Historique complet des modifications

- ✅ Recherche et filtrage avancés- ✅ Recherche et filtrage avancés



### 👥 Gestion des Utilisateurs### 👥 Gestion des Utilisateurs

- ✅ CRUD complet des utilisateurs- ✅ CRUD complet des utilisateurs

- ✅ Gestion des rôles et permissions- ✅ Gestion des rôles et permissions

- ✅ Activation/Désactivation de comptes- ✅ Activation/Désactivation de comptes

- ✅ Profils utilisateurs détaillés- ✅ Profils utilisateurs détaillés



### 🏢 Réservations de Salles### 🏢 Réservations de Salles

- ✅ Réservation de salles avec équipements- ✅ Réservation de salles avec équipements

- ✅ Validation par les administrateurs- ✅ Validation par les administrateurs

- ✅ Gestion des conflits de réservation- ✅ Gestion des conflits de réservation

- ✅ Commentaires administratifs- ✅ Commentaires administratifs



### 📅 Périodes d'Examens### 📅 Périodes d'Examens

- ✅ Création et gestion des périodes- ✅ Création et gestion des périodes

- ✅ Planification des examens- ✅ Planification des examens

- ✅ Visualisation du calendrier- ✅ Visualisation du calendrier



### 📁 Stockage de Fichiers### 📁 Stockage de Fichiers

- ✅ Intégration MinIO pour stockage S3-compatible- ✅ Intégration MinIO pour stockage S3-compatible

- ✅ Upload de fichiers multi-format- ✅ Upload de fichiers multi-format

- ✅ Téléchargement sécurisé avec authentification- ✅ Téléchargement sécurisé avec authentification

- ✅ Gestion automatique des types MIME- ✅ Gestion automatique des types MIME



------



## 🛠 Technologies## 🛠 Technologies



### Backend Core### Backend Core

- **Spring Boot 3.2.0** - Framework principal- **Spring Boot 3.2.0** - Framework principal

- **Spring Security** - Authentification et autorisation- **Spring Security** - Authentification et autorisation

- **Spring Data JPA** - ORM et accès aux données- **Spring Data JPA** - ORM et accès aux données

- **Hibernate** - Implémentation JPA- **Hibernate** - Implémentation JPA



### Base de données### Base de données

- **H2 Database** - Base de données embarquée (développement)- **H2 Database** - Base de données embarquée (développement)

- **MySQL 8.0+** - Base de données production- **MySQL 8.0+** - Base de données production

- **Spring Data JPA** - Abstraction d'accès aux données- **Spring Data JPA** - Abstraction d'accès aux données



### Sécurité### Sécurité

- **JWT (JSON Web Tokens)** - Authentification stateless- **JWT (JSON Web Tokens)** - Authentification stateless

- **BCrypt** - Hachage des mots de passe- **BCrypt** - Hachage des mots de passe

- **CORS** - Configuration cross-origin- **CORS** - Configuration cross-origin



### Stockage### Stockage

- **MinIO** - Stockage d'objets S3-compatible- **MinIO** - Stockage d'objets S3-compatible

- **Docker** - Conteneurisation MinIO- **Docker** - Conteneurisation MinIO



### Build & Déploiement### Build & Déploiement

- **Maven 3.8+** - Gestion de dépendances- **Maven 3.8+** - Gestion de dépendances

- **Java 17** - Runtime- **Java 17** - Runtime

- **Spring Boot DevTools** - Rechargement à chaud- **Spring Boot DevTools** - Rechargement à chaud



### Documentation### Documentation

- **OpenAPI 3.0** - Documentation API- **OpenAPI 3.0** - Documentation API

- **Postman Collection** - Tests d'API- **Postman Collection** - Tests d'API

- **Swagger UI** - Interface de documentation- **Swagger UI** - Interface de documentation



------



## 📦 Prérequis## 📦 Prérequis



Avant de commencer, assurez-vous d'avoir installé :Avant de commencer, assurez-vous d'avoir installé :



| Logiciel | Version | Téléchargement || Logiciel | Version | Téléchargement |

|----------|---------|----------------||----------|---------|----------------|

| Java JDK | 17+ | [Oracle](https://www.oracle.com/java/technologies/downloads/) || Java JDK | 17+ | [Oracle](https://www.oracle.com/java/technologies/downloads/) |

| Maven | 3.8+ | [Apache Maven](https://maven.apache.org/download.cgi) || Maven | 3.8+ | [Apache Maven](https://maven.apache.org/download.cgi) |

| Docker | Latest | [Docker Desktop](https://www.docker.com/products/docker-desktop) || Docker | Latest | [Docker Desktop](https://www.docker.com/products/docker-desktop) |

| Git | Latest | [Git SCM](https://git-scm.com/) || Git | Latest | [Git SCM](https://git-scm.com/) |



### Optionnel### Optionnel

- **MySQL 8.0+** - Pour la production- **MySQL 8.0+** - Pour la production

- **Postman** - Pour tester l'API- **Postman** - Pour tester l'API



------



## 🚀 Installation## 🚀 Installation



### 1. Cloner le repository### 1. Cloner le repository



```bash```bash

git clone https://github.com/Fridhi-Rochdi/EnicarStaffManageBack.gitgit clone https://github.com/Fridhi-Rochdi/EnicarStaffManageBack.git

cd EnicarStaffManageBackcd EnicarStaffManageBack

``````



### 2. Démarrer MinIO (Stockage de fichiers)### 2. Démarrer MinIO (Stockage de fichiers)



```bash```bash

# Avec Docker Compose# Avec Docker Compose

docker-compose up -ddocker-compose up -d



# Vérifier que MinIO est démarré# Vérifier que MinIO est démarré

docker ps | grep miniodocker ps | grep minio

``````



MinIO sera accessible sur :MinIO sera accessible sur :

- **API**: http://localhost:9100- **API**: http://localhost:9100

- **Console**: http://localhost:9101- **Console**: http://localhost:9101

- **Identifiants**: minioadmin / minioadmin- **Identifiants**: minioadmin / minioadmin



### 3. Installer les dépendances### 3. Installer les dépendances



```bash```bash

mvn clean installmvn clean install

``````



------



## ⚙️ Configuration## ⚙️ Configuration



### Variables d'environnement### Variables d'environnement



Créez un fichier `application-local.properties` (optionnel) :Créez un fichier `application-local.properties` (optionnel) :



```properties```properties

# JWT Configuration# JWT Configuration

jwt.secret=VotreClefSecreteSuperLongueEtComplexePourLaProductionjwt.secret=VotreClefSecreteSuperLongueEtComplexePourLaProduction

jwt.expiration=86400000jwt.expiration=86400000



# Database (H2 - Développement)# Database (H2 - Développement)

spring.datasource.url=jdbc:h2:file:./data/staffmanagerdbspring.datasource.url=jdbc:h2:file:./data/staffmanagerdb

spring.datasource.username=saspring.datasource.username=sa

spring.datasource.password=spring.datasource.password=



# MinIO Configuration# MinIO Configuration

minio.url=http://localhost:9100minio.url=http://localhost:9100

minio.access-key=minioadminminio.access-key=minioadmin

minio.secret-key=minioadminminio.secret-key=minioadmin

minio.bucket-name=enicarthage-filesminio.bucket-name=enicarthage-files



# CORS# CORS

cors.allowed-origins=http://localhost:5173,http://localhost:3000cors.allowed-origins=http://localhost:5173,http://localhost:3000



# File Upload# File Upload

spring.servlet.multipart.max-file-size=10MBspring.servlet.multipart.max-file-size=10MB

spring.servlet.multipart.max-request-size=10MBspring.servlet.multipart.max-request-size=10MB

``````



### Base de données MySQL (Production)### Base de données MySQL (Production)



Pour utiliser MySQL en production, modifiez `application-mysql.properties` :Pour utiliser MySQL en production, modifiez `application-mysql.properties` :



```properties```properties

spring.datasource.url=jdbc:mysql://localhost:3306/staffmanagerdbspring.datasource.url=jdbc:mysql://localhost:3306/staffmanagerdb

spring.datasource.username=votre_utilisateurspring.datasource.username=votre_utilisateur

spring.datasource.password=votre_mot_de_passespring.datasource.password=votre_mot_de_passe

spring.jpa.hibernate.ddl-auto=updatespring.jpa.hibernate.ddl-auto=update

``````



Puis démarrez avec :Puis démarrez avec :

```bash```bash

mvn spring-boot:run -Dspring-boot.run.profiles=mysqlmvn spring-boot:run -Dspring-boot.run.profiles=mysql

``````



------



## 🎬 Démarrage## 🎬 Démarrage



### Méthode 1 : Maven (Recommandée)### Méthode 1 : Maven (Recommandée)



```bash```bash

# Développement avec rechargement automatique# Développement avec rechargement automatique

mvn spring-boot:runmvn spring-boot:run

``````



### Méthode 2 : Script Windows### Méthode 2 : Script Windows



```bash```bash

# Démarrer tout (MinIO + Backend)# Démarrer tout (MinIO + Backend)

.\start.bat.\start.bat

``````



### Méthode 3 : JAR exécutable### Méthode 3 : JAR exécutable



```bash```bash

# Compiler# Compiler

mvn clean packagemvn clean package



# Exécuter# Exécuter

java -jar target/staff-manager-0.0.1-SNAPSHOT.jarjava -jar target/staff-manager-0.0.1-SNAPSHOT.jar

``````



### Vérification### Vérification



L'application sera accessible sur : **http://localhost:8081**L'application sera accessible sur : **http://localhost:8081**



Testez avec :Testez avec :

```bash```bash

curl http://localhost:8081/api/testcurl http://localhost:8081/api/test

``````



Réponse attendue :Réponse attendue :

```json```json

{{

  "success": true,  "success": true,

  "message": "API is working!"  "message": "API is working!"

}}

``````



------



## 📡 API Endpoints## 📡 API Endpoints



### 🔐 Authentication### 🔐 Authentication



| Méthode | Endpoint | Description | Auth || Méthode | Endpoint | Description | Auth |

|---------|----------|-------------|------||---------|----------|-------------|------|

| POST | `/api/auth/login` | Connexion utilisateur | ❌ || POST | `/api/auth/login` | Connexion utilisateur | ❌ |

| POST | `/api/auth/register` | Inscription | ❌ || POST | `/api/auth/register` | Inscription | ❌ |



**Exemple Login:****Exemple Login:**

```bash```bash

curl -X POST http://localhost:8081/api/auth/login \curl -X POST http://localhost:8081/api/auth/login \

  -H "Content-Type: application/json" \  -H "Content-Type: application/json" \

  -d '{  -d '{

    "email": "admin@enicarthage.tn",    "email": "admin@enicarthage.tn",

    "password": "admin123"    "password": "admin123"

  }'  }'

``````



### 📄 Tickets### 📄 Tickets



| Méthode | Endpoint | Description | Auth || Méthode | Endpoint | Description | Auth |

|---------|----------|-------------|------||---------|----------|-------------|------|

| GET | `/api/tickets` | Liste des tickets | ✅ ADMIN/STAFF || GET | `/api/tickets` | Liste des tickets | ✅ ADMIN/STAFF |

| POST | `/api/tickets` | Créer un ticket | ✅ || POST | `/api/tickets` | Créer un ticket | ✅ |

| GET | `/api/tickets/{id}` | Détails d'un ticket | ✅ || GET | `/api/tickets/{id}` | Détails d'un ticket | ✅ |

| PUT | `/api/tickets/{id}` | Modifier un ticket | ✅ || PUT | `/api/tickets/{id}` | Modifier un ticket | ✅ |

| DELETE | `/api/tickets/{id}` | Supprimer un ticket | ✅ || DELETE | `/api/tickets/{id}` | Supprimer un ticket | ✅ |

| GET | `/api/tickets/{id}/download` | Télécharger le fichier | ✅ || GET | `/api/tickets/{id}/download` | Télécharger le fichier | ✅ |

| PATCH | `/api/tickets/{id}/status` | Changer le statut | ✅ ADMIN/STAFF || PATCH | `/api/tickets/{id}/status` | Changer le statut | ✅ ADMIN/STAFF |

| GET | `/api/tickets/my-tickets` | Mes tickets | ✅ || GET | `/api/tickets/my-tickets` | Mes tickets | ✅ |



**Exemple Upload de fichier:****Exemple Upload de fichier:**

```bash```bash

curl -X POST http://localhost:8081/api/tickets \curl -X POST http://localhost:8081/api/tickets \

  -H "Authorization: Bearer {token}" \  -H "Authorization: Bearer {token}" \

  -F "ticket={\"title\":\"Impression TP\",\"description\":\"TP Java\",\"totalNumber\":30}" \  -F "ticket={\"title\":\"Impression TP\",\"description\":\"TP Java\",\"totalNumber\":30}" \

  -F "file=@document.pdf"  -F "file=@document.pdf"

``````



### 👥 Users### 👥 Users



| Méthode | Endpoint | Description | Auth || Méthode | Endpoint | Description | Auth |

|---------|----------|-------------|------||---------|----------|-------------|------|

| GET | `/api/users` | Liste des utilisateurs | ✅ ADMIN || GET | `/api/users` | Liste des utilisateurs | ✅ ADMIN |

| POST | `/api/users` | Créer un utilisateur | ✅ ADMIN || POST | `/api/users` | Créer un utilisateur | ✅ ADMIN |

| GET | `/api/users/{id}` | Détails utilisateur | ✅ ADMIN || GET | `/api/users/{id}` | Détails utilisateur | ✅ ADMIN |

| PUT | `/api/users/{id}` | Modifier utilisateur | ✅ ADMIN || PUT | `/api/users/{id}` | Modifier utilisateur | ✅ ADMIN |

| DELETE | `/api/users/{id}` | Supprimer utilisateur | ✅ ADMIN || DELETE | `/api/users/{id}` | Supprimer utilisateur | ✅ ADMIN |

| GET | `/api/users/me` | Mon profil | ✅ || GET | `/api/users/me` | Mon profil | ✅ |



### 🏢 Room Reservations### 🏢 Room Reservations



| Méthode | Endpoint | Description | Auth || Méthode | Endpoint | Description | Auth |

|---------|----------|-------------|------||---------|----------|-------------|------|

| GET | `/api/room-reservations` | Liste des réservations | ✅ ADMIN/STAFF || GET | `/api/room-reservations` | Liste des réservations | ✅ ADMIN/STAFF |

| POST | `/api/room-reservations` | Créer réservation | ✅ || POST | `/api/room-reservations` | Créer réservation | ✅ |

| GET | `/api/room-reservations/{id}` | Détails réservation | ✅ || GET | `/api/room-reservations/{id}` | Détails réservation | ✅ |

| PUT | `/api/room-reservations/{id}` | Modifier réservation | ✅ || PUT | `/api/room-reservations/{id}` | Modifier réservation | ✅ |

| DELETE | `/api/room-reservations/{id}` | Annuler réservation | ✅ || DELETE | `/api/room-reservations/{id}` | Annuler réservation | ✅ |

| PATCH | `/api/room-reservations/{id}/status` | Changer statut | ✅ ADMIN/STAFF || PATCH | `/api/room-reservations/{id}/status` | Changer statut | ✅ ADMIN/STAFF |

| GET | `/api/room-reservations/my-reservations` | Mes réservations | ✅ || GET | `/api/room-reservations/my-reservations` | Mes réservations | ✅ |



### 📅 Exam Periods### 📅 Exam Periods



| Méthode | Endpoint | Description | Auth || Méthode | Endpoint | Description | Auth |

|---------|----------|-------------|------||---------|----------|-------------|------|

| GET | `/api/exam-periods` | Liste des périodes | ✅ || GET | `/api/exam-periods` | Liste des périodes | ✅ |

| POST | `/api/exam-periods` | Créer période | ✅ ADMIN/STAFF || POST | `/api/exam-periods` | Créer période | ✅ ADMIN/STAFF |

| GET | `/api/exam-periods/{id}` | Détails période | ✅ || GET | `/api/exam-periods/{id}` | Détails période | ✅ |

| PUT | `/api/exam-periods/{id}` | Modifier période | ✅ ADMIN/STAFF || PUT | `/api/exam-periods/{id}` | Modifier période | ✅ ADMIN/STAFF |

| DELETE | `/api/exam-periods/{id}` | Supprimer période | ✅ ADMIN/STAFF || DELETE | `/api/exam-periods/{id}` | Supprimer période | ✅ ADMIN/STAFF |

| GET | `/api/exam-periods/active` | Périodes actives | ✅ || GET | `/api/exam-periods/active` | Périodes actives | ✅ |



------



## 🔒 Sécurité## 🔒 Sécurité



### JWT Authentication### JWT Authentication



Tous les endpoints protégés nécessitent un token JWT dans le header :Tous les endpoints protégés nécessitent un token JWT dans le header :



```bash```bash

Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...

``````



### Rôles disponibles### Rôles disponibles



| Rôle | Description | Permissions || Rôle | Description | Permissions |

|------|-------------|-------------||------|-------------|-------------|

| **ADMIN** | Administrateur | Accès complet à toutes les fonctionnalités || **ADMIN** | Administrateur | Accès complet à toutes les fonctionnalités |

| **STAFF** | Personnel administratif | Gestion des tickets, réservations, périodes d'examens || **STAFF** | Personnel administratif | Gestion des tickets, réservations, périodes d'examens |

| **PROFESSOR** | Professeur | Création de tickets et réservations || **PROFESSOR** | Professeur | Création de tickets et réservations |



### Utilisateurs par défaut### Utilisateurs par défaut



| Email | Mot de passe | Rôle || Email | Mot de passe | Rôle |

|-------|--------------|------||-------|--------------|------|

| admin@enicarthage.tn | admin123 | ADMIN || admin@enicarthage.tn | admin123 | ADMIN |

| staff@enicarthage.tn | staff123 | STAFF || staff@enicarthage.tn | staff123 | STAFF |

| prof.dupont@enicarthage.tn | prof123 | PROFESSOR || prof.dupont@enicarthage.tn | prof123 | PROFESSOR |



⚠️ **Important**: Changez ces mots de passe en production !⚠️ **Important**: Changez ces mots de passe en production !



------



## 💾 Base de données## 💾 Base de données



### Schéma de base de données### Schéma de base de données



``````

┌─────────────┐       ┌──────────────┐       ┌─────────────────────┐┌─────────────┐       ┌──────────────┐       ┌─────────────────────┐

│    Users    │       │   Tickets    │       │  RoomReservations   ││    Users    │       │   Tickets    │       │  RoomReservations   │

├─────────────┤       ├──────────────┤       ├─────────────────────┤├─────────────┤       ├──────────────┤       ├─────────────────────┤

│ id          │◄──────┤ owner_id     │       │ id                  ││ id          │◄──────┤ owner_id     │       │ id                  │

│ email       │       │ title        │       │ user_id            │◄──┐│ email       │       │ title        │       │ user_id            │◄──┐

│ password    │       │ description  │       │ room_name           │   ││ password    │       │ description  │       │ room_name           │   │

│ first_name  │       │ file_name    │       │ reservation_date    │   ││ first_name  │       │ file_name    │       │ reservation_date    │   │

│ last_name   │       │ file_path    │       │ start_time          │   ││ last_name   │       │ file_path    │       │ start_time          │   │

│ role        │       │ status       │       │ end_time            │   ││ role        │       │ status       │       │ end_time            │   │

│ active      │       │ total_number │       │ status              │   ││ active      │       │ total_number │       │ status              │   │

└─────────────┘       └──────────────┘       └─────────────────────┘   │└─────────────┘       └──────────────┘       └─────────────────────┘   │

                                                                        │                                                                        │

                                             ┌──────────────┐           │                                             ┌──────────────┐           │

                                             │ ExamPeriods  │           │                                             │ ExamPeriods  │           │

                                             ├──────────────┤           │                                             ├──────────────┤           │

                                             │ id           │           │                                             │ id           │           │

                                             │ name         │           │                                             │ name         │           │

                                             │ start_date   │           │                                             │ start_date   │           │

                                             │ end_date     │           │                                             │ end_date     │           │

                                             │ is_active    │           │                                             │ is_active    │           │

                                             └──────────────┘───────────┘                                             └──────────────┘───────────┘

``````



### Console H2### Console H2



Accédez à la console H2 pour le développement :Accédez à la console H2 pour le développement :

- **URL**: http://localhost:8081/h2-console- **URL**: http://localhost:8081/h2-console

- **JDBC URL**: `jdbc:h2:file:./data/staffmanagerdb`- **JDBC URL**: `jdbc:h2:file:./data/staffmanagerdb`

- **Username**: `sa`- **Username**: `sa`

- **Password**: (vide)- **Password**: (vide)



------



## 📁 Stockage de fichiers## 📁 Stockage de fichiers



### MinIO Configuration### MinIO Configuration



Le système utilise MinIO pour le stockage de fichiers (S3-compatible).Le système utilise MinIO pour le stockage de fichiers (S3-compatible).



**Console MinIO**: http://localhost:9101**Console MinIO**: http://localhost:9101

- Username: `minioadmin`- Username: `minioadmin`

- Password: `minioadmin`- Password: `minioadmin`



### Bucket structure### Bucket structure



``````

enicarthage-files/enicarthage-files/

├── tickets/├── tickets/

│   ├── 2025/│   ├── 2025/

│   │   ├── 01/│   │   ├── 01/

│   │   │   ├── document1.pdf│   │   │   ├── document1.pdf

│   │   │   └── image.png│   │   │   └── image.png

│   │   └── 02/│   │   └── 02/

│   └── ...│   └── ...

``````



### Types de fichiers supportés### Types de fichiers supportés



- **Documents**: PDF, DOC, DOCX, TXT- **Documents**: PDF, DOC, DOCX, TXT

- **Images**: PNG, JPG, JPEG, GIF- **Images**: PNG, JPG, JPEG, GIF

- **Autres**: ZIP, RAR- **Autres**: ZIP, RAR



**Taille maximale**: 10 MB par fichier**Taille maximale**: 10 MB par fichier



------



## 🧪 Tests## 🧪 Tests



### Postman Collection### Postman Collection



Une collection Postman complète est disponible dans `/postman/`.Une collection Postman complète est disponible dans `/postman/`.



**Import dans Postman:****Import dans Postman:**

1. Ouvrir Postman1. Ouvrir Postman

2. File → Import2. File → Import

3. Sélectionner `ENICarthage_Staff_Manager.postman_collection.json`3. Sélectionner `ENICarthage_Staff_Manager.postman_collection.json`



### Tests unitaires### Tests unitaires



```bash```bash

# Exécuter tous les tests# Exécuter tous les tests

mvn testmvn test



# Tests avec couverture# Tests avec couverture

mvn clean test jacoco:reportmvn clean test jacoco:report

``````



------



## 📚 Documentation API## 📚 Documentation API



### OpenAPI/Swagger### OpenAPI/Swagger



Documentation interactive disponible dans `openapi.json`.Documentation interactive disponible dans `openapi.json`.



Pour visualiser :Pour visualiser :

1. Aller sur [Swagger Editor](https://editor.swagger.io/)1. Aller sur [Swagger Editor](https://editor.swagger.io/)

2. Importer le fichier `openapi.json`2. Importer le fichier `openapi.json`



### Exemples de requêtes### Exemples de requêtes



Voir le dossier `/frontend-integration/` pour des exemples React.Voir le dossier `/frontend-integration/` pour des exemples React.



------



## 🐳 Docker## 🐳 Docker



### Docker Compose (MinIO uniquement)### Docker Compose (MinIO uniquement)



```bash```bash

# Démarrer MinIO# Démarrer MinIO

docker-compose up -ddocker-compose up -d



# Arrêter# Arrêter

docker-compose downdocker-compose down



# Voir les logs# Voir les logs

docker-compose logs -f miniodocker-compose logs -f minio

``````



### Dockeriser l'application (optionnel)### Dockeriser l'application (optionnel)



```dockerfile```dockerfile

FROM openjdk:17-slimFROM openjdk:17-slim

WORKDIR /appWORKDIR /app

COPY target/*.jar app.jarCOPY target/*.jar app.jar

EXPOSE 8081EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]ENTRYPOINT ["java", "-jar", "app.jar"]

``````



```bash```bash

# Build# Build

docker build -t enicar-backend .docker build -t enicar-backend .



# Run# Run

docker run -p 8081:8081 enicar-backenddocker run -p 8081:8081 enicar-backend

``````



------



## 🚀 Déploiement en production## 🚀 Déploiement en production



### Checklist avant déploiement### Checklist avant déploiement



- [ ] Changer le `jwt.secret` dans `application.properties`- [ ] Changer le `jwt.secret` dans `application.properties`

- [ ] Configurer MySQL au lieu de H2- [ ] Configurer MySQL au lieu de H2

- [ ] Changer les mots de passe par défaut- [ ] Changer les mots de passe par défaut

- [ ] Configurer HTTPS- [ ] Configurer HTTPS

- [ ] Configurer MinIO en production- [ ] Configurer MinIO en production

- [ ] Activer les logs de production- [ ] Activer les logs de production

- [ ] Configurer CORS correctement- [ ] Configurer CORS correctement

- [ ] Backup automatique de la base de données- [ ] Backup automatique de la base de données



### Variables d'environnement recommandées### Variables d'environnement recommandées



```bash```bash

export JWT_SECRET=votre-secret-super-long-et-complexeexport JWT_SECRET=votre-secret-super-long-et-complexe

export DB_URL=jdbc:mysql://prod-db:3306/staffmanagerdbexport DB_URL=jdbc:mysql://prod-db:3306/staffmanagerdb

export DB_USERNAME=prod_userexport DB_USERNAME=prod_user

export DB_PASSWORD=prod_passwordexport DB_PASSWORD=prod_password

export MINIO_URL=https://minio.votre-domaine.comexport MINIO_URL=https://minio.votre-domaine.com

export MINIO_ACCESS_KEY=votre_access_keyexport MINIO_ACCESS_KEY=votre_access_key

export MINIO_SECRET_KEY=votre_secret_keyexport MINIO_SECRET_KEY=votre_secret_key

``````



------



## 📂 Structure du projet## 📂 Structure du projet



``````

enicarthageStaffManagerBackend/enicarthageStaffManagerBackend/

├── src/├── src/

│   ├── main/│   ├── main/

│   │   ├── java/tn/enicarthage/staffmanager/│   │   ├── java/tn/enicarthage/staffmanager/

│   │   │   ├── config/              # Configurations (Security, CORS, MinIO)│   │   │   ├── config/              # Configurations (Security, CORS, MinIO)

│   │   │   ├── controller/          # REST Controllers│   │   │   ├── controller/          # REST Controllers

│   │   │   ├── dto/                 # Data Transfer Objects│   │   │   ├── dto/                 # Data Transfer Objects

│   │   │   ├── exception/           # Exception handlers│   │   │   ├── exception/           # Exception handlers

│   │   │   ├── model/               # Entités JPA│   │   │   ├── model/               # Entités JPA

│   │   │   ├── repository/          # Repositories Spring Data│   │   │   ├── repository/          # Repositories Spring Data

│   │   │   ├── security/            # JWT & Security│   │   │   ├── security/            # JWT & Security

│   │   │   └── service/             # Business logic│   │   │   └── service/             # Business logic

│   │   └── resources/│   │   └── resources/

│   │       ├── application.properties│   │       ├── application.properties

│   │       ├── application-mysql.properties│   │       ├── application-mysql.properties

│   │       └── application-prod.properties│   │       └── application-prod.properties

│   └── test/                        # Tests unitaires│   └── test/                        # Tests unitaires

├── data/                            # Base de données H2├── data/                            # Base de données H2

├── frontend-integration/            # Exemples React├── frontend-integration/            # Exemples React

├── postman/                         # Collection Postman├── postman/                         # Collection Postman

├── docker-compose.yml               # Configuration Docker├── docker-compose.yml               # Configuration Docker

├── pom.xml                          # Dépendances Maven├── pom.xml                          # Dépendances Maven

└── README.md└── README.md

``````



------



## 🤝 Contribution## 🤝 Contribution



Les contributions sont les bienvenues ! Voici comment contribuer :Les contributions sont les bienvenues ! Voici comment contribuer :



1. **Fork** le projet1. **Fork** le projet

2. **Créer** une branche (`git checkout -b feature/AmazingFeature`)2. **Créer** une branche (`git checkout -b feature/AmazingFeature`)

3. **Commit** vos changements (`git commit -m 'Add AmazingFeature'`)3. **Commit** vos changements (`git commit -m 'Add AmazingFeature'`)

4. **Push** vers la branche (`git push origin feature/AmazingFeature`)4. **Push** vers la branche (`git push origin feature/AmazingFeature`)

5. **Ouvrir** une Pull Request5. **Ouvrir** une Pull Request



------



## 📝 License## 📝 License



Ce projet est sous licence MIT. Voir le fichier `LICENSE` pour plus de détails.Ce projet est sous licence MIT. Voir le fichier `LICENSE` pour plus de détails.



------



## 👨‍💻 Auteur## 👨‍💻 Auteur



**Rochdi Fridhi****Rochdi Fridhi**

- GitHub: [@Fridhi-Rochdi](https://github.com/Fridhi-Rochdi)- GitHub: [@Fridhi-Rochdi](https://github.com/Fridhi-Rochdi)

- Email: rochdi.fridhi@enicarthage.tn- Email: rochdi.fridhi@enicarthage.tn



------



## 🙏 Remerciements## 🙏 Remerciements



- ENI Carthage pour le support du projet- ENI Carthage pour le support du projet

- Spring Boot Community- Spring Boot Community

- MinIO Team- MinIO Team



------



<div align="center"><div align="center">



**⭐ Si ce projet vous a aidé, n'oubliez pas de laisser une étoile ! ⭐****⭐ Si ce projet vous a aidé, n'oubliez pas de laisser une étoile ! ⭐**



Made with ❤️ by ENI Carthage StudentsMade with ❤️ by ENI Carthage Students



</div></div>


L'application sera accessible sur : **http://localhost:8080**

## 👥 Utilisateurs par Défaut

Le système crée automatiquement trois utilisateurs au démarrage :

| Rôle       | Email                      | Mot de passe |
|------------|----------------------------|--------------|
| Admin      | admin@enicarthage.tn       | admin123     |
| Professeur | prof.dupont@enicarthage.tn | prof123      |
| Staff      | staff@enicarthage.tn       | staff123     |

## 📡 API Endpoints

### Authentication

#### Login
```http
POST /api/auth/login
Content-Type: application/json

{
  "email": "prof.dupont@enicarthage.tn",
  "password": "prof123"
}
```

**Réponse :**
```json
{
  "success": true,
  "message": "Login successful",
  "data": {
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
    "type": "Bearer",
    "id": 1,
    "email": "prof.dupont@enicarthage.tn",
    "firstName": "Jean",
    "lastName": "Dupont",
    "role": "PROFESSOR"
  }
}
```

#### Register
```http
POST /api/auth/register
Content-Type: application/json

{
  "email": "new.user@enicarthage.tn",
  "password": "password123",
  "firstName": "John",
  "lastName": "Doe",
  "role": "PROFESSOR"
}
```

#### Get Current User
```http
GET /api/auth/me
Authorization: Bearer {token}
```

### Tickets

#### Créer un Ticket
```http
POST /api/tickets
Authorization: Bearer {token}
Content-Type: multipart/form-data

ticket: {
  "title": "Mathématiques - Algèbre Linéaire",
  "description": "Notes de cours",
  "fileType": "COURS",
  "totalNumber": 25
}
file: [fichier PDF/DOC]
```

#### Obtenir tous les Tickets (Admin/Staff uniquement)
```http
GET /api/tickets
Authorization: Bearer {token}
```

#### Obtenir mes Tickets
```http
GET /api/tickets/my-tickets
Authorization: Bearer {token}
```

#### Obtenir un Ticket par ID
```http
GET /api/tickets/{id}
Authorization: Bearer {token}
```

#### Mettre à jour un Ticket
```http
PUT /api/tickets/{id}
Authorization: Bearer {token}
Content-Type: multipart/form-data

ticket: {
  "title": "Titre mis à jour",
  "description": "Description",
  "fileType": "EXAMEN",
  "totalNumber": 30
}
file: [nouveau fichier optionnel]
```

#### Mettre à jour le Statut (Admin/Staff uniquement)
```http
PATCH /api/tickets/{id}/status?status=EN_COURS
Authorization: Bearer {token}
```

#### Supprimer un Ticket
```http
DELETE /api/tickets/{id}
Authorization: Bearer {token}
```

### Test

#### Health Check
```http
GET /api/test/health
```

#### Public Endpoint
```http
GET /api/test/public
```

## 📊 Types de Fichiers

- `COURS` - Cours
- `TRAVEAUX_DIRIGES` - Travaux Dirigés
- `TRAVEAUX_PRATIQUES` - Travaux Pratiques
- `COURS_INTEGRE` - Cours Intégré
- `EXAMEN` - Examen
- `EXAMEN_INTELLIGENT` - Examen Intelligent

## 📈 Statuts des Tickets

- `EN_ATTENTE` - En Attente
- `EN_COURS` - En Cours
- `TERMINE` - Terminé
- `ANNULE` - Annulé

## 🔐 Sécurité

- Authentification JWT
- Tokens valides pendant 24 heures
- Mots de passe hashés avec BCrypt
- CORS configuré pour le frontend
- Protection CSRF désactivée (API REST)

## 📁 Structure du Projet

```
src/main/java/tn/enicarthage/staffmanager/
├── config/              # Configuration (Security, CORS, etc.)
├── controller/          # REST Controllers
├── dto/                 # Data Transfer Objects
├── exception/           # Exception Handlers
├── model/               # Entités JPA
├── repository/          # Repositories JPA
├── security/            # JWT & Security Classes
└── service/             # Business Logic
```

## 🗄️ Console H2 (Mode Développement)

Accéder à la console H2 : **http://localhost:8080/h2-console**

- **JDBC URL:** `jdbc:h2:mem:staffmanagerdb`
- **Username:** `sa`
- **Password:** *(vide)*

## 📦 Upload de Fichiers

Les fichiers uploadés sont stockés dans le dossier `./uploads` à la racine du projet.

Taille maximale : **10 MB**

## 🧪 Tests

```bash
# Exécuter les tests
mvn test

# Exécuter avec couverture
mvn test jacoco:report
```

## 🔄 Intégration Frontend

Le backend est configuré pour accepter les requêtes du frontend React sur :
- http://localhost:5173 (Vite dev server)
- http://localhost:3000 (React dev server)

Pour ajouter d'autres origines, modifier `application.properties` :
```properties
cors.allowed-origins=http://localhost:5173,http://localhost:3000,http://autre-origine
```

## 📝 Variables d'Environnement

Vous pouvez surcharger les propriétés via des variables d'environnement :

```bash
export JWT_SECRET=votre_secret_jwt
export JWT_EXPIRATION=86400000
export UPLOAD_DIR=/chemin/vers/uploads
```

## 🐛 Débogage

Pour activer les logs détaillés :

```properties
logging.level.tn.enicarthage=DEBUG
logging.level.org.springframework.security=DEBUG
```

## 📄 Licence

Ce projet est développé pour ENICarthage.

## 👨‍💻 Support

Pour toute question ou problème, veuillez contacter l'équipe de développement.
#   E n i c a r S t a f f M a n a g e B a c k 
 
 