package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
final class zzgzi extends zzgyd {

    /* renamed from: h, reason: collision with root package name */
    public ListenableFuture f33397h;

    /* renamed from: i, reason: collision with root package name */
    public ScheduledFuture f33398i;

    @Override // com.google.android.gms.internal.ads.zzgxf
    public final void e() {
        n(this.f33397h);
        ScheduledFuture scheduledFuture = this.f33398i;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f33397h = null;
        this.f33398i = null;
    }

    @Override // com.google.android.gms.internal.ads.zzgxf
    public final String f() {
        ListenableFuture listenableFuture = this.f33397h;
        ScheduledFuture scheduledFuture = this.f33398i;
        if (listenableFuture == null) {
            return null;
        }
        String string = listenableFuture.toString();
        String strS = android.support.v4.media.b.s(new StringBuilder(string.length() + 14), "inputFuture=[", string, "]");
        if (scheduledFuture == null) {
            return strS;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return strS;
        }
        int length = strS.length();
        StringBuilder sb = new StringBuilder(String.valueOf(delay).length() + length + 19 + 4);
        sb.append(strS);
        sb.append(", remaining delay=[");
        sb.append(delay);
        sb.append(" ms]");
        return sb.toString();
    }
}
