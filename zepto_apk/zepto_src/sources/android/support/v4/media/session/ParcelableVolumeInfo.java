package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes3.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public int f93a;

    /* renamed from: b, reason: collision with root package name */
    public int f94b;

    /* renamed from: c, reason: collision with root package name */
    public int f95c;

    /* renamed from: d, reason: collision with root package name */
    public int f96d;

    /* renamed from: e, reason: collision with root package name */
    public int f97e;

    /* renamed from: android.support.v4.media.session.ParcelableVolumeInfo$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<ParcelableVolumeInfo> {
        @Override // android.os.Parcelable.Creator
        public final ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            ParcelableVolumeInfo parcelableVolumeInfo = new ParcelableVolumeInfo();
            parcelableVolumeInfo.f93a = parcel.readInt();
            parcelableVolumeInfo.f95c = parcel.readInt();
            parcelableVolumeInfo.f96d = parcel.readInt();
            parcelableVolumeInfo.f97e = parcel.readInt();
            parcelableVolumeInfo.f94b = parcel.readInt();
            return parcelableVolumeInfo;
        }

        @Override // android.os.Parcelable.Creator
        public final ParcelableVolumeInfo[] newArray(int i2) {
            return new ParcelableVolumeInfo[i2];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f93a);
        parcel.writeInt(this.f95c);
        parcel.writeInt(this.f96d);
        parcel.writeInt(this.f97e);
        parcel.writeInt(this.f94b);
    }
}
