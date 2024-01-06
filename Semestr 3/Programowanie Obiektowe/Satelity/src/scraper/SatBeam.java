package scraper;

public class SatBeam {

    private Long id;

    private String position;

    private String status;

    private String sateliteName;

    private int norad;

    private String cospar;

    private String satelliteModel;

    private String operator;

    private String launchSite;

    private int launchMass;

    private String launchDate;

    private String comments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSateliteName() {
        return sateliteName;
    }

    public void setSateliteName(String sateliteName) {
        this.sateliteName = sateliteName;
    }

    public int getNorad() {
        return norad;
    }

    public void setNorad(int norad) {
        this.norad = norad;
    }

    public String getCospar() {
        return cospar;
    }

    public void setCospar(String cospar) {
        this.cospar = cospar;
    }

    public String getSatelliteModel() {
        return satelliteModel;
    }

    public void setSatelliteModel(String satelliteModel) {
        this.satelliteModel = satelliteModel;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getLaunchSite() {
        return launchSite;
    }

    public void setLaunchSite(String launchSite) {
        this.launchSite = launchSite;
    }

    public int getLaunchMass() {
        return launchMass;
    }

    public void setLaunchMass(int launchMass) {
        this.launchMass = launchMass;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SatBeam{" + "\n" +
                "   - id=" + id + "\n" +
                "   - position='" + position + '\'' + "\n" +
                "   - status='" + status + '\'' + "\n" +
                "   - sateliteName='" + sateliteName + '\'' + "\n" +
                "   - norad=" + norad + "\n" +
                "   - cospar='" + cospar + '\'' + "\n" +
                "   - satelliteModel='" + satelliteModel + '\'' + "\n" +
                "   - operator='" + operator + '\'' + "\n" +
                "   - launchSite='" + launchSite + '\'' + "\n" +
                "   - launchMass=" + launchMass + "\n" +
                "   - launchDate='" + launchDate + '\'' + "\n" +
                "   - comments='" + comments + '\'' + '}' + "\n"  + "\n" ;
    }
}
