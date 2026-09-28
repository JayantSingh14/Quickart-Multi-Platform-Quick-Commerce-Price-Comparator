package com.google.android.gms.dynamic;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.LifecycleDelegate;

@KeepForSdk
/* loaded from: classes4.dex */
public interface OnDelegateCreatedListener<T extends LifecycleDelegate> {
    void a(LifecycleDelegate lifecycleDelegate);
}
