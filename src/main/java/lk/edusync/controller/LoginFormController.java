package lk.edusync.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.edusync.bo.BOFactory;
import lk.edusync.bo.custom.UserBO;
import lk.edusync.bo.custom.impl.UserBOImpl;
import lk.edusync.dao.custom.impl.UserDAOImpl;
import lk.edusync.db.DbConnection;
import lk.edusync.entity.UserEntity;
import lk.edusync.util.Regex;
import lk.edusync.util.TextField;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginFormController {

    @FXML
    private AnchorPane rootNode;


    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXTextField txtUserId;

    UserBO userDAO = (UserBO) BOFactory.getBOFactory().getBO(BOFactory.BOType.USER);


    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        String id = txtUserId.getText();
        String password = txtPassword.getText();
        try {
            checkCredential(id, password);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "OOPS! something went wrong").show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private void checkCredential(String id, String password) throws SQLException, IOException, ClassNotFoundException {
      //  String sql = "SELECT id, password FROM user WHERE id =?";
//        Connection connection = DbConnection.getInstance().getConnection();
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setObject(1,id);



        ArrayList<UserEntity> userEntities =  userDAO.checkCredentials(id);
        for (UserEntity userEntity : userEntities) {
            if (userEntity.getId().equals(id) && userEntity.getPassword().equals(password)) {
                navigateToDashbeard();
            }else {
                new Alert(Alert.AlertType.ERROR, "Passwords do not match").show();

            }
        }

    }

    private void navigateToDashbeard() throws IOException {

        AnchorPane rootNode = FXMLLoader.load(this.getClass().getResource("/view/main.fxml"));
        Scene scene = new Scene(rootNode);

        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Dashboard Form");



    }

   
    public void txtCusytomerIdOnKeyRelesed(KeyEvent keyEvent) {
        Regex.setTextColour(TextField.ID,txtUserId);

    }
    public boolean is() {
        if (!Regex.setTextColour(TextField.ID, txtUserId)) return true;
        return false;
    }


    public void setStage(Stage stage) {
    }
}