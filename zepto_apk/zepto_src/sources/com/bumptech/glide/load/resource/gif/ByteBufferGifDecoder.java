package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.support.v4.media.b;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.gifdecoder.StandardGifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ByteBufferGifDecoder implements ResourceDecoder<ByteBuffer, GifDrawable> {

    /* renamed from: f, reason: collision with root package name */
    public static final GifDecoderFactory f16341f = new GifDecoderFactory();

    /* renamed from: g, reason: collision with root package name */
    public static final GifHeaderParserPool f16342g = new GifHeaderParserPool();

    /* renamed from: a, reason: collision with root package name */
    public final Context f16343a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f16344b;

    /* renamed from: c, reason: collision with root package name */
    public final GifHeaderParserPool f16345c;

    /* renamed from: d, reason: collision with root package name */
    public final GifDecoderFactory f16346d;

    /* renamed from: e, reason: collision with root package name */
    public final GifBitmapProvider f16347e;

    @VisibleForTesting
    public static class GifDecoderFactory {
    }

    @VisibleForTesting
    public static class GifHeaderParserPool {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayDeque f16348a;

        public GifHeaderParserPool() {
            char[] cArr = Util.f16528a;
            this.f16348a = new ArrayDeque(0);
        }

        public final synchronized void a(GifHeaderParser gifHeaderParser) {
            gifHeaderParser.f15772b = null;
            gifHeaderParser.f15773c = null;
            this.f16348a.offer(gifHeaderParser);
        }
    }

    public ByteBufferGifDecoder(Context context, ArrayList arrayList, BitmapPool bitmapPool, LruArrayPool lruArrayPool) {
        GifHeaderParserPool gifHeaderParserPool = f16342g;
        GifDecoderFactory gifDecoderFactory = f16341f;
        this.f16343a = context.getApplicationContext();
        this.f16344b = arrayList;
        this.f16346d = gifDecoderFactory;
        this.f16347e = new GifBitmapProvider(bitmapPool, lruArrayPool);
        this.f16345c = gifHeaderParserPool;
    }

    public static int d(GifHeader gifHeader, int i2, int i3) {
        int iMin = Math.min(gifHeader.f15766g / i3, gifHeader.f15765f / i2);
        int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
        if (Log.isLoggable("BufferGifDecoder", 2) && iMax > 1) {
            StringBuilder sbT = b.t(iMax, i2, "Downsampling GIF, sampleSize: ", ", target dimens: [", "x");
            sbT.append(i3);
            sbT.append("], actual dimens: [");
            sbT.append(gifHeader.f15765f);
            sbT.append("x");
            sbT.append(gifHeader.f15766g);
            sbT.append("]");
            Log.v("BufferGifDecoder", sbT.toString());
        }
        return iMax;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final boolean a(Object obj, Options options) {
        return !((Boolean) options.c(GifOptions.f16383b)).booleanValue() && ImageHeaderParserUtils.e(this.f16344b, (ByteBuffer) obj) == ImageHeaderParser.ImageType.GIF;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:25:0x0059
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    @Override // com.bumptech.glide.load.ResourceDecoder
    public final com.bumptech.glide.load.engine.Resource b(java.lang.Object r8, int r9, int r10, com.bumptech.glide.load.Options r11) {
        /*
            r7 = this;
            r2 = r8
            java.nio.ByteBuffer r2 = (java.nio.ByteBuffer) r2
            com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder$GifHeaderParserPool r8 = r7.f16345c
            monitor-enter(r8)
            java.util.ArrayDeque r0 = r8.f16348a     // Catch: java.lang.Throwable -> L54
            java.lang.Object r0 = r0.poll()     // Catch: java.lang.Throwable -> L54
            com.bumptech.glide.gifdecoder.GifHeaderParser r0 = (com.bumptech.glide.gifdecoder.GifHeaderParser) r0     // Catch: java.lang.Throwable -> L54
            if (r0 != 0) goto L15
            com.bumptech.glide.gifdecoder.GifHeaderParser r0 = new com.bumptech.glide.gifdecoder.GifHeaderParser     // Catch: java.lang.Throwable -> L17
            r0.<init>()     // Catch: java.lang.Throwable -> L17
        L15:
            r5 = r0
            goto L1b
        L17:
            r0 = move-exception
            r9 = r0
            r1 = r7
            goto L57
        L1b:
            r0 = 0
            r5.f15772b = r0     // Catch: java.lang.Throwable -> L54
            byte[] r0 = r5.f15771a     // Catch: java.lang.Throwable -> L54
            r1 = 0
            java.util.Arrays.fill(r0, r1)     // Catch: java.lang.Throwable -> L54
            com.bumptech.glide.gifdecoder.GifHeader r0 = new com.bumptech.glide.gifdecoder.GifHeader     // Catch: java.lang.Throwable -> L54
            r0.<init>()     // Catch: java.lang.Throwable -> L54
            r5.f15773c = r0     // Catch: java.lang.Throwable -> L54
            r5.f15774d = r1     // Catch: java.lang.Throwable -> L54
            java.nio.ByteBuffer r0 = r2.asReadOnlyBuffer()     // Catch: java.lang.Throwable -> L54
            r5.f15772b = r0     // Catch: java.lang.Throwable -> L54
            r0.position(r1)     // Catch: java.lang.Throwable -> L54
            java.nio.ByteBuffer r0 = r5.f15772b     // Catch: java.lang.Throwable -> L54
            java.nio.ByteOrder r1 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch: java.lang.Throwable -> L54
            r0.order(r1)     // Catch: java.lang.Throwable -> L54
            monitor-exit(r8)
            r1 = r7
            r3 = r9
            r4 = r10
            r6 = r11
            com.bumptech.glide.load.resource.gif.GifDrawableResource r8 = r1.c(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L4c
            com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder$GifHeaderParserPool r9 = r1.f16345c
            r9.a(r5)
            return r8
        L4c:
            r0 = move-exception
            r8 = r0
            com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder$GifHeaderParserPool r9 = r1.f16345c
            r9.a(r5)
            throw r8
        L54:
            r0 = move-exception
            r1 = r7
        L56:
            r9 = r0
        L57:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L59
            throw r9
        L59:
            r0 = move-exception
            goto L56
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder.b(java.lang.Object, int, int, com.bumptech.glide.load.Options):com.bumptech.glide.load.engine.Resource");
    }

    public final GifDrawableResource c(ByteBuffer byteBuffer, int i2, int i3, GifHeaderParser gifHeaderParser, Options options) {
        StringBuilder sb;
        int i4 = LogTime.f16520b;
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        try {
            GifHeader gifHeaderB = gifHeaderParser.b();
            if (gifHeaderB.f15762c > 0 && gifHeaderB.f15761b == 0) {
                Bitmap.Config config = options.c(GifOptions.f16382a) == DecodeFormat.f15795b ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                int iD = d(gifHeaderB, i2, i3);
                GifDecoderFactory gifDecoderFactory = this.f16346d;
                GifBitmapProvider gifBitmapProvider = this.f16347e;
                gifDecoderFactory.getClass();
                StandardGifDecoder standardGifDecoder = new StandardGifDecoder(gifBitmapProvider, gifHeaderB, byteBuffer, iD);
                standardGifDecoder.e(config);
                standardGifDecoder.b();
                Bitmap bitmapA = standardGifDecoder.a();
                if (bitmapA == null) {
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        sb = new StringBuilder("Decoded GIF from stream in ");
                        sb.append(LogTime.a(jElapsedRealtimeNanos));
                        Log.v("BufferGifDecoder", sb.toString());
                        return null;
                    }
                    return null;
                }
                GifDrawableResource gifDrawableResource = new GifDrawableResource(new GifDrawable(new GifDrawable.GifState(new GifFrameLoader(Glide.b(this.f16343a), standardGifDecoder, i2, i3, bitmapA))));
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    Log.v("BufferGifDecoder", "Decoded GIF from stream in " + LogTime.a(jElapsedRealtimeNanos));
                }
                return gifDrawableResource;
            }
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                sb = new StringBuilder("Decoded GIF from stream in ");
                sb.append(LogTime.a(jElapsedRealtimeNanos));
                Log.v("BufferGifDecoder", sb.toString());
                return null;
            }
            return null;
        } finally {
        }
    }
}
