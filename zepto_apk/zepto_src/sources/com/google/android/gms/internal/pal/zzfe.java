package com.google.android.gms.internal.pal;

import dalvik.system.DexClassLoader;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes4.dex */
final class zzfe implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzff f37716a;

    public zzfe(zzff zzffVar) {
        this.f37716a = zzffVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CountDownLatch countDownLatch;
        CountDownLatch countDownLatch2;
        zzff zzffVar = this.f37716a;
        try {
            try {
                zzdu zzduVar = zzffVar.f37717a;
                DexClassLoader dexClassLoader = zzduVar.f37636c;
                byte[] bArr = zzduVar.f37638e;
                String str = zzffVar.f37718b;
                zzduVar.f37637d.getClass();
                Class<?> clsLoadClass = dexClassLoader.loadClass(new String(zzdb.b(bArr, str), "UTF-8"));
                if (clsLoadClass == null) {
                    countDownLatch2 = zzffVar.f37722f;
                } else {
                    zzdu zzduVar2 = zzffVar.f37717a;
                    byte[] bArr2 = zzduVar2.f37638e;
                    String str2 = zzffVar.f37719c;
                    zzduVar2.f37637d.getClass();
                    zzffVar.f37720d = clsLoadClass.getMethod(new String(zzdb.b(bArr2, str2), "UTF-8"), zzffVar.f37721e);
                    countDownLatch2 = zzffVar.f37720d == null ? zzffVar.f37722f : zzffVar.f37722f;
                }
                countDownLatch2.countDown();
            } catch (zzda | UnsupportedEncodingException | ClassNotFoundException | NoSuchMethodException unused) {
                countDownLatch = zzffVar.f37722f;
                countDownLatch.countDown();
            }
        } catch (NullPointerException unused2) {
            countDownLatch = zzffVar.f37722f;
            countDownLatch.countDown();
        } catch (Throwable th) {
            zzffVar.f37722f.countDown();
            throw th;
        }
    }
}
