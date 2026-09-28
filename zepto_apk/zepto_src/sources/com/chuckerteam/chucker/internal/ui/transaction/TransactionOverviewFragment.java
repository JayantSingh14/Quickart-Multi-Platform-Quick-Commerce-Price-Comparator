package com.chuckerteam.chucker.internal.ui.transaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.viewbinding.ViewBindings;
import com.chuckerteam.chucker.R;
import com.chuckerteam.chucker.databinding.ChuckerFragmentTransactionOverviewBinding;
import com.chuckerteam.chucker.internal.support.LiveDataUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class TransactionOverviewFragment extends Fragment {
    public final ViewModelLazy Q = new ViewModelLazy(Reflection.a(TransactionViewModel.class), new Function0<ViewModelStore>() { // from class: com.chuckerteam.chucker.internal.ui.transaction.TransactionOverviewFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return this.f16936c.requireActivity().getViewModelStore();
        }
    }, new coil3.decode.b(5), new Function0<CreationExtras>() { // from class: com.chuckerteam.chucker.internal.ui.transaction.TransactionOverviewFragment$special$$inlined$activityViewModels$default$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return this.f16937c.requireActivity().getDefaultViewModelCreationExtras();
        }
    });
    public ChuckerFragmentTransactionOverviewBinding X;

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        menu.findItem(R.id.save_body).setVisible(false);
        ((TransactionViewModel) this.Q.getValue()).f16969e.e(getViewLifecycleOwner(), new d(menu, 3));
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.chucker_fragment_transaction_overview, viewGroup, false);
        int i2 = R.id.barrierRequestSize;
        if (((Barrier) ViewBindings.a(i2, viewInflate)) != null) {
            i2 = R.id.barrierRequestTime;
            if (((Barrier) ViewBindings.a(i2, viewInflate)) != null) {
                i2 = R.id.barrierResponseSize;
                if (((Barrier) ViewBindings.a(i2, viewInflate)) != null) {
                    i2 = R.id.barrierResponseTime;
                    if (((Barrier) ViewBindings.a(i2, viewInflate)) != null) {
                        i2 = R.id.cipherSuite;
                        TextView textView = (TextView) ViewBindings.a(i2, viewInflate);
                        if (textView != null) {
                            i2 = R.id.cipherSuiteGroup;
                            Group group = (Group) ViewBindings.a(i2, viewInflate);
                            if (group != null) {
                                i2 = R.id.cipherSuiteValue;
                                TextView textView2 = (TextView) ViewBindings.a(i2, viewInflate);
                                if (textView2 != null) {
                                    i2 = R.id.duration;
                                    TextView textView3 = (TextView) ViewBindings.a(i2, viewInflate);
                                    if (textView3 != null) {
                                        i2 = R.id.method;
                                        TextView textView4 = (TextView) ViewBindings.a(i2, viewInflate);
                                        if (textView4 != null) {
                                            i2 = R.id.overviewGuideline;
                                            if (((Guideline) ViewBindings.a(i2, viewInflate)) != null) {
                                                i2 = R.id.protocol;
                                                TextView textView5 = (TextView) ViewBindings.a(i2, viewInflate);
                                                if (textView5 != null) {
                                                    i2 = R.id.requestSize;
                                                    TextView textView6 = (TextView) ViewBindings.a(i2, viewInflate);
                                                    if (textView6 != null) {
                                                        i2 = R.id.requestSizeLabel;
                                                        TextView textView7 = (TextView) ViewBindings.a(i2, viewInflate);
                                                        if (textView7 != null) {
                                                            i2 = R.id.requestTime;
                                                            TextView textView8 = (TextView) ViewBindings.a(i2, viewInflate);
                                                            if (textView8 != null) {
                                                                i2 = R.id.requestTimeLabel;
                                                                TextView textView9 = (TextView) ViewBindings.a(i2, viewInflate);
                                                                if (textView9 != null) {
                                                                    i2 = R.id.response;
                                                                    TextView textView10 = (TextView) ViewBindings.a(i2, viewInflate);
                                                                    if (textView10 != null) {
                                                                        i2 = R.id.responseSize;
                                                                        TextView textView11 = (TextView) ViewBindings.a(i2, viewInflate);
                                                                        if (textView11 != null) {
                                                                            i2 = R.id.responseSizeLabel;
                                                                            TextView textView12 = (TextView) ViewBindings.a(i2, viewInflate);
                                                                            if (textView12 != null) {
                                                                                i2 = R.id.responseTime;
                                                                                TextView textView13 = (TextView) ViewBindings.a(i2, viewInflate);
                                                                                if (textView13 != null) {
                                                                                    i2 = R.id.responseTimeLabel;
                                                                                    TextView textView14 = (TextView) ViewBindings.a(i2, viewInflate);
                                                                                    if (textView14 != null) {
                                                                                        i2 = R.id.ssl;
                                                                                        TextView textView15 = (TextView) ViewBindings.a(i2, viewInflate);
                                                                                        if (textView15 != null) {
                                                                                            i2 = R.id.sslGroup;
                                                                                            Group group2 = (Group) ViewBindings.a(i2, viewInflate);
                                                                                            if (group2 != null) {
                                                                                                i2 = R.id.sslValue;
                                                                                                TextView textView16 = (TextView) ViewBindings.a(i2, viewInflate);
                                                                                                if (textView16 != null) {
                                                                                                    i2 = R.id.status;
                                                                                                    TextView textView17 = (TextView) ViewBindings.a(i2, viewInflate);
                                                                                                    if (textView17 != null) {
                                                                                                        i2 = R.id.tlsGroup;
                                                                                                        Group group3 = (Group) ViewBindings.a(i2, viewInflate);
                                                                                                        if (group3 != null) {
                                                                                                            i2 = R.id.tlsVersion;
                                                                                                            TextView textView18 = (TextView) ViewBindings.a(i2, viewInflate);
                                                                                                            if (textView18 != null) {
                                                                                                                i2 = R.id.tlsVersionValue;
                                                                                                                TextView textView19 = (TextView) ViewBindings.a(i2, viewInflate);
                                                                                                                if (textView19 != null) {
                                                                                                                    i2 = R.id.totalSize;
                                                                                                                    TextView textView20 = (TextView) ViewBindings.a(i2, viewInflate);
                                                                                                                    if (textView20 != null) {
                                                                                                                        i2 = R.id.url;
                                                                                                                        TextView textView21 = (TextView) ViewBindings.a(i2, viewInflate);
                                                                                                                        if (textView21 != null) {
                                                                                                                            ScrollView scrollView = (ScrollView) viewInflate;
                                                                                                                            this.X = new ChuckerFragmentTransactionOverviewBinding(scrollView, textView, group, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, group2, textView16, textView17, group3, textView18, textView19, textView20, textView21);
                                                                                                                            return scrollView;
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ViewModelLazy viewModelLazy = this.Q;
        LiveData liveData = ((TransactionViewModel) viewModelLazy.getValue()).f16971g;
        MutableLiveData other = ((TransactionViewModel) viewModelLazy.getValue()).f16967c;
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        LiveDataUtilsKt.a(liveData, other, new com.chuckerteam.chucker.internal.data.repository.a(1)).e(getViewLifecycleOwner(), new d(this, 4));
    }
}
