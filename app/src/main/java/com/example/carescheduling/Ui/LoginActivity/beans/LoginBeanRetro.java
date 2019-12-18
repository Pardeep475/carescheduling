package com.example.carescheduling.Ui.LoginActivity.beans;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class LoginBeanRetro implements Serializable {

    private Object DataList;

    private Data Data;

    private String ResponseMessage;

    private Object Exception;

    private boolean Success;

    public Object getDataList ()
    {
        return DataList;
    }

    public void setDataList (Object DataList)
    {
        this.DataList = DataList;
    }

    public Data getData ()
    {
        return Data;
    }

    public void setData (Data Data)
    {
        this.Data = Data;
    }

    public String getResponseMessage ()
    {
        return ResponseMessage;
    }

    public void setResponseMessage (String ResponseMessage)
    {
        this.ResponseMessage = ResponseMessage;
    }

    public Object getException ()
    {
        return Exception;
    }

    public void setException (Object Exception)
    {
        this.Exception = Exception;
    }

    public boolean getSuccess ()
    {
        return Success;
    }

    public void setSuccess (boolean Success)
    {
        this.Success = Success;
    }

    public class Data implements Serializable {
        private String UserName;

        private String PersonId;

        private ArrayList<BranchList> BranchList;

        private String CustomerId;

        private String CreateDate;

        public String getUserName ()
        {
            return UserName;
        }

        public void setUserName (String UserName)
        {
            this.UserName = UserName;
        }

        public String getPersonId ()
        {
            return PersonId;
        }

        public void setPersonId (String PersonId)
        {
            this.PersonId = PersonId;
        }

        public ArrayList<BranchList> getBranchList ()
        {
            return BranchList;
        }

        public void setBranchList (ArrayList<BranchList> BranchList)
        {
            this.BranchList = BranchList;
        }

        public String getCustomerId ()
        {
            return CustomerId;
        }

        public void setCustomerId (String CustomerId)
        {
            this.CustomerId = CustomerId;
        }

        public String getCreateDate ()
        {
            return CreateDate;
        }

        public void setCreateDate (String CreateDate)
        {
            this.CreateDate = CreateDate;
        }
    }

    public class BranchList implements Serializable {
        private String BranchId;

        private String BranchName;

        public String getBranchId ()
        {
            return BranchId;
        }

        public void setBranchId (String BranchId)
        {
            this.BranchId = BranchId;
        }

        public String getBranchName ()
        {
            return BranchName;
        }

        public void setBranchName (String BranchName)
        {
            this.BranchName = BranchName;
        }

    }

}
