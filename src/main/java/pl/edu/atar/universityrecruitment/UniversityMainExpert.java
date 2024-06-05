package pl.edu.atar.universityrecruitment;

import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UniversityMainExpert {

    private static final Logger LOGGER = LoggerFactory.getLogger(UniversityMainExpert.class);

    public static void main(String[] args) {

        // Tworzenie kolekcji faktów zawierającej 1 fakt o wskazanym ID = 1..7
		int candidate = 7;
        List<UniversityCandidate> uc = new Dataset().getUniversityCandidatesWithSubjects().subList(candidate - 1, candidate);

        // Tworzenie kolekcji faktów zawierającej wszystkie fakty
        // List<UniversityCandidate> uc = new Dataset().getUniversityCandidatesWithSubjects();

        for (UniversityCandidate fact : uc) {
            KieServices kService = KieServices.Factory.get();
            KieContainer kContainer = kService.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules-expert");

            LOGGER.info("Knowledge base created.\n\nREASONING AND ANALYSIS OF FACT NUMBER {}\n", fact.getId());

	        // Logowanie zebranych informacji
            kService.getLoggers().newConsoleLogger(kSession);
            kService.getLoggers().newFileLogger(kSession, "./logs/reasoning_expert_fact_" + fact.getId());

            LOGGER.info("Adding fact(s) into WORKING MEMORY.");
            LOGGER.info("Number of facts in WORKING MEMORY (Entry Point): {}", kSession.getFactCount());
            kSession.insert(fact);
            LOGGER.info("Number of facts in WORKING MEMORY (Entry Point): {}", kSession.getFactCount());
            LOGGER.info("Fact(s) inserted into WORKING MEMORY.\n");

            // Wskazanie do przetwarzania zbiorów reguł kwalifikacyjnych "exam_result_calculation"
            kSession.getAgenda().getAgendaGroup("exam_result_calculation").setFocus();



            LOGGER.info("... REASONING STARTED ...");
            kSession.fireAllRules();
            LOGGER.info("... REASONING ENDED ...\n");

            LOGGER.info("Checking fact(s) in WORKING MEMORY.");
            LOGGER.info("Number of facts in WORKING MEMORY (Exit Point): {}\n", kSession.getFactCount());

            LOGGER.info(fact.getCandidateInformationLogger());

            // Usunięcie sesji oraz zwolnienie pamięci
            kSession.dispose();
        }
    }
}