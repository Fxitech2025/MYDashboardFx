package io.github.gleidsonmt.dashboardfx.model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  14/03/2025
 */
public class Activity extends Model {

    private ObjectProperty<Company> company = new SimpleObjectProperty<>();
    private ObjectProperty<Type> type = new SimpleObjectProperty<>();
    private ObjectProperty<Status> status = new SimpleObjectProperty<>();
    private ObservableList<User> users = FXCollections.observableArrayList();
    private ObjectProperty<BigDecimal> income = new SimpleObjectProperty<>();

    public Activity(Company company, Type type, Status status, BigDecimal income, User... users) {
        this.setType(type);
        this.company.set(company);
        this.status.set(status);
        this.income.set(income);


        this.users.addAll(Arrays.asList(users));
//        this.users.set(FXCollections.observableArrayList(users));
    }

    public BigDecimal getIncome() {
        return income.get();
    }

    public ObjectProperty<BigDecimal> incomeProperty() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income.set(income);
    }

    public ObservableList<User> getUsers() {
        return users;
    }

    public void setUsers(ObservableList<User> users) {
        this.users = users;
    }

    public Status getStatus() {
        return status.get();
    }

    public ObjectProperty<Status> statusProperty() {
        return status;
    }

    public void setStatus(Status status) {
        this.status.set(status);
    }

    public Company getCompany() {
        return company.get();
    }

    public ObjectProperty<Company> companyProperty() {
        return company;
    }

    public void setCompany(Company company) {
        this.company.set(company);
    }

    public Type getType() {
        return type.get();
    }

    public ObjectProperty<Type> typeProperty() {
        return type;
    }

    public void setType(Type type) {
        this.type.set(type);
    }
}
