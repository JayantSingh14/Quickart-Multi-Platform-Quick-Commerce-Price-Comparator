package androidx.media3.container;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.UnstableApi;
import com.google.common.primitives.Longs;

@UnstableApi
/* loaded from: classes3.dex */
public final class Mp4TimestampData implements Metadata.Entry {
    public static final Parcelable.Creator<Mp4TimestampData> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final long f5776a;

    /* renamed from: b, reason: collision with root package name */
    public final long f5777b;

    /* renamed from: c, reason: collision with root package name */
    public final long f5778c;

    /* renamed from: androidx.media3.container.Mp4TimestampData$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<Mp4TimestampData> {
        @Override // android.os.Parcelable.Creator
        public final Mp4TimestampData createFromParcel(Parcel parcel) {
            return new Mp4TimestampData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final Mp4TimestampData[] newArray(int i2) {
            return new Mp4TimestampData[i2];
        }
    }

    public Mp4TimestampData(long j2, long j3, long j4) {
        this.f5776a = j2;
        this.f5777b = j3;
        this.f5778c = j4;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Mp4TimestampData)) {
            return false;
        }
        Mp4TimestampData mp4TimestampData = (Mp4TimestampData) obj;
        return this.f5776a == mp4TimestampData.f5776a && this.f5777b == mp4TimestampData.f5777b && this.f5778c == mp4TimestampData.f5778c;
    }

    public final int hashCode() {
        return Longs.a(this.f5778c) + ((Longs.a(this.f5777b) + ((Longs.a(this.f5776a) + 527) * 31)) * 31);
    }

    public final String toString() {
        return "Mp4Timestamp: creation time=" + this.f5776a + ", modification time=" + this.f5777b + ", timescale=" + this.f5778c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f5776a);
        parcel.writeLong(this.f5777b);
        parcel.writeLong(this.f5778c);
    }

    public Mp4TimestampData(Parcel parcel) {
        this.f5776a = parcel.readLong();
        this.f5777b = parcel.readLong();
        this.f5778c = parcel.readLong();
    }
}
