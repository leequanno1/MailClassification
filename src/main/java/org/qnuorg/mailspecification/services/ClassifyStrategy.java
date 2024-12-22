package org.qnuorg.mailspecification.services;

import org.qnuorg.mailspecification.type.PredictResult;

public interface ClassifyStrategy {
    public PredictResult classifyEmail(String emailContent);
}
