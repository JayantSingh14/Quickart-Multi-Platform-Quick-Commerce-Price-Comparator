package androidx.media3.session.legacy;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.media3.common.util.UnstableApi;

@SuppressLint({"BanParcelableUsage"})
@RestrictTo
@UnstableApi
/* loaded from: classes3.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public int f10653a;

    /* renamed from: b, reason: collision with root package name */
    public int f10654b;

    /* renamed from: c, reason: collision with root package name */
    public int f10655c;

    /* renamed from: d, reason: collision with root package name */
    public int f10656d;

    /* renamed from: e, reason: collision with root package name */
    public int f10657e;

    /* renamed from: androidx.media3.session.legacy.ParcelableVolumeInfo$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<ParcelableVolumeInfo> {
        @Override // android.os.Parcelable.Creator
        public final ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            ParcelableVolumeInfo parcelableVolumeInfo = new ParcelableVolumeInfo();
            parcelableVolumeInfo.f10653a = parcel.readInt();
            parcelableVolumeInfo.f10655c = parcel.readInt();
            parcelableVolumeInfo.f10656d = parcel.readInt();
            parcelableVolumeInfo.f10657e = parcel.readInt();
            parcelableVolumeInfo.f10654b = parcel.readInt();
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
        parcel.writeInt(this.f10653a);
        parcel.writeInt(this.f10655c);
        parcel.writeInt(this.f10656d);
        parcel.writeInt(this.f10657e);
        parcel.writeInt(this.f10654b);
    }
}
