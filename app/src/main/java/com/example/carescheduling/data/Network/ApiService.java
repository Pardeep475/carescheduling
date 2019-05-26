package com.example.carescheduling.data.Network;

import com.example.carescheduling.Ui.Dashboard.beans.ClientBookingListModel;
import com.example.carescheduling.Ui.Dashboard.beans.EditMyProfile;
import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientCarePlan;
import com.example.carescheduling.Ui.LoginActivity.beans.LoginBeanRetro;
import com.example.carescheduling.Ui.Profile.bean.AddressByPostCode;
import com.example.carescheduling.Ui.Profile.bean.DataList;
import com.example.carescheduling.Ui.Profile.bean.ProfileImageRetro;
import com.example.carescheduling.Ui.Profile.bean.UserViewModel;
import com.google.gson.JsonElement;

import java.util.List;

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

    //    @GET("GetMyProfile/{person_id}/{customer_id}/{branch_id}")
    @GET("GetMyProfileWithoutPersonImages/{person_id}/{customer_id}/{branch_id}")
    Observable<Response<ProfileBean>> getProfile(@Path("person_id") String PersonId, @Path("customer_id") String CustomerId, @Path("branch_id") String BranchId);

    @GET("GetProfileImage/{person_id}/{customer_id}/{branch_id}/Small")
    Observable<Response<ProfileImageRetro>> getProfileImages(@Path("person_id") String PersonId, @Path("customer_id") String CustomerId, @Path("branch_id") String BranchId);


    @GET("GetCustomerWithoutAddressByCustomerId/{customer_id}")
    Observable<Response<EditMyProfile>> editMyProfile(@Path("customer_id") String customerId);

    @GET("GetAddressByCountryNameAndPostCode/{countryName}/{postalCode}")
    Observable<Response<AddressByPostCode>> fetchAddressByPostalCode(@Path("countryName") String countryName, @Path("postalCode") String postalCode);

    @GET("GetUser/{person_id}/{branch_id}")
    Observable<Response<UserViewModel>> getUserInfo(@Path("person_id") String PersonId, @Path("branch_id") String BranchId);

    @GET("CheckIfUsernameExist/{userName}/{branch_id}/{customerId}/{person_id}")
    Observable<Response<JsonElement>> checkUserName(@Path("userName") String userName,
                                                    @Path("customerId") String customerId,
                                                    @Path("person_id") String PersonId,
                                                    @Path("branch_id") String BranchId);

    @POST("EditMyProfile")
    Observable<Response<ProfileBean>> editMyProfilePost(@Body ProfileBean.Data profileBean);


    @POST("EditUser")
    Observable<Response<JsonElement>> EditMyUser(@Body UserViewModel.Data profileBean);

//    http://mobile.rota.services/CssMobileRestfulService.svc/EditProfileImages

    @POST("EditProfileImages")
    Observable<Response<ProfileImageRetro>> EditMyImages(@Body DataList profileImageRetro);

    //    "GetNextVisitClientBookingList/{employeeId}/{branchId}/{customerId}"
    @GET("GetNextVisitClientBookingList/{employeeId}/{branchId}/{customerId}")
    Observable<Response<ClientBookingListModel>> GetNextVisitClientBookingList(@Path("employeeId") String employeeId,
                                                                               @Path("branchId") String branchId,
                                                                               @Path("customerId") String customerId);

    @GET("GetClientAndClientCarePlan/{customerId}/{branchId}/{clientId}")
    Observable<Response<ClientCarePlan>> GetClientAndClientCarePlan(@Path("customerId") String customerId,
                                                                    @Path("branchId") String branchId,
                                                                    @Path("clientId") String clientId);


}
