package com.google.android.gms.internal.auth;

import com.google.android.gms.internal.auth.zzet;
import com.google.android.gms.internal.auth.zzev;

/* loaded from: classes4.dex */
public class zzet<MessageType extends zzev<MessageType, BuilderType>, BuilderType extends zzet<MessageType, BuilderType>> extends zzdp<MessageType, BuilderType> {

    /* renamed from: a, reason: collision with root package name */
    public final zzhs f36351a;

    /* renamed from: b, reason: collision with root package name */
    public zzev f36352b;

    public zzet(zzhs zzhsVar) {
        this.f36351a = zzhsVar;
        if (zzhsVar.f()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.f36352b = (zzev) zzhsVar.g(4);
    }

    @Override // com.google.android.gms.internal.auth.zzdp
    /* renamed from: a */
    public final zzet clone() {
        zzev zzevVar;
        zzet zzetVar = (zzet) this.f36351a.g(5);
        if (this.f36352b.f()) {
            zzev zzevVar2 = this.f36352b;
            zzevVar2.getClass();
            zzgf.f36386c.a(zzevVar2.getClass()).a(zzevVar2);
            zzevVar2.c();
            zzevVar = this.f36352b;
        } else {
            zzevVar = this.f36352b;
        }
        zzetVar.f36352b = zzevVar;
        return zzetVar;
    }

    @Override // com.google.android.gms.internal.auth.zzdp
    public final Object clone() {
        zzev zzevVar;
        zzet zzetVar = (zzet) this.f36351a.g(5);
        if (this.f36352b.f()) {
            zzev zzevVar2 = this.f36352b;
            zzevVar2.getClass();
            zzgf.f36386c.a(zzevVar2.getClass()).a(zzevVar2);
            zzevVar2.c();
            zzevVar = this.f36352b;
        } else {
            zzevVar = this.f36352b;
        }
        zzetVar.f36352b = zzevVar;
        return zzetVar;
    }
}
