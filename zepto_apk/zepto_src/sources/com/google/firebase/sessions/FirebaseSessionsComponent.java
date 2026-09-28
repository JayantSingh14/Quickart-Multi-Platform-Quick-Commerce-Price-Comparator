package com.google.firebase.sessions;

import com.google.firebase.sessions.dagger.Component;
import com.google.firebase.sessions.dagger.Module;
import com.google.firebase.sessions.settings.SessionsSettings;
import javax.inject.Singleton;
import kotlin.Metadata;

@Component
@Singleton
@Metadata
/* loaded from: classes.dex */
public interface FirebaseSessionsComponent {

    @Component.Builder
    @Metadata
    public interface Builder {
    }

    @Metadata
    @Module
    public interface MainModule {

        @Metadata
        public static final class Companion {
        }
    }

    SessionGenerator a();

    SessionsSettings b();

    SessionFirelogPublisher c();

    FirebaseSessions d();

    SessionDatastore e();
}
