package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzayh implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzayi f24474a;

    public zzayh(zzayi zzayiVar) {
        Objects.requireNonNull(zzayiVar);
        this.f24474a = zzayiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzayi zzayiVar = this.f24474a;
        synchronized (zzayiVar.o) {
            if (zzayiVar.p) {
                return;
            }
            zzayiVar.p = true;
            try {
                zzayiVar.m();
            } catch (Exception e2) {
                this.f24474a.f24480f.c(2023, -1L, e2);
            }
            zzayi zzayiVar2 = this.f24474a;
            synchronized (zzayiVar2.o) {
                zzayiVar2.p = false;
            }
        }
    }
}
