package org.qnuorg.mailspecification.controller;

import org.qnuorg.mailspecification.services.BigramClassify;
import org.qnuorg.mailspecification.services.TrigramClassify;
import org.qnuorg.mailspecification.services.WordClassify;
import org.springframework.web.bind.annotation.*;

@RestController
public class MailClassifyController {
    private final WordClassify wordClassify = new WordClassify();
    private final BigramClassify bigramClassify = new BigramClassify();
    private final TrigramClassify trigramClassify = new TrigramClassify();


    @GetMapping(value = "/predict/word", produces = "application/json")
    public String getPredictByWord(@RequestParam String mailContent) {
        return wordClassify.classifyEmail(mailContent).toString();
    }

    @GetMapping(value = "/predict/bigram", produces = "application/json")
    public String getPredictByBigram(@RequestParam String mailContent) {
        return bigramClassify.classifyEmail(mailContent).toString();

    }

    @GetMapping(value = "/predict/trigram", produces = "application/json")
    public String  getPredictByTrigram(@RequestParam String mailContent) {
        return trigramClassify.classifyEmail(mailContent).toString();
    }

    @GetMapping("/predict/test")
    public String test() {
        return "Bala";
    }
}

