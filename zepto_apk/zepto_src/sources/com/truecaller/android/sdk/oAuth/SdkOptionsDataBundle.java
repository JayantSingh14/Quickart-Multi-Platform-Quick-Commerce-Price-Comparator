package com.truecaller.android.sdk.oAuth;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.ColorInt;
import androidx.annotation.Keep;
import com.truecaller.android.sdk.oAuth.TcSdkOptions;

@Keep
/* loaded from: classes4.dex */
public class SdkOptionsDataBundle implements Parcelable {
    public static final Parcelable.Creator<SdkOptionsDataBundle> CREATOR = new AnonymousClass1();

    @ColorInt
    private final int buttonColor;

    @ColorInt
    private final int buttonTextColor;

    @TcSdkOptions.CTATextOptions
    private final int ctaTextOption;

    @TcSdkOptions.ConsentHeadingOptions
    private final int headingOption;

    @TcSdkOptions.LoginTextPrefixOptions
    private final int loginTextPrefixOption;

    @TcSdkOptions.ConsentTitleOptions
    private final int titleOption;

    /* renamed from: com.truecaller.android.sdk.oAuth.SdkOptionsDataBundle$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<SdkOptionsDataBundle> {
        @Override // android.os.Parcelable.Creator
        public final SdkOptionsDataBundle createFromParcel(Parcel parcel) {
            return new SdkOptionsDataBundle(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final SdkOptionsDataBundle[] newArray(int i2) {
            return new SdkOptionsDataBundle[i2];
        }
    }

    public SdkOptionsDataBundle(Parcel parcel) {
        this.buttonColor = parcel.readInt();
        this.buttonTextColor = parcel.readInt();
        this.titleOption = parcel.readInt();
        this.ctaTextOption = parcel.readInt();
        this.loginTextPrefixOption = parcel.readInt();
        this.headingOption = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getButtonColor() {
        return this.buttonColor;
    }

    public int getButtonTextColor() {
        return this.buttonTextColor;
    }

    public int getCtaTextOption() {
        return this.ctaTextOption;
    }

    public int getHeadingOption() {
        return this.headingOption;
    }

    public int getLoginTextPrefixOption() {
        return this.loginTextPrefixOption;
    }

    public int getTitleOption() {
        return this.titleOption;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.buttonColor);
        parcel.writeInt(this.buttonTextColor);
        parcel.writeInt(this.titleOption);
        parcel.writeInt(this.ctaTextOption);
        parcel.writeInt(this.loginTextPrefixOption);
        parcel.writeInt(this.headingOption);
    }

    public SdkOptionsDataBundle(@ColorInt int i2, @ColorInt int i3, @TcSdkOptions.ConsentTitleOptions int i4, @TcSdkOptions.ConsentHeadingOptions int i5, @TcSdkOptions.CTATextOptions int i6, @TcSdkOptions.LoginTextPrefixOptions int i7) {
        this.buttonColor = i2;
        this.buttonTextColor = i3;
        this.titleOption = i4;
        this.headingOption = i5;
        this.ctaTextOption = i6;
        this.loginTextPrefixOption = i7;
    }
}
