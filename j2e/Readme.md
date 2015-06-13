Choix d'implementatiton pour la partie EJB :

    Pour les sessions :
        Nous n'avons pas de sessions à proprement parler, afin que l'utilisateur n'aie pas à s'identifier à chaque fois
        qu'il souhaite réaliser une opération necessitant d'être authentifié, lorsqu'il se loggue ppour la première fois
        le client mémorise ses informations de connection et les envoie avec l'appel au serveur (en somme, toutes les
        operations necessitant d'être authentifié prennent un email et un mot de passe en argument).

    Pour les connections :
        Ne pas interroger le serveur .Net pour chaque connection. Lors d'une connection on stocke en base l'id
        de l'utilisateur ainsi que le timestamp de sa connection. si celui ci souhaite réaliser une autre opération
        necessitant d'être authentifier, on va d'abord verfier s'il a été actif pendant les 10 dernières minutes on ne
        renvoie pas de requête au server .Net, on se contente de mettre à jour le timestamp de sa dernière activité.
        De cette manière nous évitons d'avoir des appels à chaque action necessitant d'être authentifié et on laisse une
        marge de 10 minutes (temps par défaut, modifiable dans j2e/src/main/java/domain/Authentifier.java) jugée acceptable.
