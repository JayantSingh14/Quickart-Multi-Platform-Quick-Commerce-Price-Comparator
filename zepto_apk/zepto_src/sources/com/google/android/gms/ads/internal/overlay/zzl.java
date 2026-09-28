package com.google.android.gms.ads.internal.overlay;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzl extends com.google.android.gms.ads.internal.util.zzb {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzm f21359b;

    public /* synthetic */ zzl(zzm zzmVar) {
        Objects.requireNonNull(zzmVar);
        this.f21359b = zzmVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0077  */
    @Override // com.google.android.gms.ads.internal.util.zzb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r7 = this;
            com.google.android.gms.ads.internal.zzt r0 = com.google.android.gms.ads.internal.zzt.C
            com.google.android.gms.ads.internal.util.zzbr r0 = r0.w
            com.google.android.gms.ads.internal.overlay.zzm r1 = r7.f21359b
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r2 = r1.f21361c
            com.google.android.gms.ads.internal.zzl r2 = r2.o
            int r2 = r2.f21658f
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.util.concurrent.ConcurrentHashMap r0 = r0.f21540a
            java.lang.Object r0 = r0.get(r2)
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            if (r0 == 0) goto L8a
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r2 = r1.f21361c
            com.google.android.gms.ads.internal.zzl r2 = r2.o
            boolean r3 = r2.f21656d
            android.app.Activity r1 = r1.f21360b
            if (r3 == 0) goto L77
            float r2 = r2.f21657e
            r3 = 0
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 <= 0) goto L77
            r3 = 1103626240(0x41c80000, float:25.0)
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 <= 0) goto L32
            goto L77
        L32:
            int r3 = r0.getWidth()     // Catch: java.lang.RuntimeException -> L6d
            int r4 = r0.getHeight()     // Catch: java.lang.RuntimeException -> L6d
            r5 = 0
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createScaledBitmap(r0, r3, r4, r5)     // Catch: java.lang.RuntimeException -> L6d
            android.graphics.Bitmap r4 = android.graphics.Bitmap.createBitmap(r3)     // Catch: java.lang.RuntimeException -> L6d
            android.renderscript.RenderScript r5 = android.renderscript.RenderScript.create(r1)     // Catch: java.lang.RuntimeException -> L6d
            android.renderscript.Element r6 = android.renderscript.Element.U8_4(r5)     // Catch: java.lang.RuntimeException -> L6d
            android.renderscript.ScriptIntrinsicBlur r6 = android.renderscript.ScriptIntrinsicBlur.create(r5, r6)     // Catch: java.lang.RuntimeException -> L6d
            android.renderscript.Allocation r3 = android.renderscript.Allocation.createFromBitmap(r5, r3)     // Catch: java.lang.RuntimeException -> L6d
            android.renderscript.Allocation r5 = android.renderscript.Allocation.createFromBitmap(r5, r4)     // Catch: java.lang.RuntimeException -> L6d
            r6.setRadius(r2)     // Catch: java.lang.RuntimeException -> L6d
            r6.setInput(r3)     // Catch: java.lang.RuntimeException -> L6d
            r6.forEach(r5)     // Catch: java.lang.RuntimeException -> L6d
            r5.copyTo(r4)     // Catch: java.lang.RuntimeException -> L6d
            android.graphics.drawable.BitmapDrawable r2 = new android.graphics.drawable.BitmapDrawable     // Catch: java.lang.RuntimeException -> L6d
            android.content.res.Resources r3 = r1.getResources()     // Catch: java.lang.RuntimeException -> L6d
            r2.<init>(r3, r4)     // Catch: java.lang.RuntimeException -> L6d
            goto L80
        L6d:
            android.graphics.drawable.BitmapDrawable r2 = new android.graphics.drawable.BitmapDrawable
            android.content.res.Resources r1 = r1.getResources()
            r2.<init>(r1, r0)
            goto L80
        L77:
            android.graphics.drawable.BitmapDrawable r2 = new android.graphics.drawable.BitmapDrawable
            android.content.res.Resources r1 = r1.getResources()
            r2.<init>(r1, r0)
        L80:
            com.google.android.gms.ads.internal.util.zzf r0 = com.google.android.gms.ads.internal.util.zzs.f21608l
            com.google.android.gms.ads.internal.overlay.zzk r1 = new com.google.android.gms.ads.internal.overlay.zzk
            r1.<init>()
            r0.post(r1)
        L8a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzl.a():void");
    }
}
