package com.google.android.gms.internal.ads;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class zzang implements zzaly {

    /* renamed from: a, reason: collision with root package name */
    public final zzer f23742a = new zzer();

    @Override // com.google.android.gms.internal.ads.zzaly
    public final void a(byte[] bArr, int i2, int i3, zzdr zzdrVar) {
        zzcx zzcxVarB;
        zzer zzerVar = this.f23742a;
        zzerVar.z(i2 + i3, bArr);
        zzerVar.E(i2);
        ArrayList arrayList = new ArrayList();
        while (zzerVar.B() > 0) {
            zzgqa.b("Incomplete Mp4Webvtt Top Level box header found.", zzerVar.B() >= 8);
            int iB = zzerVar.b() - 8;
            if (zzerVar.b() == 1987343459) {
                CharSequence charSequenceA = null;
                zzcw zzcwVarA = null;
                while (iB > 0) {
                    zzgqa.b("Incomplete vtt cue box header found.", iB >= 8);
                    int iB2 = zzerVar.b();
                    int iB3 = zzerVar.b();
                    int i4 = iB - 8;
                    int i5 = iB2 - 8;
                    byte[] bArr2 = zzerVar.f30144a;
                    int i6 = zzerVar.f30145b;
                    String str = zzfj.f31254a;
                    String str2 = new String(bArr2, i6, i5, StandardCharsets.UTF_8);
                    zzerVar.G(i5);
                    if (iB3 == 1937011815) {
                        Pattern pattern = zzanp.f23784a;
                        zzano zzanoVar = new zzano();
                        zzanp.c(str2, zzanoVar);
                        zzcwVarA = zzanoVar.a();
                    } else if (iB3 == 1885436268) {
                        charSequenceA = zzanp.a(null, str2.trim(), Collections.EMPTY_LIST);
                    }
                    iB = i4 - i5;
                }
                if (charSequenceA == null) {
                    charSequenceA = "";
                }
                if (zzcwVarA != null) {
                    zzcwVarA.a(charSequenceA);
                    zzcxVarB = zzcwVarA.b();
                } else {
                    Pattern pattern2 = zzanp.f23784a;
                    zzano zzanoVar2 = new zzano();
                    zzanoVar2.f23775c = charSequenceA;
                    zzcxVarB = zzanoVar2.a().b();
                }
                arrayList.add(zzcxVarB);
            } else {
                zzerVar.G(iB);
            }
        }
        ((zzama) zzdrVar).zza(new zzalq(arrayList, -9223372036854775807L, -9223372036854775807L));
    }
}
