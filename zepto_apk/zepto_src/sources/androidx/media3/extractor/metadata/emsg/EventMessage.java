package androidx.media3.extractor.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.Arrays;

@UnstableApi
/* loaded from: classes3.dex */
public final class EventMessage implements Metadata.Entry {
    public static final Parcelable.Creator<EventMessage> CREATOR;

    /* renamed from: g, reason: collision with root package name */
    public static final Format f8768g;

    /* renamed from: h, reason: collision with root package name */
    public static final Format f8769h;

    /* renamed from: a, reason: collision with root package name */
    public final String f8770a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8771b;

    /* renamed from: c, reason: collision with root package name */
    public final long f8772c;

    /* renamed from: d, reason: collision with root package name */
    public final long f8773d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f8774e;

    /* renamed from: f, reason: collision with root package name */
    public int f8775f;

    /* renamed from: androidx.media3.extractor.metadata.emsg.EventMessage$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<EventMessage> {
        @Override // android.os.Parcelable.Creator
        public final EventMessage createFromParcel(Parcel parcel) {
            return new EventMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final EventMessage[] newArray(int i2) {
            return new EventMessage[i2];
        }
    }

    static {
        Format.Builder builder = new Format.Builder();
        builder.f5237l = MimeTypes.p("application/id3");
        f8768g = new Format(builder);
        Format.Builder builder2 = new Format.Builder();
        builder2.f5237l = MimeTypes.p("application/x-scte35");
        f8769h = new Format(builder2);
        CREATOR = new AnonymousClass1();
    }

    public EventMessage(String str, String str2, long j2, long j3, byte[] bArr) {
        this.f8770a = str;
        this.f8771b = str2;
        this.f8772c = j2;
        this.f8773d = j3;
        this.f8774e = bArr;
    }

    @Override // androidx.media3.common.Metadata.Entry
    public final byte[] T7() {
        if (z0() != null) {
            return this.f8774e;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && EventMessage.class == obj.getClass()) {
            EventMessage eventMessage = (EventMessage) obj;
            if (this.f8772c == eventMessage.f8772c && this.f8773d == eventMessage.f8773d && Util.a(this.f8770a, eventMessage.f8770a) && Util.a(this.f8771b, eventMessage.f8771b) && Arrays.equals(this.f8774e, eventMessage.f8774e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.f8775f == 0) {
            String str = this.f8770a;
            int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f8771b;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            long j2 = this.f8772c;
            int i2 = (iHashCode2 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.f8773d;
            this.f8775f = Arrays.hashCode(this.f8774e) + ((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31);
        }
        return this.f8775f;
    }

    public final String toString() {
        return "EMSG: scheme=" + this.f8770a + ", id=" + this.f8773d + ", durationMs=" + this.f8772c + ", value=" + this.f8771b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f8770a);
        parcel.writeString(this.f8771b);
        parcel.writeLong(this.f8772c);
        parcel.writeLong(this.f8773d);
        parcel.writeByteArray(this.f8774e);
    }

    @Override // androidx.media3.common.Metadata.Entry
    public final Format z0() {
        String str = this.f8770a;
        str.getClass();
        switch (str) {
            case "urn:scte:scte35:2014:bin":
                return f8769h;
            case "https://aomedia.org/emsg/ID3":
            case "https://developer.apple.com/streaming/emsg-id3":
                return f8768g;
            default:
                return null;
        }
    }

    public EventMessage(Parcel parcel) {
        String string = parcel.readString();
        int i2 = Util.f5744a;
        this.f8770a = string;
        this.f8771b = parcel.readString();
        this.f8772c = parcel.readLong();
        this.f8773d = parcel.readLong();
        this.f8774e = parcel.createByteArray();
    }
}
