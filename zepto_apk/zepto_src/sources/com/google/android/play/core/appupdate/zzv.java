package com.google.android.play.core.appupdate;

import com.google.android.play.core.appupdate.AppUpdateOptions;

/* loaded from: classes4.dex */
final class zzv extends AppUpdateOptions.Builder {

    /* renamed from: a, reason: collision with root package name */
    public int f41746a;

    /* renamed from: b, reason: collision with root package name */
    public byte f41747b;

    @Override // com.google.android.play.core.appupdate.AppUpdateOptions.Builder
    public final AppUpdateOptions a() {
        if (this.f41747b == 3) {
            return new zzx(this.f41746a);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.f41747b & 1) == 0) {
            sb.append(" appUpdateType");
        }
        if ((this.f41747b & 2) == 0) {
            sb.append(" allowAssetPackDeletion");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
