package io.sentry.protocol;

import com.google.android.gms.common.Scopes;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.a;
import io.sentry.protocol.Geo;
import io.sentry.util.CollectionUtils;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public final class User implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public String f52959a;

    /* renamed from: b, reason: collision with root package name */
    public String f52960b;

    /* renamed from: c, reason: collision with root package name */
    public String f52961c;

    /* renamed from: d, reason: collision with root package name */
    public String f52962d;

    /* renamed from: e, reason: collision with root package name */
    public String f52963e;

    /* renamed from: f, reason: collision with root package name */
    public String f52964f;

    /* renamed from: g, reason: collision with root package name */
    public Geo f52965g;

    /* renamed from: h, reason: collision with root package name */
    public ConcurrentHashMap f52966h;

    /* renamed from: i, reason: collision with root package name */
    public ConcurrentHashMap f52967i;

    public static final class Deserializer implements JsonDeserializer<User> {
        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            objectReader.k();
            User user = new User();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strX = objectReader.X();
                strX.getClass();
                switch (strX) {
                    case "username":
                        user.f52961c = objectReader.a1();
                        break;
                    case "id":
                        user.f52960b = objectReader.a1();
                        break;
                    case "geo":
                        new Geo.Deserializer();
                        user.f52965g = Geo.Deserializer.b(objectReader, iLogger);
                        break;
                    case "data":
                        user.f52966h = CollectionUtils.c((Map) objectReader.B1());
                        break;
                    case "name":
                        user.f52964f = objectReader.a1();
                        break;
                    case "email":
                        user.f52959a = objectReader.a1();
                        break;
                    case "other":
                        ConcurrentHashMap concurrentHashMap2 = user.f52966h;
                        if (concurrentHashMap2 != null && !concurrentHashMap2.isEmpty()) {
                            break;
                        } else {
                            user.f52966h = CollectionUtils.c((Map) objectReader.B1());
                            break;
                        }
                        break;
                    case "ip_address":
                        user.f52963e = objectReader.a1();
                        break;
                    case "segment":
                        user.f52962d = objectReader.a1();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.I(iLogger, concurrentHashMap, strX);
                        break;
                }
            }
            user.f52967i = concurrentHashMap;
            objectReader.t();
            return user;
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && User.class == obj.getClass()) {
            User user = (User) obj;
            if (Objects.a(this.f52959a, user.f52959a) && Objects.a(this.f52960b, user.f52960b) && Objects.a(this.f52961c, user.f52961c) && Objects.a(this.f52962d, user.f52962d) && Objects.a(this.f52963e, user.f52963e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f52959a, this.f52960b, this.f52961c, this.f52962d, this.f52963e});
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        if (this.f52959a != null) {
            objectWriter.d(Scopes.EMAIL).e(this.f52959a);
        }
        if (this.f52960b != null) {
            objectWriter.d(CLConstants.SHARED_PREFERENCE_ITEM_ID).e(this.f52960b);
        }
        if (this.f52961c != null) {
            objectWriter.d("username").e(this.f52961c);
        }
        if (this.f52962d != null) {
            objectWriter.d("segment").e(this.f52962d);
        }
        if (this.f52963e != null) {
            objectWriter.d("ip_address").e(this.f52963e);
        }
        if (this.f52964f != null) {
            objectWriter.d(CLConstants.FIELD_PAY_INFO_NAME).e(this.f52964f);
        }
        if (this.f52965g != null) {
            objectWriter.d("geo");
            this.f52965g.serialize(objectWriter, iLogger);
        }
        if (this.f52966h != null) {
            objectWriter.d("data").h(iLogger, this.f52966h);
        }
        ConcurrentHashMap concurrentHashMap = this.f52967i;
        if (concurrentHashMap != null) {
            for (String str : concurrentHashMap.keySet()) {
                a.b(this.f52967i, str, objectWriter, str, iLogger);
            }
        }
        objectWriter.t();
    }
}
