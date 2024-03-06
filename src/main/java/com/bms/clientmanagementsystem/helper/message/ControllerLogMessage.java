package com.bms.clientmanagementsystem.helper.message;

public class ControllerLogMessage {
    private ControllerLogMessage() {
        throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
    }

    public static class Appointment {
        private Appointment() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String APPOINTMENT_CREATE = "Appointment API: Create Appointment";
        public static final String APPOINTMENT_UPDATE = "Appointment API: Update Appointment";
        public static final String APPOINTMENT_DELETE = "Appointment API: Delete Appointment";
        public static final String APPOINTMENT_FIND = "Appointment API: Find Appointment";
        public static final String APPOINTMENT_FIND_ALL = "Appointment API: Find All Appointment";
    }

    public static class Document {
        private Document() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String DOCUMENT_PDF_CREATE = "Document API: Create PDF Document";
        public static final String DOCUMENT_CREATE = "Document API: Create Document";
        public static final String DOCUMENT_UPDATE = "Document API: Update Document";
        public static final String DOCUMENT_DELETE = "Document API: Delete Document";
        public static final String DOCUMENT_FIND = "Document API: Find Document";
        public static final String DOCUMENT_FIND_ALL = "Document API: Find All Document";
    }

    public static class Client {
        private Client() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String Client_CREATE = "Client API: Create Client";
        public static final String Client_UPDATE = "Client API: Update Client";
        public static final String Client_DELETE = "Client API: Delete Client";
        public static final String Client_FIND = "Client API: Find Client";
        public static final String Client_FIND_ALL = "Client API: Find All Client";
    }

    public static class ClientCase {
        private ClientCase() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String Client_CASE_CREATE = "ClientCase API: Create ClientCase";
        public static final String Client_CASE_UPDATE = "ClientCase API: Update ClientCase";
        public static final String Client_CASE_FIND = "ClientCase API: Find ClientCase";
        public static final String Client_CASE_FIND_ALL = "ClientCase API: Find All ClientCase";
        public static final String Client_CASE_COMPLETE = "ClientCase API: Complete ClientCase";
        public static final String Client_CASE_PDF = "ClientCase API: Generate PDF for ClientCase";
    }

    public static class Status {
        private Status() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String STATUS_CREATE = "Status API: Create Status";
        public static final String STATUS_UPDATE = "Status API: Update Status";
        public static final String STATUS_DELETE = "Status API: Delete Status";
        public static final String STATUS_FIND = "Status API: Find Status";
        public static final String STATUS_FIND_ALL = "Status API: Find All Status";
    }

    public static class StatusHistory {
        private StatusHistory() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String STATUS_HISTORY_CREATE = "StatusHistory API: Create StatusHistory";
        public static final String STATUS_HISTORY_UPDATE = "StatusHistory API: Update StatusHistory";
        public static final String STATUS_HISTORY_DELETE = "StatusHistory API: Delete StatusHistory";
        public static final String STATUS_HISTORY_FIND = "StatusHistory API: Find StatusHistory";
        public static final String STATUS_HISTORY_FIND_ALL = "StatusHistory API: Find All StatusHistory";
    }
}
