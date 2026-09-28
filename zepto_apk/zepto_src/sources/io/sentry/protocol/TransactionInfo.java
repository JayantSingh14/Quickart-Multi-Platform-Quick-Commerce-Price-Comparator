package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.a;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes3.dex */
public final class TransactionInfo implements JsonSerializable, JsonUnknown {

    /* renamed from: a, reason: collision with root package name */
    public final String f52957a;

    /* renamed from: b, reason: collision with root package name */
    public ConcurrentHashMap f52958b;

    public static final class Deserializer implements JsonDeserializer<TransactionInfo> {
        public static TransactionInfo b(ObjectReader objectReader, ILogger iLogger) {
            objectReader.k();
            String strA1 = null;
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strX = objectReader.X();
                strX.getClass();
                if (strX.equals("source")) {
                    strA1 = objectReader.a1();
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    objectReader.I(iLogger, concurrentHashMap, strX);
                }
            }
            TransactionInfo transactionInfo = new TransactionInfo(strA1);
            transactionInfo.f52958b = concurrentHashMap;
            objectReader.t();
            return transactionInfo;
        }

        @Override // io.sentry.JsonDeserializer
        public final /* bridge */ /* synthetic */ Object a(ObjectReader objectReader, ILogger iLogger) {
            return b(objectReader, iLogger);
        }
    }

    public static final class JsonKeys {
    }

    public TransactionInfo(String str) {
        this.f52957a = str;
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        String str = this.f52957a;
        if (str != null) {
            objectWriter.d("source").h(iLogger, str);
        }
        ConcurrentHashMap concurrentHashMap = this.f52958b;
        if (concurrentHashMap != null) {
            for (String str2 : concurrentHashMap.keySet()) {
                a.b(this.f52958b, str2, objectWriter, str2, iLogger);
            }
        }
        objectWriter.t();
    }
}
