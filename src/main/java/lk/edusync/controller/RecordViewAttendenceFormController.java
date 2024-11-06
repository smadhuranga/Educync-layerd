package lk.edusync.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import lk.edusync.bo.BOFactory;
import lk.edusync.bo.custom.QuearyBO;
import lk.edusync.bo.custom.RecordeViewBO;
import lk.edusync.bo.custom.impl.QueryBOImpl;
import lk.edusync.dao.custom.impl.RecordViewDAOImpl;


import lk.edusync.dto.RecordDTO;
import lk.edusync.entity.RecordEntity;
import lk.edusync.util.Regex;
import lk.edusync.util.TextField;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class RecordViewAttendenceFormController {
    @FXML
    private AnchorPane root;

    @FXML
    private TableColumn<?, ?> coldate;

    @FXML
    private TableColumn<?, ?> colgarde;

    @FXML
    private TableColumn<?, ?> colgemail;

    @FXML
    private TableColumn<?, ?> colgname;

    @FXML
    private TableColumn<?, ?> colgtel;

    @FXML
    private TableColumn<?, ?> colid;

    @FXML
    private TableColumn<?, ?> colname;

    @FXML
    private TableColumn<?, ?> coltime;


    @FXML
    private JFXTextField date;

    @FXML
    private JFXTextField nfcnum;

    @FXML
    private JFXTextField stid;

    @FXML
    private JFXTextField time;

    @FXML
    private TableView<RecordDTO> tblAttende;

    RecordeViewBO recordeViewBO = (RecordeViewBO) BOFactory.getBOFactory().getBO(BOFactory.BOType.RECORDVIEW);

   QuearyBO quearyBO = new QueryBOImpl();


    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }




    private void clearFields() {
        stid.clear();
        nfcnum.clear();
    }



    public void initialize() {
        this.recordList = this.getAllRecords();
        this.setCellValueFactory2();
        this.loadRecordTable();


        LocalDate currentDate = LocalDate.now();
        date.setText(currentDate.toString());

        // Set current time in the "time" field
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        time.setText(currentTime.format(formatter));
    }

    private void setCellValueFactory2() {
        this.colid.setCellValueFactory(new PropertyValueFactory("Sid"));
        this.colname.setCellValueFactory(new PropertyValueFactory("name"));
        this.colgarde.setCellValueFactory(new  PropertyValueFactory("grade"));
        this.coldate.setCellValueFactory(new PropertyValueFactory("date"));
        this.coltime.setCellValueFactory(new PropertyValueFactory("time"));
        this.colgtel.setCellValueFactory(new PropertyValueFactory("guardianTel"));
        this.colgemail.setCellValueFactory(new PropertyValueFactory("guardianEmail"));
        this.colgname.setCellValueFactory(new PropertyValueFactory("guardianName"));
    }

    private void loadRecordTable() {
        ObservableList<RecordDTO> tmList = FXCollections.observableArrayList();

        for (RecordEntity record : this.recordList) {
            RecordDTO recordTm = new RecordDTO(
                    record.getTime(),
                    record.getDate(),
                    record.getSid(),
                    record.getName(),
                    record.getGrade(),
                    record.getGuardianTel(),
                    record.getGuardianEmail(),
                    record.getGuardianName());

            tmList.add(recordTm);
        }

        this.tblAttende.setItems(tmList);
        RecordDTO selectedRecord = this.tblAttende.getSelectionModel().getSelectedItem();
        System.out.println("selectedItem = " + selectedRecord);
    }
    private ArrayList<RecordEntity> getAllRecords() {
        ArrayList<RecordEntity> recordList = null;

        try {
            recordList = recordeViewBO.getAll();
        } catch (SQLException var3) {
            SQLException e = var3;
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return recordList;
    }

    private List<RecordEntity> recordList = new ArrayList<>();

    public void txtSaveOnAction(ActionEvent actionEvent) throws Exception {
//        String sql = "select a.id, a.nfcNumber, a.time, a.date, a.Sid, s.guardianEmail, s.name from student s join studentattendence a on s.id = a.Sid where nfcNumber = ?";

        String nfcNum =this.nfcnum.getText();
        Time time = Time.valueOf(this.time.getText());
        Date date = Date.valueOf(this.date.getText());
        String Sid =  this.stid.getText();
        String email = null;
        String name = null;
        String body = null;

     //   RecordR record = new RecordR(nfcNum,time,date,Sid, null, null);



        try {
            ArrayList<RecordEntity> recordRS =quearyBO.save(nfcNum);
            for (RecordEntity recordR : recordRS) {
                name = recordR.getName();
                email = recordR.getGuardianEmail();
                Sid = recordR.getSid();
            }

               stid.setText(Sid);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
            body = ("Date :"+date+"        "+"Time :"+ time +"       "+"Name :"+ name) ;
        RecordEntity record = new RecordEntity(nfcNum, time, date, Sid);

        try {
            RecordViewDAOImpl recordViewDAO = new RecordViewDAOImpl();
           boolean isSaved = recordViewDAO.save(record);
            if (isSaved) {
                initialize();
                new Alert(Alert.AlertType.CONFIRMATION, "Record saved!").show();


               EmailSender.sendEmail(email, "Athwala Institute", body+"");
                System.out.println(email);
                System.out.println(body);
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (Exception e) {

        }


    }

    public void txtEmployeeOnKeyRelesed(KeyEvent keyEvent) {
        Regex.setTextColour(TextField.NFC,nfcnum);
    }
    public boolean is(){
        if (!Regex.setTextColour(TextField.NFC,nfcnum)) return true;
        return false;
    }
}
