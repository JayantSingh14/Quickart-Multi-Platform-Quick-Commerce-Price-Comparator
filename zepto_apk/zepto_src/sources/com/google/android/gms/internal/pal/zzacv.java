package com.google.android.gms.internal.pal;

import com.google.android.gms.internal.pal.zzacv;
import com.google.android.gms.internal.pal.zzacz;
import java.io.IOException;

/* loaded from: classes4.dex */
public class zzacv<MessageType extends zzacz<MessageType, BuilderType>, BuilderType extends zzacv<MessageType, BuilderType>> extends zzabh<MessageType, BuilderType> {

    /* renamed from: a, reason: collision with root package name */
    public final zzacz f37404a;

    /* renamed from: b, reason: collision with root package name */
    public zzacz f37405b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f37406c = false;

    public zzacv(zzacz zzaczVar) {
        this.f37404a = zzaczVar;
        this.f37405b = (zzacz) zzaczVar.o(4);
    }

    public static final void c(zzacz zzaczVar, zzacz zzaczVar2) {
        zzaen.f37457c.a(zzaczVar.getClass()).b(zzaczVar, zzaczVar2);
    }

    @Override // com.google.android.gms.internal.pal.zzabh
    /* renamed from: b */
    public final zzacv clone() {
        zzacv zzacvVar = (zzacv) this.f37404a.o(5);
        zzacvVar.d(j());
        return zzacvVar;
    }

    @Override // com.google.android.gms.internal.pal.zzabh
    public final Object clone() {
        zzacv zzacvVar = (zzacv) this.f37404a.o(5);
        zzacvVar.d(j());
        return zzacvVar;
    }

    public final void d(zzacz zzaczVar) {
        if (this.f37406c) {
            k();
            this.f37406c = false;
        }
        c(this.f37405b, zzaczVar);
    }

    public final void f(byte[] bArr, int i2, zzacm zzacmVar) throws zzadi {
        if (this.f37406c) {
            k();
            this.f37406c = false;
        }
        try {
            zzaen.f37457c.a(this.f37405b.getClass()).a(this.f37405b, bArr, 0, i2, new zzabl(zzacmVar));
        } catch (zzadi e2) {
            throw e2;
        } catch (IOException e3) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e3);
        } catch (IndexOutOfBoundsException unused) {
            throw zzadi.e();
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaeg
    public final /* synthetic */ zzaef g() {
        throw null;
    }

    public final zzacz h() {
        zzacz zzaczVarJ = j();
        if (zzaczVarJ.j()) {
            return zzaczVarJ;
        }
        throw new zzafh();
    }

    public final zzacz j() {
        if (this.f37406c) {
            return this.f37405b;
        }
        zzacz zzaczVar = this.f37405b;
        zzaen.f37457c.a(zzaczVar.getClass()).zzf(zzaczVar);
        this.f37406c = true;
        return this.f37405b;
    }

    public final void k() {
        zzacz zzaczVar = (zzacz) this.f37405b.o(4);
        c(zzaczVar, this.f37405b);
        this.f37405b = zzaczVar;
    }
}
