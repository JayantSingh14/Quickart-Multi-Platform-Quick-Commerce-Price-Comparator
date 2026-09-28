package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzafx extends zzafd {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzafr f22970b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzafy f22971c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzafx(zzafy zzafyVar, zzafr zzafrVar, zzafr zzafrVar2) {
        super(zzafrVar);
        this.f22970b = zzafrVar2;
        Objects.requireNonNull(zzafyVar);
        this.f22971c = zzafyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafd, com.google.android.gms.internal.ads.zzafr
    public final zzafp b(long j2) {
        zzafp zzafpVarB = this.f22970b.b(j2);
        zzafs zzafsVar = zzafpVarB.f22955a;
        long j3 = zzafsVar.f22960a;
        long j4 = this.f22971c.f22972a;
        zzafs zzafsVar2 = new zzafs(j3, zzafsVar.f22961b + j4);
        zzafs zzafsVar3 = zzafpVarB.f22956b;
        return new zzafp(zzafsVar2, new zzafs(zzafsVar3.f22960a, zzafsVar3.f22961b + j4));
    }
}
