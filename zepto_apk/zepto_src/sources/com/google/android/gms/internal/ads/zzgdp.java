package com.google.android.gms.internal.ads;

import android.view.MotionEvent;

/* loaded from: classes4.dex */
public final class zzgdp {

    /* renamed from: a, reason: collision with root package name */
    public long f32330a;

    /* renamed from: b, reason: collision with root package name */
    public long f32331b;

    /* renamed from: c, reason: collision with root package name */
    public long f32332c;

    /* renamed from: d, reason: collision with root package name */
    public long f32333d;

    /* renamed from: e, reason: collision with root package name */
    public double f32334e;

    /* renamed from: f, reason: collision with root package name */
    public double f32335f;

    /* renamed from: g, reason: collision with root package name */
    public double f32336g;

    /* renamed from: h, reason: collision with root package name */
    public float f32337h;

    /* renamed from: i, reason: collision with root package name */
    public float f32338i;

    /* renamed from: j, reason: collision with root package name */
    public float f32339j;

    /* renamed from: k, reason: collision with root package name */
    public float f32340k;

    public final void a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f32330a++;
            this.f32336g = 0.0d;
            this.f32334e = motionEvent.getRawX();
            this.f32335f = motionEvent.getRawY();
            this.f32337h = motionEvent.getX();
            this.f32338i = motionEvent.getY();
            this.f32339j = motionEvent.getRawX();
            this.f32340k = motionEvent.getRawY();
            return;
        }
        if (action == 1) {
            this.f32332c++;
            this.f32336g = Math.hypot(motionEvent.getRawX() - this.f32334e, motionEvent.getRawY() - this.f32335f) + this.f32336g;
            this.f32334e = motionEvent.getRawX();
            this.f32335f = motionEvent.getRawY();
            return;
        }
        if (action != 2) {
            if (action != 3) {
                return;
            }
            this.f32333d++;
            return;
        }
        this.f32331b += motionEvent.getHistorySize() + 1;
        this.f32336g = Math.hypot(motionEvent.getRawX() - this.f32334e, motionEvent.getRawY() - this.f32335f) + this.f32336g;
        this.f32334e = motionEvent.getRawX();
        this.f32335f = motionEvent.getRawY();
    }
}
