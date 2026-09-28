package androidx.media3.extractor.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.UnstableApi;
import com.google.common.primitives.Longs;

@UnstableApi
/* loaded from: classes3.dex */
public final class MotionPhotoMetadata implements Metadata.Entry {
    public static final Parcelable.Creator<MotionPhotoMetadata> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final long f8845a;

    /* renamed from: b, reason: collision with root package name */
    public final long f8846b;

    /* renamed from: c, reason: collision with root package name */
    public final long f8847c;

    /* renamed from: d, reason: collision with root package name */
    public final long f8848d;

    /* renamed from: e, reason: collision with root package name */
    public final long f8849e;

    /* renamed from: androidx.media3.extractor.metadata.mp4.MotionPhotoMetadata$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<MotionPhotoMetadata> {
        @Override // android.os.Parcelable.Creator
        public final MotionPhotoMetadata createFromParcel(Parcel parcel) {
            return new MotionPhotoMetadata(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final MotionPhotoMetadata[] newArray(int i2) {
            return new MotionPhotoMetadata[i2];
        }
    }

    public MotionPhotoMetadata(long j2, long j3, long j4, long j5, long j6) {
        this.f8845a = j2;
        this.f8846b = j3;
        this.f8847c = j4;
        this.f8848d = j5;
        this.f8849e = j6;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && MotionPhotoMetadata.class == obj.getClass()) {
            MotionPhotoMetadata motionPhotoMetadata = (MotionPhotoMetadata) obj;
            if (this.f8845a == motionPhotoMetadata.f8845a && this.f8846b == motionPhotoMetadata.f8846b && this.f8847c == motionPhotoMetadata.f8847c && this.f8848d == motionPhotoMetadata.f8848d && this.f8849e == motionPhotoMetadata.f8849e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Longs.a(this.f8849e) + ((Longs.a(this.f8848d) + ((Longs.a(this.f8847c) + ((Longs.a(this.f8846b) + ((Longs.a(this.f8845a) + 527) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "Motion photo metadata: photoStartPosition=" + this.f8845a + ", photoSize=" + this.f8846b + ", photoPresentationTimestampUs=" + this.f8847c + ", videoStartPosition=" + this.f8848d + ", videoSize=" + this.f8849e;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f8845a);
        parcel.writeLong(this.f8846b);
        parcel.writeLong(this.f8847c);
        parcel.writeLong(this.f8848d);
        parcel.writeLong(this.f8849e);
    }

    public MotionPhotoMetadata(Parcel parcel) {
        this.f8845a = parcel.readLong();
        this.f8846b = parcel.readLong();
        this.f8847c = parcel.readLong();
        this.f8848d = parcel.readLong();
        this.f8849e = parcel.readLong();
    }
}
