package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;

/* loaded from: classes3.dex */
public class BitmapEncoder implements ResourceEncoder<Bitmap> {

    /* renamed from: b, reason: collision with root package name */
    public static final Option f16251b = Option.a(90, "com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality");

    /* renamed from: c, reason: collision with root package name */
    public static final Option f16252c = new Option("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat", null, Option.f15812e);

    /* renamed from: a, reason: collision with root package name */
    public final LruArrayPool f16253a;

    public BitmapEncoder(LruArrayPool lruArrayPool) {
        this.f16253a = lruArrayPool;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x007c  */
    @Override // com.bumptech.glide.load.Encoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(java.lang.Object r9, java.io.File r10, com.bumptech.glide.load.Options r11) throws java.lang.Throwable {
        /*
            r8 = this;
            com.bumptech.glide.load.engine.Resource r9 = (com.bumptech.glide.load.engine.Resource) r9
            java.lang.String r0 = "BitmapEncoder"
            java.lang.Object r9 = r9.get()
            android.graphics.Bitmap r9 = (android.graphics.Bitmap) r9
            com.bumptech.glide.load.Option r1 = com.bumptech.glide.load.resource.bitmap.BitmapEncoder.f16252c
            java.lang.Object r2 = r11.c(r1)
            android.graphics.Bitmap$CompressFormat r2 = (android.graphics.Bitmap.CompressFormat) r2
            if (r2 == 0) goto L15
            goto L20
        L15:
            boolean r2 = r9.hasAlpha()
            if (r2 == 0) goto L1e
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG
            goto L20
        L1e:
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG
        L20:
            r9.getWidth()
            r9.getHeight()
            int r3 = com.bumptech.glide.util.LogTime.f16520b
            long r3 = android.os.SystemClock.elapsedRealtimeNanos()
            com.bumptech.glide.load.Option r5 = com.bumptech.glide.load.resource.bitmap.BitmapEncoder.f16251b
            java.lang.Object r5 = r11.c(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            r6 = 0
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            r7.<init>(r10)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool r10 = r8.f16253a
            if (r10 == 0) goto L51
            com.bumptech.glide.load.data.BufferedOutputStream r6 = new com.bumptech.glide.load.data.BufferedOutputStream     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L4f
            r6.<init>(r7, r10)     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L4f
            goto L52
        L48:
            r6 = r7
            goto Lbe
        L4b:
            r6 = r7
            goto L63
        L4d:
            r9 = move-exception
            goto L48
        L4f:
            r10 = move-exception
            goto L4b
        L51:
            r6 = r7
        L52:
            r9.compress(r2, r5, r6)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            r6.close()     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            r6.close()     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L5e
            goto L5e
        L5c:
            r9 = move-exception
            goto Lc4
        L5e:
            r10 = 1
            goto L75
        L60:
            r9 = move-exception
            goto Lbe
        L62:
            r10 = move-exception
        L63:
            r5 = 3
            boolean r5 = android.util.Log.isLoggable(r0, r5)     // Catch: java.lang.Throwable -> L60
            if (r5 == 0) goto L6f
            java.lang.String r5 = "Failed to encode Bitmap"
            android.util.Log.d(r0, r5, r10)     // Catch: java.lang.Throwable -> L60
        L6f:
            if (r6 == 0) goto L74
            r6.close()     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L74
        L74:
            r10 = 0
        L75:
            r5 = 2
            boolean r5 = android.util.Log.isLoggable(r0, r5)
            if (r5 == 0) goto Lbd
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Compressed with type: "
            r5.<init>(r6)
            r5.append(r2)
            java.lang.String r2 = " of size "
            r5.append(r2)
            int r2 = com.bumptech.glide.util.Util.c(r9)
            r5.append(r2)
            java.lang.String r2 = " in "
            r5.append(r2)
            double r2 = com.bumptech.glide.util.LogTime.a(r3)
            r5.append(r2)
            java.lang.String r2 = ", options format: "
            r5.append(r2)
            java.lang.Object r11 = r11.c(r1)
            r5.append(r11)
            java.lang.String r11 = ", hasAlpha: "
            r5.append(r11)
            boolean r9 = r9.hasAlpha()
            r5.append(r9)
            java.lang.String r9 = r5.toString()
            android.util.Log.v(r0, r9)
        Lbd:
            return r10
        Lbe:
            if (r6 == 0) goto Lc5
            r6.close()     // Catch: java.lang.Throwable -> L5c java.io.IOException -> Lc5
            goto Lc5
        Lc4:
            throw r9
        Lc5:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.BitmapEncoder.a(java.lang.Object, java.io.File, com.bumptech.glide.load.Options):boolean");
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    public final EncodeStrategy b(Options options) {
        return EncodeStrategy.f15799b;
    }

    @Deprecated
    public BitmapEncoder() {
        this.f16253a = null;
    }
}
