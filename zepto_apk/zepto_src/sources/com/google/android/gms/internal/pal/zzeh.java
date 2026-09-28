package com.google.android.gms.internal.pal;

import android.content.Context;
import android.util.Base64;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class zzeh extends zzfg {

    /* renamed from: i, reason: collision with root package name */
    public static final zzfh f37689i = new zzfh();

    /* renamed from: h, reason: collision with root package name */
    public final Context f37690h;

    public zzeh(zzdu zzduVar, zzr zzrVar, int i2, Context context) {
        super(zzduVar, "joxZSCFIfSio2J1Z0g3HMtlcDGNvogfMyrj1e2b+qPNv6DXnDVXfwkgCXW9zFWFC", "iJiFXDBrMwFOGpG8WmWNKc3sGwXbWv8N6fPQac0mMm0=", zzrVar, i2, 29);
        this.f37690h = context;
    }

    @Override // com.google.android.gms.internal.pal.zzfg
    public final void a() {
        zzr zzrVar = this.f37726d;
        if (zzrVar.f37406c) {
            zzrVar.k();
            zzrVar.f37406c = false;
        }
        zzaf.z0((zzaf) zzrVar.f37405b, "E");
        AtomicReference atomicReferenceA = f37689i.a(this.f37690h.getPackageName());
        if (atomicReferenceA.get() == null) {
            synchronized (atomicReferenceA) {
                try {
                    if (atomicReferenceA.get() == null) {
                        atomicReferenceA.set((String) this.f37727e.invoke(null, this.f37690h));
                    }
                } finally {
                }
            }
        }
        String str = (String) atomicReferenceA.get();
        synchronized (this.f37726d) {
            zzr zzrVar2 = this.f37726d;
            String strEncodeToString = Base64.encodeToString(str.getBytes(), 11);
            if (zzrVar2.f37406c) {
                zzrVar2.k();
                zzrVar2.f37406c = false;
            }
            zzaf.z0((zzaf) zzrVar2.f37405b, strEncodeToString);
        }
    }
}
