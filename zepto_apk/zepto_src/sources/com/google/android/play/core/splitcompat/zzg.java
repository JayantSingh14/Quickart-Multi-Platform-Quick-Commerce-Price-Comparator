package com.google.android.play.core.splitcompat;

import java.io.File;

/* loaded from: classes4.dex */
final class zzg implements zzl {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzh f41911a;

    public zzg(zzh zzhVar) {
        this.f41911a = zzhVar;
    }

    @Override // com.google.android.play.core.splitcompat.zzl
    public final void a(zzm zzmVar, File file, boolean z) {
        zzh zzhVar = this.f41911a;
        zzhVar.f41913b.add(file);
        if (z) {
            return;
        }
        zzhVar.f41914c.set(false);
    }
}
