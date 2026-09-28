package kotlinx.serialization.json.internal;

import java.util.LinkedHashMap;
import kotlin.DeepRecursiveScope;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "kotlinx.serialization.json.internal.JsonTreeReader", f = "JsonTreeReader.kt", l = {24}, m = "readObject")
/* loaded from: classes3.dex */
final class JsonTreeReader$readObject$2 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public DeepRecursiveScope f56077a;

    /* renamed from: b, reason: collision with root package name */
    public JsonTreeReader f56078b;

    /* renamed from: c, reason: collision with root package name */
    public LinkedHashMap f56079c;

    /* renamed from: d, reason: collision with root package name */
    public String f56080d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f56081e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ JsonTreeReader f56082f;

    /* renamed from: g, reason: collision with root package name */
    public int f56083g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeReader$readObject$2(JsonTreeReader jsonTreeReader, BaseContinuationImpl baseContinuationImpl) {
        super(baseContinuationImpl);
        this.f56082f = jsonTreeReader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f56081e = obj;
        this.f56083g |= Integer.MIN_VALUE;
        return JsonTreeReader.a(this.f56082f, null, this);
    }
}
