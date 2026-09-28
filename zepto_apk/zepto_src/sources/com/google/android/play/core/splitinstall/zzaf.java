package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.play.core.splitinstall.internal.zzcb;
import java.io.File;

/* loaded from: classes4.dex */
public final class zzaf implements zzcb {

    /* renamed from: a, reason: collision with root package name */
    public final zzad f42093a;

    public zzaf(zzad zzadVar) {
        this.f42093a = zzadVar;
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzcb, com.google.android.play.core.splitinstall.internal.zzby
    public final Object zza() {
        String string;
        Context context = this.f42093a.f42091a.f42090a;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null && (string = bundle.getString("local_testing_dir")) != null) {
                return new File(context.getExternalFilesDir(null), string);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }
}
