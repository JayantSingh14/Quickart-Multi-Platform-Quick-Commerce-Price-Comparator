package com.chuckerteam.chucker.internal.ui;

import android.net.Uri;
import android.util.LongSparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope;
import androidx.lifecycle.viewmodel.internal.SynchronizedObject;
import coil3.network.internal.UtilsKt;
import com.chuckerteam.chucker.R;
import com.chuckerteam.chucker.databinding.ChuckerActivityMainBinding;
import com.chuckerteam.chucker.internal.data.model.DialogData;
import com.chuckerteam.chucker.internal.support.ContextExtKt;
import com.chuckerteam.chucker.internal.support.Logger;
import com.chuckerteam.chucker.internal.support.NotificationHelper;
import com.chuckerteam.chucker.internal.ui.MainActivity;
import com.chuckerteam.chucker.internal.ui.transaction.TransactionAdapter;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class MainActivity extends BaseChuckerActivity implements SearchView.OnQueryTextListener {
    public static final /* synthetic */ int p = 0;

    /* renamed from: j, reason: collision with root package name */
    public final ViewModelLazy f16849j = new ViewModelLazy(Reflection.a(MainViewModel.class), new Function0<ViewModelStore>() { // from class: com.chuckerteam.chucker.internal.ui.MainActivity$special$$inlined$viewModels$default$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return this.f16854c.getViewModelStore();
        }
    }, new Function0<ViewModelProvider.Factory>() { // from class: com.chuckerteam.chucker.internal.ui.MainActivity$special$$inlined$viewModels$default$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return this.f16853c.getDefaultViewModelProviderFactory();
        }
    }, new Function0<CreationExtras>() { // from class: com.chuckerteam.chucker.internal.ui.MainActivity$special$$inlined$viewModels$default$3
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return this.f16855c.getDefaultViewModelCreationExtras();
        }
    });

    /* renamed from: k, reason: collision with root package name */
    public ChuckerActivityMainBinding f16850k;

    /* renamed from: l, reason: collision with root package name */
    public TransactionAdapter f16851l;

    /* renamed from: m, reason: collision with root package name */
    public final ActivityResultLauncher f16852m;
    public final ActivityResultLauncher n;
    public final ActivityResultLauncher o;

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    public static final class ExportType {

        /* renamed from: a, reason: collision with root package name */
        public static final ExportType f16856a;

        /* renamed from: b, reason: collision with root package name */
        public static final ExportType f16857b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ ExportType[] f16858c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f16859d;

        static {
            ExportType exportType = new ExportType("TEXT", 0);
            f16856a = exportType;
            ExportType exportType2 = new ExportType("HAR", 1);
            f16857b = exportType2;
            ExportType[] exportTypeArr = {exportType, exportType2};
            f16858c = exportTypeArr;
            f16859d = EnumEntriesKt.a(exportTypeArr);
        }

        public static ExportType valueOf(String str) {
            return (ExportType) Enum.valueOf(ExportType.class, str);
        }

        public static ExportType[] values() {
            return (ExportType[]) f16858c.clone();
        }
    }

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[ExportType.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                ExportType exportType = ExportType.f16856a;
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public MainActivity() {
        final int i2 = 2;
        this.f16852m = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback(this) { // from class: com.chuckerteam.chucker.internal.ui.c

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MainActivity f16895b;

            {
                this.f16895b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void b(Object obj) {
                MainActivity mainActivity = this.f16895b;
                switch (i2) {
                    case 0:
                        int i3 = MainActivity.p;
                        mainActivity.o((Uri) obj, MainActivity.ExportType.f16856a);
                        break;
                    case 1:
                        int i4 = MainActivity.p;
                        mainActivity.o((Uri) obj, MainActivity.ExportType.f16857b);
                        break;
                    default:
                        boolean zBooleanValue = ((Boolean) obj).booleanValue();
                        int i5 = MainActivity.p;
                        if (!zBooleanValue) {
                            String message = mainActivity.getApplicationContext().getString(R.string.chucker_notifications_permission_not_granted);
                            Intrinsics.checkNotNullExpressionValue(message, "getString(...)");
                            Intrinsics.checkNotNullParameter(message, "message");
                            Toast.makeText(mainActivity.getApplicationContext(), message, 1).show();
                            Logger.Companion.f16778a.a("Notification permission denied. Can't show transactions info", null);
                            break;
                        }
                        break;
                }
            }
        });
        ExportType exportType = ExportType.f16856a;
        final int i3 = 0;
        this.n = registerForActivityResult(new ActivityResultContracts.CreateDocument(UtilsKt.MIME_TYPE_TEXT_PLAIN), new ActivityResultCallback(this) { // from class: com.chuckerteam.chucker.internal.ui.c

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MainActivity f16895b;

            {
                this.f16895b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void b(Object obj) {
                MainActivity mainActivity = this.f16895b;
                switch (i3) {
                    case 0:
                        int i32 = MainActivity.p;
                        mainActivity.o((Uri) obj, MainActivity.ExportType.f16856a);
                        break;
                    case 1:
                        int i4 = MainActivity.p;
                        mainActivity.o((Uri) obj, MainActivity.ExportType.f16857b);
                        break;
                    default:
                        boolean zBooleanValue = ((Boolean) obj).booleanValue();
                        int i5 = MainActivity.p;
                        if (!zBooleanValue) {
                            String message = mainActivity.getApplicationContext().getString(R.string.chucker_notifications_permission_not_granted);
                            Intrinsics.checkNotNullExpressionValue(message, "getString(...)");
                            Intrinsics.checkNotNullParameter(message, "message");
                            Toast.makeText(mainActivity.getApplicationContext(), message, 1).show();
                            Logger.Companion.f16778a.a("Notification permission denied. Can't show transactions info", null);
                            break;
                        }
                        break;
                }
            }
        });
        final int i4 = 1;
        this.o = registerForActivityResult(new ActivityResultContracts.CreateDocument("application/har+json"), new ActivityResultCallback(this) { // from class: com.chuckerteam.chucker.internal.ui.c

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MainActivity f16895b;

            {
                this.f16895b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void b(Object obj) {
                MainActivity mainActivity = this.f16895b;
                switch (i4) {
                    case 0:
                        int i32 = MainActivity.p;
                        mainActivity.o((Uri) obj, MainActivity.ExportType.f16856a);
                        break;
                    case 1:
                        int i42 = MainActivity.p;
                        mainActivity.o((Uri) obj, MainActivity.ExportType.f16857b);
                        break;
                    default:
                        boolean zBooleanValue = ((Boolean) obj).booleanValue();
                        int i5 = MainActivity.p;
                        if (!zBooleanValue) {
                            String message = mainActivity.getApplicationContext().getString(R.string.chucker_notifications_permission_not_granted);
                            Intrinsics.checkNotNullExpressionValue(message, "getString(...)");
                            Intrinsics.checkNotNullParameter(message, "message");
                            Toast.makeText(mainActivity.getApplicationContext(), message, 1).show();
                            Logger.Companion.f16778a.a("Notification permission denied. Can't show transactions info", null);
                            break;
                        }
                        break;
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m(com.chuckerteam.chucker.internal.ui.MainActivity r6, com.chuckerteam.chucker.internal.ui.MainActivity.ExportType r7, kotlin.coroutines.jvm.internal.ContinuationImpl r8) throws java.lang.Throwable {
        /*
            r6.getClass()
            boolean r0 = r8 instanceof com.chuckerteam.chucker.internal.ui.MainActivity$prepareDataToSave$1
            if (r0 == 0) goto L16
            r0 = r8
            com.chuckerteam.chucker.internal.ui.MainActivity$prepareDataToSave$1 r0 = (com.chuckerteam.chucker.internal.ui.MainActivity$prepareDataToSave$1) r0
            int r1 = r0.f16881e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.f16881e = r1
            goto L1b
        L16:
            com.chuckerteam.chucker.internal.ui.MainActivity$prepareDataToSave$1 r0 = new com.chuckerteam.chucker.internal.ui.MainActivity$prepareDataToSave$1
            r0.<init>(r6, r8)
        L1b:
            java.lang.Object r8 = r0.f16879c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f16881e
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L40
            if (r2 == r3) goto L35
            if (r2 != r4) goto L2d
            kotlin.ResultKt.b(r8)
            return r8
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            java.lang.Object r6 = r0.f16878b
            r7 = r6
            com.chuckerteam.chucker.internal.ui.MainActivity$ExportType r7 = (com.chuckerteam.chucker.internal.ui.MainActivity.ExportType) r7
            com.chuckerteam.chucker.internal.ui.MainActivity r6 = r0.f16877a
            kotlin.ResultKt.b(r8)
            goto L67
        L40:
            kotlin.ResultKt.b(r8)
            androidx.lifecycle.ViewModelLazy r8 = r6.f16849j
            java.lang.Object r8 = r8.getValue()
            com.chuckerteam.chucker.internal.ui.MainViewModel r8 = (com.chuckerteam.chucker.internal.ui.MainViewModel) r8
            r0.f16877a = r6
            r0.f16878b = r7
            r0.f16881e = r3
            r8.getClass()
            com.chuckerteam.chucker.internal.data.repository.HttpTransactionRepository r8 = com.chuckerteam.chucker.internal.data.repository.RepositoryProvider.b()
            com.chuckerteam.chucker.internal.data.repository.HttpTransactionDatabaseRepository r8 = (com.chuckerteam.chucker.internal.data.repository.HttpTransactionDatabaseRepository) r8
            com.chuckerteam.chucker.internal.data.room.ChuckerDatabase r8 = r8.f16717a
            com.chuckerteam.chucker.internal.data.room.HttpTransactionDao r8 = r8.q()
            java.lang.Object r8 = r8.e(r0)
            if (r8 != r1) goto L67
            goto L98
        L67:
            java.util.List r8 = (java.util.List) r8
            boolean r2 = r8.isEmpty()
            r3 = 0
            if (r2 == 0) goto L83
            android.content.Context r7 = r6.getApplicationContext()
            int r8 = com.chuckerteam.chucker.R.string.chucker_save_empty_text
            java.lang.String r7 = r7.getString(r8)
            java.lang.String r8 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            com.chuckerteam.chucker.internal.ui.BaseChuckerActivity.l(r6, r7)
            return r3
        L83:
            kotlinx.coroutines.scheduling.DefaultScheduler r2 = kotlinx.coroutines.Dispatchers.f54091a
            kotlinx.coroutines.scheduling.DefaultIoScheduler r2 = kotlinx.coroutines.scheduling.DefaultIoScheduler.f55150b
            com.chuckerteam.chucker.internal.ui.MainActivity$prepareDataToSave$2 r5 = new com.chuckerteam.chucker.internal.ui.MainActivity$prepareDataToSave$2
            r5.<init>(r7, r8, r6, r3)
            r0.f16877a = r3
            r0.f16878b = r3
            r0.f16881e = r4
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.e(r2, r5, r0)
            if (r6 != r1) goto L99
        L98:
            return r1
        L99:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chuckerteam.chucker.internal.ui.MainActivity.m(com.chuckerteam.chucker.internal.ui.MainActivity, com.chuckerteam.chucker.internal.ui.MainActivity$ExportType, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final DialogData n(int i2) {
        String string = getString(R.string.chucker_export);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(i2);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        return new DialogData(string, string2, getString(R.string.chucker_export), getString(R.string.chucker_cancel));
    }

    public final void o(Uri uri, ExportType exportType) {
        if (uri == null) {
            Toast.makeText(getApplicationContext(), R.string.chucker_save_failed_to_open_document, 0).show();
        } else {
            BuildersKt.c(LifecycleOwnerKt.a(this), null, new MainActivity$onSaveToFileActivityResult$1(uri, this, exportType, null), 3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x011b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0119 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[LOOP:0: B:29:0x00f1->B:75:?, LOOP_END, SYNTHETIC] */
    @Override // com.chuckerteam.chucker.internal.ui.BaseChuckerActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onCreate(android.os.Bundle r14) {
        /*
            Method dump skipped, instructions count: 457
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chuckerteam.chucker.internal.ui.MainActivity.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        getMenuInflater().inflate(R.menu.chucker_transactions_list, menu);
        MenuCompat.a(menu);
        View actionView = menu.findItem(R.id.search).getActionView();
        Intrinsics.d(actionView, "null cannot be cast to non-null type androidx.appcompat.widget.SearchView");
        SearchView searchView = (SearchView) actionView;
        searchView.setOnQueryTextListener(this);
        searchView.setIconifiedByDefault(true);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        int itemId = item.getItemId();
        if (itemId == R.id.clear) {
            String string = getString(R.string.chucker_clear);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String string2 = getString(R.string.chucker_clear_http_confirmation);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            final int i2 = 0;
            ContextExtKt.a(this, new DialogData(string, string2, getString(R.string.chucker_clear), getString(R.string.chucker_cancel)), new Function0(this) { // from class: com.chuckerteam.chucker.internal.ui.b

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ MainActivity f16893b;

                {
                    this.f16893b = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    CloseableCoroutineScope closeableCoroutineScope;
                    CoroutineContext coroutineContextO1;
                    switch (i2) {
                        case 0:
                            MainActivity mainActivity = this.f16893b;
                            int i3 = MainActivity.p;
                            MainViewModel mainViewModel = (MainViewModel) mainActivity.f16849j.getValue();
                            mainViewModel.getClass();
                            SynchronizedObject synchronizedObject = ViewModelKt.f4937a;
                            Intrinsics.checkNotNullParameter(mainViewModel, "<this>");
                            synchronized (ViewModelKt.f4937a) {
                                closeableCoroutineScope = (CloseableCoroutineScope) mainViewModel.c("androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY");
                                if (closeableCoroutineScope == null) {
                                    try {
                                        DefaultScheduler defaultScheduler = Dispatchers.f54091a;
                                        coroutineContextO1 = MainDispatcherLoader.f55099a.O1();
                                    } catch (IllegalStateException unused) {
                                        coroutineContextO1 = EmptyCoroutineContext.f53685a;
                                    } catch (NotImplementedError unused2) {
                                        coroutineContextO1 = EmptyCoroutineContext.f53685a;
                                    }
                                    CloseableCoroutineScope closeableCoroutineScope2 = new CloseableCoroutineScope(coroutineContextO1.plus(SupervisorKt.b()));
                                    mainViewModel.a("androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY", closeableCoroutineScope2);
                                    closeableCoroutineScope = closeableCoroutineScope2;
                                }
                            }
                            BuildersKt.c(closeableCoroutineScope, null, new MainViewModel$clearTransactions$1(2, null), 3);
                            LongSparseArray longSparseArray = NotificationHelper.f16779d;
                            synchronized (longSparseArray) {
                                longSparseArray.clear();
                                NotificationHelper.f16780e.clear();
                            }
                            return Unit.f53572a;
                        case 1:
                            int i4 = MainActivity.p;
                            MainActivity$onOptionsItemSelected$2$1 mainActivity$onOptionsItemSelected$2$1 = new MainActivity$onOptionsItemSelected$2$1(2, null);
                            MainActivity mainActivity2 = this.f16893b;
                            BuildersKt.c(LifecycleOwnerKt.a(mainActivity2), null, new MainActivity$exportTransactions$1(mainActivity2, mainActivity2.getApplicationContext(), mainActivity$onOptionsItemSelected$2$1, "transactions.txt", null), 3);
                            return Unit.f53572a;
                        default:
                            int i5 = MainActivity.p;
                            MainActivity mainActivity3 = this.f16893b;
                            MainActivity$onOptionsItemSelected$3$1 mainActivity$onOptionsItemSelected$3$1 = new MainActivity$onOptionsItemSelected$3$1(mainActivity3, null);
                            BuildersKt.c(LifecycleOwnerKt.a(mainActivity3), null, new MainActivity$exportTransactions$1(mainActivity3, mainActivity3.getApplicationContext(), mainActivity$onOptionsItemSelected$3$1, "transactions.har", null), 3);
                            return Unit.f53572a;
                    }
                }
            });
            return true;
        }
        if (itemId == R.id.share_text) {
            final int i3 = 1;
            ContextExtKt.a(this, n(R.string.chucker_export_text_http_confirmation), new Function0(this) { // from class: com.chuckerteam.chucker.internal.ui.b

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ MainActivity f16893b;

                {
                    this.f16893b = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    CloseableCoroutineScope closeableCoroutineScope;
                    CoroutineContext coroutineContextO1;
                    switch (i3) {
                        case 0:
                            MainActivity mainActivity = this.f16893b;
                            int i32 = MainActivity.p;
                            MainViewModel mainViewModel = (MainViewModel) mainActivity.f16849j.getValue();
                            mainViewModel.getClass();
                            SynchronizedObject synchronizedObject = ViewModelKt.f4937a;
                            Intrinsics.checkNotNullParameter(mainViewModel, "<this>");
                            synchronized (ViewModelKt.f4937a) {
                                closeableCoroutineScope = (CloseableCoroutineScope) mainViewModel.c("androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY");
                                if (closeableCoroutineScope == null) {
                                    try {
                                        DefaultScheduler defaultScheduler = Dispatchers.f54091a;
                                        coroutineContextO1 = MainDispatcherLoader.f55099a.O1();
                                    } catch (IllegalStateException unused) {
                                        coroutineContextO1 = EmptyCoroutineContext.f53685a;
                                    } catch (NotImplementedError unused2) {
                                        coroutineContextO1 = EmptyCoroutineContext.f53685a;
                                    }
                                    CloseableCoroutineScope closeableCoroutineScope2 = new CloseableCoroutineScope(coroutineContextO1.plus(SupervisorKt.b()));
                                    mainViewModel.a("androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY", closeableCoroutineScope2);
                                    closeableCoroutineScope = closeableCoroutineScope2;
                                }
                            }
                            BuildersKt.c(closeableCoroutineScope, null, new MainViewModel$clearTransactions$1(2, null), 3);
                            LongSparseArray longSparseArray = NotificationHelper.f16779d;
                            synchronized (longSparseArray) {
                                longSparseArray.clear();
                                NotificationHelper.f16780e.clear();
                            }
                            return Unit.f53572a;
                        case 1:
                            int i4 = MainActivity.p;
                            MainActivity$onOptionsItemSelected$2$1 mainActivity$onOptionsItemSelected$2$1 = new MainActivity$onOptionsItemSelected$2$1(2, null);
                            MainActivity mainActivity2 = this.f16893b;
                            BuildersKt.c(LifecycleOwnerKt.a(mainActivity2), null, new MainActivity$exportTransactions$1(mainActivity2, mainActivity2.getApplicationContext(), mainActivity$onOptionsItemSelected$2$1, "transactions.txt", null), 3);
                            return Unit.f53572a;
                        default:
                            int i5 = MainActivity.p;
                            MainActivity mainActivity3 = this.f16893b;
                            MainActivity$onOptionsItemSelected$3$1 mainActivity$onOptionsItemSelected$3$1 = new MainActivity$onOptionsItemSelected$3$1(mainActivity3, null);
                            BuildersKt.c(LifecycleOwnerKt.a(mainActivity3), null, new MainActivity$exportTransactions$1(mainActivity3, mainActivity3.getApplicationContext(), mainActivity$onOptionsItemSelected$3$1, "transactions.har", null), 3);
                            return Unit.f53572a;
                    }
                }
            });
            return true;
        }
        if (itemId == R.id.share_har) {
            final int i4 = 2;
            ContextExtKt.a(this, n(R.string.chucker_export_har_http_confirmation), new Function0(this) { // from class: com.chuckerteam.chucker.internal.ui.b

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ MainActivity f16893b;

                {
                    this.f16893b = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    CloseableCoroutineScope closeableCoroutineScope;
                    CoroutineContext coroutineContextO1;
                    switch (i4) {
                        case 0:
                            MainActivity mainActivity = this.f16893b;
                            int i32 = MainActivity.p;
                            MainViewModel mainViewModel = (MainViewModel) mainActivity.f16849j.getValue();
                            mainViewModel.getClass();
                            SynchronizedObject synchronizedObject = ViewModelKt.f4937a;
                            Intrinsics.checkNotNullParameter(mainViewModel, "<this>");
                            synchronized (ViewModelKt.f4937a) {
                                closeableCoroutineScope = (CloseableCoroutineScope) mainViewModel.c("androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY");
                                if (closeableCoroutineScope == null) {
                                    try {
                                        DefaultScheduler defaultScheduler = Dispatchers.f54091a;
                                        coroutineContextO1 = MainDispatcherLoader.f55099a.O1();
                                    } catch (IllegalStateException unused) {
                                        coroutineContextO1 = EmptyCoroutineContext.f53685a;
                                    } catch (NotImplementedError unused2) {
                                        coroutineContextO1 = EmptyCoroutineContext.f53685a;
                                    }
                                    CloseableCoroutineScope closeableCoroutineScope2 = new CloseableCoroutineScope(coroutineContextO1.plus(SupervisorKt.b()));
                                    mainViewModel.a("androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY", closeableCoroutineScope2);
                                    closeableCoroutineScope = closeableCoroutineScope2;
                                }
                            }
                            BuildersKt.c(closeableCoroutineScope, null, new MainViewModel$clearTransactions$1(2, null), 3);
                            LongSparseArray longSparseArray = NotificationHelper.f16779d;
                            synchronized (longSparseArray) {
                                longSparseArray.clear();
                                NotificationHelper.f16780e.clear();
                            }
                            return Unit.f53572a;
                        case 1:
                            int i42 = MainActivity.p;
                            MainActivity$onOptionsItemSelected$2$1 mainActivity$onOptionsItemSelected$2$1 = new MainActivity$onOptionsItemSelected$2$1(2, null);
                            MainActivity mainActivity2 = this.f16893b;
                            BuildersKt.c(LifecycleOwnerKt.a(mainActivity2), null, new MainActivity$exportTransactions$1(mainActivity2, mainActivity2.getApplicationContext(), mainActivity$onOptionsItemSelected$2$1, "transactions.txt", null), 3);
                            return Unit.f53572a;
                        default:
                            int i5 = MainActivity.p;
                            MainActivity mainActivity3 = this.f16893b;
                            MainActivity$onOptionsItemSelected$3$1 mainActivity$onOptionsItemSelected$3$1 = new MainActivity$onOptionsItemSelected$3$1(mainActivity3, null);
                            BuildersKt.c(LifecycleOwnerKt.a(mainActivity3), null, new MainActivity$exportTransactions$1(mainActivity3, mainActivity3.getApplicationContext(), mainActivity$onOptionsItemSelected$3$1, "transactions.har", null), 3);
                            return Unit.f53572a;
                    }
                }
            });
            return true;
        }
        if (itemId == R.id.save_text) {
            p(ExportType.f16856a);
            return true;
        }
        if (itemId != R.id.save_har) {
            return super.onOptionsItemSelected(item);
        }
        p(ExportType.f16857b);
        return true;
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public final void onQueryTextChange(String searchQuery) {
        Intrinsics.checkNotNullParameter(searchQuery, "newText");
        MainViewModel mainViewModel = (MainViewModel) this.f16849j.getValue();
        mainViewModel.getClass();
        Intrinsics.checkNotNullParameter(searchQuery, "searchQuery");
        mainViewModel.f16887b.k(searchQuery);
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public final boolean onQueryTextSubmit(String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        return true;
    }

    public final void p(final ExportType exportType) {
        int i2;
        int iOrdinal = exportType.ordinal();
        if (iOrdinal == 0) {
            i2 = R.string.chucker_save_text_http_confirmation;
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            i2 = R.string.chucker_save_har_http_confirmation;
        }
        String string = getString(R.string.chucker_save);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(i2);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        ContextExtKt.a(this, new DialogData(string, string2, getString(R.string.chucker_save), getString(R.string.chucker_cancel)), new Function0() { // from class: com.chuckerteam.chucker.internal.ui.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i3 = MainActivity.p;
                int iOrdinal2 = exportType.ordinal();
                MainActivity mainActivity = this;
                if (iOrdinal2 == 0) {
                    mainActivity.n.a("transactions.txt");
                } else {
                    if (iOrdinal2 != 1) {
                        throw new NoWhenBranchMatchedException();
                    }
                    mainActivity.o.a("transactions.har");
                }
                return Unit.f53572a;
            }
        });
    }
}
