package css.mobile.carescheduling.Ui.Profile.bean;

import android.graphics.Bitmap;

public class ProfileImageList {
    private Bitmap ImageBitMap;
    private boolean isDefault;

    public Bitmap getImageBitMap() {
        return ImageBitMap;
    }

    public void setImageBitMap(Bitmap imageBitMap) {
        ImageBitMap = imageBitMap;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }
}
