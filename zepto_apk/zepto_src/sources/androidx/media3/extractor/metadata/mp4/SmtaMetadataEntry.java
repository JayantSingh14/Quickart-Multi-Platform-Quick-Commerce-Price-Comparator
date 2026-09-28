package androidx.media3.extractor.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes3.dex */
public final class SmtaMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<SmtaMetadataEntry> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final float f8854a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8855b;

    /* renamed from: androidx.media3.extractor.metadata.mp4.SmtaMetadataEntry$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<SmtaMetadataEntry> {
        @Override // android.os.Parcelable.Creator
        public final SmtaMetadataEntry createFromParcel(Parcel parcel) {
            return new SmtaMetadataEntry(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final SmtaMetadataEntry[] newArray(int i2) {
            return new SmtaMetadataEntry[i2];
        }
    }

    public SmtaMetadataEntry(float f2, int i2) {
        this.f8854a = f2;
        this.f8855b = i2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && SmtaMetadataEntry.class == obj.getClass()) {
            SmtaMetadataEntry smtaMetadataEntry = (SmtaMetadataEntry) obj;
            if (this.f8854a == smtaMetadataEntry.f8854a && this.f8855b == smtaMetadataEntry.f8855b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.valueOf(this.f8854a).hashCode() + 527) * 31) + this.f8855b;
    }

    public final String toString() {
        return "smta: captureFrameRate=" + this.f8854a + ", svcTemporalLayerCount=" + this.f8855b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeFloat(this.f8854a);
        parcel.writeInt(this.f8855b);
    }

    public SmtaMetadataEntry(Parcel parcel) {
        this.f8854a = parcel.readFloat();
        this.f8855b = parcel.readInt();
    }
}
