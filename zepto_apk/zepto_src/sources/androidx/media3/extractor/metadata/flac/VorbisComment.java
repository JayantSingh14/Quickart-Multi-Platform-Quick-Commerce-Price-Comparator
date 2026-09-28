package androidx.media3.extractor.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.e;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.base.Ascii;

@UnstableApi
@Deprecated
/* loaded from: classes3.dex */
public class VorbisComment implements Metadata.Entry {
    public static final Parcelable.Creator<VorbisComment> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final String f8786a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8787b;

    /* renamed from: androidx.media3.extractor.metadata.flac.VorbisComment$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<VorbisComment> {
        @Override // android.os.Parcelable.Creator
        public final VorbisComment createFromParcel(Parcel parcel) {
            return new VorbisComment(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final VorbisComment[] newArray(int i2) {
            return new VorbisComment[i2];
        }
    }

    public VorbisComment(String str, String str2) {
        this.f8786a = Ascii.c(str);
        this.f8787b = str2;
    }

    @Override // androidx.media3.common.Metadata.Entry
    public final void A4(MediaMetadata.Builder builder) {
        String str;
        String str2 = this.f8786a;
        str2.getClass();
        str = this.f8787b;
        switch (str2) {
            case "ALBUM":
                builder.f5394c = str;
                break;
            case "TITLE":
                builder.f5392a = str;
                break;
            case "DESCRIPTION":
                builder.f5398g = str;
                break;
            case "ALBUMARTIST":
                builder.f5395d = str;
                break;
            case "ARTIST":
                builder.f5393b = str;
                break;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            VorbisComment vorbisComment = (VorbisComment) obj;
            if (this.f8786a.equals(vorbisComment.f8786a) && this.f8787b.equals(vorbisComment.f8787b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f8787b.hashCode() + e.e(527, 31, this.f8786a);
    }

    public final String toString() {
        return "VC: " + this.f8786a + "=" + this.f8787b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f8786a);
        parcel.writeString(this.f8787b);
    }

    public VorbisComment(Parcel parcel) {
        String string = parcel.readString();
        int i2 = Util.f5744a;
        this.f8786a = string;
        this.f8787b = parcel.readString();
    }
}
