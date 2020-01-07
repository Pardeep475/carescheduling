package css.mobile.carescheduling.Ui.Dashboard.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PersonImage implements Serializable {
    @SerializedName("CustomerId")
    @Expose
    private String customerId;
    @SerializedName("ImageAddedDate")
    @Expose
    private String ImageAddedDate;
    @SerializedName("ImageAltText")
    @Expose
    private String ImageAltText;
    @SerializedName("ImageFile")
    @Expose
    private String ImageFile;
    @SerializedName("ImageFileName")
    @Expose
    private String ImageFileName;
    @SerializedName("ImageFileTypeName")
    @Expose
    private String ImageFileTypeName;
    @SerializedName("ImageFileUrl")
    @Expose
    private String ImageFileUrl;
    @SerializedName("ImageHexString")
    @Expose
    private String ImageHexString;
    @SerializedName("ImageId")
    @Expose
    private String ImageId;
    @SerializedName("ImageLongAltText")
    @Expose
    private String ImageLongAltText;
    @SerializedName("ImageSizeName")
    @Expose
    private String ImageSizeName;
    @SerializedName("ImageSizes")
    @Expose
    private String ImageSizes;
    @SerializedName("ImageUpdatedDate")
    @Expose
    private String ImageUpdatedDate;
    @SerializedName("IsDefault")
    @Expose
    private boolean IsDefault;
    @SerializedName("MaxColourDepth")
    @Expose
    private int MaxColourDepth;
    @SerializedName("XPixel")
    @Expose
    private int XPixel;
    @SerializedName("YPixel")
    @Expose
    private int YPixel;
    @SerializedName("Orientation")
    @Expose
    private String Orientation;


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getImageAddedDate() {
        return ImageAddedDate;
    }

    public void setImageAddedDate(String imageAddedDate) {
        ImageAddedDate = imageAddedDate;
    }

    public String getImageAltText() {
        return ImageAltText;
    }

    public void setImageAltText(String imageAltText) {
        ImageAltText = imageAltText;
    }

    public String getImageFile() {
        return ImageFile;
    }

    public void setImageFile(String imageFile) {
        ImageFile = imageFile;
    }

    public String getImageFileName() {
        return ImageFileName;
    }

    public void setImageFileName(String imageFileName) {
        ImageFileName = imageFileName;
    }

    public String getImageFileTypeName() {
        return ImageFileTypeName;
    }

    public void setImageFileTypeName(String imageFileTypeName) {
        ImageFileTypeName = imageFileTypeName;
    }

    public String getImageFileUrl() {
        return ImageFileUrl;
    }

    public void setImageFileUrl(String imageFileUrl) {
        ImageFileUrl = imageFileUrl;
    }

    public String getImageHexString() {
        return ImageHexString;
    }

    public void setImageHexString(String imageHexString) {
        ImageHexString = imageHexString;
    }

    public String getImageId() {
        return ImageId;
    }

    public void setImageId(String imageId) {
        ImageId = imageId;
    }

    public String getImageLongAltText() {
        return ImageLongAltText;
    }

    public void setImageLongAltText(String imageLongAltText) {
        ImageLongAltText = imageLongAltText;
    }

    public String getImageSizeName() {
        return ImageSizeName;
    }

    public void setImageSizeName(String imageSizeName) {
        ImageSizeName = imageSizeName;
    }

    public String getImageSizes() {
        return ImageSizes;
    }

    public void setImageSizes(String imageSizes) {
        ImageSizes = imageSizes;
    }

    public String getImageUpdatedDate() {
        return ImageUpdatedDate;
    }

    public void setImageUpdatedDate(String imageUpdatedDate) {
        ImageUpdatedDate = imageUpdatedDate;
    }

    public boolean isDefault() {
        return IsDefault;
    }

    public void setDefault(boolean aDefault) {
        IsDefault = aDefault;
    }

    public int getMaxColourDepth() {
        return MaxColourDepth;
    }

    public void setMaxColourDepth(int maxColourDepth) {
        MaxColourDepth = maxColourDepth;
    }

    public int getXPixel() {
        return XPixel;
    }

    public void setXPixel(int XPixel) {
        this.XPixel = XPixel;
    }

    public int getYPixel() {
        return YPixel;
    }

    public void setYPixel(int YPixel) {
        this.YPixel = YPixel;
    }

    public String getOrientation() {
        return Orientation;
    }

    public void setOrientation(String orientation) {
        Orientation = orientation;
    }
}