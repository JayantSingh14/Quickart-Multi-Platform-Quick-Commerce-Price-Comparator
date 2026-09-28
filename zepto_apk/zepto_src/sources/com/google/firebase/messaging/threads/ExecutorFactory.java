package com.google.firebase.messaging.threads;

import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public interface ExecutorFactory {
    ExecutorService a(NamedThreadFactory namedThreadFactory);
}
