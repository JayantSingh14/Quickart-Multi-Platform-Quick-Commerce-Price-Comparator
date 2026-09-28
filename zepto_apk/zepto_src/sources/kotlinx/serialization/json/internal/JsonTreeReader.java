package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.DeepRecursiveFunction;
import kotlin.DeepRecursiveKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class JsonTreeReader {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractJsonLexer f56071a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f56072b;

    /* renamed from: c, reason: collision with root package name */
    public int f56073c;

    public JsonTreeReader(JsonConfiguration configuration, AbstractJsonLexer lexer) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(lexer, "lexer");
        this.f56071a = lexer;
        this.f56072b = configuration.f55968c;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(kotlinx.serialization.json.internal.JsonTreeReader r10, kotlin.DeepRecursiveScope r11, kotlin.coroutines.jvm.internal.BaseContinuationImpl r12) {
        /*
            boolean r0 = r12 instanceof kotlinx.serialization.json.internal.JsonTreeReader$readObject$2
            if (r0 == 0) goto L13
            r0 = r12
            kotlinx.serialization.json.internal.JsonTreeReader$readObject$2 r0 = (kotlinx.serialization.json.internal.JsonTreeReader$readObject$2) r0
            int r1 = r0.f56083g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f56083g = r1
            goto L18
        L13:
            kotlinx.serialization.json.internal.JsonTreeReader$readObject$2 r0 = new kotlinx.serialization.json.internal.JsonTreeReader$readObject$2
            r0.<init>(r10, r12)
        L18:
            java.lang.Object r12 = r0.f56081e
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f56083g
            r3 = 0
            r4 = 6
            r5 = 0
            r6 = 7
            r7 = 4
            r8 = 1
            if (r2 == 0) goto L59
            if (r2 != r8) goto L51
            java.lang.String r10 = r0.f56080d
            java.util.LinkedHashMap r11 = r0.f56079c
            kotlinx.serialization.json.internal.JsonTreeReader r2 = r0.f56078b
            kotlin.DeepRecursiveScope r9 = r0.f56077a
            kotlin.ResultKt.b(r12)
            kotlinx.serialization.json.JsonElement r12 = (kotlinx.serialization.json.JsonElement) r12
            r11.put(r10, r12)
            kotlinx.serialization.json.internal.AbstractJsonLexer r10 = r2.f56071a
            byte r10 = r10.f()
            if (r10 == r7) goto L4b
            if (r10 != r6) goto L43
            goto L9a
        L43:
            kotlinx.serialization.json.internal.AbstractJsonLexer r10 = r2.f56071a
            java.lang.String r11 = "Expected end of the object or comma"
            kotlinx.serialization.json.internal.AbstractJsonLexer.p(r10, r11, r3, r5, r4)
            throw r5
        L4b:
            r12 = r2
            r2 = r10
            r10 = r12
            r12 = r11
            r11 = r9
            goto L6d
        L51:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L59:
            kotlin.ResultKt.b(r12)
            kotlinx.serialization.json.internal.AbstractJsonLexer r12 = r10.f56071a
            byte r2 = r12.g(r4)
            byte r9 = r12.u()
            if (r9 == r7) goto Lae
            java.util.LinkedHashMap r12 = new java.util.LinkedHashMap
            r12.<init>()
        L6d:
            kotlinx.serialization.json.internal.AbstractJsonLexer r3 = r10.f56071a
            boolean r9 = r3.c()
            if (r9 == 0) goto L96
            boolean r2 = r10.f56072b
            if (r2 == 0) goto L7e
            java.lang.String r2 = r3.k()
            goto L82
        L7e:
            java.lang.String r2 = r3.j()
        L82:
            r4 = 5
            r3.g(r4)
            kotlin.Unit r3 = kotlin.Unit.f53572a
            r0.f56077a = r11
            r0.f56078b = r10
            r0.f56079c = r12
            r0.f56080d = r2
            r0.f56083g = r8
            r11.a(r3, r0)
            return r1
        L96:
            r11 = r2
            r2 = r10
            r10 = r11
            r11 = r12
        L9a:
            kotlinx.serialization.json.internal.AbstractJsonLexer r12 = r2.f56071a
            if (r10 != r4) goto La2
            r12.g(r6)
            goto La4
        La2:
            if (r10 == r7) goto Laa
        La4:
            kotlinx.serialization.json.JsonObject r10 = new kotlinx.serialization.json.JsonObject
            r10.<init>(r11)
            return r10
        Laa:
            kotlinx.serialization.json.internal.JsonExceptionsKt.f(r12)
            throw r5
        Lae:
            java.lang.String r10 = "Unexpected leading comma"
            kotlinx.serialization.json.internal.AbstractJsonLexer.p(r12, r10, r3, r5, r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.JsonTreeReader.a(kotlinx.serialization.json.internal.JsonTreeReader, kotlin.DeepRecursiveScope, kotlin.coroutines.jvm.internal.BaseContinuationImpl):java.lang.Object");
    }

    public final JsonElement b() {
        JsonElement jsonObject;
        AbstractJsonLexer abstractJsonLexer = this.f56071a;
        byte bU = abstractJsonLexer.u();
        if (bU == 1) {
            return d(true);
        }
        if (bU == 0) {
            return d(false);
        }
        if (bU != 6) {
            if (bU == 8) {
                return c();
            }
            AbstractJsonLexer.p(abstractJsonLexer, "Cannot read Json element because of unexpected ".concat(AbstractJsonLexerKt.b(bU)), 0, null, 6);
            throw null;
        }
        int i2 = this.f56073c + 1;
        this.f56073c = i2;
        if (i2 == 200) {
            jsonObject = (JsonElement) DeepRecursiveKt.a(new DeepRecursiveFunction(new JsonTreeReader$readDeepRecursive$1(this, null)), Unit.f53572a);
        } else {
            byte bG = abstractJsonLexer.g((byte) 6);
            if (abstractJsonLexer.u() == 4) {
                AbstractJsonLexer.p(abstractJsonLexer, "Unexpected leading comma", 0, null, 6);
                throw null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            while (true) {
                if (!abstractJsonLexer.c()) {
                    break;
                }
                String strK = this.f56072b ? abstractJsonLexer.k() : abstractJsonLexer.j();
                abstractJsonLexer.g((byte) 5);
                linkedHashMap.put(strK, b());
                bG = abstractJsonLexer.f();
                if (bG != 4) {
                    if (bG != 7) {
                        AbstractJsonLexer.p(abstractJsonLexer, "Expected end of the object or comma", 0, null, 6);
                        throw null;
                    }
                }
            }
            if (bG == 6) {
                abstractJsonLexer.g((byte) 7);
            } else if (bG == 4) {
                JsonExceptionsKt.f(abstractJsonLexer);
                throw null;
            }
            jsonObject = new JsonObject(linkedHashMap);
        }
        this.f56073c--;
        return jsonObject;
    }

    public final JsonArray c() {
        AbstractJsonLexer abstractJsonLexer = this.f56071a;
        byte bF = abstractJsonLexer.f();
        if (abstractJsonLexer.u() == 4) {
            AbstractJsonLexer.p(abstractJsonLexer, "Unexpected leading comma", 0, null, 6);
            throw null;
        }
        ArrayList arrayList = new ArrayList();
        while (abstractJsonLexer.c()) {
            arrayList.add(b());
            bF = abstractJsonLexer.f();
            if (bF != 4) {
                boolean z = bF == 9;
                int i2 = abstractJsonLexer.f56006a;
                if (!z) {
                    AbstractJsonLexer.p(abstractJsonLexer, "Expected end of the array or comma", i2, null, 4);
                    throw null;
                }
            }
        }
        if (bF == 8) {
            abstractJsonLexer.g((byte) 9);
        } else if (bF == 4) {
            JsonExceptionsKt.e(abstractJsonLexer, "array");
            throw null;
        }
        return new JsonArray(arrayList);
    }

    public final JsonPrimitive d(boolean z) {
        boolean z2 = this.f56072b;
        AbstractJsonLexer abstractJsonLexer = this.f56071a;
        String strK = (z2 || !z) ? abstractJsonLexer.k() : abstractJsonLexer.j();
        return (z || !Intrinsics.b(strK, "null")) ? new JsonLiteral(strK, z, null) : JsonNull.INSTANCE;
    }
}
