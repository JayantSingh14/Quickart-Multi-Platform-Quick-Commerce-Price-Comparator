package io.sentry;

import com.google.android.gms.common.Scopes;
import io.sentry.protocol.SentryId;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.HashMap;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public final class UserFeedback implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public final SentryId f51976a;

    /* renamed from: b, reason: collision with root package name */
    public final String f51977b;

    /* renamed from: c, reason: collision with root package name */
    public final String f51978c;

    /* renamed from: d, reason: collision with root package name */
    public final String f51979d;

    /* renamed from: e, reason: collision with root package name */
    public HashMap f51980e;

    public static final class Deserializer implements JsonDeserializer<UserFeedback> {
        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            objectReader.k();
            SentryId sentryIdB = null;
            String strA1 = null;
            String strA12 = null;
            String strA13 = null;
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strX = objectReader.X();
                strX.getClass();
                switch (strX) {
                    case "comments":
                        strA13 = objectReader.a1();
                        break;
                    case "name":
                        strA1 = objectReader.a1();
                        break;
                    case "email":
                        strA12 = objectReader.a1();
                        break;
                    case "event_id":
                        new SentryId.Deserializer();
                        sentryIdB = SentryId.Deserializer.b(objectReader);
                        break;
                    default:
                        if (map == null) {
                            map = new HashMap();
                        }
                        objectReader.I(iLogger, map, strX);
                        break;
                }
            }
            objectReader.t();
            if (sentryIdB != null) {
                UserFeedback userFeedback = new UserFeedback(sentryIdB, strA1, strA12, strA13);
                userFeedback.f51980e = map;
                return userFeedback;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"event_id\"");
            iLogger.b(SentryLevel.ERROR, "Missing required field \"event_id\"", illegalStateException);
            throw illegalStateException;
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    public UserFeedback(SentryId sentryId, String str, String str2, String str3) {
        this.f51976a = sentryId;
        this.f51977b = str;
        this.f51978c = str2;
        this.f51979d = str3;
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        objectWriter.d("event_id");
        this.f51976a.serialize(objectWriter, iLogger);
        String str = this.f51977b;
        if (str != null) {
            objectWriter.d(CLConstants.FIELD_PAY_INFO_NAME).e(str);
        }
        String str2 = this.f51978c;
        if (str2 != null) {
            objectWriter.d(Scopes.EMAIL).e(str2);
        }
        String str3 = this.f51979d;
        if (str3 != null) {
            objectWriter.d("comments").e(str3);
        }
        HashMap map = this.f51980e;
        if (map != null) {
            for (String str4 : map.keySet()) {
                objectWriter.d(str4).h(iLogger, this.f51980e.get(str4));
            }
        }
        objectWriter.t();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("UserFeedback{eventId=");
        sb.append(this.f51976a);
        sb.append(", name='");
        sb.append(this.f51977b);
        sb.append("', email='");
        sb.append(this.f51978c);
        sb.append("', comments='");
        return android.support.v4.media.b.r(sb, this.f51979d, "'}");
    }
}
