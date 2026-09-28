package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzftk implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzftp f31839a;

    public zzftk(zzftp zzftpVar) {
        Objects.requireNonNull(zzftpVar);
        this.f31839a = zzftpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzftj zzftjVar = this.f31839a.f31849e;
        zzftjVar.getClass();
        zzftt zzfttVar = new zzftt(zzftjVar);
        zzfts zzftsVar = zzftjVar.f31838b;
        zzfttVar.f31854a = zzftsVar;
        ArrayDeque arrayDeque = zzftsVar.f31857b;
        arrayDeque.add(zzfttVar);
        if (zzftsVar.f31858c == null) {
            zzftr zzftrVar = (zzftr) arrayDeque.poll();
            zzftsVar.f31858c = zzftrVar;
            if (zzftrVar != null) {
                zzftrVar.executeOnExecutor(zzftsVar.f31856a, new Object[0]);
            }
        }
    }
}
