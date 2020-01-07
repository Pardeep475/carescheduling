package css.mobile.carescheduling.data.Local;

import android.content.Context;

import css.mobile.carescheduling.Ui.Common.ClientBarcodeList;
import css.mobile.carescheduling.Ui.Dashboard.beans.ClientContactList;
import css.mobile.carescheduling.Ui.Dashboard.beans.ClientDisabilityList;
import css.mobile.carescheduling.Ui.Dashboard.beans.ClientDocumentList;
import css.mobile.carescheduling.Ui.Dashboard.beans.ClientMedicalForMobileList;
import css.mobile.carescheduling.Ui.Dashboard.beans.ClientNoteList;
import css.mobile.carescheduling.Ui.Dashboard.beans.ClientSummary;
import css.mobile.carescheduling.Ui.Dashboard.beans.ClientTaskList;
import css.mobile.carescheduling.Ui.Dashboard.beans.PersonDetail;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ClientBookingScreenModel;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ScheduleClients;
import css.mobile.carescheduling.Ui.Profile.bean.ImageDataBean;
import css.mobile.carescheduling.Ui.Profile.bean.PersonEmailList;
import css.mobile.carescheduling.Ui.Profile.bean.PersonPhoneList;
import css.mobile.carescheduling.data.Local.DatabaseDao.HomeDeo;
import css.mobile.carescheduling.data.Local.DatabaseDao.ProfileDao;
import css.mobile.carescheduling.data.Local.DatabaseTable.AddressType;
import css.mobile.carescheduling.data.Local.DatabaseTable.CountryCode;
import css.mobile.carescheduling.data.Local.DatabaseTable.DisabilityType;
import css.mobile.carescheduling.data.Local.DatabaseTable.EmailType;
import css.mobile.carescheduling.data.Local.DatabaseTable.Ethnicity;
import css.mobile.carescheduling.data.Local.DatabaseTable.Gender;
import css.mobile.carescheduling.data.Local.DatabaseTable.MaritialStatus;
import css.mobile.carescheduling.data.Local.DatabaseTable.Nationality;
import css.mobile.carescheduling.data.Local.DatabaseTable.PersonAllAddressEntity;
import css.mobile.carescheduling.data.Local.DatabaseTable.PersonLanguage;
import css.mobile.carescheduling.data.Local.DatabaseTable.PhoneType;
import css.mobile.carescheduling.data.Local.DatabaseTable.Prefix;
import css.mobile.carescheduling.data.Local.DatabaseTable.ProfileInfo;
import css.mobile.carescheduling.data.Local.DatabaseTable.ProfileMainData;
import css.mobile.carescheduling.data.Local.DatabaseTable.Religion;
import css.mobile.carescheduling.data.Local.DatabaseTable.SexualityType;
import css.mobile.carescheduling.data.Local.DatabaseTable.UserInfo;

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