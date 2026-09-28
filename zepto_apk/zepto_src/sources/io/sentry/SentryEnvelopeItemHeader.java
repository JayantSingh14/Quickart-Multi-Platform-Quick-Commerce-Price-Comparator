package io.sentry;

import io.sentry.SentryItemType;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.HashMap;
import java.util.concurrent.Callable;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class SentryEnvelopeItemHeader implements JsonSerializable, JsonUnknown {

    /* renamed from: a, reason: collision with root package name */
    public final String f51825a;

    /* renamed from: b, reason: collision with root package name */
    public final String f51826b;

    /* renamed from: c, reason: collision with root package name */
    public final SentryItemType f51827c;

    /* renamed from: d, reason: collision with root package name */
    public final int f51828d;

    /* renamed from: e, reason: collision with root package name */
    public final Callable f51829e;

    /* renamed from: f, reason: collision with root package name */
    public final String f51830f;

    /* renamed from: g, reason: collision with root package name */
    public HashMap f51831g;

    public static final class Deserializer implements JsonDeserializer<SentryEnvelopeItemHeader> {
        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            objectReader.k();
            HashMap map = null;
            int iNextInt = 0;
            SentryItemType sentryItemType = null;
            String strA1 = null;
            String strA12 = null;
            String strA13 = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strX = objectReader.X();
                strX.getClass();
                switch (strX) {
                    case "length":
                        iNextInt = objectReader.nextInt();
                        break;
                    case "filename":
                        strA12 = objectReader.a1();
                        break;
                    case "attachment_type":
                        strA13 = objectReader.a1();
                        break;
                    case "type":
                        sentryItemType = (SentryItemType) objectReader.o0(iLogger, new SentryItemType.Deserializer());
                        break;
                    case "content_type":
                        strA1 = objectReader.a1();
                        break;
                    default:
                        if (map == null) {
                            map = new HashMap();
                        }
                        objectReader.I(iLogger, map, strX);
                        break;
                }
            }
            if (sentryItemType == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"type\"");
                iLogger.b(SentryLevel.ERROR, "Missing required field \"type\"", illegalStateException);
                throw illegalStateException;
            }
            SentryEnvelopeItemHeader sentryEnvelopeItemHeader = new SentryEnvelopeItemHeader(sentryItemType, iNextInt, strA1, strA12, strA13);
            sentryEnvelopeItemHeader.f51831g = map;
            objectReader.t();
            return sentryEnvelopeItemHeader;
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    public SentryEnvelopeItemHeader(SentryItemType sentryItemType, int i2, String str, String str2, String str3) {
        this.f51827c = sentryItemType;
        this.f51825a = str;
        this.f51828d = i2;
        this.f51826b = str2;
        this.f51829e = null;
        this.f51830f = str3;
    }

    public final int a() {
        Callable callable = this.f51829e;
        if (callable == null) {
            return this.f51828d;
        }
        try {
            return ((Integer) callable.call()).intValue();
        } catch (Throwable unused) {
            return -1;
        }
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        String str = this.f51825a;
        if (str != null) {
            objectWriter.d("content_type").e(str);
        }
        String str2 = this.f51826b;
        if (str2 != null) {
            objectWriter.d("filename").e(str2);
        }
        objectWriter.d("type").h(iLogger, this.f51827c);
        String str3 = this.f51830f;
        if (str3 != null) {
            objectWriter.d("attachment_type").e(str3);
        }
        objectWriter.d("length").a(a());
        HashMap map = this.f51831g;
        if (map != null) {
            for (String str4 : map.keySet()) {
                Object obj = this.f51831g.get(str4);
                objectWriter.d(str4);
                objectWriter.h(iLogger, obj);
            }
        }
        objectWriter.t();
    }

    public SentryEnvelopeItemHeader(SentryItemType sentryItemType, Callable callable, String str, String str2, String str3) {
        Objects.b(sentryItemType, "type is required");
        this.f51827c = sentryItemType;
        this.f51825a = str;
        this.f51828d = -1;
        this.f51826b = str2;
        this.f51829e = callable;
        this.f51830f = str3;
    }
}
