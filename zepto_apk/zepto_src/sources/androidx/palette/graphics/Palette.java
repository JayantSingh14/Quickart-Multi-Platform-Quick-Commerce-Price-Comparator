package androidx.palette.graphics;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;
import android.util.SparseBooleanArray;
import androidx.collection.ArrayMap;
import androidx.core.graphics.ColorUtils;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class Palette {

    /* renamed from: e, reason: collision with root package name */
    public static final Filter f11031e = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f11032a;

    /* renamed from: d, reason: collision with root package name */
    public final Swatch f11035d;

    /* renamed from: c, reason: collision with root package name */
    public final SparseBooleanArray f11034c = new SparseBooleanArray();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayMap f11033b = new ArrayMap();

    /* renamed from: androidx.palette.graphics.Palette$1, reason: invalid class name */
    public static class AnonymousClass1 implements Filter {
        @Override // androidx.palette.graphics.Palette.Filter
        public final boolean a(int i2, float[] fArr) {
            float f2 = fArr[2];
            if (f2 < 0.95f && f2 > 0.05f) {
                float f3 = fArr[0];
                if (f3 < 10.0f || f3 > 37.0f || fArr[1] > 0.82f) {
                    return true;
                }
            }
            return false;
        }
    }

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final Bitmap f11036a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f11037b;

        /* renamed from: c, reason: collision with root package name */
        public final int f11038c;

        /* renamed from: d, reason: collision with root package name */
        public final int f11039d;

        /* renamed from: e, reason: collision with root package name */
        public final int f11040e;

        /* renamed from: f, reason: collision with root package name */
        public final ArrayList f11041f;

        /* renamed from: androidx.palette.graphics.Palette$Builder$1, reason: invalid class name */
        class AnonymousClass1 extends AsyncTask<Bitmap, Void, Palette> {
            @Override // android.os.AsyncTask
            public final Palette doInBackground(Bitmap[] bitmapArr) {
                try {
                    throw null;
                } catch (Exception e2) {
                    Log.e("Palette", "Exception thrown during async generate", e2);
                    return null;
                }
            }

            @Override // android.os.AsyncTask
            public final void onPostExecute(Palette palette) {
                throw null;
            }
        }

        public Builder(Bitmap bitmap) {
            ArrayList arrayList = new ArrayList();
            this.f11037b = arrayList;
            this.f11038c = 16;
            this.f11039d = 12544;
            this.f11040e = -1;
            ArrayList arrayList2 = new ArrayList();
            this.f11041f = arrayList2;
            if (bitmap.isRecycled()) {
                throw new IllegalArgumentException("Bitmap is not valid");
            }
            arrayList2.add(Palette.f11031e);
            this.f11036a = bitmap;
            arrayList.add(Target.f11051d);
            arrayList.add(Target.f11052e);
            arrayList.add(Target.f11053f);
            arrayList.add(Target.f11054g);
            arrayList.add(Target.f11055h);
            arrayList.add(Target.f11056i);
        }

        /* JADX WARN: Removed duplicated region for block: B:77:0x0175  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final androidx.palette.graphics.Palette a() {
            /*
                Method dump skipped, instructions count: 421
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.palette.graphics.Palette.Builder.a():androidx.palette.graphics.Palette");
        }
    }

    public interface Filter {
        boolean a(int i2, float[] fArr);
    }

    public interface PaletteAsyncListener {
    }

    public static final class Swatch {

        /* renamed from: a, reason: collision with root package name */
        public final int f11042a;

        /* renamed from: b, reason: collision with root package name */
        public final int f11043b;

        /* renamed from: c, reason: collision with root package name */
        public final int f11044c;

        /* renamed from: d, reason: collision with root package name */
        public final int f11045d;

        /* renamed from: e, reason: collision with root package name */
        public final int f11046e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f11047f;

        /* renamed from: g, reason: collision with root package name */
        public int f11048g;

        /* renamed from: h, reason: collision with root package name */
        public int f11049h;

        /* renamed from: i, reason: collision with root package name */
        public float[] f11050i;

        public Swatch(int i2, int i3) {
            this.f11042a = Color.red(i2);
            this.f11043b = Color.green(i2);
            this.f11044c = Color.blue(i2);
            this.f11045d = i2;
            this.f11046e = i3;
        }

        public final void a() {
            if (this.f11047f) {
                return;
            }
            int i2 = this.f11045d;
            int iG = ColorUtils.g(4.5f, -1, i2);
            int iG2 = ColorUtils.g(3.0f, -1, i2);
            if (iG != -1 && iG2 != -1) {
                this.f11049h = ColorUtils.k(-1, iG);
                this.f11048g = ColorUtils.k(-1, iG2);
                this.f11047f = true;
                return;
            }
            int iG3 = ColorUtils.g(4.5f, -16777216, i2);
            int iG4 = ColorUtils.g(3.0f, -16777216, i2);
            if (iG3 == -1 || iG4 == -1) {
                this.f11049h = iG != -1 ? ColorUtils.k(-1, iG) : ColorUtils.k(-16777216, iG3);
                this.f11048g = iG2 != -1 ? ColorUtils.k(-1, iG2) : ColorUtils.k(-16777216, iG4);
                this.f11047f = true;
            } else {
                this.f11049h = ColorUtils.k(-16777216, iG3);
                this.f11048g = ColorUtils.k(-16777216, iG4);
                this.f11047f = true;
            }
        }

        public final float[] b() {
            if (this.f11050i == null) {
                this.f11050i = new float[3];
            }
            ColorUtils.b(this.f11050i, this.f11042a, this.f11043b, this.f11044c);
            return this.f11050i;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && Swatch.class == obj.getClass()) {
                Swatch swatch = (Swatch) obj;
                if (this.f11046e == swatch.f11046e && this.f11045d == swatch.f11045d) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return (this.f11045d * 31) + this.f11046e;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(Swatch.class.getSimpleName());
            sb.append(" [RGB: #");
            sb.append(Integer.toHexString(this.f11045d));
            sb.append("] [HSL: ");
            sb.append(Arrays.toString(b()));
            sb.append("] [Population: ");
            sb.append(this.f11046e);
            sb.append("] [Title Text: #");
            a();
            sb.append(Integer.toHexString(this.f11048g));
            sb.append("] [Body Text: #");
            a();
            sb.append(Integer.toHexString(this.f11049h));
            sb.append(']');
            return sb.toString();
        }
    }

    public Palette(ArrayList arrayList, ArrayList arrayList2) {
        this.f11032a = arrayList;
        int size = arrayList.size();
        int i2 = Integer.MIN_VALUE;
        Swatch swatch = null;
        for (int i3 = 0; i3 < size; i3++) {
            Swatch swatch2 = (Swatch) arrayList.get(i3);
            int i4 = swatch2.f11046e;
            if (i4 > i2) {
                swatch = swatch2;
                i2 = i4;
            }
        }
        this.f11035d = swatch;
    }
}
