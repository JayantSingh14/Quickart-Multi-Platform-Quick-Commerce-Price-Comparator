package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.ViewUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.plus.PlusOneDummyView;

@Deprecated
/* loaded from: classes4.dex */
public final class PlusOneButton extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public PlusOneDummyView f39683a;

    /* renamed from: b, reason: collision with root package name */
    public int f39684b;

    /* renamed from: c, reason: collision with root package name */
    public final int f39685c;

    /* renamed from: d, reason: collision with root package name */
    public OnPlusOneClickListener f39686d;

    @Deprecated
    public class DefaultOnPlusOneClickListener implements View.OnClickListener, OnPlusOneClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final OnPlusOneClickListener f39687a;

        public DefaultOnPlusOneClickListener(OnPlusOneClickListener onPlusOneClickListener) {
            this.f39687a = onPlusOneClickListener;
        }

        @Override // com.google.android.gms.plus.PlusOneButton.OnPlusOneClickListener
        public final void a(Intent intent) {
            PlusOneButton plusOneButton = PlusOneButton.this;
            Context context = plusOneButton.getContext();
            if (!(context instanceof Activity) || intent == null) {
                return;
            }
            ((Activity) context).startActivityForResult(intent, plusOneButton.f39685c);
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Intent intent = (Intent) PlusOneButton.this.f39683a.getTag();
            OnPlusOneClickListener onPlusOneClickListener = this.f39687a;
            if (onPlusOneClickListener != null) {
                onPlusOneClickListener.a(intent);
            } else {
                a(intent);
            }
        }
    }

    @Deprecated
    public interface OnPlusOneClickListener {
        void a(Intent intent);
    }

    @Deprecated
    public PlusOneButton(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        String xmlAttributeString = ViewUtils.getXmlAttributeString("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "size", context, attributeSet, true, false, "PlusOneButton");
        this.f39684b = "SMALL".equalsIgnoreCase(xmlAttributeString) ? 0 : "MEDIUM".equalsIgnoreCase(xmlAttributeString) ? 1 : "TALL".equalsIgnoreCase(xmlAttributeString) ? 2 : 3;
        String xmlAttributeString2 = ViewUtils.getXmlAttributeString("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "annotation", context, attributeSet, true, false, "PlusOneButton");
        if (!"INLINE".equalsIgnoreCase(xmlAttributeString2)) {
            "NONE".equalsIgnoreCase(xmlAttributeString2);
        }
        this.f39685c = -1;
        a(getContext());
        isInEditMode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(Context context) {
        int i2;
        PlusOneDummyView plusOneDummyView = this.f39683a;
        if (plusOneDummyView != null) {
            removeView(plusOneDummyView);
        }
        int i3 = this.f39684b;
        try {
            throw new NullPointerException();
        } catch (Exception unused) {
            PlusOneDummyView plusOneDummyView2 = new PlusOneDummyView(context);
            Button button = new Button(context);
            button.setEnabled(false);
            Context context2 = plusOneDummyView2.getContext();
            PlusOneDummyView.zzb zzbVar = new PlusOneDummyView.zzb();
            zzbVar.f39690a = context2;
            boolean zB = zzbVar.b();
            PlusOneDummyView.zzb zzbVar2 = zzbVar;
            if (!zB) {
                Context context3 = plusOneDummyView2.getContext();
                PlusOneDummyView.zzc zzcVar = new PlusOneDummyView.zzc();
                zzcVar.f39691a = context3;
                zzbVar2 = zzcVar;
            }
            boolean zB2 = zzbVar2.b();
            PlusOneDummyView.zzb zzbVar3 = zzbVar2;
            if (!zB2) {
                Context context4 = plusOneDummyView2.getContext();
                PlusOneDummyView.zza zzaVar = new PlusOneDummyView.zza();
                zzaVar.f39689a = context4;
                zzbVar3 = zzaVar;
            }
            button.setBackgroundDrawable(zzbVar3.a(i3));
            Point point = new Point();
            int i4 = 24;
            if (i3 != 0) {
                i2 = 20;
                if (i3 == 1) {
                    i4 = 32;
                } else if (i3 != 2) {
                    i2 = 24;
                    i4 = 38;
                } else {
                    i4 = 50;
                }
            } else {
                i2 = 14;
            }
            DisplayMetrics displayMetrics = plusOneDummyView2.getResources().getDisplayMetrics();
            float fApplyDimension = TypedValue.applyDimension(1, i4, displayMetrics);
            float fApplyDimension2 = TypedValue.applyDimension(1, i2, displayMetrics);
            point.x = (int) (fApplyDimension + 0.5d);
            point.y = (int) (fApplyDimension2 + 0.5d);
            plusOneDummyView2.addView(button, new FrameLayout.LayoutParams(point.x, point.y, 17));
            this.f39683a = plusOneDummyView2;
            setOnPlusOneClickListener(this.f39686d);
            addView(this.f39683a);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        this.f39683a.layout(0, 0, i4 - i2, i5 - i3);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i2, int i3) {
        PlusOneDummyView plusOneDummyView = this.f39683a;
        measureChild(plusOneDummyView, i2, i3);
        setMeasuredDimension(plusOneDummyView.getMeasuredWidth(), plusOneDummyView.getMeasuredHeight());
    }

    @Deprecated
    public final void setAnnotation(int i2) {
        a(getContext());
    }

    @VisibleForTesting
    @Deprecated
    public final void setIntent(Intent intent) {
        this.f39683a.setTag(intent);
    }

    @Deprecated
    public final void setOnPlusOneClickListener(OnPlusOneClickListener onPlusOneClickListener) {
        this.f39686d = onPlusOneClickListener;
        this.f39683a.setOnClickListener(new DefaultOnPlusOneClickListener(onPlusOneClickListener));
    }

    @Deprecated
    public final void setSize(int i2) {
        this.f39684b = i2;
        a(getContext());
    }
}
