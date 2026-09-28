package com.google.android.gms.internal.ads;

import android.util.Base64;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsResponse;
import androidx.privacysandbox.ads.adservices.topics.Topic;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
final /* synthetic */ class zzfaq implements zzgxu {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzfaq f30762a = new zzfaq();

    /* JADX WARN: Type inference failed for: r8v2, types: [java.util.AbstractCollection, java.util.List] */
    @Override // com.google.android.gms.internal.ads.zzgxu
    public final ListenableFuture zza(Object obj) {
        GetTopicsResponse getTopicsResponse = (GetTopicsResponse) obj;
        if (getTopicsResponse == null) {
            return zzgym.a(new zzfas("", 1));
        }
        zziek zziekVarC = zziel.C();
        for (Topic topic : getTopicsResponse.f11277a) {
            zziei zzieiVarC = zziej.C();
            int i2 = topic.f11281c;
            zzieiVarC.j();
            ((zziej) zzieiVarC.f34638b).D(i2);
            zzieiVarC.j();
            ((zziej) zzieiVarC.f34638b).E(topic.f11280b);
            zzieiVarC.j();
            ((zziej) zzieiVarC.f34638b).F(topic.f11279a);
            zziej zziejVar = (zziej) zzieiVarC.l();
            zziekVarC.j();
            ((zziel) zziekVarC.f34638b).D(zziejVar);
        }
        return zzgym.a(new zzfas(Base64.encodeToString(((zziel) zziekVarC.l()).g(), 1), 1));
    }
}
