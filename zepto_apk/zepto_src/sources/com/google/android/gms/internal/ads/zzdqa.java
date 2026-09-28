package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Looper;
import com.google.android.gms.common.util.Clock;

/* loaded from: classes4.dex */
public final class zzdqa {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.util.zzbl f28220a;

    /* renamed from: b, reason: collision with root package name */
    public final Clock f28221b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgyw f28222c;

    public zzdqa(com.google.android.gms.ads.internal.util.zzbl zzblVar, Clock clock, zzgyw zzgywVar) {
        this.f28220a = zzblVar;
        this.f28221b = clock;
        this.f28222c = zzgywVar;
    }

    public final Bitmap a(byte[] bArr, BitmapFactory.Options options) {
        Clock clock = this.f28221b;
        long jElapsedRealtime = clock.elapsedRealtime();
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        long jElapsedRealtime2 = clock.elapsedRealtime();
        if (bitmapDecodeByteArray != null) {
            long j2 = jElapsedRealtime2 - jElapsedRealtime;
            int width = bitmapDecodeByteArray.getWidth();
            int height = bitmapDecodeByteArray.getHeight();
            int allocationByteCount = bitmapDecodeByteArray.getAllocationByteCount();
            boolean z = Looper.getMainLooper().getThread() == Thread.currentThread();
            StringBuilder sb = new StringBuilder(String.valueOf(j2).length() + String.valueOf(width).length() + 20 + String.valueOf(height).length() + 8 + String.valueOf(allocationByteCount).length() + 7 + 15 + String.valueOf(z).length());
            androidx.fragment.app.e.w(width, height, "Decoded image w: ", " h:", sb);
            sb.append(" bytes: ");
            sb.append(allocationByteCount);
            sb.append(" time: ");
            sb.append(j2);
            sb.append(" on ui thread: ");
            sb.append(z);
            com.google.android.gms.ads.internal.util.zze.k(sb.toString());
        }
        return bitmapDecodeByteArray;
    }
}
