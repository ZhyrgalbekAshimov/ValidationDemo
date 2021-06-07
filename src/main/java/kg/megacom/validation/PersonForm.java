package kg.megacom.validation;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Date;

public class PersonForm {
    @NotNull(message = "Поле не может быть пустым")
    @Size(min=2, max=30, message = "Имя должно содержать не менее 2 и не более 30 символов")
    private String name;

    @NotNull(message = "Имя не может быть пустым")
    @Min(value = 18, message = "Должен быть минимум 18 и более")
    private Integer age;

    @NotEmpty(message = "Email не может быть пустым")
    @Email(message = "Введите валидный email")
    private String email;

    @Min(value = 1, message = "Максимум 5 и более 1")
    @Max(value = 5, message = "Максимум 5 и более 1")
    @Positive(message = "Должен быть положительным числом")
    private int experience;

    @Past
    private Date carierStart;

    @Future
    private Date endContract;

    @PastOrPresent
    private Date birthday;

    private Boolean notrobot;
    @AssertTrue (message = "Поставьте галочку чтобы доказать что вы не робот")
    public Boolean getNotrobot() {
        return notrobot;
    }

    @Size(min = 2, max = 4, message = "Выберите минимум 2 города")
    private ArrayList<Boolean> arrayList;


    @NotBlank(message = "Поле не может быть пустым")
    @Pattern(regexp = "^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$", message = "Введите ввалидный IP адрес")
    private String ipAddress;



    public ArrayList<Boolean> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Boolean> arrayList) {
        this.arrayList = arrayList;
    }

    public void setNotrobot(Boolean notrobot) {
        this.notrobot = notrobot;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCarierStart() {
        return carierStart;
    }

    public void setCarierStart(Date carierStart) {
        this.carierStart = carierStart;
    }

    public Date getEndContract() {
        return endContract;
    }

    public void setEndContract(Date endContract) {
        this.endContract = endContract;
    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "Person(Name: " + this.name + ", Age: " + this.age + ")";
    }
}
