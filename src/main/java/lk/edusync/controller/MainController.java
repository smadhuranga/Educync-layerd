package lk.edusync.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView; // Corrected import for ImageView
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.event.ActionEvent; // Corrected import for ActionEvent

import java.io.IOException;

public class MainController {
    @FXML
    private Label Menu;

    @FXML
    private Label MenuBack;

    @FXML
    private JFXButton btnDashBoard;

    @FXML
    private JFXButton btnEmployee;

    @FXML
    private JFXButton btnFee;

    @FXML
    private JFXButton btnLogout;

    @FXML
    private JFXButton btnSchedule;

    @FXML
    private JFXButton btnStuAtten;

    @FXML
    private JFXButton btnStudent;

    @FXML
    private JFXButton btnrecord;

    @FXML
    private ImageView exit;

    @FXML
    private AnchorPane mainPain;

    @FXML
    private AnchorPane rooNode;

    @FXML
    private AnchorPane root;

    @FXML
    private AnchorPane slider;
    @FXML
    private AnchorPane slider2;

public String buttonOnAction(String location) throws IOException {
    String locate = "/view/"+location+".fxml";
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(locate));
    Pane registerPane = fxmlLoader.load();
    mainPain.getChildren().clear();
    mainPain.getChildren().add(registerPane);
    return locate;
}

    @FXML
    String btnDashboardOnAction(ActionEvent event) throws IOException {
       // setButtonActive(btnDashBoard);
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/dashboard_form.fxml"));
//        Pane registerPane = fxmlLoader.load();
//        mainPain.getChildren().clear();
//        mainPain.getChildren().add(registerPane);
        return buttonOnAction("dashboard_form");

    }

    @FXML
    String btnEmployeeOnAction(ActionEvent event) throws IOException {
       // setButtonActive(btnEmployee);
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/employee_form.fxml"));
//        Pane registerPane = fxmlLoader.load();
//        mainPain.getChildren().clear();
//        mainPain.getChildren().add(registerPane);

        return buttonOnAction("employee_form");

    }

    @FXML
    String btnFeeDetailsOnAction(ActionEvent event) throws IOException {
      //  setButtonActive(btnFee);
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/feeManage_form.fxml"));
//        Pane registerPane = fxmlLoader.load();
//        mainPain.getChildren().clear();
//        mainPain.getChildren().add(registerPane);

        return buttonOnAction("feeManage_form");

    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/login_form.fxml"));
        AnchorPane root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        LoginFormController loginController = loader.getController();
        Stage stage = new Stage();
        loginController.setStage(stage);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.initStyle(StageStyle.UNDECORATED);


        // Get the current stage and close it when the new stage is shown
        Stage currentStage = (Stage) rooNode.getScene().getWindow();
        stage.setOnShown( e -> currentStage.close());

        stage.show();

    }

    @FXML
    String btnRecordViewOnAction(ActionEvent event) throws IOException {
       // setButtonActive(btnrecord);
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/record&viewAttendence_form.fxml"));
//        Pane registerPane = fxmlLoader.load();
//        mainPain.getChildren().clear();
//        mainPain.getChildren().add(registerPane);

        return buttonOnAction("record&viewAttendence_form");

    }

    @FXML
    String btnScheduleOnAction(ActionEvent event) throws IOException {
       // setButtonActive(btnSchedule);
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/schedule_form.fxml"));
//        Pane registerPane = fxmlLoader.load();
//        mainPain.getChildren().clear();
//        mainPain.getChildren().add(registerPane);
        return buttonOnAction("schedule_form");

    }

    @FXML
    String btnStudentAttendenceOnAction(ActionEvent event) throws IOException {
       // setButtonActive(btnStuAtten);
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/attendence_form.fxml"));
//        Pane registerPane = fxmlLoader.load();
//        mainPain.getChildren().clear();
//        mainPain.getChildren().add(registerPane);

        return buttonOnAction("attendence_form");

    }

    @FXML
    String btnStudentOnAction(ActionEvent event) throws IOException {
       // setButtonActive(btnStudent);
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/student_form.fxml"));
//        Pane registerPane = fxmlLoader.load();
//        mainPain.getChildren().clear();
//        mainPain.getChildren().add(registerPane);

        return buttonOnAction("student_form");
    }
    public void initialize() throws IOException {


        exit.setOnMouseClicked(event -> {
            System.exit(0);
        });
        mainPain.setTranslateX(-180);


        Menu.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4)); // Reduced duration for better UX
            slide.setNode(mainPain);

            slide.setToX(0);
            slide.play();
            mainPain.setTranslateX(-180);

            slide.setOnFinished(e -> {
                Menu.setVisible(false);
                MenuBack.setVisible(true);
            });
        });


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/dashboard_form.fxml"));
        Pane registerPane = fxmlLoader.load();
          mainPain.getChildren().clear();
          mainPain.getChildren().add(registerPane);



        MenuBack.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4)); // Reduced duration for better UX
            slide.setNode(mainPain);

            slide.setToX(-180);
            slide.play();
            mainPain.setTranslateX(0);

            slide.setOnFinished(e -> {
                Menu.setVisible(true);
                MenuBack.setVisible(false);





            });
        });






    }






}

