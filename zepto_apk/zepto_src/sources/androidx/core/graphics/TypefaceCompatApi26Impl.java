package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RequiresApi
@RestrictTo
/* loaded from: classes3.dex */
public class TypefaceCompatApi26Impl extends TypefaceCompatApi21Impl {

    /* renamed from: g, reason: collision with root package name */
    public final Class f2834g;

    /* renamed from: h, reason: collision with root package name */
    public final Constructor f2835h;

    /* renamed from: i, reason: collision with root package name */
    public final Method f2836i;

    /* renamed from: j, reason: collision with root package name */
    public final Method f2837j;

    /* renamed from: k, reason: collision with root package name */
    public final Method f2838k;

    /* renamed from: l, reason: collision with root package name */
    public final Method f2839l;

    /* renamed from: m, reason: collision with root package name */
    public final Method f2840m;

    public TypefaceCompatApi26Impl() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        Method methodP;
        Constructor<?> constructor;
        Method methodO;
        Method method;
        Method method2;
        Method method3;
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("android.graphics.FontFamily");
            constructor = cls2.getConstructor(null);
            methodO = o(cls2);
            Class cls3 = Integer.TYPE;
            method = cls2.getMethod("addFontFromBuffer", ByteBuffer.class, cls3, FontVariationAxis[].class, cls3, cls3);
            method2 = cls2.getMethod("freeze", null);
            method3 = cls2.getMethod("abortCreation", null);
            methodP = p(cls2);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class ".concat(e2.getClass().getName()), e2);
            methodP = null;
            constructor = null;
            methodO = null;
            method = null;
            method2 = null;
            method3 = null;
        }
        this.f2834g = cls;
        this.f2835h = constructor;
        this.f2836i = methodO;
        this.f2837j = method;
        this.f2838k = method2;
        this.f2839l = method3;
        this.f2840m = methodP;
    }

    public static Method o(Class cls) {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    @Override // androidx.core.graphics.TypefaceCompatApi21Impl, androidx.core.graphics.TypefaceCompatBaseImpl
    public final Typeface a(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = this.f2836i;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method == null) {
            return super.a(context, fontFamilyFilesResourceEntry, resources, i2);
        }
        Object objN = n();
        if (objN != null) {
            FontResourcesParserCompat.FontFileResourceEntry[] fontFileResourceEntryArr = fontFamilyFilesResourceEntry.f2750a;
            int length = fontFileResourceEntryArr.length;
            int i3 = 0;
            while (i3 < length) {
                FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry = fontFileResourceEntryArr[i3];
                String str = fontFileResourceEntry.f2751a;
                FontVariationAxis[] fontVariationAxisArrFromFontVariationSettings = FontVariationAxis.fromFontVariationSettings(fontFileResourceEntry.f2754d);
                Context context2 = context;
                if (!k(context2, objN, str, fontFileResourceEntry.f2755e, fontFileResourceEntry.f2752b, fontFileResourceEntry.f2753c ? 1 : 0, fontVariationAxisArrFromFontVariationSettings)) {
                    j(objN);
                    return null;
                }
                i3++;
                context = context2;
            }
            if (m(objN)) {
                return l(objN);
            }
        }
        return null;
    }

    @Override // androidx.core.graphics.TypefaceCompatApi21Impl, androidx.core.graphics.TypefaceCompatBaseImpl
    public final Typeface b(Context context, FontsContractCompat.FontInfo[] fontInfoArr, int i2) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        Typeface typefaceL;
        boolean zBooleanValue;
        if (fontInfoArr.length >= 1) {
            Method method = this.f2836i;
            if (method == null) {
                Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
            }
            if (method != null) {
                HashMap map = new HashMap();
                for (FontsContractCompat.FontInfo fontInfo : fontInfoArr) {
                    if (fontInfo.f2927e == 0) {
                        Uri uri = fontInfo.f2923a;
                        if (!map.containsKey(uri)) {
                            map.put(uri, TypefaceCompatUtil.e(context, uri));
                        }
                    }
                }
                Map mapUnmodifiableMap = Collections.unmodifiableMap(map);
                Object objN = n();
                if (objN != null) {
                    int length = fontInfoArr.length;
                    int i3 = 0;
                    boolean z = false;
                    while (i3 < length) {
                        FontsContractCompat.FontInfo fontInfo2 = fontInfoArr[i3];
                        ByteBuffer byteBuffer = (ByteBuffer) mapUnmodifiableMap.get(fontInfo2.f2923a);
                        if (byteBuffer != null) {
                            try {
                                zBooleanValue = ((Boolean) this.f2837j.invoke(objN, byteBuffer, Integer.valueOf(fontInfo2.f2924b), null, Integer.valueOf(fontInfo2.f2925c), Integer.valueOf(fontInfo2.f2926d ? 1 : 0))).booleanValue();
                            } catch (IllegalAccessException | InvocationTargetException unused) {
                                zBooleanValue = false;
                            }
                            if (!zBooleanValue) {
                                j(objN);
                                return null;
                            }
                            z = true;
                        }
                        i3++;
                        z = z;
                    }
                    if (!z) {
                        j(objN);
                        return null;
                    }
                    if (m(objN) && (typefaceL = l(objN)) != null) {
                        return Typeface.create(typefaceL, i2);
                    }
                }
            } else {
                FontsContractCompat.FontInfo fontInfoG = g(fontInfoArr, i2);
                try {
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(fontInfoG.f2923a, "r", null);
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        try {
                            Typeface typefaceBuild = new Typeface.Builder(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).setWeight(fontInfoG.f2925c).setItalic(fontInfoG.f2926d).build();
                            parcelFileDescriptorOpenFileDescriptor.close();
                            return typefaceBuild;
                        } finally {
                        }
                    }
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                        return null;
                    }
                } catch (IOException unused2) {
                }
            }
        }
        return null;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public final Typeface e(Context context, Resources resources, int i2, String str, int i3) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = this.f2836i;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method == null) {
            return super.e(context, resources, i2, str, i3);
        }
        Object objN = n();
        if (objN != null) {
            if (!k(context, objN, str, 0, -1, -1, null)) {
                j(objN);
                return null;
            }
            if (m(objN)) {
                return l(objN);
            }
        }
        return null;
    }

    public final void j(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            this.f2839l.invoke(obj, null);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public final boolean k(Context context, Object obj, String str, int i2, int i3, int i4, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f2836i.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface l(Object obj) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) this.f2834g, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.f2840m.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean m(Object obj) {
        try {
            return ((Boolean) this.f2838k.invoke(obj, null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final Object n() {
        try {
            return this.f2835h.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public Method p(Class cls) throws NoSuchMethodException, SecurityException {
        Class<?> cls2 = Array.newInstance((Class<?>) cls, 1).getClass();
        Class cls3 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", cls2, cls3, cls3);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
