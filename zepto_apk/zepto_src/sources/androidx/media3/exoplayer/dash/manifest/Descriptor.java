package androidx.media3.exoplayer.dash.manifest;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

@UnstableApi
/* loaded from: classes3.dex */
public final class Descriptor {

    /* renamed from: a, reason: collision with root package name */
    public final String f6815a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6816b;

    /* renamed from: c, reason: collision with root package name */
    public final String f6817c;

    public Descriptor(String str, String str2, String str3) {
        this.f6815a = str;
        this.f6816b = str2;
        this.f6817c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Descriptor.class == obj.getClass()) {
            Descriptor descriptor = (Descriptor) obj;
            if (Util.a(this.f6815a, descriptor.f6815a) && Util.a(this.f6816b, descriptor.f6816b) && Util.a(this.f6817c, descriptor.f6817c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f6815a.hashCode() * 31;
        String str = this.f6816b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f6817c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }
}
