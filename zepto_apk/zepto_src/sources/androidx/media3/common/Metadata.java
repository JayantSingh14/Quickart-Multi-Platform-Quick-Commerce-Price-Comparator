package androidx.media3.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.primitives.Longs;
import java.util.Arrays;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public final class Metadata implements Parcelable {
    public static final Parcelable.Creator<Metadata> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final Entry[] f5405a;

    /* renamed from: b, reason: collision with root package name */
    public final long f5406b;

    /* renamed from: androidx.media3.common.Metadata$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<Metadata> {
        @Override // android.os.Parcelable.Creator
        public final Metadata createFromParcel(Parcel parcel) {
            return new Metadata(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final Metadata[] newArray(int i2) {
            return new Metadata[i2];
        }
    }

    public interface Entry extends Parcelable {
        default void A4(MediaMetadata.Builder builder) {
        }

        default byte[] T7() {
            return null;
        }

        default Format z0() {
            return null;
        }
    }

    public Metadata(Entry... entryArr) {
        this(-9223372036854775807L, entryArr);
    }

    public final Metadata a(Entry... entryArr) {
        if (entryArr.length == 0) {
            return this;
        }
        int i2 = Util.f5744a;
        Entry[] entryArr2 = this.f5405a;
        Object[] objArrCopyOf = Arrays.copyOf(entryArr2, entryArr2.length + entryArr.length);
        System.arraycopy(entryArr, 0, objArrCopyOf, entryArr2.length, entryArr.length);
        return new Metadata(this.f5406b, (Entry[]) objArrCopyOf);
    }

    public final Metadata b(Metadata metadata) {
        return metadata == null ? this : a(metadata.f5405a);
    }

    public final Entry c(int i2) {
        return this.f5405a[i2];
    }

    public final int d() {
        return this.f5405a.length;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Metadata.class == obj.getClass()) {
            Metadata metadata = (Metadata) obj;
            if (Arrays.equals(this.f5405a, metadata.f5405a) && this.f5406b == metadata.f5406b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Longs.a(this.f5406b) + (Arrays.hashCode(this.f5405a) * 31);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("entries=");
        sb.append(Arrays.toString(this.f5405a));
        long j2 = this.f5406b;
        if (j2 == -9223372036854775807L) {
            str = "";
        } else {
            str = ", presentationTimeUs=" + j2;
        }
        sb.append(str);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        Entry[] entryArr = this.f5405a;
        parcel.writeInt(entryArr.length);
        for (Entry entry : entryArr) {
            parcel.writeParcelable(entry, 0);
        }
        parcel.writeLong(this.f5406b);
    }

    public Metadata(long j2, Entry... entryArr) {
        this.f5406b = j2;
        this.f5405a = entryArr;
    }

    public Metadata(List list) {
        this((Entry[]) list.toArray(new Entry[0]));
    }

    public Metadata(Parcel parcel) {
        this.f5405a = new Entry[parcel.readInt()];
        int i2 = 0;
        while (true) {
            Entry[] entryArr = this.f5405a;
            if (i2 < entryArr.length) {
                entryArr[i2] = (Entry) parcel.readParcelable(Entry.class.getClassLoader());
                i2++;
            } else {
                this.f5406b = parcel.readLong();
                return;
            }
        }
    }
}
