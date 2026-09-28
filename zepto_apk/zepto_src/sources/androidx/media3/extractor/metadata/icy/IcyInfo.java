package androidx.media3.extractor.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.UnstableApi;
import java.util.Arrays;

@UnstableApi
/* loaded from: classes3.dex */
public final class IcyInfo implements Metadata.Entry {
    public static final Parcelable.Creator<IcyInfo> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f8797a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8798b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8799c;

    /* renamed from: androidx.media3.extractor.metadata.icy.IcyInfo$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<IcyInfo> {
        @Override // android.os.Parcelable.Creator
        public final IcyInfo createFromParcel(Parcel parcel) {
            return new IcyInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final IcyInfo[] newArray(int i2) {
            return new IcyInfo[i2];
        }
    }

    public IcyInfo(String str, String str2, byte[] bArr) {
        this.f8797a = bArr;
        this.f8798b = str;
        this.f8799c = str2;
    }

    @Override // androidx.media3.common.Metadata.Entry
    public final void A4(MediaMetadata.Builder builder) {
        String str = this.f8798b;
        if (str != null) {
            builder.f5392a = str;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || IcyInfo.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f8797a, ((IcyInfo) obj).f8797a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f8797a);
    }

    public final String toString() {
        return "ICY: title=\"" + this.f8798b + "\", url=\"" + this.f8799c + "\", rawMetadata.length=\"" + this.f8797a.length + "\"";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByteArray(this.f8797a);
        parcel.writeString(this.f8798b);
        parcel.writeString(this.f8799c);
    }

    public IcyInfo(Parcel parcel) {
        byte[] bArrCreateByteArray = parcel.createByteArray();
        bArrCreateByteArray.getClass();
        this.f8797a = bArrCreateByteArray;
        this.f8798b = parcel.readString();
        this.f8799c = parcel.readString();
    }
}
