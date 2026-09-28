package com.google.android.gms.internal.ads;

import java.security.KeyFactory;
import java.security.Provider;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPublicKeySpec;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhrl implements zzhjr {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhrl f34112a = new zzhrl();

    @Override // com.google.android.gms.internal.ads.zzhjr
    public final Object a(zzgzx zzgzxVar) {
        zzhri zzhriVar = (zzhri) zzgzxVar;
        byte[] bArr = zzhud.f34294g;
        Provider providerA = zzhhf.a();
        ECPublicKey eCPublicKey = (ECPublicKey) (providerA != null ? KeyFactory.getInstance("EC", providerA) : (KeyFactory) zzhwc.f34419g.f34420a.a("EC")).generatePublic(new ECPublicKeySpec(zzhriVar.f34107b, zzhvw.a((zzhvu) zzhud.f34298k.a(zzhriVar.f34106a.f34096b))));
        zzhre zzhreVar = zzhriVar.f34106a;
        return new zzhud(eCPublicKey, (zzhwl) zzhud.f34296i.a(zzhreVar.f34097c), (zzhvv) zzhud.f34297j.a(zzhreVar.f34095a), zzhriVar.f34108c.b(), zzhreVar.f34098d.equals(zzhrd.f34092d) ? zzhud.f34295h : zzhud.f34294g, providerA);
    }
}
