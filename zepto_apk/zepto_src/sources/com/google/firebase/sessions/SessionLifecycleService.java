package com.google.firebase.sessions;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import com.google.firebase.FirebaseKt;
import com.google.firebase.sessions.SessionGenerator;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.lang3.ClassUtils;

@Metadata
/* loaded from: classes4.dex */
public final class SessionLifecycleService extends Service {

    /* renamed from: a, reason: collision with root package name */
    public final HandlerThread f45112a = new HandlerThread("FirebaseSessions_HandlerThread");

    /* renamed from: b, reason: collision with root package name */
    public MessageHandler f45113b;

    /* renamed from: c, reason: collision with root package name */
    public Messenger f45114c;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    @SourceDebugExtension
    public static final class MessageHandler extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public boolean f45115a;

        /* renamed from: b, reason: collision with root package name */
        public long f45116b;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f45117c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MessageHandler(Looper looper) {
            super(looper);
            Intrinsics.checkNotNullParameter(looper, "looper");
            this.f45117c = new ArrayList();
        }

        public final void a() throws RemoteException {
            Log.d("SessionLifecycleService", "Broadcasting new session");
            SessionFirelogPublisher sessionFirelogPublisherC = ((FirebaseSessionsComponent) FirebaseKt.a().b(FirebaseSessionsComponent.class)).c();
            SessionDetails sessionDetails = SessionGenerator.Companion.a().f45091e;
            if (sessionDetails == null) {
                Intrinsics.h("currentSession");
                throw null;
            }
            sessionFirelogPublisherC.a(sessionDetails);
            Iterator it = new ArrayList(this.f45117c).iterator();
            while (it.hasNext()) {
                Messenger it2 = (Messenger) it.next();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                b(it2);
            }
        }

        public final void b(Messenger messenger) throws RemoteException {
            try {
                if (this.f45115a) {
                    SessionDetails sessionDetails = SessionGenerator.Companion.a().f45091e;
                    if (sessionDetails != null) {
                        d(messenger, sessionDetails.f45054a);
                        return;
                    } else {
                        Intrinsics.h("currentSession");
                        throw null;
                    }
                }
                String strA = ((FirebaseSessionsComponent) FirebaseKt.a().b(FirebaseSessionsComponent.class)).e().a();
                Log.d("SessionLifecycleService", "App has not yet foregrounded. Using previously stored session.");
                if (strA != null) {
                    d(messenger, strA);
                }
            } catch (IllegalStateException e2) {
                Log.w("SessionLifecycleService", "Failed to send session to client.", e2);
            }
        }

        public final void c() throws RemoteException {
            try {
                SessionGenerator sessionGeneratorA = SessionGenerator.Companion.a();
                int i2 = sessionGeneratorA.f45090d + 1;
                sessionGeneratorA.f45090d = i2;
                sessionGeneratorA.f45091e = new SessionDetails(sessionGeneratorA.f45087a.a(), i2 == 0 ? sessionGeneratorA.f45089c : sessionGeneratorA.a(), sessionGeneratorA.f45089c, sessionGeneratorA.f45090d);
                Log.d("SessionLifecycleService", "Generated new session.");
                a();
                SessionDatastore sessionDatastoreE = ((FirebaseSessionsComponent) FirebaseKt.a().b(FirebaseSessionsComponent.class)).e();
                SessionDetails sessionDetails = SessionGenerator.Companion.a().f45091e;
                if (sessionDetails != null) {
                    sessionDatastoreE.b(sessionDetails.f45054a);
                } else {
                    Intrinsics.h("currentSession");
                    throw null;
                }
            } catch (IllegalStateException e2) {
                Log.w("SessionLifecycleService", "Failed to generate new session.", e2);
            }
        }

        public final void d(Messenger messenger, String str) throws RemoteException {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("SessionUpdateExtra", str);
                Message messageObtain = Message.obtain(null, 3, 0, 0);
                messageObtain.setData(bundle);
                messenger.send(messageObtain);
            } catch (DeadObjectException unused) {
                Log.d("SessionLifecycleService", "Removing dead client from list: " + messenger);
                this.f45117c.remove(messenger);
            } catch (Exception e2) {
                Log.w("SessionLifecycleService", "Unable to push new session to " + messenger + ClassUtils.PACKAGE_SEPARATOR_CHAR, e2);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x0107  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x011e  */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void handleMessage(android.os.Message r11) throws android.os.RemoteException {
            /*
                Method dump skipped, instructions count: 334
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SessionLifecycleService.MessageHandler.handleMessage(android.os.Message):void");
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        if (intent == null) {
            Log.d("SessionLifecycleService", "Service bound with null intent. Ignoring.");
            return null;
        }
        Log.d("SessionLifecycleService", "Service bound to new client on process " + intent.getAction());
        Messenger messenger = Build.VERSION.SDK_INT >= 33 ? (Messenger) intent.getParcelableExtra("ClientCallbackMessenger", Messenger.class) : (Messenger) intent.getParcelableExtra("ClientCallbackMessenger");
        if (messenger != null) {
            Message messageObtain = Message.obtain(null, 4, 0, 0);
            messageObtain.replyTo = messenger;
            MessageHandler messageHandler = this.f45113b;
            if (messageHandler != null) {
                messageHandler.sendMessage(messageObtain);
            }
        }
        Messenger messenger2 = this.f45114c;
        if (messenger2 != null) {
            return messenger2.getBinder();
        }
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        HandlerThread handlerThread = this.f45112a;
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        Intrinsics.checkNotNullExpressionValue(looper, "handlerThread.looper");
        this.f45113b = new MessageHandler(looper);
        this.f45114c = new Messenger(this.f45113b);
        Log.d("SessionLifecycleService", "Service created on process " + Process.myPid());
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        this.f45112a.quit();
    }
}
