# JAVAEE
# TP 1

## CAHIER DES CHARGES

### DESCRIPTION DES BESOINS

Le logiciel doit permettre la saisie et la réservation de ressources internes à l'entreprise comme par exemple des
salles de réunion, des vidéoprojecteurs, des voitures de fonctions, ...

Il est nécessaire de connaître l'identité de la personne ayant la gestion de la ressource (le responsable de la
ressource) ainsi que de celle l'ayant réservé (l’utilisateur de la ressource).

De plus, il faut pouvoir afficher le planning des réservations en cours ou à venir aussi bien pour une seule
ressource que pour l'ensemble des ressources d'un type particulier (salle, vidéo projecteur, voiture, ...).

On doit aussi pouvoir visualiser l'historique des réservations pour une ressource ainsi que l'historique des
réservations qu'a réalisé une personne.

### CONTRAINTES FONCTIONNELLES

- Une ressource est réservée pour un ou plusieurs jours, les heures et les demi-journées ne sont pas prises en
compte.
- Une personne peut réserver autant que ressources qu'elle veut.
- Une ressource est gérée par une et une seule personne.
- Une ressource doit obligatoirement être gérée par une personne.
- Certains types de ressources peuvent avoir une capacité (comme par exemple une salle de réunion).
- Les ressources ayant une capacité peuvent (mais ce n’est pas obligatoire) être partageables.
- Une ressource ne peut être réservée plus d'une seule fois à une même date sauf si elle est partageable.
- Une réservation d'une ressource partageable doit indiquer le nombre de personne liées à cette réservation.
- Certaines personnes pourront avoir un statut gestionnaire qui leur permettra de gérer les types de ressources, les
ressources et les personnes


## DEVELOPPEMENT

### OUTILS

Récupérez et installez, dans l’ordre :

- Un JDK en version 11 : OpenJDK 11, Amazon Coretto 11, ... (disponible sur Teams, notez qu’il est
    **nécessaire** que les commandes java et javac pour ces versions soient dans la variable d’environnement
    PATH)
- Gradle 7.2 (disponible sur Teams, notez qu’il est **nécessaire** que la commande gradle soit dans la
    variable d’environnement PATH)
- Git (notez qu’il est **nécessaire** que la commande git soit dans la variable d’environnement PATH)
- IntelliJ IDEA Ultimate (vous pouvez avoir une clé en vous inscrivant sur le site de Jetbrains avec votre
    adresse e-mail @esimed.fr)
- Payara Server ( obligatoirement celui fournis dans Teams)
- Un SGBDR (PostgreSQL, MySQL, ...). Vous pouvez par exemple utiliser la machine virtuelle « Cours
    SQL ».

### BASE DE DONNEES

Créez un utilisateur et une base de données (encodée en UTF-8 de préférence). Si vous utilisez la machine
virtuelle « Cours SQL » tout est déjà prêt.

Ouvrez une invite de commande, déplacez-vous dans le répertoire où se trouve le répertoire payara5 et exécutez
la commande suivante pour démarrer manuellement le serveur d’applications :

```
./payara5/bin/asadmin start-domain
```
Une fois démarré connectez-vous à la console d’administration [http://localhost:](http://localhost:)

Ajoutez dans Payara un pool de connexion à la base de données :

- Allez dans ‘Resources’ -> ‘JDBC’ -> ‘JDBC Connexion Pools’ - > ‘New’
- Configurez les paramètres suivants sur la première page : ‘Resource Type’ -> ‘DataSource’, ‘Database
    Driver Vendor’ - > ‘PostgreSQL’ (ou autre suivant votre SGBDR)
- Si vous utilisez PostgreSQL configurez les attributs suivants sur la deuxième page (supprimez tous les autres
    attributs) :
       o User/rolename, password = les informations de connexion de l’utilisateur que vous avez créé
       o serverName = localhost
       o databaseName = la nom de la base de données que vous avez créé
       o portNumber = 5432
- Si vous utilisez un autre SGBDR consulter la documentation du connecteur correspondant.
- Une fois sauvegardé éditez à nouveau de pool de connexion et tester la connexion à l’aide du bouton « Ping ».
    Si vous n’avez pas le message « Ping Succeeded » vérifiez vos paramètres.

Ajoutez dans Payara une ressource JDBC nommée tpjavaee liée à ce pool de connexion (‘Resources’ -> ‘JDBC’
-> ‘JDBC Resources’ - > ‘New’).


Arrêter manuellement le serveur d’applications :

```
./payara5/bin/asadmin stop-domain
```
### PROJET DE DEPART

Récupérez le projet type pour les TP à l’aide de git :

```
git clone https://github.com/HenriMichelonEsimed/template-tpjavaee.git
```
Renommez le répertoire puis ouvrez le projet dans IntelliJ.

Dans le fichier build.gradle modifiez la ligne suivante en fonction du répertoire où vous avez installé Payara
server :

```
ext.setProperty('payaraHome', " le repertoire où se trouve Payara ");
```
Vous pouvez à partir de ce moment démarrer le serveur d’applications et votre application depuis IntelliJ :

- Allez dans « Run » -> « Run »
- Cliquez sur « + » -> « Glassfish Server » -> « Local »
- Cliquez sur « Configure » pour préciser l’emplacement de Payara server
- Sélectionnez le domaine « domain1 » dans « Server Domain »
- Cliquez sur « Fix » en bas à droite
- Sélectionnez « _votreprojet_ .war (exploded) » -> Apply
- Revenez dans l’onglet « Server » puis sélectionnez « Redeploy » pour l’option « on ‘Update’ action »

Vous pouvez aussi ajouter une connexion à votre base de données pour pouvoir la manipuler manuellement (onglet
‘Database’ sur la droite de l’écran).

Note : si vous ne modifiez que les fichiers HTML, CSS ou JS vous pouvez utiliser l’option « Update Resources »
au lieu de « Redeploy » lorsque vous exécutez/débuggez le projet. Cela évite de redéployer le projet (seules les
ressources HTML, CSS ou JS sont copiées vers le répertoire de build).


### CONTROLE DE VERSION

Une fois votre projet démarré au moins une fois supprimez le répertoire .git du projet et créez un repository sur
github et importez-y vous projet puis partagez-le avec le professeur.

### TIERS METIER ET SERVICES

Ajoutez à votre projet les tiers métier et service pour la gestion des types de ressources réservables (et uniquement
cela dans un premier temps) :

- Une classe métier ResourceType (annotée @Entity)
- La classe « DAO » correspondante (annotée @ApplicationScoped)
- La classe « service » correspondante (annotée @ApplicationScoped)
- Modifiez la classe « Seeder » (annotée @Singleton et @Startup)

Exécutez votre projet et vérifier dans la base de données la création de la table RESOURCETYPE et son remplissage
par le seeder.

Si cela fonctionne faite de même pour les entités suivantes : Person et Resource (comme il existe déjà une classe
User avec les informations de sécurité des utilisateurs faites une association entre Person et User).

### GESTION DES TYPES DE RESSOURCES

Vous allez implémenter un modèle MVC « classique » avec une classe contrôleur pour chaque vue et dialogue.

Implémentez la gestion des types de ressources réservables sur la forme suivante : un **tableau simple** (non paginé)
avec la liste des types de ressources (pour chaque ligne : nom du type, avec capacité ou non, nombre de ressources
associées, un bouton pour supprimer actif uniquement si le nombre de ressources == 0). Ce tableau sera géré par
une classe contrôleur annotée @ViewScoped et @Named.

Un clic sur un nom de type de ressource permet d’affiche **une boite de dialogue** pour modifier le type de ressources.
La même boite de dialogue sera utilisée pour la fonctionnalité « ajouter ». Cette boite de dialogue sera gérée par une
classe contrôleur annotée @ViewScoped et @Named.

La suppression ne doit se faire qu’après confirmation.

Les vues et messages doivent être internationalisés (pas de texte brut dans les vues et dans les contrôleurs).

Utiliser la documentation de Primefaces pour les composants : https://www.primefaces.org/showcase/index.xhtml


### GESTION DES RESSOURCES

Implémentez la partie gestion des ressources réservables. Cette fois-ci avec un tableau paginé (et un seeder qui
génère une grande quantité de ressources aléatoires). On parle ici d’une pagination réelle, c’est-à-dire appliquée à
toutes les couches, de la DAO à la vue (et pas seulement au niveau de la vue). On ne doit lire dans la base de données
que les données de la page courante. Implémentez aussi un filtre sur le nom des ressources.

Pour l’édition, la création et la suppression utilisez cette-fois ci un formulaire sur une vue séparée à la place d’une
boite de dialogue.

Bien entendu seules les gestionnaires pourront supprimer les ressources qui leur appartiennent et uniquement si
celles-ci n’ont pas de réservations en cours. Si une ressource a une réservation passée celle-ci sera désactivée (non
visible dans le tableau et non réservable) et non supprimée.

### RESERVATIONS ET CALENDRIER

Pour les réservations utilisez un calendrier (composant « schedule » de Primefaces) pour l’affichage au lieu d’un
tableau et des boites de dialogue pour l’ajout/édition/suppression. Ce calendrier sera en « lazy loading » c’est-à-dire
que l’on ne lira dans la base de données que les réservations actuellement affichées sur le calendrier (un peu comme
la pagination, mais avec une plage de dates).

### SECURITE

Ajoutez un « realm » de sécurité dans les paramètres de Payara (« Configurations » -> « server config » ->
« Security » -> « Realms »). Utilisez la copie d’écran de configuration fournie (et adaptez les paramètres si vous
avez modifié quelque chose dans les entités User et Group).

Modifiez le descripteur de déploiement (fichier web/WEB-ENF/web.xml) pour ajouter la configuration de la
sécurité :

- Configuration de l’authentification
- Contraintes de sécurité (les ressources comme les css ou les images doivent être accessible sans être
    connecté).
