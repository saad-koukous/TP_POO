# TP_POO
## [Spring Web](https://spring.io/projects/spring-ws)
Spring Web est un sous-module de Spring qui fournit des fonctionnalités pour le développement d'applications web, comme la gestion des requêtes HTTP, la gestion des sessions, la gestion des vues, etc. Il fournit également des classes de base pour simplifier la création de contrôleurs et la gestion des requêtes HTTP. En utilisant Spring Web, on peut écrire moins de code pour gérer les requêtes HTTP et se concentrer sur les logiques métiers. Il permet également de faciliter l'intégration avec d'autres modules Spring tels que Spring MVC ou Spring Security pour construire des applications web plus robustes.
## [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
Spring Data JPA est un module de Spring qui facilite l'utilisation de JPA (Java Persistence API) pour l'accès aux données en utilisant les fonctionnalités de Spring, comme les transactions, les requêtes nommées, etc. Il fournit également des classes de base pour simplifier la création de répositories (classes d'accès aux données) pour les entités de l'application. En utilisant Spring Data JPA, on peut écrire moins de code pour accéder aux données et se concentrer sur les logiques métiers.
## [Spring Validation (Hibernate)](https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/validation.html)
Spring Validation est un sous-module de Spring qui fournit des fonctionnalités de validation pour les applications Java. Il permet de valider les données d'entrée d'une application en utilisant des annotations pour spécifier les règles de validation et les messages d'erreur associés. Il prend en charge la validation de groupe pour valider les données en fonction du contexte de l'application. Il intègre également avec les formulaires web pour fournir des messages d'erreur de validation pour les utilisateurs. Il facilite ainsi la validation des données d'entrée de manière efficace et centralisée.
## [H2 Database](https://www.geeksforgeeks.org/spring-boot-h2-database/)
H2 Database est un système de gestion de base de données relationnelle open source écrit en Java. Il prend en charge les normes SQL (Structured Query Language) pour gérer les données et peut être utilisé comme base de données embarquée ou en mode client/serveur. Il peut être utilisé pour des applications de développement, de test, de POC (preuve de concept) et même pour des applications de production à petite échelle. Il a une taille légère, une facilité d'utilisation et une rapidité d'exécution. Il prend en charge les fonctionnalités avancées telles que les vues, les procédures stockées, les triggers et les fonctions.
## [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/1.5.16.RELEASE/reference/html/using-boot-devtools.html)
Spring Boot DevTools est un ensemble d'outils de développement pour les applications Spring Boot. Il permet de faciliter le développement et le débogage en offrant des fonctionnalités telles que le rechargement automatique des ressources, la surveillance des modifications de fichiers, l'accès à des informations de débogage, etc. Il permet également de configurer les propriétés de l'application de manière dynamique sans avoir à redémarrer l'application. Il permet de gagner du temps lors du développement en évitant les temps de redémarrage longs et en facilitant la mise au point des applications.
## [Thymeleaf](https://www.thymeleaf.org/)
Thymeleaf est un moteur de template utilisé pour générer des vues dans les applications Spring Boot. Il permet de créer des modèles de pages web en utilisant des balises HTML standard et des expressions de données pour insérer des données dans les pages. Il prend en charge les fonctionnalités avancées telles que la gestion des erreurs, la sécurité, les formulaires, etc. Il intègre également bien avec Spring, en offrant des fonctionnalités pour les formulaires, les messages de validation, les liens, etc. Il offre une syntaxe propre, facile à utiliser, et une bonne performance en termes de temps d'exécution. Il facilite la création des vues pour les applications web, en se concentrant sur la présentation des données plutôt que sur la logique de l'application.
## Q&A
### Etape 13

1. Avec quelle partie du code avons-nous paramétré l'url d'appel /greeting ?

L'URL d'appel /greeting est paramétrée avec l'annotation @GetMapping("/greeting"). Cette annotation permet de mapper les requêtes HTTP GET à une méthode spécifique dans le contrôleur.

2. Avec quelle partie du code avons-nous choisi le fichier HTML à afficher ?

Le fichier HTML à afficher est choisi avec la méthode "return "greeting";" de la fonction greeting(). Cette méthode retourne une chaîne de caractères qui correspond au nom de la vue. Dans ce cas, cela correspond au nom du fichier "greeting.html" dans le répertoire des vues.

3. Comment envoyons-nous le nom à qui nous disons bonjour avec le second lien ?

Le nom à qui nous disons bonjour avec le second lien est envoyé en utilisant l'annotation @RequestParam et la méthode addAttribute() de l'objet Model. L'annotation @RequestParam permet de récupérer les paramètres de la requête HTTP, ici "nameGET", qui est utilisé pour définir le nom par défaut "World" si il n'est pas fourni. Le nom est ensuite ajouté à l'objet Model avec la méthode addAttribute() pour être utilisé dans la vue. Dans ce cas, il est utilisé dans la vue sous le nom "nomTemplate".

## Etape 17

1. Avez-vous remarqué une différence ? 

une table Adresse a ete ajoute.

## Etape 18

1. Expliquez l'apparition de la nouvelle table en vous aidant de vos cours sur Hibernate, et de la  dépendance Hibernate de Spring.

Lorsque Spring Boot est configuré pour utiliser Hibernate en tant que gestionnaire de persistance, Hibernate va automatiquement créer les tables de la base de données en fonction des entités déclarées dans l'application. Cela est possible grâce à la propriété "hibernate.hbm2ddl.auto" qui peut être configurée pour différentes valeurs telles que "create", "create-drop", "update" etc. Si cette propriété est définie sur "create" ou "create-drop", Hibernate va automatiquement créer les tables de la base de données en fonction des entités déclarées. Dans ce cas, on peut voir l'apparition de la nouvelle table qui est générée automatiquement à partir de l'entité déclarée.

## Etape 20

1.  Voyez-vous tout le contenu de data.sql ?

OUI

##  Etape 22

1. Pouvez-vous trouver à quoi sert l'annotation @Autowired du code précèdent sur internet ?

@Autowired est une annotation de Spring qui permet d'injecter automatiquement une dépendance dans un bean géré par Spring. Dans le code précédent, elle est utilisée pour injecter l'instance d'AddressRepository dans le champ addressRepository de la classe AddressController. Cela signifie que Spring va créer une instance d'AddressRepository et l'injecter dans le champ addressRepository de la classe AddressController, pour que cette dernière puisse utiliser les méthodes de AddressRepository pour récupérer les données de la base de données.

## Etape 30

1. telecharger les fichier bootstrap.css et bootstrap.js
2. les ajouters dans resources/static
3. inclure ces fichiers dans la section head des fichiers html


# TP4
## Etape 6
1. Faut-il une clé API pour appeler MeteoConcept ?
OUI
2. Quelle URL appeler ?
   """https://api.meteo-concept.com/api/forecast/nextHours?token=MON_Cle&latlng=lat,lng"""
3. Quelle méthode HTTP utiliser ?
GET
4. Comment passer les paramètres d'appels ?
en attribut
5. Où est l'information dont j'ai besoin dans la réponse :
   temp2m, wheter.
