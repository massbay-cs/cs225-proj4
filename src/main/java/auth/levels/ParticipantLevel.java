package auth.levels;

import auth.AuthorizationException;
import auth.PrivilegeLevel;

public class ParticipantLevel extends Level {
    @Override
    public PrivilegeLevel getPrivilegeLevel() {
        return PrivilegeLevel.PARTICIPANT;
    }

    @Override
    protected void checkPermissionUsers(Context context) throws AuthorizationException {
        switch (context.getFieldForSwitch()) {
            case "LEVEL":
                context.cannotCreate();
                context.cannotDeleteOther();
                context.cannotModify();
                context.cannotViewOther();
//                        .cannotViewOther()    // "Other" means other users; they can still view info about themselves
//                        .cannotModify()       // No "Other" or "Self"; doesn't matter who the user is that's being modified
//                        .cannotCreate()       // User can't add other users.
//                        .cannotDeleteOther(); // User can delete self.  Opposite is cannotDeleteSelf().

                break;

            case "FNAME":
                context.cannotCreate();
                context.cannotDeleteOther();
                context.cannotModifyOther();
                context.cannotViewOther(); // needs to be changed for people who agree to share information

                break;

            case "LNAME":
                context.cannotCreate();
                context.cannotDeleteOther();
                context.cannotModifyOther();
                context.cannotViewOther(); // needs to be changed for people who agree to share information

                break;

            case "PWD":
                context.cannotCreate();
                context.cannotDeleteOther();
                context.cannotModifyOther();
                context.cannotViewOther();

                break;

            case "EMAIL":
                context.cannotCreate();
                context.cannotDeleteOther();
                context.cannotModifyOther();
                context.cannotViewOther(); // needs to be changed for enabling to email organizers

                break;

            case "PHONE":
                context.cannotCreate();
                context.cannotDeleteOther();
                context.cannotModifyOther();
                context.cannotViewOther(); // needs to be changed for people who agree to share information

                break;


            case "STREET":
                context.cannotCreate();
                context.cannotDeleteOther();
                context.cannotModifyOther();
                context.cannotViewOther(); // needs to be changed for people who agree to share information

                break;

            case "CITY":
                context.cannotCreate();
                context.cannotDeleteOther();
                context.cannotModifyOther();
                context.cannotViewOther(); // needs to be changed for people who agree to share information

                break;


            case "STATE":
                context.cannotCreate();
                context.cannotDeleteOther();
                context.cannotModifyOther();
                context.cannotViewOther(); // needs to be changed for people who agree to share information

                break;

            case "ZIPCODE":
                context.cannotCreate();
                context.cannotDeleteOther();
                context.cannotModifyOther();
                context.cannotViewOther(); // needs to be changed for people who agree to share information

                break;


            case "COUNTRY":
                context.cannotCreate();
                context.cannotDeleteOther();
                context.cannotModifyOther();
                context.cannotViewOther(); // needs to be changed for people who agree to share information

                break;

            case "participant":// only guessing the usage of this field
                context.noAccess();

                break;

            case "eventLevel":// no idea what this is used for
                context.cannotCreate();

                break;

            default:
                throw new UnknownFieldException(context);
        }
    }

    @Override
    protected void checkPermissionEvents(Context context) throws AuthorizationException {
        switch (context.getFieldForSwitch()) {
            case "tableName":
                context.cannotCreate();
                context.cannotDelete();
                context.cannotModify();
                // is there a need to deny viewing this field for events not participating in?

                break;

            case "DESCRIPTION":
                context.cannotCreate();
                context.cannotDelete();
                context.cannotModify();
                // is there a need to deny viewing this field for events not participating in?

                break;

            case "DETAILS":
                context.cannotCreate();
                context.cannotDelete();
                context.cannotModify();
                // is there a need to deny viewing this field for events not participating in?

                break;

            case "TITLE":
                context.cannotCreate();
                context.cannotDelete();
                context.cannotModify();
                // is there a need to deny viewing this field for events not participating in?

                break;

            case "STARTDATE":
                context.cannotCreate();
                context.cannotDelete();
                context.cannotModify();
                // is there a need to deny viewing this field for events not participating in?

                break;

            case "ENDDATE":
                context.cannotCreate();
                context.cannotDelete();
                context.cannotModify();
                // is there a need to deny viewing this field for events not participating in?

                break;

            case "COMPLETE":
                context.cannotCreate();
                context.cannotDelete();
                context.cannotModify();
                // is there a need to deny viewing this field for events not participating in?

                break;

            case "STREET":
                context.cannotCreate();
                context.cannotDelete();
                context.cannotModify();
                // is there a need to deny viewing this field for events not participating in?

                break;

            case "CITY":
                context.cannotCreate();
                context.cannotDelete();
                context.cannotModify();
                // is there a need to deny viewing this field for events not participating in?

                break;


            case "STATE":
                context.cannotCreate();
                context.cannotDelete();
                context.cannotModify();
                // is there a need to deny viewing this field for events not participating in?

                break;

            case "ZIPCODE":
                context.cannotCreate();
                context.cannotDelete();
                context.cannotModify();
                // is there a need to deny viewing this field for events not participating in?

                break;


            case "COUNTRY":
                context.cannotCreate();
                context.cannotDelete();
                context.cannotModify();
                // is there a need to deny viewing this field for events not participating in?

                break;

            case "ORGANIZER":
                context.cannotCreate();
                context.cannotDelete();
                context.cannotModify();
                // is there a need to deny viewing this field for events not participating in?

                break;

            case "SUBEVENT":
                context.cannotCreate();
                context.cannotDelete();
                context.cannotModify();
                // is there a need to deny viewing this field for events not participating in?

                break;

            case "PARTICIPANT":
                context.cannotCreate();
                context.cannotDelete();
                context.cannotModify();
                // is there a need to deny viewing this field for events not participating in?

                break;

            case "organizerList":
                context.cannotCreate();
                context.cannotDelete();
                context.cannotModify();
                // is there a need to deny viewing this field for events not participating in?

                break;

            case "subEventList":
                context.cannotCreate();
                context.cannotDelete();
                context.cannotModify();
                // is there a need to deny viewing this field for events not participating in?

                break;

            case "participantList":
                context.cannotCreate();
                context.cannotDelete();
                context.cannotModify();
                // is there a need to deny viewing this field for events not participating in?

                break;

            case "COMMITTEE":
                context.cannotCreate();
                context.cannotDelete();
                context.cannotModify();
                // is there a need to deny viewing this field for events not participating in?

                break;

            // TODO

            default:
                throw new UnknownFieldException(context);
        }
    }

    @Override
    protected void checkPermissionSubEvents(Context context) throws AuthorizationException {
        switch (context.getFieldForSwitch()) {
            case "DESCRIPTION":
                context.cannotCreate();
                context.cannotDelete();
                context.cannotModify();
                // is there a need to deny viewing this field for events not participating in?

                break;

            case "DETAILS":
                context.cannotCreate();
                context.cannotDelete();
                context.cannotModify();
                // is there a need to deny viewing this field for events not participating in?

                break;

            case "TITLE":
                context.cannotCreate();
                context.cannotDelete();
                context.cannotModify();
                // is there a need to deny viewing this field for events not participating in?

                break;

            case "COMPLETE":
                context.cannotCreate();
                context.cannotDelete();
                context.cannotModify();
                // is there a need to deny viewing this field for events not participating in?

                break;

            case "STREET":
                context.cannotCreate();
                context.cannotDelete();
                context.cannotModify();
                // is there a need to deny viewing this field for events not participating in?

                break;

            case "CITY":
                context.cannotCreate();
                context.cannotDelete();
                context.cannotModify();
                // is there a need to deny viewing this field for events not participating in?

                break;


            case "STATE":
                context.cannotCreate();
                context.cannotDelete();
                context.cannotModify();
                // is there a need to deny viewing this field for events not participating in?

                break;

            case "ZIPCODE":
                context.cannotCreate();
                context.cannotDelete();
                context.cannotModify();
                // is there a need to deny viewing this field for events not participating in?

                break;


            case "COUNTRY":
                context.cannotCreate();
                context.cannotDelete();
                context.cannotModify();
                // is there a need to deny viewing this field for events not participating in?

                break;

            case "STARTDATE":
                context.cannotCreate();
                context.cannotDelete();
                context.cannotModify();
                // is there a need to deny viewing this field for events not participating in?

                break;

            case "ENDDATE":
                context.cannotCreate();
                context.cannotDelete();
                context.cannotModify();
                // is there a need to deny viewing this field for events not participating in?

                break;

            case "startTime":
                context.cannotCreate();
                context.cannotDelete();
                context.cannotModify();
                // is there a need to deny viewing this field for events not participating in?

                break;

            case "endTime":
                context.cannotCreate();
                context.cannotDelete();
                context.cannotModify();
                // is there a need to deny viewing this field for events not participating in?

                break;



            // TODO

            default:
                throw new UnknownFieldException(context);
        }
    }

    @Override
    protected void checkPermissionCommittee(Context context) throws AuthorizationException {
        switch (context.getFieldForSwitch()) {
            case "TITLE":
                context.cannotCreate();
                context.cannotDelete();
                context.cannotModify();

                break;

            case "CHAIRMAN":
                context.cannotCreate();
                context.cannotDelete();
                context.cannotModify();

                break;

            case "BUDGETACCESS":
                context.noAccess();

                break;

            case "MEMBERS":
                context.noAccess();

                break;

            case "TASKS":
                context.noAccess();

                break;

            case "INCOME":
                context.noAccess();

                break;

            case "EXPENSE":
                context.noAccess();

                break;

            case "BUDGET":
                context.noAccess();

                break;



            // TODO

            default:
                throw new UnknownFieldException(context);
        }
    }

    @Override
    protected void checkPermissionTasks(Context context) throws AuthorizationException {
        switch (context.getFieldForSwitch()) {
            case "DESCRIPTION":
                context.noAccess();

                break;

            case "DETAILS":
                context.noAccess();

                break;

            case "TITLE":
                context.noAccess();

                break;


            case "STREET":
                context.noAccess();

                break;

            case "CITY":
                context.noAccess();

                break;


            case "STATE":
                context.noAccess();

                break;

            case "ZIPCODE":
                context.noAccess();

                break;


            case "COUNTRY":
                context.noAccess();

                break;

            case "STARTDATE":
                context.noAccess();

                break;

            case "ENDDATE":
                context.noAccess();

                break;

            case "COMPLETE":
                context.noAccess();

                break;

            case "MANAGER":
                context.noAccess();

                break;


            // TODO

            default:
                throw new UnknownFieldException(context);
        }
    }

    @Override
    protected void checkPermissionIncome(Context context) throws AuthorizationException {
        switch (context.getFieldForSwitch()) {
            case "DESCRIPTION":
                context.noAccess();

                break;

            case "DATE":
                context.noAccess();

                break;

            case "time":
                context.noAccess();

                break;

            case "VALUE":
                context.noAccess();

                break;



            // TODO

            default:
                throw new UnknownFieldException(context);
        }
    }

    @Override
    protected void checkPermissionExpense(Context context) throws AuthorizationException {
        switch (context.getFieldForSwitch()) {
            case "DESCRIPTION":
                context.noAccess();

                break;

            case "DATE":
                context.noAccess();

                break;

            case "VALUE":
                context.noAccess();

                break;



            // TODO

            default:
                throw new UnknownFieldException(context);
        }
    }
}
