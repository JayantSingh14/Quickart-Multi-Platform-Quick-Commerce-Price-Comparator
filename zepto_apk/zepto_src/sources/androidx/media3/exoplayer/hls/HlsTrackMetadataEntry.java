package androidx.media3.exoplayer.hls;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.UnstableApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public final class HlsTrackMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<HlsTrackMetadataEntry> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final String f7060a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7061b;

    /* renamed from: c, reason: collision with root package name */
    public final List f7062c;

    /* renamed from: androidx.media3.exoplayer.hls.HlsTrackMetadataEntry$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<HlsTrackMetadataEntry> {
        @Override // android.os.Parcelable.Creator
        public final HlsTrackMetadataEntry createFromParcel(Parcel parcel) {
            return new HlsTrackMetadataEntry(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final HlsTrackMetadataEntry[] newArray(int i2) {
            return new HlsTrackMetadataEntry[i2];
        }
    }

    public HlsTrackMetadataEntry(String str, String str2, List list) {
        this.f7060a = str;
        this.f7061b = str2;
        this.f7062c = Collections.unmodifiableList(new ArrayList(list));
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && HlsTrackMetadataEntry.class == obj.getClass()) {
            HlsTrackMetadataEntry hlsTrackMetadataEntry = (HlsTrackMetadataEntry) obj;
            if (TextUtils.equals(this.f7060a, hlsTrackMetadataEntry.f7060a) && TextUtils.equals(this.f7061b, hlsTrackMetadataEntry.f7061b) && this.f7062c.equals(hlsTrackMetadataEntry.f7062c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f7060a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f7061b;
        return this.f7062c.hashCode() + ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("HlsTrackMetadataEntry");
        String str = this.f7060a;
        sb.append(str != null ? android.support.v4.media.b.r(android.support.v4.media.b.y(" [", str, ", "), this.f7061b, "]") : "");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f7060a);
        parcel.writeString(this.f7061b);
        List list = this.f7062c;
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeParcelable((Parcelable) list.get(i3), 0);
        }
    }

    public HlsTrackMetadataEntry(Parcel parcel) {
        this.f7060a = parcel.readString();
        this.f7061b = parcel.readString();
        int i2 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add((VariantInfo) parcel.readParcelable(VariantInfo.class.getClassLoader()));
        }
        this.f7062c = Collections.unmodifiableList(arrayList);
    }

    public static final class VariantInfo implements Parcelable {
        public static final Parcelable.Creator<VariantInfo> CREATOR = new AnonymousClass1();

        /* renamed from: a, reason: collision with root package name */
        public final int f7063a;

        /* renamed from: b, reason: collision with root package name */
        public final int f7064b;

        /* renamed from: c, reason: collision with root package name */
        public final String f7065c;

        /* renamed from: d, reason: collision with root package name */
        public final String f7066d;

        /* renamed from: e, reason: collision with root package name */
        public final String f7067e;

        /* renamed from: f, reason: collision with root package name */
        public final String f7068f;

        /* renamed from: androidx.media3.exoplayer.hls.HlsTrackMetadataEntry$VariantInfo$1, reason: invalid class name */
        public class AnonymousClass1 implements Parcelable.Creator<VariantInfo> {
            @Override // android.os.Parcelable.Creator
            public final VariantInfo createFromParcel(Parcel parcel) {
                return new VariantInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final VariantInfo[] newArray(int i2) {
                return new VariantInfo[i2];
            }
        }

        public VariantInfo(String str, String str2, int i2, int i3, String str3, String str4) {
            this.f7063a = i2;
            this.f7064b = i3;
            this.f7065c = str;
            this.f7066d = str2;
            this.f7067e = str3;
            this.f7068f = str4;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && VariantInfo.class == obj.getClass()) {
                VariantInfo variantInfo = (VariantInfo) obj;
                if (this.f7063a == variantInfo.f7063a && this.f7064b == variantInfo.f7064b && TextUtils.equals(this.f7065c, variantInfo.f7065c) && TextUtils.equals(this.f7066d, variantInfo.f7066d) && TextUtils.equals(this.f7067e, variantInfo.f7067e) && TextUtils.equals(this.f7068f, variantInfo.f7068f)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            int i2 = ((this.f7063a * 31) + this.f7064b) * 31;
            String str = this.f7065c;
            int iHashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f7066d;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f7067e;
            int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.f7068f;
            return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f7063a);
            parcel.writeInt(this.f7064b);
            parcel.writeString(this.f7065c);
            parcel.writeString(this.f7066d);
            parcel.writeString(this.f7067e);
            parcel.writeString(this.f7068f);
        }

        public VariantInfo(Parcel parcel) {
            this.f7063a = parcel.readInt();
            this.f7064b = parcel.readInt();
            this.f7065c = parcel.readString();
            this.f7066d = parcel.readString();
            this.f7067e = parcel.readString();
            this.f7068f = parcel.readString();
        }
    }
}
