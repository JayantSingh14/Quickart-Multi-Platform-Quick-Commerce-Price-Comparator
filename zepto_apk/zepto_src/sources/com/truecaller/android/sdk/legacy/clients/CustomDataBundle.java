package com.truecaller.android.sdk.legacy.clients;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class CustomDataBundle implements Parcelable {
    public static final Parcelable.Creator<CustomDataBundle> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final int f47247a;

    /* renamed from: b, reason: collision with root package name */
    public final int f47248b;

    /* renamed from: c, reason: collision with root package name */
    public final String f47249c;

    /* renamed from: d, reason: collision with root package name */
    public final String f47250d;

    /* renamed from: e, reason: collision with root package name */
    public final int f47251e;

    /* renamed from: f, reason: collision with root package name */
    public final int f47252f;

    /* renamed from: g, reason: collision with root package name */
    public final int f47253g;

    /* renamed from: com.truecaller.android.sdk.legacy.clients.CustomDataBundle$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<CustomDataBundle> {
        @Override // android.os.Parcelable.Creator
        public final CustomDataBundle createFromParcel(Parcel parcel) {
            return new CustomDataBundle(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final CustomDataBundle[] newArray(int i2) {
            return new CustomDataBundle[i2];
        }
    }

    public CustomDataBundle(int i2, int i3, String str, String str2, int i4, int i5, int i6) {
        this.f47247a = i2;
        this.f47248b = i3;
        this.f47249c = str;
        this.f47250d = str2;
        this.f47253g = i4;
        this.f47251e = i5;
        this.f47252f = i6;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f47247a);
        parcel.writeInt(this.f47248b);
        parcel.writeString(this.f47249c);
        parcel.writeString(this.f47250d);
        parcel.writeInt(this.f47253g);
        parcel.writeInt(this.f47251e);
        parcel.writeInt(this.f47252f);
    }

    public CustomDataBundle(Parcel parcel) {
        this.f47247a = parcel.readInt();
        this.f47248b = parcel.readInt();
        this.f47249c = parcel.readString();
        this.f47250d = parcel.readString();
        this.f47253g = parcel.readInt();
        this.f47251e = parcel.readInt();
        this.f47252f = parcel.readInt();
    }
}
