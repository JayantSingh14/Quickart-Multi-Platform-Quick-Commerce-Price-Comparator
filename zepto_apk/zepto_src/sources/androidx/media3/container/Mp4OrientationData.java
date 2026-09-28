package androidx.media3.container;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes3.dex */
public final class Mp4OrientationData implements Metadata.Entry {
    public static final Parcelable.Creator<Mp4OrientationData> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final int f5775a;

    /* renamed from: androidx.media3.container.Mp4OrientationData$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<Mp4OrientationData> {
        @Override // android.os.Parcelable.Creator
        public final Mp4OrientationData createFromParcel(Parcel parcel) {
            return new Mp4OrientationData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final Mp4OrientationData[] newArray(int i2) {
            return new Mp4OrientationData[i2];
        }
    }

    public Mp4OrientationData(Parcel parcel) {
        this.f5775a = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Mp4OrientationData) && this.f5775a == ((Mp4OrientationData) obj).f5775a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f5775a) + 527;
    }

    public final String toString() {
        return "Orientation= " + this.f5775a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f5775a);
    }
}
