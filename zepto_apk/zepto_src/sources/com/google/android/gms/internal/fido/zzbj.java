package com.google.android.gms.internal.fido;

import android.support.v4.media.b;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzbj extends zzbk {

    /* renamed from: a, reason: collision with root package name */
    public final String f36611a;

    public zzbj(String str) {
        this.f36611a = str;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzbk zzbkVar = (zzbk) obj;
        zzbkVar.getClass();
        String str = this.f36611a;
        int length = str.length();
        String str2 = ((zzbj) zzbkVar).f36611a;
        return length != str2.length() ? str.length() - str2.length() : str.compareTo(str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzbj.class == obj.getClass()) {
            return this.f36611a.equals(((zzbj) obj).f36611a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{3, this.f36611a});
    }

    public final String toString() {
        return b.r(new StringBuilder("\""), this.f36611a, "\"");
    }
}
