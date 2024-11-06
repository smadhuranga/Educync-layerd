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
import lk.edusync.bo.custom.EmployeeBO;

import lk.edusync.dto.EmployeeDTO;
import lk.edusync.entity.EmployeeEntity;
import lk.edusync.util.Regex;
import lk.edusync.util.TextField;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeFormController {
    @FXML
    private TableColumn<?, ?> coladdress;

    @FXML
    private TableColumn<?, ?> colemail;

    @FXML
    private TableColumn<?, ?> colid;

    @FXML
    private TableColumn<?, ?> colname;

    @FXML
    private TableColumn<?, ?> colnic;

    @FXML
    private TableColumn<?, ?> colroll;

    @FXML
    private TableColumn<?, ?> coltel;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<EmployeeDTO> tblEmployee;

    @FXML
    private JFXTextField txtaddress;

    @FXML
    private JFXTextField txtemail;

    @FXML
    private JFXTextField txtid;

    @FXML
    private JFXTextField txtname;

    @FXML
    private JFXTextField txtnic;

    @FXML
    private JFXTextField txtroll;

    @FXML
    private JFXTextField txttel;

    EmployeeBO employeeBO = (EmployeeBO) BOFactory.getBOFactory().getBO(BOFactory.BOType.EMPLOYEE);




    private void clearFields() {
        txtid.clear();
        txtname.clear();
        txtemail.clear();
        txtaddress.clear();
        txttel.clear();
        txtnic.clear();
        txtroll.clear();

    }
    public void txtSearchOnAction(ActionEvent actionEvent) throws SQLException {
        String id1 = txtid.getText();
        try {


           // ResultSet resultSet = pstm.executeQuery();

            ArrayList<EmployeeEntity> employees1 = employeeBO.search(id1);

            for (EmployeeEntity employee : employees1) {
                txtname.setText(employee.getName());
                txtid.setText(employee.getId());
                txtemail.setText(employee.getEmail());
                txtaddress.setText(employee.getAddress());
                txttel.setText(String.valueOf(employee.getTel()));
                txtnic.setText(employee.getNic());
                txtroll.setText(employee.getRoll());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        this.clearFields();
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String id = this.txtid.getText();



        try {
            boolean isDeleted = employeeBO.delete(id);
            if (isDeleted) {
                (new Alert(Alert.AlertType.CONFIRMATION, "Employee deleted!", new ButtonType[0])).show();
            }
        } catch (SQLException var4) {
            SQLException e = var4;
            (new Alert(Alert.AlertType.ERROR, e.getMessage(), new ButtonType[0])).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String id = this.txtid.getText();
        String name = this.txtname.getText();
        String email = this.txtemail.getText();
        String address = this.txtaddress.getText();
        int tel= Integer.parseInt(this.txttel.getText());
        String nic = this.txtnic.getText();
        String roll = this.txtroll.getText();



        EmployeeEntity employee= new EmployeeEntity(id, name, address,email, roll, nic, tel);

        try {
            boolean isUpdated = employeeBO.update(employee);
            if (isUpdated) {
                (new Alert(Alert.AlertType.CONFIRMATION, "Employee updated!", new ButtonType[0])).show();
                initialize();
                clearFields();
            }
        } catch (SQLException var8) {
            SQLException e = var8;
            (new Alert(Alert.AlertType.ERROR, e.getMessage(), new ButtonType[0])).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        String id = this.txtid.getText();
        String name = this.txtname.getText();
        String email = this.txtemail.getText();
        String address = this.txtaddress.getText();
        int tel = Integer.parseInt(this.txttel.getText());
        String nic = this.txtnic.getText();
        String roll = this.txtroll.getText();


        EmployeeEntity employee = new EmployeeEntity(id, name, address,email, roll, nic, tel);


        try {
            boolean isSaved = employeeBO.save(employee);
            if (isSaved) {
                (new Alert(Alert.AlertType.CONFIRMATION, "Emplopyee saved!", new ButtonType[0])).show();
                initialize();
                clearFields();
            }
        } catch (SQLException var8) {
            SQLException e = var8;
            (new Alert(Alert.AlertType.ERROR, e.getMessage(), new ButtonType[0])).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void initialize() {
        this.employeeList = this.getAllEmployees();
        this.setCellValueFactory2();
        this.loadEmployeeTable();
    }

    private void setCellValueFactory2() {
        this.colid.setCellValueFactory(new PropertyValueFactory("id"));
        this.colname.setCellValueFactory(new PropertyValueFactory("name"));
        this.coladdress.setCellValueFactory(new PropertyValueFactory("address"));
        this.colemail.setCellValueFactory(new PropertyValueFactory("email"));
        this.colroll.setCellValueFactory(new PropertyValueFactory("roll"));
        this.colnic.setCellValueFactory(new PropertyValueFactory("nic"));
        this.coltel.setCellValueFactory(new PropertyValueFactory("tel"));
    }

    private void loadEmployeeTable() {
        ObservableList<EmployeeDTO> tmList = FXCollections.observableArrayList();

        for (EmployeeEntity employee : this.employeeList) {
            EmployeeDTO employeeTm = new EmployeeDTO(
                    employee.getId(),
                    employee.getName(),
                    employee.getAddress(),
                    employee.getEmail(),
                    employee.getRoll(),
                    employee.getNic(),
                    employee.getTel()
            );
            tmList.add(employeeTm);
        }

        this.tblEmployee.setItems(tmList);
        EmployeeDTO selectedEmployee = this.tblEmployee.getSelectionModel().getSelectedItem();
        System.out.println("selectedItem = " + selectedEmployee);
    }
    private ArrayList<EmployeeEntity> getAllEmployees() {

        ArrayList<EmployeeEntity> employeeList1 = null;
        try {
            employeeList1 =  employeeBO.getAll();
        } catch (SQLException var3) {
            SQLException e = var3;
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return employeeList1;
    }

    private ArrayList<EmployeeEntity> employeeList = new ArrayList<>();

    public boolean is(){
        if (!Regex.setTextColour(TextField.SID,txtid)) return true;
        return false;
    }
    public void txtEmployeeIdOnKeyRelesed(KeyEvent keyEvent) {
        Regex.setTextColour(TextField.SID,txtid);

    }
}
