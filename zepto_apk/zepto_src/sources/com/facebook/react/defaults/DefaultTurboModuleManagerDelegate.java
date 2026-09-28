package com.facebook.react.defaults;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.proguard.annotations.DoNotStripAny;
import com.facebook.react.ReactPackage;
import com.facebook.react.ReactPackageTurboModuleManagerDelegate;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.runtime.cxxreactpackage.CxxReactPackage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@DoNotStripAny
@Metadata
/* loaded from: classes3.dex */
public final class DefaultTurboModuleManagerDelegate extends ReactPackageTurboModuleManagerDelegate {

    @NotNull
    private static final Companion Companion = new Companion();

    @Metadata
    @SourceDebugExtension
    public static final class Builder extends ReactPackageTurboModuleManagerDelegate.Builder {

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f18757c = new ArrayList();

        @Override // com.facebook.react.ReactPackageTurboModuleManagerDelegate.Builder
        public final DefaultTurboModuleManagerDelegate b(ReactApplicationContext context, ArrayList packages) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(packages, "packages");
            ArrayList arrayList = this.f18757c;
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                CollectionsKt.i(arrayList2, (Iterable) ((Function1) it.next()).invoke(context));
            }
            return new DefaultTurboModuleManagerDelegate(context, packages, arrayList2, null);
        }
    }

    @Metadata
    public static final class Companion {
        @JvmStatic
        @DoNotStrip
        @NotNull
        public final HybridData initHybrid(@NotNull List<? extends CxxReactPackage> list) {
            return DefaultTurboModuleManagerDelegate.initHybrid(list);
        }
    }

    static {
        DefaultSoLoader.f18756a.a();
    }

    public /* synthetic */ DefaultTurboModuleManagerDelegate(ReactApplicationContext reactApplicationContext, List list, List list2, DefaultConstructorMarker defaultConstructorMarker) {
        this(reactApplicationContext, list, list2);
    }

    @JvmStatic
    @DoNotStrip
    @NotNull
    public static final native HybridData initHybrid(@NotNull List<? extends CxxReactPackage> list);

    @Override // com.facebook.react.internal.turbomodule.core.TurboModuleManagerDelegate
    @NotNull
    public HybridData initHybrid() {
        throw new UnsupportedOperationException("DefaultTurboModuleManagerDelegate.initHybrid() must never be called!");
    }

    private DefaultTurboModuleManagerDelegate(ReactApplicationContext reactApplicationContext, List<? extends ReactPackage> list, List<? extends CxxReactPackage> list2) {
        super(reactApplicationContext, list, Companion.initHybrid(list2));
    }
}
