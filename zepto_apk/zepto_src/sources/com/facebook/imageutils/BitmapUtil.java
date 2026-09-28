package com.facebook.imageutils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import androidx.core.util.Pools;
import coil3.decode.b;
import com.facebook.common.memory.DecodeBufferHelper;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class BitmapUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final Lazy f18392a = LazyKt.b(new b(9));

    @Metadata
    public /* synthetic */ class WhenMappings {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18393a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Bitmap.Config.RGB_565.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Bitmap.Config.RGBA_F16.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Bitmap.Config.RGBA_1010102.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Bitmap.Config.HARDWARE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f18393a = iArr;
        }
    }

    public static final ImageMetaData a(InputStream inputStream) {
        if (inputStream == null) {
            throw new IllegalStateException("Required value was null.");
        }
        Lazy lazy = f18392a;
        ByteBuffer byteBufferAllocate = (ByteBuffer) ((Pools.SynchronizedPool) lazy.getValue()).b();
        if (byteBufferAllocate == null) {
            byteBufferAllocate = ByteBuffer.allocate(DecodeBufferHelper.f17092a);
            Intrinsics.checkNotNullExpressionValue(byteBufferAllocate, "allocate(...)");
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            options.inTempStorage = byteBufferAllocate.array();
            BitmapFactory.decodeStream(inputStream, null, options);
            ImageMetaData imageMetaData = new ImageMetaData(options.outWidth, options.outHeight, Build.VERSION.SDK_INT >= 26 ? options.outColorSpace : null);
            ((Pools.SynchronizedPool) lazy.getValue()).a(byteBufferAllocate);
            return imageMetaData;
        } catch (Throwable th) {
            ((Pools.SynchronizedPool) lazy.getValue()).a(byteBufferAllocate);
            throw th;
        }
    }

    public static final int b(Bitmap.Config config) {
        switch (config == null ? -1 : WhenMappings.f18393a[config.ordinal()]) {
            case 1:
                return 4;
            case 2:
                return 1;
            case 3:
            case 4:
                return 2;
            case 5:
                return 8;
            case 6:
            case 7:
                return 4;
            default:
                throw new UnsupportedOperationException("The provided Bitmap.Config is not supported");
        }
    }

    public static final int c(int i2, int i3, Bitmap.Config config) {
        if (i2 <= 0) {
            throw new IllegalArgumentException(android.support.v4.media.b.f(i2, "width must be > 0, width is: ").toString());
        }
        if (i3 <= 0) {
            throw new IllegalArgumentException(android.support.v4.media.b.f(i3, "height must be > 0, height is: ").toString());
        }
        int iB = b(config);
        int i4 = i2 * i3 * iB;
        if (i4 > 0) {
            return i4;
        }
        StringBuilder sbT = android.support.v4.media.b.t(i4, i2, "size must be > 0: size: ", ", width: ", ", height: ");
        sbT.append(i3);
        sbT.append(", pixelSize: ");
        sbT.append(iB);
        throw new IllegalStateException(sbT.toString().toString());
    }

    public static final int d(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        try {
            return bitmap.getAllocationByteCount();
        } catch (NullPointerException unused) {
            return bitmap.getByteCount();
        }
    }
}
