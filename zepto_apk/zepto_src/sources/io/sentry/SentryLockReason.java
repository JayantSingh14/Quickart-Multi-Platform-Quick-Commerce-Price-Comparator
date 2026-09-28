package io.sentry;

import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class SentryLockReason implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public int f51839a;

    /* renamed from: b, reason: collision with root package name */
    public String f51840b;

    /* renamed from: c, reason: collision with root package name */
    public String f51841c;

    /* renamed from: d, reason: collision with root package name */
    public String f51842d;

    /* renamed from: e, reason: collision with root package name */
    public Long f51843e;

    /* renamed from: f, reason: collision with root package name */
    public ConcurrentHashMap f51844f;

    public static final class Deserializer implements JsonDeserializer<SentryLockReason> {
        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            SentryLockReason sentryLockReason = new SentryLockReason();
            objectReader.k();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strX = objectReader.X();
                strX.getClass();
                switch (strX) {
                    case "package_name":
                        sentryLockReason.f51841c = objectReader.a1();
                        break;
                    case "thread_id":
                        sentryLockReason.f51843e = objectReader.R0();
                        break;
                    case "address":
                        sentryLockReason.f51840b = objectReader.a1();
                        break;
                    case "class_name":
                        sentryLockReason.f51842d = objectReader.a1();
                        break;
                    case "type":
                        sentryLockReason.f51839a = objectReader.nextInt();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.I(iLogger, concurrentHashMap, strX);
                        break;
                }
            }
            sentryLockReason.f51844f = concurrentHashMap;
            objectReader.t();
            return sentryLockReason;
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SentryLockReason.class != obj.getClass()) {
            return false;
        }
        return Objects.a(this.f51840b, ((SentryLockReason) obj).f51840b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f51840b});
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        objectWriter.d("type").a(this.f51839a);
        if (this.f51840b != null) {
            objectWriter.d("address").e(this.f51840b);
        }
        if (this.f51841c != null) {
            objectWriter.d("package_name").e(this.f51841c);
        }
        if (this.f51842d != null) {
            objectWriter.d("class_name").e(this.f51842d);
        }
        if (this.f51843e != null) {
            objectWriter.d("thread_id").f(this.f51843e);
        }
        ConcurrentHashMap concurrentHashMap = this.f51844f;
        if (concurrentHashMap != null) {
            for (String str : concurrentHashMap.keySet()) {
                a.b(this.f51844f, str, objectWriter, str, iLogger);
            }
        }
        objectWriter.t();
    }
}
