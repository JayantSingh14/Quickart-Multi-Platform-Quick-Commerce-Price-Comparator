package coil3;

import coil3.ComponentRegistry;
import coil3.decode.Decoder;
import coil3.fetch.Fetcher;
import coil3.fetch.SourceFetchResult;
import coil3.intercept.Interceptor;
import coil3.key.Keyer;
import coil3.map.Mapper;
import coil3.request.Options;
import coil3.util.Collections_jvmCommonKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ComponentRegistry {

    @NotNull
    private final Lazy decoderFactories$delegate;

    @NotNull
    private final Lazy fetcherFactories$delegate;

    @NotNull
    private final List<Interceptor> interceptors;

    @NotNull
    private final List<Pair<Keyer<? extends Object>, KClass<? extends Object>>> keyers;

    @NotNull
    private List<? extends Function0<? extends List<? extends Decoder.Factory>>> lazyDecoderFactories;

    @NotNull
    private List<? extends Function0<? extends List<? extends Pair<? extends Fetcher.Factory<? extends Object>, ? extends KClass<? extends Object>>>>> lazyFetcherFactories;

    @NotNull
    private final List<Pair<Mapper<? extends Object, ? extends Object>, KClass<? extends Object>>> mappers;

    @Metadata
    @SourceDebugExtension
    public static final class Builder {

        @NotNull
        private final List<Interceptor> interceptors;

        @NotNull
        private final List<Pair<Keyer<? extends Object>, KClass<? extends Object>>> keyers;

        @NotNull
        private final List<Function0<List<Decoder.Factory>>> lazyDecoderFactories;

        @NotNull
        private final List<Function0<List<Pair<Fetcher.Factory<? extends Object>, KClass<? extends Object>>>>> lazyFetcherFactories;

        @NotNull
        private final List<Pair<Mapper<? extends Object, ?>, KClass<? extends Object>>> mappers;

        public Builder() {
            this.interceptors = new ArrayList();
            this.mappers = new ArrayList();
            this.keyers = new ArrayList();
            this.lazyFetcherFactories = new ArrayList();
            this.lazyDecoderFactories = new ArrayList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List add$lambda$8$lambda$7(Fetcher.Factory factory, KClass kClass) {
            return CollectionsKt.H(new Pair(factory, kClass));
        }

        @NotNull
        public final Builder add(@NotNull Interceptor interceptor) {
            this.interceptors.add(interceptor);
            return this;
        }

        @NotNull
        public final Builder addDecoderFactories(@NotNull Function0<? extends List<? extends Decoder.Factory>> function0) {
            this.lazyDecoderFactories.add(function0);
            return this;
        }

        @NotNull
        public final Builder addFetcherFactories(@NotNull Function0<? extends List<? extends Pair<? extends Fetcher.Factory<? extends Object>, ? extends KClass<? extends Object>>>> function0) {
            this.lazyFetcherFactories.add(function0);
            return this;
        }

        @NotNull
        public final ComponentRegistry build() {
            return new ComponentRegistry(Collections_jvmCommonKt.toImmutableList(this.interceptors), Collections_jvmCommonKt.toImmutableList(this.mappers), Collections_jvmCommonKt.toImmutableList(this.keyers), Collections_jvmCommonKt.toImmutableList(this.lazyFetcherFactories), Collections_jvmCommonKt.toImmutableList(this.lazyDecoderFactories), null);
        }

        @NotNull
        public final List<Interceptor> getInterceptors$coil_core_release() {
            return this.interceptors;
        }

        @NotNull
        public final List<Pair<Keyer<? extends Object>, KClass<? extends Object>>> getKeyers$coil_core_release() {
            return this.keyers;
        }

        @NotNull
        public final List<Function0<List<Decoder.Factory>>> getLazyDecoderFactories$coil_core_release() {
            return this.lazyDecoderFactories;
        }

        @NotNull
        public final List<Function0<List<Pair<Fetcher.Factory<? extends Object>, KClass<? extends Object>>>>> getLazyFetcherFactories$coil_core_release() {
            return this.lazyFetcherFactories;
        }

        @NotNull
        public final List<Pair<Mapper<? extends Object, ?>, KClass<? extends Object>>> getMappers$coil_core_release() {
            return this.mappers;
        }

        @NotNull
        public final <T> Builder add(@NotNull Mapper<T, ?> mapper, @NotNull KClass<T> kClass) {
            this.mappers.add(new Pair<>(mapper, kClass));
            return this;
        }

        @NotNull
        public final <T> Builder add(@NotNull Keyer<T> keyer, @NotNull KClass<T> kClass) {
            this.keyers.add(new Pair<>(keyer, kClass));
            return this;
        }

        public Builder(@NotNull ComponentRegistry componentRegistry) {
            this.interceptors = CollectionsKt.f0(componentRegistry.getInterceptors());
            this.mappers = CollectionsKt.f0(componentRegistry.getMappers());
            this.keyers = CollectionsKt.f0(componentRegistry.getKeyers());
            List<Pair<Fetcher.Factory<? extends Object>, KClass<? extends Object>>> fetcherFactories = componentRegistry.getFetcherFactories();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = fetcherFactories.iterator();
            while (it.hasNext()) {
                arrayList.add(new defpackage.b((Pair) it.next(), 2));
            }
            this.lazyFetcherFactories = arrayList;
            List<Decoder.Factory> decoderFactories = componentRegistry.getDecoderFactories();
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it2 = decoderFactories.iterator();
            while (it2.hasNext()) {
                arrayList2.add(new b((Decoder.Factory) it2.next(), 0));
            }
            this.lazyDecoderFactories = arrayList2;
        }

        @NotNull
        public final <T> Builder add(@NotNull final Fetcher.Factory<T> factory, @NotNull final KClass<T> kClass) {
            this.lazyFetcherFactories.add(new Function0() { // from class: coil3.c
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ComponentRegistry.Builder.add$lambda$8$lambda$7(factory, kClass);
                }
            });
            return this;
        }

        @NotNull
        public final Builder add(@NotNull Decoder.Factory factory) {
            this.lazyDecoderFactories.add(new b(factory, 1));
            return this;
        }

        public final <T> Builder add(Fetcher.Factory<T> factory) {
            Intrinsics.g();
            throw null;
        }

        public final <T> Builder add(Keyer<T> keyer) {
            Intrinsics.g();
            throw null;
        }

        public final <T> Builder add(Mapper<T, ?> mapper) {
            Intrinsics.g();
            throw null;
        }
    }

    public /* synthetic */ ComponentRegistry(List list, List list2, List list3, List list4, List list5, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, list3, list4, list5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List decoderFactories_delegate$lambda$5(ComponentRegistry componentRegistry) {
        List<? extends Function0<? extends List<? extends Decoder.Factory>>> list = componentRegistry.lazyDecoderFactories;
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            CollectionsKt.i(arrayList, (List) list.get(i2).invoke());
        }
        componentRegistry.lazyDecoderFactories = EmptyList.f53609a;
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List fetcherFactories_delegate$lambda$2(ComponentRegistry componentRegistry) {
        List<? extends Function0<? extends List<? extends Pair<? extends Fetcher.Factory<? extends Object>, ? extends KClass<? extends Object>>>>> list = componentRegistry.lazyFetcherFactories;
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            CollectionsKt.i(arrayList, (List) list.get(i2).invoke());
        }
        componentRegistry.lazyFetcherFactories = EmptyList.f53609a;
        return arrayList;
    }

    public static /* synthetic */ Pair newDecoder$default(ComponentRegistry componentRegistry, SourceFetchResult sourceFetchResult, Options options, ImageLoader imageLoader, int i2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return componentRegistry.newDecoder(sourceFetchResult, options, imageLoader, i2);
    }

    public static /* synthetic */ Pair newFetcher$default(ComponentRegistry componentRegistry, Object obj, Options options, ImageLoader imageLoader, int i2, int i3, Object obj2) {
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return componentRegistry.newFetcher(obj, options, imageLoader, i2);
    }

    @NotNull
    public final List<Decoder.Factory> getDecoderFactories() {
        return (List) this.decoderFactories$delegate.getValue();
    }

    @NotNull
    public final List<Pair<Fetcher.Factory<? extends Object>, KClass<? extends Object>>> getFetcherFactories() {
        return (List) this.fetcherFactories$delegate.getValue();
    }

    @NotNull
    public final List<Interceptor> getInterceptors() {
        return this.interceptors;
    }

    @NotNull
    public final List<Pair<Keyer<? extends Object>, KClass<? extends Object>>> getKeyers() {
        return this.keyers;
    }

    @NotNull
    public final List<Pair<Mapper<? extends Object, ? extends Object>, KClass<? extends Object>>> getMappers() {
        return this.mappers;
    }

    @Nullable
    public final String key(@NotNull Object obj, @NotNull Options options) {
        List<Pair<Keyer<? extends Object>, KClass<? extends Object>>> list = this.keyers;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Pair<Keyer<? extends Object>, KClass<? extends Object>> pair = list.get(i2);
            Keyer keyer = (Keyer) pair.f53533a;
            if (((KClass) pair.f53534b).h(obj)) {
                Intrinsics.d(keyer, "null cannot be cast to non-null type coil3.key.Keyer<kotlin.Any>");
                String strKey = keyer.key(obj, options);
                if (strKey != null) {
                    return strKey;
                }
            }
        }
        return null;
    }

    @NotNull
    public final Object map(@NotNull Object obj, @NotNull Options options) {
        List<Pair<Mapper<? extends Object, ? extends Object>, KClass<? extends Object>>> list = this.mappers;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Pair<Mapper<? extends Object, ? extends Object>, KClass<? extends Object>> pair = list.get(i2);
            Mapper mapper = (Mapper) pair.f53533a;
            if (((KClass) pair.f53534b).h(obj)) {
                Intrinsics.d(mapper, "null cannot be cast to non-null type coil3.map.Mapper<kotlin.Any, *>");
                Object map = mapper.map(obj, options);
                if (map != null) {
                    obj = map;
                }
            }
        }
        return obj;
    }

    @NotNull
    public final Builder newBuilder() {
        return new Builder(this);
    }

    @JvmOverloads
    @Nullable
    public final Pair<Decoder, Integer> newDecoder(@NotNull SourceFetchResult sourceFetchResult, @NotNull Options options, @NotNull ImageLoader imageLoader) {
        return newDecoder$default(this, sourceFetchResult, options, imageLoader, 0, 8, null);
    }

    @JvmOverloads
    @Nullable
    public final Pair<Fetcher, Integer> newFetcher(@NotNull Object obj, @NotNull Options options, @NotNull ImageLoader imageLoader) {
        return newFetcher$default(this, obj, options, imageLoader, 0, 8, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ComponentRegistry(List<? extends Interceptor> list, List<? extends Pair<? extends Mapper<? extends Object, ? extends Object>, ? extends KClass<? extends Object>>> list2, List<? extends Pair<? extends Keyer<? extends Object>, ? extends KClass<? extends Object>>> list3, List<? extends Function0<? extends List<? extends Pair<? extends Fetcher.Factory<? extends Object>, ? extends KClass<? extends Object>>>>> list4, List<? extends Function0<? extends List<? extends Decoder.Factory>>> list5) {
        this.interceptors = list;
        this.mappers = list2;
        this.keyers = list3;
        this.lazyFetcherFactories = list4;
        this.lazyDecoderFactories = list5;
        final int i2 = 0;
        this.fetcherFactories$delegate = LazyKt.b(new Function0(this) { // from class: coil3.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ComponentRegistry f13856b;

            {
                this.f13856b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                switch (i2) {
                    case 0:
                        return ComponentRegistry.fetcherFactories_delegate$lambda$2(this.f13856b);
                    default:
                        return ComponentRegistry.decoderFactories_delegate$lambda$5(this.f13856b);
                }
            }
        });
        final int i3 = 1;
        this.decoderFactories$delegate = LazyKt.b(new Function0(this) { // from class: coil3.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ComponentRegistry f13856b;

            {
                this.f13856b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                switch (i3) {
                    case 0:
                        return ComponentRegistry.fetcherFactories_delegate$lambda$2(this.f13856b);
                    default:
                        return ComponentRegistry.decoderFactories_delegate$lambda$5(this.f13856b);
                }
            }
        });
    }

    @JvmOverloads
    @Nullable
    public final Pair<Decoder, Integer> newDecoder(@NotNull SourceFetchResult sourceFetchResult, @NotNull Options options, @NotNull ImageLoader imageLoader, int i2) {
        int size = getDecoderFactories().size();
        while (i2 < size) {
            Decoder decoderCreate = getDecoderFactories().get(i2).create(sourceFetchResult, options, imageLoader);
            if (decoderCreate != null) {
                return new Pair<>(decoderCreate, Integer.valueOf(i2));
            }
            i2++;
        }
        return null;
    }

    @JvmOverloads
    @Nullable
    public final Pair<Fetcher, Integer> newFetcher(@NotNull Object obj, @NotNull Options options, @NotNull ImageLoader imageLoader, int i2) {
        int size = getFetcherFactories().size();
        while (i2 < size) {
            Pair<Fetcher.Factory<? extends Object>, KClass<? extends Object>> pair = getFetcherFactories().get(i2);
            Fetcher.Factory factory = (Fetcher.Factory) pair.f53533a;
            if (((KClass) pair.f53534b).h(obj)) {
                Intrinsics.d(factory, "null cannot be cast to non-null type coil3.fetch.Fetcher.Factory<kotlin.Any>");
                Fetcher fetcherCreate = factory.create(obj, options, imageLoader);
                if (fetcherCreate != null) {
                    return new Pair<>(fetcherCreate, Integer.valueOf(i2));
                }
            }
            i2++;
        }
        return null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ComponentRegistry() {
        EmptyList emptyList = EmptyList.f53609a;
        this(emptyList, emptyList, emptyList, emptyList, emptyList);
    }
}
