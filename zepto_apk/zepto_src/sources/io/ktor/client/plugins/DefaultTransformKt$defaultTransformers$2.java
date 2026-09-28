package io.ktor.client.plugins;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2", f = "DefaultTransform.kt", l = {WKSRecord.Service.BOOTPC, WKSRecord.Service.NETRJS_2, WKSRecord.Service.NETRJS_2, 78, 78, 82, 90, 116, WKSRecord.Service.ERPC}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes.dex */
final class DefaultTransformKt$defaultTransformers$2 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public CoroutineScope f49480a;

    /* renamed from: b, reason: collision with root package name */
    public TypeInfo f49481b;

    /* renamed from: c, reason: collision with root package name */
    public int f49482c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ PipelineContext f49483d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f49484e;

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        DefaultTransformKt$defaultTransformers$2 defaultTransformKt$defaultTransformers$2 = new DefaultTransformKt$defaultTransformers$2(3, (Continuation) obj3);
        defaultTransformKt$defaultTransformers$2.f49483d = (PipelineContext) obj;
        defaultTransformKt$defaultTransformers$2.f49484e = (HttpResponseContainer) obj2;
        return defaultTransformKt$defaultTransformers$2.invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02c3  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 776
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
