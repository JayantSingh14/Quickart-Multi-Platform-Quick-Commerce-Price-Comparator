package com.google.firebase.messaging;

import androidx.annotation.Keep;
import com.google.android.datatransport.TransportFactory;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.datatransport.TransportBackend;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.Arrays;
import java.util.List;

@Keep
@KeepForSdk
/* loaded from: classes.dex */
public class FirebaseMessagingRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-fcm";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ FirebaseMessaging lambda$getComponents$0(Qualified qualified, ComponentContainer componentContainer) {
        return new FirebaseMessaging((FirebaseApp) componentContainer.a(FirebaseApp.class), (FirebaseInstanceIdInternal) componentContainer.a(FirebaseInstanceIdInternal.class), componentContainer.g(UserAgentPublisher.class), componentContainer.g(HeartBeatInfo.class), (FirebaseInstallationsApi) componentContainer.a(FirebaseInstallationsApi.class), componentContainer.b(qualified), (Subscriber) componentContainer.a(Subscriber.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<Component<?>> getComponents() {
        Qualified qualified = new Qualified(TransportBackend.class, TransportFactory.class);
        Component.Builder builderB = Component.b(FirebaseMessaging.class);
        builderB.f43563a = LIBRARY_NAME;
        builderB.a(Dependency.b(FirebaseApp.class));
        builderB.a(new Dependency(0, 0, FirebaseInstanceIdInternal.class));
        builderB.a(new Dependency(0, 1, UserAgentPublisher.class));
        builderB.a(new Dependency(0, 1, HeartBeatInfo.class));
        builderB.a(Dependency.b(FirebaseInstallationsApi.class));
        builderB.a(new Dependency(qualified, 0, 1));
        builderB.a(Dependency.b(Subscriber.class));
        builderB.f43568f = new m(qualified);
        builderB.d(1);
        return Arrays.asList(builderB.b(), LibraryVersionComponent.a(LIBRARY_NAME, "24.1.2"));
    }
}
