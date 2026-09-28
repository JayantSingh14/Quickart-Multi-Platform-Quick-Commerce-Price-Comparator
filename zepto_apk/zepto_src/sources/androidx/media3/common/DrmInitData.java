package androidx.media3.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.e;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.UUID;

@UnstableApi
/* loaded from: classes3.dex */
public final class DrmInitData implements Comparator<SchemeData>, Parcelable {
    public static final Parcelable.Creator<DrmInitData> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final SchemeData[] f5201a;

    /* renamed from: b, reason: collision with root package name */
    public int f5202b;

    /* renamed from: c, reason: collision with root package name */
    public final String f5203c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5204d;

    /* renamed from: androidx.media3.common.DrmInitData$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<DrmInitData> {
        @Override // android.os.Parcelable.Creator
        public final DrmInitData createFromParcel(Parcel parcel) {
            return new DrmInitData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final DrmInitData[] newArray(int i2) {
            return new DrmInitData[i2];
        }
    }

    public DrmInitData(String str, ArrayList arrayList) {
        this(str, false, (SchemeData[]) arrayList.toArray(new SchemeData[0]));
    }

    public final DrmInitData a(String str) {
        return Util.a(this.f5203c, str) ? this : new DrmInitData(str, false, this.f5201a);
    }

    @Override // java.util.Comparator
    public final int compare(SchemeData schemeData, SchemeData schemeData2) {
        SchemeData schemeData3 = schemeData;
        SchemeData schemeData4 = schemeData2;
        UUID uuid = C.f5164a;
        return uuid.equals(schemeData3.f5206b) ? uuid.equals(schemeData4.f5206b) ? 0 : 1 : schemeData3.f5206b.compareTo(schemeData4.f5206b);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && DrmInitData.class == obj.getClass()) {
            DrmInitData drmInitData = (DrmInitData) obj;
            if (Util.a(this.f5203c, drmInitData.f5203c) && Arrays.equals(this.f5201a, drmInitData.f5201a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.f5202b == 0) {
            String str = this.f5203c;
            this.f5202b = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.f5201a);
        }
        return this.f5202b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f5203c);
        parcel.writeTypedArray(this.f5201a, 0);
    }

    public DrmInitData(SchemeData... schemeDataArr) {
        this(null, true, schemeDataArr);
    }

    public DrmInitData(String str, boolean z, SchemeData... schemeDataArr) {
        this.f5203c = str;
        schemeDataArr = z ? (SchemeData[]) schemeDataArr.clone() : schemeDataArr;
        this.f5201a = schemeDataArr;
        this.f5204d = schemeDataArr.length;
        Arrays.sort(schemeDataArr, this);
    }

    public static final class SchemeData implements Parcelable {
        public static final Parcelable.Creator<SchemeData> CREATOR = new AnonymousClass1();

        /* renamed from: a, reason: collision with root package name */
        public int f5205a;

        /* renamed from: b, reason: collision with root package name */
        public final UUID f5206b;

        /* renamed from: c, reason: collision with root package name */
        public final String f5207c;

        /* renamed from: d, reason: collision with root package name */
        public final String f5208d;

        /* renamed from: e, reason: collision with root package name */
        public final byte[] f5209e;

        /* renamed from: androidx.media3.common.DrmInitData$SchemeData$1, reason: invalid class name */
        public class AnonymousClass1 implements Parcelable.Creator<SchemeData> {
            @Override // android.os.Parcelable.Creator
            public final SchemeData createFromParcel(Parcel parcel) {
                return new SchemeData(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final SchemeData[] newArray(int i2) {
                return new SchemeData[i2];
            }
        }

        public SchemeData(UUID uuid, String str, String str2, byte[] bArr) {
            uuid.getClass();
            this.f5206b = uuid;
            this.f5207c = str;
            str2.getClass();
            this.f5208d = MimeTypes.p(str2);
            this.f5209e = bArr;
        }

        public final boolean a(UUID uuid) {
            UUID uuid2 = C.f5164a;
            UUID uuid3 = this.f5206b;
            return uuid2.equals(uuid3) || uuid.equals(uuid3);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof SchemeData)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            SchemeData schemeData = (SchemeData) obj;
            return Util.a(this.f5207c, schemeData.f5207c) && Util.a(this.f5208d, schemeData.f5208d) && Util.a(this.f5206b, schemeData.f5206b) && Arrays.equals(this.f5209e, schemeData.f5209e);
        }

        public final int hashCode() {
            if (this.f5205a == 0) {
                int iHashCode = this.f5206b.hashCode() * 31;
                String str = this.f5207c;
                this.f5205a = Arrays.hashCode(this.f5209e) + e.e((iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31, this.f5208d);
            }
            return this.f5205a;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            UUID uuid = this.f5206b;
            parcel.writeLong(uuid.getMostSignificantBits());
            parcel.writeLong(uuid.getLeastSignificantBits());
            parcel.writeString(this.f5207c);
            parcel.writeString(this.f5208d);
            parcel.writeByteArray(this.f5209e);
        }

        public SchemeData(Parcel parcel) {
            this.f5206b = new UUID(parcel.readLong(), parcel.readLong());
            this.f5207c = parcel.readString();
            String string = parcel.readString();
            int i2 = Util.f5744a;
            this.f5208d = string;
            this.f5209e = parcel.createByteArray();
        }
    }

    public DrmInitData(Parcel parcel) {
        this.f5203c = parcel.readString();
        SchemeData[] schemeDataArr = (SchemeData[]) parcel.createTypedArray(SchemeData.CREATOR);
        int i2 = Util.f5744a;
        this.f5201a = schemeDataArr;
        this.f5204d = schemeDataArr.length;
    }
}
