package com.rnmaps.maps;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.facebook.react.uimanager.ThemedReactContext;
import com.google.android.gms.maps.model.TileProvider;
import com.google.android.gms.maps.model.UrlTileProvider;
import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes4.dex */
public class MapTileProvider implements TileProvider {

    /* renamed from: b, reason: collision with root package name */
    public UrlTileProvider f46589b;

    /* renamed from: c, reason: collision with root package name */
    public String f46590c;

    /* renamed from: d, reason: collision with root package name */
    public int f46591d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f46592e;

    /* renamed from: f, reason: collision with root package name */
    public int f46593f;

    /* renamed from: g, reason: collision with root package name */
    public int f46594g;

    /* renamed from: h, reason: collision with root package name */
    public int f46595h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f46596i;

    /* renamed from: j, reason: collision with root package name */
    public String f46597j;

    /* renamed from: k, reason: collision with root package name */
    public int f46598k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f46599l;

    /* renamed from: m, reason: collision with root package name */
    public final ThemedReactContext f46600m;
    public final boolean n;

    public class AIRMapUrlTileProvider extends UrlTileProvider {

        /* renamed from: d, reason: collision with root package name */
        public final String f46601d;

        public AIRMapUrlTileProvider(int i2, int i3, String str) {
            super(i2, i3);
            this.f46601d = str;
        }

        @Override // com.google.android.gms.maps.model.UrlTileProvider
        public final URL b(int i2, int i3, int i4) {
            MapTileProvider mapTileProvider = MapTileProvider.this;
            if (mapTileProvider.f46596i) {
                i3 = ((1 << i4) - i3) - 1;
            }
            String strReplace = this.f46601d.replace("{x}", Integer.toString(i2)).replace("{y}", Integer.toString(i3)).replace("{z}", Integer.toString(i4));
            int i5 = mapTileProvider.f46593f;
            if (i5 > 0 && i4 > i5) {
                return null;
            }
            int i6 = mapTileProvider.f46595h;
            if (i6 > 0 && i4 < i6) {
                return null;
            }
            try {
                return new URL(strReplace);
            } catch (MalformedURLException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public MapTileProvider(int i2, boolean z, String str, int i3, int i4, int i5, boolean z2, String str2, int i6, boolean z3, ThemedReactContext themedReactContext, boolean z4) {
        this.f46589b = new AIRMapUrlTileProvider(i2, i2, str);
        this.f46591d = i2;
        this.f46592e = z;
        this.f46590c = str;
        this.f46593f = i3;
        this.f46594g = i4;
        this.f46595h = i5;
        this.f46596i = z2;
        this.f46597j = str2;
        this.f46598k = i6;
        this.f46599l = z3;
        this.f46600m = themedReactContext;
        this.n = z4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0108 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0109  */
    @Override // com.google.android.gms.maps.model.TileProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.maps.model.Tile a(int r18, int r19, int r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rnmaps.maps.MapTileProvider.a(int, int, int):com.google.android.gms.maps.model.Tile");
    }

    public final String b(int i2, int i3, int i4) {
        if (this.f46597j == null) {
            return null;
        }
        return this.f46597j + '/' + i4 + "/" + i2 + "/" + i3;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:38|(2:90|39)|(9:105|40|41|102|42|(2:43|(1:45)(1:107))|52|97|53)|91|54|(1:74)|75|108) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0275 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x023a A[EXC_TOP_SPLITTER, PHI: r8 r18
      0x023a: PHI (r8v9 java.io.ByteArrayOutputStream) = (r8v8 java.io.ByteArrayOutputStream), (r8v12 java.io.ByteArrayOutputStream), (r8v12 java.io.ByteArrayOutputStream) binds: [B:71:0x025b, B:83:0x023a, B:53:0x0237] A[DONT_GENERATE, DONT_INLINE]
      0x023a: PHI (r18v5 byte[]) = (r18v10 byte[]), (r18v8 byte[]), (r18v8 byte[]) binds: [B:71:0x025b, B:83:0x023a, B:53:0x0237] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x027a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0258 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.net.URL] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.io.ByteArrayOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final byte[] c(int r26, int r27, int r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 639
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rnmaps.maps.MapTileProvider.c(int, int, int):byte[]");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final byte[] d(int r7, int r8, int r9) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.String r7 = r6.b(r7, r8, r9)
            r8 = 0
            if (r7 != 0) goto L8
            return r8
        L8:
            java.io.File r9 = new java.io.File
            r9.<init>(r7)
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L4f java.lang.OutOfMemoryError -> L54 java.io.IOException -> L58
            r7.<init>(r9)     // Catch: java.lang.Throwable -> L4f java.lang.OutOfMemoryError -> L54 java.io.IOException -> L58
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L46 java.lang.OutOfMemoryError -> L4a java.io.IOException -> L4d
            r0.<init>()     // Catch: java.lang.Throwable -> L46 java.lang.OutOfMemoryError -> L4a java.io.IOException -> L4d
            r1 = 16384(0x4000, float:2.2959E-41)
            byte[] r2 = new byte[r1]     // Catch: java.lang.Throwable -> L27 java.lang.OutOfMemoryError -> L29 java.io.IOException -> L2b
        L1b:
            r3 = 0
            int r4 = r7.read(r2, r3, r1)     // Catch: java.lang.Throwable -> L27 java.lang.OutOfMemoryError -> L29 java.io.IOException -> L2b
            r5 = -1
            if (r4 == r5) goto L2d
            r0.write(r2, r3, r4)     // Catch: java.lang.Throwable -> L27 java.lang.OutOfMemoryError -> L29 java.io.IOException -> L2b
            goto L1b
        L27:
            r8 = move-exception
            goto L68
        L29:
            r9 = move-exception
            goto L5a
        L2b:
            r9 = move-exception
            goto L5a
        L2d:
            r0.flush()     // Catch: java.lang.Throwable -> L27 java.lang.OutOfMemoryError -> L29 java.io.IOException -> L2b
            int r1 = r6.f46598k     // Catch: java.lang.Throwable -> L27 java.lang.OutOfMemoryError -> L29 java.io.IOException -> L2b
            if (r1 != 0) goto L3b
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L27 java.lang.OutOfMemoryError -> L29 java.io.IOException -> L2b
            r9.setLastModified(r1)     // Catch: java.lang.Throwable -> L27 java.lang.OutOfMemoryError -> L29 java.io.IOException -> L2b
        L3b:
            byte[] r8 = r0.toByteArray()     // Catch: java.lang.Throwable -> L27 java.lang.OutOfMemoryError -> L29 java.io.IOException -> L2b
            r7.close()     // Catch: java.lang.Exception -> L42
        L42:
            r0.close()     // Catch: java.lang.Exception -> L45
        L45:
            return r8
        L46:
            r9 = move-exception
            r0 = r8
            r8 = r9
            goto L68
        L4a:
            r9 = move-exception
        L4b:
            r0 = r8
            goto L5a
        L4d:
            r9 = move-exception
            goto L4b
        L4f:
            r7 = move-exception
            r0 = r8
            r8 = r7
            r7 = r0
            goto L68
        L54:
            r9 = move-exception
        L55:
            r7 = r8
            r0 = r7
            goto L5a
        L58:
            r9 = move-exception
            goto L55
        L5a:
            r9.printStackTrace()     // Catch: java.lang.Throwable -> L27
            if (r7 == 0) goto L62
            r7.close()     // Catch: java.lang.Exception -> L62
        L62:
            if (r0 == 0) goto L67
            r0.close()     // Catch: java.lang.Exception -> L67
        L67:
            return r8
        L68:
            if (r7 == 0) goto L6d
            r7.close()     // Catch: java.lang.Exception -> L6d
        L6d:
            if (r0 == 0) goto L72
            r0.close()     // Catch: java.lang.Exception -> L72
        L72:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rnmaps.maps.MapTileProvider.d(int, int, int):byte[]");
    }

    public final byte[] e(int i2, int i3, int i4, int i5) throws Throwable {
        int i6 = i4 - i5;
        int i7 = 1 << i6;
        int i8 = i2 >> i6;
        int i9 = i3 >> i6;
        int i10 = i4 - i6;
        int i11 = i2 % i7;
        int i12 = i3 % i7;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(512, 512, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.eraseColor(0);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        byte[] bArrC = c(i8, i9, i10);
        if (bArrC == null) {
            return null;
        }
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrC, 0, bArrC.length);
        int i13 = this.f46591d / i7;
        int i14 = i11 * i13;
        int i15 = i12 * i13;
        canvas.drawBitmap(bitmapDecodeByteArray, new Rect(i14, i15, i14 + i13, i13 + i15), new Rect(0, 0, 512, 512), paint);
        bitmapDecodeByteArray.recycle();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        bitmapCreateBitmap.recycle();
        return byteArray;
    }

    public final void f(boolean z) {
        this.f46592e = z;
    }

    public final void g(boolean z) {
        this.f46596i = z;
    }

    public final void h(int i2) {
        this.f46594g = i2;
    }

    public final void i(int i2) {
        this.f46593f = i2;
    }

    public final void j(int i2) {
        this.f46595h = i2;
    }

    public final void k(boolean z) {
        this.f46599l = z;
    }

    public final void l(int i2) {
        this.f46598k = i2;
    }

    public final void m(String str) {
        this.f46597j = str;
    }

    public final void n(int i2) {
        if (this.f46591d != i2) {
            this.f46589b = new AIRMapUrlTileProvider(i2, i2, this.f46590c);
        }
        this.f46591d = i2;
    }

    public final void o(String str) {
        if (this.f46590c != str) {
            int i2 = this.f46591d;
            this.f46589b = new AIRMapUrlTileProvider(i2, i2, str);
        }
        this.f46590c = str;
    }
}
