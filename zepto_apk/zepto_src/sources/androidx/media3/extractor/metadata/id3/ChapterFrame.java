package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.Arrays;

@UnstableApi
/* loaded from: classes3.dex */
public final class ChapterFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterFrame> CREATOR = new AnonymousClass1();

    /* renamed from: b, reason: collision with root package name */
    public final String f8805b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8806c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8807d;

    /* renamed from: e, reason: collision with root package name */
    public final long f8808e;

    /* renamed from: f, reason: collision with root package name */
    public final long f8809f;

    /* renamed from: g, reason: collision with root package name */
    public final Id3Frame[] f8810g;

    /* renamed from: androidx.media3.extractor.metadata.id3.ChapterFrame$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<ChapterFrame> {
        @Override // android.os.Parcelable.Creator
        public final ChapterFrame createFromParcel(Parcel parcel) {
            return new ChapterFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final ChapterFrame[] newArray(int i2) {
            return new ChapterFrame[i2];
        }
    }

    public ChapterFrame(String str, int i2, int i3, long j2, long j3, Id3Frame[] id3FrameArr) {
        super("CHAP");
        this.f8805b = str;
        this.f8806c = i2;
        this.f8807d = i3;
        this.f8808e = j2;
        this.f8809f = j3;
        this.f8810g = id3FrameArr;
    }

    @Override // androidx.media3.extractor.metadata.id3.Id3Frame, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ChapterFrame.class == obj.getClass()) {
            ChapterFrame chapterFrame = (ChapterFrame) obj;
            if (this.f8806c == chapterFrame.f8806c && this.f8807d == chapterFrame.f8807d && this.f8808e == chapterFrame.f8808e && this.f8809f == chapterFrame.f8809f && Util.a(this.f8805b, chapterFrame.f8805b) && Arrays.equals(this.f8810g, chapterFrame.f8810g)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = (((((((527 + this.f8806c) * 31) + this.f8807d) * 31) + ((int) this.f8808e)) * 31) + ((int) this.f8809f)) * 31;
        String str = this.f8805b;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f8805b);
        parcel.writeInt(this.f8806c);
        parcel.writeInt(this.f8807d);
        parcel.writeLong(this.f8808e);
        parcel.writeLong(this.f8809f);
        Id3Frame[] id3FrameArr = this.f8810g;
        parcel.writeInt(id3FrameArr.length);
        for (Id3Frame id3Frame : id3FrameArr) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }

    public ChapterFrame(Parcel parcel) {
        super("CHAP");
        String string = parcel.readString();
        int i2 = Util.f5744a;
        this.f8805b = string;
        this.f8806c = parcel.readInt();
        this.f8807d = parcel.readInt();
        this.f8808e = parcel.readLong();
        this.f8809f = parcel.readLong();
        int i3 = parcel.readInt();
        this.f8810g = new Id3Frame[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            this.f8810g[i4] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }
}
