package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.support.v4.media.b;
import androidx.fragment.app.e;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.DefaultCloseableReference;
import com.facebook.imagepipeline.common.TooManyBitmapsException;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapCounter;
import com.facebook.imagepipeline.memory.BitmapCounterProvider;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imageutils.BitmapUtil;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.soloader.DoNotOptimize;
import com.facebook.soloader.nativeloader.NativeLoader;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@DoNotStrip
@Nullsafe
/* loaded from: classes3.dex */
public abstract class DalvikPurgeableDecoder implements PlatformDecoder {

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f18062b;

    /* renamed from: a, reason: collision with root package name */
    public final BitmapCounter f18063a;

    @DoNotOptimize
    public static class OreoUtils {
        private OreoUtils() {
        }
    }

    static {
        List list = ImagePipelineNativeLoader.f18064a;
        NativeLoader.b("imagepipeline");
        f18062b = new byte[]{-1, -39};
    }

    public DalvikPurgeableDecoder() {
        if (BitmapCounterProvider.f18001c == null) {
            synchronized (BitmapCounterProvider.class) {
                try {
                    if (BitmapCounterProvider.f18001c == null) {
                        BitmapCounterProvider.f18001c = new BitmapCounter(BitmapCounterProvider.f18000b, BitmapCounterProvider.f17999a);
                    }
                    Unit unit = Unit.f53572a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        BitmapCounter bitmapCounter = BitmapCounterProvider.f18001c;
        Intrinsics.c(bitmapCounter);
        this.f18063a = bitmapCounter;
    }

    public static boolean e(CloseableReference closeableReference, int i2) {
        PooledByteBuffer pooledByteBuffer = (PooledByteBuffer) closeableReference.l();
        return i2 >= 2 && pooledByteBuffer.q(i2 + (-2)) == -1 && pooledByteBuffer.q(i2 - 1) == -39;
    }

    @DoNotStrip
    private static native void nativePinBitmap(Bitmap bitmap);

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public final CloseableReference a(EncodedImage encodedImage, Bitmap.Config config) {
        int i2 = encodedImage.f17962g;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inSampleSize = i2;
        options.inMutable = true;
        if (Build.VERSION.SDK_INT >= 26) {
            ColorSpace.Named unused = ColorSpace.Named.SRGB;
            options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        CloseableReference closeableReferenceC = CloseableReference.c(encodedImage.f17956a);
        closeableReferenceC.getClass();
        try {
            return f(c(closeableReferenceC, options));
        } finally {
            closeableReferenceC.close();
        }
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public final CloseableReference b(EncodedImage encodedImage, Bitmap.Config config, int i2, ColorSpace colorSpace) {
        int i3 = encodedImage.f17962g;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inSampleSize = i3;
        options.inMutable = true;
        if (Build.VERSION.SDK_INT >= 26) {
            if (colorSpace == null) {
                ColorSpace.Named unused = ColorSpace.Named.SRGB;
                colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            }
            options.inPreferredColorSpace = colorSpace;
        }
        CloseableReference closeableReferenceC = CloseableReference.c(encodedImage.f17956a);
        closeableReferenceC.getClass();
        try {
            return f(d(closeableReferenceC, i2, options));
        } finally {
            closeableReferenceC.close();
        }
    }

    public abstract Bitmap c(CloseableReference closeableReference, BitmapFactory.Options options);

    public abstract Bitmap d(CloseableReference closeableReference, int i2, BitmapFactory.Options options);

    public final DefaultCloseableReference f(Bitmap bitmap) throws Throwable {
        int i2;
        long j2;
        int i3;
        bitmap.getClass();
        try {
            nativePinBitmap(bitmap);
            BitmapCounter bitmapCounter = this.f18063a;
            synchronized (bitmapCounter) {
                int iD = BitmapUtil.d(bitmap);
                int i4 = bitmapCounter.f17993a;
                if (i4 < bitmapCounter.f17995c) {
                    long j3 = bitmapCounter.f17994b + iD;
                    if (j3 <= bitmapCounter.f17996d) {
                        bitmapCounter.f17993a = i4 + 1;
                        bitmapCounter.f17994b = j3;
                        return CloseableReference.T(bitmap, this.f18063a.f17997e, CloseableReference.f17108f);
                    }
                }
                int iD2 = BitmapUtil.d(bitmap);
                bitmap.recycle();
                Locale locale = Locale.US;
                BitmapCounter bitmapCounter2 = this.f18063a;
                synchronized (bitmapCounter2) {
                    i2 = bitmapCounter2.f17993a;
                }
                BitmapCounter bitmapCounter3 = this.f18063a;
                synchronized (bitmapCounter3) {
                    j2 = bitmapCounter3.f17994b;
                }
                BitmapCounter bitmapCounter4 = this.f18063a;
                synchronized (bitmapCounter4) {
                    i3 = bitmapCounter4.f17995c;
                }
                int iB = this.f18063a.b();
                StringBuilder sbT = b.t(iD2, i2, "Attempted to pin a bitmap of size ", " bytes. The current pool count is ", ", the current pool size is ");
                sbT.append(j2);
                sbT.append(" bytes. The current pool max count is ");
                sbT.append(i3);
                throw new TooManyBitmapsException(e.u(sbT, ", the current pool max size is ", iB, " bytes."));
            }
        } catch (Exception e2) {
            bitmap.recycle();
            Throwables.b(e2);
            throw new RuntimeException(e2);
        }
    }
}
