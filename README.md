# Contexte général du projet (DonDuSang)

## Chapitre I : Contexte général du projet

### 1 - Étude de l’Existant

Au Maroc, le don du sang est crucial pour répondre aux besoins des patients et maintenir les stocks de sang adéquats. Une application mobile dédiée pourrait jouer un rôle important en facilitant les dons et en sensibilisant la population. Cette étude vise à examiner les initiatives actuelles et les applications existantes de don du sang au Maroc.

**Objectif :**
- Faciliter l'inscription des donneurs.
- Optimiser la gestion des rendez-vous pour les dons de sang.
- Informer et sensibiliser le public sur le don du sang.

**Méthodologie :**
Nous avons analysé plusieurs sources, y compris des applications mobiles existantes, des organisations de don de sang, et des rapports gouvernementaux pour comprendre l'état actuel du don du sang au Maroc.

**Centre et Applications Existantes :**

- **Centre National de Transfusion Sanguine (CNTS)**
  - Gère la collecte, le traitement et la distribution du sang au Maroc.
  - Organise régulièrement des campagnes de sensibilisation et des collectes de sang dans tout le pays.

- **Applications Mobiles et Initiatives Communautaires**
  - **Don de Sang Maroc :**
    - Application permettant aux utilisateurs de localiser les centres de don, de prendre des rendez-vous et de recevoir des notifications.
    - Partage d'informations sur les critères d'éligibilité et les bénéfices du don de sang.
  - **DabaDon :**
    - Plateforme en ligne permettant aux donneurs potentiels de s'inscrire et de trouver des informations sur les collectes de sang à venir.
    - Facilite les dons en période de besoin urgent.

### Définition du Problème - Description de la Situation Actuelle

Au Maroc, bien que des efforts significatifs soient déployés pour encourager le don du sang, plusieurs défis persistent :

- **Insuffisance des Stocks de Sang :** Les centres de collecte peinent parfois à maintenir des stocks suffisants pour répondre à la demande, surtout lors de périodes de besoins accrus ou de situations d'urgence.
- **Sensibilisation et Éducation :** Une partie significative de la population n'est pas pleinement consciente de l'importance du don régulier de sang, de ses avantages pour la santé et de son impact sur les vies humaines.
- **Accessibilité et Disponibilité :** Certains donneurs potentiels rencontrent des difficultés pour trouver des centres de don proches, et il peut être compliqué de prendre des rendez-vous ou d'être informé des campagnes de collecte.

### Fonctionnement du Cas 

**Processus Manuels :**

- **Enregistrement des Donneurs :**
  - Les donneurs doivent souvent s'inscrire manuellement lors des campagnes de collecte ou aux centres de transfusion sanguine.
  - **Point de douleur :** Ce processus peut être fastidieux et nécessite souvent une documentation papier, ce qui peut entraîner des erreurs de saisie ou des retards dans la mise à jour des informations.

- **Planification des Collectes :**
  - La planification des campagnes de collecte de sang et des événements associés est souvent réalisée manuellement par le personnel du CNTS et des organisations partenaires.
  - **Point de douleur :** La coordination manuelle peut parfois entraîner des conflits d'horaire, des difficultés dans l'affectation des ressources nécessaires et des communications moins efficaces avec les donneurs potentiels.

- **Gestion des Stocks de Sang :**
  - Bien que des systèmes informatisés soient utilisés, une partie de la gestion des stocks peut encore impliquer des processus manuels pour assurer le suivi précis des quantités disponibles et leur répartition entre les centres de santé.
  - **Point de douleur :** Les erreurs humaines potentielles et la nécessité d'une vérification manuelle peuvent ralentir les opérations et affecter la disponibilité en cas d'urgence.

### Analyse des Déficiences et Limites

1. **Insuffisance des Stocks de Sang**
   - **Problème :** Les stocks de sang peuvent souvent être insuffisants pour répondre à la demande, en particulier lors de situations d'urgence ou de besoins accrus.
   - **Données :** Les rapports indiquent que les réserves de sang fluctuent et peuvent parfois ne pas être suffisantes pour couvrir les besoins hospitaliers.

2. **Sensibilisation et Participation des Donneurs**
   - **Problème :** Une partie de la population n'est pas suffisamment sensibilisée aux besoins continus en don de sang, ce qui affecte le nombre de donneurs réguliers.
   - **Données :** Les taux de don régulier pourraient être plus élevés, indiquant une opportunité de sensibilisation accrue et d'éducation sur l'importance du don de sang.

3. **Accessibilité et Gestion des Rendez-vous**
   - **Problème :** Les processus manuels pour la gestion des rendez-vous et la localisation des centres de collecte peuvent entraîner des inefficacités et des difficultés pour les donneurs.
   - **Données :** Les applications mobiles facilitent l'accès aux informations sur les collectes de sang, mais leur adoption peut être limitée par la connectivité et la disponibilité des smartphones.

### Propositions de Solutions Informatiques pour l'Automatisation

1. **Système Centralisé de Gestion des Donneurs**
   - **Solution :** Développer un système centralisé de gestion des donneurs intégrant une base de données robuste et sécurisée pour enregistrer et suivre les informations des donneurs de manière électronique.
   - **Avantages :** Permettrait une gestion centralisée des donneurs, facilitant la mise à jour rapide des informations, la gestion des rendez-vous et l'historique des dons.

2. **Application Mobile Améliorée pour la Gestion des Rendez-vous**
   - **Solution :** Améliorer l'application mobile existante ou en développer une nouvelle pour permettre aux donneurs de planifier leurs rendez-vous de don de sang, recevoir des rappels automatiques et accéder facilement aux informations sur les centres de collecte.
   - **Avantages :** Améliorerait l'accessibilité aux services de collecte de sang, réduirait les oublis de rendez-vous et encouragerait les dons réguliers grâce à une interface conviviale.

## Chapitre II : Analyse et Conception

### Besoins Fonctionnels pour la Gestion des Rendez-vous

**Procédure**

**Acteurs :**
- Donneur de sang
- Personnel administratif (secrétaire)
- Responsable du centre de collecte de sang

**Les besoins fonctionnels**

1. **Authentification**
   - **Description :** Les utilisateurs doivent pouvoir s'authentifier de manière sécurisée pour accéder au système.
   - **Acteurs :** Tous les utilisateurs du système.
   - **Exigences :** Utilisation d'un nom d'utilisateur et d'un mot de passe sécurisé.

2. **Demander un rendez-vous**
   - **Description :** Les donneurs de sang doivent pouvoir demander un rendez-vous pour faire un don de sang à une date et un centre de leur choix.
   - **Acteurs :** Donneur de sang.
   - **Exigences :** Formulaire en ligne pour sélectionner la date, l'heure et le lieu du rendez-vous.

3. **Accepter ou refuser un rendez-vous**
   - **Description :** Le personnel administratif (secrétaire) doit pouvoir accepter ou refuser les demandes de rendez-vous des donneurs.
   - **Acteurs :** Secrétaire.
   - **Exigences :** Interface pour visualiser les demandes de rendez-vous, avec options pour approuver ou rejeter.

4. **Lancer un état de demande de rendez-vous**
   - **Description :** Le système doit pouvoir générer des rapports sur les demandes de rendez-vous en attente, approuvées ou rejetées.
   - **Acteurs :** Responsable du centre de collecte de sang.
   - **Exigences :** Fonctionnalité de génération de rapports avec filtres par statut de rendez-vous et période spécifique.

5. **Ajouter un rendez-vous**
   - **Description :** Le personnel administratif (secrétaire) doit pouvoir ajouter manuellement un rendez-vous pour un donneur, si nécessaire.
   - **Acteurs :** Secrétaire.
   - **Exigences :** Formulaire pour saisir les détails du rendez-vous (nom du donneur, date, heure, centre de collecte).

### Recherche et Filtrage

- **Effectuer des recherches générales à partir d'une barre de recherche**
- **Affiner les résultats de recherche à l'aide de filtres spécifiques [Localisation (ville, région)]**

### Exigences de performance

- Temps de chargement des pages inférieur à 2 secondes.
- Traitement rapide des actions des utilisateurs.

### Technologies utilisées

- **Frontend :** Angular
- **Backend :** Spring Boot
- **Base de données :** PostgreSQL - MySQL
