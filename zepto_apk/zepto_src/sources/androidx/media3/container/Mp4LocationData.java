package androidx.media3.container;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes3.dex */
public final class Mp4LocationData implements Metadata.Entry {
    public static final Parcelable.Creator<Mp4LocationData> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final float f5773a;

    /* renamed from: b, reason: collision with root package name */
    public final float f5774b;

    /* renamed from: androidx.media3.container.Mp4LocationData$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<Mp4LocationData> {
        @Override // android.os.Parcelable.Creator
        public final Mp4LocationData createFromParcel(Parcel parcel) {
            return new Mp4LocationData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final Mp4LocationData[] newArray(int i2) {
            return new Mp4LocationData[i2];
        }
    }

    public Mp4LocationData(float f2, float f3) {
        Assertions.b(f2 >= -90.0f && f2 <= 90.0f && f3 >= -180.0f && f3 <= 180.0f, "Invalid latitude or longitude");
        this.f5773a = f2;
        this.f5774b = f3;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Mp4LocationData.class == obj.getClass()) {
            Mp4LocationData mp4LocationData = (Mp4LocationData) obj;
            if (this.f5773a == mp4LocationData.f5773a && this.f5774b == mp4LocationData.f5774b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.valueOf(this.f5774b).hashCode() + ((Float.valueOf(this.f5773a).hashCode() + 527) * 31);
    }

    public final String toString() {
        return "xyz: latitude=" + this.f5773a + ", longitude=" + this.f5774b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeFloat(this.f5773a);
        parcel.writeFloat(this.f5774b);
    }

    public Mp4LocationData(Parcel parcel) {
        this.f5773a = parcel.readFloat();
        this.f5774b = parcel.readFloat();
    }
}
