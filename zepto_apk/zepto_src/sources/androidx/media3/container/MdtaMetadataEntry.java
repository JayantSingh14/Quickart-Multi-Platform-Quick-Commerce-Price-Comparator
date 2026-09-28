package androidx.media3.container;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import androidx.fragment.app.e;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.util.Arrays;

@UnstableApi
/* loaded from: classes3.dex */
public final class MdtaMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<MdtaMetadataEntry> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final String f5769a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f5770b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5771c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5772d;

    /* renamed from: androidx.media3.container.MdtaMetadataEntry$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<MdtaMetadataEntry> {
        @Override // android.os.Parcelable.Creator
        public final MdtaMetadataEntry createFromParcel(Parcel parcel) {
            return new MdtaMetadataEntry(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final MdtaMetadataEntry[] newArray(int i2) {
            return new MdtaMetadataEntry[i2];
        }
    }

    public MdtaMetadataEntry(String str, byte[] bArr, int i2, int i3) {
        this.f5769a = str;
        this.f5770b = bArr;
        this.f5771c = i2;
        this.f5772d = i3;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && MdtaMetadataEntry.class == obj.getClass()) {
            MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) obj;
            if (this.f5769a.equals(mdtaMetadataEntry.f5769a) && Arrays.equals(this.f5770b, mdtaMetadataEntry.f5770b) && this.f5771c == mdtaMetadataEntry.f5771c && this.f5772d == mdtaMetadataEntry.f5772d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((Arrays.hashCode(this.f5770b) + e.e(527, 31, this.f5769a)) * 31) + this.f5771c) * 31) + this.f5772d;
    }

    public final String toString() {
        String strP;
        byte[] bArr = this.f5770b;
        int i2 = this.f5772d;
        if (i2 == 1) {
            strP = Util.p(bArr);
        } else if (i2 == 23) {
            Preconditions.b(bArr.length, 4, "array too small: %s < %s", bArr.length >= 4);
            strP = String.valueOf(Float.intBitsToFloat(Ints.d(bArr[0], bArr[1], bArr[2], bArr[3])));
        } else if (i2 != 67) {
            strP = Util.h0(bArr);
        } else {
            Preconditions.b(bArr.length, 4, "array too small: %s < %s", bArr.length >= 4);
            strP = String.valueOf(Ints.d(bArr[0], bArr[1], bArr[2], bArr[3]));
        }
        return b.s(new StringBuilder("mdta: key="), this.f5769a, ", value=", strP);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f5769a);
        parcel.writeByteArray(this.f5770b);
        parcel.writeInt(this.f5771c);
        parcel.writeInt(this.f5772d);
    }

    public MdtaMetadataEntry(Parcel parcel) {
        String string = parcel.readString();
        int i2 = Util.f5744a;
        this.f5769a = string;
        this.f5770b = parcel.createByteArray();
        this.f5771c = parcel.readInt();
        this.f5772d = parcel.readInt();
    }
}
