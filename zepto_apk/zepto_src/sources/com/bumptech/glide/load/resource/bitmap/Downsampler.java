package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;

/* loaded from: classes3.dex */
public final class Downsampler {

    /* renamed from: f, reason: collision with root package name */
    public static final Option f16275f = Option.a(DecodeFormat.f15796c, "com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat");

    /* renamed from: g, reason: collision with root package name */
    public static final Option f16276g = Option.a(PreferredColorSpace.f15818a, "com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace");

    /* renamed from: h, reason: collision with root package name */
    public static final Option f16277h;

    /* renamed from: i, reason: collision with root package name */
    public static final Option f16278i;

    /* renamed from: j, reason: collision with root package name */
    public static final DecodeCallbacks f16279j;

    /* renamed from: k, reason: collision with root package name */
    public static final ArrayDeque f16280k;

    /* renamed from: a, reason: collision with root package name */
    public final BitmapPool f16281a;

    /* renamed from: b, reason: collision with root package name */
    public final DisplayMetrics f16282b;

    /* renamed from: c, reason: collision with root package name */
    public final LruArrayPool f16283c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f16284d;

    /* renamed from: e, reason: collision with root package name */
    public final HardwareConfigState f16285e = HardwareConfigState.a();

    public interface DecodeCallbacks {
        void a(Bitmap bitmap, BitmapPool bitmapPool);

        void b();
    }

    static {
        DownsampleStrategy downsampleStrategy = DownsampleStrategy.f16267a;
        Boolean bool = Boolean.FALSE;
        f16277h = Option.a(bool, "com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize");
        f16278i = Option.a(bool, "com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode");
        Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        f16279j = new AnonymousClass1();
        Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        char[] cArr = Util.f16528a;
        f16280k = new ArrayDeque(0);
    }

    public Downsampler(ArrayList arrayList, DisplayMetrics displayMetrics, BitmapPool bitmapPool, LruArrayPool lruArrayPool) {
        this.f16284d = arrayList;
        Preconditions.c(displayMetrics, "Argument must not be null");
        this.f16282b = displayMetrics;
        Preconditions.c(bitmapPool, "Argument must not be null");
        this.f16281a = bitmapPool;
        Preconditions.c(lruArrayPool, "Argument must not be null");
        this.f16283c = lruArrayPool;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
    
        throw r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap c(com.bumptech.glide.load.resource.bitmap.ImageReader r9, android.graphics.BitmapFactory.Options r10, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks r11, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r12) {
        /*
            java.lang.String r0 = "Downsampler"
            boolean r1 = r10.inJustDecodeBounds
            if (r1 != 0) goto Lc
            r11.b()
            r9.b()
        Lc:
            int r1 = r10.outWidth
            int r2 = r10.outHeight
            java.lang.String r3 = r10.outMimeType
            java.util.concurrent.locks.Lock r4 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.f16325d
            r4.lock()
            android.graphics.Bitmap r9 = r9.a(r10)     // Catch: java.lang.IllegalArgumentException -> L1f java.lang.Throwable -> L66
            r4.unlock()
            return r9
        L1f:
            r4 = move-exception
            java.io.IOException r5 = new java.io.IOException     // Catch: java.lang.Throwable -> L66
            java.lang.String r6 = "Exception decoding bitmap, outWidth: "
            java.lang.String r7 = ", outHeight: "
            java.lang.String r8 = ", outMimeType: "
            java.lang.StringBuilder r1 = android.support.v4.media.b.t(r1, r2, r6, r7, r8)     // Catch: java.lang.Throwable -> L66
            r1.append(r3)     // Catch: java.lang.Throwable -> L66
            java.lang.String r2 = ", inBitmap: "
            r1.append(r2)     // Catch: java.lang.Throwable -> L66
            android.graphics.Bitmap r2 = r10.inBitmap     // Catch: java.lang.Throwable -> L66
            java.lang.String r2 = d(r2)     // Catch: java.lang.Throwable -> L66
            r1.append(r2)     // Catch: java.lang.Throwable -> L66
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L66
            r5.<init>(r1, r4)     // Catch: java.lang.Throwable -> L66
            r1 = 3
            boolean r1 = android.util.Log.isLoggable(r0, r1)     // Catch: java.lang.Throwable -> L66
            if (r1 == 0) goto L50
            java.lang.String r1 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r0, r1, r5)     // Catch: java.lang.Throwable -> L66
        L50:
            android.graphics.Bitmap r0 = r10.inBitmap     // Catch: java.lang.Throwable -> L66
            if (r0 == 0) goto L65
            r12.b(r0)     // Catch: java.io.IOException -> L64 java.lang.Throwable -> L66
            r0 = 0
            r10.inBitmap = r0     // Catch: java.io.IOException -> L64 java.lang.Throwable -> L66
            android.graphics.Bitmap r9 = c(r9, r10, r11, r12)     // Catch: java.io.IOException -> L64 java.lang.Throwable -> L66
            java.util.concurrent.locks.Lock r10 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.f16325d
            r10.unlock()
            return r9
        L64:
            throw r5     // Catch: java.lang.Throwable -> L66
        L65:
            throw r5     // Catch: java.lang.Throwable -> L66
        L66:
            r9 = move-exception
            java.util.concurrent.locks.Lock r10 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.f16325d
            r10.unlock()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.c(com.bumptech.glide.load.resource.bitmap.ImageReader, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool):android.graphics.Bitmap");
    }

    public static String d(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    public static void e(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public final BitmapResource a(ImageReader imageReader, int i2, int i3, Options options, DecodeCallbacks decodeCallbacks) {
        ArrayDeque arrayDeque;
        BitmapFactory.Options options2;
        byte[] bArr = (byte[]) this.f16283c.d(byte[].class, 65536);
        synchronized (Downsampler.class) {
            arrayDeque = f16280k;
            synchronized (arrayDeque) {
                options2 = (BitmapFactory.Options) arrayDeque.poll();
            }
            if (options2 == null) {
                options2 = new BitmapFactory.Options();
                e(options2);
            }
        }
        options2.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) options.c(f16275f);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) options.c(f16276g);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.c(DownsampleStrategy.f16270d);
        boolean zBooleanValue = ((Boolean) options.c(f16277h)).booleanValue();
        Option option = f16278i;
        try {
            BitmapResource bitmapResourceB = BitmapResource.b(b(imageReader, options2, downsampleStrategy, decodeFormat, preferredColorSpace, options.c(option) != null && ((Boolean) options.c(option)).booleanValue(), i2, i3, zBooleanValue, decodeCallbacks), this.f16281a);
            e(options2);
            synchronized (arrayDeque) {
                arrayDeque.offer(options2);
            }
            this.f16283c.i(bArr);
            return bitmapResourceB;
        } catch (Throwable th) {
            e(options2);
            ArrayDeque arrayDeque2 = f16280k;
            synchronized (arrayDeque2) {
                arrayDeque2.offer(options2);
                this.f16283c.i(bArr);
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x02b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap b(com.bumptech.glide.load.resource.bitmap.ImageReader r41, android.graphics.BitmapFactory.Options r42, com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r43, com.bumptech.glide.load.DecodeFormat r44, com.bumptech.glide.load.PreferredColorSpace r45, boolean r46, int r47, int r48, boolean r49, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks r50) {
        /*
            Method dump skipped, instructions count: 1362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.b(com.bumptech.glide.load.resource.bitmap.ImageReader, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.DownsampleStrategy, com.bumptech.glide.load.DecodeFormat, com.bumptech.glide.load.PreferredColorSpace, boolean, int, int, boolean, com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks):android.graphics.Bitmap");
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.Downsampler$1, reason: invalid class name */
    public class AnonymousClass1 implements DecodeCallbacks {
        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public final void b() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public final void a(Bitmap bitmap, BitmapPool bitmapPool) {
        }
    }
}
