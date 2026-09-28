package com.google.android.play.core.splitcompat;

import java.io.IOException;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

/* loaded from: classes4.dex */
final class zzh implements zzk {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzt f41912a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HashSet f41913b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f41914c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzn f41915d;

    public zzh(zzn zznVar, zzt zztVar, HashSet hashSet, AtomicBoolean atomicBoolean) {
        this.f41915d = zznVar;
        this.f41912a = zztVar;
        this.f41913b = hashSet;
        this.f41914c = atomicBoolean;
    }

    @Override // com.google.android.play.core.splitcompat.zzk
    public final void a(ZipFile zipFile, HashSet hashSet) throws IOException {
        zzg zzgVar = new zzg(this);
        Pattern pattern = zzn.f41924b;
        this.f41915d.c(this.f41912a, hashSet, zzgVar);
    }
}
