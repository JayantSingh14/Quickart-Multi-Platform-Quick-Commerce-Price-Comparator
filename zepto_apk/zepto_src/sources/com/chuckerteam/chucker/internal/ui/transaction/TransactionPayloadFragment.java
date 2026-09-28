package com.chuckerteam.chucker.internal.ui.transaction;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.SearchView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.brentvatne.common.react.r;
import com.chuckerteam.chucker.R;
import com.chuckerteam.chucker.databinding.ChuckerFragmentTransactionPayloadBinding;
import com.chuckerteam.chucker.internal.data.entity.HttpTransaction;
import com.chuckerteam.chucker.internal.support.LiveDataUtilsKt;
import com.chuckerteam.chucker.internal.support.SearchHighlightUtilKt;
import com.chuckerteam.chucker.internal.ui.transaction.TransactionBodyAdapter;
import com.chuckerteam.chucker.internal.ui.transaction.TransactionPayloadItem;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.IndexingIterable;
import kotlin.collections.IndexingIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt;
import kotlin.sequences.TransformingSequence;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import okio.Okio;
import okio.Source;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class TransactionPayloadFragment extends Fragment implements SearchView.OnQueryTextListener {
    public final TransactionBodyAdapter A0;
    public int B0;
    public int C0;
    public final int D0;
    public final ArrayList E0;
    public int F0;
    public String G0;
    public final ViewModelLazy Q = new ViewModelLazy(Reflection.a(TransactionViewModel.class), new Function0<ViewModelStore>() { // from class: com.chuckerteam.chucker.internal.ui.transaction.TransactionPayloadFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return this.f16940c.requireActivity().getViewModelStore();
        }
    }, new coil3.decode.b(6), new Function0<CreationExtras>() { // from class: com.chuckerteam.chucker.internal.ui.transaction.TransactionPayloadFragment$special$$inlined$activityViewModels$default$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return this.f16941c.requireActivity().getDefaultViewModelCreationExtras();
        }
    });
    public final Object X = LazyKt.a(LazyThreadSafetyMode.f53530c, new b(this, 1));
    public final ActivityResultLauncher Y;
    public ChuckerFragmentTransactionPayloadBinding Z;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[PayloadType.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                PayloadType payloadType = PayloadType.f16899a;
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Metadata
    @DebugMetadata(c = "com.chuckerteam.chucker.internal.ui.transaction.TransactionPayloadFragment$onQueryTextChange$1", f = "TransactionPayloadFragment.kt", l = {335, 540}, m = "invokeSuspend")
    @SourceDebugExtension
    /* renamed from: com.chuckerteam.chucker.internal.ui.transaction.TransactionPayloadFragment$onQueryTextChange$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f16942a;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return TransactionPayloadFragment.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0080, code lost:
        
            if (androidx.lifecycle.WithLifecycleStateKt.a(r1, r5, r4, r3, r8) == r0) goto L28;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
                int r1 = r8.f16942a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1d
                if (r1 == r3) goto L19
                if (r1 != r2) goto L11
                kotlin.ResultKt.b(r9)
                goto L83
            L11:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L19:
                kotlin.ResultKt.b(r9)
                goto L2b
            L1d:
                kotlin.ResultKt.b(r9)
                r8.f16942a = r3
                r3 = 600(0x258, double:2.964E-321)
                java.lang.Object r9 = kotlinx.coroutines.DelayKt.a(r3, r8)
                if (r9 != r0) goto L2b
                goto L82
            L2b:
                com.chuckerteam.chucker.internal.ui.transaction.TransactionPayloadFragment r9 = com.chuckerteam.chucker.internal.ui.transaction.TransactionPayloadFragment.this
                androidx.lifecycle.Lifecycle r1 = r9.getLifecycle()
                java.lang.String r3 = "<get-lifecycle>(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
                androidx.lifecycle.Lifecycle$State r3 = androidx.lifecycle.Lifecycle.State.f4809e
                kotlinx.coroutines.scheduling.DefaultScheduler r4 = kotlinx.coroutines.Dispatchers.f54091a
                kotlinx.coroutines.MainCoroutineDispatcher r4 = kotlinx.coroutines.internal.MainDispatcherLoader.f55099a
                kotlinx.coroutines.MainCoroutineDispatcher r4 = r4.O1()
                kotlin.coroutines.CoroutineContext r5 = r8.getContext()
                boolean r5 = r4.o1(r5)
                if (r5 != 0) goto L75
                androidx.lifecycle.Lifecycle$State r6 = r1.b()
                androidx.lifecycle.Lifecycle$State r7 = androidx.lifecycle.Lifecycle.State.f4805a
                if (r6 == r7) goto L6f
                androidx.lifecycle.Lifecycle$State r6 = r1.b()
                int r3 = r6.compareTo(r3)
                if (r3 < 0) goto L75
                java.util.ArrayList r0 = r9.E0
                boolean r0 = r0.isEmpty()
                if (r0 != 0) goto L69
                r0 = 0
                r9.E(r0)
                goto L6c
            L69:
                r0 = -1
                r9.F0 = r0
            L6c:
                kotlin.Unit r9 = kotlin.Unit.f53572a
                goto L83
            L6f:
                androidx.lifecycle.LifecycleDestroyedException r9 = new androidx.lifecycle.LifecycleDestroyedException
                r9.<init>()
                throw r9
            L75:
                com.chuckerteam.chucker.internal.ui.transaction.TransactionPayloadFragment$onQueryTextChange$1$invokeSuspend$$inlined$withResumed$1 r3 = new com.chuckerteam.chucker.internal.ui.transaction.TransactionPayloadFragment$onQueryTextChange$1$invokeSuspend$$inlined$withResumed$1
                r3.<init>(r9)
                r8.f16942a = r2
                java.lang.Object r9 = androidx.lifecycle.WithLifecycleStateKt.a(r1, r5, r4, r3, r8)
                if (r9 != r0) goto L83
            L82:
                return r0
            L83:
                kotlin.Unit r9 = kotlin.Unit.f53572a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chuckerteam.chucker.internal.ui.transaction.TransactionPayloadFragment.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public TransactionPayloadFragment() {
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.CreateDocument(), new ActivityResultCallback() { // from class: com.chuckerteam.chucker.internal.ui.transaction.g
            @Override // androidx.activity.result.ActivityResultCallback
            public final void b(Object obj) {
                Uri uri = (Uri) obj;
                TransactionPayloadFragment transactionPayloadFragment = this.f16986a;
                HttpTransaction httpTransaction = (HttpTransaction) transactionPayloadFragment.B().f16971g.d();
                Context applicationContext = transactionPayloadFragment.requireContext().getApplicationContext();
                if (uri == null || httpTransaction == null) {
                    Toast.makeText(applicationContext, R.string.chucker_save_failed_to_open_document, 0).show();
                } else {
                    BuildersKt.c(LifecycleOwnerKt.a(transactionPayloadFragment), null, new TransactionPayloadFragment$saveToFile$1$1(uri, applicationContext, transactionPayloadFragment, httpTransaction, null), 3);
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.Y = activityResultLauncherRegisterForActivityResult;
        this.A0 = new TransactionBodyAdapter(new TransactionPayloadFragment$payloadAdapter$1(0, this, TransactionPayloadFragment.class, "copyResponse", "copyResponse()V", 0));
        this.B0 = -256;
        this.C0 = -65536;
        this.D0 = -16711936;
        this.E0 = new ArrayList();
        this.F0 = -1;
        this.G0 = "";
    }

    public static final Source y(TransactionPayloadFragment transactionPayloadFragment, PayloadType payloadType, HttpTransaction httpTransaction) throws IOException {
        int iOrdinal = payloadType.ordinal();
        if (iOrdinal == 0) {
            String requestBody = httpTransaction.getRequestBody();
            if (requestBody == null) {
                throw new IOException("Transaction not ready");
            }
            byte[] bytes = requestBody.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            return Okio.m(new ByteArrayInputStream(bytes));
        }
        if (iOrdinal != 1) {
            throw new NoWhenBranchMatchedException();
        }
        String responseBody = httpTransaction.getResponseBody();
        if (responseBody == null) {
            throw new IOException("Transaction not ready");
        }
        byte[] bytes2 = responseBody.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        return Okio.m(new ByteArrayInputStream(bytes2));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    public final PayloadType A() {
        return (PayloadType) this.X.getValue();
    }

    public final TransactionViewModel B() {
        return (TransactionViewModel) this.Q.getValue();
    }

    public final void C(boolean z) {
        ChuckerFragmentTransactionPayloadBinding chuckerFragmentTransactionPayloadBinding = this.Z;
        if (chuckerFragmentTransactionPayloadBinding == null) {
            Intrinsics.h("payloadBinding");
            throw null;
        }
        LinearLayoutCompat rootSearchSummary = chuckerFragmentTransactionPayloadBinding.f16671e;
        Intrinsics.checkNotNullExpressionValue(rootSearchSummary, "rootSearchSummary");
        rootSearchSummary.setVisibility(z ? 0 : 8);
    }

    public final void D(boolean z) {
        View currentFocus;
        FragmentActivity activity = getActivity();
        Object systemService = activity != null ? activity.getSystemService("input_method") : null;
        Intrinsics.d(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        if (inputMethodManager.isAcceptingText()) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null && (currentFocus = activity2.getCurrentFocus()) != null) {
                currentFocus.clearFocus();
            }
            View view = getView();
            inputMethodManager.hideSoftInputFromWindow(view != null ? view.getWindowToken() : null, 0);
        }
        ArrayList arrayList = this.E0;
        if (arrayList.isEmpty()) {
            return;
        }
        E(z ? (this.F0 + 1) % arrayList.size() : Math.abs(arrayList.size() + (this.F0 - 1)) % arrayList.size());
    }

    public final void E(int i2) {
        ArrayList arrayList = this.E0;
        TransactionBodyAdapter.SearchItemBodyLine searchItemBodyLine = (TransactionBodyAdapter.SearchItemBodyLine) CollectionsKt.C(this.F0, arrayList);
        if (searchItemBodyLine != null) {
            String str = this.G0;
            this.A0.z(searchItemBodyLine.f16934a, searchItemBodyLine.f16935b, this.B0, this.C0, str);
        }
        this.F0 = i2;
        TransactionBodyAdapter.SearchItemBodyLine searchItemBodyLine2 = (TransactionBodyAdapter.SearchItemBodyLine) CollectionsKt.C(i2, arrayList);
        if (searchItemBodyLine2 != null) {
            String str2 = this.G0;
            this.A0.z(searchItemBodyLine2.f16934a, searchItemBodyLine2.f16935b, this.D0, this.C0, str2);
            int size = arrayList.size();
            int i3 = i2 + 1;
            ChuckerFragmentTransactionPayloadBinding chuckerFragmentTransactionPayloadBinding = this.Z;
            if (chuckerFragmentTransactionPayloadBinding == null) {
                Intrinsics.h("payloadBinding");
                throw null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            StyleSpan styleSpan = new StyleSpan(1);
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) (i3 + " / " + size));
            spannableStringBuilder.setSpan(styleSpan, length, spannableStringBuilder.length(), 17);
            chuckerFragmentTransactionPayloadBinding.f16674h.setText(spannableStringBuilder);
            C(true);
            ChuckerFragmentTransactionPayloadBinding chuckerFragmentTransactionPayloadBinding2 = this.Z;
            if (chuckerFragmentTransactionPayloadBinding2 == null) {
                Intrinsics.h("payloadBinding");
                throw null;
            }
            chuckerFragmentTransactionPayloadBinding2.f16670d.m0(searchItemBodyLine2.f16934a);
            this.F0 = i2;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        this.B0 = context.getColor(R.color.chucker_background_span_color);
        this.C0 = context.getColor(R.color.chucker_foreground_span_color);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onCreateOptionsMenu(android.view.Menu r8, android.view.MenuInflater r9) {
        /*
            r7 = this;
            java.lang.String r0 = "menu"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "inflater"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            com.chuckerteam.chucker.internal.ui.transaction.TransactionViewModel r0 = r7.B()
            androidx.lifecycle.LiveData r0 = r0.f16971g
            java.lang.Object r0 = r0.d()
            com.chuckerteam.chucker.internal.data.entity.HttpTransaction r0 = (com.chuckerteam.chucker.internal.data.entity.HttpTransaction) r0
            com.chuckerteam.chucker.internal.ui.transaction.PayloadType r1 = r7.A()
            int r1 = r1.ordinal()
            r2 = 0
            r4 = 1
            if (r1 == 0) goto L43
            if (r1 != r4) goto L3d
            if (r0 == 0) goto L74
            boolean r1 = r0.isResponseBodyEncoded()
            if (r1 != 0) goto L74
            java.lang.Long r1 = r0.getResponsePayloadSize()
            if (r1 != 0) goto L34
            goto L5a
        L34:
            long r5 = r1.longValue()
            int r1 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r1 == 0) goto L74
            goto L5a
        L3d:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        L43:
            if (r0 == 0) goto L74
            boolean r1 = r0.isRequestBodyEncoded()
            if (r1 != 0) goto L74
            java.lang.Long r1 = r0.getRequestPayloadSize()
            if (r1 != 0) goto L52
            goto L5a
        L52:
            long r5 = r1.longValue()
            int r1 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r1 == 0) goto L74
        L5a:
            int r1 = com.chuckerteam.chucker.R.id.search
            android.view.MenuItem r1 = r8.findItem(r1)
            r1.setVisible(r4)
            android.view.View r1 = r1.getActionView()
            java.lang.String r5 = "null cannot be cast to non-null type androidx.appcompat.widget.SearchView"
            kotlin.jvm.internal.Intrinsics.d(r1, r5)
            androidx.appcompat.widget.SearchView r1 = (androidx.appcompat.widget.SearchView) r1
            r1.setOnQueryTextListener(r7)
            r1.setIconifiedByDefault(r4)
        L74:
            com.chuckerteam.chucker.internal.ui.transaction.PayloadType r1 = r7.A()
            com.chuckerteam.chucker.internal.ui.transaction.PayloadType r5 = com.chuckerteam.chucker.internal.ui.transaction.PayloadType.f16899a
            if (r1 != r5) goto L8e
            if (r0 == 0) goto La8
            java.lang.Long r0 = r0.getRequestPayloadSize()
            if (r0 != 0) goto L85
            goto La8
        L85:
            long r0 = r0.longValue()
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 != 0) goto La8
            goto Lba
        L8e:
            com.chuckerteam.chucker.internal.ui.transaction.PayloadType r1 = r7.A()
            com.chuckerteam.chucker.internal.ui.transaction.PayloadType r6 = com.chuckerteam.chucker.internal.ui.transaction.PayloadType.f16900b
            if (r1 != r6) goto La8
            if (r0 == 0) goto La8
            java.lang.Long r0 = r0.getResponsePayloadSize()
            if (r0 != 0) goto L9f
            goto La8
        L9f:
            long r0 = r0.longValue()
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 != 0) goto La8
            goto Lba
        La8:
            int r0 = com.chuckerteam.chucker.R.id.save_body
            android.view.MenuItem r0 = r8.findItem(r0)
            r0.setVisible(r4)
            com.chuckerteam.chucker.internal.ui.transaction.a r1 = new com.chuckerteam.chucker.internal.ui.transaction.a
            r2 = 1
            r1.<init>(r7, r2)
            r0.setOnMenuItemClickListener(r1)
        Lba:
            com.chuckerteam.chucker.internal.ui.transaction.PayloadType r0 = r7.A()
            if (r0 != r5) goto Ld8
            com.chuckerteam.chucker.internal.ui.transaction.TransactionViewModel r0 = r7.B()
            androidx.lifecycle.MediatorLiveData r0 = r0.f16970f
            androidx.lifecycle.LifecycleOwner r1 = r7.getViewLifecycleOwner()
            com.chuckerteam.chucker.internal.ui.transaction.f r2 = new com.chuckerteam.chucker.internal.ui.transaction.f
            r2.<init>(r8)
            com.chuckerteam.chucker.internal.ui.transaction.TransactionPayloadFragment$sam$androidx_lifecycle_Observer$0 r3 = new com.chuckerteam.chucker.internal.ui.transaction.TransactionPayloadFragment$sam$androidx_lifecycle_Observer$0
            r3.<init>(r2)
            r0.e(r1, r3)
            goto Le2
        Ld8:
            int r0 = com.chuckerteam.chucker.R.id.encode_url
            android.view.MenuItem r0 = r8.findItem(r0)
            r1 = 0
            r0.setVisible(r1)
        Le2:
            super.onCreateOptionsMenu(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chuckerteam.chucker.internal.ui.transaction.TransactionPayloadFragment.onCreateOptionsMenu(android.view.Menu, android.view.MenuInflater):void");
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.chucker_fragment_transaction_payload, viewGroup, false);
        int i2 = R.id.emptyPayloadImage;
        if (((ImageView) ViewBindings.a(i2, viewInflate)) != null) {
            i2 = R.id.emptyPayloadTextView;
            TextView textView = (TextView) ViewBindings.a(i2, viewInflate);
            if (textView != null) {
                i2 = R.id.emptyStateGroup;
                Group group = (Group) ViewBindings.a(i2, viewInflate);
                if (group != null) {
                    i2 = R.id.loadingProgress;
                    CircularProgressIndicator circularProgressIndicator = (CircularProgressIndicator) ViewBindings.a(i2, viewInflate);
                    if (circularProgressIndicator != null) {
                        i2 = R.id.payloadRecyclerView;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.a(i2, viewInflate);
                        if (recyclerView != null) {
                            i2 = R.id.rootSearchSummary;
                            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.a(i2, viewInflate);
                            if (linearLayoutCompat != null) {
                                i2 = R.id.searchNavButton;
                                ImageButton imageButton = (ImageButton) ViewBindings.a(i2, viewInflate);
                                if (imageButton != null) {
                                    i2 = R.id.searchNavButtonUp;
                                    ImageButton imageButton2 = (ImageButton) ViewBindings.a(i2, viewInflate);
                                    if (imageButton2 != null) {
                                        i2 = R.id.searchSummary;
                                        TextView textView2 = (TextView) ViewBindings.a(i2, viewInflate);
                                        if (textView2 != null) {
                                            ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
                                            this.Z = new ChuckerFragmentTransactionPayloadBinding(constraintLayout, textView, group, circularProgressIndicator, recyclerView, linearLayoutCompat, imageButton, imageButton2, textView2);
                                            Intrinsics.checkNotNullExpressionValue(constraintLayout, "getRoot(...)");
                                            return constraintLayout;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public final void onQueryTextChange(String search) {
        Intrinsics.checkNotNullParameter(search, "newText");
        ArrayList arrayList = this.E0;
        arrayList.clear();
        this.G0 = search;
        this.F0 = -1;
        boolean z = StringsKt.z(search);
        TransactionBodyAdapter transactionBodyAdapter = this.A0;
        if (z || search.length() <= 1) {
            transactionBodyAdapter.A();
            C(false);
        } else {
            int i2 = this.B0;
            int i3 = this.C0;
            transactionBodyAdapter.getClass();
            Intrinsics.checkNotNullParameter(search, "newText");
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = transactionBodyAdapter.f16933e;
            ArrayList arrayList4 = new ArrayList();
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof TransactionPayloadItem.BodyLineItem) {
                    arrayList4.add(next);
                }
            }
            Intrinsics.checkNotNullParameter(arrayList4, "<this>");
            Iterator it2 = new IndexingIterable(new coil3.decode.a(arrayList4, 10)).iterator();
            while (true) {
                IndexingIterator indexingIterator = (IndexingIterator) it2;
                if (!indexingIterator.f53615a.hasNext()) {
                    break;
                }
                IndexedValue indexedValue = (IndexedValue) indexingIterator.next();
                TransactionPayloadItem.BodyLineItem bodyLineItem = (TransactionPayloadItem.BodyLineItem) indexedValue.f53613b;
                SpannableStringBuilder spannableStringBuilder = bodyLineItem.f16962a;
                Intrinsics.checkNotNullParameter(spannableStringBuilder, "<this>");
                Intrinsics.checkNotNullParameter(search, "input");
                Pattern patternCompile = Pattern.compile(search, 2);
                Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(...)");
                TransformingSequence transformingSequenceM = SequencesKt.m(Regex.a(new Regex(patternCompile), spannableStringBuilder), new r(4));
                ArrayList startIndices = new ArrayList();
                SequencesKt.p(transformingSequenceM, startIndices);
                boolean zIsEmpty = startIndices.isEmpty();
                int i4 = indexedValue.f53612a;
                if (!zIsEmpty) {
                    Iterator it3 = startIndices.iterator();
                    while (it3.hasNext()) {
                        arrayList2.add(new TransactionBodyAdapter.SearchItemBodyLine(i4 + 1, ((Number) it3.next()).intValue()));
                    }
                    TransactionBodyAdapter.y(bodyLineItem.f16962a);
                    SpannableStringBuilder spannableStringBuilder2 = bodyLineItem.f16962a;
                    Intrinsics.checkNotNullParameter(spannableStringBuilder2, "<this>");
                    Intrinsics.checkNotNullParameter(search, "search");
                    Intrinsics.checkNotNullParameter(startIndices, "startIndices");
                    int length = search.length();
                    Iterator it4 = startIndices.iterator();
                    while (it4.hasNext()) {
                        SearchHighlightUtilKt.a(spannableStringBuilder2, ((Number) it4.next()).intValue(), length, i2, i3);
                    }
                    Intrinsics.checkNotNullParameter(spannableStringBuilder2, "<set-?>");
                    bodyLineItem.f16962a = spannableStringBuilder2;
                    transactionBodyAdapter.h(i4 + 1);
                } else if (TransactionBodyAdapter.y(bodyLineItem.f16962a) > 0) {
                    transactionBodyAdapter.h(i4 + 1);
                }
            }
            if (arrayList2.isEmpty()) {
                transactionBodyAdapter.A();
                C(false);
            } else {
                arrayList.addAll(arrayList2);
            }
        }
        BuildersKt.c(LifecycleOwnerKt.a(this), null, new AnonymousClass1(null), 3);
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public final boolean onQueryTextSubmit(String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ChuckerFragmentTransactionPayloadBinding chuckerFragmentTransactionPayloadBinding = this.Z;
        if (chuckerFragmentTransactionPayloadBinding == null) {
            Intrinsics.h("payloadBinding");
            throw null;
        }
        RecyclerView recyclerView = chuckerFragmentTransactionPayloadBinding.f16670d;
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(this.A0);
        LiveData liveData = B().f16971g;
        MediatorLiveData other = B().f16972h;
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        LiveDataUtilsKt.a(liveData, other, new com.chuckerteam.chucker.internal.data.repository.a(1)).e(getViewLifecycleOwner(), new d(this, 0));
        ChuckerFragmentTransactionPayloadBinding chuckerFragmentTransactionPayloadBinding2 = this.Z;
        if (chuckerFragmentTransactionPayloadBinding2 == null) {
            Intrinsics.h("payloadBinding");
            throw null;
        }
        chuckerFragmentTransactionPayloadBinding2.f16672f.setOnClickListener(new e(this, 0));
        ChuckerFragmentTransactionPayloadBinding chuckerFragmentTransactionPayloadBinding3 = this.Z;
        if (chuckerFragmentTransactionPayloadBinding3 == null) {
            Intrinsics.h("payloadBinding");
            throw null;
        }
        chuckerFragmentTransactionPayloadBinding3.f16673g.setOnClickListener(new e(this, 1));
    }

    public final void z(String str, String str2, String str3) {
        FragmentActivity activity = getActivity();
        Object systemService = activity != null ? activity.getSystemService("clipboard") : null;
        Intrinsics.d(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(str2, str));
        Toast.makeText(getActivity(), str3, 1).show();
    }
}
