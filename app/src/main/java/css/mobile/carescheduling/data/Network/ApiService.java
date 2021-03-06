package css.mobile.carescheduling.data.Network;

import css.mobile.carescheduling.Ui.Dashboard.beans.AllHomeData;
import css.mobile.carescheduling.Ui.Dashboard.beans.ClientBookingListModel;
import css.mobile.carescheduling.Ui.Dashboard.beans.EditMyProfile;
import css.mobile.carescheduling.Ui.Dashboard.beans.GetMyProfileHome;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ClientCareContactsBean;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ClientCareDocumentBean;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ClientCareMedicalBean;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ClientCareNoteBean;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ClientCarePersonalDetailsBean;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ClientCarePlan;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ClientCareSummaryBean;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ClientDisabilityBean;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ClientInfoCarePlanRetro;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ClientTaskRetroBean;
import css.mobile.carescheduling.Ui.HomeScreen.beans.EmployeeClientVisitForArrivalRetro;
import css.mobile.carescheduling.Ui.HomeScreen.beans.EmployeeClientVisitForDepartureRetro;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ManualForDepartureRetro;
import css.mobile.carescheduling.Ui.HomeScreen.beans.MatchingClientBarcodeForLoginRetro;
import css.mobile.carescheduling.Ui.HomeScreen.beans.MatchingClientNFCForLoginRetro;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ScanBean;
import css.mobile.carescheduling.Ui.HomeScreen.beans.VisitArchiveRetroBean;
import css.mobile.carescheduling.Ui.LoginActivity.beans.LoginBeanRetro;
import css.mobile.carescheduling.Ui.Profile.bean.AddAddressBeanRetro;
import css.mobile.carescheduling.Ui.Profile.bean.AddEmailBeanRetro;
import css.mobile.carescheduling.Ui.Profile.bean.AddImageBeanRetro;
import css.mobile.carescheduling.Ui.Profile.bean.AddPhoneNumberBeanRetro;
import css.mobile.carescheduling.Ui.Profile.bean.AddressByPostCode;
import css.mobile.carescheduling.Ui.Profile.bean.ChangePasswordBeanRetro;
import css.mobile.carescheduling.Ui.Profile.bean.DeleteImageRetro;
import css.mobile.carescheduling.Ui.Profile.bean.EditAddressAllData;
import css.mobile.carescheduling.Ui.Profile.bean.EditAdressBeanRetro;
import css.mobile.carescheduling.Ui.Profile.bean.EditEmailRetroBean;
import css.mobile.carescheduling.Ui.Profile.bean.EditNumberBeanRetro;
import css.mobile.carescheduling.Ui.Profile.bean.EditProfileInfoBeanRetro;
import css.mobile.carescheduling.Ui.Profile.bean.EditUserWithUserNameRetro;
import css.mobile.carescheduling.Ui.Profile.bean.EditUserWithoutUserNameRetro;
import css.mobile.carescheduling.Ui.Profile.bean.GetMyPicturesEditBeanRetro;
import css.mobile.carescheduling.Ui.Profile.bean.GetMyProfileEdit;
import css.mobile.carescheduling.Ui.Profile.bean.PersonAddress;
import css.mobile.carescheduling.Ui.Profile.bean.PersonEmailList;
import css.mobile.carescheduling.Ui.Profile.bean.PersonPhoneList;
import css.mobile.carescheduling.Ui.Profile.bean.ProfileAllData;
import css.mobile.carescheduling.Ui.Profile.bean.ProfileImageRetro;
import css.mobile.carescheduling.Ui.Profile.bean.UserViewModel;
import com.google.gson.JsonElement;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    @GET("AuthenticateUser/{userEmail}/{userPassword}/")
    Observable<Response<LoginBeanRetro>> getUser(@Path("userEmail") String userEmail, @Path("userPassword") String userPassword);

    @GET("AuthenticateUser/{userEmail}/{userPassword}/{branch_id}")
    Observable<Response<JsonElement>> getClientDetail(@Path("userEmail") String userEmail, @Path("userPassword") String userPassword, @Path("branch_id") String branchId);

    // http://mobile.rota.services/CssMobileRestfulService.svc/GetMyProfileAllData/EC38283E-BE96-4B38-A66B-89FE3C882D90/5F98AF4F-25DC-4AC8-B867-C5072C100000/5F98AF4F-25DC-4AC8-B867-C5072C101011/""
    @GET("GetMyProfileAllData/{person_id}/{customer_id}/{branch_id}/{ImageSize}")
    Observable<Response<ProfileAllData>> getProfileAllData(@Path("person_id") String PersonId, @Path("customer_id") String CustomerId, @Path("branch_id") String BranchId, @Path("ImageSize") String ImageSize);

    @GET("GetProfileImage/{person_id}/{branch_id}/{customer_id}/Small")
    Observable<Response<ProfileImageRetro>> getProfileImages(@Path("person_id") String PersonId, @Path("customer_id") String CustomerId, @Path("branch_id") String BranchId);

    @GET("GetHomeAllData/{person_id}/{customerId}/{branch_id}")
    Observable<Response<AllHomeData>> GetAllHomeData(
            @Path("person_id") String PersonId,
            @Path("customerId") String customerId,
            @Path("branch_id") String BranchId);


    @GET("GetCustomerWithoutAddressByCustomerId/{customer_id}")
    Observable<Response<EditMyProfile>> editMyProfile(@Path("customer_id") String customerId);

    @GET("GetAddressByCountryNameAndPostCode/{countryName}/{postalCode}")
    Observable<Response<AddressByPostCode>> fetchAddressByPostalCode(@Path("countryName") String countryName, @Path("postalCode") String postalCode);

    @GET("GetUser/{person_id}/{branch_id}/{customerId}")
    Observable<Response<UserViewModel>> getUserInfo(@Path("person_id") String PersonId, @Path("branch_id") String BranchId, @Path("customerId") String customerId);

    @GET("CheckIfUsernameExist/{userName}/{branch_id}/{customerId}/{person_id}")
    Observable<Response<JsonElement>> checkUserName(@Path("userName") String userName,
                                                    @Path("customerId") String customerId,
                                                    @Path("person_id") String PersonId,
                                                    @Path("branch_id") String BranchId);


    @POST("EditUser")
    Observable<Response<JsonElement>> EditMyUserWithOutUserName(@Body EditUserWithoutUserNameRetro profileBean);

    @POST("EditUser")
    Observable<Response<JsonElement>> EditMyUserWithUserName(@Body EditUserWithUserNameRetro profileBean);

    @POST("ResetUserPassword")
    Observable<Response<JsonElement>> ChangePassword(@Body ChangePasswordBeanRetro changePasswordBeanRetro);

//http://mobile.rota.services/CssMobileRestfulService.svc/ResetUserPassword
//    http://mobile.rota.services/CssMobileRestfulService.svc/EditProfileImages

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

    @GET("GetClientMedicals/{customerId}/{branchId}/{clientId}")
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

//http://mobile.rota.services/CssMobileRestfulService.svc/GetMyProfileHome/EC38283E-BE96-4B38-A66B-89FE3C882D90/5F98AF4F-25DC-4AC8-B867-C5072C100000/5F98AF4F-25DC-4AC8-B867-C5072C101011


    @GET("GetMyProfileHome/{personId}/{customerId}/{branchId}")
    Observable<Response<GetMyProfileHome>> GetMyProfileHome(
            @Path("personId") String clientId,
            @Path("customerId") String customerId,
            @Path("branchId") String branchId);

    //    GetMyProfileEdit
//    http://mobile.rota.services/CssMobileRestfulService.svc/GetMyProfileEdit/EC38283E-BE96-4B38-A66B-89FE3C882D90/5F98AF4F-25DC-4AC8-B867-C5072C100000/5F98AF4F-25DC-4AC8-B867-C5072C101011
    @GET("GetMyProfileEdit/{personId}/{customerId}/{branchId}")
    Observable<Response<GetMyProfileEdit>> GetMyProfileEdit(
            @Path("personId") String clientId,
            @Path("customerId") String customerId,
            @Path("branchId") String branchId);

    @POST("UpdateMyProfile")
    Observable<Response<JsonElement>> UpdateMyProfile(
            @Body EditProfileInfoBeanRetro editProfileInfoBeanRetro);

    //    http://mobile.rota.services/CssMobileRestfulService.svc/GetMyAddressEdit/EC38283E-BE96-4B38-A66B-89FE3C882D90/5F98AF4F-25DC-4AC8-B867-C5072C100000/5F98AF4F-25DC-4AC8-B867-C5072C101011
    @GET("GetMyAddressEdit/{personId}/{customerId}/{branchId}")
    Observable<Response<EditAddressAllData>> GetMyAddressEdit(
            @Path("personId") String clientId,
            @Path("customerId") String customerId,
            @Path("branchId") String branchId);

    @POST("DeletePhone")
    Observable<Response<JsonElement>> DeletePhone(
            @Body PersonPhoneList personPhoneList);

    @POST("DeleteAddress")
    Observable<Response<JsonElement>> DeleteAddress(
            @Body PersonAddress personAddressList);

    @POST("DeleteEmail")
    Observable<Response<JsonElement>> DeleteEmail(
            @Body PersonEmailList personEmailList);

    //    http://mobile.rota.services/CssMobileRestfulService.svc/GetMyPicturesEdit/EC38283E-BE96-4B38-A66B-89FE3C882D90/5F98AF4F-25DC-4AC8-B867-C5072C100000/5F98AF4F-25DC-4AC8-B867-C5072C101011
    @GET("GetMyPicturesEdit/{personId}/{customerId}/{branchId}")
    Observable<Response<GetMyPicturesEditBeanRetro>> GetMyPicturesEdit(
            @Path("personId") String clientId,
            @Path("customerId") String customerId,
            @Path("branchId") String branchId);

    @POST("DeleteUserImage")
    Observable<Response<JsonElement>> DeleteUserImage(
            @Body DeleteImageRetro personEmailList);

    @POST("AddUserImage")
    Observable<Response<JsonElement>> AddUserImage(
            @Body AddImageBeanRetro personEmailList);

    @POST("AddPhone")
    Observable<Response<JsonElement>> AddPhone(
            @Body AddPhoneNumberBeanRetro addPhoneNumberBeanRetro);

    @POST("AddEmail")
    Observable<Response<JsonElement>> AddEmail(
            @Body AddEmailBeanRetro addEmailBeanRetro);

    @POST("EditPhone")
    Observable<Response<JsonElement>> EditPhone(
            @Body EditNumberBeanRetro editNumberBeanRetro);

    @POST("EditEmail")
    Observable<Response<JsonElement>> EditEmail(
            @Body EditEmailRetroBean editEmailRetroBean);

    @POST("AddAddress")
    Observable<Response<JsonElement>> AddAddress(
            @Body AddAddressBeanRetro addAddressBeanRetro);

    @POST("EditAddress")
    Observable<Response<JsonElement>> EditAddress(
            @Body EditAdressBeanRetro editAdressBeanRetro);

    @GET("GetTodayClientTaskList/{clientId}/{branchId}/{customerId}")
//    @GET("GetTodayClientTaskList/EC38283E-BE96-4B38-A66B-89FE3C882D90/5F98AF4F-25DC-4AC8-B867-C5072C101011/5f98af4f-25dc-4ac8-b867-c5072c100000")
    Observable<Response<ClientTaskRetroBean>> GetClientTask(@Path("customerId") String customerId,
                                                            @Path("branchId") String branchId,
                                                            @Path("clientId") String clientId);

    @POST("UpdateUserImage")
    Observable<Response<JsonElement>> UpdateUserImage(
            @Body DeleteImageRetro personEmailList);

    @POST("MatchingClientNFCForLogin")
    Observable<Response<ScanBean>> MatchingClientNFCForLogin(
            @Body MatchingClientNFCForLoginRetro matchingClientNFCForLoginRetro);

    @POST("MatchingClientBarcodeForLoginAndLogout")
    Observable<Response<ScanBean>> MatchingClientBarcodeForLogin(
            @Body MatchingClientBarcodeForLoginRetro matchingClientNFCForLoginRetro);

    @POST("EmployeeClientVisitForArrival")
    Observable<Response<JsonElement>> EmployeeClientVisitForArrival(
            @Body ArrayList<EmployeeClientVisitForArrivalRetro> employeeClientVisitForArrivalRetro);

    @POST("EmployeeClientVisitForDeparture")
    Observable<Response<JsonElement>> EmployeeClientVisitForDepartureManual(
            @Body ManualForDepartureRetro manualForDepartureRetro);

    @POST("EmployeeClientVisitForDeparture")
    Observable<Response<JsonElement>> EmployeeClientVisitForDeparture(
            @Body EmployeeClientVisitForDepartureRetro employeeClientVisitForDepartureRetro);
}
