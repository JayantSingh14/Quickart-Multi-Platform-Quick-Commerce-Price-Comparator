package com.google.firebase.sessions;

import android.content.ServiceConnection;
import android.os.Messenger;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface SessionLifecycleServiceBinder {
    void a(Messenger messenger, ServiceConnection serviceConnection);
}
