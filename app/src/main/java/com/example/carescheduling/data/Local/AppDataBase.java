package com.example.carescheduling.data.Local;

import android.content.Context;

import com.example.carescheduling.Ui.Common.ClientBarcodeList;
import com.example.carescheduling.Ui.Dashboard.beans.ClientContactList;
import com.example.carescheduling.Ui.Dashboard.beans.ClientDisabilityList;
import com.example.carescheduling.Ui.Dashboard.beans.ClientDocumentList;
import com.example.carescheduling.Ui.Dashboard.beans.ClientMedicalForMobileList;
import com.example.carescheduling.Ui.Dashboard.beans.ClientNoteList;
import com.example.carescheduling.Ui.Dashboard.beans.ClientSummary;
import com.example.carescheduling.Ui.Dashboard.beans.ClientTaskList;
import com.example.carescheduling.Ui.Dashboard.beans.PersonDetail;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientBookingScreenModel;
import com.example.carescheduling.Ui.HomeScreen.beans.ScheduleClients;
import com.example.carescheduling.Ui.Profile.bean.ImageDataBean;
import com.example.carescheduling.Ui.Profile.bean.PersonEmailList;
import com.example.carescheduling.Ui.Profile.bean.PersonPhoneList;
import com.example.carescheduling.data.Local.DatabaseDao.HomeDeo;
import com.example.carescheduling.data.Local.DatabaseDao.ProfileDao;
import com.example.carescheduling.data.Local.DatabaseTable.AddressType;
import com.example.carescheduling.data.Local.DatabaseTable.CountryCode;
import com.example.carescheduling.data.Local.DatabaseTable.DisabilityType;
import com.example.carescheduling.data.Local.DatabaseTable.EmailType;
import com.example.carescheduling.data.Local.DatabaseTable.Ethnicity;
import com.example.carescheduling.data.Local.DatabaseTable.Gender;
import com.example.carescheduling.data.Local.DatabaseTable.MaritialStatus;
import com.example.carescheduling.data.Local.DatabaseTable.Nationality;
import com.example.carescheduling.data.Local.DatabaseTable.PersonAllAddressEntity;
import com.example.carescheduling.data.Local.DatabaseTable.PersonLanguage;
import com.example.carescheduling.data.Local.DatabaseTable.PhoneType;
import com.example.carescheduling.data.Local.DatabaseTable.Prefix;
import com.example.carescheduling.data.Local.DatabaseTable.ProfileInfo;
import com.example.carescheduling.data.Local.DatabaseTable.ProfileMainData;
import com.example.carescheduling.data.Local.DatabaseTable.Religion;
import com.example.carescheduling.data.Local.DatabaseTable.SexualityType;
import com.example.carescheduling.data.Local.DatabaseTable.UserInfo;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/*AddressAllData.class
 */
@Database(entities = {PersonLanguage.class, Ethnicity.class, Gender.class, MaritialStatus.class
        , Nationality.class, Prefix.class, Religion.class, DisabilityType.class, SexualityType.class
        , CountryCode.class, PhoneType.class, AddressType.class, EmailType.class, ProfileMainData.class
        , UserInfo.class, PersonEmailList.class, PersonPhoneList.class, ProfileInfo.class, PersonAllAddressEntity.class
        , ImageDataBean.class, ClientContactList.class, ClientDisabilityList.class, ClientDocumentList.class
        , ClientMedicalForMobileList.class, ClientNoteList.class, ClientSummary.class, ClientTaskList.class
        , ClientBookingScreenModel.class, PersonDetail.class, ScheduleClients.class, ClientBarcodeList.class}
        , version = 6, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    private static AppDataBase INSTANCE;

    public abstract ProfileDao profileDao();
    public abstract HomeDeo homeDeo();

    public static AppDataBase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "css_application")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}