package io.ktor.client;

import io.ktor.client.engine.HttpClientEngineConfig;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.util.Attributes;
import io.ktor.util.KtorDsl;
import io.ktor.util.PlatformUtils;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@KtorDsl
@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class HttpClientConfig<T extends HttpClientEngineConfig> {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f49281a = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f49282b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f49283c = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name */
    public Lambda f49284d = HttpClientConfig$engineConfig$1.f49290c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f49285e = true;

    /* renamed from: f, reason: collision with root package name */
    public boolean f49286f = true;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f49287g = PlatformUtils.f50503a;

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r1v0, types: [io.ktor.client.HttpClientConfig$engine$1, kotlin.jvm.internal.Lambda] */
    public final void a(final Function1 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        final ?? r0 = this.f49284d;
        this.f49284d = new Function1<HttpClientEngineConfig, Unit>(r0, block) { // from class: io.ktor.client.HttpClientConfig$engine$1

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Lambda f49288c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Function1 f49289d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.f49288c = (Lambda) r0;
                this.f49289d = block;
            }

            /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                HttpClientEngineConfig httpClientEngineConfig = (HttpClientEngineConfig) obj;
                Intrinsics.checkNotNullParameter(httpClientEngineConfig, "$this$null");
                this.f49288c.invoke(httpClientEngineConfig);
                this.f49289d.invoke(httpClientEngineConfig);
                return Unit.f53572a;
            }
        };
    }

    public final void b(final HttpClientPlugin plugin, final Function1 configure) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Intrinsics.checkNotNullParameter(configure, "configure");
        LinkedHashMap linkedHashMap = this.f49282b;
        final Function1 function1 = (Function1) linkedHashMap.get(plugin.getKey());
        linkedHashMap.put(plugin.getKey(), new Function1<Object, Unit>() { // from class: io.ktor.client.HttpClientConfig$install$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Intrinsics.checkNotNullParameter(obj, "$this$null");
                Function1 function12 = function1;
                if (function12 != null) {
                    function12.invoke(obj);
                }
                configure.invoke(obj);
                return Unit.f53572a;
            }
        });
        LinkedHashMap linkedHashMap2 = this.f49281a;
        if (linkedHashMap2.containsKey(plugin.getKey())) {
            return;
        }
        linkedHashMap2.put(plugin.getKey(), new Function1<HttpClient, Unit>() { // from class: io.ktor.client.HttpClientConfig$install$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                HttpClient scope = (HttpClient) obj;
                Intrinsics.checkNotNullParameter(scope, "scope");
                Attributes attributes = (Attributes) scope.f49266i.g(HttpClientPluginKt.f49537a, HttpClientConfig$install$3$attributes$1.f49295c);
                LinkedHashMap linkedHashMap3 = scope.f49268k.f49282b;
                HttpClientPlugin httpClientPlugin = plugin;
                Object obj2 = linkedHashMap3.get(httpClientPlugin.getKey());
                Intrinsics.c(obj2);
                Object objB = httpClientPlugin.b((Function1) obj2);
                httpClientPlugin.a(objB, scope);
                attributes.b(httpClientPlugin.getKey(), objB);
                return Unit.f53572a;
            }
        });
    }
}
