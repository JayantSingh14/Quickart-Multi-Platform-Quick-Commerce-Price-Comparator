package com.google.firebase.analytics.connector;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;

/* loaded from: classes.dex */
final /* synthetic */ class zza implements EventHandler {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zza f43550a = new zza();

    @Override // com.google.firebase.events.EventHandler
    public final void a(Event event) {
        boolean z = ((DataCollectionDefaultChange) event.a()).f43485a;
        synchronized (AnalyticsConnectorImpl.class) {
            ((AnalyticsConnectorImpl) Preconditions.checkNotNull(AnalyticsConnectorImpl.f43537c)).f43538a.f38652a.h(z);
        }
    }
}
