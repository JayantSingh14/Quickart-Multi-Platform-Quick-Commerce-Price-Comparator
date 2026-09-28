package androidx.core.graphics;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.provider.FontsContractCompat;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

@RequiresApi
@RestrictTo
/* loaded from: classes3.dex */
class TypefaceCompatApi24Impl extends TypefaceCompatBaseImpl {

    /* renamed from: b, reason: collision with root package name */
    public static final Class f2830b;

    /* renamed from: c, reason: collision with root package name */
    public static final Constructor f2831c;

    /* renamed from: d, reason: collision with root package name */
    public static final Method f2832d;

    /* renamed from: e, reason: collision with root package name */
    public static final Method f2833e;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            Class cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi24Impl", e2.getClass().getName(), e2);
            cls = null;
            method = null;
            method2 = null;
        }
        f2831c = constructor;
        f2830b = cls;
        f2832d = method2;
        f2833e = method;
    }

    public static boolean h(Object obj, ByteBuffer byteBuffer, int i2, int i3, boolean z) {
        try {
            return ((Boolean) f2832d.invoke(obj, byteBuffer, Integer.valueOf(i2), null, Integer.valueOf(i3), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public static Typeface i(Object obj) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) f2830b, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f2833e.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0067 A[SYNTHETIC] */
    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Typeface a(android.content.Context r17, androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry r18, android.content.res.Resources r19, int r20) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r16 = this;
            r1 = 0
            java.lang.reflect.Constructor r0 = androidx.core.graphics.TypefaceCompatApi24Impl.f2831c     // Catch: java.lang.Throwable -> L9
            java.lang.Object r0 = r0.newInstance(r1)     // Catch: java.lang.Throwable -> L9
            r2 = r0
            goto La
        L9:
            r2 = r1
        La:
            if (r2 != 0) goto Ld
            goto L67
        Ld:
            r0 = r18
            androidx.core.content.res.FontResourcesParserCompat$FontFileResourceEntry[] r3 = r0.f2750a
            int r4 = r3.length
            r0 = 0
            r5 = r0
        L14:
            if (r5 >= r4) goto L70
            r6 = r3[r5]
            int r0 = r6.f2756f
            java.io.File r7 = androidx.core.graphics.TypefaceCompatUtil.d(r17)
            if (r7 != 0) goto L24
            r8 = r19
        L22:
            r0 = r1
            goto L58
        L24:
            r8 = r19
            boolean r0 = androidx.core.graphics.TypefaceCompatUtil.b(r7, r8, r0)     // Catch: java.lang.Throwable -> L6b
            if (r0 != 0) goto L30
            r7.delete()
            goto L22
        L30:
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch: java.io.IOException -> L54 java.lang.Throwable -> L6b
            r9.<init>(r7)     // Catch: java.io.IOException -> L54 java.lang.Throwable -> L6b
            java.nio.channels.FileChannel r10 = r9.getChannel()     // Catch: java.lang.Throwable -> L49
            long r14 = r10.size()     // Catch: java.lang.Throwable -> L49
            java.nio.channels.FileChannel$MapMode r11 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch: java.lang.Throwable -> L49
            r12 = 0
            java.nio.MappedByteBuffer r0 = r10.map(r11, r12, r14)     // Catch: java.lang.Throwable -> L49
            r9.close()     // Catch: java.io.IOException -> L54 java.lang.Throwable -> L6b
            goto L55
        L49:
            r0 = move-exception
            r10 = r0
            r9.close()     // Catch: java.lang.Throwable -> L4f
            goto L53
        L4f:
            r0 = move-exception
            r10.addSuppressed(r0)     // Catch: java.io.IOException -> L54 java.lang.Throwable -> L6b
        L53:
            throw r10     // Catch: java.io.IOException -> L54 java.lang.Throwable -> L6b
        L54:
            r0 = r1
        L55:
            r7.delete()
        L58:
            if (r0 != 0) goto L5b
            goto L67
        L5b:
            int r7 = r6.f2752b
            boolean r9 = r6.f2753c
            int r6 = r6.f2755e
            boolean r0 = h(r2, r0, r6, r7, r9)
            if (r0 != 0) goto L68
        L67:
            return r1
        L68:
            int r5 = r5 + 1
            goto L14
        L6b:
            r0 = move-exception
            r7.delete()
            throw r0
        L70:
            android.graphics.Typeface r0 = i(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.TypefaceCompatApi24Impl.a(android.content.Context, androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry, android.content.res.Resources, int):android.graphics.Typeface");
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public final Typeface b(Context context, FontsContractCompat.FontInfo[] fontInfoArr, int i2) throws IllegalAccessException, InstantiationException, IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException, InvocationTargetException, NegativeArraySizeException {
        Object objNewInstance;
        try {
            objNewInstance = f2831c.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance != null) {
            SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
            int length = fontInfoArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    Typeface typefaceI = i(objNewInstance);
                    if (typefaceI != null) {
                        return Typeface.create(typefaceI, i2);
                    }
                } else {
                    FontsContractCompat.FontInfo fontInfo = fontInfoArr[i3];
                    Uri uri = fontInfo.f2923a;
                    ByteBuffer byteBufferE = (ByteBuffer) simpleArrayMap.get(uri);
                    if (byteBufferE == null) {
                        byteBufferE = TypefaceCompatUtil.e(context, uri);
                        simpleArrayMap.put(uri, byteBufferE);
                    }
                    if (byteBufferE == null) {
                        break;
                    }
                    if (!h(objNewInstance, byteBufferE, fontInfo.f2924b, fontInfo.f2925c, fontInfo.f2926d)) {
                        break;
                    }
                    i3++;
                }
            }
        }
        return null;
    }
}
