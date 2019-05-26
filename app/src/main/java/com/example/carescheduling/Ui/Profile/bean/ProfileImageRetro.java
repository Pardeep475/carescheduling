package com.example.carescheduling.Ui.Profile.bean;
import java.util.ArrayList;
import java.util.List;
public class ProfileImageRetro {

        private String Data;

        public List<DataList> DataList;

        private String Exception;

        private String ResponseMessage;

        private boolean Success;

        public void setData(String Data){
        this.Data = Data;
    }
        public String getData(){
        return this.Data;
    }
        public void setDataList(List<DataList> DataList){
        this.DataList = DataList;
    }
        public List<DataList> getDataList(){
        return this.DataList;
    }
        public void setException(String Exception){
        this.Exception = Exception;
    }
        public String getException(){
        return this.Exception;
    }
        public void setResponseMessage(String ResponseMessage){
        this.ResponseMessage = ResponseMessage; }
        public String getResponseMessage(){
        return this.ResponseMessage;
    }
        public void setSuccess(boolean Success){
        this.Success = Success;
    }
        public boolean getSuccess(){
        return this.Success;
    }





}
