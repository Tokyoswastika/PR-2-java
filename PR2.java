package com.example.p1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Text label1 = new Text("Визначення вiдстані мiж точками");
        label1.setLayoutX(50);
        label1.setLayoutY(50);

        Text label2 = new Text("Точка 1:");
        label2.setLayoutX(80);
        label2.setLayoutY(80);

        Text labelx1 = new Text("X:");
        labelx1.setLayoutX(65);
        labelx1.setLayoutY(105);

        TextField tfx1 = new TextField();
        tfx1.setLayoutX(80);
        tfx1.setLayoutY(90);

        Text labely1 = new Text("Y:");
        labely1.setLayoutX(65);
        labely1.setLayoutY(135);

        TextField tfy1 = new TextField();
        tfy1.setLayoutX(80);
        tfy1.setLayoutY(120);

        Text label3 = new Text("Точка 2:");
        label3.setLayoutX(80);
        label3.setLayoutY(180);

        Text labelx2 = new Text("X:");
        labelx2.setLayoutX(65);
        labelx2.setLayoutY(205);

        TextField tfx2 = new TextField();
        tfx2.setLayoutX(80);
        tfx2.setLayoutY(190);

        Text labely2 = new Text("Y:");
        labely2.setLayoutX(65);
        labely2.setLayoutY(235);

        TextField tfy2 = new TextField();
        tfy2.setLayoutX(80);
        tfy2.setLayoutY(220);


        Group groupinput = new Group(label2, label3, labelx1, labely1,tfx1, tfy1, labelx2, labely2,tfx2, tfy2);


        Button button = new Button("Обчислити");
        button.setLayoutX(80);
        button.setLayoutY(300);

        Text labelres = new Text("Результат:");
        labelres.setLayoutX(80);
        labelres.setLayoutY(340);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{
                    labelres.setText("");

                    if(tfx1.getText().isEmpty()) throw new Exception("Введіть точку х1!");
                    if(tfy1.getText().isEmpty()) throw new Exception("Введіть точку y1!");

                    if(tfx2.getText().isEmpty()) throw new Exception("Введіть точку x2!");
                    if(tfy2.getText().isEmpty()) throw new Exception("Введіть точку y2!");

                    int x1 = Integer.parseInt(tfx1.getText());
                    int y1 = Integer.parseInt(tfy1.getText());
                    int x2 = Integer.parseInt(tfx2.getText());
                    int y2 = Integer.parseInt(tfy2.getText());

                    double d = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));

                    if(Double.isNaN(d) || d == 0) throw new Exception("Точки введено некоректно");

                    labelres.setText(String.format("Результат: %.2f", d));

                }
                catch (NumberFormatException e)
                {
                    labelres.setText("Невірний тип даних!");
                }
                catch (Exception e)
                {
                    labelres.setText(e.getMessage());
                }
            }
        });

        Group group = new Group(label1, label2, groupinput, button, labelres);
        Scene scene = new Scene(group);
        stage.setScene(scene);
        stage.setTitle("Практична 2.");
        stage.setWidth(300);
        stage.setHeight(400);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}