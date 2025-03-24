package io.github.gleidsonmt.dashboardfx.presentation.presentations.controls;

import io.github.gleidsonmt.dashboardfx.model.Person;
import io.github.gleidsonmt.dashboardfx.presentation.internal.Tutorial;
import javafx.collections.FXCollections;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  17/03/2025
 */
@SuppressWarnings("unchecked")
public class TableViewPres extends StackPane {

    public TableViewPres() {
        getChildren().setAll(
                new Tutorial()
                        .h3("Table View")
                        .text("""
                                The TableView control is designed to visualize an unlimited number of rows of data, broken out into columns. 
                                A TableView is therefore very similar to the ListView control, with the addition of support for columns.
                                """)
                        .legend("javafx.scene.control.TableView")
                        .demo(createDemo())
                        .h5("Default")
                        .code("""
                                public class Person {
                                    private String firstName = null;
                                    private String lastName = null;
                                
                                    public Person() {
                                    }
                                
                                    public Person(String firstName, String lastName) {
                                        this.firstName = firstName;
                                        this.lastName = lastName;
                                    }
                                
                                    public String getFirstName() {
                                        return firstName;
                                    }
                                
                                    public void setFirstName(String firstName) {
                                        this.firstName = firstName;
                                    }
                                
                                    public String getLastName() {
                                        return lastName;
                                    }
                                
                                    public void setLastName(String lastName) {
                                        this.lastName = lastName;
                                    }
                                }
                                
                                TableView<Person> tableView = new TableView<>();
                                
                                TableColumn<Person, String> columnOne = new TableColumn<>("Column One");
                                columnOne.setCellValueFactory(new PropertyValueFactory<>("firstName"));
                                TableColumn<Person, String> columnTwo = new TableColumn<>("Column Two");
                                columnTwo.setCellValueFactory(new PropertyValueFactory<>("lastName"));
                                
                                tableView.getColumns().addAll(columnOne, columnTwo);
                        
                                tableView.setItems(FXCollections.observableArrayList(
                                       new Person("Gleidson", "Neves da Silveira"),
                                       new Person("Daniel", "Neves da Silveira")
                                ));
                                """)
                        .build().getRoot()
        );
    }

    private Node createDemo() {

        TableView<Person> tableView = new TableView<>();
        TableColumn<Person, String> columnOne = new TableColumn<>("Column One");
        columnOne.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        TableColumn<Person, String> columnTwo = new TableColumn<>("Column Two");
        columnTwo.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tableView.getColumns().addAll(columnOne, columnTwo);

        tableView.setItems(FXCollections.observableArrayList(
               new Person("Gleidson", "Neves da Silveira"),
               new Person("Daniel", "Neves da Silveira")
        ));
        return tableView;
    }
}

