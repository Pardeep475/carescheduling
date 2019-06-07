package com.example.carescheduling.Ui.HomeScreen.beans;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientCareDocumentBean {

    @SerializedName("Data")
    @Expose
    private Object data = null;
    @SerializedName("DataList")
    @Expose
    private ArrayList<Datum> dataList;
    @SerializedName("Exception")
    @Expose
    private Object exception;
    @SerializedName("ResponseMessage")
    @Expose
    private Object responseMessage;
    @SerializedName("Success")
    @Expose
    private Boolean success;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ArrayList<Datum> getDataList() {
        return dataList;
    }

    public void setDataList(ArrayList<Datum> dataList) {
        this.dataList = dataList;
    }

    public Object getException() {
        return exception;
    }

    public void setException(Object exception) {
        this.exception = exception;
    }

    public Object getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(Object responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
    public class Datum {

        @SerializedName("By")
        @Expose
        private Object by;
        @SerializedName("Document")
        @Expose
        private Document document;
        @SerializedName("DocumentData")
        @Expose
        private String documentData;
        @SerializedName("DocumentFileHexString")
        @Expose
        private Object documentFileHexString;
        @SerializedName("Regarding")
        @Expose
        private Object regarding;

        public Object getBy() {
            return by;
        }

        public void setBy(Object by) {
            this.by = by;
        }

        public Document getDocument() {
            return document;
        }

        public void setDocument(Document document) {
            this.document = document;
        }

        public String getDocumentData() {
            return documentData;
        }

        public void setDocumentData(String documentData) {
            this.documentData = documentData;
        }

        public Object getDocumentFileHexString() {
            return documentFileHexString;
        }

        public void setDocumentFileHexString(Object documentFileHexString) {
            this.documentFileHexString = documentFileHexString;
        }

        public Object getRegarding() {
            return regarding;
        }

        public void setRegarding(Object regarding) {
            this.regarding = regarding;
        }

        public class Document {

            @SerializedName("AddedByPersonId")
            @Expose
            private String addedByPersonId;
            @SerializedName("CustomerId")
            @Expose
            private String customerId;
            @SerializedName("DocumentAdded")
            @Expose
            private String documentAdded;
            @SerializedName("DocumentCategoryName")
            @Expose
            private String documentCategoryName;
            @SerializedName("DocumentExpireDate")
            @Expose
            private Object documentExpireDate;
            @SerializedName("DocumentFile")
            @Expose
            private String documentFile;
            @SerializedName("DocumentFileTypeName")
            @Expose
            private String documentFileTypeName;
            @SerializedName("DocumentHasExpireDate")
            @Expose
            private Boolean documentHasExpireDate;
            @SerializedName("DocumentId")
            @Expose
            private String documentId;
            @SerializedName("DocumentLink")
            @Expose
            private String documentLink;
            @SerializedName("DocumentName")
            @Expose
            private String documentName;
            @SerializedName("DocumentTypeName")
            @Expose
            private String documentTypeName;
            @SerializedName("DocumentUpdated")
            @Expose
            private String documentUpdated;

            public String getAddedByPersonId() {
                return addedByPersonId;
            }

            public void setAddedByPersonId(String addedByPersonId) {
                this.addedByPersonId = addedByPersonId;
            }

            public String getCustomerId() {
                return customerId;
            }

            public void setCustomerId(String customerId) {
                this.customerId = customerId;
            }

            public String getDocumentAdded() {
                return documentAdded;
            }

            public void setDocumentAdded(String documentAdded) {
                this.documentAdded = documentAdded;
            }

            public String getDocumentCategoryName() {
                return documentCategoryName;
            }

            public void setDocumentCategoryName(String documentCategoryName) {
                this.documentCategoryName = documentCategoryName;
            }

            public Object getDocumentExpireDate() {
                return documentExpireDate;
            }

            public void setDocumentExpireDate(Object documentExpireDate) {
                this.documentExpireDate = documentExpireDate;
            }

            public String getDocumentFile() {
                return documentFile;
            }

            public void setDocumentFile(String documentFile) {
                this.documentFile = documentFile;
            }

            public String getDocumentFileTypeName() {
                return documentFileTypeName;
            }

            public void setDocumentFileTypeName(String documentFileTypeName) {
                this.documentFileTypeName = documentFileTypeName;
            }

            public Boolean getDocumentHasExpireDate() {
                return documentHasExpireDate;
            }

            public void setDocumentHasExpireDate(Boolean documentHasExpireDate) {
                this.documentHasExpireDate = documentHasExpireDate;
            }

            public String getDocumentId() {
                return documentId;
            }

            public void setDocumentId(String documentId) {
                this.documentId = documentId;
            }

            public String getDocumentLink() {
                return documentLink;
            }

            public void setDocumentLink(String documentLink) {
                this.documentLink = documentLink;
            }

            public String getDocumentName() {
                return documentName;
            }

            public void setDocumentName(String documentName) {
                this.documentName = documentName;
            }

            public String getDocumentTypeName() {
                return documentTypeName;
            }

            public void setDocumentTypeName(String documentTypeName) {
                this.documentTypeName = documentTypeName;
            }

            public String getDocumentUpdated() {
                return documentUpdated;
            }

            public void setDocumentUpdated(String documentUpdated) {
                this.documentUpdated = documentUpdated;
            }

        }
    }


}
