package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class ResourcesCompat {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f2764a = new ThreadLocal();

    /* renamed from: b, reason: collision with root package name */
    public static final WeakHashMap f2765b = new WeakHashMap(0);

    /* renamed from: c, reason: collision with root package name */
    public static final Object f2766c = new Object();

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api21Impl {
        public static Drawable a(Resources resources, int i2, Resources.Theme theme) {
            return resources.getDrawable(i2, theme);
        }

        public static Drawable b(Resources resources, int i2, int i3, Resources.Theme theme) {
            return resources.getDrawableForDensity(i2, i3, theme);
        }
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api23Impl {
        public static int a(Resources resources, int i2, Resources.Theme theme) {
            return resources.getColor(i2, theme);
        }

        public static ColorStateList b(Resources resources, int i2, Resources.Theme theme) {
            return resources.getColorStateList(i2, theme);
        }
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api29Impl {
    }

    /* loaded from: classes3.dex */
    public static class ColorStateListCacheEntry {

        /* renamed from: a, reason: collision with root package name */
        public final ColorStateList f2767a;

        /* renamed from: b, reason: collision with root package name */
        public final Configuration f2768b;

        /* renamed from: c, reason: collision with root package name */
        public final int f2769c;

        public ColorStateListCacheEntry(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            this.f2767a = colorStateList;
            this.f2768b = configuration;
            this.f2769c = theme == null ? 0 : theme.hashCode();
        }
    }

    /* loaded from: classes3.dex */
    public static final class ColorStateListCacheKey {

        /* renamed from: a, reason: collision with root package name */
        public final Resources f2770a;

        /* renamed from: b, reason: collision with root package name */
        public final Resources.Theme f2771b;

        public ColorStateListCacheKey(Resources resources, Resources.Theme theme) {
            this.f2770a = resources;
            this.f2771b = theme;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && ColorStateListCacheKey.class == obj.getClass()) {
                ColorStateListCacheKey colorStateListCacheKey = (ColorStateListCacheKey) obj;
                if (this.f2770a.equals(colorStateListCacheKey.f2770a) && Objects.equals(this.f2771b, colorStateListCacheKey.f2771b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return Objects.hash(this.f2770a, this.f2771b);
        }
    }

    public static abstract class FontCallback {
        public final void a(int i2) {
            new Handler(Looper.getMainLooper()).post(new a(this, i2));
        }

        public abstract void b(int i2);

        public abstract void c(Typeface typeface);
    }

    /* loaded from: classes3.dex */
    public static final class ThemeCompat {

        @RequiresApi
        public static class Api23Impl {

            /* renamed from: a, reason: collision with root package name */
            public static final Object f2772a = new Object();

            /* renamed from: b, reason: collision with root package name */
            public static Method f2773b;

            /* renamed from: c, reason: collision with root package name */
            public static boolean f2774c;
        }

        @RequiresApi
        public static class Api29Impl {
            public static void a(Resources.Theme theme) {
                theme.rebase();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x0031 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void a(android.content.res.Resources.Theme r6) {
            /*
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 29
                if (r0 < r1) goto La
                androidx.core.content.res.ResourcesCompat.ThemeCompat.Api29Impl.a(r6)
                return
            La:
                java.lang.Object r0 = androidx.core.content.res.ResourcesCompat.ThemeCompat.Api23Impl.f2772a
                monitor-enter(r0)
                boolean r1 = androidx.core.content.res.ResourcesCompat.ThemeCompat.Api23Impl.f2774c     // Catch: java.lang.Throwable -> L21
                r2 = 0
                if (r1 != 0) goto L2d
                r1 = 1
                java.lang.Class<android.content.res.Resources$Theme> r3 = android.content.res.Resources.Theme.class
                java.lang.String r4 = "rebase"
                java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r2)     // Catch: java.lang.Throwable -> L21 java.lang.NoSuchMethodException -> L23
                androidx.core.content.res.ResourcesCompat.ThemeCompat.Api23Impl.f2773b = r3     // Catch: java.lang.Throwable -> L21 java.lang.NoSuchMethodException -> L23
                r3.setAccessible(r1)     // Catch: java.lang.Throwable -> L21 java.lang.NoSuchMethodException -> L23
                goto L2b
            L21:
                r6 = move-exception
                goto L43
            L23:
                r3 = move-exception
                java.lang.String r4 = "ResourcesCompat"
                java.lang.String r5 = "Failed to retrieve rebase() method"
                android.util.Log.i(r4, r5, r3)     // Catch: java.lang.Throwable -> L21
            L2b:
                androidx.core.content.res.ResourcesCompat.ThemeCompat.Api23Impl.f2774c = r1     // Catch: java.lang.Throwable -> L21
            L2d:
                java.lang.reflect.Method r1 = androidx.core.content.res.ResourcesCompat.ThemeCompat.Api23Impl.f2773b     // Catch: java.lang.Throwable -> L21
                if (r1 == 0) goto L41
                r1.invoke(r6, r2)     // Catch: java.lang.Throwable -> L21 java.lang.reflect.InvocationTargetException -> L35 java.lang.IllegalAccessException -> L37
                goto L41
            L35:
                r6 = move-exception
                goto L38
            L37:
                r6 = move-exception
            L38:
                java.lang.String r1 = "ResourcesCompat"
                java.lang.String r3 = "Failed to invoke rebase() method via reflection"
                android.util.Log.i(r1, r3, r6)     // Catch: java.lang.Throwable -> L21
                androidx.core.content.res.ResourcesCompat.ThemeCompat.Api23Impl.f2773b = r2     // Catch: java.lang.Throwable -> L21
            L41:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L21
                return
            L43:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L21
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ResourcesCompat.ThemeCompat.a(android.content.res.Resources$Theme):void");
        }
    }

    public static int a(Resources resources, int i2, Resources.Theme theme) {
        return Api23Impl.a(resources, i2, theme);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
    
        if (r4.f2769c == r9.hashCode()) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.content.res.ColorStateList b(android.content.res.Resources r7, int r8, android.content.res.Resources.Theme r9) throws android.content.res.Resources.NotFoundException {
        /*
            androidx.core.content.res.ResourcesCompat$ColorStateListCacheKey r0 = new androidx.core.content.res.ResourcesCompat$ColorStateListCacheKey
            r0.<init>(r7, r9)
            java.lang.Object r1 = androidx.core.content.res.ResourcesCompat.f2766c
            monitor-enter(r1)
            java.util.WeakHashMap r2 = androidx.core.content.res.ResourcesCompat.f2765b     // Catch: java.lang.Throwable -> L34
            java.lang.Object r2 = r2.get(r0)     // Catch: java.lang.Throwable -> L34
            android.util.SparseArray r2 = (android.util.SparseArray) r2     // Catch: java.lang.Throwable -> L34
            r3 = 0
            if (r2 == 0) goto L48
            int r4 = r2.size()     // Catch: java.lang.Throwable -> L34
            if (r4 <= 0) goto L48
            java.lang.Object r4 = r2.get(r8)     // Catch: java.lang.Throwable -> L34
            androidx.core.content.res.ResourcesCompat$ColorStateListCacheEntry r4 = (androidx.core.content.res.ResourcesCompat.ColorStateListCacheEntry) r4     // Catch: java.lang.Throwable -> L34
            if (r4 == 0) goto L48
            android.content.res.Configuration r5 = r4.f2768b     // Catch: java.lang.Throwable -> L34
            android.content.res.Configuration r6 = r7.getConfiguration()     // Catch: java.lang.Throwable -> L34
            boolean r5 = r5.equals(r6)     // Catch: java.lang.Throwable -> L34
            if (r5 == 0) goto L45
            if (r9 != 0) goto L37
            int r5 = r4.f2769c     // Catch: java.lang.Throwable -> L34
            if (r5 == 0) goto L41
            goto L37
        L34:
            r7 = move-exception
            goto Lb0
        L37:
            if (r9 == 0) goto L45
            int r5 = r4.f2769c     // Catch: java.lang.Throwable -> L34
            int r6 = r9.hashCode()     // Catch: java.lang.Throwable -> L34
            if (r5 != r6) goto L45
        L41:
            android.content.res.ColorStateList r2 = r4.f2767a     // Catch: java.lang.Throwable -> L34
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L34
            goto L4a
        L45:
            r2.remove(r8)     // Catch: java.lang.Throwable -> L34
        L48:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L34
            r2 = r3
        L4a:
            if (r2 == 0) goto L4d
            return r2
        L4d:
            java.lang.ThreadLocal r1 = androidx.core.content.res.ResourcesCompat.f2764a
            java.lang.Object r2 = r1.get()
            android.util.TypedValue r2 = (android.util.TypedValue) r2
            if (r2 != 0) goto L5f
            android.util.TypedValue r2 = new android.util.TypedValue
            r2.<init>()
            r1.set(r2)
        L5f:
            r1 = 1
            r7.getValue(r8, r2, r1)
            int r1 = r2.type
            r2 = 28
            if (r1 < r2) goto L6e
            r2 = 31
            if (r1 > r2) goto L6e
            goto L7f
        L6e:
            android.content.res.XmlResourceParser r1 = r7.getXml(r8)
            android.content.res.ColorStateList r3 = androidx.core.content.res.ColorStateListInflaterCompat.a(r7, r1, r9)     // Catch: java.lang.Exception -> L77
            goto L7f
        L77:
            r1 = move-exception
            java.lang.String r2 = "ResourcesCompat"
            java.lang.String r4 = "Failed to inflate ColorStateList, leaving it to the framework"
            android.util.Log.w(r2, r4, r1)
        L7f:
            if (r3 == 0) goto Lab
            java.lang.Object r1 = androidx.core.content.res.ResourcesCompat.f2766c
            monitor-enter(r1)
            java.util.WeakHashMap r7 = androidx.core.content.res.ResourcesCompat.f2765b     // Catch: java.lang.Throwable -> L97
            java.lang.Object r2 = r7.get(r0)     // Catch: java.lang.Throwable -> L97
            android.util.SparseArray r2 = (android.util.SparseArray) r2     // Catch: java.lang.Throwable -> L97
            if (r2 != 0) goto L99
            android.util.SparseArray r2 = new android.util.SparseArray     // Catch: java.lang.Throwable -> L97
            r2.<init>()     // Catch: java.lang.Throwable -> L97
            r7.put(r0, r2)     // Catch: java.lang.Throwable -> L97
            goto L99
        L97:
            r7 = move-exception
            goto La9
        L99:
            androidx.core.content.res.ResourcesCompat$ColorStateListCacheEntry r7 = new androidx.core.content.res.ResourcesCompat$ColorStateListCacheEntry     // Catch: java.lang.Throwable -> L97
            android.content.res.Resources r0 = r0.f2770a     // Catch: java.lang.Throwable -> L97
            android.content.res.Configuration r0 = r0.getConfiguration()     // Catch: java.lang.Throwable -> L97
            r7.<init>(r3, r0, r9)     // Catch: java.lang.Throwable -> L97
            r2.append(r8, r7)     // Catch: java.lang.Throwable -> L97
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L97
            return r3
        La9:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L97
            throw r7
        Lab:
            android.content.res.ColorStateList r7 = androidx.core.content.res.ResourcesCompat.Api23Impl.b(r7, r8, r9)
            return r7
        Lb0:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L34
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ResourcesCompat.b(android.content.res.Resources, int, android.content.res.Resources$Theme):android.content.res.ColorStateList");
    }

    public static Drawable c(Resources resources, int i2, Resources.Theme theme) {
        return Api21Impl.a(resources, i2, theme);
    }

    public static Drawable d(Resources resources, int i2, int i3, Resources.Theme theme) {
        return Api21Impl.b(resources, i2, i3, theme);
    }

    public static Typeface e(int i2, Context context) {
        if (context.isRestricted()) {
            return null;
        }
        return f(context, i2, new TypedValue(), 0, null, false, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c4 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface f(android.content.Context r12, int r13, android.util.TypedValue r14, int r15, androidx.core.content.res.ResourcesCompat.FontCallback r16, boolean r17, boolean r18) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ResourcesCompat.f(android.content.Context, int, android.util.TypedValue, int, androidx.core.content.res.ResourcesCompat$FontCallback, boolean, boolean):android.graphics.Typeface");
    }
}
