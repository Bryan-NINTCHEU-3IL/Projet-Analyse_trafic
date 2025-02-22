/**
 * Nous allons utiliser Wireshark pour capturer les trames Ethernet locales et distantes
 * 
 */

/**
 * Commençons par lancer minet sur l'invite de commande 
 * cela va télécharger un fichier topo.py suivant le chemin indiquer
 */
[analyst@secOps ~]$ sudo ./lab.support.files/scripts/cyberops_topo.py 

/** Demarrons les fenetres de terminal sur 'hote H3' */
[sudo] password for analyst: cyberops

mininet> xterm H3
/** Pour voir la configuration de l'adresse MAC enregistrée ainsi que son adresse IP */
ifconfig
/*l'affichage de la parserelle par défaut*/
[root@secOps~]# netstat -r

/**
 * Avons de commencer le trafic le trafic , vidons le cache avec la commande suivant
 */
[root@secOps analyst]# arp -n 

/*Ouvrons alors Wireshark et lançons une capture de paquets*/
[root@secOps analyst]# wireshark-gtk &

/**
 * Voir la suite dans le dossier Screenchots
 */

/**
 * Faisons une requete ping H1 depuis H3
 */
[root@secOps analyst]# ping -c 5 10.0.0.1

/**Application du filtre icmp au trafic
 * voir réseultat dans Screenshots
 */
/**
 * Cliquons sur Internet Control Message protocol( pour avoir plus d'information): voir screenshots
 */
On remarque le ping va de l'hote H3: 10.0.0.1 vers l'hote H1:10.0.0.13
Un autre ping vers 172.16.0.40 /*solution dans screenshots*/

/*Demanrrons deux autres interfaces, H1 et H4*/
mininet> xterm H1 
mininet> xterm H4 
/*Demarrage du serveur web sur H4*/

[root@secOps analyst]# /home/analyst/lab.support.files/scripts/reg_server_start.sh. 
/*Démarreons  le navigateur sur H1. Ce processus peut prendre quelques instants. */
[root@secOps analyst]# firefox & 

/**
 * démarrons une session tcpdump sur le terminal Node: H1 et 
envoyons la sortie vers un fichier appelé capture.pcap. L'option -v affiche la progression du 
processus. Le processus de capture s'arrête après la capture de 50 paquets, car il est configuré 
avec l'option -c 50.
 */
[root@secOps analyst]# tcpdump -i H1-eth0 -v -c 50 -w /home/analyst/capture.pcap 

/*Analysons maintenant le trafic sur l'hote H1 voir sreenschots*/
[root@secOps analyst]# wireshark-gtk & 

/*Examinons les informations au sein des paquets, y compris les adresses IP, les numéros 
de port TCP et les indicateurs de contrôle TCP. */

[analyst@secOps ~]# man tcpdump
/*résultat dans screenshots*/
/*pour termier l'analys nous allons taper quit dans le terminal */
mininet> quit 