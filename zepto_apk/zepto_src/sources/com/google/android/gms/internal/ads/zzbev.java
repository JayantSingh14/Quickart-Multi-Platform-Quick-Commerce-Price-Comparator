package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@SafeParcelable.Class(creator = "CacheOfferingCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class zzbev extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbev> CREATOR = new zzbew();

    /* renamed from: a, reason: collision with root package name */
    public final String f24857a;

    /* renamed from: b, reason: collision with root package name */
    public final long f24858b;

    /* renamed from: c, reason: collision with root package name */
    public final String f24859c;

    /* renamed from: d, reason: collision with root package name */
    public final String f24860d;

    /* renamed from: e, reason: collision with root package name */
    public final String f24861e;

    /* renamed from: f, reason: collision with root package name */
    public final Bundle f24862f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f24863g;

    /* renamed from: h, reason: collision with root package name */
    public long f24864h;

    /* renamed from: i, reason: collision with root package name */
    public String f24865i;

    /* renamed from: j, reason: collision with root package name */
    public int f24866j;

    public zzbev(String str, long j2, String str2, String str3, String str4, Bundle bundle, boolean z, long j3, String str5, int i2) {
        this.f24857a = str;
        this.f24858b = j2;
        this.f24859c = str2 == null ? "" : str2;
        this.f24860d = str3 == null ? "" : str3;
        this.f24861e = str4 == null ? "" : str4;
        this.f24862f = bundle == null ? new Bundle() : bundle;
        this.f24863g = z;
        this.f24864h = j3;
        this.f24865i = str5;
        this.f24866j = i2;
    }

    public static zzbev b(Uri uri) {
        try {
            if (!"gcache".equals(uri.getScheme())) {
                return null;
            }
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.size() != 2) {
                int size = pathSegments.size();
                StringBuilder sb = new StringBuilder(String.valueOf(size).length() + 51);
                sb.append("Expected 2 path parts for namespace and id, found :");
                sb.append(size);
                String string = sb.toString();
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.f(string);
                return null;
            }
            String str = pathSegments.get(0);
            String str2 = pathSegments.get(1);
            String host = uri.getHost();
            String queryParameter = uri.getQueryParameter("url");
            boolean zEquals = "1".equals(uri.getQueryParameter("read_only"));
            String queryParameter2 = uri.getQueryParameter("expiration");
            long j2 = queryParameter2 == null ? 0L : Long.parseLong(queryParameter2);
            Bundle bundle = new Bundle();
            for (String str3 : uri.getQueryParameterNames()) {
                if (str3.startsWith("tag.")) {
                    bundle.putString(str3.substring(4), uri.getQueryParameter(str3));
                }
            }
            return new zzbev(queryParameter, j2, host, str, str2, bundle, zEquals, 0L, "", 0);
        } catch (NullPointerException e2) {
            e = e2;
            int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Unable to parse Uri into cache offering.", e);
            return null;
        } catch (NumberFormatException e3) {
            e = e3;
            int i32 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Unable to parse Uri into cache offering.", e);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.f24857a, false);
        SafeParcelWriter.writeLong(parcel, 3, this.f24858b);
        SafeParcelWriter.writeString(parcel, 4, this.f24859c, false);
        SafeParcelWriter.writeString(parcel, 5, this.f24860d, false);
        SafeParcelWriter.writeString(parcel, 6, this.f24861e, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.f24862f, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.f24863g);
        SafeParcelWriter.writeLong(parcel, 9, this.f24864h);
        SafeParcelWriter.writeString(parcel, 10, this.f24865i, false);
        SafeParcelWriter.writeInt(parcel, 11, this.f24866j);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
