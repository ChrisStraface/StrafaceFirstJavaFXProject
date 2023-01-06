import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.time.LocalDate;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Layouts:
        primaryStage.setTitle("Straface's First JavaFX App");
        Label label = new Label("Hello World, JavaFX!");
        label.setFont(new Font("Times New Roman", 14));
        Label label2 = new Label("Type into the text box!");
        Label label3 = new Label("I read the date!");

        //Controls:
        Accordion accordion = new Accordion();
        TitledPane pane1 = new TitledPane("Games" , new Label("Add games"));
        TitledPane pane2 = new TitledPane("Apps" , new Label("Add apps"));
        TitledPane pane3 = new TitledPane("Music" , new Label("Add music"));
        accordion.getPanes().add(pane1);
        accordion.getPanes().add(pane2);
        accordion.getPanes().add(pane3);

        ChoiceBox choiceBox = new ChoiceBox();
        choiceBox.getItems().add("This is option 1");
        choiceBox.getItems().add("This is option 2");
        choiceBox.getItems().add("This is option 3");

        TextField comboField = new TextField();
        ComboBox comboBox = new ComboBox();
        comboBox.getItems().add("Item 1");
        comboBox.getItems().add("Item 2");
        comboBox.getItems().add("Item 3");
        comboBox.setOnAction(actionEvent ->  {
            int selectedIndex = comboBox.getSelectionModel().getSelectedIndex();
            Object selectedItem = comboBox.getSelectionModel().getSelectedItem();
            comboField.setText("Your selected index is " + selectedIndex + ", your chosen item is " + selectedItem);
        });

       // comboBox.setEditable(true);

        RadioButton radioButton1 = new RadioButton("Click me!");
        radioButton1.setOnAction(actionEvent ->  {
            radioButton1.setText("Good job!");
        });

        Button pressMe = new Button("Press me!");
        pressMe.setOnAction(actionEvent ->  {
            label2.setText("You hit the button!");
        });

        DatePicker datePicker = new DatePicker();
        Button dateButton = new Button("Read the date");
        dateButton.setOnAction(actionEvent ->{
            LocalDate value = datePicker.getValue();
            label3.setText("The date is " + value);
        });

        Slider slider = new Slider(0, 100, 0);
        slider.setMajorTickUnit(8.0);
        slider.setMinorTickCount(3);
        Button tickButton = new Button("Add tick marks to the slider!");
        tickButton.setOnAction(actionEvent ->{
        slider.setShowTickMarks(true);
        });

        ProgressBar progressBar = new ProgressBar(0);
        progressBar.setProgress(0.3);

        TextField textField = new TextField();

        VBox vBox = new VBox(10, slider, tickButton, label, label2, datePicker, dateButton, label3, comboBox, comboField);
        VBox vBox2 = new VBox(10, radioButton1, choiceBox);
        HBox hBox = new HBox(15,accordion, textField, vBox, pressMe, vBox2);

        //Scene:
        Scene scene = new Scene(hBox,800, 650);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}