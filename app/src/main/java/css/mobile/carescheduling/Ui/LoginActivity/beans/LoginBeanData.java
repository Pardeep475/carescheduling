package css.mobile.carescheduling.Ui.LoginActivity.beans;

import css.mobile.carescheduling.BR;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;


public class LoginBeanData extends BaseObservable {
    private String userEmail, userPassword;

    public LoginBeanData(String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    @Bindable
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
        notifyPropertyChanged(BR.userEmail);
    }

    @Bindable
    public String getUserPassword() {
        return userPassword;

    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
        notifyPropertyChanged(BR.userPassword);
    }
}
