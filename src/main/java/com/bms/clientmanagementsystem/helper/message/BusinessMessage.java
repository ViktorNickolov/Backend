package com.bms.clientmanagementsystem.helper.message;

public class BusinessMessage {
    public static final String ILLEGAL_STATE_EXCEPTION = "Utility class, cannot be instantiated";
    private BusinessMessage(){
        throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
    }

    public static class Appointment{
        private Appointment(){
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }

        public static final String APPOINTMENT_NOT_FOUND = "Appointment not found";
        public static final String APPOINTMENT_LIST_EMPTY = "Appointment list is empty";
    }

    public static class Document{
        private Document(){
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }

        public static final String DOCUMENT_NOT_FOUND = "Document not found";
        public static final String DOCUMENT_LIST_EMPTY = "Document list is empty";
    }
    public static class Client{
        private Client(){
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }

        public static final String Client_NOT_FOUND = "Client not found";
        public static final String Client_LIST_EMPTY = "Client list is empty";
        public static final String Client_ALREADY_EXISTS = "Client already exists";
    }

    public static class ClientCase{
        private ClientCase(){
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }

        public static final String Client_CASE_NOT_FOUND = "Client case not found";
        public static final String Client_CASE_LIST_EMPTY = "Client case list is empty";
    }

    public static class Status{
        private Status(){
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }

        public static final String STATUS_NOT_FOUND = "Status not found";
        public static final String STATUS_LIST_EMPTY = "Status list is empty";
        public static final String STATUS_ALREADY_EXISTS = "Status already exists";
    }

    public static class StatusHistory{
        private StatusHistory(){
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }

        public static final String STATUS_HISTORY_NOT_FOUND = "Status history not found";
        public static final String STATUS_HISTORY_LIST_EMPTY = "Status history list is empty";
    }
}
