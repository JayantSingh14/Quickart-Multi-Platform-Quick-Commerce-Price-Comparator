package com.zeptoconsumerapp.AutoLogin;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.xbill.DNS.WKSRecord;

@Keep
@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class AutoBackupManager {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;

    @NotNull
    private static final String DATASTORE_NAME = "secure_prefs";

    @NotNull
    public static final AutoBackupManager INSTANCE;

    @NotNull
    private static final ReadOnlyProperty dataStore$delegate;

    @Metadata
    @DebugMetadata(c = "com.zeptoconsumerapp.AutoLogin.AutoBackupManager", f = "AutoBackupManager.kt", l = {79}, m = "clear")
    /* renamed from: com.zeptoconsumerapp.AutoLogin.AutoBackupManager$clear$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f47348a;

        /* renamed from: c, reason: collision with root package name */
        public int f47350c;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f47348a = obj;
            this.f47350c |= Integer.MIN_VALUE;
            return AutoBackupManager.this.clear(null, this);
        }
    }

    @Metadata
    @DebugMetadata(c = "com.zeptoconsumerapp.AutoLogin.AutoBackupManager$clear$2", f = "AutoBackupManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.zeptoconsumerapp.AutoLogin.AutoBackupManager$clear$2, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f47351a;

        public AnonymousClass2() {
            super(2, null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(2, continuation);
            anonymousClass2.f47351a = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass2) create((MutablePreferences) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            ResultKt.b(obj);
            MutablePreferences mutablePreferences = (MutablePreferences) this.f47351a;
            mutablePreferences.c();
            mutablePreferences.f3717a.clear();
            return Unit.f53572a;
        }
    }

    @Metadata
    @DebugMetadata(c = "com.zeptoconsumerapp.AutoLogin.AutoBackupManager", f = "AutoBackupManager.kt", l = {55}, m = "get")
    /* renamed from: com.zeptoconsumerapp.AutoLogin.AutoBackupManager$get$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00911 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f47352a;

        /* renamed from: c, reason: collision with root package name */
        public int f47354c;

        public C00911(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f47352a = obj;
            this.f47354c |= Integer.MIN_VALUE;
            return AutoBackupManager.this.get(null, null, this);
        }
    }

    @Metadata
    @DebugMetadata(c = "com.zeptoconsumerapp.AutoLogin.AutoBackupManager", f = "AutoBackupManager.kt", l = {WKSRecord.Service.BOOTPC}, m = "remove")
    /* renamed from: com.zeptoconsumerapp.AutoLogin.AutoBackupManager$remove$1, reason: invalid class name and case insensitive filesystem */
    /* loaded from: classes4.dex */
    public static final class C00921 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f47355a;

        /* renamed from: c, reason: collision with root package name */
        public int f47357c;

        public C00921(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f47355a = obj;
            this.f47357c |= Integer.MIN_VALUE;
            return AutoBackupManager.this.remove(null, null, this);
        }
    }

    @Metadata
    @DebugMetadata(c = "com.zeptoconsumerapp.AutoLogin.AutoBackupManager$remove$2", f = "AutoBackupManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.zeptoconsumerapp.AutoLogin.AutoBackupManager$remove$2, reason: invalid class name and case insensitive filesystem */
    /* loaded from: classes4.dex */
    public static final class C00932 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f47358a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Preferences.Key f47359b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00932(Preferences.Key key, Continuation continuation) {
            super(2, continuation);
            this.f47359b = key;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C00932 c00932 = new C00932(this.f47359b, continuation);
            c00932.f47358a = obj;
            return c00932;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((C00932) create((MutablePreferences) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            ResultKt.b(obj);
            MutablePreferences mutablePreferences = (MutablePreferences) this.f47358a;
            Preferences.Key key = this.f47359b;
            mutablePreferences.getClass();
            Intrinsics.checkNotNullParameter(key, "key");
            mutablePreferences.c();
            mutablePreferences.f3717a.remove(key);
            return Unit.f53572a;
        }
    }

    @Metadata
    @DebugMetadata(c = "com.zeptoconsumerapp.AutoLogin.AutoBackupManager", f = "AutoBackupManager.kt", l = {43}, m = "save")
    /* renamed from: com.zeptoconsumerapp.AutoLogin.AutoBackupManager$save$1, reason: invalid class name and case insensitive filesystem */
    /* loaded from: classes4.dex */
    public static final class C00941 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f47360a;

        /* renamed from: c, reason: collision with root package name */
        public int f47362c;

        public C00941(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f47360a = obj;
            this.f47362c |= Integer.MIN_VALUE;
            return AutoBackupManager.this.save(null, null, null, this);
        }
    }

    @Metadata
    @DebugMetadata(c = "com.zeptoconsumerapp.AutoLogin.AutoBackupManager$save$2", f = "AutoBackupManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.zeptoconsumerapp.AutoLogin.AutoBackupManager$save$2, reason: invalid class name and case insensitive filesystem */
    /* loaded from: classes4.dex */
    public static final class C00952 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f47363a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Preferences.Key f47364b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f47365c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00952(Preferences.Key key, String str, Continuation continuation) {
            super(2, continuation);
            this.f47364b = key;
            this.f47365c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C00952 c00952 = new C00952(this.f47364b, this.f47365c, continuation);
            c00952.f47363a = obj;
            return c00952;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((C00952) create((MutablePreferences) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            ResultKt.b(obj);
            MutablePreferences mutablePreferences = (MutablePreferences) this.f47363a;
            Preferences.Key key = this.f47364b;
            mutablePreferences.getClass();
            Intrinsics.checkNotNullParameter(key, "key");
            mutablePreferences.d(key, this.f47365c);
            return Unit.f53572a;
        }
    }

    static {
        PropertyReference2Impl propertyReference2Impl = new PropertyReference2Impl(CallableReference.NO_RECEIVER, AutoBackupManager.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0);
        Reflection.f53802a.getClass();
        $$delegatedProperties = new KProperty[]{propertyReference2Impl};
        INSTANCE = new AutoBackupManager();
        dataStore$delegate = PreferenceDataStoreDelegateKt.a(new ReplaceFileCorruptionHandler(new a(0)));
    }

    private AutoBackupManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Preferences dataStore_delegate$lambda$0(CorruptionException it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new MutablePreferences(true, (int) (1 == true ? 1 : 0));
    }

    private final DataStore<Preferences> getDataStore(Context context) {
        return (DataStore) dataStore$delegate.a(context, $$delegatedProperties[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @androidx.annotation.Keep
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object clear(@org.jetbrains.annotations.NotNull android.content.Context r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.zeptoconsumerapp.AutoLogin.AutoBackupManager.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            com.zeptoconsumerapp.AutoLogin.AutoBackupManager$clear$1 r0 = (com.zeptoconsumerapp.AutoLogin.AutoBackupManager.AnonymousClass1) r0
            int r1 = r0.f47350c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f47350c = r1
            goto L18
        L13:
            com.zeptoconsumerapp.AutoLogin.AutoBackupManager$clear$1 r0 = new com.zeptoconsumerapp.AutoLogin.AutoBackupManager$clear$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f47348a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f47350c
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.b(r6)     // Catch: java.lang.Throwable -> L44
            goto L44
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            kotlin.ResultKt.b(r6)
            androidx.datastore.core.DataStore r5 = r4.getDataStore(r5)     // Catch: java.lang.Throwable -> L44
            com.zeptoconsumerapp.AutoLogin.AutoBackupManager$clear$2 r6 = new com.zeptoconsumerapp.AutoLogin.AutoBackupManager$clear$2     // Catch: java.lang.Throwable -> L44
            r6.<init>()     // Catch: java.lang.Throwable -> L44
            r0.f47350c = r3     // Catch: java.lang.Throwable -> L44
            java.lang.Object r5 = androidx.datastore.preferences.core.PreferencesKt.a(r5, r6, r0)     // Catch: java.lang.Throwable -> L44
            if (r5 != r1) goto L44
            return r1
        L44:
            kotlin.Unit r5 = kotlin.Unit.f53572a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptoconsumerapp.AutoLogin.AutoBackupManager.clear(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @androidx.annotation.Keep
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(@org.jetbrains.annotations.NotNull android.content.Context r5, @org.jetbrains.annotations.NotNull java.lang.String r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.String> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.zeptoconsumerapp.AutoLogin.AutoBackupManager.C00911
            if (r0 == 0) goto L13
            r0 = r7
            com.zeptoconsumerapp.AutoLogin.AutoBackupManager$get$1 r0 = (com.zeptoconsumerapp.AutoLogin.AutoBackupManager.C00911) r0
            int r1 = r0.f47354c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f47354c = r1
            goto L18
        L13:
            com.zeptoconsumerapp.AutoLogin.AutoBackupManager$get$1 r0 = new com.zeptoconsumerapp.AutoLogin.AutoBackupManager$get$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f47352a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f47354c
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.b(r7)     // Catch: java.lang.Throwable -> L4f
            goto L4c
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            kotlin.ResultKt.b(r7)
            androidx.datastore.preferences.core.Preferences$Key r6 = androidx.datastore.preferences.core.PreferencesKeys.a(r6)     // Catch: java.lang.Throwable -> L4f
            androidx.datastore.core.DataStore r5 = r4.getDataStore(r5)     // Catch: java.lang.Throwable -> L4f
            kotlinx.coroutines.flow.Flow r5 = r5.getData()     // Catch: java.lang.Throwable -> L4f
            com.zeptoconsumerapp.AutoLogin.AutoBackupManager$get$$inlined$map$1 r7 = new com.zeptoconsumerapp.AutoLogin.AutoBackupManager$get$$inlined$map$1     // Catch: java.lang.Throwable -> L4f
            r7.<init>()     // Catch: java.lang.Throwable -> L4f
            r0.f47354c = r3     // Catch: java.lang.Throwable -> L4f
            java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.i(r7, r0)     // Catch: java.lang.Throwable -> L4f
            if (r7 != r1) goto L4c
            return r1
        L4c:
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Throwable -> L4f
            return r7
        L4f:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptoconsumerapp.AutoLogin.AutoBackupManager.get(android.content.Context, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @androidx.annotation.Keep
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object remove(@org.jetbrains.annotations.NotNull android.content.Context r5, @org.jetbrains.annotations.NotNull java.lang.String r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.zeptoconsumerapp.AutoLogin.AutoBackupManager.C00921
            if (r0 == 0) goto L13
            r0 = r7
            com.zeptoconsumerapp.AutoLogin.AutoBackupManager$remove$1 r0 = (com.zeptoconsumerapp.AutoLogin.AutoBackupManager.C00921) r0
            int r1 = r0.f47357c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f47357c = r1
            goto L18
        L13:
            com.zeptoconsumerapp.AutoLogin.AutoBackupManager$remove$1 r0 = new com.zeptoconsumerapp.AutoLogin.AutoBackupManager$remove$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f47355a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f47357c
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.b(r7)     // Catch: java.lang.Throwable -> L49
            goto L49
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            kotlin.ResultKt.b(r7)
            androidx.datastore.preferences.core.Preferences$Key r6 = androidx.datastore.preferences.core.PreferencesKeys.a(r6)     // Catch: java.lang.Throwable -> L49
            androidx.datastore.core.DataStore r5 = r4.getDataStore(r5)     // Catch: java.lang.Throwable -> L49
            com.zeptoconsumerapp.AutoLogin.AutoBackupManager$remove$2 r7 = new com.zeptoconsumerapp.AutoLogin.AutoBackupManager$remove$2     // Catch: java.lang.Throwable -> L49
            r2 = 0
            r7.<init>(r6, r2)     // Catch: java.lang.Throwable -> L49
            r0.f47357c = r3     // Catch: java.lang.Throwable -> L49
            java.lang.Object r5 = androidx.datastore.preferences.core.PreferencesKt.a(r5, r7, r0)     // Catch: java.lang.Throwable -> L49
            if (r5 != r1) goto L49
            return r1
        L49:
            kotlin.Unit r5 = kotlin.Unit.f53572a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptoconsumerapp.AutoLogin.AutoBackupManager.remove(android.content.Context, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @androidx.annotation.Keep
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object save(@org.jetbrains.annotations.NotNull android.content.Context r5, @org.jetbrains.annotations.NotNull java.lang.String r6, @org.jetbrains.annotations.NotNull java.lang.String r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.zeptoconsumerapp.AutoLogin.AutoBackupManager.C00941
            if (r0 == 0) goto L13
            r0 = r8
            com.zeptoconsumerapp.AutoLogin.AutoBackupManager$save$1 r0 = (com.zeptoconsumerapp.AutoLogin.AutoBackupManager.C00941) r0
            int r1 = r0.f47362c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f47362c = r1
            goto L18
        L13:
            com.zeptoconsumerapp.AutoLogin.AutoBackupManager$save$1 r0 = new com.zeptoconsumerapp.AutoLogin.AutoBackupManager$save$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f47360a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f47362c
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L49
            goto L49
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            kotlin.ResultKt.b(r8)
            androidx.datastore.preferences.core.Preferences$Key r6 = androidx.datastore.preferences.core.PreferencesKeys.a(r6)     // Catch: java.lang.Throwable -> L49
            androidx.datastore.core.DataStore r5 = r4.getDataStore(r5)     // Catch: java.lang.Throwable -> L49
            com.zeptoconsumerapp.AutoLogin.AutoBackupManager$save$2 r8 = new com.zeptoconsumerapp.AutoLogin.AutoBackupManager$save$2     // Catch: java.lang.Throwable -> L49
            r2 = 0
            r8.<init>(r6, r7, r2)     // Catch: java.lang.Throwable -> L49
            r0.f47362c = r3     // Catch: java.lang.Throwable -> L49
            java.lang.Object r5 = androidx.datastore.preferences.core.PreferencesKt.a(r5, r8, r0)     // Catch: java.lang.Throwable -> L49
            if (r5 != r1) goto L49
            return r1
        L49:
            kotlin.Unit r5 = kotlin.Unit.f53572a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptoconsumerapp.AutoLogin.AutoBackupManager.save(android.content.Context, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
