package androidx.media3.extractor.metadata.dvbsi;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes3.dex */
public final class AppInfoTable implements Metadata.Entry {
    public static final Parcelable.Creator<AppInfoTable> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final int f8766a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8767b;

    /* renamed from: androidx.media3.extractor.metadata.dvbsi.AppInfoTable$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<AppInfoTable> {
        @Override // android.os.Parcelable.Creator
        public final AppInfoTable createFromParcel(Parcel parcel) {
            String string = parcel.readString();
            string.getClass();
            return new AppInfoTable(parcel.readInt(), string);
        }

        @Override // android.os.Parcelable.Creator
        public final AppInfoTable[] newArray(int i2) {
            return new AppInfoTable[i2];
        }
    }

    public AppInfoTable(int i2, String str) {
        this.f8766a = i2;
        this.f8767b = str;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Ait(controlCode=");
        sb.append(this.f8766a);
        sb.append(",url=");
        return b.r(sb, this.f8767b, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f8767b);
        parcel.writeInt(this.f8766a);
    }
}
