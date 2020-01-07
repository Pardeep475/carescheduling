package css.mobile.carescheduling.Ui.HomeScreen.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class VisitArchiveRetroBean {

    @SerializedName("Data")
    @Expose
    private Object data;
    @SerializedName("DataList")
    @Expose
    private ArrayList<DataList> dataList = null;
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

    public ArrayList<DataList> getDataList() {
        return dataList;
    }

    public void setDataList(ArrayList<DataList> dataList) {
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

    public class DataList {

        @SerializedName("BookingDate")
        @Expose
        private String bookingDate;
        @SerializedName("BookingEndTime")
        @Expose
        private String bookingEndTime;
        @SerializedName("BookingStartTime")
        @Expose
        private String bookingStartTime;
        @SerializedName("ClientBookingId")
        @Expose
        private Object clientBookingId;
        @SerializedName("ClientName")
        @Expose
        private String clientName;
        @SerializedName("ClientPersonId")
        @Expose
        private String clientPersonId;
        @SerializedName("ClientPhoneNumber")
        @Expose
        private String clientPhoneNumber;
        @SerializedName("ClientEmailAddress")
        @Expose
        private Object emailAddress;
        @SerializedName("ImageHexString")
        @Expose
        private Object imageHexString;
        @SerializedName("ClientAddress")
        @Expose
        private String personAddress;
        @SerializedName("Weekdayname")
        @Expose
        private String weekdayname;

        public String getBookingDate() {
            return bookingDate;
        }

        public void setBookingDate(String bookingDate) {
            this.bookingDate = bookingDate;
        }

        public String getBookingEndTime() {
            return bookingEndTime;
        }

        public void setBookingEndTime(String bookingEndTime) {
            this.bookingEndTime = bookingEndTime;
        }

        public String getBookingStartTime() {
            return bookingStartTime;
        }

        public void setBookingStartTime(String bookingStartTime) {
            this.bookingStartTime = bookingStartTime;
        }

        public Object getClientBookingId() {
            return clientBookingId;
        }

        public void setClientBookingId(Object clientBookingId) {
            this.clientBookingId = clientBookingId;
        }

        public String getClientName() {
            return clientName;
        }

        public void setClientName(String clientName) {
            this.clientName = clientName;
        }

        public String getClientPersonId() {
            return clientPersonId;
        }

        public void setClientPersonId(String clientPersonId) {
            this.clientPersonId = clientPersonId;
        }

        public String getClientPhoneNumber() {
            return clientPhoneNumber;
        }

        public void setClientPhoneNumber(String clientPhoneNumber) {
            this.clientPhoneNumber = clientPhoneNumber;
        }

        public Object getEmailAddress() {
            return emailAddress;
        }

        public void setEmailAddress(Object emailAddress) {
            this.emailAddress = emailAddress;
        }

        public Object getImageHexString() {
            return imageHexString;
        }

        public void setImageHexString(Object imageHexString) {
            this.imageHexString = imageHexString;
        }

        public String getPersonAddress() {
            return personAddress;
        }

        public void setPersonAddress(String personAddress) {
            this.personAddress = personAddress;
        }

        public String getWeekdayname() {
            return weekdayname;
        }

        public void setWeekdayname(String weekdayname) {
            this.weekdayname = weekdayname;
        }


    }
}