package org.npci.upi.security.pinactivitycomponent;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.commons.lang3.time.DateUtils;
import org.npci.upi.security.pinactivitycomponent.widget.FormItemView;

/* loaded from: classes5.dex */
public abstract class s extends Fragment implements FormItemView.a {

    /* renamed from: f, reason: collision with root package name */
    protected PopupWindow f57572f;

    /* renamed from: h, reason: collision with root package name */
    protected Timer f57574h;

    /* renamed from: i, reason: collision with root package name */
    protected Handler f57575i;

    /* renamed from: j, reason: collision with root package name */
    protected Runnable f57576j;

    /* renamed from: l, reason: collision with root package name */
    protected Context f57578l;
    private g q;

    /* renamed from: a, reason: collision with root package name */
    protected Timer f57567a = null;

    /* renamed from: b, reason: collision with root package name */
    protected CountDownTimer f57568b = null;

    /* renamed from: c, reason: collision with root package name */
    protected long f57569c = DateUtils.MILLIS_PER_MINUTE;

    /* renamed from: d, reason: collision with root package name */
    protected ArrayList<org.npci.upi.security.pinactivitycomponent.widget.a> f57570d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    protected int f57571e = -1;

    /* renamed from: g, reason: collision with root package name */
    protected Timer f57573g = null;

    /* renamed from: k, reason: collision with root package name */
    protected long f57577k = 3000;
    private boolean p = false;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f57579m = false;
    protected int n = 2;
    protected boolean o = false;

    public int a(float f2) {
        return (int) (f2 * (getResources().getDisplayMetrics().densityDpi / 160));
    }

    public abstract void a();

    public abstract void b();

    public void b(t tVar) {
        a(tVar);
    }

    public Boolean c() {
        return Boolean.valueOf(((GetCredential) this.f57578l).getCredBlockBuilder().k());
    }

    public int d() {
        return this.f57579m ? this.f57571e - 1 : this.f57571e;
    }

    public void e() {
        this.p = false;
        this.n = ((GetCredential) this.f57578l).getCredBlockBuilder().m();
        this.o = ((GetCredential) this.f57578l).getCredBlockBuilder().l();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.f57578l = context;
        this.q = new g(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        Runnable runnable;
        super.onDestroy();
        a(this.f57567a);
        a(this.f57573g);
        a(this.f57568b);
        a(this.f57574h);
        Handler handler = this.f57575i;
        if (handler != null && (runnable = this.f57576j) != null) {
            handler.removeCallbacks(runnable);
        }
        PopupWindow popupWindow = this.f57572f;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getActivity() instanceof GetCredential) {
            ((GetCredential) getActivity()).setCurrentFragment(this);
            this.n = ((GetCredential) getActivity()).getCredBlockBuilder().m();
            this.o = ((GetCredential) getActivity()).getCredBlockBuilder().l();
        }
    }

    public FormItemView a(String str, int i2, int i3, String str2, Boolean bool, String str3) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        FormItemView formItemView = new FormItemView(getActivity(), this.f57578l);
        formItemView.setActionBarPositionTop(true);
        layoutParams.width = -2;
        formItemView.getFormInputView().setCharSize(0.0f);
        formItemView.getFormInputView().setSpace(a(15.0f));
        formItemView.getFormInputView().setFontSize(a(24.0f));
        formItemView.getFormInputView().setMargin(new int[]{80, a(25.0f), 80, 0});
        formItemView.getFormInputView().setLineStrokeCentered(true);
        formItemView.getFormInputView().setLineStrokeSelected(a(2.0f));
        formItemView.getFormInputView().setColorStates(ContextCompat.b(R.color.form_item_input_colors_transparent, getActivity()));
        formItemView.setLayoutParams(layoutParams);
        formItemView.setInputLength(i3);
        formItemView.setFormItemListener(this);
        formItemView.setTitle(str);
        formItemView.setFormItemTag(i2);
        formItemView.setSubtype(str3);
        formItemView.setEducationalText(str2);
        if (((GetCredential) this.f57578l).getCredBlockBuilder().j()) {
            formItemView.setForgotUpi(bool);
            return formItemView;
        }
        formItemView.setForgotUpi(Boolean.FALSE);
        return formItemView;
    }

    public void b(final FormItemView formItemView) {
        formItemView.a("", null, null, 0, false, false);
        formItemView.a((Drawable) null, false);
        this.f57568b = new CountDownTimer(this.f57569c, 1000L) { // from class: org.npci.upi.security.pinactivitycomponent.s.5
            @Override // android.os.CountDownTimer
            public void onFinish() {
                s.this.a(Boolean.TRUE);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                FormItemView formItemView2;
                String string;
                long j3 = j2 / 1000;
                long j4 = j3 - 15;
                if (j3 > 15) {
                    formItemView2 = formItemView;
                    string = Long.toString(j4) + "s";
                } else {
                    formItemView2 = formItemView;
                    string = s.this.getString(R.string.waiting_for_otp);
                }
                formItemView2.a(string, null, true, false);
            }
        }.start();
        formItemView.a(false);
    }

    public void a(final int i2) {
        if (getActivity() != null && (getActivity() instanceof GetCredential)) {
            ((GetCredential) getActivity()).setNumDigitsOfOTP(i2);
        }
        final u uVar = new u(getActivity());
        Timer timer = new Timer();
        this.f57567a = timer;
        timer.scheduleAtFixedRate(new TimerTask() { // from class: org.npci.upi.security.pinactivitycomponent.s.1

            /* renamed from: a, reason: collision with root package name */
            long f57580a = System.currentTimeMillis() - 45000;

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() throws Throwable {
                final t tVarA = uVar.a(i2, this.f57580a - 10000);
                if (tVarA != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: org.npci.upi.security.pinactivitycomponent.s.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            s.this.a(tVarA);
                        }
                    });
                }
                this.f57580a = System.currentTimeMillis();
            }
        }, 100L, 2000L);
    }

    public boolean b(org.npci.upi.security.pinactivitycomponent.widget.a aVar) {
        if (aVar instanceof FormItemView) {
            return ((FormItemView) aVar).getSubtype().equals(CLConstants.CREDTYPE_AADHAAR);
        }
        return false;
    }

    public void a(CountDownTimer countDownTimer) {
        if (countDownTimer != null) {
            try {
                countDownTimer.cancel();
            } catch (Exception e2) {
                q.a("NPCIFragment", e2);
            }
        }
    }

    public void a(View view, String str) {
        PopupWindow popupWindow = this.f57572f;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        final View viewFindViewById = getActivity().findViewById(R.id.popupView);
        viewFindViewById.setVisibility(0);
        viewFindViewById.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.npci_slide_in_top));
        ((TextView) viewFindViewById.findViewById(R.id.popup_text)).setText(str);
        viewFindViewById.findViewById(R.id.popup_button).setOnClickListener(new View.OnClickListener() { // from class: org.npci.upi.security.pinactivitycomponent.s.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                viewFindViewById.setVisibility(8);
            }
        });
        this.f57574h = new Timer();
        this.f57575i = new Handler(Looper.getMainLooper());
        Runnable runnable = new Runnable() { // from class: org.npci.upi.security.pinactivitycomponent.s.3
            @Override // java.lang.Runnable
            public void run() {
                viewFindViewById.setVisibility(8);
            }
        };
        this.f57576j = runnable;
        this.f57575i.postDelayed(runnable, this.f57577k);
    }

    public void a(Boolean bool) {
        if ((!((GetCredential) this.f57578l).getCredBlockBuilder().l() || this.p) && !bool.booleanValue()) {
            a((FormItemView) this.f57570d.get(d()));
        } else {
            getActivity().runOnUiThread(new Runnable() { // from class: org.npci.upi.security.pinactivitycomponent.s.4
                private void a(final FormItemView formItemView) {
                    s sVar;
                    int i2;
                    formItemView.a(false);
                    s sVar2 = s.this;
                    if (sVar2.n <= 0) {
                        sVar2.a(formItemView);
                        return;
                    }
                    if (formItemView.getSubtype().equals(CLConstants.CREDTYPE_AADHAAR)) {
                        sVar = s.this;
                        i2 = R.string.action_resend_aadhaar_otp;
                    } else {
                        sVar = s.this;
                        i2 = R.string.action_resend_bank_otp;
                    }
                    formItemView.a(sVar.getString(i2), s.this.getActivity().getDrawable(R.drawable.ic_action_reload), new View.OnClickListener() { // from class: org.npci.upi.security.pinactivitycomponent.s.4.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ResultReceiver resultReceiverC;
                            int i3;
                            formItemView.getFormInputView().setText("");
                            r3.n--;
                            s.this.b(formItemView);
                            Bundle bundle = new Bundle();
                            bundle.putString("action", CLConstants.OUTPUT_ACTION_TRIGGEROTP);
                            if (formItemView.getSubtype().equals(CLConstants.CREDTYPE_AADHAAR)) {
                                resultReceiverC = ((GetCredential) s.this.f57578l).getCredBlockBuilder().g().c();
                                i3 = 4;
                            } else {
                                resultReceiverC = ((GetCredential) s.this.f57578l).getCredBlockBuilder().g().c();
                                i3 = 2;
                            }
                            resultReceiverC.send(i3, bundle);
                        }
                    }, 0, true, true);
                }

                @Override // java.lang.Runnable
                public void run() {
                    ArrayList<org.npci.upi.security.pinactivitycomponent.widget.a> arrayList;
                    int iD;
                    s sVar = s.this;
                    if (sVar.f57571e == -1 || !(sVar.f57570d.get(sVar.d()) instanceof FormItemView)) {
                        return;
                    }
                    s sVar2 = s.this;
                    if (((FormItemView) sVar2.f57570d.get(sVar2.d())).isShown()) {
                        s sVar3 = s.this;
                        arrayList = sVar3.f57570d;
                        iD = sVar3.d();
                    } else {
                        s sVar4 = s.this;
                        arrayList = sVar4.f57570d;
                        iD = sVar4.f57571e;
                    }
                    FormItemView formItemView = (FormItemView) arrayList.get(iD);
                    if (((GetCredential) s.this.f57578l).getCredBlockBuilder().l()) {
                        a(formItemView);
                    } else {
                        s.this.a(formItemView);
                    }
                }
            });
        }
    }

    public void a(Timer timer) {
        if (timer != null) {
            try {
                timer.cancel();
            } catch (Exception e2) {
                q.a("NPCIFragment", e2);
            }
        }
    }

    public void a(t tVar) {
        ArrayList<org.npci.upi.security.pinactivitycomponent.widget.a> arrayList;
        int iD;
        try {
            if (this.f57571e != -1) {
                if (((FormItemView) this.f57570d.get(d())).isShown()) {
                    arrayList = this.f57570d;
                    iD = d();
                } else {
                    arrayList = this.f57570d;
                    iD = this.f57571e;
                }
                FormItemView formItemView = (FormItemView) arrayList.get(iD);
                if (!this.f57579m) {
                    String strA = this.q.a(CLConstants.SHARED_PREFERENCE_BANK_OTP, "");
                    if (strA.isEmpty()) {
                        return;
                    }
                    this.p = true;
                    this.f57570d.get(d()).setText(strA);
                    formItemView.setText(strA);
                } else {
                    if (formItemView.getSubType().equals(CLConstants.CREDTYPE_AADHAAR) && tVar.a().contains(CLConstants.CREDTYPE_AADHAAR)) {
                        String strA2 = this.q.a(CLConstants.SHARED_PREFERENCE_AADHAAR_OTP, "");
                        if (strA2.isEmpty()) {
                            return;
                        }
                        this.p = true;
                        formItemView.setText(strA2);
                        this.q.b(CLConstants.SHARED_PREFERENCE_AADHAAR_OTP, "");
                        return;
                    }
                    if (!formItemView.getSubType().equals(CLConstants.CREDTYPE_SMS) || this.p) {
                        return;
                    }
                    String strA3 = this.q.a(CLConstants.SHARED_PREFERENCE_BANK_OTP, "");
                    if (strA3.isEmpty()) {
                        return;
                    }
                    this.p = true;
                    formItemView.setText(strA3);
                }
                this.q.b(CLConstants.SHARED_PREFERENCE_BANK_OTP, "");
            }
        } catch (Exception unused) {
        }
    }

    public void a(FormItemView formItemView) {
        formItemView.a(getString(formItemView.getSubtype().equals(CLConstants.CREDTYPE_AADHAAR) ? R.string.aadhaar_otp_limit_info : R.string.bank_otp_limit_info), null, true, false);
    }

    public boolean a(org.npci.upi.security.pinactivitycomponent.widget.a aVar) {
        if (aVar instanceof FormItemView) {
            return ((FormItemView) aVar).getSubtype().equals(CLConstants.CREDTYPE_SMS);
        }
        return false;
    }
}
