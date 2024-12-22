package org.qnuorg.mailspecification.type;


import java.io.Serializable;

public class PredictResult implements Serializable {
    private String result;
    private double spamPercent;
    private double hamPercent;

    public PredictResult(String result, double spamPercent, double hamPercent) {
        this.result = result;
        this.spamPercent = spamPercent;
        this.hamPercent = hamPercent;
    }

    public PredictResult() {
        this.result = "";
        this.spamPercent = 0;
        this.hamPercent = 0;
    }

    @Override
    public String toString(){
        return String.format("{\"result\":\"%s\",\"spamPercent\":\"%.2f\",\"hamPercent\":\"%2f\"}", this.result, this.spamPercent, this.hamPercent);
    }
}
