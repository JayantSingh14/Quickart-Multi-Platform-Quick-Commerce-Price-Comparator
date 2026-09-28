package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import androidx.core.util.Pools;
import com.facebook.common.memory.DecodeBufferHelper;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.DefaultCloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.common.streams.LimitedInputStream;
import com.facebook.common.streams.TailAppendingInputStream;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imagepipeline.memory.DummyBitmapPool;
import com.facebook.infer.annotation.Nullsafe;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
@Nullsafe
/* loaded from: classes.dex */
public abstract class DefaultDecoder implements PlatformDecoder {

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f18073d = {-1, -39};

    /* renamed from: a, reason: collision with root package name */
    public final BitmapPool f18074a;

    /* renamed from: b, reason: collision with root package name */
    public final PreverificationHelper f18075b;

    /* renamed from: c, reason: collision with root package name */
    public final Pools.Pool f18076c;

    /* loaded from: classes3.dex */
    public static final class NoOpResourceReleaser implements ResourceReleaser<Bitmap> {
        @Override // com.facebook.common.references.ResourceReleaser
        public final /* bridge */ /* synthetic */ void a(Object obj) {
        }
    }

    public DefaultDecoder(BitmapPool bitmapPool, Pools.Pool pool, PlatformDecoderOptions platformDecoderOptions) {
        this.f18075b = Build.VERSION.SDK_INT >= 26 ? new PreverificationHelper() : null;
        this.f18074a = bitmapPool;
        if (bitmapPool instanceof DummyBitmapPool) {
            platformDecoderOptions.getClass();
        }
        this.f18076c = pool;
    }

    public static BitmapFactory.Options e(EncodedImage encodedImage, Bitmap.Config config) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = encodedImage.x();
        options.inJustDecodeBounds = true;
        options.inDither = true;
        boolean z = Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE;
        if (!z) {
            options.inPreferredConfig = config;
        }
        options.inMutable = true;
        BitmapFactory.decodeStream(encodedImage.s(), null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            throw new IllegalArgumentException();
        }
        if (z) {
            options.inPreferredConfig = config;
        }
        options.inJustDecodeBounds = false;
        return options;
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public final CloseableReference a(EncodedImage encodedImage, Bitmap.Config config) {
        BitmapFactory.Options optionsE = e(encodedImage, config);
        boolean z = optionsE.inPreferredConfig != Bitmap.Config.ARGB_8888;
        try {
            InputStream inputStreamS = encodedImage.s();
            inputStreamS.getClass();
            return c(inputStreamS, optionsE, null);
        } catch (RuntimeException e2) {
            if (z) {
                return a(encodedImage, Bitmap.Config.ARGB_8888);
            }
            throw e2;
        }
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public final CloseableReference b(EncodedImage encodedImage, Bitmap.Config config, int i2, ColorSpace colorSpace) throws IOException {
        boolean zN = encodedImage.N(i2);
        BitmapFactory.Options optionsE = e(encodedImage, config);
        InputStream inputStreamS = encodedImage.s();
        inputStreamS.getClass();
        if (encodedImage.A() > i2) {
            inputStreamS = new LimitedInputStream(inputStreamS, i2);
        }
        if (!zN) {
            inputStreamS = new TailAppendingInputStream(f18073d, inputStreamS);
        }
        boolean z = optionsE.inPreferredConfig != Bitmap.Config.ARGB_8888;
        try {
            try {
                DefaultCloseableReference defaultCloseableReferenceC = c(inputStreamS, optionsE, colorSpace);
                try {
                    return defaultCloseableReferenceC;
                } catch (IOException e2) {
                    return defaultCloseableReferenceC;
                }
            } catch (RuntimeException e3) {
                if (!z) {
                    throw e3;
                }
                CloseableReference closeableReferenceB = b(encodedImage, Bitmap.Config.ARGB_8888, i2, colorSpace);
                try {
                    inputStreamS.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                return closeableReferenceB;
            }
        } finally {
            try {
                inputStreamS.close();
            } catch (IOException e22) {
                e22.printStackTrace();
            }
        }
    }

    public final DefaultCloseableReference c(InputStream inputStream, BitmapFactory.Options options, ColorSpace colorSpace) {
        Bitmap bitmap;
        PreverificationHelper preverificationHelper;
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        int i4 = Build.VERSION.SDK_INT;
        boolean z = i4 >= 26 && (preverificationHelper = this.f18075b) != null && preverificationHelper.shouldUseHardwareBitmapConfig(options.inPreferredConfig);
        BitmapPool bitmapPool = this.f18074a;
        if (z) {
            options.inMutable = false;
            bitmap = null;
        } else {
            bitmap = (Bitmap) bitmapPool.get(d(i2, i3, options));
            if (bitmap == null) {
                throw new NullPointerException("BitmapPool.get returned null");
            }
        }
        options.inBitmap = bitmap;
        if (i4 >= 26) {
            if (colorSpace == null) {
                ColorSpace.Named unused = ColorSpace.Named.SRGB;
                colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            }
            options.inPreferredColorSpace = colorSpace;
        }
        Pools.Pool pool = this.f18076c;
        ByteBuffer byteBufferAllocate = (ByteBuffer) pool.b();
        if (byteBufferAllocate == null) {
            byteBufferAllocate = ByteBuffer.allocate(DecodeBufferHelper.f17092a);
        }
        try {
            try {
                options.inTempStorage = byteBufferAllocate.array();
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                pool.a(byteBufferAllocate);
                if (bitmap == null || bitmap == bitmapDecodeStream) {
                    return CloseableReference.O(bitmapDecodeStream, bitmapPool);
                }
                bitmapPool.a(bitmap);
                if (bitmapDecodeStream != null) {
                    bitmapDecodeStream.recycle();
                }
                throw new IllegalStateException();
            } catch (IllegalArgumentException e2) {
                if (bitmap != null) {
                    bitmapPool.a(bitmap);
                }
                try {
                    inputStream.reset();
                    Bitmap bitmapDecodeStream2 = BitmapFactory.decodeStream(inputStream);
                    if (bitmapDecodeStream2 == null) {
                        throw e2;
                    }
                    DefaultCloseableReference defaultCloseableReferenceO = CloseableReference.O(bitmapDecodeStream2, SimpleBitmapReleaser.b());
                    pool.a(byteBufferAllocate);
                    return defaultCloseableReferenceO;
                } catch (IOException unused2) {
                    throw e2;
                }
            } catch (RuntimeException e3) {
                if (bitmap != null) {
                    bitmapPool.a(bitmap);
                }
                throw e3;
            }
        } catch (Throwable th) {
            pool.a(byteBufferAllocate);
            throw th;
        }
    }

    public abstract int d(int i2, int i3, BitmapFactory.Options options);
}
