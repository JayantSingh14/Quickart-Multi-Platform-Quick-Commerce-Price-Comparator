package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes4.dex */
public final class zzyi extends zzat {

    /* renamed from: c, reason: collision with root package name */
    public final zzgtd f35908c;

    public zzyi(String str, List list) {
        super(str, null, false, 1);
        this.f35908c = zzgtd.r(list);
    }

    @Override // com.google.android.gms.internal.ads.zzat, java.lang.Throwable
    public final String getMessage() {
        String message = super.getMessage();
        zzgtd zzgtdVar = this.f35908c;
        if (zzgtdVar.isEmpty()) {
            return message;
        }
        int length = message.length();
        String strValueOf = String.valueOf(zzgtdVar);
        return android.support.v4.media.b.s(new StringBuilder(length + 17 + strValueOf.length()), message, "\nsniff failures: ", strValueOf);
    }
}
