package com.facebook.webpsupport;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.TypedValue;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.nativecode.StaticWebpNativeLoader;
import com.facebook.infer.annotation.Nullsafe;
import java.io.BufferedInputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;
import org.xbill.DNS.KEYRecord;

@DoNotStrip
@Nullsafe
/* loaded from: classes3.dex */
public class WebpBitmapFactoryImpl implements WebpBitmapFactory {
    public static byte[] b(InputStream inputStream, BitmapFactory.Options options) throws IOException {
        byte[] bArr;
        inputStream.mark(20);
        if (options == null || (bArr = options.inTempStorage) == null || bArr.length < 20) {
            bArr = new byte[20];
        }
        try {
            inputStream.read(bArr, 0, 20);
            inputStream.reset();
            return bArr;
        } catch (IOException unused) {
            return null;
        }
    }

    public static void c(Bitmap bitmap, BitmapFactory.Options options) {
        if (bitmap != null && options != null) {
            int i2 = options.inDensity;
            if (i2 != 0) {
                bitmap.setDensity(i2);
                int i3 = options.inTargetDensity;
                if (i3 != 0 && i2 != i3 && i2 != options.inScreenDensity && options.inScaled) {
                    bitmap.setDensity(i3);
                }
            } else if (options.inBitmap != null) {
                bitmap.setDensity(160);
            }
        }
        if (options != null) {
            options.outMimeType = "image/webp";
        }
    }

    @DoNotStrip
    @Nullable
    private static Bitmap createBitmap(int i2, int i3, @Nullable BitmapFactory.Options options) {
        Bitmap bitmap;
        if (options != null && (bitmap = options.inBitmap) != null && bitmap.isMutable()) {
            return options.inBitmap;
        }
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        throw null;
    }

    @DoNotStrip
    private static byte[] getInTempStorageFromOptions(@Nullable BitmapFactory.Options options) {
        byte[] bArr;
        return (options == null || (bArr = options.inTempStorage) == null) ? new byte[KEYRecord.Flags.FLAG2] : bArr;
    }

    @DoNotStrip
    private static float getScaleFromOptions(@Nullable BitmapFactory.Options options) {
        if (options != null) {
            int i2 = options.inSampleSize;
            f = i2 > 1 ? 1.0f / i2 : 1.0f;
            if (options.inScaled) {
                int i3 = options.inDensity;
                int i4 = options.inTargetDensity;
                int i5 = options.inScreenDensity;
                if (i3 != 0 && i4 != 0 && i3 != i5) {
                    return i4 / i3;
                }
            }
        }
        return f;
    }

    @DoNotStrip
    @Nullable
    public static Bitmap hookDecodeByteArray(byte[] bArr, int i2, int i3, @Nullable BitmapFactory.Options options) {
        StaticWebpNativeLoader.a();
        if (!WebpSupportStatus.sIsWebpSupportRequired || !WebpSupportStatus.b(i2, bArr, i3)) {
            return originalDecodeByteArray(bArr, i2, i3, options);
        }
        Bitmap bitmapNativeDecodeByteArray = nativeDecodeByteArray(bArr, i2, i3, options, getScaleFromOptions(options), getInTempStorageFromOptions(options));
        c(bitmapNativeDecodeByteArray, options);
        return bitmapNativeDecodeByteArray;
    }

    @DoNotStrip
    @Nullable
    public static Bitmap hookDecodeFile(String str, @Nullable BitmapFactory.Options options) throws IOException {
        Bitmap bitmapHookDecodeStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            try {
                bitmapHookDecodeStream = hookDecodeStream(fileInputStream, null, options);
                fileInputStream.close();
                return bitmapHookDecodeStream;
            } finally {
            }
        } catch (Exception unused) {
            return bitmapHookDecodeStream;
        }
    }

    @DoNotStrip
    @Nullable
    public static Bitmap hookDecodeFileDescriptor(FileDescriptor fileDescriptor, @Nullable Rect rect, @Nullable BitmapFactory.Options options) throws IOException {
        Bitmap bitmapOriginalDecodeFileDescriptor;
        StaticWebpNativeLoader.a();
        long jNativeSeek = nativeSeek(fileDescriptor, 0L, false);
        if (jNativeSeek == -1) {
            Bitmap bitmapHookDecodeStream = hookDecodeStream(new FileInputStream(fileDescriptor), rect, options);
            setPaddingDefaultValues(rect);
            return bitmapHookDecodeStream;
        }
        InputStream fileInputStream = new FileInputStream(fileDescriptor);
        if (!fileInputStream.markSupported()) {
            fileInputStream = new BufferedInputStream(fileInputStream, 20);
        }
        try {
            byte[] bArrB = b(fileInputStream, options);
            if (WebpSupportStatus.sIsWebpSupportRequired && bArrB != null && WebpSupportStatus.b(0, bArrB, 20)) {
                bitmapOriginalDecodeFileDescriptor = nativeDecodeStream(fileInputStream, options, getScaleFromOptions(options), getInTempStorageFromOptions(options));
                setPaddingDefaultValues(rect);
                c(bitmapOriginalDecodeFileDescriptor, options);
            } else {
                nativeSeek(fileDescriptor, jNativeSeek, true);
                bitmapOriginalDecodeFileDescriptor = originalDecodeFileDescriptor(fileDescriptor, rect, options);
            }
            try {
                fileInputStream.close();
            } catch (Throwable unused) {
            }
            return bitmapOriginalDecodeFileDescriptor;
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable unused2) {
            }
            throw th;
        }
    }

    @DoNotStrip
    @Nullable
    public static Bitmap hookDecodeResource(Resources resources, int i2, @Nullable BitmapFactory.Options options) throws Resources.NotFoundException, IOException {
        TypedValue typedValue = new TypedValue();
        Bitmap bitmapHookDecodeResourceStream = null;
        try {
            InputStream inputStreamOpenRawResource = resources.openRawResource(i2, typedValue);
            try {
                bitmapHookDecodeResourceStream = hookDecodeResourceStream(resources, typedValue, inputStreamOpenRawResource, null, options);
                if (inputStreamOpenRawResource != null) {
                    inputStreamOpenRawResource.close();
                }
            } finally {
            }
        } catch (Exception unused) {
        }
        if (bitmapHookDecodeResourceStream != null || options == null || options.inBitmap == null) {
            return bitmapHookDecodeResourceStream;
        }
        throw new IllegalArgumentException("Problem decoding into existing bitmap");
    }

    @DoNotStrip
    @Nullable
    public static Bitmap hookDecodeResourceStream(@Nullable Resources resources, @Nullable TypedValue typedValue, InputStream inputStream, @Nullable Rect rect, @Nullable BitmapFactory.Options options) {
        if (options == null) {
            options = new BitmapFactory.Options();
        }
        if (options.inDensity == 0 && typedValue != null) {
            int i2 = typedValue.density;
            if (i2 == 0) {
                options.inDensity = 160;
            } else if (i2 != 65535) {
                options.inDensity = i2;
            }
        }
        if (options.inTargetDensity == 0 && resources != null) {
            options.inTargetDensity = resources.getDisplayMetrics().densityDpi;
        }
        return hookDecodeStream(inputStream, rect, options);
    }

    @DoNotStrip
    @Nullable
    public static Bitmap hookDecodeStream(InputStream inputStream, @Nullable Rect rect, @Nullable BitmapFactory.Options options) throws IOException {
        StaticWebpNativeLoader.a();
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream, 20);
        }
        byte[] bArrB = b(inputStream, options);
        if (!WebpSupportStatus.sIsWebpSupportRequired || bArrB == null || !WebpSupportStatus.b(0, bArrB, 20)) {
            return originalDecodeStream(inputStream, rect, options);
        }
        Bitmap bitmapNativeDecodeStream = nativeDecodeStream(inputStream, options, getScaleFromOptions(options), getInTempStorageFromOptions(options));
        c(bitmapNativeDecodeStream, options);
        setPaddingDefaultValues(rect);
        return bitmapNativeDecodeStream;
    }

    @DoNotStrip
    @Nullable
    private static native Bitmap nativeDecodeByteArray(byte[] bArr, int i2, int i3, @Nullable BitmapFactory.Options options, float f2, byte[] bArr2);

    @DoNotStrip
    @Nullable
    private static native Bitmap nativeDecodeStream(InputStream inputStream, @Nullable BitmapFactory.Options options, float f2, byte[] bArr);

    @DoNotStrip
    private static native long nativeSeek(FileDescriptor fileDescriptor, long j2, boolean z);

    @DoNotStrip
    @Nullable
    private static Bitmap originalDecodeByteArray(byte[] bArr, int i2, int i3, @Nullable BitmapFactory.Options options) {
        return BitmapFactory.decodeByteArray(bArr, i2, i3, options);
    }

    @DoNotStrip
    @Nullable
    private static Bitmap originalDecodeFile(String str, @Nullable BitmapFactory.Options options) {
        return BitmapFactory.decodeFile(str, options);
    }

    @DoNotStrip
    @Nullable
    private static Bitmap originalDecodeFileDescriptor(FileDescriptor fileDescriptor, @Nullable Rect rect, @Nullable BitmapFactory.Options options) {
        return BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options);
    }

    @DoNotStrip
    @Nullable
    private static Bitmap originalDecodeResource(Resources resources, int i2, BitmapFactory.Options options) {
        return BitmapFactory.decodeResource(resources, i2, options);
    }

    @DoNotStrip
    @Nullable
    private static Bitmap originalDecodeResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        return BitmapFactory.decodeResourceStream(resources, typedValue, inputStream, rect, options);
    }

    @DoNotStrip
    @Nullable
    private static Bitmap originalDecodeStream(InputStream inputStream, @Nullable Rect rect, @Nullable BitmapFactory.Options options) {
        return BitmapFactory.decodeStream(inputStream, rect, options);
    }

    @DoNotStrip
    private static void setBitmapSize(@Nullable BitmapFactory.Options options, int i2, int i3) {
        if (options != null) {
            options.outWidth = i2;
            options.outHeight = i3;
        }
    }

    @DoNotStrip
    private static boolean setOutDimensions(@Nullable BitmapFactory.Options options, int i2, int i3) {
        if (options == null || !options.inJustDecodeBounds) {
            return false;
        }
        options.outWidth = i2;
        options.outHeight = i3;
        return true;
    }

    @DoNotStrip
    private static void setPaddingDefaultValues(@Nullable Rect rect) {
        if (rect != null) {
            rect.top = -1;
            rect.left = -1;
            rect.bottom = -1;
            rect.right = -1;
        }
    }

    @DoNotStrip
    @SuppressLint({"NewApi"})
    private static boolean shouldPremultiply(@Nullable BitmapFactory.Options options) {
        if (options != null) {
            return options.inPremultiplied;
        }
        return true;
    }

    @Override // com.facebook.common.webp.WebpBitmapFactory
    public final Bitmap a(FileDescriptor fileDescriptor, BitmapFactory.Options options) {
        return hookDecodeFileDescriptor(fileDescriptor, null, options);
    }

    @DoNotStrip
    @Nullable
    private static Bitmap originalDecodeByteArray(byte[] bArr, int i2, int i3) {
        return BitmapFactory.decodeByteArray(bArr, i2, i3);
    }

    @DoNotStrip
    @Nullable
    private static Bitmap originalDecodeFile(String str) {
        return BitmapFactory.decodeFile(str);
    }

    @DoNotStrip
    @Nullable
    private static Bitmap originalDecodeFileDescriptor(FileDescriptor fileDescriptor) {
        return BitmapFactory.decodeFileDescriptor(fileDescriptor);
    }

    @DoNotStrip
    @Nullable
    private static Bitmap originalDecodeResource(Resources resources, int i2) {
        return BitmapFactory.decodeResource(resources, i2);
    }

    @DoNotStrip
    @Nullable
    private static Bitmap originalDecodeStream(InputStream inputStream) {
        return BitmapFactory.decodeStream(inputStream);
    }

    @DoNotStrip
    @Nullable
    public static Bitmap hookDecodeFile(String str) {
        return hookDecodeFile(str, null);
    }

    @DoNotStrip
    @Nullable
    public static Bitmap hookDecodeByteArray(byte[] bArr, int i2, int i3) {
        return hookDecodeByteArray(bArr, i2, i3, null);
    }

    @DoNotStrip
    @Nullable
    public static Bitmap hookDecodeResource(Resources resources, int i2) {
        return hookDecodeResource(resources, i2, null);
    }

    @DoNotStrip
    @Nullable
    public static Bitmap hookDecodeStream(InputStream inputStream) {
        return hookDecodeStream(inputStream, null, null);
    }

    @DoNotStrip
    @Nullable
    public static Bitmap hookDecodeFileDescriptor(FileDescriptor fileDescriptor) {
        return hookDecodeFileDescriptor(fileDescriptor, null, null);
    }
}
