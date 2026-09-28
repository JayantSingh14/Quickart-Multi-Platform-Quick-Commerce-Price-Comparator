package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.core.graphics.Insets;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public final class zzesi implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final zzeul f30219a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfik f30220b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f30221c;

    /* renamed from: d, reason: collision with root package name */
    public final zzcda f30222d;

    public zzesi(zzeul zzeulVar, zzfik zzfikVar, Context context, zzcda zzcdaVar) {
        this.f30219a = zzeulVar;
        this.f30220b = zzfikVar;
        this.f30221c = context;
        this.f30222d = zzcdaVar;
    }

    public static final int a(float f2, int i2) {
        if (f2 == 0.0f) {
            return 0;
        }
        return (int) Math.ceil(i2 / f2);
    }

    public static final Insets b(Insets insets, float f2) {
        return f2 == 0.0f ? Insets.f2807e : Insets.c((int) Math.ceil(insets.f2808a / f2), (int) Math.ceil(insets.f2809b / f2), (int) Math.ceil(insets.f2810c / f2), (int) Math.ceil(insets.f2811d / f2));
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return zzgym.i(this.f30219a.zza(), new zzgpr() { // from class: com.google.android.gms.internal.ads.zzesh
            /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r4v2 com.google.android.gms.internal.ads.zzesj, still in use, count: 4, list:
                  (r4v2 com.google.android.gms.internal.ads.zzesj) from 0x0304: MOVE (r22v0 com.google.android.gms.internal.ads.zzesj) = (r4v2 com.google.android.gms.internal.ads.zzesj) (LINE:773)
                  (r4v2 com.google.android.gms.internal.ads.zzesj) from 0x01b0: MOVE (r22v3 com.google.android.gms.internal.ads.zzesj) = (r4v2 com.google.android.gms.internal.ads.zzesj) (LINE:433)
                  (r4v2 com.google.android.gms.internal.ads.zzesj) from 0x01cf: MOVE (r22v6 com.google.android.gms.internal.ads.zzesj) = (r4v2 com.google.android.gms.internal.ads.zzesj) (LINE:464)
                  (r4v2 com.google.android.gms.internal.ads.zzesj) from 0x018d: MOVE (r22v8 com.google.android.gms.internal.ads.zzesj) = (r4v2 com.google.android.gms.internal.ads.zzesj) (LINE:398)
                	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
                	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
                	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:91)
                	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:57)
                	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:463)
                	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:97)
                */
            @Override // com.google.android.gms.internal.ads.zzgpr
            public final java.lang.Object apply(java.lang.Object r30) {
                /*
                    Method dump skipped, instructions count: 1048
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzesh.apply(java.lang.Object):java.lang.Object");
            }
        }, zzcdo.f25988g);
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 7;
    }
}
