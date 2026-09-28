package com.facebook.imagepipeline.request;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import com.facebook.infer.annotation.Nullsafe;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Nullsafe
/* loaded from: classes3.dex */
public abstract class BasePostprocessor implements Postprocessor {

    /* renamed from: a, reason: collision with root package name */
    public static final Bitmap.Config f18344a = Bitmap.Config.ARGB_8888;

    /* renamed from: b, reason: collision with root package name */
    public static Method f18345b;

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public CacheKey a() {
        return null;
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public CloseableReference c(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory) {
        Bitmap.Config config = bitmap.getConfig();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (config == null) {
            config = f18344a;
        }
        CloseableReference closeableReferenceA = platformBitmapFactory.a(width, height, config);
        try {
            e((Bitmap) closeableReferenceA.l(), bitmap);
            CloseableReference closeableReferenceClone = closeableReferenceA.clone();
            closeableReferenceA.close();
            return closeableReferenceClone;
        } catch (Throwable th) {
            CloseableReference.e(closeableReferenceA);
            throw th;
        }
    }

    public void d(Bitmap bitmap) {
    }

    public void e(Bitmap bitmap, Bitmap bitmap2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (bitmap.getConfig() == bitmap2.getConfig()) {
            try {
                if (f18345b == null) {
                    int i2 = Bitmaps.f18061a;
                    f18345b = Bitmaps.class.getDeclaredMethod("copyBitmap", Bitmap.class, Bitmap.class);
                }
                f18345b.invoke(null, bitmap, bitmap2);
            } catch (ClassNotFoundException e2) {
                throw new RuntimeException("Wrong Native code setup, reflection failed.", e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Wrong Native code setup, reflection failed.", e3);
            } catch (NoSuchMethodException e4) {
                throw new RuntimeException("Wrong Native code setup, reflection failed.", e4);
            } catch (InvocationTargetException e5) {
                throw new RuntimeException("Wrong Native code setup, reflection failed.", e5);
            }
        } else {
            new Canvas(bitmap).drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
        }
        d(bitmap);
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public String getName() {
        return "Unknown postprocessor";
    }
}
