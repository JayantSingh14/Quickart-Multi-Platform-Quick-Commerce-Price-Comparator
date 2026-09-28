package com.google.firebase.sessions;

import com.google.firebase.FirebaseKt;
import java.util.Locale;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Singleton
@Metadata
/* loaded from: classes4.dex */
public final class SessionGenerator {

    /* renamed from: a, reason: collision with root package name */
    public final TimeProvider f45087a;

    /* renamed from: b, reason: collision with root package name */
    public final UuidGenerator f45088b;

    /* renamed from: c, reason: collision with root package name */
    public final String f45089c;

    /* renamed from: d, reason: collision with root package name */
    public int f45090d;

    /* renamed from: e, reason: collision with root package name */
    public SessionDetails f45091e;

    @Metadata
    public static final class Companion {
        public static SessionGenerator a() {
            return ((FirebaseSessionsComponent) FirebaseKt.a().b(FirebaseSessionsComponent.class)).a();
        }
    }

    public SessionGenerator(TimeProvider timeProvider, UuidGenerator uuidGenerator) {
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        Intrinsics.checkNotNullParameter(uuidGenerator, "uuidGenerator");
        this.f45087a = timeProvider;
        this.f45088b = uuidGenerator;
        this.f45089c = a();
        this.f45090d = -1;
    }

    public final String a() {
        String string = this.f45088b.next().toString();
        Intrinsics.checkNotNullExpressionValue(string, "uuidGenerator.next().toString()");
        String lowerCase = StringsKt.K(string, "-", "").toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }
}
