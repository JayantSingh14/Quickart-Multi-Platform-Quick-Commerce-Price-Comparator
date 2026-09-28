package com.zeptoconsumerapp.AutoLogin;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xbill.DNS.WKSRecord;

@Keep
@Metadata
/* loaded from: classes.dex */
public final class SharedCredentialManager {

    @NotNull
    private static final String ACCOUNT_NAME = "Zepto";

    @NotNull
    public static final SharedCredentialManager INSTANCE = new SharedCredentialManager();

    @NotNull
    private static final String SHARED_ACCOUNT_TYPE = "com.zepto.shared_account";

    @Metadata
    @DebugMetadata(c = "com.zeptoconsumerapp.AutoLogin.SharedCredentialManager$cache$2", f = "SharedCredentialManager.kt", l = {54}, m = "invokeSuspend")
    /* renamed from: com.zeptoconsumerapp.AutoLogin.SharedCredentialManager$cache$2, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public AccountManager f47380a;

        /* renamed from: b, reason: collision with root package name */
        public int f47381b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f47382c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f47383d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f47384e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Context context, String str, String str2, Continuation continuation) {
            super(2, continuation);
            this.f47382c = context;
            this.f47383d = str;
            this.f47384e = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.f47382c, this.f47383d, this.f47384e, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AccountManager accountManager;
            Context context = this.f47382c;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            int i2 = this.f47381b;
            try {
                if (i2 == 0) {
                    ResultKt.b(obj);
                    AccountManager accountManager2 = AccountManager.get(context);
                    SharedCredentialManager sharedCredentialManager = SharedCredentialManager.INSTANCE;
                    this.f47380a = accountManager2;
                    this.f47381b = 1;
                    Object orCreateAccount = sharedCredentialManager.getOrCreateAccount(context, this);
                    if (orCreateAccount == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    accountManager = accountManager2;
                    obj = orCreateAccount;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    accountManager = this.f47380a;
                    ResultKt.b(obj);
                }
                accountManager.setAuthToken((Account) obj, this.f47383d, this.f47384e);
            } catch (Exception unused) {
            }
            return Unit.f53572a;
        }
    }

    @Metadata
    @DebugMetadata(c = "com.zeptoconsumerapp.AutoLogin.SharedCredentialManager$clearCache$2", f = "SharedCredentialManager.kt", l = {80}, m = "invokeSuspend")
    /* renamed from: com.zeptoconsumerapp.AutoLogin.SharedCredentialManager$clearCache$2, reason: invalid class name and case insensitive filesystem */
    /* loaded from: classes4.dex */
    public static final class C00982 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public AccountManager f47385a;

        /* renamed from: b, reason: collision with root package name */
        public int f47386b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f47387c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f47388d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00982(Context context, String str, Continuation continuation) {
            super(2, continuation);
            this.f47387c = context;
            this.f47388d = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C00982(this.f47387c, this.f47388d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((C00982) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AccountManager accountManager;
            Context context = this.f47387c;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            int i2 = this.f47386b;
            try {
                if (i2 == 0) {
                    ResultKt.b(obj);
                    AccountManager accountManager2 = AccountManager.get(context);
                    SharedCredentialManager sharedCredentialManager = SharedCredentialManager.INSTANCE;
                    String str = this.f47388d;
                    this.f47385a = accountManager2;
                    this.f47386b = 1;
                    Object cached = sharedCredentialManager.getCached(context, str, this);
                    if (cached == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    accountManager = accountManager2;
                    obj = cached;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    accountManager = this.f47385a;
                    ResultKt.b(obj);
                }
                String str2 = (String) obj;
                if (str2 != null && str2.length() != 0) {
                    accountManager.invalidateAuthToken(SharedCredentialManager.SHARED_ACCOUNT_TYPE, str2);
                }
            } catch (Exception unused) {
            }
            return Unit.f53572a;
        }
    }

    @Metadata
    @DebugMetadata(c = "com.zeptoconsumerapp.AutoLogin.SharedCredentialManager$getCached$2", f = "SharedCredentialManager.kt", l = {WKSRecord.Protocol.RVD}, m = "invokeSuspend")
    /* renamed from: com.zeptoconsumerapp.AutoLogin.SharedCredentialManager$getCached$2, reason: invalid class name and case insensitive filesystem */
    public static final class C00992 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public AccountManager f47389a;

        /* renamed from: b, reason: collision with root package name */
        public int f47390b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f47391c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f47392d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00992(Context context, String str, Continuation continuation) {
            super(2, continuation);
            this.f47391c = context;
            this.f47392d = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C00992(this.f47391c, this.f47392d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((C00992) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AccountManager accountManager;
            Context context = this.f47391c;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            int i2 = this.f47390b;
            try {
                if (i2 == 0) {
                    ResultKt.b(obj);
                    AccountManager accountManager2 = AccountManager.get(context);
                    SharedCredentialManager sharedCredentialManager = SharedCredentialManager.INSTANCE;
                    this.f47389a = accountManager2;
                    this.f47390b = 1;
                    Object orCreateAccount = sharedCredentialManager.getOrCreateAccount(context, this);
                    if (orCreateAccount == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    accountManager = accountManager2;
                    obj = orCreateAccount;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    accountManager = this.f47389a;
                    ResultKt.b(obj);
                }
                return accountManager.peekAuthToken((Account) obj, this.f47392d);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    @Metadata
    @DebugMetadata(c = "com.zeptoconsumerapp.AutoLogin.SharedCredentialManager$getOrCreateAccount$2", f = "SharedCredentialManager.kt", l = {}, m = "invokeSuspend")
    @SourceDebugExtension
    /* renamed from: com.zeptoconsumerapp.AutoLogin.SharedCredentialManager$getOrCreateAccount$2, reason: invalid class name and case insensitive filesystem */
    public static final class C01002 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Account>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f47393a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01002(Context context, Continuation continuation) {
            super(2, continuation);
            this.f47393a = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C01002(this.f47393a, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((C01002) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            ResultKt.b(obj);
            Context context = this.f47393a;
            AccountManager accountManager = AccountManager.get(context);
            Account account = new Account("Zepto", SharedCredentialManager.SHARED_ACCOUNT_TYPE);
            Account[] accountsByType = accountManager.getAccountsByType(SharedCredentialManager.SHARED_ACCOUNT_TYPE);
            Intrinsics.checkNotNullExpressionValue(accountsByType, "getAccountsByType(...)");
            for (Account account2 : accountsByType) {
                if (Intrinsics.b(account2.name, "Zepto")) {
                    return account;
                }
            }
            Bundle bundle = new Bundle();
            bundle.putString("created_by", context.getPackageName());
            bundle.putLong("created_at", System.currentTimeMillis());
            Unit unit = Unit.f53572a;
            accountManager.addAccountExplicitly(account, null, bundle);
            return account;
        }
    }

    private SharedCredentialManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getOrCreateAccount(Context context, Continuation<? super Account> continuation) {
        DefaultScheduler defaultScheduler = Dispatchers.f54091a;
        return BuildersKt.e(DefaultIoScheduler.f55150b, new C01002(context, null), continuation);
    }

    @Keep
    @Nullable
    public final Object cache(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull Continuation<? super Unit> continuation) throws Throwable {
        DefaultScheduler defaultScheduler = Dispatchers.f54091a;
        Object objE = BuildersKt.e(DefaultIoScheduler.f55150b, new AnonymousClass2(context, str, str2, null), continuation);
        return objE == CoroutineSingletons.f53689a ? objE : Unit.f53572a;
    }

    @Keep
    @Nullable
    public final Object clearCache(@NotNull Context context, @NotNull String str, @NotNull Continuation<? super Unit> continuation) throws Throwable {
        DefaultScheduler defaultScheduler = Dispatchers.f54091a;
        Object objE = BuildersKt.e(DefaultIoScheduler.f55150b, new C00982(context, str, null), continuation);
        return objE == CoroutineSingletons.f53689a ? objE : Unit.f53572a;
    }

    @Keep
    @Nullable
    public final Object getCached(@NotNull Context context, @NotNull String str, @NotNull Continuation<? super String> continuation) {
        DefaultScheduler defaultScheduler = Dispatchers.f54091a;
        return BuildersKt.e(DefaultIoScheduler.f55150b, new C00992(context, str, null), continuation);
    }
}
