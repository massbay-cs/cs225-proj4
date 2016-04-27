package auth.levels;

import auth.AuthorizationException;
import auth.Operation;
import auth.PrivilegeLevel;
import auth.Who;

public class AdminLevel extends Level {
    @Override
    public PrivilegeLevel getPrivilegeLevel() {
        return PrivilegeLevel.ADMIN; 
    }
    @Override
    public void checkPermission(String table, String field, Operation operation, Who who, PrivilegeLevel otherLevel) throws AuthorizationException {
        super.checkPermission(table, field, operation, who, otherLevel);
    }@Override
    protected void checkPermissionTasks(Context context) throws AuthorizationException {
        switch (context.getFieldForSwitch()){
            case "":
                break;
            case "DESCRIPTION":
                break;
            case "DETAILS":
                break;
            case "TITLE":
                break;
            case "STREET":
                break;
            case "CITY":
                break;
            case "STATE":
                break;
            case "ZIPCODE":
                break;
            case "COUNTRY":
                break;
            case "STARTDATE":
                break;
            case "ENDDATE":
                break;
            case "COMPLETE":
                break;
            case "MANAGER":
                break;
            default:
                throw new UnknownFieldException(context);
        }
    }
    @Override
    protected void checkPermissionIncome(Context context) throws AuthorizationException {
        switch (context.getFieldForSwitch()){
            case "":
                break;
            case "DESCRIPTION":
                break;
            case "DATE":
                break;
            case "VALUE":
                break;
            default:
                throw new UnknownFieldException(context);
        }
    }

    @Override
    protected void checkPermissionExpense(Context context) throws AuthorizationException {
        switch (context.getFieldForSwitch()){
            case "":
                break;
            case "DESCRIPTION":
                break;
            case "DATE":
                break;
            case "VALUE":
                break;
            default:
                throw new UnknownFieldException(context);
        }
    }
    @Override
    protected void checkPermissionSubEvents(Context context) throws AuthorizationException {
        switch (context.getFieldForSwitch()) {
            case "":
                break;
            case "DESCRIPTION":
                break;
            case "DETAILS":
                break;
            case "TITLE":
                break;
            case "STARTTIME":
                break;
            case "ENDTIME":
                break;
            case "COMPLETE":
                break;
            case "STREET":
                break;
            case "CITY":
                break;
            case "STATE":
                break;
            case "ZIPCODE":
                break;
            case "COUNTRY":
                break;
            default:
                throw new UnknownFieldException(context);
        }
    }
    @Override
    protected void checkPermissionEvents(Context context) throws AuthorizationException {
        switch (context.getFieldForSwitch()) {
            case "":
                break;
            case "DESCRIPTION":
                break;
            case "DETAILS":
                break;
            case "TITLE":
                break;
            case "STARTDATE":
                break;
            case "ENDDATE":
                break;
            case "COMPLETE":
                break;
            case "STREET":
                break;
            case "CITY":
                break;
            case "STATE":
                break;
            case "ZIPCODE":
                break;
            case "COUNTRY":
                break;
            case "ORGANIZERLIST":
                break;
            case "SUBEVENTLIST":
                break;
            case "PARTICIPANTLIST":
                break;
            case "COMMITTEE":
                break;
            default:
                throw new UnknownFieldException(context);
        }
    }
    @Override
    protected void checkPermissionUsers(Context context) throws AuthorizationException {
        switch (context.getFieldForSwitch()) {
            case "":
                break;
            case "LEVEL":
                break;
            case "FNAME":
                break;
            case "LNAME":
                break;
            case "PWD":
                context.cannotViewOther();
                break;
            case "EMAIL":
                break;
            case "PHONE":
                break;
            case "STREET":
                break;
            case "CITY":
                break;
            case "STATE":
                break;
            case "ZIPCODE":
                break;
            case "COUNTRY":
                break;
            case "PARTICIPANT":
                break;
            case "EVENTLEVEL":
                break;
            default:
                throw new UnknownFieldException(context);
        }
    }
    @Override
    protected void checkPermissionCommittee(Context context) throws AuthorizationException {
        switch (context.getFieldForSwitch()) {
            case "":
                break;
            case "TITLE":
                break;
            case "CHAIRMAN":
                break;
            case "BUDGETACCESS":
                break;
            case "MEMBERS":
                break;
            case "TASKS":
                break;
            case "INCOME":
                break;
            case "EXPENSE":
                break;
            case "BUDGET":
                break;
            default:
                throw new UnknownFieldException(context);
        }
    }
}