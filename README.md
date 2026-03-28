## TP 16 : Supervision et Journalisation (Logging + Actuator + Prometheus + Grafana)
**Cours : Développement JakartaEE / Spring Boot**


---

##  Objectifs
*   **Collecter** des métriques de performance (JVM, CPU, Mémoire, Requêtes HTTP) via **Spring Boot Actuator**.
*   **Exporter** et centraliser ces données dans une base de données temporelle avec **Prometheus**.
*   **Visualiser** dynamiquement ces indicateurs via des tableaux de bord **Grafana**.
*   **Mettre en œuvre** une journalisation (logging) structurée et persistante.
*   **Automatiser** le déploiement de l'infrastructure complète via **Docker & Docker Compose**.

---

## 🛠 2. Technologies et Outils utilisés
*   **Framework** : Spring Boot 3+ (Java 17/21).
*   **Supervision interne** : Actuator & Micrometer Prometheus Registry.
*   **Base de données de métriques** : Prometheus.
*   **Visualisation & Alerting** : Grafana (Dashboard ID 4701 : JVM Micrometer).
*   **Gestionnaire de dépendances** : Maven.
*   **Conteneurisation** : Docker & Docker Compose.
*   **IDE** : IntelliJ IDEA.

---

##  Étapes de réalisation

### Étape 1 : Initialisation et Configuration
*   Ajout des dépendances `spring-boot-starter-actuator` et `micrometer-registry-prometheus` dans le `pom.xml`.
*   Exposition des endpoints de supervision dans `application.properties` via `management.endpoints.web.exposure.include=*`.

### Étape 2 : Journalisation (Logging)
*   Configuration des niveaux de log (`INFO`, `DEBUG`) et redirection de la sortie vers un fichier physique : `logs/application.log`.
*   Personnalisation du pattern de sortie pour inclure le temps, le thread et le niveau de sévérité.

### Étape 3 : Exportation vers Prometheus
*   Vérification de l'endpoint `/actuator/prometheus` générant des métriques au format compatible.
*   Ajout de métriques personnalisées dans le code métier via `Metrics.counter()`.

### Étape 4 : Configuration de Prometheus & Grafana
*   Rédaction du fichier `prometheus.yml` pour scroller les données de l'application toutes les 5 secondes.
*   Mise en place de règles d'alerte (`rules.yml`) pour détecter l'état "Down" de l'application.
*   Configuration de Grafana : ajout de la Data Source Prometheus et importation du dashboard statistique.

### Étape 5 : Conteneurisation (Docker Compose)
*   Création d'un `Dockerfile` pour l'image de l'application Java (Eclipse Temurin).
*   Rédaction d'un fichier `docker-compose.yml` orchestrant trois services : `app`, `prometheus` et `grafana` dans un réseau isolé.

---
   
## 📸 4. Résultats et Captures d'écran
*   *Vérification des endpoints*
 
<img width="1600" height="485" alt="image" src="https://github.com/user-attachments/assets/58acc087-0b29-49ac-9181-d2391e3ef80c" />

*   *Avec impression élégante*
<img width="1600" height="691" alt="image" src="https://github.com/user-attachments/assets/3bcbb664-35b7-468a-b6fb-8e6936b389a4" />

 ### Health Check 
<img width="1600" height="647" alt="image" src="https://github.com/user-attachments/assets/27df9db7-6e7d-4863-a10b-860f841d8967" />

 ### Infos générales
<img width="1600" height="410" alt="image" src="https://github.com/user-attachments/assets/c5591505-1e04-4172-a043-846a01c1a87a" />

 ### Métriques JVM
<img width="1600" height="358" alt="image" src="https://github.com/user-attachments/assets/33b54c68-fff6-4753-8e8b-11560cc07e67" />

 ### Observation en direct des logs
<img width="1600" height="799" alt="image" src="https://github.com/user-attachments/assets/4cecfb4a-f5d0-40d6-a53f-2ae65930f17e" />

 ### Vérification de l’endpoint Prometheus
 <img width="1600" height="836" alt="image" src="https://github.com/user-attachments/assets/8d5fc1bb-dbf9-454e-912a-36fe0fbbb49f" />

 ### Lancement de Prometheus après son installation
 <img width="1351" height="765" alt="image" src="https://github.com/user-attachments/assets/71d5f83a-983b-43c2-8873-1095971a2495" />

 ### Prometheus est accessible sur http://localhost:9090
 <img width="1600" height="616" alt="image" src="https://github.com/user-attachments/assets/dcb79dc5-724c-416e-85ec-a3c782f8af21" />

 * *Il est connecté à l'application Spring Boot*
 <img width="1600" height="556" alt="image" src="https://github.com/user-attachments/assets/649a01d3-8076-49d6-afe1-a819e609875f" />


 ### Installation et Lancement de Grafana sur  http://localhost:3000
 <img width="1600" height="829" alt="image" src="https://github.com/user-attachments/assets/1633ba83-e06d-4511-916d-afb316cb6cc3" />
 <img width="1600" height="739" alt="image" src="https://github.com/user-attachments/assets/a77a2e69-5278-47aa-a9ee-933ec00a7cdf" />

 ### Ajout et importation de Prometheus comme source 
 <img width="1600" height="716" alt="image" src="https://github.com/user-attachments/assets/12f727e1-3cc2-46d9-b2db-091b42c8558d" />
 <img width="1524" height="349" alt="image" src="https://github.com/user-attachments/assets/8a7e0956-d5e9-4f22-b8fb-6bdd59a76540" />
 <img width="1600" height="550" alt="image" src="https://github.com/user-attachments/assets/e0792b4a-b840-4100-8750-527ff4f619ff" />

 ### Visualisation de
  *Requêtes HTTP/minute*  
  *Temps moyen de réponse*  
  *Utilisation CPU et mémoire JVM*  
  *État de santé de l’application*  
  *Nombre d’exceptions ou erreurs HTTP*  
 <img width="1919" height="802" alt="Capture d&#39;écran 2026-03-28 145455" src="https://github.com/user-attachments/assets/56ca7399-12da-472d-9977-9261001ac69e" />
 <img width="1919" height="682" alt="Capture d&#39;écran 2026-03-28 145525" src="https://github.com/user-attachments/assets/f710d4d6-8e50-40fc-8919-b030148b3d68" />
 <img width="1885" height="635" alt="Capture d&#39;écran 2026-03-28 145542" src="https://github.com/user-attachments/assets/166ed9b7-6202-426f-ab40-adfdff79aab6" />
 <img width="1908" height="691" alt="Capture d&#39;écran 2026-03-28 145602" src="https://github.com/user-attachments/assets/6df4b8fd-0de0-4136-b9dc-d6ad410f5cf9" />
 <img width="1913" height="730" alt="Capture d&#39;écran 2026-03-28 145734" src="https://github.com/user-attachments/assets/fc54e3b2-92fc-4263-b97f-0b894093df53" />

 ### Alertes et supervision proactive
 #### Dans Prometheus web*
 <img width="1918" height="675" alt="Capture d&#39;écran 2026-03-28 150821" src="https://github.com/user-attachments/assets/fcd16b5a-85b3-4f55-ad87-5cb8e29d1393" />

  #### Dans Grafana
   *Etat normale*
   <img width="1919" height="920" alt="Capture d&#39;écran 2026-03-28 151043" src="https://github.com/user-attachments/assets/af9b0693-e4fb-4910-aa41-4771ed1033f1" />

   *Etat d'attente*
   <img width="1592" height="716" alt="Capture d&#39;écran 2026-03-28 151219" src="https://github.com/user-attachments/assets/f8ea5839-101e-4d6f-a9e6-c498ea94f1c0" />

   *Etat de réaction et d'alerte*
   <img width="1578" height="719" alt="Capture d&#39;écran 2026-03-28 151321" src="https://github.com/user-attachments/assets/b7c040a9-5c41-4736-af38-e267eff8b02b" />

 ### Conteneurisation de la supervision avec Docker
  #### Création de l'image
  <img width="1563" height="304" alt="image" src="https://github.com/user-attachments/assets/b454c8a7-5dec-4430-a7aa-43cb3b7ba56c" />
  <img width="1600" height="52" alt="image" src="https://github.com/user-attachments/assets/33aa98d9-8718-46b1-990e-364fd0045562" />
 
  #### Lancement de l'infrastructure  
  <img width="1600" height="424" alt="image" src="https://github.com/user-attachments/assets/cf0c67b4-8dd0-4742-8333-6800681e94c2" />
  <img width="1600" height="424" alt="image" src="https://github.com/user-attachments/assets/09fe2b7b-6ce0-48c8-86f4-602e22d53712" />

  #### Prometheus après conteneurisation
  <img width="1600" height="816" alt="image" src="https://github.com/user-attachments/assets/07a7ad5e-7fe8-4425-9023-48261ea0cf35" />

  #### Prometheus après conteneurisation
  <img width="1600" height="451" alt="image" src="https://github.com/user-attachments/assets/ce9fac3c-2e2b-4483-8d93-1b5a8018edee" />

  #### Grafana après conteneurisation
  <img width="1600" height="696" alt="image" src="https://github.com/user-attachments/assets/4c23099a-1e9d-4c7e-a03a-0551f889e718" />
  <img width="1600" height="567" alt="image" src="https://github.com/user-attachments/assets/4787891f-d264-4602-8dbd-72255b5f1cfd" />
  <img width="1600" height="703" alt="image" src="https://github.com/user-attachments/assets/f86f7c02-3320-46a2-97eb-b2e567457ca5" />

  #### Arrêt du système
  <img width="1448" height="229" alt="image" src="https://github.com/user-attachments/assets/37af7734-04d3-4497-bbd3-1438e95d935a" />
 
  #### Visualisation sur Docker Desktop
  <img width="1600" height="833" alt="image" src="https://github.com/user-attachments/assets/4a50890d-8472-4515-8962-a492ba559bba" />








---

## 💻 5. Comment lancer le projet ?
1.  **Compiler l'application** : `mvn clean package`
2.  **Construire l'image Docker** : `docker build -t spring-monitoring:1.0 .`
3.  **Lancer l'infrastructure** : `docker compose up -d`
4.  **Accès aux outils** :
    *   Application : `http://localhost:8080`
    *   Prometheus : `http://localhost:9090`
    *   Grafana : `http://localhost:3000` (admin / admin)
