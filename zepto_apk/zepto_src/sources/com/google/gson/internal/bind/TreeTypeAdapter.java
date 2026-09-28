package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.zeptoconsumerapp.modules.configservice.entity.ResolvedConfig;
import com.zeptoconsumerapp.modules.configservice.entity.ResolvedConfigDataAdapter;
import java.io.IOException;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public final class TreeTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {

    /* renamed from: a, reason: collision with root package name */
    public final JsonSerializer f45395a;

    /* renamed from: b, reason: collision with root package name */
    public final JsonDeserializer f45396b;

    /* renamed from: c, reason: collision with root package name */
    public final Gson f45397c;

    /* renamed from: d, reason: collision with root package name */
    public final TypeToken f45398d;

    /* renamed from: e, reason: collision with root package name */
    public final TypeAdapterFactory f45399e;

    /* renamed from: f, reason: collision with root package name */
    public final GsonContextImpl f45400f = new GsonContextImpl();

    /* renamed from: g, reason: collision with root package name */
    public final boolean f45401g;

    /* renamed from: h, reason: collision with root package name */
    public volatile TypeAdapter f45402h;

    public final class GsonContextImpl implements JsonSerializationContext, JsonDeserializationContext {
        public GsonContextImpl() {
        }

        @Override // com.google.gson.JsonSerializationContext
        public final JsonElement a(ResolvedConfig resolvedConfig) {
            return TreeTypeAdapter.this.f45397c.m(resolvedConfig);
        }

        @Override // com.google.gson.JsonDeserializationContext
        public final Object b(JsonElement jsonElement) {
            Gson gson = TreeTypeAdapter.this.f45397c;
            gson.getClass();
            TypeToken typeToken = new TypeToken(ResolvedConfig.class);
            if (jsonElement == null) {
                return null;
            }
            JsonTreeReader jsonTreeReader = new JsonTreeReader(JsonTreeReader.t);
            jsonTreeReader.p = new Object[32];
            jsonTreeReader.q = 0;
            jsonTreeReader.r = new String[32];
            jsonTreeReader.s = new int[32];
            jsonTreeReader.l1(jsonElement);
            return gson.b(jsonTreeReader, typeToken);
        }
    }

    public static final class SingleTypeFactory implements TypeAdapterFactory {

        /* renamed from: a, reason: collision with root package name */
        public final TypeToken f45404a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f45405b;

        /* renamed from: c, reason: collision with root package name */
        public final JsonSerializer f45406c;

        /* renamed from: d, reason: collision with root package name */
        public final JsonDeserializer f45407d;

        public SingleTypeFactory(ResolvedConfigDataAdapter resolvedConfigDataAdapter, TypeToken typeToken, boolean z) {
            this.f45406c = resolvedConfigDataAdapter;
            this.f45407d = resolvedConfigDataAdapter;
            this.f45404a = typeToken;
            this.f45405b = z;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0013, code lost:
        
            if (r0.f45460b == r12.f45459a) goto L12;
         */
        @Override // com.google.gson.TypeAdapterFactory
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final com.google.gson.TypeAdapter a(com.google.gson.Gson r11, com.google.gson.reflect.TypeToken r12) {
            /*
                r10 = this;
                com.google.gson.reflect.TypeToken r0 = r10.f45404a
                r1 = 0
                if (r0 == 0) goto L25
                boolean r2 = r0.equals(r12)
                if (r2 != 0) goto L17
                boolean r2 = r10.f45405b
                if (r2 == 0) goto L16
                java.lang.Class r2 = r12.f45459a
                java.lang.reflect.Type r0 = r0.f45460b
                if (r0 != r2) goto L16
                goto L17
            L16:
                return r1
            L17:
                com.google.gson.internal.bind.TreeTypeAdapter r3 = new com.google.gson.internal.bind.TreeTypeAdapter
                com.google.gson.JsonSerializer r4 = r10.f45406c
                com.google.gson.JsonDeserializer r5 = r10.f45407d
                r9 = 1
                r8 = r10
                r6 = r11
                r7 = r12
                r3.<init>(r4, r5, r6, r7, r8, r9)
                return r3
            L25:
                r7 = r12
                java.lang.Class r11 = r7.f45459a
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.TreeTypeAdapter.SingleTypeFactory.a(com.google.gson.Gson, com.google.gson.reflect.TypeToken):com.google.gson.TypeAdapter");
        }
    }

    public TreeTypeAdapter(JsonSerializer jsonSerializer, JsonDeserializer jsonDeserializer, Gson gson, TypeToken typeToken, TypeAdapterFactory typeAdapterFactory, boolean z) {
        this.f45395a = jsonSerializer;
        this.f45396b = jsonDeserializer;
        this.f45397c = gson;
        this.f45398d = typeToken;
        this.f45399e = typeAdapterFactory;
        this.f45401g = z;
    }

    public static TypeAdapterFactory e(TypeToken typeToken, ResolvedConfigDataAdapter resolvedConfigDataAdapter) {
        return new SingleTypeFactory(resolvedConfigDataAdapter, typeToken, typeToken.f45460b == typeToken.f45459a);
    }

    @Override // com.google.gson.TypeAdapter
    public final Object b(JsonReader jsonReader) {
        JsonDeserializer jsonDeserializer = this.f45396b;
        if (jsonDeserializer == null) {
            TypeAdapter typeAdapterG = this.f45402h;
            if (typeAdapterG == null) {
                typeAdapterG = this.f45397c.g(this.f45399e, this.f45398d);
                this.f45402h = typeAdapterG;
            }
            return typeAdapterG.b(jsonReader);
        }
        JsonElement jsonElementA = Streams.a(jsonReader);
        if (this.f45401g) {
            jsonElementA.getClass();
            if (jsonElementA instanceof JsonNull) {
                return null;
            }
        }
        Type type = this.f45398d.f45460b;
        return jsonDeserializer.a(jsonElementA, this.f45400f);
    }

    @Override // com.google.gson.TypeAdapter
    public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
        JsonSerializer jsonSerializer = this.f45395a;
        if (jsonSerializer == null) {
            TypeAdapter typeAdapterG = this.f45402h;
            if (typeAdapterG == null) {
                typeAdapterG = this.f45397c.g(this.f45399e, this.f45398d);
                this.f45402h = typeAdapterG;
            }
            typeAdapterG.c(jsonWriter, obj);
            return;
        }
        if (this.f45401g && obj == null) {
            jsonWriter.s();
            return;
        }
        Type type = this.f45398d.f45460b;
        TypeAdapters.z.c(jsonWriter, jsonSerializer.b(obj, this.f45400f));
    }

    @Override // com.google.gson.internal.bind.SerializationDelegatingTypeAdapter
    public final TypeAdapter d() {
        if (this.f45395a != null) {
            return this;
        }
        TypeAdapter typeAdapter = this.f45402h;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter typeAdapterG = this.f45397c.g(this.f45399e, this.f45398d);
        this.f45402h = typeAdapterG;
        return typeAdapterG;
    }
}
