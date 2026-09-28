package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

@UnstableApi
/* loaded from: classes3.dex */
public final class InternalFrame extends Id3Frame {
    public static final Parcelable.Creator<InternalFrame> CREATOR = new AnonymousClass1();

    /* renamed from: b, reason: collision with root package name */
    public final String f8830b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8831c;

    /* renamed from: d, reason: collision with root package name */
    public final String f8832d;

    /* renamed from: androidx.media3.extractor.metadata.id3.InternalFrame$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<InternalFrame> {
        @Override // android.os.Parcelable.Creator
        public final InternalFrame createFromParcel(Parcel parcel) {
            return new InternalFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final InternalFrame[] newArray(int i2) {
            return new InternalFrame[i2];
        }
    }

    public InternalFrame(String str, String str2, String str3) {
        super("----");
        this.f8830b = str;
        this.f8831c = str2;
        this.f8832d = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && InternalFrame.class == obj.getClass()) {
            InternalFrame internalFrame = (InternalFrame) obj;
            if (Util.a(this.f8831c, internalFrame.f8831c) && Util.a(this.f8830b, internalFrame.f8830b) && Util.a(this.f8832d, internalFrame.f8832d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f8830b;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f8831c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f8832d;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // androidx.media3.extractor.metadata.id3.Id3Frame
    public final String toString() {
        return this.f8828a + ": domain=" + this.f8830b + ", description=" + this.f8831c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f8828a);
        parcel.writeString(this.f8830b);
        parcel.writeString(this.f8832d);
    }

    public InternalFrame(Parcel parcel) {
        super("----");
        String string = parcel.readString();
        int i2 = Util.f5744a;
        this.f8830b = string;
        this.f8831c = parcel.readString();
        this.f8832d = parcel.readString();
    }
}
