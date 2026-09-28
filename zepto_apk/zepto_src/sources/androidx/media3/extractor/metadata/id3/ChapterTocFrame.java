package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.Arrays;

@UnstableApi
/* loaded from: classes3.dex */
public final class ChapterTocFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterTocFrame> CREATOR = new AnonymousClass1();

    /* renamed from: b, reason: collision with root package name */
    public final String f8811b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f8812c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f8813d;

    /* renamed from: e, reason: collision with root package name */
    public final String[] f8814e;

    /* renamed from: f, reason: collision with root package name */
    public final Id3Frame[] f8815f;

    /* renamed from: androidx.media3.extractor.metadata.id3.ChapterTocFrame$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<ChapterTocFrame> {
        @Override // android.os.Parcelable.Creator
        public final ChapterTocFrame createFromParcel(Parcel parcel) {
            return new ChapterTocFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final ChapterTocFrame[] newArray(int i2) {
            return new ChapterTocFrame[i2];
        }
    }

    public ChapterTocFrame(String str, boolean z, boolean z2, String[] strArr, Id3Frame[] id3FrameArr) {
        super("CTOC");
        this.f8811b = str;
        this.f8812c = z;
        this.f8813d = z2;
        this.f8814e = strArr;
        this.f8815f = id3FrameArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ChapterTocFrame.class == obj.getClass()) {
            ChapterTocFrame chapterTocFrame = (ChapterTocFrame) obj;
            if (this.f8812c == chapterTocFrame.f8812c && this.f8813d == chapterTocFrame.f8813d && Util.a(this.f8811b, chapterTocFrame.f8811b) && Arrays.equals(this.f8814e, chapterTocFrame.f8814e) && Arrays.equals(this.f8815f, chapterTocFrame.f8815f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = (((527 + (this.f8812c ? 1 : 0)) * 31) + (this.f8813d ? 1 : 0)) * 31;
        String str = this.f8811b;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f8811b);
        parcel.writeByte(this.f8812c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8813d ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.f8814e);
        Id3Frame[] id3FrameArr = this.f8815f;
        parcel.writeInt(id3FrameArr.length);
        for (Id3Frame id3Frame : id3FrameArr) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }

    public ChapterTocFrame(Parcel parcel) {
        super("CTOC");
        String string = parcel.readString();
        int i2 = Util.f5744a;
        this.f8811b = string;
        this.f8812c = parcel.readByte() != 0;
        this.f8813d = parcel.readByte() != 0;
        this.f8814e = parcel.createStringArray();
        int i3 = parcel.readInt();
        this.f8815f = new Id3Frame[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            this.f8815f[i4] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }
}
