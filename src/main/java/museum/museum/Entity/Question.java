package museum.museum.Entity;

public class Question {
    private Long qId;

    private String kind;

    private Integer degree;

    private String content;

    private String contentImage;

    private String optionA;

    private String optionB;

    private String optionC;

    private String optionAImage;

    private String optionBImage;

    private String optionCImage;

    private String answer;

    private String analysis;

    public Long getqId() {
        return qId;
    }

    public void setqId(Long qId) {
        this.qId = qId;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind == null ? null : kind.trim();
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getContentImage() {
        return contentImage;
    }

    public void setContentImage(String contentImage) {
        this.contentImage = contentImage == null ? null : contentImage.trim();
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA == null ? null : optionA.trim();
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB == null ? null : optionB.trim();
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC == null ? null : optionC.trim();
    }

    public String getOptionAImage() {
        return optionAImage;
    }

    public void setOptionAImage(String optionAImage) {
        this.optionAImage = optionAImage == null ? null : optionAImage.trim();
    }

    public String getOptionBImage() {
        return optionBImage;
    }

    public void setOptionBImage(String optionBImage) {
        this.optionBImage = optionBImage == null ? null : optionBImage.trim();
    }

    public String getOptionCImage() {
        return optionCImage;
    }

    public void setOptionCImage(String optionCImage) {
        this.optionCImage = optionCImage == null ? null : optionCImage.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis == null ? null : analysis.trim();
    }
}