package lk.edusync.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.edusync.bo.BOFactory;
import lk.edusync.bo.custom.AttendenceBO;
import lk.edusync.dto.AttendenceDTO;
import lk.edusync.entity.AttendenceEntity;


import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AttendenceFormController {
    @FXML
    private TableColumn<?, ?> coldate;

    @FXML
    private TableColumn<?, ?> colid;

    @FXML
    private TableColumn<?, ?> colnfc;

    @FXML
    private TableColumn<?, ?> colstId;

    @FXML
    private TableColumn<?, ?> coltime;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<AttendenceDTO> tblAttendence;

    @FXML
    private JFXTextField txtdate;



    @FXML
    private JFXTextField txtnfc;

    @FXML
    private JFXTextField txtstid;


    @FXML
    private JFXTextField txttime;

        AttendenceBO attendenceBO = (AttendenceBO) BOFactory.getBOFactory().getBO(BOFactory.BOType.ATTENDENCE);
    @FXML
    void txtSearchOnAction1(ActionEvent event) {
        String id1 = txtnfc.getText();


        try {
            ArrayList<AttendenceEntity> attendences =attendenceBO.searchNfc(id1);
            for (AttendenceEntity attendence : attendences) {
                txtdate.setText(attendence.getDate());
                txttime.setText(attendence.getTime());
                txtnfc.setText(attendence.getNfcNumber());
                txtstid.setText(attendence.getSid());



            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void txtSearchOnAction(ActionEvent actionEvent) {
        String id1 = txtstid.getText();



        try {

            ArrayList<AttendenceEntity> attendences =attendenceBO.search(id1);
            for (AttendenceEntity attendence : attendences) {
                txtdate.setText(attendence.getDate());
                txttime.setText(attendence.getTime());
                txtnfc.setText(attendence.getNfcNumber());
                txtstid.setText(attendence.getSid());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String id = this.txtstid.getText();


        try {
            boolean isDeleted = attendenceBO.delete(id);
            if (isDeleted) {
                initialize();
                new Alert(Alert.AlertType.CONFIRMATION, "Attendence deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String nfc = this.txtnfc.getText();
        String time = this.txttime.getText();
        String date = this.txtdate.getText();
        String stid = this.txtstid.getText();
        AttendenceEntity attendence = new AttendenceEntity();
        attendence.setNfcNumber(nfc);
        attendence.setSid(stid);
        attendence.setTime(time);
        attendence.setDate(date);

        try {

          boolean isUpdated = attendenceBO.update(attendence);
          if(isUpdated) {
              initialize();
              new Alert(Alert.AlertType.CONFIRMATION, "Attendence updated!").show();
              clearFields();
           }

        }
      catch (SQLException e) {
          new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
         } catch (ClassNotFoundException e) {
          throw new RuntimeException(e);
      }

    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        String nfc = this.txtnfc.getText();
        String time = this.txttime.getText();
        String date = this.txtdate.getText();
        String stid = this.txtstid.getText();

        AttendenceEntity attendence = new AttendenceEntity();
        attendence.setNfcNumber(nfc);
        attendence.setTime(time);
        attendence.setDate(date);
        attendence.setSid(stid);


        try {


            boolean isSaved = attendenceBO.save(attendence);
            if(isSaved) {
                initialize();
                new Alert(Alert.AlertType.CONFIRMATION, "Student saved!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    private void clearFields() {
        txtnfc.clear();
        txtstid.clear();
        txttime.clear();
        txtdate.clear();
    }

    private List<AttendenceEntity> attendenceList = new ArrayList<>();

    private void loadAttendencTable() {
        ObservableList<AttendenceDTO> tmList = FXCollections.observableArrayList();

        for (AttendenceEntity attendence : this.attendenceList) {
            AttendenceDTO attendenceTm = new AttendenceDTO(
                    attendence.getId(),
                    attendence.getNfcNumber(),
                    attendence.getTime(),
                    attendence.getDate(),
                    attendence.getSid()

            );
            tmList.add(attendenceTm);
        }
        this.tblAttendence.setItems(tmList);
        AttendenceDTO selectedAttendence = this.tblAttendence.getSelectionModel().getSelectedItem();
        System.out.println("selectedItem = " + selectedAttendence);
    }
    private List<AttendenceEntity> getAllAttendence() {
        List<AttendenceEntity> attendenceList1 = null;

        try {
            attendenceList1 = attendenceBO.getAll();
        } catch (SQLException var3) {
            SQLException e = var3;
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return attendenceList1;
    }

    public void initialize() {
        this.attendenceList = this.getAllAttendence();
        this.setCellValueFactory();
        this.loadAttendencTable();


        LocalDate currentDate = LocalDate.now();
        txtdate.setText(currentDate.toString());
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        txttime.setText(currentTime.format(formatter));

    }

    private void setCellValueFactory() {
        this.colid.setCellValueFactory(new PropertyValueFactory("id"));
        this.colnfc.setCellValueFactory(new PropertyValueFactory("nfcNumber"));
        this.coltime.setCellValueFactory(new PropertyValueFactory("time"));
        this.coldate.setCellValueFactory(new PropertyValueFactory("date"));
        this.colstId.setCellValueFactory(new PropertyValueFactory("sid"));


    }

    public void txtStudentIdOnKeyRelesed(KeyEvent keyEvent) {
    //    Regex.setTextColour(TextField.SID);

    }
}
