package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzial;
import com.google.android.gms.internal.ads.zziar;
import java.io.IOException;

/* loaded from: classes4.dex */
public class zzial<MessageType extends zziar<MessageType, BuilderType>, BuilderType extends zzial<MessageType, BuilderType>> extends zzhyt<MessageType, BuilderType> {

    /* renamed from: a, reason: collision with root package name */
    public final zziar f34637a;

    /* renamed from: b, reason: collision with root package name */
    public zziar f34638b;

    public zzial(zziar zziarVar) {
        this.f34637a = zziarVar;
        if (zziarVar.m()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.f34638b = zziarVar.t();
    }

    @Override // com.google.android.gms.internal.ads.zzhyt
    public final Object clone() {
        zzial zzialVar = (zzial) this.f34637a.y(zziaq.f34644e, null);
        zzialVar.f34638b = n0();
        return zzialVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhyt
    /* renamed from: g */
    public final zzial clone() {
        zzial zzialVar = (zzial) this.f34637a.y(zziaq.f34644e, null);
        zzialVar.f34638b = n0();
        return zzialVar;
    }

    public final zzial i(byte[] bArr, int i2, zziab zziabVar) throws zzibg {
        j();
        try {
            zzicm.f34722c.a(this.f34638b.getClass()).c(this.f34638b, bArr, 0, i2, new zzhyz(zziabVar));
            return this;
        } catch (zzibg e2) {
            throw e2;
        } catch (IOException e3) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e3);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    public final void j() {
        if (this.f34638b.m()) {
            return;
        }
        zziar zziarVarT = this.f34637a.t();
        zzicm.f34722c.a(zziarVarT.getClass()).a(zziarVarT, this.f34638b);
        this.f34638b = zziarVarT;
    }

    @Override // com.google.android.gms.internal.ads.zzicb
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public final zziar n0() {
        if (!this.f34638b.m()) {
            return this.f34638b;
        }
        zziar zziarVar = this.f34638b;
        zziarVar.getClass();
        zzicm.f34722c.a(zziarVar.getClass()).b(zziarVar);
        zziarVar.n();
        return this.f34638b;
    }

    public final zziar l() {
        zziar zziarVarN0 = n0();
        zziarVarN0.getClass();
        if (zziar.z(zziarVarN0, true)) {
            return zziarVarN0;
        }
        throw new zzide();
    }

    public final zzial m(zziar zziarVar) {
        if (this.f34637a.equals(zziarVar)) {
            return this;
        }
        j();
        zziar zziarVar2 = this.f34638b;
        zzicm.f34722c.a(zziarVar2.getClass()).a(zziarVar2, zziarVar);
        return this;
    }
}
