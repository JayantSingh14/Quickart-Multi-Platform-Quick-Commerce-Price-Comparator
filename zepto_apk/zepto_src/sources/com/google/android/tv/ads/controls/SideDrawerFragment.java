package com.google.android.tv.ads.controls;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.Keep;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.manager.SupportRequestManagerFragment;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.google.android.gms.internal.atv_ads_framework.zzav;
import com.google.android.gms.internal.atv_ads_framework.zzby;
import com.google.android.tv.ads.R;

/* loaded from: classes4.dex */
public final class SideDrawerFragment extends Fragment {
    public Button A0;
    public ConstraintLayout B0;
    public Button C0;
    public ConstraintLayout Q;
    public ConstraintLayout X;
    public ConstraintLayout Y;
    public ImageView Z;

    public SideDrawerFragment() {
        super(R.layout.fragment_side_drawer);
    }

    @Keep
    public float getBackgroundAlpha() {
        return this.Q.getAlpha();
    }

    @Keep
    public float getDrawerTranslationX() {
        return this.X.getTranslationX() / this.X.getWidth();
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Resources.NotFoundException {
        RequestManager requestManagerB;
        viewGroup.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.fragment_side_drawer, viewGroup, false);
        ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate.findViewById(R.id.side_drawer_base_layout);
        constraintLayout.getClass();
        this.Q = constraintLayout;
        ConstraintLayout constraintLayout2 = (ConstraintLayout) viewInflate.findViewById(R.id.side_drawer_frame_layout);
        constraintLayout2.getClass();
        this.X = constraintLayout2;
        ConstraintLayout constraintLayout3 = (ConstraintLayout) viewInflate.findViewById(R.id.why_this_ad_layout);
        constraintLayout3.getClass();
        this.Y = constraintLayout3;
        ConstraintLayout constraintLayout4 = (ConstraintLayout) viewInflate.findViewById(R.id.error_message_layout);
        constraintLayout4.getClass();
        this.B0 = constraintLayout4;
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.wta_image_view);
        imageView.getClass();
        this.Z = imageView;
        Button button = (Button) viewInflate.findViewById(R.id.why_this_ad_back_button);
        button.getClass();
        this.A0 = button;
        Button button2 = (Button) viewInflate.findViewById(R.id.error_message_back_button);
        button2.getClass();
        this.C0 = button2;
        boolean z = requireArguments().getBoolean("render_error_message");
        String string = requireArguments().getString("wta_uri");
        AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(requireContext(), R.animator.animator_drawer_in);
        animatorSet.setTarget(this);
        animatorSet.start();
        final AnimatorSet animatorSet2 = (AnimatorSet) AnimatorInflater.loadAnimator(requireContext(), R.animator.animator_drawer_out);
        animatorSet2.setTarget(this);
        animatorSet2.addListener(new zzc(this));
        this.A0.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.tv.ads.controls.zza
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                animatorSet2.start();
            }
        });
        this.C0.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.tv.ads.controls.zzb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                animatorSet2.start();
            }
        });
        requireActivity().getOnBackPressedDispatcher().a(this, new zzd(animatorSet2));
        if (z || string == null) {
            this.Y.setVisibility(8);
            this.B0.setVisibility(0);
            this.C0.requestFocus();
            return viewInflate;
        }
        this.Y.setVisibility(0);
        this.A0.requestFocus();
        String strB = zzav.b(requireArguments().getString("wta_uri"));
        String string2 = requireArguments().getString("wta_alt_text");
        if (!TextUtils.isEmpty(string2)) {
            this.Z.setContentDescription(string2);
        }
        Drawable drawable = getResources().getDrawable(R.drawable.placeholder_image, requireContext().getTheme());
        Context context = getContext();
        Preconditions.c(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        RequestManagerRetriever requestManagerRetriever = Glide.b(context).f15653f;
        requestManagerRetriever.getClass();
        Preconditions.c(getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        char[] cArr = Util.f16528a;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Context context2 = getContext();
            SupportRequestManagerFragment supportRequestManagerFragmentD = requestManagerRetriever.d(childFragmentManager, this, isVisible());
            RequestManager requestManager = supportRequestManagerFragmentD.A0;
            if (requestManager == null) {
                RequestManager requestManagerA = requestManagerRetriever.f16418e.a(Glide.b(context2), supportRequestManagerFragmentD.Q, supportRequestManagerFragmentD.X, context2);
                supportRequestManagerFragmentD.A0 = requestManagerA;
                requestManagerB = requestManagerA;
            } else {
                requestManagerB = requestManager;
            }
        } else {
            requestManagerB = requestManagerRetriever.b(getContext().getApplicationContext());
        }
        String strA = zzby.a(strB);
        requestManagerB.getClass();
        RequestBuilder requestBuilder = new RequestBuilder(requestManagerB.f15701a, requestManagerB, Drawable.class, requestManagerB.f15702b);
        requestBuilder.w = strA;
        requestBuilder.y = true;
        RequestBuilder requestBuilder2 = (RequestBuilder) requestBuilder.g(drawable);
        requestBuilder2.getClass();
        BaseRequestOptions baseRequestOptionsN = requestBuilder2.n(DownsampleStrategy.f16267a, new FitCenter());
        baseRequestOptionsN.p = true;
        ((RequestBuilder) baseRequestOptionsN).t(new zze(this, this.Z));
        return viewInflate;
    }

    @Keep
    public void setBackgroundAlpha(float f2) {
        this.Q.setAlpha(f2);
        this.Q.invalidate();
    }

    @Keep
    public void setDrawerTranslationX(float f2) {
        this.X.setTranslationX(r0.getWidth() * f2);
        this.X.invalidate();
    }
}
