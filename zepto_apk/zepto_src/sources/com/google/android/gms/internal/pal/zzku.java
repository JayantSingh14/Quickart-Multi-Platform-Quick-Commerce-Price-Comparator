package com.google.android.gms.internal.pal;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public final class zzku {

    /* renamed from: a, reason: collision with root package name */
    public final Class f37895a;

    /* renamed from: c, reason: collision with root package name */
    public zzkv f37897c;

    /* renamed from: b, reason: collision with root package name */
    public ConcurrentHashMap f37896b = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    public zzrb f37898d = zzrb.f38039b;

    public /* synthetic */ zzku(Class cls) {
        this.f37895a = cls;
    }

    public final void a(Object obj, zzwa zzwaVar, boolean z) throws GeneralSecurityException {
        zzka zzpcVar;
        byte[] bArrArray;
        if (this.f37896b == null) {
            throw new IllegalStateException("addPrimitive cannot be called after build");
        }
        if (zzwaVar.v() != 3) {
            throw new GeneralSecurityException("only ENABLED key is allowed");
        }
        ConcurrentHashMap concurrentHashMap = this.f37896b;
        Integer numValueOf = zzwaVar.w() == 5 ? null : Integer.valueOf(zzwaVar.p());
        zzpj zzpjVar = zzpj.f37999b;
        String strT = zzwaVar.q().t();
        zzaby zzabyVarS = zzwaVar.q().s();
        zzvn zzvnVarQ = zzwaVar.q().q();
        int iW = zzwaVar.w();
        if (iW == 5) {
            if (numValueOf != null) {
                throw new GeneralSecurityException("Keys with output prefix type raw should not have an id requirement.");
            }
        } else if (numValueOf == null) {
            throw new GeneralSecurityException("Keys with output prefix type different from raw should have an id requirement.");
        }
        zzps zzpsVar = new zzps(strT, zzabyVarS, zzvnVarQ, iW, numValueOf);
        zzpjVar.getClass();
        try {
            try {
                zzpcVar = ((zzqb) zzpjVar.f38000a.get()).a(zzpsVar);
            } catch (GeneralSecurityException unused) {
                zzpcVar = new zzpc();
                int i2 = zzpb.f37994a[zzpsVar.f38006d.ordinal()];
            }
            zzks zzkzVar = zzpcVar instanceof zzpc ? new zzkz(zzwaVar.q().t(), zzwaVar.w()) : zzpcVar.a();
            int iW2 = zzwaVar.w() - 2;
            if (iW2 == 1) {
                bArrArray = ByteBuffer.allocate(5).put((byte) 1).putInt(zzwaVar.p()).array();
            } else if (iW2 == 2) {
                bArrArray = ByteBuffer.allocate(5).put((byte) 0).putInt(zzwaVar.p()).array();
            } else if (iW2 != 3) {
                if (iW2 != 4) {
                    throw new GeneralSecurityException("unknown output prefix type");
                }
                bArrArray = ByteBuffer.allocate(5).put((byte) 0).putInt(zzwaVar.p()).array();
            } else {
                bArrArray = zzjv.f37875a;
            }
            zzkv zzkvVar = new zzkv(obj, bArrArray, zzwaVar.v(), zzwaVar.w(), zzwaVar.p(), zzkzVar);
            ArrayList arrayList = new ArrayList();
            arrayList.add(zzkvVar);
            byte[] bArr = zzkvVar.f37900b;
            zzkx zzkxVar = new zzkx(bArr != null ? Arrays.copyOf(bArr, bArr.length) : null);
            List list = (List) concurrentHashMap.put(zzkxVar, Collections.unmodifiableList(arrayList));
            if (list != null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(list);
                arrayList2.add(zzkvVar);
                concurrentHashMap.put(zzkxVar, Collections.unmodifiableList(arrayList2));
            }
            if (z) {
                if (this.f37897c != null) {
                    throw new IllegalStateException("you cannot set two primary primitives");
                }
                this.f37897c = zzkvVar;
            }
        } catch (GeneralSecurityException e2) {
            throw new zzqc("Creating a LegacyProtoKey failed", e2);
        }
    }
}
