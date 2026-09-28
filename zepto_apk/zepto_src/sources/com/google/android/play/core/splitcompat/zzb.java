package com.google.android.play.core.splitcompat;

import android.support.v4.media.b;
import java.io.File;

/* loaded from: classes4.dex */
final class zzb extends zzt {

    /* renamed from: a, reason: collision with root package name */
    public final File f41905a;

    /* renamed from: b, reason: collision with root package name */
    public final String f41906b;

    public zzb(File file, String str) {
        this.f41905a = file;
        if (str == null) {
            throw new NullPointerException("Null splitId");
        }
        this.f41906b = str;
    }

    @Override // com.google.android.play.core.splitcompat.zzt
    public final File a() {
        return this.f41905a;
    }

    @Override // com.google.android.play.core.splitcompat.zzt
    public final String b() {
        return this.f41906b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzt)) {
            return false;
        }
        zzt zztVar = (zzt) obj;
        return this.f41905a.equals(zztVar.a()) && this.f41906b.equals(zztVar.b());
    }

    public final int hashCode() {
        return ((this.f41905a.hashCode() ^ 1000003) * 1000003) ^ this.f41906b.hashCode();
    }

    public final String toString() {
        return b.r(b.y("SplitFileInfo{splitFile=", this.f41905a.toString(), ", splitId="), this.f41906b, "}");
    }
}
