package androidx.media3.extractor.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

@UnstableApi
/* loaded from: classes3.dex */
public final class SlowMotionData implements Metadata.Entry {
    public static final Parcelable.Creator<SlowMotionData> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f8850a;

    /* renamed from: androidx.media3.extractor.metadata.mp4.SlowMotionData$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<SlowMotionData> {
        @Override // android.os.Parcelable.Creator
        public final SlowMotionData createFromParcel(Parcel parcel) {
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, Segment.class.getClassLoader());
            return new SlowMotionData(arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public final SlowMotionData[] newArray(int i2) {
            return new SlowMotionData[i2];
        }
    }

    public static final class Segment implements Parcelable {
        public static final Parcelable.Creator<Segment> CREATOR = new AnonymousClass1();

        /* renamed from: a, reason: collision with root package name */
        public final long f8851a;

        /* renamed from: b, reason: collision with root package name */
        public final long f8852b;

        /* renamed from: c, reason: collision with root package name */
        public final int f8853c;

        /* renamed from: androidx.media3.extractor.metadata.mp4.SlowMotionData$Segment$1, reason: invalid class name */
        public class AnonymousClass1 implements Parcelable.Creator<Segment> {
            @Override // android.os.Parcelable.Creator
            public final Segment createFromParcel(Parcel parcel) {
                return new Segment(parcel.readLong(), parcel.readLong(), parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            public final Segment[] newArray(int i2) {
                return new Segment[i2];
            }
        }

        public Segment(long j2, long j3, int i2) {
            Assertions.a(j2 < j3);
            this.f8851a = j2;
            this.f8852b = j3;
            this.f8853c = i2;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && Segment.class == obj.getClass()) {
                Segment segment = (Segment) obj;
                if (this.f8851a == segment.f8851a && this.f8852b == segment.f8852b && this.f8853c == segment.f8853c) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{Long.valueOf(this.f8851a), Long.valueOf(this.f8852b), Integer.valueOf(this.f8853c)});
        }

        public final String toString() {
            int i2 = Util.f5744a;
            Locale locale = Locale.US;
            return "Segment: startTimeMs=" + this.f8851a + ", endTimeMs=" + this.f8852b + ", speedDivisor=" + this.f8853c;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            parcel.writeLong(this.f8851a);
            parcel.writeLong(this.f8852b);
            parcel.writeInt(this.f8853c);
        }
    }

    public SlowMotionData(ArrayList arrayList) {
        this.f8850a = arrayList;
        boolean z = false;
        if (!arrayList.isEmpty()) {
            long j2 = ((Segment) arrayList.get(0)).f8852b;
            int i2 = 1;
            while (true) {
                if (i2 >= arrayList.size()) {
                    break;
                }
                if (((Segment) arrayList.get(i2)).f8851a < j2) {
                    z = true;
                    break;
                } else {
                    j2 = ((Segment) arrayList.get(i2)).f8852b;
                    i2++;
                }
            }
        }
        Assertions.a(!z);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SlowMotionData.class != obj.getClass()) {
            return false;
        }
        return this.f8850a.equals(((SlowMotionData) obj).f8850a);
    }

    public final int hashCode() {
        return this.f8850a.hashCode();
    }

    public final String toString() {
        return "SlowMotion: segments=" + this.f8850a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeList(this.f8850a);
    }
}
