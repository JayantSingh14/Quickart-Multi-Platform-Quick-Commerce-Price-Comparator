package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public abstract class zziin implements zzasv {

    /* renamed from: h, reason: collision with root package name */
    public static final zziiy f34843h = zziiy.b(zziin.class);

    /* renamed from: a, reason: collision with root package name */
    public final String f34844a;

    /* renamed from: d, reason: collision with root package name */
    public ByteBuffer f34847d;

    /* renamed from: e, reason: collision with root package name */
    public long f34848e;

    /* renamed from: g, reason: collision with root package name */
    public zziis f34850g;

    /* renamed from: f, reason: collision with root package name */
    public long f34849f = -1;

    /* renamed from: c, reason: collision with root package name */
    public boolean f34846c = true;

    /* renamed from: b, reason: collision with root package name */
    public boolean f34845b = true;

    public zziin(String str) {
        this.f34844a = str;
    }

    @Override // com.google.android.gms.internal.ads.zzasv
    public final void a(zziis zziisVar, ByteBuffer byteBuffer, long j2, zzasr zzasrVar) {
        zzcgf zzcgfVar = (zzcgf) zziisVar;
        this.f34848e = zzcgfVar.zzc();
        byteBuffer.remaining();
        this.f34849f = j2;
        this.f34850g = zzcgfVar;
        zzcgfVar.h(zzcgfVar.zzc() + j2);
        this.f34846c = false;
        this.f34845b = false;
        d();
    }

    public final synchronized void b() {
        try {
            if (this.f34846c) {
                return;
            }
            try {
                zziiy zziiyVar = f34843h;
                String str = this.f34844a;
                zziiyVar.a(str.length() != 0 ? "mem mapping ".concat(str) : new String("mem mapping "));
                zziis zziisVar = this.f34850g;
                long j2 = this.f34848e;
                long j3 = this.f34849f;
                ByteBuffer byteBuffer = ((zzcgf) zziisVar).f26164a;
                int iPosition = byteBuffer.position();
                byteBuffer.position((int) j2);
                ByteBuffer byteBufferSlice = byteBuffer.slice();
                byteBufferSlice.limit((int) j3);
                byteBuffer.position(iPosition);
                this.f34847d = byteBufferSlice;
                this.f34846c = true;
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public abstract void c(ByteBuffer byteBuffer);

    public final synchronized void d() {
        try {
            b();
            zziiy zziiyVar = f34843h;
            String str = this.f34844a;
            zziiyVar.a(str.length() != 0 ? "parsing details of ".concat(str) : new String("parsing details of "));
            ByteBuffer byteBuffer = this.f34847d;
            if (byteBuffer != null) {
                this.f34845b = true;
                byteBuffer.rewind();
                c(byteBuffer);
                if (byteBuffer.remaining() > 0) {
                    byteBuffer.slice();
                }
                this.f34847d = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
