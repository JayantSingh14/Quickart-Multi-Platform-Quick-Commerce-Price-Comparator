package com.google.android.gms.internal.ads;

import java.lang.reflect.Method;

/* loaded from: classes4.dex */
final class zzgfm extends zzgfz {

    /* renamed from: f, reason: collision with root package name */
    public final zzgad f32466f;

    public zzgfm(zzavs zzavsVar, zzgev zzgevVar, zzgad zzgadVar, zzgnc zzgncVar) {
        super("wtGqMd/1WM/X8Iw+J3Ea8gTPTQ9qzD2C6TcptISwpBzFOHGXqr9Zam0BzMtLgKpz", "WnUwwSu4en0kDO+iGEQNK9IW8rLFfprwibt/HeKMJc4=", zzavsVar, zzgevVar, zzgncVar.a(116));
        this.f32466f = zzgadVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgfz
    public final void a(Method method, zzavs zzavsVar) {
        Object[] objArr = (Object[]) method.invoke("", this.f32466f.I());
        objArr.getClass();
        synchronized (zzavsVar) {
            String str = (String) objArr[0];
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).I0(str);
            String str2 = (String) objArr[1];
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).o0(str2);
        }
    }
}
