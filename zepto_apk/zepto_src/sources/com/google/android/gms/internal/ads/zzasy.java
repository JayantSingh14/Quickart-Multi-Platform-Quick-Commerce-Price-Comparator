package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.Date;

/* loaded from: classes4.dex */
public final class zzasy extends zziip {

    /* renamed from: j, reason: collision with root package name */
    public Date f24286j;

    /* renamed from: k, reason: collision with root package name */
    public Date f24287k;

    /* renamed from: l, reason: collision with root package name */
    public long f24288l;

    /* renamed from: m, reason: collision with root package name */
    public long f24289m;
    public double n;
    public float o;
    public zziiz p;
    public long q;

    public zzasy() {
        super("mvhd");
        this.n = 1.0d;
        this.o = 1.0f;
        this.p = zziiz.f34866j;
    }

    @Override // com.google.android.gms.internal.ads.zziin
    public final void c(ByteBuffer byteBuffer) {
        int i2 = byteBuffer.get();
        if (i2 < 0) {
            i2 += 256;
        }
        this.f34851i = i2;
        byteBuffer.get();
        byteBuffer.get();
        byteBuffer.get();
        if (!this.f34845b) {
            d();
        }
        if (this.f34851i == 1) {
            this.f24286j = zziiu.a(zzasu.b(byteBuffer));
            this.f24287k = zziiu.a(zzasu.b(byteBuffer));
            this.f24288l = zzasu.a(byteBuffer);
            this.f24289m = zzasu.b(byteBuffer);
        } else {
            this.f24286j = zziiu.a(zzasu.a(byteBuffer));
            this.f24287k = zziiu.a(zzasu.a(byteBuffer));
            this.f24288l = zzasu.a(byteBuffer);
            this.f24289m = zzasu.a(byteBuffer);
        }
        this.n = zzasu.c(byteBuffer);
        byteBuffer.get(new byte[2]);
        this.o = ((short) ((r1[1] & 255) | ((short) (65280 & (r1[0] << 8))))) / 256.0f;
        byteBuffer.get();
        byteBuffer.get();
        zzasu.a(byteBuffer);
        zzasu.a(byteBuffer);
        this.p = new zziiz(zzasu.c(byteBuffer), zzasu.c(byteBuffer), zzasu.c(byteBuffer), zzasu.c(byteBuffer), zzasu.d(byteBuffer), zzasu.d(byteBuffer), zzasu.d(byteBuffer), zzasu.c(byteBuffer), zzasu.c(byteBuffer));
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        this.q = zzasu.a(byteBuffer);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MovieHeaderBox[creationTime=");
        sb.append(this.f24286j);
        sb.append(";modificationTime=");
        sb.append(this.f24287k);
        sb.append(";timescale=");
        sb.append(this.f24288l);
        sb.append(";duration=");
        sb.append(this.f24289m);
        sb.append(";rate=");
        sb.append(this.n);
        sb.append(";volume=");
        sb.append(this.o);
        sb.append(";matrix=");
        sb.append(this.p);
        sb.append(";nextTrackId=");
        return android.support.v4.media.b.p(sb, this.q, "]");
    }
}
