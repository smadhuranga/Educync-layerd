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
import lk.edusync.bo.custom.ScheduleBO;
import lk.edusync.bo.custom.impl.QueryBOImpl;

import lk.edusync.dto.ScheduleDTO;
import lk.edusync.entity.ScheduleEntity;
import lk.edusync.util.Regex;
import lk.edusync.util.TextField;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ScheduleFormController {
    @FXML
    private TableColumn<?, ?> colclid;

    @FXML
    private TableColumn<?, ?> coldate;

    @FXML
    private TableColumn<?, ?> colid;

    @FXML
    private TableColumn<?, ?> colstid;

    @FXML
    private TableColumn<?, ?> colstname;

    @FXML
    private TableColumn<?, ?> coltime;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<ScheduleDTO> tblschedule;

    @FXML
    private JFXTextField txtclid;

    @FXML
    private JFXTextField txtdate;

    @FXML
    private JFXTextField txteid;

    @FXML
    private JFXTextField txtid;

    @FXML
    private JFXTextField txttime;

    ScheduleBO scheduleBO = (ScheduleBO) BOFactory.getBOFactory().getBO(BOFactory.BOType.SCHEDULE);

    QuearyBO quearyBO = new QueryBOImpl();


    private void clearFields(){
        txtclid.clear();
        txtdate.clear();
        txttime.clear();
        txtid.clear();
        txteid.clear();
    }

    public void txtSearchOnAction(ActionEvent actionEvent) throws SQLException {
        String id = txtid.getText();
        try {

            ArrayList<ScheduleEntity> schedules =quearyBO.search(id);
            for (ScheduleEntity schedule : schedules) {
                txtid.setText(schedule.getShid());
                txtdate.setText(String.valueOf(schedule.getDate()));

                txttime.setText(String.valueOf(schedule.getTime()));
                txtclid.setText(schedule.getCalid());
                txteid.setText(schedule.getEid());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnClearOnAction(ActionEvent mouseEvent) {
        clearFields();
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String id = txtid.getText();
        String date = txtdate.getText();
        String time = txttime.getText();

        ScheduleEntity schedule = new ScheduleEntity(id, date, time);
        try {
            boolean isUpdate = scheduleBO.update(schedule);
            if(isUpdate) {
                initialize();
                new Alert(Alert.AlertType.CONFIRMATION, "schedule updated!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        String id = txtid.getText();
        String date = txtdate.getText();
        String time = txttime.getText();


        ScheduleEntity schedule = new ScheduleEntity(id,date,time);


        try {
            boolean isSaved =  scheduleBO.save(schedule);
            if(isSaved) {
                initialize();
                new Alert(Alert.AlertType.CONFIRMATION, "Schedule saved!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String id = txtid.getText();


        try {
            boolean isDeleted = scheduleBO.delete(id);
            if (isDeleted) {
                initialize();
                new Alert(Alert.AlertType.CONFIRMATION, "Schedule deleted!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private List<ScheduleEntity> schedulesList = new ArrayList<>();

    public void initialize() throws SQLException, ClassNotFoundException {

        this.schedulesList = this.getAllSchedule();
        this.setCellValueFactory();
        this.loadScheduleTable();

        LocalDate currentDate = LocalDate.now();
        txtdate.setText(currentDate.toString());

        // Set current time in the "time" field
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        txttime.setText(currentTime.format(formatter));

    }

    private void setCellValueFactory()  {
       this.colid.setCellValueFactory(new PropertyValueFactory<>("shid"));
       this.coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
       this.coltime.setCellValueFactory(new PropertyValueFactory<>("time"));
       this.colclid.setCellValueFactory(new PropertyValueFactory<>("calid"));
       this.colstid.setCellValueFactory(new PropertyValueFactory<>("sid"));
       this.colstname.setCellValueFactory(new PropertyValueFactory<>("name"));
    }

    private ArrayList<ScheduleEntity> getAllSchedule() throws SQLException, ClassNotFoundException {
        ArrayList<ScheduleEntity> scheduleList1 = null;


        try {
            scheduleList1 = quearyBO.getAll();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return scheduleList1;
    }

    private void loadScheduleTable() {
        ObservableList<ScheduleDTO> tmList = FXCollections.observableArrayList();

        // Check if schedulesList is not null before iterating
        if (this.schedulesList != null) {
            Iterator<ScheduleEntity> var2 = this.schedulesList.iterator();

            while (var2.hasNext()) {
                ScheduleEntity schedule = var2.next();
                ScheduleDTO scheduleTm = new ScheduleDTO(
                        schedule.getShid(),
                        schedule.getDate(), // Assuming getDate() should be called only once
                        schedule.getTime(), // Corrected to getTime() instead of getDate()
                        schedule.getCalid(),
                        schedule.getSid(),
                        schedule.getName()
                );
                tmList.add(scheduleTm);
            }
        }

        this.tblschedule.setItems(tmList);
        ScheduleDTO selectedItem = this.tblschedule.getSelectionModel().getSelectedItem();
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
