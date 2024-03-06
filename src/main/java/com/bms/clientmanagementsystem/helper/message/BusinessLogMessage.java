package com.bms.clientmanagementsystem.helper.message;

public class BusinessLogMessage {
    private BusinessLogMessage() {
        throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
    }

    public static class Pdf {
        private Pdf() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PDF_GENERATED = "PDF Generated";
    }

    public static class Appointment {
        private Appointment() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String APPOINTMENT_CREATED = "Appointment created successfully";
        public static final String APPOINTMENT_UPDATED = "Appointment updated successfully : {}";
        public static final String APPOINTMENT_DELETED = "Appointment deleted successfully : {}";
        public static final String APPOINTMENT_FOUND = "Appointment found successfully : {}";
        public static final String APPOINTMENT_LIST_FOUND = "Appointment list found successfully";
        public static final String APPOINTMENT_NOT_FOUND = "Appointment not found : {}";
        public static final String APPOINTMENT_LIST_EMPTY = "Appointment list is empty";
    }

    public static class Document {
        private Document() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String DOCUMENT_PDF_CREATED = "Document PDF created successfully : {}";
        public static final String DOCUMENT_CREATED = "Document created successfully";
        public static final String DOCUMENT_UPDATED = "Document updated successfully : {}";
        public static final String DOCUMENT_DELETED = "Document deleted successfully : {}";
        public static final String DOCUMENT_FOUND = "Document found successfully : {}";
        public static final String DOCUMENT_LIST_FOUND = "Document list found successfully";
        public static final String DOCUMENT_NOT_FOUND = "Document not found : {}";
        public static final String DOCUMENT_LIST_EMPTY = "Document list is empty";
    }

    public static class Client {
        private Client() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String Client_CREATED = "Client created successfully";
        public static final String Client_UPDATED = "Client updated successfully : {}";
        public static final String Client_DELETED = "Client deleted successfully : {}";
        public static final String Client_FOUND = "Client found successfully : {}";
        public static final String Client_LIST_FOUND = "Client list found successfully";
        public static final String Client_NOT_FOUND = "Client not found : {}";
        public static final String Client_LIST_EMPTY = "Client list is empty";
        public static final String Client_ALREADY_EXISTS = "Client already exists : {}";
    }

    public static class ClientCase {
        private ClientCase() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String Client_CASE_DOCUMENT_CREATED = "Client case document created successfully";
        public static final String Client_CASE_COMPLETED = "Client case completed successfully : {}";
        public static final String Client_CASE_CREATED = "Client case created successfully";
        public static final String Client_CASE_UPDATED = "Client case updated successfully : {}";
        public static final String Client_CASE_FOUND = "Client case found successfully : {}";
        public static final String Client_CASE_LIST_FOUND = "Client case list found successfully";
        public static final String Client_CASE_NOT_FOUND = "Client case not found : {}";
        public static final String Client_CASE_LIST_EMPTY = "Client case list is empty";
    }

    public static class Status {
        private Status() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String STATUS_CREATED = "Status created successfully";
        public static final String STATUS_UPDATED = "Status updated successfully : {}";
        public static final String STATUS_DELETED = "Status deleted successfully : {}";
        public static final String STATUS_FOUND = "Status found successfully : {}";
        public static final String STATUS_LIST_FOUND = "Status list found successfully";
        public static final String STATUS_NOT_FOUND = "Status not found : {}";
        public static final String STATUS_LIST_EMPTY = "Status list is empty";
        public static final String STATUS_ALREADY_EXISTS = "Status already exists : {}";
    }

    public static class StatusHistory {
        private StatusHistory() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String STATUS_HISTORY_CREATED = "Status history created successfully";
        public static final String STATUS_HISTORY_UPDATED = "Status history updated successfully : {}";
        public static final String STATUS_HISTORY_DELETED = "Status history deleted successfully : {}";
        public static final String STATUS_HISTORY_FOUND = "Status history found successfully : {}";
        public static final String STATUS_HISTORY_LIST_FOUND = "Status history list found successfully";
        public static final String STATUS_HISTORY_NOT_FOUND = "Status history not found : {}";
        public static final String STATUS_HISTORY_LIST_EMPTY = "Status history list is empty";
    }
}
