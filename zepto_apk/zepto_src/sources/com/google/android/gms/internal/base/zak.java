package com.google.android.gms.internal.base;

import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* loaded from: classes4.dex */
public final class zak extends Drawable implements Drawable.Callback {

    /* renamed from: a, reason: collision with root package name */
    public int f36457a;

    /* renamed from: b, reason: collision with root package name */
    public long f36458b;

    /* renamed from: c, reason: collision with root package name */
    public int f36459c;

    /* renamed from: d, reason: collision with root package name */
    public int f36460d;

    /* renamed from: e, reason: collision with root package name */
    public int f36461e;

    /* renamed from: f, reason: collision with root package name */
    public int f36462f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f36463g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f36464h;

    /* renamed from: i, reason: collision with root package name */
    public final zaj f36465i;

    /* renamed from: j, reason: collision with root package name */
    public final Drawable f36466j;

    /* renamed from: k, reason: collision with root package name */
    public final Drawable f36467k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f36468l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f36469m;
    public boolean n;
    public int o;

    public zak(Drawable drawable, Drawable drawable2) {
        this(null);
        drawable = drawable == null ? zai.f36453a : drawable;
        this.f36466j = drawable;
        drawable.setCallback(this);
        zaj zajVar = this.f36465i;
        zajVar.f36456b = drawable.getChangingConfigurations() | zajVar.f36456b;
        drawable2 = drawable2 == null ? zai.f36453a : drawable2;
        this.f36467k = drawable2;
        drawable2.setCallback(this);
        zaj zajVar2 = this.f36465i;
        zajVar2.f36456b = drawable2.getChangingConfigurations() | zajVar2.f36456b;
    }

    public final boolean a() {
        if (!this.f36468l) {
            boolean z = false;
            if (this.f36466j.getConstantState() != null && this.f36467k.getConstantState() != null) {
                z = true;
            }
            this.f36469m = z;
            this.f36468l = true;
        }
        return this.f36469m;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void draw(android.graphics.Canvas r8) {
        /*
            r7 = this;
            int r0 = r7.f36457a
            r1 = 2
            r2 = 0
            r3 = 1
            if (r0 == r3) goto L3a
            if (r0 == r1) goto Lb
        L9:
            r4 = r3
            goto L43
        Lb:
            long r0 = r7.f36458b
            r4 = 0
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 < 0) goto L9
            long r0 = android.os.SystemClock.uptimeMillis()
            long r4 = r7.f36458b
            long r0 = r0 - r4
            int r4 = r7.f36461e
            float r4 = (float) r4
            float r0 = (float) r0
            float r0 = r0 / r4
            r1 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r4 < 0) goto L27
            r4 = r3
            goto L28
        L27:
            r4 = r2
        L28:
            if (r4 == 0) goto L2c
            r7.f36457a = r2
        L2c:
            float r0 = java.lang.Math.min(r0, r1)
            int r1 = r7.f36459c
            float r1 = (float) r1
            float r1 = r1 * r0
            r0 = 0
            float r1 = r1 + r0
            int r0 = (int) r1
            r7.f36462f = r0
            goto L43
        L3a:
            long r4 = android.os.SystemClock.uptimeMillis()
            r7.f36458b = r4
            r7.f36457a = r1
            r4 = r2
        L43:
            int r0 = r7.f36462f
            boolean r1 = r7.f36463g
            android.graphics.drawable.Drawable r5 = r7.f36466j
            android.graphics.drawable.Drawable r6 = r7.f36467k
            if (r4 == 0) goto L62
            if (r1 == 0) goto L52
            if (r0 != 0) goto L57
            goto L53
        L52:
            r2 = r0
        L53:
            r5.draw(r8)
            r0 = r2
        L57:
            int r1 = r7.f36460d
            if (r0 != r1) goto L61
            r6.setAlpha(r1)
            r6.draw(r8)
        L61:
            return
        L62:
            if (r1 == 0) goto L6b
            int r1 = r7.f36460d
            int r1 = r1 - r0
            r5.setAlpha(r1)
            r2 = r3
        L6b:
            r5.draw(r8)
            if (r2 == 0) goto L75
            int r1 = r7.f36460d
            r5.setAlpha(r1)
        L75:
            if (r0 <= 0) goto L82
            r6.setAlpha(r0)
            r6.draw(r8)
            int r8 = r7.f36460d
            r6.setAlpha(r8)
        L82:
            r7.invalidateSelf()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.base.zak.draw(android.graphics.Canvas):void");
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        zaj zajVar = this.f36465i;
        return changingConfigurations | zajVar.f36455a | zajVar.f36456b;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (!a()) {
            return null;
        }
        int changingConfigurations = getChangingConfigurations();
        zaj zajVar = this.f36465i;
        zajVar.f36455a = changingConfigurations;
        return zajVar;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return Math.max(this.f36466j.getIntrinsicHeight(), this.f36467k.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.max(this.f36466j.getIntrinsicWidth(), this.f36467k.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        if (!this.n) {
            this.o = Drawable.resolveOpacity(this.f36466j.getOpacity(), this.f36467k.getOpacity());
            this.n = true;
        }
        return this.o;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        if (this.f36464h || super.mutate() != this) {
            return this;
        }
        if (!a()) {
            throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
        }
        this.f36466j.mutate();
        this.f36467k.mutate();
        this.f36464h = true;
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.f36466j.setBounds(rect);
        this.f36467k.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        if (this.f36462f == this.f36460d) {
            this.f36462f = i2;
        }
        this.f36460d = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f36466j.setColorFilter(colorFilter);
        this.f36467k.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public zak(zaj zajVar) {
        this.f36457a = 0;
        this.f36460d = 255;
        this.f36462f = 0;
        this.f36463g = true;
        zaj zajVar2 = new zaj();
        if (zajVar != null) {
            zajVar2.f36455a = zajVar.f36455a;
            zajVar2.f36456b = zajVar.f36456b;
        }
        this.f36465i = zajVar2;
    }
}
