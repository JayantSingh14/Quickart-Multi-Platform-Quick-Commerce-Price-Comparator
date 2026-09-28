package com.amazon.android.apay.commonlibrary.browsinglib.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class BrowsingRequest implements Parcelable {
    public static final Parcelable.Creator<BrowsingRequest> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final String f14856a;

    /* renamed from: b, reason: collision with root package name */
    public final String f14857b;

    /* renamed from: c, reason: collision with root package name */
    public final String f14858c;

    /* renamed from: d, reason: collision with root package name */
    public final String f14859d;

    /* renamed from: e, reason: collision with root package name */
    public Boolean f14860e;

    /* renamed from: f, reason: collision with root package name */
    public Boolean f14861f;

    public static class a implements Parcelable.Creator<BrowsingRequest> {
        @Override // android.os.Parcelable.Creator
        public final BrowsingRequest createFromParcel(Parcel parcel) {
            return new BrowsingRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final BrowsingRequest[] newArray(int i2) {
            return new BrowsingRequest[i2];
        }
    }

    public BrowsingRequest(String str, String str2, String str3, String str4) {
        Boolean bool = Boolean.FALSE;
        this.f14860e = bool;
        this.f14861f = bool;
        this.f14856a = str;
        this.f14857b = str2;
        this.f14858c = str3;
        this.f14859d = str4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCustomTabToolbarColor() {
        return this.f14859d;
    }

    public String getMerchantId() {
        return this.f14858c;
    }

    public String getPayUrl() {
        return this.f14856a;
    }

    public String getStitchingId() {
        return this.f14857b;
    }

    public Boolean isBrowserLaunched() {
        return this.f14860e;
    }

    public Boolean isNewIntentCalled() {
        return this.f14861f;
    }

    public void setIsBrowserLaunched(Boolean bool) {
        this.f14860e = bool;
    }

    public void setIsNewIntentCalled(Boolean bool) {
        this.f14861f = bool;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f14856a);
        parcel.writeString(this.f14857b);
        parcel.writeString(this.f14858c);
        parcel.writeString(this.f14859d);
        parcel.writeByte(this.f14860e.booleanValue() ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f14861f.booleanValue() ? (byte) 1 : (byte) 0);
    }

    public BrowsingRequest(Parcel parcel) {
        Boolean bool = Boolean.FALSE;
        this.f14860e = bool;
        this.f14861f = bool;
        this.f14856a = parcel.readString();
        this.f14857b = parcel.readString();
        this.f14858c = parcel.readString();
        this.f14859d = parcel.readString();
        this.f14860e = Boolean.valueOf(parcel.readByte() != 0);
        this.f14861f = Boolean.valueOf(parcel.readByte() != 0);
    }
}
