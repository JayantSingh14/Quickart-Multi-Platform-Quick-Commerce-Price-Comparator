package com.google.firebase.sessions;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class SessionLifecycleClient {

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineContext f45101a;

    /* renamed from: b, reason: collision with root package name */
    public Messenger f45102b;

    /* renamed from: c, reason: collision with root package name */
    public final LinkedBlockingDeque f45103c;

    /* renamed from: d, reason: collision with root package name */
    public final SessionLifecycleClient$serviceConnection$1 f45104d;

    @Metadata
    public static final class ClientUpdateHandler extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final CoroutineContext f45105a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ClientUpdateHandler(CoroutineContext backgroundDispatcher) {
            super(Looper.getMainLooper());
            Intrinsics.checkNotNullParameter(backgroundDispatcher, "backgroundDispatcher");
            this.f45105a = backgroundDispatcher;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message msg) {
            String string;
            Intrinsics.checkNotNullParameter(msg, "msg");
            if (msg.what != 3) {
                Log.w("SessionLifecycleClient", "Received unexpected event from the SessionLifecycleService: " + msg);
                super.handleMessage(msg);
                return;
            }
            Bundle data = msg.getData();
            if (data == null || (string = data.getString("SessionUpdateExtra")) == null) {
                string = "";
            }
            Log.d("SessionLifecycleClient", "Session update received.");
            BuildersKt.c(CoroutineScopeKt.a(this.f45105a), null, new SessionLifecycleClient$ClientUpdateHandler$handleSessionUpdate$1(string, null), 3);
        }
    }

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.google.firebase.sessions.SessionLifecycleClient$serviceConnection$1] */
    public SessionLifecycleClient(CoroutineContext backgroundDispatcher) {
        Intrinsics.checkNotNullParameter(backgroundDispatcher, "backgroundDispatcher");
        this.f45101a = backgroundDispatcher;
        this.f45103c = new LinkedBlockingDeque(20);
        this.f45104d = new ServiceConnection() { // from class: com.google.firebase.sessions.SessionLifecycleClient$serviceConnection$1
            @Override // android.content.ServiceConnection
            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                StringBuilder sb = new StringBuilder("Connected to SessionLifecycleService. Queue size ");
                SessionLifecycleClient sessionLifecycleClient = this.f45111a;
                sb.append(sessionLifecycleClient.f45103c.size());
                Log.d("SessionLifecycleClient", sb.toString());
                sessionLifecycleClient.f45102b = new Messenger(iBinder);
                ArrayList arrayList = new ArrayList();
                sessionLifecycleClient.f45103c.drainTo(arrayList);
                BuildersKt.c(CoroutineScopeKt.a(sessionLifecycleClient.f45101a), null, new SessionLifecycleClient$sendLifecycleEvents$1(sessionLifecycleClient, arrayList, null), 3);
            }

            @Override // android.content.ServiceConnection
            public final void onServiceDisconnected(ComponentName componentName) {
                Log.d("SessionLifecycleClient", "Disconnected from SessionLifecycleService");
                SessionLifecycleClient sessionLifecycleClient = this.f45111a;
                sessionLifecycleClient.f45102b = null;
                sessionLifecycleClient.getClass();
            }
        };
    }

    public static final Message a(SessionLifecycleClient sessionLifecycleClient, ArrayList arrayList, int i2) {
        Object obj;
        sessionLifecycleClient.getClass();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (((Message) obj2).what == i2) {
                arrayList2.add(obj2);
            }
        }
        Iterator it = arrayList2.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                long when = ((Message) next).getWhen();
                do {
                    Object next2 = it.next();
                    long when2 = ((Message) next2).getWhen();
                    if (when < when2) {
                        next = next2;
                        when = when2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        return (Message) obj;
    }

    public final void b() {
        ArrayList arrayList = new ArrayList();
        this.f45103c.drainTo(arrayList);
        Message messageObtain = Message.obtain(null, 2, 0, 0);
        Intrinsics.checkNotNullExpressionValue(messageObtain, "obtain(null, messageCode, 0, 0)");
        arrayList.add(messageObtain);
        BuildersKt.c(CoroutineScopeKt.a(this.f45101a), null, new SessionLifecycleClient$sendLifecycleEvents$1(this, arrayList, null), 3);
    }

    public final void c(SessionLifecycleServiceBinder sessionLifecycleServiceBinder) {
        Intrinsics.checkNotNullParameter(sessionLifecycleServiceBinder, "sessionLifecycleServiceBinder");
        sessionLifecycleServiceBinder.a(new Messenger(new ClientUpdateHandler(this.f45101a)), this.f45104d);
    }

    public final void d() {
        ArrayList arrayList = new ArrayList();
        this.f45103c.drainTo(arrayList);
        Message messageObtain = Message.obtain(null, 1, 0, 0);
        Intrinsics.checkNotNullExpressionValue(messageObtain, "obtain(null, messageCode, 0, 0)");
        arrayList.add(messageObtain);
        BuildersKt.c(CoroutineScopeKt.a(this.f45101a), null, new SessionLifecycleClient$sendLifecycleEvents$1(this, arrayList, null), 3);
    }

    public final void e(Message message) {
        LinkedBlockingDeque linkedBlockingDeque = this.f45103c;
        if (!linkedBlockingDeque.offer(message)) {
            Log.d("SessionLifecycleClient", "Failed to enqueue message " + message.what + ". Dropping.");
            return;
        }
        Log.d("SessionLifecycleClient", "Queued message " + message.what + ". Queue size " + linkedBlockingDeque.size());
    }
}
