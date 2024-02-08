
Développé en Janvier 2024

#Projet Java - Jeu Dungeon avec des fonctionnalités ajoutés

Ce projet Java consiste à ajouter des fonctionnalités à un jeu existant, initialement codé par Monsieur Tauvel.

Adaptation aux demandes : 

Nous avons adapté le code initial de Monsieur Tauvel pour appliquer les concepts appris lors des cours-vidéos. 
Ensuite, sur deux séances de TP, nous avons implémenté les nouvelles fonctionnalités suivantes :
•	Écran d'accueil permettant au joueur de démarrer une partie ou de quitter le jeu.
•	Timer pour limiter le temps de jeu du joueur.
•	Écran de Game Over s'affichant si le joueur n'atteint pas l'objectif dans le temps imparti.
•	Bonus : Affichage du taux de rafraîchissement (FramerateDisplay).

Pour implémenter ces fonctionnalités, nous avons travaillé en binôme, répartissant les tâches entre nous. 
De plus, nous avons utilisé ChatGPT comme un outil pour la création de nos codes respectifs. 
Il est important de noter que nous avons employé ChatGPT comme un support et non comme un membre actif de notre groupe. 
En effet, notre approche consistait d'abord à comprendre le code proposé par ChatGPT,
puis à le modifier pour l'intégrer dans notre propre code existant. 
ChatGPT ne fournissant pas de code exact, nous devions l'adapter, 
ce qui nécessitait une compréhension approfondie du code initial.

Apprentissage : 

Les premiers tps et les cours vidéo ont permis d’assimiler les bases de Java, 
notamment les concepts liés aux classes, aux constructeurs et aux méthodes. 
Les deux derniers TP nous ont permis de mettre en pratique directement ce que nous avions appris.
Cependant, nous aurions préféré avoir des cours en présentiel plutôt qu'en vidéo. 
La possibilité de poser des questions directement pendant le cours est plus simple et plus intuitive pour nous étudiant.
Néanmoins, nous avons apprécié que les cours vidéo soit structuré comme un projet de code (pokémon) plutôt que comme un cours purement théorique,
cela permet de mieux comprendre le langage informatique.

Problème avec le Timer: 

Nous avons rencontré un problème lors de l'utilisation du Timer pour régler les mouvements du personnage 
et celui pour l'horloge du temps écoulé. Le délai accordé à l'horloge était trop important, 
ce qui entraînait des mouvements brusques du personnage chaque seconde. 
Nous avons résolu cette difficulté en créant un deuxième Timer spécifiquement dédié à l'horloge, 
tout en laissant le premier Timer pour les mouvements du personnage. 
Bien qu'il aurait peut-être été possible de gérer les deux aspects avec un seul Timer, 
cette solution nous a permis de mieux comprendre les interactions entre les différentes fonctionnalités du jeu.

Conclusion : 

Ce projet nous a permis d’appliquer ce que nous avons apprit lors des différents cours/tp et d'apprendre des notions supplémentaires
aussi bien en java ( utlisation d'extentsion, la différence entre Jpanel et Jframe ) mais aussi bien sur l'application Intelij ( extension, création automatiquement de constructeur )
Enfin je remercie Monsieur Tauvel pour le temps et l'énergie qu'il nous a accordé durant les différentes séance de tp.



![](./img/TP2D-__Projet_Dongeon_Nassim_Hussain.png
)
