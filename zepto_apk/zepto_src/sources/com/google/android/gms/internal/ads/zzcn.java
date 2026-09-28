package com.google.android.gms.internal.ads;

import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
public final class zzcn extends Exception {
    /* JADX WARN: Illegal instructions before constructor call */
    public zzcn(String str, zzcl zzclVar) {
        String strValueOf = String.valueOf(zzclVar);
        super(android.support.v4.media.b.s(new StringBuilder(str.length() + 1 + strValueOf.length()), str, StringUtils.SPACE, strValueOf));
    }
}
