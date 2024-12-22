package org.qnuorg.mailspecification.services;

import org.qnuorg.mailspecification.type.PredictResult;
import org.jpl7.Query;
import org.jpl7.Term;

public class TrigramClassify implements ClassifyStrategy {
    @Override
    public PredictResult classifyEmail(String emailContent) {
        String prologFilePath = "src/main/resources/email_trigram_classifier.pl";

        // Load Prolog file
        Query query = new Query("consult('" + prologFilePath + "')");
        if (!query.hasSolution()) {
            throw new RuntimeException("Failed to load Prolog file");
        }

        // Call classify_email/4
        String prologQuery = String.format(
                "classify_email('%s', Result, SpamPercent, HamPercent).",
                emailContent.replace("'", "\\'")
        );
        query = new Query(prologQuery);

        if (query.hasSolution()) {
            Term resultTerm = query.oneSolution().get("Result");
            Term spamPercentTerm = query.oneSolution().get("SpamPercent");
            Term hamPercentTerm = query.oneSolution().get("HamPercent");

            String result = resultTerm.toString();
            double spamPercent = spamPercentTerm.doubleValue();
            double hamPercent = hamPercentTerm.doubleValue();

            return new PredictResult(result, spamPercent, hamPercent);
        } else {
            return new PredictResult();
        }
    }
}
