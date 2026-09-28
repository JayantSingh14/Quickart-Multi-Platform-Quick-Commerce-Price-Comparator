package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.Arrays;

@UnstableApi
/* loaded from: classes3.dex */
public final class GeobFrame extends Id3Frame {
    public static final Parcelable.Creator<GeobFrame> CREATOR = new AnonymousClass1();

    /* renamed from: b, reason: collision with root package name */
    public final String f8819b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8820c;

    /* renamed from: d, reason: collision with root package name */
    public final String f8821d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f8822e;

    /* renamed from: androidx.media3.extractor.metadata.id3.GeobFrame$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<GeobFrame> {
        @Override // android.os.Parcelable.Creator
        public final GeobFrame createFromParcel(Parcel parcel) {
            return new GeobFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final GeobFrame[] newArray(int i2) {
            return new GeobFrame[i2];
        }
    }

    public GeobFrame(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.f8819b = str;
        this.f8820c = str2;
        this.f8821d = str3;
        this.f8822e = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && GeobFrame.class == obj.getClass()) {
            GeobFrame geobFrame = (GeobFrame) obj;
            if (Util.a(this.f8819b, geobFrame.f8819b) && Util.a(this.f8820c, geobFrame.f8820c) && Util.a(this.f8821d, geobFrame.f8821d) && Arrays.equals(this.f8822e, geobFrame.f8822e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f8819b;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f8820c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f8821d;
        return Arrays.hashCode(this.f8822e) + ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31);
    }

    @Override // androidx.media3.extractor.metadata.id3.Id3Frame
    public final String toString() {
        return this.f8828a + ": mimeType=" + this.f8819b + ", filename=" + this.f8820c + ", description=" + this.f8821d;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f8819b);
        parcel.writeString(this.f8820c);
        parcel.writeString(this.f8821d);
        parcel.writeByteArray(this.f8822e);
    }

    public GeobFrame(Parcel parcel) {
        super("GEOB");
        String string = parcel.readString();
        int i2 = Util.f5744a;
        this.f8819b = string;
        this.f8820c = parcel.readString();
        this.f8821d = parcel.readString();
        this.f8822e = parcel.createByteArray();
    }
}
