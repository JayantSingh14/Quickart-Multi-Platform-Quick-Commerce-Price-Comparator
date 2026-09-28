package org.npci.upi.security.pinactivitycomponent;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;
import androidx.annotation.Nullable;
import in.org.npci.commonlibrary.Message;
import java.util.ArrayList;
import java.util.Timer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.widget.FormItemPager;
import org.npci.upi.security.pinactivitycomponent.widget.FormItemView;

/* loaded from: classes5.dex */
public class w extends s implements FormItemView.a {
    private static final String v = "s";
    private View A;
    private boolean B;
    private Boolean C;
    private String D;
    private Boolean E;
    private int F;
    private int G;
    private int H;
    private boolean I;
    private Boolean J;
    private Boolean K;
    private boolean L;
    private e M;
    LinearLayout p;
    LinearLayout q;
    LinearLayout r;
    LinearLayout s;
    WebView t;
    Message u;
    private int w = 0;
    private Boolean x;
    private Timer y;
    private ViewFlipper z;

    public w() {
        Boolean bool = Boolean.FALSE;
        this.x = bool;
        this.y = null;
        this.z = null;
        this.s = null;
        this.t = null;
        this.A = null;
        this.B = false;
        this.C = bool;
        this.D = "";
        this.E = bool;
        this.I = false;
        this.J = bool;
        this.K = bool;
        this.L = false;
    }

    private void c(int i2) {
        if (this.f57571e != -1 && (this.f57570d.get(d()) instanceof FormItemView)) {
            FormItemView formItemView = (FormItemView) this.f57570d.get(d());
            b(formItemView);
            formItemView.setNonMaskedField();
            if (!new g(this.f57578l).a(CLConstants.SHARED_PREFERENCE_BANK_OTP, "").isEmpty()) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: org.npci.upi.security.pinactivitycomponent.w.3
                    @Override // java.lang.Runnable
                    public void run() {
                        t tVar = new t();
                        tVar.b(CLConstants.CREDTYPE_SMS);
                        w.this.b(tVar);
                    }
                }, 1500L);
            }
        }
        int size = this.f57570d.size();
        while (i2 < size) {
            if (i2 != d() && (this.f57571e == -1 || !(this.f57570d.get(i2) instanceof FormItemView) || ((!a(this.f57570d.get(i2)) || !this.f57579m) && !b(this.f57570d.get(i2))))) {
                final org.npci.upi.security.pinactivitycomponent.widget.a aVar = this.f57570d.get(i2);
                final Drawable drawable = getActivity().getDrawable(R.drawable.ic_visibility_on);
                Drawable drawable2 = getActivity().getDrawable(R.drawable.ic_visibility_blue_24px);
                final Drawable drawable3 = getActivity().getDrawable(R.drawable.ic_visibility_off);
                final String string = getString(R.string.action_hide);
                final String string2 = getString(R.string.action_show);
                aVar.a(string2, drawable2, new View.OnClickListener() { // from class: org.npci.upi.security.pinactivitycomponent.w.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        org.npci.upi.security.pinactivitycomponent.widget.a aVar2;
                        String str;
                        Drawable drawable4;
                        boolean z;
                        boolean z2;
                        int iE = aVar.e();
                        boolean zC = aVar.c();
                        if (iE == 0) {
                            aVar2 = aVar;
                            str = zC ? string : string2;
                            drawable4 = zC ? drawable3 : drawable;
                            z = true;
                            z2 = false;
                        } else {
                            aVar2 = aVar;
                            str = zC ? string : string2;
                            drawable4 = zC ? drawable3 : drawable;
                            z = true;
                            z2 = true;
                        }
                        aVar2.a(str, drawable4, this, 0, z, z2);
                    }
                }, 0, false, false);
            }
            i2++;
        }
    }

    private void g() throws JSONException {
        FormItemView formItemView;
        String inputValue;
        if (this.f57571e != -1 && (this.f57570d.get(d()) instanceof FormItemView) && ((inputValue = (formItemView = (FormItemView) this.f57570d.get(d())).getInputValue()) == null || inputValue.length() != formItemView.getInputLength())) {
            a(formItemView, getString(R.string.invalid_otp));
            return;
        }
        for (int i2 = 0; i2 < this.f57570d.size(); i2++) {
            if (this.f57570d.get(i2) instanceof FormItemView) {
                FormItemView formItemView2 = (FormItemView) this.f57570d.get(i2);
                if (formItemView2.getInputValue().length() != formItemView2.getInputLength()) {
                    a(formItemView2, getString(R.string.error_message_mpin, Integer.valueOf(this.F)));
                    return;
                }
            }
        }
        if (this.B) {
            return;
        }
        this.B = true;
        for (int i3 = 0; i3 < this.f57570d.size(); i3++) {
            try {
                JSONObject jSONObject = (JSONObject) this.f57570d.get(i3).getFormDataTag();
                String string = jSONObject.getString("type");
                String string2 = jSONObject.getString(CLConstants.FIELD_SUBTYPE);
                this.M.d().put(CLConstants.SALT_FIELD_CREDENTIAL, this.f57570d.get(i3).getInputValue());
                JSONObject jSONObjectD = this.M.d();
                JSONArray jSONArray = new JSONArray();
                for (int i4 = 0; i4 < this.M.n().length(); i4++) {
                    jSONObjectD.put(CLConstants.SALT_FIELD_TXN_ID, this.M.o().get(i4));
                    jSONObjectD.put(CLConstants.OUTPUT_CRED_TYPE, this.M.n().get(i4));
                    jSONArray.put(((GetCredential) this.f57578l).getCredBlockBuilder().g().a().a(jSONObjectD));
                    Message messageA = ((GetCredential) this.f57578l).getCredBlockBuilder().g().b().a(jSONArray.getString(i4), string, string2, jSONObjectD, Boolean.FALSE);
                    this.u = messageA;
                    if (messageA != null) {
                        ((GetCredential) this.f57578l).getCredBlockBuilder().b(this.M.n().getString(i4), m.a(this.u));
                    }
                }
                ((GetCredential) this.f57578l).getCredBlockBuilder().a(string2, ((GetCredential) this.f57578l).getCredBlockBuilder().i().toString());
            } catch (Exception e2) {
                q.a(v, e2);
            }
        }
        Boolean boolValueOf = Boolean.FALSE;
        if (this.M.c() != null) {
            boolValueOf = Boolean.valueOf(Boolean.parseBoolean(this.M.c().optString(CLConstants.FIELD_GET_DEVICE_DETAILS, "false")));
        }
        if (boolValueOf.booleanValue()) {
            ((GetCredential) this.f57578l).getCredBlockBuilder().a(CLConstants.OUTPUT_CRED_DEV_DET_TAG, ((GetCredential) this.f57578l).getCredBlockBuilder().g().b().a(this.M.d(), new h(this.f57578l).a()));
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(CLConstants.OUTPUT_CRED_CREDBLOCK_TAG, ((GetCredential) this.f57578l).getCredBlockBuilder().h());
        ((GetCredential) this.f57578l).getCredBlockBuilder().g().c().send(1, bundle);
        getActivity().finish();
    }

    private void h() {
        final org.npci.upi.security.pinactivitycomponent.widget.a aVar = this.f57570d.get(0);
        final Drawable drawable = getActivity().getDrawable(R.drawable.btn_checkbox_off);
        final Drawable drawable2 = getActivity().getDrawable(R.drawable.btn_checkbox_on);
        try {
            aVar.a(getString(R.string.edit_card_number), drawable, new View.OnClickListener() { // from class: org.npci.upi.security.pinactivitycomponent.w.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    aVar.a("", aVar.d() ? drawable2 : drawable, this, 0, true, true);
                }
            }, 0, true, true);
        } catch (Exception e2) {
            q.a(v, e2);
        }
    }

    private JSONObject i() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", CLConstants.CREDTYPE_DEBIT_TYPE);
            jSONObject.put(CLConstants.FIELD_SUBTYPE, CLConstants.CREDTYPE_DEBIT);
            jSONObject.put(CLConstants.FIELD_DTYPE, CLConstants.CREDTYPE_DEBIT_NUM);
            jSONObject.put(CLConstants.FIELD_DLENGTH, CLConstants.CREDTYPE_DEBIT_DLENGTH);
            return jSONObject;
        } catch (Exception e2) {
            q.a(v, "Error while creating JSON Obj" + e2);
            return jSONObject;
        }
    }

    @Override // org.npci.upi.security.pinactivitycomponent.widget.FormItemView.a
    public void b(int i2) {
        if (this.f57570d.get(i2) instanceof FormItemPager) {
            return;
        }
        this.w = i2;
    }

    public void f() {
        WebView webView = this.t;
        if (webView != null) {
            webView.destroy();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_pin, viewGroup, false);
    }

    @Override // org.npci.upi.security.pinactivitycomponent.s, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) throws JSONException {
        this.A = view;
        super.onViewCreated(view, bundle);
        this.M = ((GetCredential) this.f57578l).getCredBlockBuilder();
        this.q = (LinearLayout) view.findViewById(R.id.main_inner_layout);
        this.p = (LinearLayout) view.findViewById(R.id.main_layout);
        this.r = (LinearLayout) view.findViewById(R.id.progressbar_layout);
        this.s = (LinearLayout) view.findViewById(R.id.progressbar_otp);
        if (((GetCredential) this.f57578l).getCredBlockBuilder().f().booleanValue()) {
            this.E = Boolean.TRUE;
        }
        a(view);
    }

    private void a(View view) throws JSONException {
        this.z = (ViewFlipper) view.findViewById(R.id.view_switcher);
        if (this.M.a() && c().booleanValue()) {
            JSONArray jSONArray = new JSONArray();
            try {
                jSONArray.put(0, i());
                int i2 = 0;
                while (i2 < this.M.p().length()) {
                    int i3 = i2 + 1;
                    jSONArray.put(i3, this.M.p().get(i2));
                    i2 = i3;
                }
                this.M.b(jSONArray);
                b(view);
                h();
            } catch (JSONException e2) {
                q.a(v, "Error while creating JSON Obj" + e2);
            }
        } else {
            a(view, (Integer) 0);
            c(0);
        }
        view.getFocusables(2).get(0).requestFocus();
    }

    private void b(View view) throws JSONException {
        JSONObject jSONObject;
        String string;
        int iOptInt;
        try {
            jSONObject = this.M.p().getJSONObject(0);
            string = jSONObject.getString(CLConstants.FIELD_SUBTYPE);
            iOptInt = jSONObject.optInt(CLConstants.FIELD_DLENGTH) == 0 ? 6 : jSONObject.optInt(CLConstants.FIELD_DLENGTH);
            this.D = getString(R.string.card_info, this.M.r(), this.M.q());
        } catch (Exception e2) {
            e = e2;
        }
        try {
            FormItemView formItemViewA = a(getString(R.string.card_number_title), 0, iOptInt, this.D, this.E, string);
            FormItemView formItemViewA2 = a(getString(R.string.card_expiry_title), 0, 4, this.D, this.E, string);
            ArrayList<FormItemView> arrayList = new ArrayList<>();
            arrayList.add(formItemViewA);
            arrayList.add(formItemViewA2);
            FormItemPager formItemPager = new FormItemPager(getActivity());
            formItemPager.a(arrayList, this);
            formItemPager.setFormDataTag(jSONObject);
            this.f57570d.add(formItemPager);
            a(view, R.id.debitLayout, 0);
            ((LinearLayout) view.findViewById(R.id.debitLayout)).addView(formItemPager);
        } catch (Exception e3) {
            e = e3;
            q.a(v, e);
        }
    }

    private void a(View view, int i2, int i3) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout linearLayout = new LinearLayout(getActivity());
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setDividerDrawable(getResources().getDrawable(R.drawable.fragment_transparent_divider));
        linearLayout.setPadding(16, 0, 16, 0);
        linearLayout.setGravity(1);
        linearLayout.setOrientation(1);
        linearLayout.setId(i2);
        this.z.addView(linearLayout, i3);
    }

    @Override // org.npci.upi.security.pinactivitycomponent.widget.FormItemView.a
    public void b(View view, String str) {
        a(view, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x0207, code lost:
    
        r13 = r3.optString(org.npci.upi.security.pinactivitycomponent.CLConstants.FIELD_PAY_INFO_VALUE, "");
     */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x049a A[Catch: Exception -> 0x046d, TRY_LEAVE, TryCatch #1 {Exception -> 0x046d, blocks: (B:182:0x0482, B:184:0x049a, B:170:0x044f, B:172:0x045b, B:174:0x0467, B:177:0x0470), top: B:205:0x0482 }] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x04b1 A[Catch: Exception -> 0x04ae, TryCatch #0 {Exception -> 0x04ae, blocks: (B:186:0x049e, B:187:0x04a9, B:190:0x04b1, B:191:0x04c1, B:193:0x04cd, B:195:0x0529, B:194:0x04fd), top: B:203:0x049e }] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x057a  */
    /* JADX WARN: Removed duplicated region for block: B:233:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(android.view.View r23, java.lang.Integer r24) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 1448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.npci.upi.security.pinactivitycomponent.w.a(android.view.View, java.lang.Integer):void");
    }

    @Override // org.npci.upi.security.pinactivitycomponent.s
    public void b() {
        ArrayList<org.npci.upi.security.pinactivitycomponent.widget.a> arrayList;
        int iD;
        if (this.C.booleanValue()) {
            this.C = Boolean.FALSE;
            a(Boolean.TRUE);
            if (((FormItemView) this.f57570d.get(d())).isShown()) {
                arrayList = this.f57570d;
                iD = d();
            } else {
                arrayList = this.f57570d;
                iD = this.f57571e;
            }
            ((FormItemView) arrayList.get(iD)).a(getActivity().getDrawable(R.drawable.ic_tick_ok), false);
        }
    }

    public void a(String str) {
        FormItemView formItemView;
        String string;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("type") || !jSONObject.has("data") || jSONObject.getJSONObject("data").getInt(CLConstants.OTP_STATUS) != -1) {
                this.f57570d.get(this.w).a(getString(R.string.bank_error));
                return;
            }
            if (jSONObject.getString("type").equals(CLConstants.OTP_RESULT_TYPE_TRIGGERED)) {
                formItemView = (FormItemView) this.f57570d.get(this.w);
                string = getString(R.string.bank_error);
            } else {
                if (!jSONObject.getString("type").equals(CLConstants.OTP_RESULT_TYPE_TRIGGERED_AADHAAR)) {
                    return;
                }
                formItemView = (FormItemView) this.f57570d.get(this.w);
                string = getString(R.string.uidai_error);
            }
            a(formItemView, string);
        } catch (Exception e2) {
            q.a(v, e2);
        }
    }

    @Override // org.npci.upi.security.pinactivitycomponent.s
    public void a() throws JSONException {
        if (((GetCredential) this.f57578l).getCredBlockBuilder().a()) {
            if (this.f57570d.size() == 1) {
                if (this.f57570d.get(this.w).a()) {
                    try {
                        if (this.n < 0) {
                            org.npci.upi.security.pinactivitycomponent.widget.a aVar = this.f57570d.get(this.w);
                            aVar.a(getString(((FormItemView) aVar).getSubtype().equals(CLConstants.CREDTYPE_AADHAAR) ? R.string.aadhaar_otp_limit_info : R.string.bank_otp_limit_info));
                            return;
                        } else {
                            if (this.K.booleanValue()) {
                                return;
                            }
                            this.J = Boolean.TRUE;
                            a(this.A, (Integer) 1);
                            c(1);
                            return;
                        }
                    } catch (Exception e2) {
                        q.a(v, e2);
                        return;
                    }
                }
                final org.npci.upi.security.pinactivitycomponent.widget.a aVar2 = this.f57570d.get(this.w);
                Drawable drawable = getActivity().getDrawable(R.drawable.ic_edit_icon);
                final Drawable drawable2 = getActivity().getDrawable(R.drawable.btn_checkbox_off);
                final Drawable drawable3 = getActivity().getDrawable(R.drawable.btn_checkbox_on);
                FormItemView formItemView = new FormItemView(getActivity(), this.f57578l);
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: org.npci.upi.security.pinactivitycomponent.w.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        w wVar = w.this;
                        wVar.f57570d.get(wVar.w).b();
                        org.npci.upi.security.pinactivitycomponent.widget.a aVar3 = aVar2;
                        aVar3.a(CLConstants.DEBIT_CARD_TYPE, (aVar3.getTextEntered() ? !aVar2.getToggleCheckBox() : !aVar2.d()) ? drawable2 : drawable3, this, 0, true, true);
                        aVar2.setTextEntered(false);
                    }
                };
                String string = getString(R.string.edit_card_number);
                if (formItemView.getTextEntered()) {
                    drawable3 = drawable;
                } else if (!aVar2.getToggleCheckBox()) {
                    drawable3 = drawable2;
                }
                aVar2.a(string, drawable3, onClickListener, 0, true, true);
                return;
            }
            if (this.f57570d.size() == 4) {
                int i2 = this.w;
                if (i2 == 1) {
                    if (((FormItemView) this.f57570d.get(i2)).getInputLength() != this.f57570d.get(this.w).getInputValue().length()) {
                        a((View) this.f57570d.get(this.w), getString(R.string.error_message_bank_otp, Integer.valueOf(this.G)));
                        return;
                    } else {
                        this.z.setDisplayedChild(this.w + 1);
                        this.w++;
                        return;
                    }
                }
                if (i2 == 2 && this.x.booleanValue()) {
                    if (((FormItemView) this.f57570d.get(this.w)).getInputLength() != this.f57570d.get(this.w).getInputValue().length()) {
                        a((View) this.f57570d.get(this.w), getString(R.string.error_message_atm_pin, Integer.valueOf(this.H)));
                        return;
                    } else {
                        this.z.showNext();
                        this.w++;
                        return;
                    }
                }
                int i3 = this.w;
                if (i3 == 3 && this.f57570d.get(i3).a()) {
                    g();
                    return;
                }
                return;
            }
            if (this.f57570d.size() == 3) {
                int i4 = this.w;
                if (i4 == 0) {
                    if (((FormItemView) this.f57570d.get(i4)).getInputLength() != this.f57570d.get(this.w).getInputValue().length()) {
                        a((View) this.f57570d.get(this.w), ((FormItemView) this.f57570d.get(this.w)).getSubtype().equals(CLConstants.CREDTYPE_AADHAAR) ? getString(R.string.error_message_aadhaar_otp, Integer.valueOf(this.G)) : getString(R.string.error_message_bank_otp, Integer.valueOf(this.G)));
                        return;
                    }
                    this.z.setDisplayedChild(this.w + 1);
                    this.w++;
                    if (this.f57579m) {
                        e();
                        FormItemView formItemView2 = (FormItemView) this.f57570d.get(this.f57571e);
                        b(formItemView2);
                        formItemView2.setNonMaskedField();
                        return;
                    }
                    return;
                }
                if (i4 != 1) {
                    if (i4 == 2 && this.f57570d.get(i4).a()) {
                        g();
                        return;
                    }
                    return;
                }
                if (this.x.booleanValue()) {
                    if (((FormItemView) this.f57570d.get(this.w)).getInputLength() != this.f57570d.get(this.w).getInputValue().length()) {
                        a((View) this.f57570d.get(this.w), getString(R.string.error_message_atm_pin, Integer.valueOf(this.H)));
                        return;
                    } else {
                        this.z.showNext();
                        this.w++;
                        return;
                    }
                }
                if (this.f57579m) {
                    if (((FormItemView) this.f57570d.get(this.w)).getInputLength() != this.f57570d.get(this.w).getInputValue().length()) {
                        a((View) this.f57570d.get(this.w), ((FormItemView) this.f57570d.get(this.w)).getSubtype().equals(CLConstants.CREDTYPE_AADHAAR) ? getString(R.string.error_message_aadhaar_otp, Integer.valueOf(this.G)) : getString(R.string.error_message_bank_otp, Integer.valueOf(this.G)));
                        return;
                    }
                    this.z.showNext();
                    this.w++;
                    this.f57579m = false;
                    return;
                }
                if ((this.f57570d.get(this.w) instanceof FormItemView) && ((FormItemView) this.f57570d.get(this.w)).getInputLength() != this.f57570d.get(this.w).getInputValue().length()) {
                    a((View) this.f57570d.get(this.w), getString(R.string.error_message_bank_otp, Integer.valueOf(this.G)));
                    return;
                } else {
                    this.z.showNext();
                    this.w++;
                    return;
                }
            }
            if (this.f57570d.size() == 2) {
                int i5 = this.w;
                if (i5 != 0) {
                    if (i5 == 1 && this.f57570d.get(i5).a()) {
                        g();
                        return;
                    }
                    return;
                }
                if (((FormItemView) this.f57570d.get(i5)).getInputLength() != this.f57570d.get(this.w).getInputValue().length()) {
                    a((View) this.f57570d.get(this.w), getString(R.string.error_message_bank_otp, Integer.valueOf(this.G)));
                    return;
                } else {
                    this.z.setDisplayedChild(this.w + 1);
                    this.w++;
                    return;
                }
            }
        }
        if (this.M.p().toString().contains(CLConstants.CREDTYPE_SIGNATURE)) {
            if (((FormItemView) this.f57570d.get(this.w)).getInputLength() != this.f57570d.get(this.w).getInputValue().length()) {
                a((View) this.f57570d.get(this.w), getString(R.string.error_message_mpin, Integer.valueOf(this.F)));
                return;
            } else {
                if (this.f57570d.get(this.w).a()) {
                    ((GetCredential) this.f57578l).getLiteInstace().a(this.f57570d.get(0).getInputValue());
                    return;
                }
                return;
            }
        }
        if (this.f57570d.size() == 1) {
            if (((FormItemView) this.f57570d.get(this.w)).getInputLength() != this.f57570d.get(this.w).getInputValue().length()) {
                a((View) this.f57570d.get(this.w), getString(R.string.error_message_mpin, Integer.valueOf(this.F)));
                return;
            } else {
                if (this.f57570d.get(this.w).a()) {
                    g();
                    return;
                }
                return;
            }
        }
        int i6 = this.w;
        if (i6 != 0) {
            if (i6 == 1 && this.f57570d.get(i6).a()) {
                g();
                return;
            }
            return;
        }
        if (((FormItemView) this.f57570d.get(i6)).getInputLength() != this.f57570d.get(this.w).getInputValue().length()) {
            a((View) this.f57570d.get(this.w), getString(R.string.error_message_mpin, Integer.valueOf(this.F)));
        } else {
            this.z.showNext();
            this.w++;
        }
    }

    @Override // org.npci.upi.security.pinactivitycomponent.widget.FormItemView.a
    public void a(int i2, String str) {
        ArrayList<org.npci.upi.security.pinactivitycomponent.widget.a> arrayList;
        int iD;
        int i3 = this.f57571e;
        if ((i3 == -1 || i3 != i2) && !this.f57579m) {
            return;
        }
        if (((FormItemView) this.f57570d.get(d())).isShown()) {
            arrayList = this.f57570d;
            iD = d();
        } else {
            arrayList = this.f57570d;
            iD = this.f57571e;
        }
        FormItemView formItemView = (FormItemView) arrayList.get(iD);
        a(this.y);
        a(this.f57568b);
        formItemView.a(false);
        formItemView.a("", null, false, false);
        formItemView.a(getActivity().getDrawable(R.drawable.ic_tick_ok), true);
        this.C = Boolean.TRUE;
    }
}
