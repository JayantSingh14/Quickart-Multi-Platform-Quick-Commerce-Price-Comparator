package com.google.android.play.core.review;

import android.app.PendingIntent;
import android.os.Bundle;

/* loaded from: classes4.dex */
final class zzh extends zzg {
    @Override // com.google.android.play.core.review.zzg, com.google.android.play.core.review.internal.zzh
    public final void b0(Bundle bundle) {
        super.b0(bundle);
        this.f41893b.d(new zza((PendingIntent) bundle.get("confirmation_intent"), bundle.getBoolean("is_review_no_op")));
    }
}
