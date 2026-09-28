package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzma;
import com.google.android.gms.internal.measurement.zzme;
import java.io.IOException;

/* loaded from: classes.dex */
public class zzma<MessageType extends zzme<MessageType, BuilderType>, BuilderType extends zzma<MessageType, BuilderType>> extends zzkq<MessageType, BuilderType> {

    /* renamed from: a, reason: collision with root package name */
    public final zzme f37106a;

    /* renamed from: b, reason: collision with root package name */
    public zzme f37107b;

    public zzma(zzme zzmeVar) {
        this.f37106a = zzmeVar;
        if (zzmeVar.i()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.f37107b = (zzme) zzmeVar.r(4);
    }

    public final /* bridge */ /* synthetic */ zzkq h(int i2, byte[] bArr) throws zzmq {
        zzlq zzlqVar = zzlq.f37088b;
        zznt zzntVar = zznt.f37161c;
        n(bArr, i2, zzlq.f37089c);
        return this;
    }

    public final void i() {
        if (this.f37107b.i()) {
            return;
        }
        zzme zzmeVar = (zzme) this.f37106a.r(4);
        zznt.f37161c.a(zzmeVar.getClass()).a(zzmeVar, this.f37107b);
        this.f37107b = zzmeVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzkq
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public final zzma clone() {
        zzma zzmaVar = (zzma) this.f37106a.r(5);
        zzmaVar.f37107b = y0();
        return zzmaVar;
    }

    @Override // com.google.android.gms.internal.measurement.zznk
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public final zzme y0() {
        if (!this.f37107b.i()) {
            return this.f37107b;
        }
        this.f37107b.k();
        return this.f37107b;
    }

    public final zzme l() {
        zzme zzmeVarY0 = y0();
        zzmeVarY0.getClass();
        boolean zB = true;
        byte bByteValue = ((Byte) zzmeVarY0.r(1)).byteValue();
        if (bByteValue != 1) {
            if (bByteValue == 0) {
                zB = false;
            } else {
                zB = zznt.f37161c.a(zzmeVarY0.getClass()).b(zzmeVarY0);
                zzmeVarY0.r(2);
            }
        }
        if (zB) {
            return zzmeVarY0;
        }
        throw new zzog();
    }

    public final void m(zzme zzmeVar) {
        zzme zzmeVar2 = this.f37106a;
        if (zzmeVar2.equals(zzmeVar)) {
            return;
        }
        if (!this.f37107b.i()) {
            zzme zzmeVar3 = (zzme) zzmeVar2.r(4);
            zznt.f37161c.a(zzmeVar3.getClass()).a(zzmeVar3, this.f37107b);
            this.f37107b = zzmeVar3;
        }
        zzme zzmeVar4 = this.f37107b;
        zznt.f37161c.a(zzmeVar4.getClass()).a(zzmeVar4, zzmeVar);
    }

    public final void n(byte[] bArr, int i2, zzlq zzlqVar) throws zzmq {
        if (!this.f37107b.i()) {
            zzme zzmeVar = (zzme) this.f37106a.r(4);
            zznt.f37161c.a(zzmeVar.getClass()).a(zzmeVar, this.f37107b);
            this.f37107b = zzmeVar;
        }
        try {
            zznt.f37161c.a(this.f37107b.getClass()).g(this.f37107b, bArr, 0, i2, new zzkv(zzlqVar));
        } catch (zzmq e2) {
            throw e2;
        } catch (IOException e3) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e3);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }
}
