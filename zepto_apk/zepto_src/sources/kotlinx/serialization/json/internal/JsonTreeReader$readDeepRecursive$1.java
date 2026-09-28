package kotlinx.serialization.json.internal;

import kotlin.DeepRecursiveScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.serialization.json.JsonElement;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "kotlinx.serialization.json.internal.JsonTreeReader$readDeepRecursive$1", f = "JsonTreeReader.kt", l = {WKSRecord.Service.SFTP}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class JsonTreeReader$readDeepRecursive$1 extends RestrictedSuspendLambda implements Function3<DeepRecursiveScope<Unit, JsonElement>, Unit, Continuation<? super JsonElement>, Object> {

    /* renamed from: b, reason: collision with root package name */
    public int f56074b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ DeepRecursiveScope f56075c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ JsonTreeReader f56076d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeReader$readDeepRecursive$1(JsonTreeReader jsonTreeReader, Continuation continuation) {
        super(3, continuation);
        this.f56076d = jsonTreeReader;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        JsonTreeReader$readDeepRecursive$1 jsonTreeReader$readDeepRecursive$1 = new JsonTreeReader$readDeepRecursive$1(this.f56076d, (Continuation) obj3);
        jsonTreeReader$readDeepRecursive$1.f56075c = (DeepRecursiveScope) obj;
        return jsonTreeReader$readDeepRecursive$1.invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f56074b;
        if (i2 == 0) {
            ResultKt.b(obj);
            DeepRecursiveScope deepRecursiveScope = this.f56075c;
            JsonTreeReader jsonTreeReader = this.f56076d;
            AbstractJsonLexer abstractJsonLexer = jsonTreeReader.f56071a;
            byte bU = abstractJsonLexer.u();
            if (bU == 1) {
                return jsonTreeReader.d(true);
            }
            if (bU == 0) {
                return jsonTreeReader.d(false);
            }
            if (bU != 6) {
                if (bU == 8) {
                    return jsonTreeReader.c();
                }
                AbstractJsonLexer.p(abstractJsonLexer, "Can't begin reading element, unexpected token", 0, null, 6);
                throw null;
            }
            this.f56074b = 1;
            obj = JsonTreeReader.a(jsonTreeReader, deepRecursiveScope, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return (JsonElement) obj;
    }
}
