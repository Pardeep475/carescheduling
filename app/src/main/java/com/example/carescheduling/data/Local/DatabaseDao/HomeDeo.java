package com.example.carescheduling.data.Local.DatabaseDao;

import com.example.carescheduling.Ui.Dashboard.beans.ClientContactList;
import com.example.carescheduling.Ui.Dashboard.beans.ClientDisabilityList;
import com.example.carescheduling.Ui.Dashboard.beans.ClientDocumentList;
import com.example.carescheduling.Ui.Dashboard.beans.ClientMedicalForMobileList;
import com.example.carescheduling.Ui.Dashboard.beans.ClientNoteList;
import com.example.carescheduling.Ui.Dashboard.beans.ClientSummary;
import com.example.carescheduling.Ui.Dashboard.beans.ClientTaskList;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientBookingScreenModel;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface HomeDeo {

    // get All Booking ListModal
    @Query("SELECT * FROM ClientBookingScreenModel WHERE BookingId = :bookingId")
    LiveData<ClientBookingScreenModel> getAllClientBookingScreenModel(String bookingId);

    //    get ClientBookingScreenModel count
    @Query("SELECT COUNT(*) from ClientBookingScreenModel")
    int countClientBookingScreenModel();

    // insert all client Booking screen modal
    @Insert
    void insertClientBookingScreenModel(ClientBookingScreenModel... clientBookingScreenModel);

    //   delete All  ClientBookingScreenModel
    @Query("DELETE FROM ClientBookingScreenModel")
    public void deleteClientBookingScreenModel();

    // get All ClientContactList
    @Query("SELECT * FROM ClientContactList WHERE BookingId = :bookingId")
    LiveData<List<ClientContactList>> getAllClientContactList(String bookingId);

    //    get ClientContactList count
    @Query("SELECT COUNT(*) from ClientContactList")
    int countClientContactList();

    // insert all ClientContactList
    @Insert
    void insertClientContactList(ClientContactList... clientContactList);

    //   delete All  ClientContactList
    @Query("DELETE FROM ClientContactList")
    public void deleteClientContactList();

    // get All ClientDisabilityList
    @Query("SELECT * FROM ClientDisabilityList WHERE BookingId = :bookingId")
    LiveData<List<ClientDisabilityList>> getAllClientDisabilityList(String bookingId);

    //    get ClientDisabilityList count
    @Query("SELECT COUNT(*) from ClientDisabilityList")
    int countClientDisabilityList();

    // insert all ClientDisabilityList
    @Insert
    void insertClientDisabilityList(ClientDisabilityList... clientDisabilityList);

    //   delete All  ClientDisabilityList
    @Query("DELETE FROM ClientDisabilityList")
    public void deleteClientDisabilityList();


    // get All ClientDocumentList
    @Query("SELECT * FROM ClientDocumentList WHERE BookingId = :bookingId")
    LiveData<List<ClientDocumentList>> getAllClientDocumentList(String bookingId);

    //    get ClientDocumentList count
    @Query("SELECT COUNT(*) from ClientDocumentList")
    int countClientDocumentList();

    // insert all ClientDocumentList
    @Insert
    void insertClientDocumentList(ClientDocumentList... clientDocumentList);

    //   delete All  ClientDocumentList
    @Query("DELETE FROM ClientDocumentList")
    public void deleteClientDocumentList();

    // get All ClientMedicalForMobileList
    @Query("SELECT * FROM ClientMedicalForMobileList WHERE BookingId = :bookingId")
    LiveData<List<ClientMedicalForMobileList>> getAllClientMedicalForMobileList(String bookingId);

    //    get ClientMedicalForMobileList count
    @Query("SELECT COUNT(*) from ClientMedicalForMobileList")
    int countClientMedicalForMobileList();

    // insert all ClientMedicalForMobileList
    @Insert
    void insertClientMedicalForMobileList(ClientMedicalForMobileList... clientMedicalForMobileList);

    //   delete All  ClientMedicalForMobileList
    @Query("DELETE FROM ClientMedicalForMobileList")
    public void deleteClientMedicalForMobileList();

    // get All ClientNoteList
    @Query("SELECT * FROM ClientNoteList WHERE BookingId = :bookingId")
    LiveData<List<ClientNoteList>> getAllClientNoteList(String bookingId);

    //    get ClientNoteList count
    @Query("SELECT COUNT(*) from ClientNoteList")
    int countClientNoteList();

    // insert all ClientNoteList
    @Insert
    void insertClientNoteList(ClientNoteList... clientNoteList);

    //   delete All  ClientNoteList
    @Query("DELETE FROM ClientNoteList")
    public void deleteClientNoteList();

    // get All ClientSummary
    @Query("SELECT * FROM ClientSummary WHERE BookingId = :bookingId")
    LiveData<ClientSummary> getAllClientSummary(String bookingId);

    //    get ClientSummary count
    @Query("SELECT COUNT(*) from ClientSummary")
    int countClientSummary();

    // insert all ClientSummary
    @Insert
    void insertClientSummary(ClientSummary... clientSummary);

    //   delete All  ClientSummary
    @Query("DELETE FROM ClientSummary")
    public void deleteClientSummary();

    // get All ClientTaskList
    @Query("SELECT * FROM ClientTaskList WHERE BookingId = :bookingId")
    LiveData<List<ClientTaskList>> getAllClientTaskList(String bookingId);

    //    get ClientTaskList count
    @Query("SELECT COUNT(*) from ClientTaskList")
    int countClientTaskList();

    // insert all ClientTaskList
    @Insert
    void insertClientTaskList(ClientTaskList... clientTaskList);

    //   delete All  ClientTaskList
    @Query("DELETE FROM ClientTaskList")
    public void deleteClientTaskList();
}
