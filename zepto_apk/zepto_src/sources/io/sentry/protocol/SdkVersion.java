package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.SentryIntegrationPackageStorage;
import io.sentry.SentryLevel;
import io.sentry.protocol.SentryPackage;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public final class SdkVersion implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public String f52895a;

    /* renamed from: b, reason: collision with root package name */
    public String f52896b;

    /* renamed from: c, reason: collision with root package name */
    public CopyOnWriteArraySet f52897c;

    /* renamed from: d, reason: collision with root package name */
    public CopyOnWriteArraySet f52898d;

    /* renamed from: e, reason: collision with root package name */
    public HashMap f52899e;

    public static final class Deserializer implements JsonDeserializer<SdkVersion> {
        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            String strX;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            objectReader.k();
            String strK0 = null;
            String strK02 = null;
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                strX = objectReader.X();
                strX.getClass();
                switch (strX) {
                    case "name":
                        strK0 = objectReader.K0();
                        break;
                    case "version":
                        strK02 = objectReader.K0();
                        break;
                    case "packages":
                        ArrayList arrayListI1 = objectReader.I1(iLogger, new SentryPackage.Deserializer());
                        if (arrayListI1 == null) {
                            break;
                        } else {
                            arrayList.addAll(arrayListI1);
                            break;
                        }
                    case "integrations":
                        List list = (List) objectReader.B1();
                        if (list == null) {
                            break;
                        } else {
                            arrayList2.addAll(list);
                            break;
                        }
                    default:
                        if (map == null) {
                            map = new HashMap();
                        }
                        objectReader.I(iLogger, map, strX);
                        break;
                }
            }
            objectReader.t();
            if (strK0 == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"name\"");
                iLogger.b(SentryLevel.ERROR, "Missing required field \"name\"", illegalStateException);
                throw illegalStateException;
            }
            if (strK02 == null) {
                IllegalStateException illegalStateException2 = new IllegalStateException("Missing required field \"version\"");
                iLogger.b(SentryLevel.ERROR, "Missing required field \"version\"", illegalStateException2);
                throw illegalStateException2;
            }
            SdkVersion sdkVersion = new SdkVersion(strK0, strK02);
            sdkVersion.f52897c = new CopyOnWriteArraySet(arrayList);
            sdkVersion.f52898d = new CopyOnWriteArraySet(arrayList2);
            sdkVersion.f52899e = map;
            return sdkVersion;
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    public SdkVersion(String str, String str2) {
        this.f52895a = str;
        this.f52896b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && SdkVersion.class == obj.getClass()) {
            SdkVersion sdkVersion = (SdkVersion) obj;
            if (this.f52895a.equals(sdkVersion.f52895a) && this.f52896b.equals(sdkVersion.f52896b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f52895a, this.f52896b});
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        objectWriter.d(CLConstants.FIELD_PAY_INFO_NAME).e(this.f52895a);
        objectWriter.d("version").e(this.f52896b);
        CopyOnWriteArraySet copyOnWriteArraySet = this.f52897c;
        if (copyOnWriteArraySet == null) {
            copyOnWriteArraySet = SentryIntegrationPackageStorage.c().f51838b;
        }
        CopyOnWriteArraySet copyOnWriteArraySet2 = this.f52898d;
        if (copyOnWriteArraySet2 == null) {
            copyOnWriteArraySet2 = SentryIntegrationPackageStorage.c().f51837a;
        }
        if (!copyOnWriteArraySet.isEmpty()) {
            objectWriter.d("packages").h(iLogger, copyOnWriteArraySet);
        }
        if (!copyOnWriteArraySet2.isEmpty()) {
            objectWriter.d("integrations").h(iLogger, copyOnWriteArraySet2);
        }
        HashMap map = this.f52899e;
        if (map != null) {
            for (String str : map.keySet()) {
                objectWriter.d(str).h(iLogger, this.f52899e.get(str));
            }
        }
        objectWriter.t();
    }
}
