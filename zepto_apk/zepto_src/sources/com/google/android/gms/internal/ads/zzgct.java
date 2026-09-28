package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public interface zzgct {
    ListenableFuture a(Context context);

    ListenableFuture b(Context context, View view, Activity activity);

    ListenableFuture c(Context context, String str, View view);

    void d(MotionEvent motionEvent);

    String zza();

    ListenableFuture zzb();

    int zzg();
}
