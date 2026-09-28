package a;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes3.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0000a();

    /* renamed from: a, reason: collision with root package name */
    public final String f5a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f6b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f8d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f9e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f10f;

    /* renamed from: g, reason: collision with root package name */
    public final String f11g;

    /* renamed from: h, reason: collision with root package name */
    public final String f12h;

    /* renamed from: i, reason: collision with root package name */
    public Integer f13i;

    /* renamed from: j, reason: collision with root package name */
    public final List f14j;

    /* renamed from: a.a$a, reason: collision with other inner class name */
    public class C0000a implements Parcelable.Creator<a> {
        @Override // android.os.Parcelable.Creator
        public final a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final a[] newArray(int i2) {
            return new a[i2];
        }
    }

    public a(String str, String str2, String str3, List list) {
        this.f6b = false;
        this.f7c = false;
        this.f8d = false;
        this.f9e = false;
        this.f10f = false;
        this.f13i = 0;
        this.f12h = str2;
        this.f5a = str;
        this.f11g = str3;
        this.f14j = list;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f5a);
        parcel.writeByte(this.f6b ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f9e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f10f ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f11g);
        parcel.writeString(this.f12h);
        if (this.f13i == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.f13i.intValue());
        }
        parcel.writeStringList(this.f14j);
    }

    public a(Parcel parcel) {
        this.f6b = false;
        this.f7c = false;
        this.f8d = false;
        this.f9e = false;
        this.f10f = false;
        this.f13i = 0;
        this.f5a = parcel.readString();
        this.f6b = parcel.readByte() != 0;
        this.f7c = parcel.readByte() != 0;
        this.f8d = parcel.readByte() != 0;
        this.f9e = parcel.readByte() != 0;
        this.f10f = parcel.readByte() != 0;
        this.f11g = parcel.readString();
        this.f12h = parcel.readString();
        if (parcel.readByte() == 0) {
            this.f13i = null;
        } else {
            this.f13i = Integer.valueOf(parcel.readInt());
        }
        this.f14j = parcel.createStringArrayList();
    }
}
