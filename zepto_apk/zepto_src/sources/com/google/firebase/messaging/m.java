package com.google.firebase.messaging;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Qualified;
import java.io.IOException;

/* loaded from: classes.dex */
public final /* synthetic */ class m implements OnSuccessListener, Continuation, ComponentFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f44839a;

    public /* synthetic */ m(Object obj) {
        this.f44839a = obj;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object c(ComponentContainer componentContainer) {
        return FirebaseMessagingRegistrar.lambda$getComponents$0((Qualified) this.f44839a, componentContainer);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        TopicsSubscriber topicsSubscriber = (TopicsSubscriber) obj;
        if (((FirebaseMessaging) this.f44839a).f44705f.b()) {
            topicsSubscriber.f();
        }
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) throws IOException {
        ((GmsRpc) this.f44839a).getClass();
        Bundle bundle = (Bundle) task.m();
        if (bundle == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String string = bundle.getString("registration_id");
        if (string != null) {
            return string;
        }
        String string2 = bundle.getString("unregistered");
        if (string2 != null) {
            return string2;
        }
        String string3 = bundle.getString("error");
        if ("RST".equals(string3)) {
            throw new IOException("INSTANCE_ID_RESET");
        }
        if (string3 != null) {
            throw new IOException(string3);
        }
        Log.w("FirebaseMessaging", "Unexpected response: " + bundle, new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }
}
