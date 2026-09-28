package com.google.android.gms.internal.ads;

import android.os.IBinder;

/* loaded from: classes4.dex */
final class zzgnm extends zzgon {

    /* renamed from: a, reason: collision with root package name */
    public IBinder f32977a;

    /* renamed from: b, reason: collision with root package name */
    public String f32978b;

    /* renamed from: c, reason: collision with root package name */
    public int f32979c;

    /* renamed from: d, reason: collision with root package name */
    public float f32980d;

    /* renamed from: e, reason: collision with root package name */
    public int f32981e;

    /* renamed from: f, reason: collision with root package name */
    public String f32982f;

    /* renamed from: g, reason: collision with root package name */
    public byte f32983g;

    public final zzgoo a() {
        IBinder iBinder;
        if (this.f32983g == 31 && (iBinder = this.f32977a) != null) {
            return new zzgnn(iBinder, this.f32978b, this.f32979c, this.f32980d, this.f32981e, this.f32982f);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f32977a == null) {
            sb.append(" windowToken");
        }
        if ((this.f32983g & 1) == 0) {
            sb.append(" layoutGravity");
        }
        if ((this.f32983g & 2) == 0) {
            sb.append(" layoutVerticalMargin");
        }
        if ((this.f32983g & 4) == 0) {
            sb.append(" displayMode");
        }
        if ((this.f32983g & 8) == 0) {
            sb.append(" triggerMode");
        }
        if ((this.f32983g & 16) == 0) {
            sb.append(" windowWidthPx");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
