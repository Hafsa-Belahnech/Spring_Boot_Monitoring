package ma.fstg.service;

import io.micrometer.core.instrument.Metrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private static final Logger logger = LoggerFactory.getLogger(ProjectService.class);

    public String processData() {
        //On incrémente un compteur personnalisé nommé "custom.process.count"
        Metrics.counter("custom.process.count").increment();

        logger.info("Démarrage du traitement des données en cours ...");
        try {
            Thread.sleep(500); // On simule un traitement
        } catch (InterruptedException e) {
            logger.error("Erreur dans le traitement !", e);
        }
        logger.info("Traitement terminé avec succès!!");
        return "Traitement effectué!!";
    }
}


//logger.info(...) : Ça écrit du texte dans le fichier application.log
//Metrics.counter(...).increment() : Ça crée une statistique chiffrée. C'est pour GRAFANA (pour dessiner une courbe qui monte chaque fois que le traitement est lancé)