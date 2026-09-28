package com.google.ads.interactivemedia.v3.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public final class zzek {
    private final zztb zza;
    private final float zzb;

    public zzek(ExecutorService executorService, float f2) {
        this.zzb = f2;
        this.zza = zztg.zza(executorService);
    }

    public final /* synthetic */ Bitmap zza(String str, com.google.ads.interactivemedia.v3.impl.data.zzbw zzbwVar) throws Exception {
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new URL(str).openConnection().getInputStream());
        if (bitmapDecodeStream == null) {
            return null;
        }
        if (zzbwVar.width != bitmapDecodeStream.getWidth() || zzbwVar.height != bitmapDecodeStream.getHeight()) {
            return bitmapDecodeStream;
        }
        double d2 = this.zzb;
        if (Math.copySign(1.0d - d2, 1.0d) <= 0.1d || d2 == 1.0d) {
            return bitmapDecodeStream;
        }
        if (Double.isNaN(1.0d) && Double.isNaN(d2)) {
            return bitmapDecodeStream;
        }
        return Bitmap.createScaledBitmap(bitmapDecodeStream, (int) (this.zzb * bitmapDecodeStream.getWidth()), (int) (this.zzb * bitmapDecodeStream.getHeight()), true);
    }

    public final Task zzb(final String str, final com.google.ads.interactivemedia.v3.impl.data.zzbw zzbwVar) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zzsr.zzc(this.zza.zza(new Callable() { // from class: com.google.ads.interactivemedia.v3.internal.zzei
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zza(str, zzbwVar);
            }
        }), new zzej(this, taskCompletionSource, str), this.zza);
        return taskCompletionSource.f39750a;
    }
}
