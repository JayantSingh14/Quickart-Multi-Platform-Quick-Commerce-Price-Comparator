package com.google.firebase.concurrent;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.StrictMode;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.annotations.concurrent.UiThread;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Lazy;
import com.google.firebase.components.Qualified;
import com.google.firebase.inject.Provider;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@SuppressLint({"ThreadPoolCreation"})
/* loaded from: classes.dex */
public class ExecutorsRegistrar implements ComponentRegistrar {

    /* renamed from: a, reason: collision with root package name */
    public static final Lazy f43634a;

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f43635b;

    /* renamed from: c, reason: collision with root package name */
    public static final Lazy f43636c;

    /* renamed from: d, reason: collision with root package name */
    public static final Lazy f43637d;

    static {
        final int i2 = 0;
        f43634a = new Lazy(new Provider() { // from class: com.google.firebase.concurrent.g
            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                switch (i2) {
                    case 0:
                        Lazy lazy = ExecutorsRegistrar.f43634a;
                        StrictMode.ThreadPolicy.Builder builderDetectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
                        int i3 = Build.VERSION.SDK_INT;
                        builderDetectNetwork.detectResourceMismatches();
                        if (i3 >= 26) {
                            builderDetectNetwork.detectUnbufferedIo();
                        }
                        return new DelegatingScheduledExecutorService(Executors.newFixedThreadPool(4, new CustomThreadFactory("Firebase Background", 10, builderDetectNetwork.penaltyLog().build())), (ScheduledExecutorService) ExecutorsRegistrar.f43637d.get());
                    case 1:
                        Lazy lazy2 = ExecutorsRegistrar.f43634a;
                        return new DelegatingScheduledExecutorService(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors()), new CustomThreadFactory("Firebase Lite", 0, new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build())), (ScheduledExecutorService) ExecutorsRegistrar.f43637d.get());
                    case 2:
                        Lazy lazy3 = ExecutorsRegistrar.f43634a;
                        return new DelegatingScheduledExecutorService(Executors.newCachedThreadPool(new CustomThreadFactory("Firebase Blocking", 11, null)), (ScheduledExecutorService) ExecutorsRegistrar.f43637d.get());
                    default:
                        Lazy lazy4 = ExecutorsRegistrar.f43634a;
                        return Executors.newSingleThreadScheduledExecutor(new CustomThreadFactory("Firebase Scheduler", 0, null));
                }
            }
        });
        final int i3 = 1;
        f43635b = new Lazy(new Provider() { // from class: com.google.firebase.concurrent.g
            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                switch (i3) {
                    case 0:
                        Lazy lazy = ExecutorsRegistrar.f43634a;
                        StrictMode.ThreadPolicy.Builder builderDetectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
                        int i32 = Build.VERSION.SDK_INT;
                        builderDetectNetwork.detectResourceMismatches();
                        if (i32 >= 26) {
                            builderDetectNetwork.detectUnbufferedIo();
                        }
                        return new DelegatingScheduledExecutorService(Executors.newFixedThreadPool(4, new CustomThreadFactory("Firebase Background", 10, builderDetectNetwork.penaltyLog().build())), (ScheduledExecutorService) ExecutorsRegistrar.f43637d.get());
                    case 1:
                        Lazy lazy2 = ExecutorsRegistrar.f43634a;
                        return new DelegatingScheduledExecutorService(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors()), new CustomThreadFactory("Firebase Lite", 0, new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build())), (ScheduledExecutorService) ExecutorsRegistrar.f43637d.get());
                    case 2:
                        Lazy lazy3 = ExecutorsRegistrar.f43634a;
                        return new DelegatingScheduledExecutorService(Executors.newCachedThreadPool(new CustomThreadFactory("Firebase Blocking", 11, null)), (ScheduledExecutorService) ExecutorsRegistrar.f43637d.get());
                    default:
                        Lazy lazy4 = ExecutorsRegistrar.f43634a;
                        return Executors.newSingleThreadScheduledExecutor(new CustomThreadFactory("Firebase Scheduler", 0, null));
                }
            }
        });
        final int i4 = 2;
        f43636c = new Lazy(new Provider() { // from class: com.google.firebase.concurrent.g
            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                switch (i4) {
                    case 0:
                        Lazy lazy = ExecutorsRegistrar.f43634a;
                        StrictMode.ThreadPolicy.Builder builderDetectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
                        int i32 = Build.VERSION.SDK_INT;
                        builderDetectNetwork.detectResourceMismatches();
                        if (i32 >= 26) {
                            builderDetectNetwork.detectUnbufferedIo();
                        }
                        return new DelegatingScheduledExecutorService(Executors.newFixedThreadPool(4, new CustomThreadFactory("Firebase Background", 10, builderDetectNetwork.penaltyLog().build())), (ScheduledExecutorService) ExecutorsRegistrar.f43637d.get());
                    case 1:
                        Lazy lazy2 = ExecutorsRegistrar.f43634a;
                        return new DelegatingScheduledExecutorService(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors()), new CustomThreadFactory("Firebase Lite", 0, new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build())), (ScheduledExecutorService) ExecutorsRegistrar.f43637d.get());
                    case 2:
                        Lazy lazy3 = ExecutorsRegistrar.f43634a;
                        return new DelegatingScheduledExecutorService(Executors.newCachedThreadPool(new CustomThreadFactory("Firebase Blocking", 11, null)), (ScheduledExecutorService) ExecutorsRegistrar.f43637d.get());
                    default:
                        Lazy lazy4 = ExecutorsRegistrar.f43634a;
                        return Executors.newSingleThreadScheduledExecutor(new CustomThreadFactory("Firebase Scheduler", 0, null));
                }
            }
        });
        final int i5 = 3;
        f43637d = new Lazy(new Provider() { // from class: com.google.firebase.concurrent.g
            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                switch (i5) {
                    case 0:
                        Lazy lazy = ExecutorsRegistrar.f43634a;
                        StrictMode.ThreadPolicy.Builder builderDetectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
                        int i32 = Build.VERSION.SDK_INT;
                        builderDetectNetwork.detectResourceMismatches();
                        if (i32 >= 26) {
                            builderDetectNetwork.detectUnbufferedIo();
                        }
                        return new DelegatingScheduledExecutorService(Executors.newFixedThreadPool(4, new CustomThreadFactory("Firebase Background", 10, builderDetectNetwork.penaltyLog().build())), (ScheduledExecutorService) ExecutorsRegistrar.f43637d.get());
                    case 1:
                        Lazy lazy2 = ExecutorsRegistrar.f43634a;
                        return new DelegatingScheduledExecutorService(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors()), new CustomThreadFactory("Firebase Lite", 0, new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build())), (ScheduledExecutorService) ExecutorsRegistrar.f43637d.get());
                    case 2:
                        Lazy lazy3 = ExecutorsRegistrar.f43634a;
                        return new DelegatingScheduledExecutorService(Executors.newCachedThreadPool(new CustomThreadFactory("Firebase Blocking", 11, null)), (ScheduledExecutorService) ExecutorsRegistrar.f43637d.get());
                    default:
                        Lazy lazy4 = ExecutorsRegistrar.f43634a;
                        return Executors.newSingleThreadScheduledExecutor(new CustomThreadFactory("Firebase Scheduler", 0, null));
                }
            }
        });
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public final List getComponents() {
        Component.Builder builder = new Component.Builder(new Qualified(Background.class, ScheduledExecutorService.class), new Qualified[]{new Qualified(Background.class, ExecutorService.class), new Qualified(Background.class, Executor.class)});
        final int i2 = 0;
        builder.f43568f = new ComponentFactory() { // from class: com.google.firebase.concurrent.h
            @Override // com.google.firebase.components.ComponentFactory
            public final Object c(ComponentContainer componentContainer) {
                switch (i2) {
                    case 0:
                        return (ScheduledExecutorService) ExecutorsRegistrar.f43634a.get();
                    case 1:
                        return (ScheduledExecutorService) ExecutorsRegistrar.f43636c.get();
                    case 2:
                        return (ScheduledExecutorService) ExecutorsRegistrar.f43635b.get();
                    default:
                        Lazy lazy = ExecutorsRegistrar.f43634a;
                        return UiExecutor.f43653a;
                }
            }
        };
        Component componentB = builder.b();
        Component.Builder builder2 = new Component.Builder(new Qualified(Blocking.class, ScheduledExecutorService.class), new Qualified[]{new Qualified(Blocking.class, ExecutorService.class), new Qualified(Blocking.class, Executor.class)});
        final int i3 = 1;
        builder2.f43568f = new ComponentFactory() { // from class: com.google.firebase.concurrent.h
            @Override // com.google.firebase.components.ComponentFactory
            public final Object c(ComponentContainer componentContainer) {
                switch (i3) {
                    case 0:
                        return (ScheduledExecutorService) ExecutorsRegistrar.f43634a.get();
                    case 1:
                        return (ScheduledExecutorService) ExecutorsRegistrar.f43636c.get();
                    case 2:
                        return (ScheduledExecutorService) ExecutorsRegistrar.f43635b.get();
                    default:
                        Lazy lazy = ExecutorsRegistrar.f43634a;
                        return UiExecutor.f43653a;
                }
            }
        };
        Component componentB2 = builder2.b();
        Component.Builder builder3 = new Component.Builder(new Qualified(Lightweight.class, ScheduledExecutorService.class), new Qualified[]{new Qualified(Lightweight.class, ExecutorService.class), new Qualified(Lightweight.class, Executor.class)});
        final int i4 = 2;
        builder3.f43568f = new ComponentFactory() { // from class: com.google.firebase.concurrent.h
            @Override // com.google.firebase.components.ComponentFactory
            public final Object c(ComponentContainer componentContainer) {
                switch (i4) {
                    case 0:
                        return (ScheduledExecutorService) ExecutorsRegistrar.f43634a.get();
                    case 1:
                        return (ScheduledExecutorService) ExecutorsRegistrar.f43636c.get();
                    case 2:
                        return (ScheduledExecutorService) ExecutorsRegistrar.f43635b.get();
                    default:
                        Lazy lazy = ExecutorsRegistrar.f43634a;
                        return UiExecutor.f43653a;
                }
            }
        };
        Component componentB3 = builder3.b();
        Component.Builder builderA = Component.a(new Qualified(UiThread.class, Executor.class));
        final int i5 = 3;
        builderA.f43568f = new ComponentFactory() { // from class: com.google.firebase.concurrent.h
            @Override // com.google.firebase.components.ComponentFactory
            public final Object c(ComponentContainer componentContainer) {
                switch (i5) {
                    case 0:
                        return (ScheduledExecutorService) ExecutorsRegistrar.f43634a.get();
                    case 1:
                        return (ScheduledExecutorService) ExecutorsRegistrar.f43636c.get();
                    case 2:
                        return (ScheduledExecutorService) ExecutorsRegistrar.f43635b.get();
                    default:
                        Lazy lazy = ExecutorsRegistrar.f43634a;
                        return UiExecutor.f43653a;
                }
            }
        };
        return Arrays.asList(componentB, componentB2, componentB3, builderA.b());
    }
}
