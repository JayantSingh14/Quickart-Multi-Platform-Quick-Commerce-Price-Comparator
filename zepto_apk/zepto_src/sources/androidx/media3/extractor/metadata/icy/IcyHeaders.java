package androidx.media3.extractor.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

@UnstableApi
/* loaded from: classes3.dex */
public final class IcyHeaders implements Metadata.Entry {
    public static final Parcelable.Creator<IcyHeaders> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final int f8791a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8792b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8793c;

    /* renamed from: d, reason: collision with root package name */
    public final String f8794d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f8795e;

    /* renamed from: f, reason: collision with root package name */
    public final int f8796f;

    /* renamed from: androidx.media3.extractor.metadata.icy.IcyHeaders$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<IcyHeaders> {
        @Override // android.os.Parcelable.Creator
        public final IcyHeaders createFromParcel(Parcel parcel) {
            return new IcyHeaders(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final IcyHeaders[] newArray(int i2) {
            return new IcyHeaders[i2];
        }
    }

    public IcyHeaders(int i2, int i3, String str, String str2, String str3, boolean z) {
        Assertions.a(i3 == -1 || i3 > 0);
        this.f8791a = i2;
        this.f8792b = str;
        this.f8793c = str2;
        this.f8794d = str3;
        this.f8795e = z;
        this.f8796f = i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.media3.extractor.metadata.icy.IcyHeaders a(java.util.Map r14) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 207
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.metadata.icy.IcyHeaders.a(java.util.Map):androidx.media3.extractor.metadata.icy.IcyHeaders");
    }

    @Override // androidx.media3.common.Metadata.Entry
    public final void A4(MediaMetadata.Builder builder) {
        String str = this.f8793c;
        if (str != null) {
            builder.F = str;
        }
        String str2 = this.f8792b;
        if (str2 != null) {
            builder.D = str2;
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
        if (obj != null && IcyHeaders.class == obj.getClass()) {
            IcyHeaders icyHeaders = (IcyHeaders) obj;
            if (this.f8791a == icyHeaders.f8791a && Util.a(this.f8792b, icyHeaders.f8792b) && Util.a(this.f8793c, icyHeaders.f8793c) && Util.a(this.f8794d, icyHeaders.f8794d) && this.f8795e == icyHeaders.f8795e && this.f8796f == icyHeaders.f8796f) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = (527 + this.f8791a) * 31;
        String str = this.f8792b;
        int iHashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f8793c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f8794d;
        return ((((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.f8795e ? 1 : 0)) * 31) + this.f8796f;
    }

    public final String toString() {
        return "IcyHeaders: name=\"" + this.f8793c + "\", genre=\"" + this.f8792b + "\", bitrate=" + this.f8791a + ", metadataInterval=" + this.f8796f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f8791a);
        parcel.writeString(this.f8792b);
        parcel.writeString(this.f8793c);
        parcel.writeString(this.f8794d);
        int i3 = Util.f5744a;
        parcel.writeInt(this.f8795e ? 1 : 0);
        parcel.writeInt(this.f8796f);
    }

    public IcyHeaders(Parcel parcel) {
        this.f8791a = parcel.readInt();
        this.f8792b = parcel.readString();
        this.f8793c = parcel.readString();
        this.f8794d = parcel.readString();
        int i2 = Util.f5744a;
        this.f8795e = parcel.readInt() != 0;
        this.f8796f = parcel.readInt();
    }
}
