package com.google.android.gms.internal.ads;

import dalvik.system.DexClassLoader;
import java.io.UnsupportedEncodingException;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzbbf implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbbg f24662a;

    public zzbbf(zzbbg zzbbgVar) {
        Objects.requireNonNull(zzbbgVar);
        this.f24662a = zzbbgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbbg zzbbgVar = this.f24662a;
        zzbbgVar.getClass();
        try {
            zzazt zzaztVar = zzbbgVar.f24663a;
            DexClassLoader dexClassLoader = zzaztVar.f24560c;
            byte[] bArr = zzaztVar.f24562e;
            String str = zzbbgVar.f24664b;
            zzaztVar.f24561d.getClass();
            Class<?> clsLoadClass = dexClassLoader.loadClass(new String(zzayy.b(bArr, str), "UTF-8"));
            if (clsLoadClass != null) {
                byte[] bArr2 = zzaztVar.f24562e;
                String str2 = zzbbgVar.f24665c;
                zzbbgVar.f24663a.f24561d.getClass();
                zzbbgVar.f24666d = clsLoadClass.getMethod(new String(zzayy.b(bArr2, str2), "UTF-8"), zzbbgVar.f24667e);
            }
        } catch (zzayx | UnsupportedEncodingException | ClassNotFoundException | NoSuchMethodException | NullPointerException unused) {
        } catch (Throwable th) {
            zzbbgVar.f24668f.countDown();
            throw th;
        }
        zzbbgVar.f24668f.countDown();
    }
}
