package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzaek implements zzaeu {

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f22880c = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14, 17, 18, 19, 20, 21};

    /* renamed from: d, reason: collision with root package name */
    public static final zzaej f22881d = new zzaej(zzaeh.f22877a);

    /* renamed from: e, reason: collision with root package name */
    public static final zzaej f22882e = new zzaej(zzaeg.f22876a);

    /* renamed from: a, reason: collision with root package name */
    public zzgtd f22883a;

    /* renamed from: b, reason: collision with root package name */
    public final zzalr f22884b = new zzalr();

    /* JADX WARN: Removed duplicated region for block: B:114:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x020a  */
    @Override // com.google.android.gms.internal.ads.zzaeu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized com.google.android.gms.internal.ads.zzaeo[] a(android.net.Uri r27, java.util.Map r28) {
        /*
            Method dump skipped, instructions count: 1182
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaek.a(android.net.Uri, java.util.Map):com.google.android.gms.internal.ads.zzaeo[]");
    }

    public final void b(int i2, ArrayList arrayList) {
        zzalr zzalrVar = this.f22884b;
        switch (i2) {
            case 0:
                arrayList.add(new zzanv());
                break;
            case 1:
                arrayList.add(new zzany());
                break;
            case 2:
                arrayList.add(new zzaob(0));
                break;
            case 3:
                arrayList.add(new zzagi(0));
                break;
            case 4:
                zzaeo zzaeoVarA = f22881d.a(0);
                if (zzaeoVarA == null) {
                    arrayList.add(new zzagz(0));
                    break;
                } else {
                    arrayList.add(zzaeoVarA);
                    break;
                }
            case 5:
                arrayList.add(new zzahc());
                break;
            case 6:
                arrayList.add(new zzaja(new zzait(), 0, zzalrVar));
                break;
            case 7:
                arrayList.add(new zzaji(0));
                break;
            case 8:
                zzgvs zzgvsVar = zzgtd.f33183b;
                arrayList.add(new zzakh(zzalrVar, 0, zzguy.f33232e));
                arrayList.add(new zzakp(0, zzalrVar));
                break;
            case 9:
                arrayList.add(new zzalf());
                break;
            case 10:
                arrayList.add(new zzapf());
                break;
            case 11:
                if (this.f22883a == null) {
                    zzgvs zzgvsVar2 = zzgtd.f33183b;
                    this.f22883a = zzguy.f33232e;
                }
                arrayList.add(new zzapq(0, zzalrVar, new zzfg(), new zzaod(this.f22883a)));
                break;
            case 12:
                arrayList.add(new zzaqd());
                break;
            case 14:
                arrayList.add(new zzahj(0));
                break;
            case 15:
                zzaeo zzaeoVarA2 = f22882e.a(new Object[0]);
                if (zzaeoVarA2 != null) {
                    arrayList.add(zzaeoVarA2);
                    break;
                }
                break;
            case 16:
                arrayList.add(new zzagm(0, zzalrVar));
                break;
            case 17:
                arrayList.add(new zzalp());
                break;
            case 18:
                arrayList.add(new zzaqi());
                break;
            case 19:
                arrayList.add(new zzagu());
                break;
            case 20:
                arrayList.add(new zzahi(0));
                break;
            case 21:
                arrayList.add(new zzagt());
                break;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final synchronized zzaeo[] zza() {
        return a(Uri.EMPTY, new HashMap());
    }
}
