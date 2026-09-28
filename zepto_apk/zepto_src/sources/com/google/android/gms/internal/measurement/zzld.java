package com.google.android.gms.internal.measurement;

/* loaded from: classes4.dex */
final class zzld {
    public static final zzlg a(zzll zzllVar, byte[] bArr) {
        if (zzllVar.v() == 0) {
            return new zzlf(bArr);
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }
}
