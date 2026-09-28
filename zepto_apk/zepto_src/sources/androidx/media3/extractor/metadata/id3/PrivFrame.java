package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.Arrays;

@UnstableApi
/* loaded from: classes3.dex */
public final class PrivFrame extends Id3Frame {
    public static final Parcelable.Creator<PrivFrame> CREATOR = new AnonymousClass1();

    /* renamed from: b, reason: collision with root package name */
    public final String f8838b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f8839c;

    /* renamed from: androidx.media3.extractor.metadata.id3.PrivFrame$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<PrivFrame> {
        @Override // android.os.Parcelable.Creator
        public final PrivFrame createFromParcel(Parcel parcel) {
            return new PrivFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final PrivFrame[] newArray(int i2) {
            return new PrivFrame[i2];
        }
    }

    public PrivFrame(String str, byte[] bArr) {
        super("PRIV");
        this.f8838b = str;
        this.f8839c = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && PrivFrame.class == obj.getClass()) {
            PrivFrame privFrame = (PrivFrame) obj;
            if (Util.a(this.f8838b, privFrame.f8838b) && Arrays.equals(this.f8839c, privFrame.f8839c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f8838b;
        return Arrays.hashCode(this.f8839c) + ((527 + (str != null ? str.hashCode() : 0)) * 31);
    }

    @Override // androidx.media3.extractor.metadata.id3.Id3Frame
    public final String toString() {
        return this.f8828a + ": owner=" + this.f8838b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f8838b);
        parcel.writeByteArray(this.f8839c);
    }

    public PrivFrame(Parcel parcel) {
        super("PRIV");
        String string = parcel.readString();
        int i2 = Util.f5744a;
        this.f8838b = string;
        this.f8839c = parcel.createByteArray();
    }
}
