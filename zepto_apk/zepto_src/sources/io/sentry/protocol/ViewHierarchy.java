package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.protocol.ViewHierarchyNode;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class ViewHierarchy implements JsonUnknown, JsonSerializable {

    /* renamed from: a, reason: collision with root package name */
    public final String f52968a;

    /* renamed from: b, reason: collision with root package name */
    public final List f52969b;

    /* renamed from: c, reason: collision with root package name */
    public HashMap f52970c;

    public static final class Deserializer implements JsonDeserializer<ViewHierarchy> {
        @Override // io.sentry.JsonDeserializer
        public final Object a(ObjectReader objectReader, ILogger iLogger) {
            objectReader.k();
            String strA1 = null;
            ArrayList arrayListI1 = null;
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strX = objectReader.X();
                strX.getClass();
                if (strX.equals("rendering_system")) {
                    strA1 = objectReader.a1();
                } else if (strX.equals("windows")) {
                    arrayListI1 = objectReader.I1(iLogger, new ViewHierarchyNode.Deserializer());
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.I(iLogger, map, strX);
                }
            }
            objectReader.t();
            ViewHierarchy viewHierarchy = new ViewHierarchy(strA1, arrayListI1);
            viewHierarchy.f52970c = map;
            return viewHierarchy;
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    public ViewHierarchy(String str, List list) {
        this.f52968a = str;
        this.f52969b = list;
    }

    @Override // io.sentry.JsonSerializable
    public final void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.k();
        String str = this.f52968a;
        if (str != null) {
            objectWriter.d("rendering_system").e(str);
        }
        List list = this.f52969b;
        if (list != null) {
            objectWriter.d("windows").h(iLogger, list);
        }
        HashMap map = this.f52970c;
        if (map != null) {
            for (String str2 : map.keySet()) {
                objectWriter.d(str2).h(iLogger, this.f52970c.get(str2));
            }
        }
        objectWriter.t();
    }
}
