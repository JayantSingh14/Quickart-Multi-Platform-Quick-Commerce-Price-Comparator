package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EnhancedIntentService f44816a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Intent f44817b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f44818c;

    public /* synthetic */ c(EnhancedIntentService enhancedIntentService, Intent intent, TaskCompletionSource taskCompletionSource) {
        this.f44816a = enhancedIntentService;
        this.f44817b = intent;
        this.f44818c = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Intent intent = this.f44817b;
        TaskCompletionSource taskCompletionSource = this.f44818c;
        int i2 = EnhancedIntentService.f44691a;
        EnhancedIntentService enhancedIntentService = this.f44816a;
        enhancedIntentService.getClass();
        try {
            enhancedIntentService.handleIntent(intent);
        } finally {
            taskCompletionSource.b(null);
        }
    }
}
