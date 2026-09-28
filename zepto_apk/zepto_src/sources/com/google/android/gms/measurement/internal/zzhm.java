package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
final class zzhm implements com.google.android.gms.internal.measurement.zzr {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzhs f39040a;

    public zzhm(zzhs zzhsVar) {
        Objects.requireNonNull(zzhsVar);
        this.f39040a = zzhsVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void a(int i2, String str, List list, boolean z, boolean z2) {
        zzgr zzgrVar;
        int i3 = i2 - 1;
        zzhs zzhsVar = this.f39040a;
        if (i3 == 0) {
            zzgt zzgtVar = zzhsVar.f39180a.f39089f;
            zzib.l(zzgtVar);
            zzgrVar = zzgtVar.f38965m;
        } else if (i3 != 1) {
            if (i3 == 3) {
                zzgt zzgtVar2 = zzhsVar.f39180a.f39089f;
                zzib.l(zzgtVar2);
                zzgrVar = zzgtVar2.n;
            } else if (i3 != 4) {
                zzgt zzgtVar3 = zzhsVar.f39180a.f39089f;
                zzib.l(zzgtVar3);
                zzgrVar = zzgtVar3.f38964l;
            } else if (z) {
                zzgt zzgtVar4 = zzhsVar.f39180a.f39089f;
                zzib.l(zzgtVar4);
                zzgrVar = zzgtVar4.f38962j;
            } else if (z2) {
                zzgt zzgtVar5 = zzhsVar.f39180a.f39089f;
                zzib.l(zzgtVar5);
                zzgrVar = zzgtVar5.f38961i;
            } else {
                zzgt zzgtVar6 = zzhsVar.f39180a.f39089f;
                zzib.l(zzgtVar6);
                zzgrVar = zzgtVar6.f38963k;
            }
        } else if (z) {
            zzgt zzgtVar7 = zzhsVar.f39180a.f39089f;
            zzib.l(zzgtVar7);
            zzgrVar = zzgtVar7.f38959g;
        } else if (z2) {
            zzgt zzgtVar8 = zzhsVar.f39180a.f39089f;
            zzib.l(zzgtVar8);
            zzgrVar = zzgtVar8.f38958f;
        } else {
            zzgt zzgtVar9 = zzhsVar.f39180a.f39089f;
            zzib.l(zzgtVar9);
            zzgrVar = zzgtVar9.f38960h;
        }
        int size = list.size();
        if (size == 1) {
            zzgrVar.b(list.get(0), str);
            return;
        }
        if (size == 2) {
            zzgrVar.c(str, list.get(0), list.get(1));
        } else if (size != 3) {
            zzgrVar.a(str);
        } else {
            zzgrVar.d(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
