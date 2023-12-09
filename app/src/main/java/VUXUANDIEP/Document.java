package VUXUANDIEP;

public class Document {
    private String subjectid;
    private String subject;
    private String url;
    private String  describe;

    public Document(String subjectid, String subject, String url, String describe) {
        this.subjectid = subjectid;
        this.subject = subject;
        this.url = url;
        this.describe = describe;
    }

    public String getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(String subjectid) {
        this.subjectid = subjectid;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
