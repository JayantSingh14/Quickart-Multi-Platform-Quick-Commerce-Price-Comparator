package com.google.android.play.core.splitcompat;

import java.io.IOException;
import java.util.HashSet;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

/* loaded from: classes4.dex */
final class zzi implements zzk {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HashSet f41916a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzt f41917b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzn f41918c;

    public zzi(zzn zznVar, HashSet hashSet, zzt zztVar) {
        this.f41918c = zznVar;
        this.f41916a = hashSet;
        this.f41917b = zztVar;
    }

    @Override // com.google.android.play.core.splitcompat.zzk
    public final void a(ZipFile zipFile, HashSet hashSet) throws IOException {
        Pattern pattern = zzn.f41924b;
        HashSet hashSet2 = new HashSet();
        zzt zztVar = this.f41917b;
        this.f41918c.c(zztVar, hashSet, new zzj(hashSet2, zztVar, zipFile));
        this.f41916a.addAll(hashSet2);
    }
}
