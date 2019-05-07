package com.example.carescheduling.data.Network;

import com.example.carescheduling.Ui.Dashboard.beans.EditMyProfile;
import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.LoginActivity.beans.LoginBeanRetro;
import com.example.carescheduling.Ui.Profile.bean.AddressByPostCode;
import com.google.gson.JsonElement;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    @GET("AuthenticateUser/{userEmail}/{userPassword}/")
    Observable<Response<LoginBeanRetro>> getUser(@Path("userEmail") String userEmail, @Path("userPassword") String userPassword);

    @GET("AuthenticateUser/{userEmail}/{userPassword}/{branch_id}")
    Observable<Response<JsonElement>> getClientDetail(@Path("userEmail") String userEmail, @Path("userPassword") String userPassword, @Path("branch_id") String branchId);

    @GET("GetMyProfile/{person_id}/{customer_id}/{branch_id}")
    Observable<Response<ProfileBean>> getProfile(@Path("person_id") String PersonId, @Path("customer_id") String CustomerId, @Path("branch_id") String BranchId);

    @GET("GetCustomerWithoutAddressByCustomerId/{customer_id}")
    Observable<Response<EditMyProfile>> editMyProfile(@Path("customer_id") String customerId);

    @GET("GetAddressByCountryNameAndPostCode/{countryName}/{postalCode}")
    Observable<Response<AddressByPostCode>> fetchAddressByPostalCode(@Path("countryName") String countryName, @Path("postalCode") String postalCode);

    @POST("EditMyProfile")
    Observable<Response<ProfileBean>> editMyProfilePost(@Body ProfileBean.Data profileBean);
}
