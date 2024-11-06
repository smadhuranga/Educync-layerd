package lk.edusync.bo;

import lk.edusync.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory daoFactory;
    private BOFactory() {
    }
    public static BOFactory getBOFactory() {
        return (daoFactory == null) ? daoFactory = new BOFactory() : daoFactory;
    }
    public enum BOType{
        ATTENDENCE,EMPLOYEE,STUDENT,FEE,RECORDVIEW,SCHEDULE,USER
    }

    public SuperBO getBO(BOType boType) {
        switch (boType) {
            case ATTENDENCE:
                return new AttendenceBOImpl();
                case EMPLOYEE:
                    return new EmployeeBOImpl();
                    case FEE:
                        return new FeeBOImpl();
                            case RECORDVIEW:
                                return new RecordViewBOImpl();
                                case SCHEDULE:
                                    return new ScheduleBOImpl();
                                    case STUDENT:
                                        return new StudentBOImpl();
                                        case USER:
                                            return new UserBOImpl();

            default:
                return null;

        }
    }

}
