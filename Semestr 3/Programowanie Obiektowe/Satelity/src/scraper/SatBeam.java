package scraper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class SatBeam {

//    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern ( "dd-MMM-yyyy" , Locale.ENGLISH );
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

    public WebsiteData.Satellite toSatellite() throws ParseException {

        // TODO: Can't translate position to 'actual position' and 'date' in WebsiteData because of type conflict


        WebsiteData.Satellite satellite = new WebsiteData.Satellite();

        satellite.setNorad(this.norad);
        ArrayList<String> names = new ArrayList<String>();
        names.add(this.sateliteName);
        satellite.setNames(names);
        satellite.setOperator(this.operator);
        satellite.setStatus(this.status);
//        satellite.setLaunchDate((Date) formatter.parse(this.launchDate));
        satellite.setLaunchSite(this.launchSite);
        satellite.setLaunchMass(this.launchMass);
        satellite.setSatelliteModel(this.satelliteModel);

        return satellite;
    }

    public WebsiteData.Satellite updateSatelliteBySatBeam(WebsiteData.Satellite websiteDataSat) throws ParseException {

        // TODO: Can't translate position to 'actual position' and 'date' in WebsiteData because of type conflict

        WebsiteData.Satellite satellite = websiteDataSat;

        satellite.setNorad(this.norad);
        ArrayList<String> names = new ArrayList<String>();
        names.add(this.sateliteName);
        satellite.setNames(names);
        satellite.setOperator(this.operator);
        satellite.setStatus(this.status);
//        satellite.setLaunchDate((Date) formatter.parse(this.launchDate));
        satellite.setLaunchSite(this.launchSite);
        satellite.setLaunchMass(this.launchMass);
        satellite.setSatelliteModel(this.satelliteModel);

        return satellite;
    }



}
