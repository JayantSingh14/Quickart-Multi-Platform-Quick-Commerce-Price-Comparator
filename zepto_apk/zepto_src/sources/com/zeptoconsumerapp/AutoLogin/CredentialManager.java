package com.zeptoconsumerapp.AutoLogin;

import android.content.Context;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

@Keep
@Metadata
/* loaded from: classes.dex */
public final class CredentialManager {

    @NotNull
    public static final CredentialManager INSTANCE = new CredentialManager();

    @Nullable
    private static Context appContext;

    @Metadata
    @DebugMetadata(c = "com.zeptoconsumerapp.AutoLogin.CredentialManager$getShared$1", f = "CredentialManager.kt", l = {Type.CDS, 65, WKSRecord.Service.BOOTPC}, m = "invokeSuspend")
    /* renamed from: com.zeptoconsumerapp.AutoLogin.CredentialManager$getShared$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public String f47372a;

        /* renamed from: b, reason: collision with root package name */
        public int f47373b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f47374c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f47375d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, String str, Continuation continuation) {
            super(2, continuation);
            this.f47374c = context;
            this.f47375d = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f47374c, this.f47375d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            int i2 = this.f47373b;
            Context context = this.f47374c;
            String str2 = this.f47375d;
            if (i2 == 0) {
                ResultKt.b(obj);
                SharedCredentialManager sharedCredentialManager = SharedCredentialManager.INSTANCE;
                this.f47373b = 1;
                obj = sharedCredentialManager.getCached(context, str2, this);
                if (obj != coroutineSingletons) {
                }
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    String str3 = this.f47372a;
                    ResultKt.b(obj);
                    return str3;
                }
                ResultKt.b(obj);
                str = (String) obj;
                if (str == null && str.length() != 0) {
                    SharedCredentialManager sharedCredentialManager2 = SharedCredentialManager.INSTANCE;
                    this.f47372a = str;
                    this.f47373b = 3;
                    return sharedCredentialManager2.cache(context, str2, str, this) == coroutineSingletons ? coroutineSingletons : str;
                }
            }
            ResultKt.b(obj);
            String str4 = (String) obj;
            if (str4 != null && str4.length() != 0) {
                return str4;
            }
            AutoBackupManager autoBackupManager = AutoBackupManager.INSTANCE;
            this.f47373b = 2;
            obj = autoBackupManager.get(context, str2, this);
            if (obj != coroutineSingletons) {
                str = (String) obj;
                return str == null ? null : null;
            }
        }
    }

    @Metadata
    @DebugMetadata(c = "com.zeptoconsumerapp.AutoLogin.CredentialManager$saveShared$1", f = "CredentialManager.kt", l = {39, 42}, m = "invokeSuspend")
    /* renamed from: com.zeptoconsumerapp.AutoLogin.CredentialManager$saveShared$1, reason: invalid class name and case insensitive filesystem */
    /* loaded from: classes4.dex */
    public static final class C00971 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f47376a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f47377b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f47378c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f47379d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00971(Context context, String str, String str2, Continuation continuation) {
            super(2, continuation);
            this.f47377b = context;
            this.f47378c = str;
            this.f47379d = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C00971(this.f47377b, this.f47378c, this.f47379d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((C00971) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
        
            if (r8.cache(r2, r4, r3, r7) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
                int r1 = r7.f47376a
                android.content.Context r2 = r7.f47377b
                java.lang.String r3 = r7.f47379d
                java.lang.String r4 = r7.f47378c
                r5 = 2
                r6 = 1
                if (r1 == 0) goto L22
                if (r1 == r6) goto L1e
                if (r1 != r5) goto L16
                kotlin.ResultKt.b(r8)
                goto L3b
            L16:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1e:
                kotlin.ResultKt.b(r8)
                goto L30
            L22:
                kotlin.ResultKt.b(r8)
                com.zeptoconsumerapp.AutoLogin.AutoBackupManager r8 = com.zeptoconsumerapp.AutoLogin.AutoBackupManager.INSTANCE
                r7.f47376a = r6
                java.lang.Object r8 = r8.save(r2, r4, r3, r7)
                if (r8 != r0) goto L30
                goto L3a
            L30:
                com.zeptoconsumerapp.AutoLogin.SharedCredentialManager r8 = com.zeptoconsumerapp.AutoLogin.SharedCredentialManager.INSTANCE
                r7.f47376a = r5
                java.lang.Object r8 = r8.cache(r2, r4, r3, r7)
                if (r8 != r0) goto L3b
            L3a:
                return r0
            L3b:
                kotlin.Unit r8 = kotlin.Unit.f53572a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zeptoconsumerapp.AutoLogin.CredentialManager.C00971.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private CredentialManager() {
    }

    @JvmStatic
    @Keep
    @Nullable
    public static final String getShared(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Context context = appContext;
        if (context != null) {
            try {
                return (String) BuildersKt.d(new AnonymousClass1(context, key, null));
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @JvmStatic
    @Keep
    public static final void initialize(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        appContext = context.getApplicationContext();
    }

    @JvmStatic
    @Keep
    public static final void saveShared(@NotNull String key, @NotNull String value) throws Throwable {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Context context = appContext;
        if (context == null) {
            return;
        }
        try {
            BuildersKt.d(new C00971(context, key, value, null));
        } catch (Exception unused) {
        }
    }
}
