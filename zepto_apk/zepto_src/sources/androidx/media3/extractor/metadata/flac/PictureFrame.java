package androidx.media3.extractor.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.e;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.base.Charsets;
import java.util.Arrays;

@UnstableApi
/* loaded from: classes3.dex */
public final class PictureFrame implements Metadata.Entry {
    public static final Parcelable.Creator<PictureFrame> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final int f8778a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8779b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8780c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8781d;

    /* renamed from: e, reason: collision with root package name */
    public final int f8782e;

    /* renamed from: f, reason: collision with root package name */
    public final int f8783f;

    /* renamed from: g, reason: collision with root package name */
    public final int f8784g;

    /* renamed from: h, reason: collision with root package name */
    public final byte[] f8785h;

    /* renamed from: androidx.media3.extractor.metadata.flac.PictureFrame$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<PictureFrame> {
        @Override // android.os.Parcelable.Creator
        public final PictureFrame createFromParcel(Parcel parcel) {
            return new PictureFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final PictureFrame[] newArray(int i2) {
            return new PictureFrame[i2];
        }
    }

    public PictureFrame(int i2, String str, String str2, int i3, int i4, int i5, int i6, byte[] bArr) {
        this.f8778a = i2;
        this.f8779b = str;
        this.f8780c = str2;
        this.f8781d = i3;
        this.f8782e = i4;
        this.f8783f = i5;
        this.f8784g = i6;
        this.f8785h = bArr;
    }

    public static PictureFrame a(ParsableByteArray parsableByteArray) {
        int iJ = parsableByteArray.j();
        String strP = MimeTypes.p(parsableByteArray.v(parsableByteArray.j(), Charsets.f42258a));
        String strV = parsableByteArray.v(parsableByteArray.j(), Charsets.f42260c);
        int iJ2 = parsableByteArray.j();
        int iJ3 = parsableByteArray.j();
        int iJ4 = parsableByteArray.j();
        int iJ5 = parsableByteArray.j();
        int iJ6 = parsableByteArray.j();
        byte[] bArr = new byte[iJ6];
        parsableByteArray.h(0, bArr, iJ6);
        return new PictureFrame(iJ, strP, strV, iJ2, iJ3, iJ4, iJ5, bArr);
    }

    @Override // androidx.media3.common.Metadata.Entry
    public final void A4(MediaMetadata.Builder builder) {
        builder.a(this.f8778a, this.f8785h);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && PictureFrame.class == obj.getClass()) {
            PictureFrame pictureFrame = (PictureFrame) obj;
            if (this.f8778a == pictureFrame.f8778a && this.f8779b.equals(pictureFrame.f8779b) && this.f8780c.equals(pictureFrame.f8780c) && this.f8781d == pictureFrame.f8781d && this.f8782e == pictureFrame.f8782e && this.f8783f == pictureFrame.f8783f && this.f8784g == pictureFrame.f8784g && Arrays.equals(this.f8785h, pictureFrame.f8785h)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f8785h) + ((((((((e.e(e.e((527 + this.f8778a) * 31, 31, this.f8779b), 31, this.f8780c) + this.f8781d) * 31) + this.f8782e) * 31) + this.f8783f) * 31) + this.f8784g) * 31);
    }

    public final String toString() {
        return "Picture: mimeType=" + this.f8779b + ", description=" + this.f8780c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f8778a);
        parcel.writeString(this.f8779b);
        parcel.writeString(this.f8780c);
        parcel.writeInt(this.f8781d);
        parcel.writeInt(this.f8782e);
        parcel.writeInt(this.f8783f);
        parcel.writeInt(this.f8784g);
        parcel.writeByteArray(this.f8785h);
    }

    public PictureFrame(Parcel parcel) {
        this.f8778a = parcel.readInt();
        String string = parcel.readString();
        int i2 = Util.f5744a;
        this.f8779b = string;
        this.f8780c = parcel.readString();
        this.f8781d = parcel.readInt();
        this.f8782e = parcel.readInt();
        this.f8783f = parcel.readInt();
        this.f8784g = parcel.readInt();
        this.f8785h = parcel.createByteArray();
    }
}
