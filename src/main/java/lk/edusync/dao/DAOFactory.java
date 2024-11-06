package lk.edusync.dao;

import lk.edusync.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {

    }
    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOType {
       ATTENDENCE,EMPLOYEE,STUDENT,FEE,RECORDVIEW,SCHEDULE,USER
    }

    public SuperDAO getDAO(DAOType daoType){
        switch (daoType) {
            case ATTENDENCE:
                return new AttendenceDAOImpl();
                case EMPLOYEE:
                    return new EmployeeDAOImpl();
                    case STUDENT:
                        return new StudentDAOImpl();
                        case FEE:
                            return new FeeDAOImpl();
                            case RECORDVIEW:
                                return new RecordViewDAOImpl();
                                case SCHEDULE:
                                    return new ScheduleDAOImpl();
                                    case USER:
                                        return new UserDAOImpl();

            default:
                return null;
        }
    }
}
