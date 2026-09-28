package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzak {

    /* renamed from: a, reason: collision with root package name */
    public final String f23331a;

    /* renamed from: b, reason: collision with root package name */
    public final zzag f23332b;

    /* renamed from: c, reason: collision with root package name */
    public final zzaf f23333c;

    /* renamed from: d, reason: collision with root package name */
    public final zzan f23334d;

    /* renamed from: e, reason: collision with root package name */
    public final zzac f23335e;

    /* renamed from: f, reason: collision with root package name */
    public final zzai f23336f;

    static {
        new zzz().a();
        String str = zzfj.f31254a;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
    }

    public /* synthetic */ zzak(String str, zzac zzacVar, zzag zzagVar, zzaf zzafVar, zzan zzanVar, zzai zzaiVar) {
        this.f23331a = str;
        this.f23332b = zzagVar;
        this.f23333c = zzafVar;
        this.f23334d = zzanVar;
        this.f23335e = zzacVar;
        this.f23336f = zzaiVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzak)) {
            return false;
        }
        zzak zzakVar = (zzak) obj;
        return this.f23331a.equals(zzakVar.f23331a) && this.f23335e.equals(zzakVar.f23335e) && Objects.equals(this.f23332b, zzakVar.f23332b) && this.f23333c.equals(zzakVar.f23333c) && Objects.equals(this.f23334d, zzakVar.f23334d) && Objects.equals(this.f23336f, zzakVar.f23336f);
    }

    public final int hashCode() {
        int iHashCode = this.f23331a.hashCode() * 31;
        zzag zzagVar = this.f23332b;
        return (this.f23334d.hashCode() + ((this.f23335e.hashCode() + ((this.f23333c.hashCode() + ((iHashCode + (zzagVar != null ? zzagVar.hashCode() : 0)) * 31)) * 31)) * 31)) * 31;
    }
}
