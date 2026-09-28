package com.google.android.gms.internal.pal;

import com.google.android.gms.internal.pal.zzabh;
import com.google.android.gms.internal.pal.zzabi;
import java.io.IOException;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public abstract class zzabi<MessageType extends zzabi<MessageType, BuilderType>, BuilderType extends zzabh<MessageType, BuilderType>> implements zzaef {
    protected int zza = 0;

    @Override // com.google.android.gms.internal.pal.zzaef
    public final byte[] F() {
        try {
            zzacz zzaczVar = (zzacz) this;
            int i2 = zzaczVar.i();
            byte[] bArr = new byte[i2];
            Logger logger = zzach.f37380b;
            zzace zzaceVar = new zzace(bArr, i2);
            zzaer zzaerVarA = zzaen.f37457c.a(zzaczVar.getClass());
            zzaci zzaciVar = zzaceVar.f37382a;
            if (zzaciVar == null) {
                zzaciVar = new zzaci(zzaceVar);
            }
            zzaerVarA.c(zzaczVar, zzaciVar);
            if (zzaceVar.f37378e - zzaceVar.f37379f == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e2) {
            throw new RuntimeException(android.support.v4.media.b.D("Serializing ", getClass().getName(), " to a byte array threw an IOException (should never happen)."), e2);
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaef
    public final zzaby a() {
        try {
            zzacz zzaczVar = (zzacz) this;
            int i2 = zzaczVar.i();
            zzaby zzabyVar = zzaby.f37363b;
            byte[] bArr = new byte[i2];
            Logger logger = zzach.f37380b;
            zzace zzaceVar = new zzace(bArr, i2);
            zzaer zzaerVarA = zzaen.f37457c.a(zzaczVar.getClass());
            zzaci zzaciVar = zzaceVar.f37382a;
            if (zzaciVar == null) {
                zzaciVar = new zzaci(zzaceVar);
            }
            zzaerVarA.c(zzaczVar, zzaciVar);
            if (zzaceVar.f37378e - zzaceVar.f37379f == 0) {
                return new zzabv(bArr);
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e2) {
            throw new RuntimeException(android.support.v4.media.b.D("Serializing ", getClass().getName(), " to a ByteString threw an IOException (should never happen)."), e2);
        }
    }

    public int b() {
        throw null;
    }

    public void c(int i2) {
        throw null;
    }
}
