
/**
 * Write a description of class contacts here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class contacts
{
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String birthday;
    private String occupation;
    private String gender;
    public contacts(String firstName, String lastName, String phoneNumber, String birthday, String occupation, String gender){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.occupation = occupation;
        this.gender = gender;
    }
    public contacts(){
    firstName = "";
    lastName = "";
    phoneNumber = "";
    birthday = "";
    occupation = "";
    gender = "";
    }
    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String f){
        firstName = f;
    }
    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String f){
        lastName = f;
    }
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    public void setPhoneNumber(String f){
        phoneNumber = f;
    }
    public String getBirthday()
    {
        return birthday;
    }
    public void setBirthday(String f){
        birthday = f;
    }
    public String getOccupation()
    {
        return occupation;
    }
    public void setOccupation(String f){
        occupation = f;
    }
    public String getGender()
    {
        return gender;
    }
    public void setGender(String f){
        gender = f;
    }
}
