package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.Arrays;

@UnstableApi
/* loaded from: classes3.dex */
public final class ApicFrame extends Id3Frame {
    public static final Parcelable.Creator<ApicFrame> CREATOR = new AnonymousClass1();

    /* renamed from: b, reason: collision with root package name */
    public final String f8800b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8801c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8802d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f8803e;

    /* renamed from: androidx.media3.extractor.metadata.id3.ApicFrame$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<ApicFrame> {
        @Override // android.os.Parcelable.Creator
        public final ApicFrame createFromParcel(Parcel parcel) {
            return new ApicFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final ApicFrame[] newArray(int i2) {
            return new ApicFrame[i2];
        }
    }

    public ApicFrame(int i2, String str, String str2, byte[] bArr) {
        super("APIC");
        this.f8800b = str;
        this.f8801c = str2;
        this.f8802d = i2;
        this.f8803e = bArr;
    }

    @Override // androidx.media3.common.Metadata.Entry
    public final void A4(MediaMetadata.Builder builder) {
        builder.a(this.f8802d, this.f8803e);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ApicFrame.class == obj.getClass()) {
            ApicFrame apicFrame = (ApicFrame) obj;
            if (this.f8802d == apicFrame.f8802d && Util.a(this.f8800b, apicFrame.f8800b) && Util.a(this.f8801c, apicFrame.f8801c) && Arrays.equals(this.f8803e, apicFrame.f8803e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = (527 + this.f8802d) * 31;
        String str = this.f8800b;
        int iHashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f8801c;
        return Arrays.hashCode(this.f8803e) + ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    @Override // androidx.media3.extractor.metadata.id3.Id3Frame
    public final String toString() {
        return this.f8828a + ": mimeType=" + this.f8800b + ", description=" + this.f8801c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f8800b);
        parcel.writeString(this.f8801c);
        parcel.writeInt(this.f8802d);
        parcel.writeByteArray(this.f8803e);
    }

    public ApicFrame(Parcel parcel) {
        super("APIC");
        String string = parcel.readString();
        int i2 = Util.f5744a;
        this.f8800b = string;
        this.f8801c = parcel.readString();
        this.f8802d = parcel.readInt();
        this.f8803e = parcel.createByteArray();
    }
}
