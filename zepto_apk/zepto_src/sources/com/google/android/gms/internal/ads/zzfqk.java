package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdFormat;
import java.util.Locale;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzfqk {

    /* renamed from: a, reason: collision with root package name */
    public final String f31643a;

    /* renamed from: b, reason: collision with root package name */
    public final AdFormat f31644b;

    /* renamed from: c, reason: collision with root package name */
    public final String f31645c;

    public /* synthetic */ zzfqk(zzfqj zzfqjVar) {
        this.f31643a = zzfqjVar.f31640a;
        this.f31644b = zzfqjVar.f31641b;
        this.f31645c = zzfqjVar.f31642c;
    }

    public final String a() {
        AdFormat adFormat = this.f31644b;
        return adFormat == null ? com.google.ads.interactivemedia.v3.impl.data.zzck.UNKNOWN_CONTENT_TYPE : adFormat.name().toLowerCase(Locale.ENGLISH);
    }

    public final boolean equals(Object obj) {
        AdFormat adFormat;
        AdFormat adFormat2;
        if (obj instanceof zzfqk) {
            zzfqk zzfqkVar = (zzfqk) obj;
            if (this.f31643a.equals(zzfqkVar.f31643a) && (adFormat = this.f31644b) != null && (adFormat2 = zzfqkVar.f31644b) != null && adFormat.equals(adFormat2)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f31643a, this.f31644b);
    }
}
