package androidx.media3.container;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.Arrays;

@UnstableApi
/* loaded from: classes3.dex */
public final class XmpData implements Metadata.Entry {
    public static final Parcelable.Creator<XmpData> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f5815a;

    /* renamed from: androidx.media3.container.XmpData$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<XmpData> {
        @Override // android.os.Parcelable.Creator
        public final XmpData createFromParcel(Parcel parcel) {
            return new XmpData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final XmpData[] newArray(int i2) {
            return new XmpData[i2];
        }
    }

    public XmpData(Parcel parcel) {
        byte[] bArrCreateByteArray = parcel.createByteArray();
        int i2 = Util.f5744a;
        this.f5815a = bArrCreateByteArray;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || XmpData.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f5815a, ((XmpData) obj).f5815a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f5815a);
    }

    public final String toString() {
        return "XMP: " + Util.h0(this.f5815a);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByteArray(this.f5815a);
    }
}
