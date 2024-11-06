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
import lk.edusync.bo.custom.StudentBO;
import lk.edusync.dto.StudentDTO;
import lk.edusync.entity.StudentEntity;
import lk.edusync.util.Regex;
import lk.edusync.util.TextField;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentFormController {
    @FXML
    private AnchorPane root;
    @FXML
    private TableView<StudentDTO> tblStudent;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colGaddress;

    @FXML
    private TableColumn<?, ?> colGemail;

    @FXML
    private TableColumn<?, ?> colGname;

    @FXML
    private TableColumn<?, ?> colGrade;

    @FXML
    private TableColumn<?, ?> colGtel;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private JFXTextField txtaddress;

    @FXML
    private JFXTextField txtgaddress;

    @FXML
    private JFXTextField txtgemail;

    @FXML
    private JFXTextField txtgname;

    @FXML
    private JFXTextField txtgrade;

    @FXML
    private JFXTextField txtgtel;

    @FXML
    private JFXTextField txtid;

    @FXML
    private JFXTextField txtdate;

    @FXML
    private JFXTextField txtname;


    StudentBO studentBO = (StudentBO) BOFactory.getBOFactory().getBO(BOFactory.BOType.STUDENT);


    private List<StudentEntity> studentsList = new ArrayList<>();

    public void initialize() {

        this.studentsList = this.getAllStudents();
        this.setCellValueFactory();
        this.loadStudentTable();

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
            clearFields();
    }
    @FXML
    void btnDeleteOnAction(ActionEvent event) {
    String id = txtid.getText();


    try {
        boolean isDeleted = studentBO.delete(id);
        if (isDeleted) {
            initialize();
            new Alert(Alert.AlertType.CONFIRMATION, "Student deleted!").show();
            clearFields();
        }
    } catch (SQLException e) {
        new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
    }
    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException {
        String id = txtid.getText();
        String name = txtname.getText();
        String grade = txtgrade.getText();
        String gname = txtgname.getText();
        String gtel = txtgtel.getText();
        String gaddress = txtgaddress.getText();
        String address = txtaddress.getText();
        String gemail = txtgemail.getText();


        StudentEntity student = new StudentEntity();
        student.setId(id);
        student.setName(name);
        student.setGrade(Integer.parseInt(grade));
        student.setGuardianTel(gtel);
        student.setGuardianName(gname);
        student.setGuardianAddress(gaddress);
        student.setAddress(address);
        student.setGuardianEmail(gemail);

//        String sql = "UPDATE student SET name = ?, address = ?, grade = ?, guardianName = ?, guardianAddress = ?, guardianEmail = ?, guardianTel = ? WHERE id = ?;";
    try {

//        PreparedStatement pstm = DbConnection.getInstance().getConnection()
//                .prepareStatement(sql);
//        pstm.setObject(1,name);
//        pstm.setObject(2,address);
//        pstm.setObject(3,grade);
//        pstm.setObject(4,gname);
//        pstm.setObject(5,gaddress);
//        pstm.setObject(6,gemail);
//        pstm.setObject(7,gtel);
//        pstm.setObject(8,id);

        boolean isUpdated = studentBO.update(student);

        if(isUpdated) {
            initialize();
            new Alert(Alert.AlertType.CONFIRMATION, "Student updated!").show();
            clearFields();
        }
    } catch (SQLException e) {
        new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }


    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = txtid.getText();
        String name = txtname.getText();
        String grade = txtgrade.getText();
        String gtel = txtgtel.getText();
        String gname = txtgname.getText();
        String gaddress = txtgaddress.getText();
        String address = txtaddress.getText();
        String gemail = txtgemail.getText();

//        String sql = "INSERT INTO student VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        StudentEntity student = new StudentEntity();
        student.setId(id);
        student.setName(name);
        student.setGrade(Integer.parseInt(grade));
        student.setGuardianTel(gtel);
        student.setGuardianName(gname);
        student.setGuardianAddress(gaddress);
        student.setAddress(address);
        student.setGuardianEmail(gemail);



        try {
//            Connection connection = DbConnection.getInstance().getConnection();
//            PreparedStatement pstm = connection.prepareStatement(sql);
//
//            pstm.setObject(1, id);
//            pstm.setObject(2, name);
//            pstm.setObject(3, grade);
//            pstm.setObject(4, address);
//            pstm.setObject(5, gname);
//            pstm.setObject(6,gaddress);
//            pstm.setObject(7,gemail);
//            pstm.setObject(8,gtel);

            boolean isSaved = studentBO.save(student);
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
        txtid.clear();
        txtname.clear();
        txtgrade.clear();
        txtgname.clear();
        txtgtel.clear();
        txtgaddress.clear();
        txtaddress.clear();
        txtgemail.clear();
    }

    public void txtSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        String id = txtid.getText();

//        String sql = "SELECT * FROM student WHERE id = ?";

        try {
//            Connection connection = DbConnection.getInstance().getConnection();
//            PreparedStatement pstm = connection.prepareStatement(sql);
//            pstm.setObject(1, id);
//
//            ResultSet resultSet = pstm.executeQuery();
//            if (resultSet.next()) {
//                String id1 = resultSet.getString(1);
//                String name = resultSet.getString(2);
//                String grade = resultSet.getString(3);
//                String address = resultSet.getString(4);
//                String gname = resultSet.getString(5);
//                String gaddress = resultSet.getString(6);
//                String gemail = resultSet.getString(7);
//                String gtel = resultSet.getString(8);
            ArrayList<StudentEntity> students = studentBO.search(id);
            for (StudentEntity student : students) {
                txtid.setText(student.getId());
                txtname.setText(student.getName());
                txtaddress.setText(student.getAddress());
                txtgrade.setText(String.valueOf(student.getGrade()));
                txtgname.setText(student.getGuardianName());
                txtgtel.setText(student.getGuardianTel());
                txtgaddress.setText(student.getGuardianAddress());
                txtgemail.setText(student.getGuardianEmail());

            }




//            } else {
//                new Alert(Alert.AlertType.INFORMATION, "Student id can't be found!").show();
//            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    private void setCellValueFactory()  {
        this.colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.colGrade.setCellValueFactory(new PropertyValueFactory<>("grade"));
        this.colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        this.colGname.setCellValueFactory(new PropertyValueFactory<>("guardianName"));
        this.colGemail.setCellValueFactory(new PropertyValueFactory<>("guardianEmail"));
        this.colGtel.setCellValueFactory(new PropertyValueFactory<>("guardianTel"));

    }

    private ArrayList<StudentEntity> getAllStudents() {
        ArrayList<StudentEntity> studentList = null;

        try {
            studentList = studentBO.getAll();
        } catch (SQLException | ClassNotFoundException var3) {

            throw new RuntimeException(var3);
        }
        return studentList;
    }

    private void loadStudentTable() {
        ObservableList<StudentDTO> tmList = FXCollections.observableArrayList();

        Iterator var2 = this.studentsList.iterator();

        while(var2.hasNext()) {
            StudentEntity student = (StudentEntity) var2.next();
            StudentDTO studentTm = new StudentDTO(student.getId(), student.getName(), String.valueOf(student.getGrade()), student.getAddress(), student.getGuardianName(), student.getGuardianAddress(), student.getGuardianEmail(), String.valueOf(student.getGuardianTel()) );
            tmList.add(studentTm);
        }

        this.tblStudent.setItems(tmList);
        StudentDTO selectedItem = (StudentDTO) this.tblStudent.getSelectionModel().getSelectedItem();
        System.out.println("selectedItem = " + selectedItem);
    }

    public boolean is(){
        if (!Regex.setTextColour(lk.edusync.util.TextField.SID,txtid)) return true;
        return false;
    }
    public void txtStudentIdOnKeyRelesed(KeyEvent keyEvent) {
        Regex.setTextColour(TextField.SID,txtid);

    }

}