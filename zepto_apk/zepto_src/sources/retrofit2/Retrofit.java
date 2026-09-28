package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.BuiltInConverters;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.converter.gson.GsonConverterFactory;

/* loaded from: classes.dex */
public final class Retrofit {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f58227a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Call.Factory f58228b;

    /* renamed from: c, reason: collision with root package name */
    public final HttpUrl f58229c;

    /* renamed from: d, reason: collision with root package name */
    public final List f58230d;

    /* renamed from: e, reason: collision with root package name */
    public final List f58231e;

    /* renamed from: f, reason: collision with root package name */
    public final Executor f58232f;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public OkHttpClient f58236a;

        /* renamed from: b, reason: collision with root package name */
        public HttpUrl f58237b;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f58238c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        public final ArrayList f58239d = new ArrayList();

        public final void a(GsonConverterFactory gsonConverterFactory) {
            this.f58238c.add(gsonConverterFactory);
        }

        public final void b(String str) {
            HttpUrl httpUrlC = HttpUrl.Companion.c(str);
            if ("".equals(httpUrlC.f56264f.get(r0.size() - 1))) {
                this.f58237b = httpUrlC;
            } else {
                throw new IllegalArgumentException("baseUrl must end in /: " + httpUrlC);
            }
        }

        public final Retrofit c() {
            if (this.f58237b == null) {
                throw new IllegalStateException("Base URL required.");
            }
            OkHttpClient okHttpClient = this.f58236a;
            if (okHttpClient == null) {
                okHttpClient = new OkHttpClient();
            }
            OkHttpClient okHttpClient2 = okHttpClient;
            Executor executor = Platform.f58181a;
            BuiltInFactories builtInFactories = Platform.f58183c;
            ArrayList arrayList = new ArrayList(this.f58239d);
            List listA = builtInFactories.a(executor);
            arrayList.addAll(listA);
            List listB = builtInFactories.b();
            int size = listB.size();
            ArrayList arrayList2 = this.f58238c;
            ArrayList arrayList3 = new ArrayList(arrayList2.size() + 1 + size);
            arrayList3.add(new BuiltInConverters());
            arrayList3.addAll(arrayList2);
            arrayList3.addAll(listB);
            HttpUrl httpUrl = this.f58237b;
            List listUnmodifiableList = Collections.unmodifiableList(arrayList3);
            List listUnmodifiableList2 = Collections.unmodifiableList(arrayList);
            listA.size();
            return new Retrofit(okHttpClient2, httpUrl, listUnmodifiableList, listUnmodifiableList2, executor);
        }
    }

    public Retrofit(Call.Factory factory, HttpUrl httpUrl, List list, List list2, Executor executor) {
        this.f58228b = factory;
        this.f58229c = httpUrl;
        this.f58230d = list;
        this.f58231e = list2;
        this.f58232f = executor;
    }

    public final CallAdapter a(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "returnType == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        List list = this.f58231e;
        int iIndexOf = list.indexOf(null) + 1;
        int size = list.size();
        for (int i2 = iIndexOf; i2 < size; i2++) {
            CallAdapter callAdapterA = ((CallAdapter.Factory) list.get(i2)).a(type, annotationArr);
            if (callAdapterA != null) {
                return callAdapterA;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
        sb.append(type);
        sb.append(".\n  Tried:");
        int size2 = list.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(((CallAdapter.Factory) list.get(iIndexOf)).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public final Object b(final Class cls) {
        if (!cls.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        }
        ArrayDeque arrayDeque = new ArrayDeque(1);
        arrayDeque.add(cls);
        while (!arrayDeque.isEmpty()) {
            Class cls2 = (Class) arrayDeque.removeFirst();
            if (cls2.getTypeParameters().length != 0) {
                StringBuilder sb = new StringBuilder("Type parameters are unsupported on ");
                sb.append(cls2.getName());
                if (cls2 != cls) {
                    sb.append(" which is an interface of ");
                    sb.append(cls.getName());
                }
                throw new IllegalArgumentException(sb.toString());
            }
            Collections.addAll(arrayDeque, cls2.getInterfaces());
        }
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: retrofit2.Retrofit.1

            /* renamed from: a, reason: collision with root package name */
            public final Object[] f58233a = new Object[0];

            /* JADX WARN: Code restructure failed: missing block: B:22:0x0040, code lost:
            
                r1 = retrofit2.ServiceMethod.b(r0, r2, r6);
             */
            /* JADX WARN: Code restructure failed: missing block: B:23:0x0044, code lost:
            
                r0.f58227a.put(r6, r1);
             */
            /* JADX WARN: Code restructure failed: missing block: B:42:0x0065, code lost:
            
                r6 = (retrofit2.ServiceMethod) r3;
             */
            /* JADX WARN: Removed duplicated region for block: B:49:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.reflect.InvocationHandler
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invoke(java.lang.Object r5, java.lang.reflect.Method r6, java.lang.Object[] r7) {
                /*
                    r4 = this;
                    java.lang.Class r0 = r6.getDeclaringClass()
                    java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
                    if (r0 != r1) goto Ld
                    java.lang.Object r5 = r6.invoke(r4, r7)
                    return r5
                Ld:
                    if (r7 == 0) goto L10
                    goto L12
                L10:
                    java.lang.Object[] r7 = r4.f58233a
                L12:
                    retrofit2.Reflection r0 = retrofit2.Platform.f58182b
                    boolean r1 = r0.c(r6)
                    java.lang.Class r2 = r2
                    if (r1 == 0) goto L21
                    java.lang.Object r5 = r0.b(r6, r2, r5, r7)
                    return r5
                L21:
                    retrofit2.Retrofit r0 = retrofit2.Retrofit.this
                L23:
                    java.util.concurrent.ConcurrentHashMap r1 = r0.f58227a
                    java.lang.Object r1 = r1.get(r6)
                    boolean r3 = r1 instanceof retrofit2.ServiceMethod
                    if (r3 == 0) goto L30
                    retrofit2.ServiceMethod r1 = (retrofit2.ServiceMethod) r1
                    goto L6a
                L30:
                    if (r1 != 0) goto L58
                    java.lang.Object r3 = new java.lang.Object
                    r3.<init>()
                    monitor-enter(r3)
                    java.util.concurrent.ConcurrentHashMap r1 = r0.f58227a     // Catch: java.lang.Throwable -> L4b
                    java.lang.Object r1 = r1.putIfAbsent(r6, r3)     // Catch: java.lang.Throwable -> L4b
                    if (r1 != 0) goto L54
                    retrofit2.HttpServiceMethod r1 = retrofit2.ServiceMethod.b(r0, r2, r6)     // Catch: java.lang.Throwable -> L4d
                    java.util.concurrent.ConcurrentHashMap r0 = r0.f58227a     // Catch: java.lang.Throwable -> L4b
                    r0.put(r6, r1)     // Catch: java.lang.Throwable -> L4b
                    monitor-exit(r3)     // Catch: java.lang.Throwable -> L4b
                    goto L6a
                L4b:
                    r5 = move-exception
                    goto L56
                L4d:
                    r5 = move-exception
                    java.util.concurrent.ConcurrentHashMap r7 = r0.f58227a     // Catch: java.lang.Throwable -> L4b
                    r7.remove(r6)     // Catch: java.lang.Throwable -> L4b
                    throw r5     // Catch: java.lang.Throwable -> L4b
                L54:
                    monitor-exit(r3)     // Catch: java.lang.Throwable -> L4b
                    goto L58
                L56:
                    monitor-exit(r3)     // Catch: java.lang.Throwable -> L4b
                    throw r5
                L58:
                    monitor-enter(r1)
                    java.util.concurrent.ConcurrentHashMap r3 = r0.f58227a     // Catch: java.lang.Throwable -> L63
                    java.lang.Object r3 = r3.get(r6)     // Catch: java.lang.Throwable -> L63
                    if (r3 != 0) goto L65
                    monitor-exit(r1)     // Catch: java.lang.Throwable -> L63
                    goto L23
                L63:
                    r5 = move-exception
                    goto L6f
                L65:
                    r6 = r3
                    retrofit2.ServiceMethod r6 = (retrofit2.ServiceMethod) r6     // Catch: java.lang.Throwable -> L63
                    monitor-exit(r1)     // Catch: java.lang.Throwable -> L63
                    r1 = r6
                L6a:
                    java.lang.Object r5 = r1.a(r7, r5)
                    return r5
                L6f:
                    monitor-exit(r1)     // Catch: java.lang.Throwable -> L63
                    throw r5
                */
                throw new UnsupportedOperationException("Method not decompiled: retrofit2.Retrofit.AnonymousClass1.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
            }
        });
    }

    public final Converter c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr2, "methodAnnotations == null");
        List list = this.f58230d;
        int iIndexOf = list.indexOf(null) + 1;
        int size = list.size();
        for (int i2 = iIndexOf; i2 < size; i2++) {
            Converter converterA = ((Converter.Factory) list.get(i2)).a(type);
            if (converterA != null) {
                return converterA;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n  Tried:");
        int size2 = list.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(((Converter.Factory) list.get(iIndexOf)).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public final Converter d(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        List list = this.f58230d;
        int iIndexOf = list.indexOf(null) + 1;
        int size = list.size();
        for (int i2 = iIndexOf; i2 < size; i2++) {
            Converter converterB = ((Converter.Factory) list.get(i2)).b(type, annotationArr, this);
            if (converterB != null) {
                return converterB;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        sb.append(".\n  Tried:");
        int size2 = list.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(((Converter.Factory) list.get(iIndexOf)).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public final Converter e(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        List list = this.f58230d;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((Converter.Factory) list.get(i2)).getClass();
        }
        return BuiltInConverters.ToStringConverter.f58079a;
    }
}
