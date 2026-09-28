package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.e;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

@UnstableApi
/* loaded from: classes3.dex */
public final class UrlLinkFrame extends Id3Frame {
    public static final Parcelable.Creator<UrlLinkFrame> CREATOR = new AnonymousClass1();

    /* renamed from: b, reason: collision with root package name */
    public final String f8843b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8844c;

    /* renamed from: androidx.media3.extractor.metadata.id3.UrlLinkFrame$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<UrlLinkFrame> {
        @Override // android.os.Parcelable.Creator
        public final UrlLinkFrame createFromParcel(Parcel parcel) {
            return new UrlLinkFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final UrlLinkFrame[] newArray(int i2) {
            return new UrlLinkFrame[i2];
        }
    }

    public UrlLinkFrame(String str, String str2, String str3) {
        super(str);
        this.f8843b = str2;
        this.f8844c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && UrlLinkFrame.class == obj.getClass()) {
            UrlLinkFrame urlLinkFrame = (UrlLinkFrame) obj;
            if (this.f8828a.equals(urlLinkFrame.f8828a) && Util.a(this.f8843b, urlLinkFrame.f8843b) && Util.a(this.f8844c, urlLinkFrame.f8844c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iE = e.e(527, 31, this.f8828a);
        String str = this.f8843b;
        int iHashCode = (iE + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f8844c;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // androidx.media3.extractor.metadata.id3.Id3Frame
    public final String toString() {
        return this.f8828a + ": url=" + this.f8844c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f8828a);
        parcel.writeString(this.f8843b);
        parcel.writeString(this.f8844c);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public UrlLinkFrame(Parcel parcel) {
        String string = parcel.readString();
        int i2 = Util.f5744a;
        super(string);
        this.f8843b = parcel.readString();
        this.f8844c = parcel.readString();
    }
}
