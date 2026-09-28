package androidx.media3.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@UnstableApi
/* loaded from: classes3.dex */
public final class StreamKey implements Comparable<StreamKey>, Parcelable {
    public static final Parcelable.Creator<StreamKey> CREATOR = new AnonymousClass1();

    /* renamed from: d, reason: collision with root package name */
    public static final String f5456d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f5457e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f5458f;

    /* renamed from: a, reason: collision with root package name */
    public final int f5459a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5460b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5461c;

    /* renamed from: androidx.media3.common.StreamKey$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<StreamKey> {
        @Override // android.os.Parcelable.Creator
        public final StreamKey createFromParcel(Parcel parcel) {
            return new StreamKey(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final StreamKey[] newArray(int i2) {
            return new StreamKey[i2];
        }
    }

    static {
        int i2 = Util.f5744a;
        f5456d = Integer.toString(0, 36);
        f5457e = Integer.toString(1, 36);
        f5458f = Integer.toString(2, 36);
    }

    public StreamKey(int i2, int i3, int i4) {
        this.f5459a = i2;
        this.f5460b = i3;
        this.f5461c = i4;
    }

    @Override // java.lang.Comparable
    public final int compareTo(StreamKey streamKey) {
        StreamKey streamKey2 = streamKey;
        int i2 = this.f5459a - streamKey2.f5459a;
        if (i2 != 0) {
            return i2;
        }
        int i3 = this.f5460b - streamKey2.f5460b;
        return i3 == 0 ? this.f5461c - streamKey2.f5461c : i3;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && StreamKey.class == obj.getClass()) {
            StreamKey streamKey = (StreamKey) obj;
            if (this.f5459a == streamKey.f5459a && this.f5460b == streamKey.f5460b && this.f5461c == streamKey.f5461c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((this.f5459a * 31) + this.f5460b) * 31) + this.f5461c;
    }

    public final String toString() {
        return this.f5459a + CLConstants.DOT_SALT_DELIMETER + this.f5460b + CLConstants.DOT_SALT_DELIMETER + this.f5461c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f5459a);
        parcel.writeInt(this.f5460b);
        parcel.writeInt(this.f5461c);
    }

    public StreamKey(Parcel parcel) {
        this.f5459a = parcel.readInt();
        this.f5460b = parcel.readInt();
        this.f5461c = parcel.readInt();
    }
}
