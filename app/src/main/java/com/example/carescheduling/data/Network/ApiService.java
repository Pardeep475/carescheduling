package com.example.carescheduling.data.Network;

import com.example.carescheduling.Ui.Dashboard.beans.ClientBookingListModel;
import com.example.carescheduling.Ui.Dashboard.beans.EditMyProfile;
import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientCareContactsBean;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientCareDocumentBean;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientCareMedicalBean;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientCareNoteBean;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientCarePersonalDetailsBean;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientCarePlan;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientCareSummaryBean;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientDisabilityBean;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientInfoCarePlanRetro;
import com.example.carescheduling.Ui.HomeScreen.beans.VisitArchiveRetroBean;
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

    @GET("GetProfileImage/{person_id}/{branch_id}/{customer_id}/Small")
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
    Observable<Response<ProfileImageRetro>> EditMyImages(@Body ProfileBean.Data profileImageRetro);

    //    "GetNextVisitClientBookingList/{employeeId}/{branchId}/{customerId}"
    @GET("GetNextVisitClientBookingList/{employeeId}/{branchId}/{customerId}")
    Observable<Response<ClientBookingListModel>> GetNextVisitClientBookingList(@Path("employeeId") String employeeId,
                                                                               @Path("branchId") String branchId,
                                                                               @Path("customerId") String customerId);

    @GET("GetClientAndClientCarePlan/{customerId}/{branchId}/{clientId}")
    Observable<Response<ClientCarePlan>> GetClientAndClientCarePlan(@Path("customerId") String customerId,
                                                                    @Path("branchId") String branchId,
                                                                    @Path("clientId") String clientId);


    @GET("GetClientSummary/{customerId}/{branchId}/{clientId}")
    Observable<Response<ClientCareSummaryBean>> GetClientSummary(@Path("customerId") String customerId,
                                                                 @Path("branchId") String branchId,
                                                                 @Path("clientId") String clientId);

    @GET("GetClientPersonDetail/{customerId}/{branchId}/{clientId}")
    Observable<Response<ClientCarePersonalDetailsBean>> GetClientPersonDetail(@Path("customerId") String customerId,
                                                                              @Path("branchId") String branchId,
                                                                              @Path("clientId") String clientId);

    @GET("GetClientNotes/{customerId}/{branchId}/{clientId}")
    Observable<Response<ClientCareNoteBean>> GetClientNotes(@Path("customerId") String customerId,
                                                            @Path("branchId") String branchId,
                                                            @Path("clientId") String clientId);

    @GET("GetClientContacts/{customerId}/{branchId}/{clientId}")
    Observable<Response<ClientCareContactsBean>> GetClientContacts(@Path("customerId") String customerId,
                                                                   @Path("branchId") String branchId,
                                                                   @Path("clientId") String clientId);

    @GET("GetClientDocuments/{customerId}/{branchId}/{clientId}")
    Observable<Response<ClientCareDocumentBean>> GetClientDocuments(@Path("customerId") String customerId,
                                                                    @Path("branchId") String branchId,
                                                                    @Path("clientId") String clientId);

    @GET("GetClientMadicals/{customerId}/{branchId}/{clientId}")
    Observable<Response<ClientCareMedicalBean>> GetClientMedical(@Path("customerId") String customerId,
                                                                 @Path("branchId") String branchId,
                                                                 @Path("clientId") String clientId);


    @GET("GetClientDisabilities/{customerId}/{branchId}/{clientId}")
    Observable<Response<ClientDisabilityBean>> GetClientDisabilities(@Path("customerId") String customerId,
                                                                     @Path("branchId") String branchId,
                                                                     @Path("clientId") String clientId);

    @GET("GetClientCareplanSchedule/{customerId}/{branchId}/{clientId}")
    Observable<Response<ClientInfoCarePlanRetro>> GetClientCarePlanSchedule(@Path("customerId") String customerId,
                                                                            @Path("branchId") String branchId,
                                                                            @Path("clientId") String clientId);


    //  employeeId,arrivalDate,branchId,customerId
//    @GET("GetEmployeeVisitArchive/5633D002-F453-402E-AD63-AAECA11452B5/2019-05-24/5F98AF4F-25DC-4AC8-B867-C5072C101011/5f98af4f-25dc-4ac8-b867-c5072c100000")
    @GET("GetEmployeeVisitArchive/{clientId}/{arrivalDate}/{branchId}/{customerId}")
    Observable<Response<VisitArchiveRetroBean>> GetEmployeeVisitArchive(
            @Path("clientId") String clientId,
            @Path("arrivalDate") String arrivalDate,
            @Path("branchId") String branchId,
            @Path("customerId") String customerId);

//89a31092-d483-4d4d-adbe-72e5e14934bd/2019-05-24/5F98AF4F-25DC-4AC8-B867-C5072C101011/5f98af4f-25dc-4ac8-b867-c5072c100000
}
