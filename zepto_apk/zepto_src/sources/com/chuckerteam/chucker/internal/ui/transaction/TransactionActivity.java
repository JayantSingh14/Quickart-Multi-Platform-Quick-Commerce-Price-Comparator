package com.chuckerteam.chucker.internal.ui.transaction;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.chuckerteam.chucker.R;
import com.chuckerteam.chucker.databinding.ChuckerActivityTransactionBinding;
import com.chuckerteam.chucker.internal.data.entity.HttpTransaction;
import com.chuckerteam.chucker.internal.support.HarUtils;
import com.chuckerteam.chucker.internal.support.Sharable;
import com.chuckerteam.chucker.internal.support.TransactionCurlCommandSharable;
import com.chuckerteam.chucker.internal.support.TransactionDetailsHarSharable;
import com.chuckerteam.chucker.internal.support.TransactionDetailsSharable;
import com.chuckerteam.chucker.internal.ui.BaseChuckerActivity;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class TransactionActivity extends BaseChuckerActivity {

    /* renamed from: l, reason: collision with root package name */
    public static int f16905l;

    /* renamed from: j, reason: collision with root package name */
    public final ViewModelLazy f16906j = new ViewModelLazy(Reflection.a(TransactionViewModel.class), new Function0<ViewModelStore>() { // from class: com.chuckerteam.chucker.internal.ui.transaction.TransactionActivity$special$$inlined$viewModels$default$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return this.f16908c.getViewModelStore();
        }
    }, new b(this, 0), new Function0<CreationExtras>() { // from class: com.chuckerteam.chucker.internal.ui.transaction.TransactionActivity$special$$inlined$viewModels$default$3
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return this.f16909c.getDefaultViewModelCreationExtras();
        }
    });

    /* renamed from: k, reason: collision with root package name */
    public ChuckerActivityTransactionBinding f16907k;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    @DebugMetadata(c = "com.chuckerteam.chucker.internal.ui.transaction.TransactionActivity$onOptionsItemSelected$3", f = "TransactionActivity.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.chuckerteam.chucker.internal.ui.transaction.TransactionActivity$onOptionsItemSelected$3, reason: invalid class name */
    final class AnonymousClass3 extends SuspendLambda implements Function2<HttpTransaction, Continuation<? super Sharable>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f16910a;

        public AnonymousClass3(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass3 anonymousClass3 = TransactionActivity.this.new AnonymousClass3(continuation);
            anonymousClass3.f16910a = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass3) create((HttpTransaction) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            ResultKt.b(obj);
            HttpTransaction httpTransaction = (HttpTransaction) this.f16910a;
            int i2 = TransactionActivity.f16905l;
            Object objD = TransactionActivity.this.m().f16967c.d();
            Intrinsics.c(objD);
            return new TransactionDetailsSharable(httpTransaction, ((Boolean) objD).booleanValue());
        }
    }

    @Metadata
    @DebugMetadata(c = "com.chuckerteam.chucker.internal.ui.transaction.TransactionActivity$onOptionsItemSelected$4", f = "TransactionActivity.kt", l = {99}, m = "invokeSuspend")
    /* renamed from: com.chuckerteam.chucker.internal.ui.transaction.TransactionActivity$onOptionsItemSelected$4, reason: invalid class name */
    final class AnonymousClass4 extends SuspendLambda implements Function2<HttpTransaction, Continuation<? super Sharable>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f16912a;

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f16913b;

        public AnonymousClass4(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass4 anonymousClass4 = TransactionActivity.this.new AnonymousClass4(continuation);
            anonymousClass4.f16913b = obj;
            return anonymousClass4;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass4) create((HttpTransaction) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            int i2 = this.f16912a;
            if (i2 == 0) {
                ResultKt.b(obj);
                HttpTransaction httpTransaction = (HttpTransaction) this.f16913b;
                HarUtils harUtils = HarUtils.f16765a;
                List listH = CollectionsKt.H(httpTransaction);
                int i3 = R.string.chucker_name;
                TransactionActivity transactionActivity = TransactionActivity.this;
                String string = transactionActivity.getString(i3);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                String string2 = transactionActivity.getString(R.string.chucker_version);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                this.f16912a = 1;
                obj = harUtils.a(listH, string, string2, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return new TransactionDetailsHarSharable((String) obj);
        }
    }

    public final TransactionViewModel m() {
        return (TransactionViewModel) this.f16906j.getValue();
    }

    @Override // com.chuckerteam.chucker.internal.ui.BaseChuckerActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        View viewInflate = getLayoutInflater().inflate(R.layout.chucker_activity_transaction, (ViewGroup) null, false);
        int i2 = R.id.tabLayout;
        TabLayout tabLayout = (TabLayout) ViewBindings.a(i2, viewInflate);
        if (tabLayout != null) {
            i2 = R.id.toolbar;
            MaterialToolbar materialToolbar = (MaterialToolbar) ViewBindings.a(i2, viewInflate);
            if (materialToolbar != null) {
                i2 = R.id.toolbarTitle;
                TextView textView = (TextView) ViewBindings.a(i2, viewInflate);
                if (textView != null) {
                    i2 = R.id.viewPager;
                    ViewPager viewPager = (ViewPager) ViewBindings.a(i2, viewInflate);
                    if (viewPager != null) {
                        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) viewInflate;
                        this.f16907k = new ChuckerActivityTransactionBinding(coordinatorLayout, tabLayout, materialToolbar, textView, viewPager);
                        setContentView(coordinatorLayout);
                        setSupportActionBar(materialToolbar);
                        Intrinsics.checkNotNullExpressionValue(viewPager, "viewPager");
                        FragmentManager supportFragmentManager = getSupportFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                        viewPager.setAdapter(new TransactionPagerAdapter(this, supportFragmentManager));
                        TransactionActivity$setupViewPager$1 transactionActivity$setupViewPager$1 = new TransactionActivity$setupViewPager$1();
                        if (viewPager.D0 == null) {
                            viewPager.D0 = new ArrayList();
                        }
                        viewPager.D0.add(transactionActivity$setupViewPager$1);
                        viewPager.setCurrentItem(f16905l);
                        tabLayout.setupWithViewPager(viewPager);
                        ActionBar supportActionBar = getSupportActionBar();
                        if (supportActionBar != null) {
                            supportActionBar.r(true);
                        }
                        m().f16968d.e(this, new d(this, 1));
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        getMenuInflater().inflate(R.menu.chucker_transaction, menu);
        MenuItem menuItemFindItem = menu.findItem(R.id.encode_url);
        menuItemFindItem.setOnMenuItemClickListener(new a(this, 0));
        m().f16967c.e(this, new d(menuItemFindItem, 2));
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        int itemId = item.getItemId();
        if (itemId == R.id.share_text) {
            HttpTransaction transaction = (HttpTransaction) m().f16971g.d();
            if (transaction == null) {
                String string = getString(R.string.chucker_request_not_ready);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                BaseChuckerActivity.l(this, string);
                return true;
            }
            Intrinsics.checkNotNullParameter(transaction, "transaction");
            Object objD = m().f16967c.d();
            Intrinsics.c(objD);
            BuildersKt.c(LifecycleOwnerKt.a(this), null, new TransactionActivity$shareTransactionAsText$1(new TransactionDetailsSharable(transaction, ((Boolean) objD).booleanValue()), this, null), 3);
            return true;
        }
        if (itemId != R.id.share_curl) {
            if (itemId == R.id.share_file) {
                BuildersKt.c(LifecycleOwnerKt.a(this), null, new TransactionActivity$shareTransactionAsFile$1(this, new AnonymousClass3(null), "transaction.txt", null), 3);
                return true;
            }
            if (itemId != R.id.share_har) {
                return super.onOptionsItemSelected(item);
            }
            BuildersKt.c(LifecycleOwnerKt.a(this), null, new TransactionActivity$shareTransactionAsFile$1(this, new AnonymousClass4(null), "transaction.har", null), 3);
            return true;
        }
        HttpTransaction transaction2 = (HttpTransaction) m().f16971g.d();
        if (transaction2 == null) {
            String string2 = getString(R.string.chucker_request_not_ready);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            BaseChuckerActivity.l(this, string2);
            return true;
        }
        Intrinsics.checkNotNullParameter(transaction2, "transaction");
        BuildersKt.c(LifecycleOwnerKt.a(this), null, new TransactionActivity$shareTransactionAsText$1(new TransactionCurlCommandSharable(transaction2), this, null), 3);
        return true;
    }
}
