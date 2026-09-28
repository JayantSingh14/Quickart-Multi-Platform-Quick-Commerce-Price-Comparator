package com.google.firebase.encoders.json;

import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import com.google.firebase.encoders.config.EncoderConfig;
import j$.util.DesugarTimeZone;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes.dex */
public final class JsonDataEncoderBuilder implements EncoderConfig<JsonDataEncoderBuilder> {

    /* renamed from: f, reason: collision with root package name */
    public static final b f44499f;

    /* renamed from: g, reason: collision with root package name */
    public static final b f44500g;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f44502a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f44503b;

    /* renamed from: c, reason: collision with root package name */
    public final a f44504c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f44505d;

    /* renamed from: e, reason: collision with root package name */
    public static final a f44498e = new a();

    /* renamed from: h, reason: collision with root package name */
    public static final TimestampEncoder f44501h = new TimestampEncoder();

    public static final class TimestampEncoder implements ValueEncoder<Date> {

        /* renamed from: a, reason: collision with root package name */
        public static final SimpleDateFormat f44507a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            f44507a = simpleDateFormat;
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        }

        @Override // com.google.firebase.encoders.ValueEncoder
        public final void a(Object obj, Object obj2) {
            ((ValueEncoderContext) obj2).e(f44507a.format((Date) obj));
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.firebase.encoders.json.b] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.firebase.encoders.json.b] */
    static {
        final int i2 = 0;
        f44499f = new ValueEncoder() { // from class: com.google.firebase.encoders.json.b
            @Override // com.google.firebase.encoders.ValueEncoder
            public final void a(Object obj, Object obj2) {
                switch (i2) {
                    case 0:
                        a aVar = JsonDataEncoderBuilder.f44498e;
                        ((ValueEncoderContext) obj2).e((String) obj);
                        break;
                    default:
                        a aVar2 = JsonDataEncoderBuilder.f44498e;
                        ((ValueEncoderContext) obj2).g(((Boolean) obj).booleanValue());
                        break;
                }
            }
        };
        final int i3 = 1;
        f44500g = new ValueEncoder() { // from class: com.google.firebase.encoders.json.b
            @Override // com.google.firebase.encoders.ValueEncoder
            public final void a(Object obj, Object obj2) {
                switch (i3) {
                    case 0:
                        a aVar = JsonDataEncoderBuilder.f44498e;
                        ((ValueEncoderContext) obj2).e((String) obj);
                        break;
                    default:
                        a aVar2 = JsonDataEncoderBuilder.f44498e;
                        ((ValueEncoderContext) obj2).g(((Boolean) obj).booleanValue());
                        break;
                }
            }
        };
    }

    public JsonDataEncoderBuilder() {
        HashMap map = new HashMap();
        this.f44502a = map;
        HashMap map2 = new HashMap();
        this.f44503b = map2;
        this.f44504c = f44498e;
        this.f44505d = false;
        map2.put(String.class, f44499f);
        map.remove(String.class);
        map2.put(Boolean.class, f44500g);
        map.remove(Boolean.class);
        map2.put(Date.class, f44501h);
        map.remove(Date.class);
    }

    public final DataEncoder a() {
        return new DataEncoder() { // from class: com.google.firebase.encoders.json.JsonDataEncoderBuilder.1
            @Override // com.google.firebase.encoders.DataEncoder
            public final void a(Writer writer, Object obj) throws IOException {
                JsonDataEncoderBuilder jsonDataEncoderBuilder = JsonDataEncoderBuilder.this;
                JsonValueObjectEncoderContext jsonValueObjectEncoderContext = new JsonValueObjectEncoderContext(writer, jsonDataEncoderBuilder.f44502a, jsonDataEncoderBuilder.f44503b, jsonDataEncoderBuilder.f44504c, jsonDataEncoderBuilder.f44505d);
                jsonValueObjectEncoderContext.h(obj);
                jsonValueObjectEncoderContext.j();
                jsonValueObjectEncoderContext.f44509b.flush();
            }

            @Override // com.google.firebase.encoders.DataEncoder
            public final String encode(Object obj) {
                StringWriter stringWriter = new StringWriter();
                try {
                    a(stringWriter, obj);
                } catch (IOException unused) {
                }
                return stringWriter.toString();
            }
        };
    }

    public final EncoderConfig b(Class cls, ObjectEncoder objectEncoder) {
        this.f44502a.put(cls, objectEncoder);
        this.f44503b.remove(cls);
        return this;
    }
}
