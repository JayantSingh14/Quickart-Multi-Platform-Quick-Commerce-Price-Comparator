package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.util.PriorityMapping;

/* loaded from: classes3.dex */
public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f20856a = 0;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter("extras");
        int iIntValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i2 = intent.getExtras().getInt("attemptNumber");
        TransportRuntime.b(context);
        TransportContext.Builder builderA = TransportContext.a();
        builderA.b(queryParameter);
        builderA.d(PriorityMapping.b(iIntValue));
        if (queryParameter2 != null) {
            builderA.c(Base64.decode(queryParameter2, 0));
        }
        Uploader uploader = TransportRuntime.a().f20763d;
        TransportContext transportContextA = builderA.a();
        com.amazon.android.amazonpay.api.c cVar = new com.amazon.android.amazonpay.api.c(1);
        uploader.getClass();
        uploader.f20879e.execute(new a(i2, 0, uploader, transportContextA, cVar));
    }
}
