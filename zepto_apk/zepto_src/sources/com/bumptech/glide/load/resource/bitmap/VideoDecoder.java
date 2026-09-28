package com.bumptech.glide.load.resource.bitmap;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.support.v4.media.b;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public class VideoDecoder<T> implements ResourceDecoder<T, Bitmap> {

    /* renamed from: d, reason: collision with root package name */
    public static final Option f16327d = new Option("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new Option.CacheKeyUpdater<Long>() { // from class: com.bumptech.glide.load.resource.bitmap.VideoDecoder.1

        /* renamed from: a, reason: collision with root package name */
        public final ByteBuffer f16333a = ByteBuffer.allocate(8);

        @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
        public final void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
            Long l2 = (Long) obj;
            messageDigest.update(bArr);
            synchronized (this.f16333a) {
                this.f16333a.position(0);
                messageDigest.update(this.f16333a.putLong(l2.longValue()).array());
            }
        }
    });

    /* renamed from: e, reason: collision with root package name */
    public static final Option f16328e = new Option("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new Option.CacheKeyUpdater<Integer>() { // from class: com.bumptech.glide.load.resource.bitmap.VideoDecoder.2

        /* renamed from: a, reason: collision with root package name */
        public final ByteBuffer f16334a = ByteBuffer.allocate(4);

        @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
        public final void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
            Integer num = (Integer) obj;
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.f16334a) {
                this.f16334a.position(0);
                messageDigest.update(this.f16334a.putInt(num.intValue()).array());
            }
        }
    });

    /* renamed from: f, reason: collision with root package name */
    public static final MediaMetadataRetrieverFactory f16329f = new MediaMetadataRetrieverFactory();

    /* renamed from: a, reason: collision with root package name */
    public final MediaMetadataRetrieverInitializer f16330a;

    /* renamed from: b, reason: collision with root package name */
    public final BitmapPool f16331b;

    /* renamed from: c, reason: collision with root package name */
    public final MediaMetadataRetrieverFactory f16332c;

    public static final class AssetFileDescriptorInitializer implements MediaMetadataRetrieverInitializer<AssetFileDescriptor> {
        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaMetadataRetrieverInitializer
        public final void a(MediaMetadataRetriever mediaMetadataRetriever, Object obj) throws IllegalArgumentException {
            AssetFileDescriptor assetFileDescriptor = (AssetFileDescriptor) obj;
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    @RequiresApi
    public static final class ByteBufferInitializer implements MediaMetadataRetrieverInitializer<ByteBuffer> {
        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaMetadataRetrieverInitializer
        public final void a(MediaMetadataRetriever mediaMetadataRetriever, Object obj) throws IllegalArgumentException {
            final ByteBuffer byteBuffer = (ByteBuffer) obj;
            mediaMetadataRetriever.setDataSource(new MediaDataSource() { // from class: com.bumptech.glide.load.resource.bitmap.VideoDecoder.ByteBufferInitializer.1
                @Override // java.io.Closeable, java.lang.AutoCloseable
                public final void close() {
                }

                @Override // android.media.MediaDataSource
                public final long getSize() {
                    return byteBuffer.limit();
                }

                @Override // android.media.MediaDataSource
                public final int readAt(long j2, byte[] bArr, int i2, int i3) {
                    ByteBuffer byteBuffer2 = byteBuffer;
                    if (j2 >= byteBuffer2.limit()) {
                        return -1;
                    }
                    byteBuffer2.position((int) j2);
                    int iMin = Math.min(i3, byteBuffer2.remaining());
                    byteBuffer2.get(bArr, i2, iMin);
                    return iMin;
                }
            });
        }
    }

    @VisibleForTesting
    public static class MediaMetadataRetrieverFactory {
    }

    @VisibleForTesting
    public interface MediaMetadataRetrieverInitializer<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, Object obj);
    }

    public static final class ParcelFileDescriptorInitializer implements MediaMetadataRetrieverInitializer<ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaMetadataRetrieverInitializer
        public final void a(MediaMetadataRetriever mediaMetadataRetriever, Object obj) throws IllegalArgumentException {
            mediaMetadataRetriever.setDataSource(((ParcelFileDescriptor) obj).getFileDescriptor());
        }
    }

    public VideoDecoder(BitmapPool bitmapPool, MediaMetadataRetrieverInitializer mediaMetadataRetrieverInitializer) {
        MediaMetadataRetrieverFactory mediaMetadataRetrieverFactory = f16329f;
        this.f16331b = bitmapPool;
        this.f16330a = mediaMetadataRetrieverInitializer;
        this.f16332c = mediaMetadataRetrieverFactory;
    }

    public static VideoDecoder c(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new AssetFileDescriptorInitializer());
    }

    public static VideoDecoder d(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new ByteBufferInitializer());
    }

    public static Bitmap e(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2, int i3, int i4, DownsampleStrategy downsampleStrategy) {
        Bitmap scaledFrameAtTime = null;
        if (Build.VERSION.SDK_INT >= 27 && i3 != Integer.MIN_VALUE && i4 != Integer.MIN_VALUE && downsampleStrategy != DownsampleStrategy.f16268b) {
            try {
                int i5 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                int i6 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                int i7 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
                if (i7 == 90 || i7 == 270) {
                    i6 = i5;
                    i5 = i6;
                }
                float fB = downsampleStrategy.b(i5, i6, i3, i4);
                scaledFrameAtTime = mediaMetadataRetriever.getScaledFrameAtTime(j2, i2, Math.round(i5 * fB), Math.round(fB * i6));
            } catch (Throwable th) {
                if (Log.isLoggable("VideoDecoder", 3)) {
                    Log.d("VideoDecoder", "Exception trying to decode frame on oreo+", th);
                }
            }
        }
        return scaledFrameAtTime == null ? mediaMetadataRetriever.getFrameAtTime(j2, i2) : scaledFrameAtTime;
    }

    public static VideoDecoder f(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new ParcelFileDescriptorInitializer());
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final boolean a(Object obj, Options options) {
        return true;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final Resource b(Object obj, int i2, int i3, Options options) throws IOException {
        long jLongValue = ((Long) options.c(f16327d)).longValue();
        if (jLongValue < 0 && jLongValue != -1) {
            throw new IllegalArgumentException(b.i(jLongValue, "Requested frame must be non-negative, or DEFAULT_FRAME, given: "));
        }
        Integer num = (Integer) options.c(f16328e);
        if (num == null) {
            num = 2;
        }
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.c(DownsampleStrategy.f16270d);
        if (downsampleStrategy == null) {
            downsampleStrategy = DownsampleStrategy.f16269c;
        }
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        this.f16332c.getClass();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                this.f16330a.a(mediaMetadataRetriever, obj);
                Bitmap bitmapE = e(mediaMetadataRetriever, jLongValue, num.intValue(), i2, i3, downsampleStrategy2);
                mediaMetadataRetriever.release();
                return BitmapResource.b(bitmapE, this.f16331b);
            } catch (RuntimeException e2) {
                throw new IOException(e2);
            }
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
    }
}
