package com.example;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
// import javafx.scene.shape.Path;
// import javafx.scene.shape.SVGPath;
// import javafx.scene.shape.MoveTo;
// import javafx.scene.shape.LineTo;
import javafx.scene.paint.Color;
import javafx.scene.transform.Translate;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Shear;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage){

        Rectangle rectangle = new Rectangle();
        rectangle.setX(200);
        rectangle.setY(100);
        rectangle.setWidth(200);
        rectangle.setHeight(100);
        rectangle.setFill(Color.RED);

        Translate translate = new Translate();
        translate.setX(-50);
        translate.setY(0);
        translate.setZ(0);

        Rotate rotate = new Rotate();
        rotate.setAngle(45);
        rotate.setPivotX(300);
        rotate.setPivotY(150);

        Scale scale = new Scale();
        scale.setX(1.5);
        scale.setY(1.5);
        scale.setPivotX(300);
        scale.setPivotY(150);    
        
        Shear shear = new Shear();
        shear.setX(0.5);
        shear.setY(0);
        shear.setPivotX(300);
        shear.setPivotY(150);


        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(new Double[]{        
         200.0, 50.0, 
         400.0, 50.0, 
         450.0, 150.0,          
      });

      KeyValue keyvalue = new KeyValue(triangle.translateXProperty(), 200);
      KeyFrame keyframe = new KeyFrame(Duration.seconds(6), keyvalue);
      Timeline timeline = new Timeline(keyframe);

        

        Button translateBtn = new Button("Translate");
        translateBtn.setLayoutX(320);
        translateBtn.setLayoutY(240);
        translateBtn.setOnAction(e -> {
            rectangle.getTransforms().add(translate);
        });

        Button resetBtn = new Button("Reset");
        resetBtn.setLayoutX(320);
        resetBtn.setLayoutY(280);
        resetBtn.setOnAction(e -> {
            rectangle.getTransforms().clear();

        });
        
        Button rotateBtn = new Button("Rotate");
        rotateBtn.setLayoutX(320);
        rotateBtn.setLayoutY(320);

        rotateBtn.setOnAction(e -> {
            rectangle.getTransforms().add(rotate);
        });

        Button scaleBtn = new Button("Scale");
        scaleBtn.setLayoutX(320);
        scaleBtn.setLayoutY(360);
        scaleBtn.setOnAction(e -> {
            rectangle.getTransforms().add(scale);
        });

        Button shearBtn = new Button("Shear");
        shearBtn.setLayoutX(320);
        shearBtn.setLayoutY(400);
        shearBtn.setOnAction(e -> {
            rectangle.getTransforms().add(shear);
        });

        Button animBtn = new Button("Animate");
        animBtn.setLayoutX(320);
        animBtn.setLayoutY(440);
        animBtn.setOnAction(e ->{
            timeline.play();
        });

        Button animResetBtn = new Button("Reset Animation");
        animResetBtn.setLayoutX(320);
        animResetBtn.setLayoutY(480);
        animResetBtn.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #ffffff");
        animResetBtn.setOnAction(e -> {
            timeline.stop();
            triangle.setScaleX(1);
            triangle.setScaleY(1);
          
        });

        // Path pentagon = new Path();
        // MoveTo point1 = new MoveTo(100, 100);
        // LineTo point2 = new LineTo(200, 150);
        // LineTo point3 = new LineTo(150, 250);
        // LineTo point4 = new LineTo(50, 250);
        // LineTo point5 = new LineTo(0, 150);
        // LineTo point6 = new LineTo(100, 100); // Closing the pentagon

        // pentagon.setStrokeWidth(5);
        // pentagon.setStroke(Color.BLUEVIOLET);
        // pentagon.setFill(Color.VIOLET);
        // pentagon.getElements().addAll(point1, point2, point3, point4, point5, point6);

        // SVGPath heart = new SVGPath();
        // String heartPath = "M 10,30 A 20,20 0,0,1 50,30 A 20,20 0,0,1 90,30 Q 90,60 50,90 Q 10,60 10,30 Z";
        // heart.setContent(heartPath);
        // heart.setFill(Color.RED);


        Pane root = new Pane ();
        // root.getChildren().add(rectangle);
        // root.getChildren().add(translateBtn);
        root.getChildren().add(resetBtn);
        // root.getChildren().add(rotateBtn);
        // root.getChildren().add(scaleBtn);
        // root.getChildren().add(shearBtn);
        root.getChildren().add(triangle);
        root.getChildren().add(animBtn);
        root.getChildren().add(animResetBtn);

        // root.getChildren().add(pentagon);
        // root.getChildren().add(heart);
        scene = new Scene(root, 640, 480);
        stage.setTitle("Work with 2D Shapes");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}