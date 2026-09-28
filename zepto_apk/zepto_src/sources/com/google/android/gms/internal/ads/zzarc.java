package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* loaded from: classes4.dex */
public final class zzarc {

    /* renamed from: a, reason: collision with root package name */
    public final String f24198a;

    /* renamed from: b, reason: collision with root package name */
    public final String f24199b;

    public zzarc(String str, String str2) {
        this.f24198a = str;
        this.f24199b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzarc.class == obj.getClass()) {
            zzarc zzarcVar = (zzarc) obj;
            if (TextUtils.equals(this.f24198a, zzarcVar.f24198a) && TextUtils.equals(this.f24199b, zzarcVar.f24199b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f24199b.hashCode() + (this.f24198a.hashCode() * 31);
    }

    public final String toString() {
        String str = this.f24198a;
        int length = String.valueOf(str).length();
        String str2 = this.f24199b;
        StringBuilder sb = new StringBuilder(length + 19 + String.valueOf(str2).length() + 1);
        android.support.v4.media.b.B(sb, "Header[name=", str, ",value=", str2);
        sb.append("]");
        return sb.toString();
    }
}
