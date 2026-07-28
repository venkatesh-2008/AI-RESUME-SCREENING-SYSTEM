public class ScreeningResult {

    private double score;
    private String recommendation;
    private String remarks;

    public ScreeningResult() {
    }

    public ScreeningResult(double score, String recommendation, String remarks) {
        this.score = score;
        this.recommendation = recommendation;
        this.remarks = remarks;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}