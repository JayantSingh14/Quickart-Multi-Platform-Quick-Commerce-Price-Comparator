package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

@UnstableApi
/* loaded from: classes3.dex */
public final class CommentFrame extends Id3Frame {
    public static final Parcelable.Creator<CommentFrame> CREATOR = new AnonymousClass1();

    /* renamed from: b, reason: collision with root package name */
    public final String f8816b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8817c;

    /* renamed from: d, reason: collision with root package name */
    public final String f8818d;

    /* renamed from: androidx.media3.extractor.metadata.id3.CommentFrame$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<CommentFrame> {
        @Override // android.os.Parcelable.Creator
        public final CommentFrame createFromParcel(Parcel parcel) {
            return new CommentFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final CommentFrame[] newArray(int i2) {
            return new CommentFrame[i2];
        }
    }

    public CommentFrame(String str, String str2, String str3) {
        super("COMM");
        this.f8816b = str;
        this.f8817c = str2;
        this.f8818d = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && CommentFrame.class == obj.getClass()) {
            CommentFrame commentFrame = (CommentFrame) obj;
            if (Util.a(this.f8817c, commentFrame.f8817c) && Util.a(this.f8816b, commentFrame.f8816b) && Util.a(this.f8818d, commentFrame.f8818d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f8816b;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f8817c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f8818d;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // androidx.media3.extractor.metadata.id3.Id3Frame
    public final String toString() {
        return this.f8828a + ": language=" + this.f8816b + ", description=" + this.f8817c + ", text=" + this.f8818d;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f8828a);
        parcel.writeString(this.f8816b);
        parcel.writeString(this.f8818d);
    }

    public CommentFrame(Parcel parcel) {
        super("COMM");
        String string = parcel.readString();
        int i2 = Util.f5744a;
        this.f8816b = string;
        this.f8817c = parcel.readString();
        this.f8818d = parcel.readString();
    }
}
