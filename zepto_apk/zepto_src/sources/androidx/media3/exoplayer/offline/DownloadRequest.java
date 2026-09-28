package androidx.media3.exoplayer.offline;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.StreamKey;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public final class DownloadRequest implements Parcelable {
    public static final Parcelable.Creator<DownloadRequest> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final String f7371a;

    /* renamed from: b, reason: collision with root package name */
    public final Uri f7372b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7373c;

    /* renamed from: d, reason: collision with root package name */
    public final List f7374d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f7375e;

    /* renamed from: f, reason: collision with root package name */
    public final String f7376f;

    /* renamed from: g, reason: collision with root package name */
    public final byte[] f7377g;

    /* renamed from: androidx.media3.exoplayer.offline.DownloadRequest$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<DownloadRequest> {
        @Override // android.os.Parcelable.Creator
        public final DownloadRequest createFromParcel(Parcel parcel) {
            return new DownloadRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final DownloadRequest[] newArray(int i2) {
            return new DownloadRequest[i2];
        }
    }

    public static class Builder {
    }

    public static class UnsupportedRequestException extends IOException {
    }

    public DownloadRequest(Parcel parcel) {
        String string = parcel.readString();
        int i2 = Util.f5744a;
        this.f7371a = string;
        this.f7372b = Uri.parse(parcel.readString());
        this.f7373c = parcel.readString();
        int i3 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i3);
        for (int i4 = 0; i4 < i3; i4++) {
            arrayList.add((StreamKey) parcel.readParcelable(StreamKey.class.getClassLoader()));
        }
        this.f7374d = Collections.unmodifiableList(arrayList);
        this.f7375e = parcel.createByteArray();
        this.f7376f = parcel.readString();
        this.f7377g = parcel.createByteArray();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof DownloadRequest)) {
            return false;
        }
        DownloadRequest downloadRequest = (DownloadRequest) obj;
        return this.f7371a.equals(downloadRequest.f7371a) && this.f7372b.equals(downloadRequest.f7372b) && Util.a(this.f7373c, downloadRequest.f7373c) && this.f7374d.equals(downloadRequest.f7374d) && Arrays.equals(this.f7375e, downloadRequest.f7375e) && Util.a(this.f7376f, downloadRequest.f7376f) && Arrays.equals(this.f7377g, downloadRequest.f7377g);
    }

    public final int hashCode() {
        int iHashCode = (this.f7372b.hashCode() + (this.f7371a.hashCode() * 961)) * 31;
        String str = this.f7373c;
        int iHashCode2 = (Arrays.hashCode(this.f7375e) + ((this.f7374d.hashCode() + ((iHashCode + (str != null ? str.hashCode() : 0)) * 31)) * 31)) * 31;
        String str2 = this.f7376f;
        return Arrays.hashCode(this.f7377g) + ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return this.f7373c + ":" + this.f7371a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f7371a);
        parcel.writeString(this.f7372b.toString());
        parcel.writeString(this.f7373c);
        List list = this.f7374d;
        parcel.writeInt(list.size());
        for (int i3 = 0; i3 < list.size(); i3++) {
            parcel.writeParcelable((Parcelable) list.get(i3), 0);
        }
        parcel.writeByteArray(this.f7375e);
        parcel.writeString(this.f7376f);
        parcel.writeByteArray(this.f7377g);
    }
}
