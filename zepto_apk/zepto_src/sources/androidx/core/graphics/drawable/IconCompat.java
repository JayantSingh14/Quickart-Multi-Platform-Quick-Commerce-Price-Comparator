package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k, reason: collision with root package name */
    public static final PorterDuff.Mode f2842k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a, reason: collision with root package name */
    public int f2843a;

    /* renamed from: b, reason: collision with root package name */
    public Object f2844b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f2845c;

    /* renamed from: d, reason: collision with root package name */
    public Parcelable f2846d;

    /* renamed from: e, reason: collision with root package name */
    public int f2847e;

    /* renamed from: f, reason: collision with root package name */
    public int f2848f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f2849g;

    /* renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f2850h;

    /* renamed from: i, reason: collision with root package name */
    public String f2851i;

    /* renamed from: j, reason: collision with root package name */
    public String f2852j;

    @RequiresApi
    public static class Api23Impl {
    }

    @RequiresApi
    public static class Api26Impl {
        public static Icon a(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }

    @RequiresApi
    public static class Api28Impl {
        public static int a(Object obj) {
            return ((Icon) obj).getResId();
        }

        public static String b(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        public static int c(Object obj) {
            return ((Icon) obj).getType();
        }

        public static Uri d(Object obj) {
            return ((Icon) obj).getUri();
        }
    }

    @RequiresApi
    public static class Api30Impl {
        public static Icon a(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface IconType {
    }

    @RestrictTo
    public IconCompat() {
        this.f2843a = -1;
        this.f2845c = null;
        this.f2846d = null;
        this.f2847e = 0;
        this.f2848f = 0;
        this.f2849g = null;
        this.f2850h = f2842k;
        this.f2851i = null;
    }

    public static Bitmap a(Bitmap bitmap, boolean z) {
        int iMin = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(3);
        float f2 = iMin;
        float f3 = 0.5f * f2;
        float f4 = 0.9166667f * f3;
        if (z) {
            float f5 = 0.010416667f * f2;
            paint.setColor(0);
            paint.setShadowLayer(f5, 0.0f, f2 * 0.020833334f, 1023410176);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.setShadowLayer(f5, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - iMin)) / 2.0f, (-(bitmap.getHeight() - iMin)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f3, f3, f4, paint);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    public static IconCompat b(Bitmap bitmap) {
        bitmap.getClass();
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.f2844b = bitmap;
        return iconCompat;
    }

    public static IconCompat c(int i2, Context context) {
        context.getClass();
        return d(context.getResources(), context.getPackageName(), i2);
    }

    public static IconCompat d(Resources resources, String str, int i2) {
        str.getClass();
        if (i2 == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.f2847e = i2;
        if (resources != null) {
            try {
                iconCompat.f2844b = resources.getResourceName(i2);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.f2844b = str;
        }
        iconCompat.f2852j = str;
        return iconCompat;
    }

    public final int e() {
        int i2 = this.f2843a;
        if (i2 != -1) {
            if (i2 == 2) {
                return this.f2847e;
            }
            throw new IllegalStateException("called getResId() on " + this);
        }
        int i3 = Build.VERSION.SDK_INT;
        Object obj = this.f2844b;
        if (i3 >= 28) {
            return Api28Impl.a(obj);
        }
        try {
            return ((Integer) obj.getClass().getMethod("getResId", null).invoke(obj, null)).intValue();
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon resource", e2);
            return 0;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon resource", e3);
            return 0;
        } catch (InvocationTargetException e4) {
            Log.e("IconCompat", "Unable to get icon resource", e4);
            return 0;
        }
    }

    public final String f() {
        int i2 = this.f2843a;
        if (i2 != -1) {
            if (i2 == 2) {
                String str = this.f2852j;
                return (str == null || TextUtils.isEmpty(str)) ? ((String) this.f2844b).split(":", -1)[0] : this.f2852j;
            }
            throw new IllegalStateException("called getResPackage() on " + this);
        }
        int i3 = Build.VERSION.SDK_INT;
        Object obj = this.f2844b;
        if (i3 >= 28) {
            return Api28Impl.b(obj);
        }
        try {
            return (String) obj.getClass().getMethod("getResPackage", null).invoke(obj, null);
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon package", e2);
            return null;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon package", e3);
            return null;
        } catch (InvocationTargetException e4) {
            Log.e("IconCompat", "Unable to get icon package", e4);
            return null;
        }
    }

    public final int g() {
        int i2 = this.f2843a;
        if (i2 != -1) {
            return i2;
        }
        int i3 = Build.VERSION.SDK_INT;
        Object obj = this.f2844b;
        if (i3 >= 28) {
            return Api28Impl.c(obj);
        }
        try {
            return ((Integer) obj.getClass().getMethod("getType", null).invoke(obj, null)).intValue();
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon type " + obj, e2);
            return -1;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon type " + obj, e3);
            return -1;
        } catch (InvocationTargetException e4) {
            Log.e("IconCompat", "Unable to get icon type " + obj, e4);
            return -1;
        }
    }

    public final Uri h() {
        int i2 = this.f2843a;
        if (i2 != -1) {
            if (i2 == 4 || i2 == 6) {
                return Uri.parse((String) this.f2844b);
            }
            throw new IllegalStateException("called getUri() on " + this);
        }
        int i3 = Build.VERSION.SDK_INT;
        Object obj = this.f2844b;
        if (i3 >= 28) {
            return Api28Impl.d(obj);
        }
        try {
            return (Uri) obj.getClass().getMethod("getUri", null).invoke(obj, null);
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon uri", e2);
            return null;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon uri", e3);
            return null;
        } catch (InvocationTargetException e4) {
            Log.e("IconCompat", "Unable to get icon uri", e4);
            return null;
        }
    }

    public final Icon i() {
        return j(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.drawable.Icon j(android.content.Context r8) throws java.io.FileNotFoundException {
        /*
            Method dump skipped, instructions count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.IconCompat.j(android.content.Context):android.graphics.drawable.Icon");
    }

    public final String toString() {
        String str;
        if (this.f2843a == -1) {
            return String.valueOf(this.f2844b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        switch (this.f2843a) {
            case 1:
                str = "BITMAP";
                break;
            case 2:
                str = "RESOURCE";
                break;
            case 3:
                str = "DATA";
                break;
            case 4:
                str = "URI";
                break;
            case 5:
                str = "BITMAP_MASKABLE";
                break;
            case 6:
                str = "URI_MASKABLE";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        sb.append(str);
        switch (this.f2843a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f2844b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f2844b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f2852j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(e())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f2847e);
                if (this.f2848f != 0) {
                    sb.append(" off=");
                    sb.append(this.f2848f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f2844b);
                break;
        }
        if (this.f2849g != null) {
            sb.append(" tint=");
            sb.append(this.f2849g);
        }
        if (this.f2850h != f2842k) {
            sb.append(" mode=");
            sb.append(this.f2850h);
        }
        sb.append(")");
        return sb.toString();
    }

    public IconCompat(int i2) {
        this.f2845c = null;
        this.f2846d = null;
        this.f2847e = 0;
        this.f2848f = 0;
        this.f2849g = null;
        this.f2850h = f2842k;
        this.f2851i = null;
        this.f2843a = i2;
    }
}
