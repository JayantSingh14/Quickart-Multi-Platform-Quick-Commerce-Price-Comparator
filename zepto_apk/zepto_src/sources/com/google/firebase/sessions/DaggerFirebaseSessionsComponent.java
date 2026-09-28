package com.google.firebase.sessions;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.FirebaseSessionsComponent;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.InstanceFactory;
import com.google.firebase.sessions.settings.SessionsSettings;
import kotlin.coroutines.CoroutineContext;

@DaggerGenerated
/* loaded from: classes.dex */
public final class DaggerFirebaseSessionsComponent {

    public static final class Builder implements FirebaseSessionsComponent.Builder {

        /* renamed from: a, reason: collision with root package name */
        public Context f44960a;

        /* renamed from: b, reason: collision with root package name */
        public CoroutineContext f44961b;

        /* renamed from: c, reason: collision with root package name */
        public CoroutineContext f44962c;

        /* renamed from: d, reason: collision with root package name */
        public FirebaseApp f44963d;

        /* renamed from: e, reason: collision with root package name */
        public FirebaseInstallationsApi f44964e;

        /* renamed from: f, reason: collision with root package name */
        public Provider f44965f;
    }

    public static final class FirebaseSessionsComponentImpl implements FirebaseSessionsComponent {

        /* renamed from: a, reason: collision with root package name */
        public InstanceFactory f44966a;

        /* renamed from: b, reason: collision with root package name */
        public InstanceFactory f44967b;

        /* renamed from: c, reason: collision with root package name */
        public javax.inject.Provider f44968c;

        /* renamed from: d, reason: collision with root package name */
        public InstanceFactory f44969d;

        /* renamed from: e, reason: collision with root package name */
        public InstanceFactory f44970e;

        /* renamed from: f, reason: collision with root package name */
        public javax.inject.Provider f44971f;

        /* renamed from: g, reason: collision with root package name */
        public javax.inject.Provider f44972g;

        /* renamed from: h, reason: collision with root package name */
        public javax.inject.Provider f44973h;

        /* renamed from: i, reason: collision with root package name */
        public javax.inject.Provider f44974i;

        /* renamed from: j, reason: collision with root package name */
        public javax.inject.Provider f44975j;

        /* renamed from: k, reason: collision with root package name */
        public javax.inject.Provider f44976k;

        /* renamed from: l, reason: collision with root package name */
        public javax.inject.Provider f44977l;

        /* renamed from: m, reason: collision with root package name */
        public javax.inject.Provider f44978m;
        public javax.inject.Provider n;
        public javax.inject.Provider o;
        public javax.inject.Provider p;
        public javax.inject.Provider q;
        public javax.inject.Provider r;
        public javax.inject.Provider s;
        public javax.inject.Provider t;

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent
        public final SessionGenerator a() {
            return (SessionGenerator) this.t.get();
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent
        public final SessionsSettings b() {
            return (SessionsSettings) this.f44976k.get();
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent
        public final SessionFirelogPublisher c() {
            return (SessionFirelogPublisher) this.q.get();
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent
        public final FirebaseSessions d() {
            return (FirebaseSessions) this.f44978m.get();
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent
        public final SessionDatastore e() {
            return (SessionDatastore) this.o.get();
        }
    }
}
