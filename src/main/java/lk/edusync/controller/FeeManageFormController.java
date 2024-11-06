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
import lk.edusync.bo.custom.FeeBO;

import lk.edusync.dto.FeeDTO;
import lk.edusync.entity.FeeEntity;
import lk.edusync.util.Regex;
import lk.edusync.util.TextField;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class FeeManageFormController {
    @FXML
    private TableColumn<?, ?> colfdate;

    @FXML
    private TableColumn<?, ?> colfid;

    @FXML
    private TableColumn<?, ?> colfname;

    @FXML
    private TableColumn<?, ?> colstid;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<FeeDTO> tvlfee;


    @FXML
    private JFXTextField txtdate;

    @FXML
    private JFXTextField txtid;

    @FXML
    private JFXTextField txtsid;

    FeeBO feeBO = (FeeBO) BOFactory.getBOFactory().getBO(BOFactory.BOType.FEE);


    public void txtSearchOnAction(ActionEvent actionEvent) throws Exception {
        String id = txtsid.getText();
        try {
            ArrayList<FeeEntity> feeList = feeBO.search(id);
            for (FeeEntity fee : feeList) {
                txtid.setText(fee.getId());
                txtsid.setText(fee.getSid());
                txtdate.setText(fee.getDate());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void clearFields(){

       txtid.clear();
       txtdate.clear();
       txtsid.clear();


    }

    public void btnClearOnAction(ActionEvent actionEvent) { clearFields();
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String id = txtid.getText();


        try {
            boolean isDeleted = feeBO.delete(id);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Fee deleted!").show();
                clearFields();
                initialize();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws Exception {
        String id = txtid.getText();
        String date = txtdate.getText();
        String sid = txtsid.getText();
       // String sql = "UPDATE feemanagement SET date = ? WHERE Sid = ?;";

        FeeEntity fee = new FeeEntity(id, date, sid);
        try {
            boolean isUpdate = feeBO.update(fee);
            if(isUpdate) {
                new Alert(Alert.AlertType.CONFIRMATION, "Fee updated!").show();
                clearFields();
                initialize();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        String id = txtid.getText();
        String date = txtdate.getText();
        String sid = txtsid.getText();


        FeeEntity fee = new FeeEntity(id, date, sid);

        try {

            boolean isSaved = feeBO.save(fee);
            if(isSaved) {
                initialize();
                new Alert(Alert.AlertType.CONFIRMATION, "Fee saved!").show();
                clearFields();

            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private ArrayList<FeeEntity> feeList = new ArrayList<>();

    public void initialize() {
        this.feeList = this.getAllFees();
        this.setCellValueFactory3();
        this.loadFeeTable();

        LocalDate currentDate = LocalDate.now();
        txtdate.setText(currentDate.toString());
    }

    private ArrayList<FeeEntity> getAllFees() {
        ArrayList<FeeEntity> feeList1 = null;

        try {
            feeList1 = feeBO.getAll();
        } catch (SQLException var3) {
            SQLException e = var3;
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return feeList1;
    }

    private void setCellValueFactory3(){
        this.colfid.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.colfdate.setCellValueFactory(new PropertyValueFactory<>("date"));
        this.colstid.setCellValueFactory(new PropertyValueFactory<>("Sid"));
        this.colfname.setCellValueFactory(new PropertyValueFactory<>("name"));




    }

    private void loadFeeTable() {
        ObservableList<FeeDTO> tmList = FXCollections.observableArrayList();

        for (FeeEntity fee : this.feeList) {
            FeeDTO feeTTm = new FeeDTO(
                    fee.getId(),
                    fee.getName(),
                    fee.getDate(),
                    fee.getSid()
            );
            tmList.add(feeTTm);
        }

        this.tvlfee.setItems(tmList);
        FeeDTO selectedFee = this.tvlfee.getSelectionModel().getSelectedItem();
        System.out.println("selectedItem = " + selectedFee);
    }

    public void txtStudentIdOnKeyRelesed(KeyEvent keyEvent) {
        Regex.setTextColour(TextField.SID,txtsid);
    }

    public boolean is(){
        if (!Regex.setTextColour(TextField.SID,txtsid)) return true;
        return false;
    }
}
