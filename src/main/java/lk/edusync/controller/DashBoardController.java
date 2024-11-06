package lk.edusync.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import lk.edusync.bo.BOFactory;
import lk.edusync.bo.custom.FeeBO;
import lk.edusync.bo.custom.StudentBO;
import lk.edusync.bo.custom.impl.StudentBOImpl;
import lk.edusync.dao.custom.impl.StudentDAOImpl;
import lk.edusync.dto.FeeDTO;
import lk.edusync.dto.StudentDTO;
import lk.edusync.entity.FeeEntity;
import lk.edusync.entity.StudentEntity;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DashBoardController{

    @FXML
    private Label lbldate;

    @FXML
    private Label lbltime;




    @FXML
    private BarChart<String, Number> barStuCount;

    @FXML
    private TableColumn<?, ?> clostName;

    @FXML
    private TableColumn<?, ?> colfDate;

    @FXML
    private TableColumn<?, ?> colfSID;

    @FXML
    private TableColumn<?, ?> colstGEmail;

    @FXML
    private TableColumn<?, ?> colstGName;

    @FXML
    private TableColumn<?, ?> colstGNumber;

    @FXML
    private TableColumn<?, ?> costGrade;



    @FXML
    private TableView<FeeDTO> tblFee;

    @FXML
    private TableView<StudentDTO> tbltudent;

    FeeBO feeBO = (FeeBO) BOFactory.getBOFactory().getBO(BOFactory.BOType.FEE);


    public void initialize() throws ClassNotFoundException {
        this.studentsList1 = this.getAllStudents();
        this.setCellValueFactory();
        this.loadStudentTable();

            setTimeAndDate();


      this.feeList = this.getAllFees();
        this.setCellValueFactory3();
        this.loadFeeTable();

        try {
            studentCount(barStuCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    private void setTimeAndDate() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> {
                    // Update the label with the current time
                    LocalDateTime currentTime = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
                    lbltime.setText(formatter.format(currentTime));
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE); // Repeat indefinitely
        timeline.play();

        LocalDate date = LocalDate.now();
        lbldate.setText(date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
    }


    private ArrayList<StudentEntity> studentsList1 = new ArrayList<>();

    private ArrayList<FeeEntity> feeList = new ArrayList<>();

   private void setCellValueFactory3() {
        this.colfSID.setCellValueFactory(new PropertyValueFactory<>("Sid"));
        this.colfDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
    }

    private void setCellValueFactory() {

        this.clostName.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.costGrade.setCellValueFactory(new PropertyValueFactory<>("grade")); // Typo fixed: changed "colGade" to "colGrade"
        this.colstGName.setCellValueFactory(new PropertyValueFactory<>("guardianName")); // Typo fixed: changed "colGname" to "colGuardianName"
        this.colstGEmail.setCellValueFactory(new PropertyValueFactory<>("guardianEmail")); // Typo fixed: changed "colGemail" to "colGuardianEmail"
        this.colstGNumber.setCellValueFactory(new PropertyValueFactory<>("guardianTel")); // Typo fixed: changed "colGtel" to "colGuardianTel"

    }

    private ArrayList<StudentEntity> getAllStudents() {
        ArrayList<StudentEntity> studentList = null;
        StudentDAOImpl studentDAO = new StudentDAOImpl();
        try {
            studentList = studentDAO.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

    private ArrayList<FeeEntity> getAllFees()  {
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

    private void loadStudentTable() {
        ObservableList<StudentDTO> tmList = FXCollections.observableArrayList();

        for (StudentEntity student : this.studentsList1) {
            StudentDTO studentTm = new StudentDTO(
                    student.getId(),
                    student.getName(),
                    String.valueOf(student.getGrade()),
                    student.getAddress(),
                    student.getGuardianName(),
                    student.getGuardianAddress(),
                    student.getGuardianEmail(),
                    String.valueOf(student.getGuardianTel())
            );
            tmList.add(studentTm);
        }

        this.tbltudent.setItems(tmList);
        StudentDTO selectedStudent = this.tbltudent.getSelectionModel().getSelectedItem();
        System.out.println("selectedItem = " + selectedStudent);
    }

    private void loadFeeTable() {
        ObservableList<FeeDTO> tmList = FXCollections.observableArrayList();

        for (FeeEntity fee : this.feeList) {
            FeeDTO feeTm = new FeeDTO(
                    fee.getId(),
                    fee.getName(),
                    fee.getDate(),
                    fee.getSid()
            );
            tmList.add(feeTm);
        }

        this.tblFee.setItems(tmList);
        FeeDTO selectedFee = this.tblFee.getSelectionModel().getSelectedItem();
        System.out.println("selectedItem = " + selectedFee);
    }

    private void studentCount(BarChart<String, Number> barChart) throws SQLException, ClassNotFoundException {


      //  String sql = "SELECT grade AS Grade, COUNT(*) AS StudentCount FROM student GROUP BY grade ORDER BY Grade";

//        PreparedStatement pstm = connection.prepareStatement(sql);
//        ResultSet resultSet = pstm.executeQuery();
        StudentBO studentBO = new StudentBOImpl();

        ResultSet resultSet = studentBO.count();





        XYChart.Series<String, Number> series = new XYChart.Series<>();

        while (resultSet.next()) {
            String grade = resultSet.getString("Grade"); // Convert to String
            int count = resultSet.getInt("StudentCount");
            series.getData().add(new XYChart.Data<>(grade, count));
        }

        barChart.getData().add(series);

        for (Node n : barChart.lookupAll(".default-color0.chart-bar")) {
            n.setStyle("-fx-bar-fill: #19733E;");
        }


    }
}