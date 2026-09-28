package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.ImageReader;
import com.bumptech.glide.util.ExceptionCatchingInputStream;
import com.bumptech.glide.util.MarkEnforcingInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;

/* loaded from: classes3.dex */
public class StreamBitmapDecoder implements ResourceDecoder<InputStream, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    public final Downsampler f16318a;

    /* renamed from: b, reason: collision with root package name */
    public final LruArrayPool f16319b;

    public static class UntrustedCallbacks implements Downsampler.DecodeCallbacks {

        /* renamed from: a, reason: collision with root package name */
        public final RecyclableBufferedInputStream f16320a;

        /* renamed from: b, reason: collision with root package name */
        public final ExceptionCatchingInputStream f16321b;

        public UntrustedCallbacks(RecyclableBufferedInputStream recyclableBufferedInputStream, ExceptionCatchingInputStream exceptionCatchingInputStream) {
            this.f16320a = recyclableBufferedInputStream;
            this.f16321b = exceptionCatchingInputStream;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public final void a(Bitmap bitmap, BitmapPool bitmapPool) throws IOException {
            IOException iOException = this.f16321b.f16515b;
            if (iOException != null) {
                if (bitmap == null) {
                    throw iOException;
                }
                bitmapPool.b(bitmap);
                throw iOException;
            }
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public final void b() {
            RecyclableBufferedInputStream recyclableBufferedInputStream = this.f16320a;
            synchronized (recyclableBufferedInputStream) {
                recyclableBufferedInputStream.f16310c = recyclableBufferedInputStream.f16308a.length;
            }
        }
    }

    public StreamBitmapDecoder(Downsampler downsampler, LruArrayPool lruArrayPool) {
        this.f16318a = downsampler;
        this.f16319b = lruArrayPool;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final boolean a(Object obj, Options options) {
        this.f16318a.getClass();
        return true;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final Resource b(Object obj, int i2, int i3, Options options) {
        boolean z;
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        ExceptionCatchingInputStream exceptionCatchingInputStream;
        InputStream inputStream = (InputStream) obj;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
            z = false;
        } else {
            z = true;
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.f16319b);
        }
        ArrayDeque arrayDeque = ExceptionCatchingInputStream.f16513c;
        synchronized (arrayDeque) {
            exceptionCatchingInputStream = (ExceptionCatchingInputStream) arrayDeque.poll();
        }
        if (exceptionCatchingInputStream == null) {
            exceptionCatchingInputStream = new ExceptionCatchingInputStream();
        }
        ExceptionCatchingInputStream exceptionCatchingInputStream2 = exceptionCatchingInputStream;
        exceptionCatchingInputStream2.f16514a = recyclableBufferedInputStream;
        MarkEnforcingInputStream markEnforcingInputStream = new MarkEnforcingInputStream(exceptionCatchingInputStream2);
        UntrustedCallbacks untrustedCallbacks = new UntrustedCallbacks(recyclableBufferedInputStream, exceptionCatchingInputStream2);
        try {
            Downsampler downsampler = this.f16318a;
            BitmapResource bitmapResourceA = downsampler.a(new ImageReader.InputStreamImageReader(downsampler.f16283c, markEnforcingInputStream, downsampler.f16284d), i2, i3, options, untrustedCallbacks);
            exceptionCatchingInputStream2.f16515b = null;
            exceptionCatchingInputStream2.f16514a = null;
            synchronized (arrayDeque) {
                arrayDeque.offer(exceptionCatchingInputStream2);
            }
            if (z) {
                recyclableBufferedInputStream.release();
            }
            return bitmapResourceA;
        } catch (Throwable th) {
            exceptionCatchingInputStream2.f16515b = null;
            exceptionCatchingInputStream2.f16514a = null;
            ArrayDeque arrayDeque2 = ExceptionCatchingInputStream.f16513c;
            synchronized (arrayDeque2) {
                arrayDeque2.offer(exceptionCatchingInputStream2);
                if (!z) {
                    throw th;
                }
                recyclableBufferedInputStream.release();
                throw th;
            }
        }
    }
}
