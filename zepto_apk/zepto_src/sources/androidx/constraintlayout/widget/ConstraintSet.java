package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.media.b;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes3.dex */
public class ConstraintSet {

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f2449h = {0, 4, 8};

    /* renamed from: i, reason: collision with root package name */
    public static final SparseIntArray f2450i;

    /* renamed from: j, reason: collision with root package name */
    public static final SparseIntArray f2451j;

    /* renamed from: a, reason: collision with root package name */
    public String f2452a;

    /* renamed from: b, reason: collision with root package name */
    public String f2453b = "";

    /* renamed from: c, reason: collision with root package name */
    public String[] f2454c = new String[0];

    /* renamed from: d, reason: collision with root package name */
    public int f2455d = 0;

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f2456e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public boolean f2457f = true;

    /* renamed from: g, reason: collision with root package name */
    public final HashMap f2458g = new HashMap();

    public static class Constraint {

        /* renamed from: a, reason: collision with root package name */
        public int f2459a;

        /* renamed from: b, reason: collision with root package name */
        public String f2460b;

        /* renamed from: c, reason: collision with root package name */
        public final PropertySet f2461c = new PropertySet();

        /* renamed from: d, reason: collision with root package name */
        public final Motion f2462d = new Motion();

        /* renamed from: e, reason: collision with root package name */
        public final Layout f2463e = new Layout();

        /* renamed from: f, reason: collision with root package name */
        public final Transform f2464f = new Transform();

        /* renamed from: g, reason: collision with root package name */
        public HashMap f2465g = new HashMap();

        /* renamed from: h, reason: collision with root package name */
        public Delta f2466h;

        public static class Delta {

            /* renamed from: a, reason: collision with root package name */
            public int[] f2467a;

            /* renamed from: b, reason: collision with root package name */
            public int[] f2468b;

            /* renamed from: c, reason: collision with root package name */
            public int f2469c;

            /* renamed from: d, reason: collision with root package name */
            public int[] f2470d;

            /* renamed from: e, reason: collision with root package name */
            public float[] f2471e;

            /* renamed from: f, reason: collision with root package name */
            public int f2472f;

            /* renamed from: g, reason: collision with root package name */
            public int[] f2473g;

            /* renamed from: h, reason: collision with root package name */
            public String[] f2474h;

            /* renamed from: i, reason: collision with root package name */
            public int f2475i;

            /* renamed from: j, reason: collision with root package name */
            public int[] f2476j;

            /* renamed from: k, reason: collision with root package name */
            public boolean[] f2477k;

            /* renamed from: l, reason: collision with root package name */
            public int f2478l;

            public final void a(float f2, int i2) {
                int i3 = this.f2472f;
                int[] iArr = this.f2470d;
                if (i3 >= iArr.length) {
                    this.f2470d = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.f2471e;
                    this.f2471e = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.f2470d;
                int i4 = this.f2472f;
                iArr2[i4] = i2;
                float[] fArr2 = this.f2471e;
                this.f2472f = i4 + 1;
                fArr2[i4] = f2;
            }

            public final void b(int i2, int i3) {
                int i4 = this.f2469c;
                int[] iArr = this.f2467a;
                if (i4 >= iArr.length) {
                    this.f2467a = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.f2468b;
                    this.f2468b = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.f2467a;
                int i5 = this.f2469c;
                iArr3[i5] = i2;
                int[] iArr4 = this.f2468b;
                this.f2469c = i5 + 1;
                iArr4[i5] = i3;
            }

            public final void c(int i2, String str) {
                int i3 = this.f2475i;
                int[] iArr = this.f2473g;
                if (i3 >= iArr.length) {
                    this.f2473g = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.f2474h;
                    this.f2474h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.f2473g;
                int i4 = this.f2475i;
                iArr2[i4] = i2;
                String[] strArr2 = this.f2474h;
                this.f2475i = i4 + 1;
                strArr2[i4] = str;
            }

            public final void d(int i2, boolean z) {
                int i3 = this.f2478l;
                int[] iArr = this.f2476j;
                if (i3 >= iArr.length) {
                    this.f2476j = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.f2477k;
                    this.f2477k = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.f2476j;
                int i4 = this.f2478l;
                iArr2[i4] = i2;
                boolean[] zArr2 = this.f2477k;
                this.f2478l = i4 + 1;
                zArr2[i4] = z;
            }

            public final void e(Constraint constraint) {
                for (int i2 = 0; i2 < this.f2469c; i2++) {
                    int i3 = this.f2467a[i2];
                    int i4 = this.f2468b[i2];
                    int[] iArr = ConstraintSet.f2449h;
                    if (i3 == 6) {
                        constraint.f2463e.D = i4;
                    } else if (i3 == 7) {
                        constraint.f2463e.E = i4;
                    } else if (i3 == 8) {
                        constraint.f2463e.K = i4;
                    } else if (i3 == 27) {
                        constraint.f2463e.F = i4;
                    } else if (i3 == 28) {
                        constraint.f2463e.H = i4;
                    } else if (i3 == 41) {
                        constraint.f2463e.W = i4;
                    } else if (i3 == 42) {
                        constraint.f2463e.X = i4;
                    } else if (i3 == 61) {
                        constraint.f2463e.A = i4;
                    } else if (i3 == 62) {
                        constraint.f2463e.B = i4;
                    } else if (i3 == 72) {
                        constraint.f2463e.g0 = i4;
                    } else if (i3 == 73) {
                        constraint.f2463e.h0 = i4;
                    } else if (i3 == 2) {
                        constraint.f2463e.J = i4;
                    } else if (i3 == 31) {
                        constraint.f2463e.L = i4;
                    } else if (i3 == 34) {
                        constraint.f2463e.I = i4;
                    } else if (i3 == 38) {
                        constraint.f2459a = i4;
                    } else if (i3 == 64) {
                        constraint.f2462d.f2493b = i4;
                    } else if (i3 == 66) {
                        constraint.f2462d.f2497f = i4;
                    } else if (i3 == 76) {
                        constraint.f2462d.f2496e = i4;
                    } else if (i3 == 78) {
                        constraint.f2461c.f2507c = i4;
                    } else if (i3 == 97) {
                        constraint.f2463e.p0 = i4;
                    } else if (i3 == 93) {
                        constraint.f2463e.M = i4;
                    } else if (i3 != 94) {
                        switch (i3) {
                            case 11:
                                constraint.f2463e.Q = i4;
                                break;
                            case 12:
                                constraint.f2463e.R = i4;
                                break;
                            case 13:
                                constraint.f2463e.N = i4;
                                break;
                            case 14:
                                constraint.f2463e.P = i4;
                                break;
                            case 15:
                                constraint.f2463e.S = i4;
                                break;
                            case 16:
                                constraint.f2463e.O = i4;
                                break;
                            case 17:
                                constraint.f2463e.f2483e = i4;
                                break;
                            case 18:
                                constraint.f2463e.f2484f = i4;
                                break;
                            default:
                                switch (i3) {
                                    case 21:
                                        constraint.f2463e.f2482d = i4;
                                        break;
                                    case 22:
                                        constraint.f2461c.f2506b = i4;
                                        break;
                                    case 23:
                                        constraint.f2463e.f2481c = i4;
                                        break;
                                    case 24:
                                        constraint.f2463e.G = i4;
                                        break;
                                    default:
                                        switch (i3) {
                                            case 54:
                                                constraint.f2463e.Y = i4;
                                                break;
                                            case 55:
                                                constraint.f2463e.Z = i4;
                                                break;
                                            case Type.NINFO /* 56 */:
                                                constraint.f2463e.a0 = i4;
                                                break;
                                            case Type.RKEY /* 57 */:
                                                constraint.f2463e.b0 = i4;
                                                break;
                                            case Type.TALINK /* 58 */:
                                                constraint.f2463e.c0 = i4;
                                                break;
                                            case Type.CDS /* 59 */:
                                                constraint.f2463e.d0 = i4;
                                                break;
                                            default:
                                                switch (i3) {
                                                    case 82:
                                                        constraint.f2462d.f2494c = i4;
                                                        break;
                                                    case 83:
                                                        constraint.f2464f.f2518i = i4;
                                                        break;
                                                    case 84:
                                                        constraint.f2462d.f2501j = i4;
                                                        break;
                                                    default:
                                                        switch (i3) {
                                                            case 87:
                                                                break;
                                                            case 88:
                                                                constraint.f2462d.f2503l = i4;
                                                                break;
                                                            case WKSRecord.Service.SU_MIT_TG /* 89 */:
                                                                constraint.f2462d.f2504m = i4;
                                                                break;
                                                            default:
                                                                Log.w("ConstraintSet", "Unknown attribute 0x");
                                                                break;
                                                        }
                                                }
                                        }
                                }
                        }
                    } else {
                        constraint.f2463e.T = i4;
                    }
                }
                for (int i5 = 0; i5 < this.f2472f; i5++) {
                    int i6 = this.f2470d[i5];
                    float f2 = this.f2471e[i5];
                    int[] iArr2 = ConstraintSet.f2449h;
                    if (i6 == 19) {
                        constraint.f2463e.f2485g = f2;
                    } else if (i6 == 20) {
                        constraint.f2463e.x = f2;
                    } else if (i6 == 37) {
                        constraint.f2463e.y = f2;
                    } else if (i6 == 60) {
                        constraint.f2464f.f2511b = f2;
                    } else if (i6 == 63) {
                        constraint.f2463e.C = f2;
                    } else if (i6 == 79) {
                        constraint.f2462d.f2498g = f2;
                    } else if (i6 == 85) {
                        constraint.f2462d.f2500i = f2;
                    } else if (i6 != 87) {
                        if (i6 == 39) {
                            constraint.f2463e.V = f2;
                        } else if (i6 != 40) {
                            switch (i6) {
                                case 43:
                                    constraint.f2461c.f2508d = f2;
                                    break;
                                case 44:
                                    Transform transform = constraint.f2464f;
                                    transform.n = f2;
                                    transform.f2522m = true;
                                    break;
                                case 45:
                                    constraint.f2464f.f2512c = f2;
                                    break;
                                case 46:
                                    constraint.f2464f.f2513d = f2;
                                    break;
                                case 47:
                                    constraint.f2464f.f2514e = f2;
                                    break;
                                case Type.DNSKEY /* 48 */:
                                    constraint.f2464f.f2515f = f2;
                                    break;
                                case 49:
                                    constraint.f2464f.f2516g = f2;
                                    break;
                                case 50:
                                    constraint.f2464f.f2517h = f2;
                                    break;
                                case 51:
                                    constraint.f2464f.f2519j = f2;
                                    break;
                                case Type.TLSA /* 52 */:
                                    constraint.f2464f.f2520k = f2;
                                    break;
                                case 53:
                                    constraint.f2464f.f2521l = f2;
                                    break;
                                default:
                                    switch (i6) {
                                        case 67:
                                            constraint.f2462d.f2499h = f2;
                                            break;
                                        case WKSRecord.Service.BOOTPC /* 68 */:
                                            constraint.f2461c.f2509e = f2;
                                            break;
                                        case 69:
                                            constraint.f2463e.e0 = f2;
                                            break;
                                        case 70:
                                            constraint.f2463e.f0 = f2;
                                            break;
                                        default:
                                            Log.w("ConstraintSet", "Unknown attribute 0x");
                                            break;
                                    }
                            }
                        } else {
                            constraint.f2463e.U = f2;
                        }
                    }
                }
                for (int i7 = 0; i7 < this.f2475i; i7++) {
                    int i8 = this.f2473g[i7];
                    String str = this.f2474h[i7];
                    int[] iArr3 = ConstraintSet.f2449h;
                    if (i8 == 5) {
                        constraint.f2463e.z = str;
                    } else if (i8 == 65) {
                        constraint.f2462d.f2495d = str;
                    } else if (i8 == 74) {
                        Layout layout = constraint.f2463e;
                        layout.k0 = str;
                        layout.j0 = null;
                    } else if (i8 == 77) {
                        constraint.f2463e.l0 = str;
                    } else if (i8 != 87) {
                        if (i8 != 90) {
                            Log.w("ConstraintSet", "Unknown attribute 0x");
                        } else {
                            constraint.f2462d.f2502k = str;
                        }
                    }
                }
                for (int i9 = 0; i9 < this.f2478l; i9++) {
                    int i10 = this.f2476j[i9];
                    boolean z = this.f2477k[i9];
                    int[] iArr4 = ConstraintSet.f2449h;
                    if (i10 == 44) {
                        constraint.f2464f.f2522m = z;
                    } else if (i10 == 75) {
                        constraint.f2463e.o0 = z;
                    } else if (i10 != 87) {
                        if (i10 == 80) {
                            constraint.f2463e.m0 = z;
                        } else if (i10 != 81) {
                            Log.w("ConstraintSet", "Unknown attribute 0x");
                        } else {
                            constraint.f2463e.n0 = z;
                        }
                    }
                }
            }
        }

        public final void a(Constraint constraint) {
            Delta delta = this.f2466h;
            if (delta != null) {
                delta.e(constraint);
            }
        }

        public final void b(ConstraintLayout.LayoutParams layoutParams) {
            Layout layout = this.f2463e;
            layoutParams.f2415e = layout.f2487i;
            layoutParams.f2416f = layout.f2488j;
            layoutParams.f2417g = layout.f2489k;
            layoutParams.f2418h = layout.f2490l;
            layoutParams.f2419i = layout.f2491m;
            layoutParams.f2420j = layout.n;
            layoutParams.f2421k = layout.o;
            layoutParams.f2422l = layout.p;
            layoutParams.f2423m = layout.q;
            layoutParams.n = layout.r;
            layoutParams.o = layout.s;
            layoutParams.s = layout.t;
            layoutParams.t = layout.u;
            layoutParams.u = layout.v;
            layoutParams.v = layout.w;
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = layout.G;
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = layout.H;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = layout.I;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = layout.J;
            layoutParams.A = layout.S;
            layoutParams.B = layout.R;
            layoutParams.x = layout.O;
            layoutParams.z = layout.Q;
            layoutParams.E = layout.x;
            layoutParams.F = layout.y;
            layoutParams.p = layout.A;
            layoutParams.q = layout.B;
            layoutParams.r = layout.C;
            layoutParams.G = layout.z;
            layoutParams.T = layout.D;
            layoutParams.U = layout.E;
            layoutParams.I = layout.U;
            layoutParams.H = layout.V;
            layoutParams.K = layout.X;
            layoutParams.J = layout.W;
            layoutParams.W = layout.m0;
            layoutParams.X = layout.n0;
            layoutParams.L = layout.Y;
            layoutParams.M = layout.Z;
            layoutParams.P = layout.a0;
            layoutParams.Q = layout.b0;
            layoutParams.N = layout.c0;
            layoutParams.O = layout.d0;
            layoutParams.R = layout.e0;
            layoutParams.S = layout.f0;
            layoutParams.V = layout.F;
            layoutParams.f2413c = layout.f2485g;
            layoutParams.f2411a = layout.f2483e;
            layoutParams.f2412b = layout.f2484f;
            ((ViewGroup.MarginLayoutParams) layoutParams).width = layout.f2481c;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = layout.f2482d;
            String str = layout.l0;
            if (str != null) {
                layoutParams.Y = str;
            }
            layoutParams.Z = layout.p0;
            layoutParams.setMarginStart(layout.L);
            layoutParams.setMarginEnd(layout.K);
            layoutParams.a();
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Constraint clone() {
            Constraint constraint = new Constraint();
            constraint.f2463e.a(this.f2463e);
            constraint.f2462d.a(this.f2462d);
            PropertySet propertySet = constraint.f2461c;
            propertySet.getClass();
            PropertySet propertySet2 = this.f2461c;
            propertySet.f2505a = propertySet2.f2505a;
            propertySet.f2506b = propertySet2.f2506b;
            propertySet.f2508d = propertySet2.f2508d;
            propertySet.f2509e = propertySet2.f2509e;
            propertySet.f2507c = propertySet2.f2507c;
            constraint.f2464f.a(this.f2464f);
            constraint.f2459a = this.f2459a;
            constraint.f2466h = this.f2466h;
            return constraint;
        }

        public final void d(int i2, ConstraintLayout.LayoutParams layoutParams) {
            this.f2459a = i2;
            int i3 = layoutParams.f2415e;
            Layout layout = this.f2463e;
            layout.f2487i = i3;
            layout.f2488j = layoutParams.f2416f;
            layout.f2489k = layoutParams.f2417g;
            layout.f2490l = layoutParams.f2418h;
            layout.f2491m = layoutParams.f2419i;
            layout.n = layoutParams.f2420j;
            layout.o = layoutParams.f2421k;
            layout.p = layoutParams.f2422l;
            layout.q = layoutParams.f2423m;
            layout.r = layoutParams.n;
            layout.s = layoutParams.o;
            layout.t = layoutParams.s;
            layout.u = layoutParams.t;
            layout.v = layoutParams.u;
            layout.w = layoutParams.v;
            layout.x = layoutParams.E;
            layout.y = layoutParams.F;
            layout.z = layoutParams.G;
            layout.A = layoutParams.p;
            layout.B = layoutParams.q;
            layout.C = layoutParams.r;
            layout.D = layoutParams.T;
            layout.E = layoutParams.U;
            layout.F = layoutParams.V;
            layout.f2485g = layoutParams.f2413c;
            layout.f2483e = layoutParams.f2411a;
            layout.f2484f = layoutParams.f2412b;
            layout.f2481c = ((ViewGroup.MarginLayoutParams) layoutParams).width;
            layout.f2482d = ((ViewGroup.MarginLayoutParams) layoutParams).height;
            layout.G = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            layout.H = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            layout.I = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            layout.J = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            layout.M = layoutParams.D;
            layout.U = layoutParams.I;
            layout.V = layoutParams.H;
            layout.X = layoutParams.K;
            layout.W = layoutParams.J;
            layout.m0 = layoutParams.W;
            layout.n0 = layoutParams.X;
            layout.Y = layoutParams.L;
            layout.Z = layoutParams.M;
            layout.a0 = layoutParams.P;
            layout.b0 = layoutParams.Q;
            layout.c0 = layoutParams.N;
            layout.d0 = layoutParams.O;
            layout.e0 = layoutParams.R;
            layout.f0 = layoutParams.S;
            layout.l0 = layoutParams.Y;
            layout.O = layoutParams.x;
            layout.Q = layoutParams.z;
            layout.N = layoutParams.w;
            layout.P = layoutParams.y;
            layout.S = layoutParams.A;
            layout.R = layoutParams.B;
            layout.T = layoutParams.C;
            layout.p0 = layoutParams.Z;
            layout.K = layoutParams.getMarginEnd();
            layout.L = layoutParams.getMarginStart();
        }

        public final void e(int i2, Constraints.LayoutParams layoutParams) {
            d(i2, layoutParams);
            this.f2461c.f2508d = layoutParams.r0;
            float f2 = layoutParams.u0;
            Transform transform = this.f2464f;
            transform.f2511b = f2;
            transform.f2512c = layoutParams.v0;
            transform.f2513d = layoutParams.w0;
            transform.f2514e = layoutParams.x0;
            transform.f2515f = layoutParams.y0;
            transform.f2516g = layoutParams.z0;
            transform.f2517h = layoutParams.A0;
            transform.f2519j = layoutParams.B0;
            transform.f2520k = layoutParams.C0;
            transform.f2521l = layoutParams.D0;
            transform.n = layoutParams.t0;
            transform.f2522m = layoutParams.s0;
        }
    }

    public static class Layout {
        public static final SparseIntArray q0;

        /* renamed from: c, reason: collision with root package name */
        public int f2481c;

        /* renamed from: d, reason: collision with root package name */
        public int f2482d;
        public int[] j0;
        public String k0;
        public String l0;

        /* renamed from: a, reason: collision with root package name */
        public boolean f2479a = false;

        /* renamed from: b, reason: collision with root package name */
        public boolean f2480b = false;

        /* renamed from: e, reason: collision with root package name */
        public int f2483e = -1;

        /* renamed from: f, reason: collision with root package name */
        public int f2484f = -1;

        /* renamed from: g, reason: collision with root package name */
        public float f2485g = -1.0f;

        /* renamed from: h, reason: collision with root package name */
        public boolean f2486h = true;

        /* renamed from: i, reason: collision with root package name */
        public int f2487i = -1;

        /* renamed from: j, reason: collision with root package name */
        public int f2488j = -1;

        /* renamed from: k, reason: collision with root package name */
        public int f2489k = -1;

        /* renamed from: l, reason: collision with root package name */
        public int f2490l = -1;

        /* renamed from: m, reason: collision with root package name */
        public int f2491m = -1;
        public int n = -1;
        public int o = -1;
        public int p = -1;
        public int q = -1;
        public int r = -1;
        public int s = -1;
        public int t = -1;
        public int u = -1;
        public int v = -1;
        public int w = -1;
        public float x = 0.5f;
        public float y = 0.5f;
        public String z = null;
        public int A = -1;
        public int B = 0;
        public float C = 0.0f;
        public int D = -1;
        public int E = -1;
        public int F = -1;
        public int G = 0;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = 0;
        public int N = Integer.MIN_VALUE;
        public int O = Integer.MIN_VALUE;
        public int P = Integer.MIN_VALUE;
        public int Q = Integer.MIN_VALUE;
        public int R = Integer.MIN_VALUE;
        public int S = Integer.MIN_VALUE;
        public int T = Integer.MIN_VALUE;
        public float U = -1.0f;
        public float V = -1.0f;
        public int W = 0;
        public int X = 0;
        public int Y = 0;
        public int Z = 0;
        public int a0 = 0;
        public int b0 = 0;
        public int c0 = 0;
        public int d0 = 0;
        public float e0 = 1.0f;
        public float f0 = 1.0f;
        public int g0 = -1;
        public int h0 = 0;
        public int i0 = -1;
        public boolean m0 = false;
        public boolean n0 = false;
        public boolean o0 = true;
        public int p0 = 0;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            q0 = sparseIntArray;
            sparseIntArray.append(R.styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            sparseIntArray.append(R.styleable.Layout_layout_constraintLeft_toRightOf, 25);
            sparseIntArray.append(R.styleable.Layout_layout_constraintRight_toLeftOf, 28);
            sparseIntArray.append(R.styleable.Layout_layout_constraintRight_toRightOf, 29);
            sparseIntArray.append(R.styleable.Layout_layout_constraintTop_toTopOf, 35);
            sparseIntArray.append(R.styleable.Layout_layout_constraintTop_toBottomOf, 34);
            sparseIntArray.append(R.styleable.Layout_layout_constraintBottom_toTopOf, 4);
            sparseIntArray.append(R.styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            sparseIntArray.append(R.styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            sparseIntArray.append(R.styleable.Layout_layout_editor_absoluteX, 6);
            sparseIntArray.append(R.styleable.Layout_layout_editor_absoluteY, 7);
            sparseIntArray.append(R.styleable.Layout_layout_constraintGuide_begin, 17);
            sparseIntArray.append(R.styleable.Layout_layout_constraintGuide_end, 18);
            sparseIntArray.append(R.styleable.Layout_layout_constraintGuide_percent, 19);
            sparseIntArray.append(R.styleable.Layout_guidelineUseRtl, 90);
            sparseIntArray.append(R.styleable.Layout_android_orientation, 26);
            sparseIntArray.append(R.styleable.Layout_layout_constraintStart_toEndOf, 31);
            sparseIntArray.append(R.styleable.Layout_layout_constraintStart_toStartOf, 32);
            sparseIntArray.append(R.styleable.Layout_layout_constraintEnd_toStartOf, 10);
            sparseIntArray.append(R.styleable.Layout_layout_constraintEnd_toEndOf, 9);
            sparseIntArray.append(R.styleable.Layout_layout_goneMarginLeft, 13);
            sparseIntArray.append(R.styleable.Layout_layout_goneMarginTop, 16);
            sparseIntArray.append(R.styleable.Layout_layout_goneMarginRight, 14);
            sparseIntArray.append(R.styleable.Layout_layout_goneMarginBottom, 11);
            sparseIntArray.append(R.styleable.Layout_layout_goneMarginStart, 15);
            sparseIntArray.append(R.styleable.Layout_layout_goneMarginEnd, 12);
            sparseIntArray.append(R.styleable.Layout_layout_constraintVertical_weight, 38);
            sparseIntArray.append(R.styleable.Layout_layout_constraintHorizontal_weight, 37);
            sparseIntArray.append(R.styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            sparseIntArray.append(R.styleable.Layout_layout_constraintVertical_chainStyle, 40);
            sparseIntArray.append(R.styleable.Layout_layout_constraintHorizontal_bias, 20);
            sparseIntArray.append(R.styleable.Layout_layout_constraintVertical_bias, 36);
            sparseIntArray.append(R.styleable.Layout_layout_constraintDimensionRatio, 5);
            sparseIntArray.append(R.styleable.Layout_layout_constraintLeft_creator, 91);
            sparseIntArray.append(R.styleable.Layout_layout_constraintTop_creator, 91);
            sparseIntArray.append(R.styleable.Layout_layout_constraintRight_creator, 91);
            sparseIntArray.append(R.styleable.Layout_layout_constraintBottom_creator, 91);
            sparseIntArray.append(R.styleable.Layout_layout_constraintBaseline_creator, 91);
            sparseIntArray.append(R.styleable.Layout_android_layout_marginLeft, 23);
            sparseIntArray.append(R.styleable.Layout_android_layout_marginRight, 27);
            sparseIntArray.append(R.styleable.Layout_android_layout_marginStart, 30);
            sparseIntArray.append(R.styleable.Layout_android_layout_marginEnd, 8);
            sparseIntArray.append(R.styleable.Layout_android_layout_marginTop, 33);
            sparseIntArray.append(R.styleable.Layout_android_layout_marginBottom, 2);
            sparseIntArray.append(R.styleable.Layout_android_layout_width, 22);
            sparseIntArray.append(R.styleable.Layout_android_layout_height, 21);
            sparseIntArray.append(R.styleable.Layout_layout_constraintWidth, 41);
            sparseIntArray.append(R.styleable.Layout_layout_constraintHeight, 42);
            sparseIntArray.append(R.styleable.Layout_layout_constrainedWidth, 87);
            sparseIntArray.append(R.styleable.Layout_layout_constrainedHeight, 88);
            sparseIntArray.append(R.styleable.Layout_layout_wrapBehaviorInParent, 76);
            sparseIntArray.append(R.styleable.Layout_layout_constraintCircle, 61);
            sparseIntArray.append(R.styleable.Layout_layout_constraintCircleRadius, 62);
            sparseIntArray.append(R.styleable.Layout_layout_constraintCircleAngle, 63);
            sparseIntArray.append(R.styleable.Layout_layout_constraintWidth_percent, 69);
            sparseIntArray.append(R.styleable.Layout_layout_constraintHeight_percent, 70);
            sparseIntArray.append(R.styleable.Layout_chainUseRtl, 71);
            sparseIntArray.append(R.styleable.Layout_barrierDirection, 72);
            sparseIntArray.append(R.styleable.Layout_barrierMargin, 73);
            sparseIntArray.append(R.styleable.Layout_constraint_referenced_ids, 74);
            sparseIntArray.append(R.styleable.Layout_barrierAllowsGoneWidgets, 75);
            sparseIntArray.append(R.styleable.Layout_layout_constraintWidth_max, 84);
            sparseIntArray.append(R.styleable.Layout_layout_constraintWidth_min, 86);
            sparseIntArray.append(R.styleable.Layout_layout_constraintWidth_max, 83);
            sparseIntArray.append(R.styleable.Layout_layout_constraintHeight_min, 85);
            sparseIntArray.append(R.styleable.Layout_layout_constraintWidth, 87);
            sparseIntArray.append(R.styleable.Layout_layout_constraintHeight, 88);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTag, 89);
            sparseIntArray.append(R.styleable.Layout_guidelineUseRtl, 90);
        }

        public final void a(Layout layout) {
            this.f2479a = layout.f2479a;
            this.f2481c = layout.f2481c;
            this.f2480b = layout.f2480b;
            this.f2482d = layout.f2482d;
            this.f2483e = layout.f2483e;
            this.f2484f = layout.f2484f;
            this.f2485g = layout.f2485g;
            this.f2486h = layout.f2486h;
            this.f2487i = layout.f2487i;
            this.f2488j = layout.f2488j;
            this.f2489k = layout.f2489k;
            this.f2490l = layout.f2490l;
            this.f2491m = layout.f2491m;
            this.n = layout.n;
            this.o = layout.o;
            this.p = layout.p;
            this.q = layout.q;
            this.r = layout.r;
            this.s = layout.s;
            this.t = layout.t;
            this.u = layout.u;
            this.v = layout.v;
            this.w = layout.w;
            this.x = layout.x;
            this.y = layout.y;
            this.z = layout.z;
            this.A = layout.A;
            this.B = layout.B;
            this.C = layout.C;
            this.D = layout.D;
            this.E = layout.E;
            this.F = layout.F;
            this.G = layout.G;
            this.H = layout.H;
            this.I = layout.I;
            this.J = layout.J;
            this.K = layout.K;
            this.L = layout.L;
            this.M = layout.M;
            this.N = layout.N;
            this.O = layout.O;
            this.P = layout.P;
            this.Q = layout.Q;
            this.R = layout.R;
            this.S = layout.S;
            this.T = layout.T;
            this.U = layout.U;
            this.V = layout.V;
            this.W = layout.W;
            this.X = layout.X;
            this.Y = layout.Y;
            this.Z = layout.Z;
            this.a0 = layout.a0;
            this.b0 = layout.b0;
            this.c0 = layout.c0;
            this.d0 = layout.d0;
            this.e0 = layout.e0;
            this.f0 = layout.f0;
            this.g0 = layout.g0;
            this.h0 = layout.h0;
            this.i0 = layout.i0;
            this.l0 = layout.l0;
            int[] iArr = layout.j0;
            if (iArr == null || layout.k0 != null) {
                this.j0 = null;
            } else {
                this.j0 = Arrays.copyOf(iArr, iArr.length);
            }
            this.k0 = layout.k0;
            this.m0 = layout.m0;
            this.n0 = layout.n0;
            this.o0 = layout.o0;
            this.p0 = layout.p0;
        }

        public final void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Layout);
            this.f2480b = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                SparseIntArray sparseIntArray = q0;
                int i3 = sparseIntArray.get(index);
                switch (i3) {
                    case 1:
                        this.q = ConstraintSet.m(typedArrayObtainStyledAttributes, index, this.q);
                        break;
                    case 2:
                        this.J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.J);
                        break;
                    case 3:
                        this.p = ConstraintSet.m(typedArrayObtainStyledAttributes, index, this.p);
                        break;
                    case 4:
                        this.o = ConstraintSet.m(typedArrayObtainStyledAttributes, index, this.o);
                        break;
                    case 5:
                        this.z = typedArrayObtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.D = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.D);
                        break;
                    case 7:
                        this.E = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.E);
                        break;
                    case 8:
                        this.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.K);
                        break;
                    case 9:
                        this.w = ConstraintSet.m(typedArrayObtainStyledAttributes, index, this.w);
                        break;
                    case 10:
                        this.v = ConstraintSet.m(typedArrayObtainStyledAttributes, index, this.v);
                        break;
                    case 11:
                        this.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                        break;
                    case 12:
                        this.R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.R);
                        break;
                    case 13:
                        this.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.N);
                        break;
                    case 14:
                        this.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.P);
                        break;
                    case 15:
                        this.S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.S);
                        break;
                    case 16:
                        this.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.O);
                        break;
                    case 17:
                        this.f2483e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2483e);
                        break;
                    case 18:
                        this.f2484f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2484f);
                        break;
                    case 19:
                        this.f2485g = typedArrayObtainStyledAttributes.getFloat(index, this.f2485g);
                        break;
                    case 20:
                        this.x = typedArrayObtainStyledAttributes.getFloat(index, this.x);
                        break;
                    case 21:
                        this.f2482d = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f2482d);
                        break;
                    case 22:
                        this.f2481c = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f2481c);
                        break;
                    case 23:
                        this.G = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.G);
                        break;
                    case 24:
                        this.f2487i = ConstraintSet.m(typedArrayObtainStyledAttributes, index, this.f2487i);
                        break;
                    case 25:
                        this.f2488j = ConstraintSet.m(typedArrayObtainStyledAttributes, index, this.f2488j);
                        break;
                    case 26:
                        this.F = typedArrayObtainStyledAttributes.getInt(index, this.F);
                        break;
                    case 27:
                        this.H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.H);
                        break;
                    case 28:
                        this.f2489k = ConstraintSet.m(typedArrayObtainStyledAttributes, index, this.f2489k);
                        break;
                    case 29:
                        this.f2490l = ConstraintSet.m(typedArrayObtainStyledAttributes, index, this.f2490l);
                        break;
                    case 30:
                        this.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.L);
                        break;
                    case 31:
                        this.t = ConstraintSet.m(typedArrayObtainStyledAttributes, index, this.t);
                        break;
                    case 32:
                        this.u = ConstraintSet.m(typedArrayObtainStyledAttributes, index, this.u);
                        break;
                    case 33:
                        this.I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.I);
                        break;
                    case 34:
                        this.n = ConstraintSet.m(typedArrayObtainStyledAttributes, index, this.n);
                        break;
                    case 35:
                        this.f2491m = ConstraintSet.m(typedArrayObtainStyledAttributes, index, this.f2491m);
                        break;
                    case 36:
                        this.y = typedArrayObtainStyledAttributes.getFloat(index, this.y);
                        break;
                    case 37:
                        this.V = typedArrayObtainStyledAttributes.getFloat(index, this.V);
                        break;
                    case Type.A6 /* 38 */:
                        this.U = typedArrayObtainStyledAttributes.getFloat(index, this.U);
                        break;
                    case 39:
                        this.W = typedArrayObtainStyledAttributes.getInt(index, this.W);
                        break;
                    case 40:
                        this.X = typedArrayObtainStyledAttributes.getInt(index, this.X);
                        break;
                    case 41:
                        ConstraintSet.n(this, typedArrayObtainStyledAttributes, index, 0);
                        break;
                    case 42:
                        ConstraintSet.n(this, typedArrayObtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i3) {
                            case 61:
                                this.A = ConstraintSet.m(typedArrayObtainStyledAttributes, index, this.A);
                                break;
                            case 62:
                                this.B = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.B);
                                break;
                            case 63:
                                this.C = typedArrayObtainStyledAttributes.getFloat(index, this.C);
                                break;
                            default:
                                switch (i3) {
                                    case 69:
                                        this.e0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 70:
                                        this.f0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 71:
                                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                        break;
                                    case WKSRecord.Service.NETRJS_2 /* 72 */:
                                        this.g0 = typedArrayObtainStyledAttributes.getInt(index, this.g0);
                                        break;
                                    case WKSRecord.Service.NETRJS_3 /* 73 */:
                                        this.h0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.h0);
                                        break;
                                    case WKSRecord.Service.NETRJS_4 /* 74 */:
                                        this.k0 = typedArrayObtainStyledAttributes.getString(index);
                                        break;
                                    case 75:
                                        this.o0 = typedArrayObtainStyledAttributes.getBoolean(index, this.o0);
                                        break;
                                    case 76:
                                        this.p0 = typedArrayObtainStyledAttributes.getInt(index, this.p0);
                                        break;
                                    case 77:
                                        this.r = ConstraintSet.m(typedArrayObtainStyledAttributes, index, this.r);
                                        break;
                                    case 78:
                                        this.s = ConstraintSet.m(typedArrayObtainStyledAttributes, index, this.s);
                                        break;
                                    case 79:
                                        this.T = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.T);
                                        break;
                                    case 80:
                                        this.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.M);
                                        break;
                                    case WKSRecord.Service.HOSTS2_NS /* 81 */:
                                        this.Y = typedArrayObtainStyledAttributes.getInt(index, this.Y);
                                        break;
                                    case 82:
                                        this.Z = typedArrayObtainStyledAttributes.getInt(index, this.Z);
                                        break;
                                    case 83:
                                        this.b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.b0);
                                        break;
                                    case 84:
                                        this.a0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.a0);
                                        break;
                                    case 85:
                                        this.d0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.d0);
                                        break;
                                    case 86:
                                        this.c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.c0);
                                        break;
                                    case 87:
                                        this.m0 = typedArrayObtainStyledAttributes.getBoolean(index, this.m0);
                                        break;
                                    case 88:
                                        this.n0 = typedArrayObtainStyledAttributes.getBoolean(index, this.n0);
                                        break;
                                    case WKSRecord.Service.SU_MIT_TG /* 89 */:
                                        this.l0 = typedArrayObtainStyledAttributes.getString(index);
                                        break;
                                    case 90:
                                        this.f2486h = typedArrayObtainStyledAttributes.getBoolean(index, this.f2486h);
                                        break;
                                    case WKSRecord.Service.MIT_DOV /* 91 */:
                                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                                        break;
                                    default:
                                        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                                        break;
                                }
                        }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class Motion {
        public static final SparseIntArray n;

        /* renamed from: a, reason: collision with root package name */
        public boolean f2492a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f2493b = -1;

        /* renamed from: c, reason: collision with root package name */
        public int f2494c = 0;

        /* renamed from: d, reason: collision with root package name */
        public String f2495d = null;

        /* renamed from: e, reason: collision with root package name */
        public int f2496e = -1;

        /* renamed from: f, reason: collision with root package name */
        public int f2497f = 0;

        /* renamed from: g, reason: collision with root package name */
        public float f2498g = Float.NaN;

        /* renamed from: h, reason: collision with root package name */
        public float f2499h = Float.NaN;

        /* renamed from: i, reason: collision with root package name */
        public float f2500i = Float.NaN;

        /* renamed from: j, reason: collision with root package name */
        public int f2501j = -1;

        /* renamed from: k, reason: collision with root package name */
        public String f2502k = null;

        /* renamed from: l, reason: collision with root package name */
        public int f2503l = -3;

        /* renamed from: m, reason: collision with root package name */
        public int f2504m = -1;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            n = sparseIntArray;
            sparseIntArray.append(R.styleable.Motion_motionPathRotate, 1);
            sparseIntArray.append(R.styleable.Motion_pathMotionArc, 2);
            sparseIntArray.append(R.styleable.Motion_transitionEasing, 3);
            sparseIntArray.append(R.styleable.Motion_drawPath, 4);
            sparseIntArray.append(R.styleable.Motion_animateRelativeTo, 5);
            sparseIntArray.append(R.styleable.Motion_animateCircleAngleTo, 6);
            sparseIntArray.append(R.styleable.Motion_motionStagger, 7);
            sparseIntArray.append(R.styleable.Motion_quantizeMotionSteps, 8);
            sparseIntArray.append(R.styleable.Motion_quantizeMotionPhase, 9);
            sparseIntArray.append(R.styleable.Motion_quantizeMotionInterpolator, 10);
        }

        public final void a(Motion motion) {
            this.f2492a = motion.f2492a;
            this.f2493b = motion.f2493b;
            this.f2495d = motion.f2495d;
            this.f2496e = motion.f2496e;
            this.f2497f = motion.f2497f;
            this.f2499h = motion.f2499h;
            this.f2498g = motion.f2498g;
        }

        public final void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Motion);
            this.f2492a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                switch (n.get(index)) {
                    case 1:
                        this.f2499h = typedArrayObtainStyledAttributes.getFloat(index, this.f2499h);
                        break;
                    case 2:
                        this.f2496e = typedArrayObtainStyledAttributes.getInt(index, this.f2496e);
                        break;
                    case 3:
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            this.f2495d = typedArrayObtainStyledAttributes.getString(index);
                            break;
                        } else {
                            this.f2495d = Easing.f1811c[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        this.f2497f = typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f2493b = ConstraintSet.m(typedArrayObtainStyledAttributes, index, this.f2493b);
                        break;
                    case 6:
                        this.f2494c = typedArrayObtainStyledAttributes.getInteger(index, this.f2494c);
                        break;
                    case 7:
                        this.f2498g = typedArrayObtainStyledAttributes.getFloat(index, this.f2498g);
                        break;
                    case 8:
                        this.f2501j = typedArrayObtainStyledAttributes.getInteger(index, this.f2501j);
                        break;
                    case 9:
                        this.f2500i = typedArrayObtainStyledAttributes.getFloat(index, this.f2500i);
                        break;
                    case 10:
                        int i3 = typedArrayObtainStyledAttributes.peekValue(index).type;
                        if (i3 == 1) {
                            int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                            this.f2504m = resourceId;
                            if (resourceId != -1) {
                                this.f2503l = -2;
                                break;
                            } else {
                                break;
                            }
                        } else if (i3 == 3) {
                            String string = typedArrayObtainStyledAttributes.getString(index);
                            this.f2502k = string;
                            if (string.indexOf("/") > 0) {
                                this.f2504m = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                this.f2503l = -2;
                                break;
                            } else {
                                this.f2503l = -1;
                                break;
                            }
                        } else {
                            this.f2503l = typedArrayObtainStyledAttributes.getInteger(index, this.f2504m);
                            break;
                        }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class PropertySet {

        /* renamed from: a, reason: collision with root package name */
        public boolean f2505a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f2506b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f2507c = 0;

        /* renamed from: d, reason: collision with root package name */
        public float f2508d = 1.0f;

        /* renamed from: e, reason: collision with root package name */
        public float f2509e = Float.NaN;

        public final void a(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PropertySet);
            this.f2505a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.PropertySet_android_alpha) {
                    this.f2508d = typedArrayObtainStyledAttributes.getFloat(index, this.f2508d);
                } else if (index == R.styleable.PropertySet_android_visibility) {
                    int i3 = typedArrayObtainStyledAttributes.getInt(index, this.f2506b);
                    this.f2506b = i3;
                    this.f2506b = ConstraintSet.f2449h[i3];
                } else if (index == R.styleable.PropertySet_visibilityMode) {
                    this.f2507c = typedArrayObtainStyledAttributes.getInt(index, this.f2507c);
                } else if (index == R.styleable.PropertySet_motionProgress) {
                    this.f2509e = typedArrayObtainStyledAttributes.getFloat(index, this.f2509e);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class Transform {
        public static final SparseIntArray o;

        /* renamed from: a, reason: collision with root package name */
        public boolean f2510a = false;

        /* renamed from: b, reason: collision with root package name */
        public float f2511b = 0.0f;

        /* renamed from: c, reason: collision with root package name */
        public float f2512c = 0.0f;

        /* renamed from: d, reason: collision with root package name */
        public float f2513d = 0.0f;

        /* renamed from: e, reason: collision with root package name */
        public float f2514e = 1.0f;

        /* renamed from: f, reason: collision with root package name */
        public float f2515f = 1.0f;

        /* renamed from: g, reason: collision with root package name */
        public float f2516g = Float.NaN;

        /* renamed from: h, reason: collision with root package name */
        public float f2517h = Float.NaN;

        /* renamed from: i, reason: collision with root package name */
        public int f2518i = -1;

        /* renamed from: j, reason: collision with root package name */
        public float f2519j = 0.0f;

        /* renamed from: k, reason: collision with root package name */
        public float f2520k = 0.0f;

        /* renamed from: l, reason: collision with root package name */
        public float f2521l = 0.0f;

        /* renamed from: m, reason: collision with root package name */
        public boolean f2522m = false;
        public float n = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            o = sparseIntArray;
            sparseIntArray.append(R.styleable.Transform_android_rotation, 1);
            sparseIntArray.append(R.styleable.Transform_android_rotationX, 2);
            sparseIntArray.append(R.styleable.Transform_android_rotationY, 3);
            sparseIntArray.append(R.styleable.Transform_android_scaleX, 4);
            sparseIntArray.append(R.styleable.Transform_android_scaleY, 5);
            sparseIntArray.append(R.styleable.Transform_android_transformPivotX, 6);
            sparseIntArray.append(R.styleable.Transform_android_transformPivotY, 7);
            sparseIntArray.append(R.styleable.Transform_android_translationX, 8);
            sparseIntArray.append(R.styleable.Transform_android_translationY, 9);
            sparseIntArray.append(R.styleable.Transform_android_translationZ, 10);
            sparseIntArray.append(R.styleable.Transform_android_elevation, 11);
            sparseIntArray.append(R.styleable.Transform_transformPivotTarget, 12);
        }

        public final void a(Transform transform) {
            this.f2510a = transform.f2510a;
            this.f2511b = transform.f2511b;
            this.f2512c = transform.f2512c;
            this.f2513d = transform.f2513d;
            this.f2514e = transform.f2514e;
            this.f2515f = transform.f2515f;
            this.f2516g = transform.f2516g;
            this.f2517h = transform.f2517h;
            this.f2518i = transform.f2518i;
            this.f2519j = transform.f2519j;
            this.f2520k = transform.f2520k;
            this.f2521l = transform.f2521l;
            this.f2522m = transform.f2522m;
            this.n = transform.n;
        }

        public final void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Transform);
            this.f2510a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                switch (o.get(index)) {
                    case 1:
                        this.f2511b = typedArrayObtainStyledAttributes.getFloat(index, this.f2511b);
                        break;
                    case 2:
                        this.f2512c = typedArrayObtainStyledAttributes.getFloat(index, this.f2512c);
                        break;
                    case 3:
                        this.f2513d = typedArrayObtainStyledAttributes.getFloat(index, this.f2513d);
                        break;
                    case 4:
                        this.f2514e = typedArrayObtainStyledAttributes.getFloat(index, this.f2514e);
                        break;
                    case 5:
                        this.f2515f = typedArrayObtainStyledAttributes.getFloat(index, this.f2515f);
                        break;
                    case 6:
                        this.f2516g = typedArrayObtainStyledAttributes.getDimension(index, this.f2516g);
                        break;
                    case 7:
                        this.f2517h = typedArrayObtainStyledAttributes.getDimension(index, this.f2517h);
                        break;
                    case 8:
                        this.f2519j = typedArrayObtainStyledAttributes.getDimension(index, this.f2519j);
                        break;
                    case 9:
                        this.f2520k = typedArrayObtainStyledAttributes.getDimension(index, this.f2520k);
                        break;
                    case 10:
                        this.f2521l = typedArrayObtainStyledAttributes.getDimension(index, this.f2521l);
                        break;
                    case 11:
                        this.f2522m = true;
                        this.n = typedArrayObtainStyledAttributes.getDimension(index, this.n);
                        break;
                    case 12:
                        this.f2518i = ConstraintSet.m(typedArrayObtainStyledAttributes, index, this.f2518i);
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public class WriteJsonEngine {
    }

    public class WriteXmlEngine {
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2450i = sparseIntArray;
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        f2451j = sparseIntArray2;
        sparseIntArray.append(R.styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintRight_toRightOf, 30);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintTop_toTopOf, 36);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintBaseline_toTopOf, 91);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintBaseline_toBottomOf, 92);
        sparseIntArray.append(R.styleable.Constraint_layout_editor_absoluteX, 6);
        sparseIntArray.append(R.styleable.Constraint_layout_editor_absoluteY, 7);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintGuide_begin, 17);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintGuide_end, 18);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintGuide_percent, 19);
        sparseIntArray.append(R.styleable.Constraint_guidelineUseRtl, 99);
        sparseIntArray.append(R.styleable.Constraint_android_orientation, 27);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintStart_toEndOf, 32);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintStart_toStartOf, 33);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        sparseIntArray.append(R.styleable.Constraint_layout_goneMarginLeft, 13);
        sparseIntArray.append(R.styleable.Constraint_layout_goneMarginTop, 16);
        sparseIntArray.append(R.styleable.Constraint_layout_goneMarginRight, 14);
        sparseIntArray.append(R.styleable.Constraint_layout_goneMarginBottom, 11);
        sparseIntArray.append(R.styleable.Constraint_layout_goneMarginStart, 15);
        sparseIntArray.append(R.styleable.Constraint_layout_goneMarginEnd, 12);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintVertical_weight, 40);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintHorizontal_weight, 39);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintHorizontal_bias, 20);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintVertical_bias, 37);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintDimensionRatio, 5);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintLeft_creator, 87);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintTop_creator, 87);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintRight_creator, 87);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintBottom_creator, 87);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintBaseline_creator, 87);
        sparseIntArray.append(R.styleable.Constraint_android_layout_marginLeft, 24);
        sparseIntArray.append(R.styleable.Constraint_android_layout_marginRight, 28);
        sparseIntArray.append(R.styleable.Constraint_android_layout_marginStart, 31);
        sparseIntArray.append(R.styleable.Constraint_android_layout_marginEnd, 8);
        sparseIntArray.append(R.styleable.Constraint_android_layout_marginTop, 34);
        sparseIntArray.append(R.styleable.Constraint_android_layout_marginBottom, 2);
        sparseIntArray.append(R.styleable.Constraint_android_layout_width, 23);
        sparseIntArray.append(R.styleable.Constraint_android_layout_height, 21);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintWidth, 95);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintHeight, 96);
        sparseIntArray.append(R.styleable.Constraint_android_visibility, 22);
        sparseIntArray.append(R.styleable.Constraint_android_alpha, 43);
        sparseIntArray.append(R.styleable.Constraint_android_elevation, 44);
        sparseIntArray.append(R.styleable.Constraint_android_rotationX, 45);
        sparseIntArray.append(R.styleable.Constraint_android_rotationY, 46);
        sparseIntArray.append(R.styleable.Constraint_android_rotation, 60);
        sparseIntArray.append(R.styleable.Constraint_android_scaleX, 47);
        sparseIntArray.append(R.styleable.Constraint_android_scaleY, 48);
        sparseIntArray.append(R.styleable.Constraint_android_transformPivotX, 49);
        sparseIntArray.append(R.styleable.Constraint_android_transformPivotY, 50);
        sparseIntArray.append(R.styleable.Constraint_android_translationX, 51);
        sparseIntArray.append(R.styleable.Constraint_android_translationY, 52);
        sparseIntArray.append(R.styleable.Constraint_android_translationZ, 53);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintWidth_default, 54);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintHeight_default, 55);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintWidth_max, 56);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintHeight_max, 57);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintWidth_min, 58);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintHeight_min, 59);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintCircle, 61);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintCircleRadius, 62);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintCircleAngle, 63);
        sparseIntArray.append(R.styleable.Constraint_animateRelativeTo, 64);
        sparseIntArray.append(R.styleable.Constraint_transitionEasing, 65);
        sparseIntArray.append(R.styleable.Constraint_drawPath, 66);
        sparseIntArray.append(R.styleable.Constraint_transitionPathRotate, 67);
        sparseIntArray.append(R.styleable.Constraint_motionStagger, 79);
        sparseIntArray.append(R.styleable.Constraint_android_id, 38);
        sparseIntArray.append(R.styleable.Constraint_motionProgress, 68);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintWidth_percent, 69);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintHeight_percent, 70);
        sparseIntArray.append(R.styleable.Constraint_layout_wrapBehaviorInParent, 97);
        sparseIntArray.append(R.styleable.Constraint_chainUseRtl, 71);
        sparseIntArray.append(R.styleable.Constraint_barrierDirection, 72);
        sparseIntArray.append(R.styleable.Constraint_barrierMargin, 73);
        sparseIntArray.append(R.styleable.Constraint_constraint_referenced_ids, 74);
        sparseIntArray.append(R.styleable.Constraint_barrierAllowsGoneWidgets, 75);
        sparseIntArray.append(R.styleable.Constraint_pathMotionArc, 76);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintTag, 77);
        sparseIntArray.append(R.styleable.Constraint_visibilityMode, 78);
        sparseIntArray.append(R.styleable.Constraint_layout_constrainedWidth, 80);
        sparseIntArray.append(R.styleable.Constraint_layout_constrainedHeight, 81);
        sparseIntArray.append(R.styleable.Constraint_polarRelativeTo, 82);
        sparseIntArray.append(R.styleable.Constraint_transformPivotTarget, 83);
        sparseIntArray.append(R.styleable.Constraint_quantizeMotionSteps, 84);
        sparseIntArray.append(R.styleable.Constraint_quantizeMotionPhase, 85);
        sparseIntArray.append(R.styleable.Constraint_quantizeMotionInterpolator, 86);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_editor_absoluteY, 6);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_editor_absoluteY, 7);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_orientation, 27);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_goneMarginLeft, 13);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_goneMarginTop, 16);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_goneMarginRight, 14);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_goneMarginBottom, 11);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_goneMarginStart, 15);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_goneMarginEnd, 12);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintVertical_weight, 40);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintVertical_bias, 37);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintDimensionRatio, 5);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintLeft_creator, 87);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintTop_creator, 87);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintRight_creator, 87);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintBottom_creator, 87);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintBaseline_creator, 87);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_layout_marginLeft, 24);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_layout_marginRight, 28);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_layout_marginStart, 31);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_layout_marginEnd, 8);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_layout_marginTop, 34);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_layout_marginBottom, 2);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_layout_width, 23);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_layout_height, 21);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintWidth, 95);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintHeight, 96);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_visibility, 22);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_alpha, 43);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_elevation, 44);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_rotationX, 45);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_rotationY, 46);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_rotation, 60);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_scaleX, 47);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_scaleY, 48);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_transformPivotX, 49);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_transformPivotY, 50);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_translationX, 51);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_translationY, 52);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_translationZ, 53);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintWidth_default, 54);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintHeight_default, 55);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintWidth_max, 56);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintHeight_max, 57);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintWidth_min, 58);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintHeight_min, 59);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintCircleRadius, 62);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintCircleAngle, 63);
        sparseIntArray2.append(R.styleable.ConstraintOverride_animateRelativeTo, 64);
        sparseIntArray2.append(R.styleable.ConstraintOverride_transitionEasing, 65);
        sparseIntArray2.append(R.styleable.ConstraintOverride_drawPath, 66);
        sparseIntArray2.append(R.styleable.ConstraintOverride_transitionPathRotate, 67);
        sparseIntArray2.append(R.styleable.ConstraintOverride_motionStagger, 79);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_id, 38);
        sparseIntArray2.append(R.styleable.ConstraintOverride_motionTarget, 98);
        sparseIntArray2.append(R.styleable.ConstraintOverride_motionProgress, 68);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintWidth_percent, 69);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintHeight_percent, 70);
        sparseIntArray2.append(R.styleable.ConstraintOverride_chainUseRtl, 71);
        sparseIntArray2.append(R.styleable.ConstraintOverride_barrierDirection, 72);
        sparseIntArray2.append(R.styleable.ConstraintOverride_barrierMargin, 73);
        sparseIntArray2.append(R.styleable.ConstraintOverride_constraint_referenced_ids, 74);
        sparseIntArray2.append(R.styleable.ConstraintOverride_barrierAllowsGoneWidgets, 75);
        sparseIntArray2.append(R.styleable.ConstraintOverride_pathMotionArc, 76);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintTag, 77);
        sparseIntArray2.append(R.styleable.ConstraintOverride_visibilityMode, 78);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constrainedWidth, 80);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constrainedHeight, 81);
        sparseIntArray2.append(R.styleable.ConstraintOverride_polarRelativeTo, 82);
        sparseIntArray2.append(R.styleable.ConstraintOverride_transformPivotTarget, 83);
        sparseIntArray2.append(R.styleable.ConstraintOverride_quantizeMotionSteps, 84);
        sparseIntArray2.append(R.styleable.ConstraintOverride_quantizeMotionPhase, 85);
        sparseIntArray2.append(R.styleable.ConstraintOverride_quantizeMotionInterpolator, 86);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_wrapBehaviorInParent, 97);
    }

    public static Constraint e(Context context, XmlResourceParser xmlResourceParser) {
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlResourceParser);
        Constraint constraint = new Constraint();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSetAsAttributeSet, R.styleable.ConstraintOverride);
        p(constraint, typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        return constraint;
    }

    public static int[] g(Barrier barrier, String str) throws IllegalAccessException, IllegalArgumentException {
        int iIntValue;
        String[] strArrSplit = str.split(",");
        Context context = barrier.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < strArrSplit.length) {
            String strTrim = strArrSplit[i2].trim();
            Object obj = null;
            try {
                iIntValue = R.id.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, CLConstants.SHARED_PREFERENCE_ITEM_ID, context.getPackageName());
            }
            if (iIntValue == 0 && barrier.isInEditMode() && (barrier.getParent() instanceof ConstraintLayout)) {
                ConstraintLayout constraintLayout = (ConstraintLayout) barrier.getParent();
                if (strTrim != null) {
                    HashMap map = constraintLayout.f2409m;
                    if (map != null && map.containsKey(strTrim)) {
                        obj = constraintLayout.f2409m.get(strTrim);
                    }
                } else {
                    constraintLayout.getClass();
                }
                if (obj != null && (obj instanceof Integer)) {
                    iIntValue = ((Integer) obj).intValue();
                }
            }
            iArr[i3] = iIntValue;
            i2++;
            i3++;
        }
        return i3 != strArrSplit.length ? Arrays.copyOf(iArr, i3) : iArr;
    }

    public static Constraint h(Context context, AttributeSet attributeSet, boolean z) {
        Constraint constraint = new Constraint();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z ? R.styleable.ConstraintOverride : R.styleable.Constraint);
        if (z) {
            p(constraint, typedArrayObtainStyledAttributes);
        } else {
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            int i2 = 0;
            while (true) {
                Layout layout = constraint.f2463e;
                if (i2 < indexCount) {
                    int index = typedArrayObtainStyledAttributes.getIndex(i2);
                    int i3 = R.styleable.Constraint_android_id;
                    PropertySet propertySet = constraint.f2461c;
                    Transform transform = constraint.f2464f;
                    Motion motion = constraint.f2462d;
                    if (index != i3 && R.styleable.Constraint_android_layout_marginStart != index && R.styleable.Constraint_android_layout_marginEnd != index) {
                        motion.f2492a = true;
                        layout.f2480b = true;
                        propertySet.f2505a = true;
                        transform.f2510a = true;
                    }
                    SparseIntArray sparseIntArray = f2450i;
                    switch (sparseIntArray.get(index)) {
                        case 1:
                            layout.q = m(typedArrayObtainStyledAttributes, index, layout.q);
                            break;
                        case 2:
                            layout.J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.J);
                            break;
                        case 3:
                            layout.p = m(typedArrayObtainStyledAttributes, index, layout.p);
                            break;
                        case 4:
                            layout.o = m(typedArrayObtainStyledAttributes, index, layout.o);
                            break;
                        case 5:
                            layout.z = typedArrayObtainStyledAttributes.getString(index);
                            break;
                        case 6:
                            layout.D = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, layout.D);
                            break;
                        case 7:
                            layout.E = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, layout.E);
                            break;
                        case 8:
                            layout.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.K);
                            break;
                        case 9:
                            layout.w = m(typedArrayObtainStyledAttributes, index, layout.w);
                            break;
                        case 10:
                            layout.v = m(typedArrayObtainStyledAttributes, index, layout.v);
                            break;
                        case 11:
                            layout.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.Q);
                            break;
                        case 12:
                            layout.R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.R);
                            break;
                        case 13:
                            layout.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.N);
                            break;
                        case 14:
                            layout.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.P);
                            break;
                        case 15:
                            layout.S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.S);
                            break;
                        case 16:
                            layout.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.O);
                            break;
                        case 17:
                            layout.f2483e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, layout.f2483e);
                            break;
                        case 18:
                            layout.f2484f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, layout.f2484f);
                            break;
                        case 19:
                            layout.f2485g = typedArrayObtainStyledAttributes.getFloat(index, layout.f2485g);
                            break;
                        case 20:
                            layout.x = typedArrayObtainStyledAttributes.getFloat(index, layout.x);
                            break;
                        case 21:
                            layout.f2482d = typedArrayObtainStyledAttributes.getLayoutDimension(index, layout.f2482d);
                            break;
                        case 22:
                            int i4 = typedArrayObtainStyledAttributes.getInt(index, propertySet.f2506b);
                            propertySet.f2506b = i4;
                            propertySet.f2506b = f2449h[i4];
                            break;
                        case 23:
                            layout.f2481c = typedArrayObtainStyledAttributes.getLayoutDimension(index, layout.f2481c);
                            break;
                        case 24:
                            layout.G = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.G);
                            break;
                        case 25:
                            layout.f2487i = m(typedArrayObtainStyledAttributes, index, layout.f2487i);
                            break;
                        case 26:
                            layout.f2488j = m(typedArrayObtainStyledAttributes, index, layout.f2488j);
                            break;
                        case 27:
                            layout.F = typedArrayObtainStyledAttributes.getInt(index, layout.F);
                            break;
                        case 28:
                            layout.H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.H);
                            break;
                        case 29:
                            layout.f2489k = m(typedArrayObtainStyledAttributes, index, layout.f2489k);
                            break;
                        case 30:
                            layout.f2490l = m(typedArrayObtainStyledAttributes, index, layout.f2490l);
                            break;
                        case 31:
                            layout.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.L);
                            break;
                        case 32:
                            layout.t = m(typedArrayObtainStyledAttributes, index, layout.t);
                            break;
                        case 33:
                            layout.u = m(typedArrayObtainStyledAttributes, index, layout.u);
                            break;
                        case 34:
                            layout.I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.I);
                            break;
                        case 35:
                            layout.n = m(typedArrayObtainStyledAttributes, index, layout.n);
                            break;
                        case 36:
                            layout.f2491m = m(typedArrayObtainStyledAttributes, index, layout.f2491m);
                            break;
                        case 37:
                            layout.y = typedArrayObtainStyledAttributes.getFloat(index, layout.y);
                            break;
                        case Type.A6 /* 38 */:
                            constraint.f2459a = typedArrayObtainStyledAttributes.getResourceId(index, constraint.f2459a);
                            break;
                        case 39:
                            layout.V = typedArrayObtainStyledAttributes.getFloat(index, layout.V);
                            break;
                        case 40:
                            layout.U = typedArrayObtainStyledAttributes.getFloat(index, layout.U);
                            break;
                        case 41:
                            layout.W = typedArrayObtainStyledAttributes.getInt(index, layout.W);
                            break;
                        case 42:
                            layout.X = typedArrayObtainStyledAttributes.getInt(index, layout.X);
                            break;
                        case 43:
                            propertySet.f2508d = typedArrayObtainStyledAttributes.getFloat(index, propertySet.f2508d);
                            break;
                        case 44:
                            transform.f2522m = true;
                            transform.n = typedArrayObtainStyledAttributes.getDimension(index, transform.n);
                            break;
                        case 45:
                            transform.f2512c = typedArrayObtainStyledAttributes.getFloat(index, transform.f2512c);
                            break;
                        case 46:
                            transform.f2513d = typedArrayObtainStyledAttributes.getFloat(index, transform.f2513d);
                            break;
                        case 47:
                            transform.f2514e = typedArrayObtainStyledAttributes.getFloat(index, transform.f2514e);
                            break;
                        case Type.DNSKEY /* 48 */:
                            transform.f2515f = typedArrayObtainStyledAttributes.getFloat(index, transform.f2515f);
                            break;
                        case 49:
                            transform.f2516g = typedArrayObtainStyledAttributes.getDimension(index, transform.f2516g);
                            break;
                        case 50:
                            transform.f2517h = typedArrayObtainStyledAttributes.getDimension(index, transform.f2517h);
                            break;
                        case 51:
                            transform.f2519j = typedArrayObtainStyledAttributes.getDimension(index, transform.f2519j);
                            break;
                        case Type.TLSA /* 52 */:
                            transform.f2520k = typedArrayObtainStyledAttributes.getDimension(index, transform.f2520k);
                            break;
                        case 53:
                            transform.f2521l = typedArrayObtainStyledAttributes.getDimension(index, transform.f2521l);
                            break;
                        case 54:
                            layout.Y = typedArrayObtainStyledAttributes.getInt(index, layout.Y);
                            break;
                        case 55:
                            layout.Z = typedArrayObtainStyledAttributes.getInt(index, layout.Z);
                            break;
                        case Type.NINFO /* 56 */:
                            layout.a0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.a0);
                            break;
                        case Type.RKEY /* 57 */:
                            layout.b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.b0);
                            break;
                        case Type.TALINK /* 58 */:
                            layout.c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.c0);
                            break;
                        case Type.CDS /* 59 */:
                            layout.d0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.d0);
                            break;
                        case 60:
                            transform.f2511b = typedArrayObtainStyledAttributes.getFloat(index, transform.f2511b);
                            break;
                        case 61:
                            layout.A = m(typedArrayObtainStyledAttributes, index, layout.A);
                            break;
                        case 62:
                            layout.B = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.B);
                            break;
                        case 63:
                            layout.C = typedArrayObtainStyledAttributes.getFloat(index, layout.C);
                            break;
                        case 64:
                            motion.f2493b = m(typedArrayObtainStyledAttributes, index, motion.f2493b);
                            break;
                        case 65:
                            if (typedArrayObtainStyledAttributes.peekValue(index).type != 3) {
                                motion.f2495d = Easing.f1811c[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                                break;
                            } else {
                                motion.f2495d = typedArrayObtainStyledAttributes.getString(index);
                                break;
                            }
                        case WKSRecord.Protocol.RVD /* 66 */:
                            motion.f2497f = typedArrayObtainStyledAttributes.getInt(index, 0);
                            break;
                        case 67:
                            motion.f2499h = typedArrayObtainStyledAttributes.getFloat(index, motion.f2499h);
                            break;
                        case WKSRecord.Service.BOOTPC /* 68 */:
                            propertySet.f2509e = typedArrayObtainStyledAttributes.getFloat(index, propertySet.f2509e);
                            break;
                        case 69:
                            layout.e0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                            break;
                        case 70:
                            layout.f0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                            break;
                        case 71:
                            Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                            break;
                        case WKSRecord.Service.NETRJS_2 /* 72 */:
                            layout.g0 = typedArrayObtainStyledAttributes.getInt(index, layout.g0);
                            break;
                        case WKSRecord.Service.NETRJS_3 /* 73 */:
                            layout.h0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.h0);
                            break;
                        case WKSRecord.Service.NETRJS_4 /* 74 */:
                            layout.k0 = typedArrayObtainStyledAttributes.getString(index);
                            break;
                        case 75:
                            layout.o0 = typedArrayObtainStyledAttributes.getBoolean(index, layout.o0);
                            break;
                        case 76:
                            motion.f2496e = typedArrayObtainStyledAttributes.getInt(index, motion.f2496e);
                            break;
                        case 77:
                            layout.l0 = typedArrayObtainStyledAttributes.getString(index);
                            break;
                        case 78:
                            propertySet.f2507c = typedArrayObtainStyledAttributes.getInt(index, propertySet.f2507c);
                            break;
                        case 79:
                            motion.f2498g = typedArrayObtainStyledAttributes.getFloat(index, motion.f2498g);
                            break;
                        case 80:
                            layout.m0 = typedArrayObtainStyledAttributes.getBoolean(index, layout.m0);
                            break;
                        case WKSRecord.Service.HOSTS2_NS /* 81 */:
                            layout.n0 = typedArrayObtainStyledAttributes.getBoolean(index, layout.n0);
                            break;
                        case 82:
                            motion.f2494c = typedArrayObtainStyledAttributes.getInteger(index, motion.f2494c);
                            break;
                        case 83:
                            transform.f2518i = m(typedArrayObtainStyledAttributes, index, transform.f2518i);
                            break;
                        case 84:
                            motion.f2501j = typedArrayObtainStyledAttributes.getInteger(index, motion.f2501j);
                            break;
                        case 85:
                            motion.f2500i = typedArrayObtainStyledAttributes.getFloat(index, motion.f2500i);
                            break;
                        case 86:
                            int i5 = typedArrayObtainStyledAttributes.peekValue(index).type;
                            if (i5 != 1) {
                                if (i5 != 3) {
                                    motion.f2503l = typedArrayObtainStyledAttributes.getInteger(index, motion.f2504m);
                                    break;
                                } else {
                                    String string = typedArrayObtainStyledAttributes.getString(index);
                                    motion.f2502k = string;
                                    if (string.indexOf("/") <= 0) {
                                        motion.f2503l = -1;
                                        break;
                                    } else {
                                        motion.f2504m = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                        motion.f2503l = -2;
                                        break;
                                    }
                                }
                            } else {
                                int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                motion.f2504m = resourceId;
                                if (resourceId == -1) {
                                    break;
                                } else {
                                    motion.f2503l = -2;
                                    break;
                                }
                            }
                        case 87:
                            Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                            break;
                        case 88:
                        case WKSRecord.Service.SU_MIT_TG /* 89 */:
                        case 90:
                        default:
                            Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                            break;
                        case WKSRecord.Service.MIT_DOV /* 91 */:
                            layout.r = m(typedArrayObtainStyledAttributes, index, layout.r);
                            break;
                        case 92:
                            layout.s = m(typedArrayObtainStyledAttributes, index, layout.s);
                            break;
                        case WKSRecord.Service.DCP /* 93 */:
                            layout.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.M);
                            break;
                        case 94:
                            layout.T = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, layout.T);
                            break;
                        case WKSRecord.Service.SUPDUP /* 95 */:
                            n(layout, typedArrayObtainStyledAttributes, index, 0);
                            break;
                        case 96:
                            n(layout, typedArrayObtainStyledAttributes, index, 1);
                            break;
                        case WKSRecord.Service.SWIFT_RVF /* 97 */:
                            layout.p0 = typedArrayObtainStyledAttributes.getInt(index, layout.p0);
                            break;
                    }
                    i2++;
                } else if (layout.k0 != null) {
                    layout.j0 = null;
                }
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return constraint;
    }

    public static int m(TypedArray typedArray, int i2, int i3) {
        int resourceId = typedArray.getResourceId(i2, i3);
        return resourceId == -1 ? typedArray.getInt(i2, -1) : resourceId;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void n(java.lang.Object r7, android.content.res.TypedArray r8, int r9, int r10) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintSet.n(java.lang.Object, android.content.res.TypedArray, int, int):void");
    }

    public static void o(ConstraintLayout.LayoutParams layoutParams, String str) {
        if (str != null) {
            int length = str.length();
            int iIndexOf = str.indexOf(44);
            char c2 = 65535;
            int i2 = 0;
            if (iIndexOf > 0 && iIndexOf < length - 1) {
                String strSubstring = str.substring(0, iIndexOf);
                if (strSubstring.equalsIgnoreCase("W")) {
                    c2 = 0;
                } else if (strSubstring.equalsIgnoreCase("H")) {
                    c2 = 1;
                }
                i2 = iIndexOf + 1;
            }
            int iIndexOf2 = str.indexOf(58);
            try {
                if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                    String strSubstring2 = str.substring(i2);
                    if (strSubstring2.length() > 0) {
                        Float.parseFloat(strSubstring2);
                    }
                } else {
                    String strSubstring3 = str.substring(i2, iIndexOf2);
                    String strSubstring4 = str.substring(iIndexOf2 + 1);
                    if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                        float f2 = Float.parseFloat(strSubstring3);
                        float f3 = Float.parseFloat(strSubstring4);
                        if (f2 > 0.0f && f3 > 0.0f) {
                            if (c2 == 1) {
                                Math.abs(f3 / f2);
                            } else {
                                Math.abs(f2 / f3);
                            }
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        layoutParams.G = str;
    }

    public static void p(Constraint constraint, TypedArray typedArray) {
        char c2;
        int indexCount = typedArray.getIndexCount();
        Constraint.Delta delta = new Constraint.Delta();
        delta.f2467a = new int[10];
        delta.f2468b = new int[10];
        delta.f2469c = 0;
        delta.f2470d = new int[10];
        delta.f2471e = new float[10];
        delta.f2472f = 0;
        delta.f2473g = new int[5];
        delta.f2474h = new String[5];
        delta.f2475i = 0;
        delta.f2476j = new int[4];
        delta.f2477k = new boolean[4];
        delta.f2478l = 0;
        constraint.f2466h = delta;
        Motion motion = constraint.f2462d;
        motion.f2492a = false;
        Layout layout = constraint.f2463e;
        layout.f2480b = false;
        PropertySet propertySet = constraint.f2461c;
        propertySet.f2505a = false;
        Transform transform = constraint.f2464f;
        transform.f2510a = false;
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArray.getIndex(i2);
            int i3 = f2451j.get(index);
            SparseIntArray sparseIntArray = f2450i;
            switch (i3) {
                case 2:
                    c2 = 5;
                    delta.b(2, typedArray.getDimensionPixelSize(index, layout.J));
                    break;
                case 3:
                case 4:
                case 9:
                case 10:
                case 25:
                case 26:
                case 29:
                case 30:
                case 32:
                case 33:
                case 35:
                case 36:
                case 61:
                case 88:
                case WKSRecord.Service.SU_MIT_TG /* 89 */:
                case 90:
                case WKSRecord.Service.MIT_DOV /* 91 */:
                case 92:
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                    c2 = 5;
                    break;
                case 5:
                    c2 = 5;
                    delta.c(5, typedArray.getString(index));
                    break;
                case 6:
                    delta.b(6, typedArray.getDimensionPixelOffset(index, layout.D));
                    c2 = 5;
                    break;
                case 7:
                    delta.b(7, typedArray.getDimensionPixelOffset(index, layout.E));
                    c2 = 5;
                    break;
                case 8:
                    delta.b(8, typedArray.getDimensionPixelSize(index, layout.K));
                    c2 = 5;
                    break;
                case 11:
                    delta.b(11, typedArray.getDimensionPixelSize(index, layout.Q));
                    c2 = 5;
                    break;
                case 12:
                    delta.b(12, typedArray.getDimensionPixelSize(index, layout.R));
                    c2 = 5;
                    break;
                case 13:
                    delta.b(13, typedArray.getDimensionPixelSize(index, layout.N));
                    c2 = 5;
                    break;
                case 14:
                    delta.b(14, typedArray.getDimensionPixelSize(index, layout.P));
                    c2 = 5;
                    break;
                case 15:
                    delta.b(15, typedArray.getDimensionPixelSize(index, layout.S));
                    c2 = 5;
                    break;
                case 16:
                    delta.b(16, typedArray.getDimensionPixelSize(index, layout.O));
                    c2 = 5;
                    break;
                case 17:
                    delta.b(17, typedArray.getDimensionPixelOffset(index, layout.f2483e));
                    c2 = 5;
                    break;
                case 18:
                    delta.b(18, typedArray.getDimensionPixelOffset(index, layout.f2484f));
                    c2 = 5;
                    break;
                case 19:
                    delta.a(typedArray.getFloat(index, layout.f2485g), 19);
                    c2 = 5;
                    break;
                case 20:
                    delta.a(typedArray.getFloat(index, layout.x), 20);
                    c2 = 5;
                    break;
                case 21:
                    delta.b(21, typedArray.getLayoutDimension(index, layout.f2482d));
                    c2 = 5;
                    break;
                case 22:
                    delta.b(22, f2449h[typedArray.getInt(index, propertySet.f2506b)]);
                    c2 = 5;
                    break;
                case 23:
                    delta.b(23, typedArray.getLayoutDimension(index, layout.f2481c));
                    c2 = 5;
                    break;
                case 24:
                    delta.b(24, typedArray.getDimensionPixelSize(index, layout.G));
                    c2 = 5;
                    break;
                case 27:
                    delta.b(27, typedArray.getInt(index, layout.F));
                    c2 = 5;
                    break;
                case 28:
                    delta.b(28, typedArray.getDimensionPixelSize(index, layout.H));
                    c2 = 5;
                    break;
                case 31:
                    delta.b(31, typedArray.getDimensionPixelSize(index, layout.L));
                    c2 = 5;
                    break;
                case 34:
                    delta.b(34, typedArray.getDimensionPixelSize(index, layout.I));
                    c2 = 5;
                    break;
                case 37:
                    delta.a(typedArray.getFloat(index, layout.y), 37);
                    c2 = 5;
                    break;
                case Type.A6 /* 38 */:
                    int resourceId = typedArray.getResourceId(index, constraint.f2459a);
                    constraint.f2459a = resourceId;
                    delta.b(38, resourceId);
                    c2 = 5;
                    break;
                case 39:
                    delta.a(typedArray.getFloat(index, layout.V), 39);
                    c2 = 5;
                    break;
                case 40:
                    delta.a(typedArray.getFloat(index, layout.U), 40);
                    c2 = 5;
                    break;
                case 41:
                    delta.b(41, typedArray.getInt(index, layout.W));
                    c2 = 5;
                    break;
                case 42:
                    delta.b(42, typedArray.getInt(index, layout.X));
                    c2 = 5;
                    break;
                case 43:
                    delta.a(typedArray.getFloat(index, propertySet.f2508d), 43);
                    c2 = 5;
                    break;
                case 44:
                    delta.d(44, true);
                    delta.a(typedArray.getDimension(index, transform.n), 44);
                    c2 = 5;
                    break;
                case 45:
                    delta.a(typedArray.getFloat(index, transform.f2512c), 45);
                    c2 = 5;
                    break;
                case 46:
                    delta.a(typedArray.getFloat(index, transform.f2513d), 46);
                    c2 = 5;
                    break;
                case 47:
                    delta.a(typedArray.getFloat(index, transform.f2514e), 47);
                    c2 = 5;
                    break;
                case Type.DNSKEY /* 48 */:
                    delta.a(typedArray.getFloat(index, transform.f2515f), 48);
                    c2 = 5;
                    break;
                case 49:
                    delta.a(typedArray.getDimension(index, transform.f2516g), 49);
                    c2 = 5;
                    break;
                case 50:
                    delta.a(typedArray.getDimension(index, transform.f2517h), 50);
                    c2 = 5;
                    break;
                case 51:
                    delta.a(typedArray.getDimension(index, transform.f2519j), 51);
                    c2 = 5;
                    break;
                case Type.TLSA /* 52 */:
                    delta.a(typedArray.getDimension(index, transform.f2520k), 52);
                    c2 = 5;
                    break;
                case 53:
                    delta.a(typedArray.getDimension(index, transform.f2521l), 53);
                    c2 = 5;
                    break;
                case 54:
                    delta.b(54, typedArray.getInt(index, layout.Y));
                    c2 = 5;
                    break;
                case 55:
                    delta.b(55, typedArray.getInt(index, layout.Z));
                    c2 = 5;
                    break;
                case Type.NINFO /* 56 */:
                    delta.b(56, typedArray.getDimensionPixelSize(index, layout.a0));
                    c2 = 5;
                    break;
                case Type.RKEY /* 57 */:
                    delta.b(57, typedArray.getDimensionPixelSize(index, layout.b0));
                    c2 = 5;
                    break;
                case Type.TALINK /* 58 */:
                    delta.b(58, typedArray.getDimensionPixelSize(index, layout.c0));
                    c2 = 5;
                    break;
                case Type.CDS /* 59 */:
                    delta.b(59, typedArray.getDimensionPixelSize(index, layout.d0));
                    c2 = 5;
                    break;
                case 60:
                    delta.a(typedArray.getFloat(index, transform.f2511b), 60);
                    c2 = 5;
                    break;
                case 62:
                    delta.b(62, typedArray.getDimensionPixelSize(index, layout.B));
                    c2 = 5;
                    break;
                case 63:
                    delta.a(typedArray.getFloat(index, layout.C), 63);
                    c2 = 5;
                    break;
                case 64:
                    delta.b(64, m(typedArray, index, motion.f2493b));
                    c2 = 5;
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        delta.c(65, typedArray.getString(index));
                    } else {
                        delta.c(65, Easing.f1811c[typedArray.getInteger(index, 0)]);
                    }
                    c2 = 5;
                    break;
                case WKSRecord.Protocol.RVD /* 66 */:
                    delta.b(66, typedArray.getInt(index, 0));
                    c2 = 5;
                    break;
                case 67:
                    delta.a(typedArray.getFloat(index, motion.f2499h), 67);
                    c2 = 5;
                    break;
                case WKSRecord.Service.BOOTPC /* 68 */:
                    delta.a(typedArray.getFloat(index, propertySet.f2509e), 68);
                    c2 = 5;
                    break;
                case 69:
                    delta.a(typedArray.getFloat(index, 1.0f), 69);
                    c2 = 5;
                    break;
                case 70:
                    delta.a(typedArray.getFloat(index, 1.0f), 70);
                    c2 = 5;
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    c2 = 5;
                    break;
                case WKSRecord.Service.NETRJS_2 /* 72 */:
                    delta.b(72, typedArray.getInt(index, layout.g0));
                    c2 = 5;
                    break;
                case WKSRecord.Service.NETRJS_3 /* 73 */:
                    delta.b(73, typedArray.getDimensionPixelSize(index, layout.h0));
                    c2 = 5;
                    break;
                case WKSRecord.Service.NETRJS_4 /* 74 */:
                    delta.c(74, typedArray.getString(index));
                    c2 = 5;
                    break;
                case 75:
                    delta.d(75, typedArray.getBoolean(index, layout.o0));
                    c2 = 5;
                    break;
                case 76:
                    delta.b(76, typedArray.getInt(index, motion.f2496e));
                    c2 = 5;
                    break;
                case 77:
                    delta.c(77, typedArray.getString(index));
                    c2 = 5;
                    break;
                case 78:
                    delta.b(78, typedArray.getInt(index, propertySet.f2507c));
                    c2 = 5;
                    break;
                case 79:
                    delta.a(typedArray.getFloat(index, motion.f2498g), 79);
                    c2 = 5;
                    break;
                case 80:
                    delta.d(80, typedArray.getBoolean(index, layout.m0));
                    c2 = 5;
                    break;
                case WKSRecord.Service.HOSTS2_NS /* 81 */:
                    delta.d(81, typedArray.getBoolean(index, layout.n0));
                    c2 = 5;
                    break;
                case 82:
                    delta.b(82, typedArray.getInteger(index, motion.f2494c));
                    c2 = 5;
                    break;
                case 83:
                    delta.b(83, m(typedArray, index, transform.f2518i));
                    c2 = 5;
                    break;
                case 84:
                    delta.b(84, typedArray.getInteger(index, motion.f2501j));
                    c2 = 5;
                    break;
                case 85:
                    delta.a(typedArray.getFloat(index, motion.f2500i), 85);
                    c2 = 5;
                    break;
                case 86:
                    int i4 = typedArray.peekValue(index).type;
                    if (i4 == 1) {
                        int resourceId2 = typedArray.getResourceId(index, -1);
                        motion.f2504m = resourceId2;
                        delta.b(89, resourceId2);
                        if (motion.f2504m != -1) {
                            motion.f2503l = -2;
                            delta.b(88, -2);
                        }
                    } else if (i4 == 3) {
                        String string = typedArray.getString(index);
                        motion.f2502k = string;
                        delta.c(90, string);
                        if (motion.f2502k.indexOf("/") > 0) {
                            int resourceId3 = typedArray.getResourceId(index, -1);
                            motion.f2504m = resourceId3;
                            delta.b(89, resourceId3);
                            motion.f2503l = -2;
                            delta.b(88, -2);
                        } else {
                            motion.f2503l = -1;
                            delta.b(88, -1);
                        }
                    } else {
                        int integer = typedArray.getInteger(index, motion.f2504m);
                        motion.f2503l = integer;
                        delta.b(88, integer);
                    }
                    c2 = 5;
                    break;
                case 87:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                    c2 = 5;
                    break;
                case WKSRecord.Service.DCP /* 93 */:
                    delta.b(93, typedArray.getDimensionPixelSize(index, layout.M));
                    c2 = 5;
                    break;
                case 94:
                    delta.b(94, typedArray.getDimensionPixelSize(index, layout.T));
                    c2 = 5;
                    break;
                case WKSRecord.Service.SUPDUP /* 95 */:
                    n(delta, typedArray, index, 0);
                    c2 = 5;
                    break;
                case 96:
                    n(delta, typedArray, index, 1);
                    c2 = 5;
                    break;
                case WKSRecord.Service.SWIFT_RVF /* 97 */:
                    delta.b(97, typedArray.getInt(index, layout.p0));
                    c2 = 5;
                    break;
                case WKSRecord.Service.TACNEWS /* 98 */:
                    if (MotionLayout.o1) {
                        int resourceId4 = typedArray.getResourceId(index, constraint.f2459a);
                        constraint.f2459a = resourceId4;
                        if (resourceId4 == -1) {
                            constraint.f2460b = typedArray.getString(index);
                        }
                    } else if (typedArray.peekValue(index).type == 3) {
                        constraint.f2460b = typedArray.getString(index);
                    } else {
                        constraint.f2459a = typedArray.getResourceId(index, constraint.f2459a);
                    }
                    c2 = 5;
                    break;
                case 99:
                    delta.d(99, typedArray.getBoolean(index, layout.f2486h));
                    c2 = 5;
                    break;
            }
        }
    }

    public final void a(MotionLayout motionLayout) {
        Constraint constraint;
        int childCount = motionLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = motionLayout.getChildAt(i2);
            int id = childAt.getId();
            HashMap map = this.f2458g;
            if (!map.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + Debug.d(childAt));
            } else {
                if (this.f2457f && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (map.containsKey(Integer.valueOf(id)) && (constraint = (Constraint) map.get(Integer.valueOf(id))) != null) {
                    ConstraintAttribute.e(childAt, constraint.f2465g);
                }
            }
        }
    }

    public final void b(ConstraintSet constraintSet) {
        for (Constraint constraint : constraintSet.f2458g.values()) {
            if (constraint.f2466h != null) {
                if (constraint.f2460b == null) {
                    constraint.f2466h.e(j(constraint.f2459a));
                } else {
                    Iterator it = this.f2458g.keySet().iterator();
                    while (it.hasNext()) {
                        Constraint constraintJ = j(((Integer) it.next()).intValue());
                        String str = constraintJ.f2463e.l0;
                        if (str != null && constraint.f2460b.matches(str)) {
                            constraint.f2466h.e(constraintJ);
                            constraintJ.f2465g.putAll((HashMap) constraint.f2465g.clone());
                        }
                    }
                }
            }
        }
    }

    public final void c(ConstraintLayout constraintLayout) {
        d(constraintLayout);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public final void d(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashMap map = this.f2458g;
        HashSet hashSet = new HashSet(map.keySet());
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            int id = childAt.getId();
            if (!map.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + Debug.d(childAt));
            } else {
                if (this.f2457f && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (map.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        Constraint constraint = (Constraint) map.get(Integer.valueOf(id));
                        if (constraint != null) {
                            if (childAt instanceof Barrier) {
                                Layout layout = constraint.f2463e;
                                layout.i0 = 1;
                                Barrier barrier = (Barrier) childAt;
                                barrier.setId(id);
                                barrier.setType(layout.g0);
                                barrier.setMargin(layout.h0);
                                barrier.setAllowsGoneWidget(layout.o0);
                                int[] iArr = layout.j0;
                                if (iArr != null) {
                                    barrier.setReferencedIds(iArr);
                                } else {
                                    String str = layout.k0;
                                    if (str != null) {
                                        int[] iArrG = g(barrier, str);
                                        layout.j0 = iArrG;
                                        barrier.setReferencedIds(iArrG);
                                    }
                                }
                            }
                            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                            layoutParams.a();
                            constraint.b(layoutParams);
                            ConstraintAttribute.e(childAt, constraint.f2465g);
                            childAt.setLayoutParams(layoutParams);
                            PropertySet propertySet = constraint.f2461c;
                            if (propertySet.f2507c == 0) {
                                childAt.setVisibility(propertySet.f2506b);
                            }
                            childAt.setAlpha(propertySet.f2508d);
                            Transform transform = constraint.f2464f;
                            childAt.setRotation(transform.f2511b);
                            childAt.setRotationX(transform.f2512c);
                            childAt.setRotationY(transform.f2513d);
                            childAt.setScaleX(transform.f2514e);
                            childAt.setScaleY(transform.f2515f);
                            if (transform.f2518i != -1) {
                                if (((View) childAt.getParent()).findViewById(transform.f2518i) != null) {
                                    float bottom = (r8.getBottom() + r8.getTop()) / 2.0f;
                                    float right = (r8.getRight() + r8.getLeft()) / 2.0f;
                                    if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                        childAt.setPivotX(right - childAt.getLeft());
                                        childAt.setPivotY(bottom - childAt.getTop());
                                    }
                                }
                            } else {
                                if (!Float.isNaN(transform.f2516g)) {
                                    childAt.setPivotX(transform.f2516g);
                                }
                                if (!Float.isNaN(transform.f2517h)) {
                                    childAt.setPivotY(transform.f2517h);
                                }
                            }
                            childAt.setTranslationX(transform.f2519j);
                            childAt.setTranslationY(transform.f2520k);
                            childAt.setTranslationZ(transform.f2521l);
                            if (transform.f2522m) {
                                childAt.setElevation(transform.n);
                            }
                        }
                    } else {
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            Constraint constraint2 = (Constraint) map.get(num);
            if (constraint2 != null) {
                Layout layout2 = constraint2.f2463e;
                if (layout2.i0 == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    int[] iArr2 = layout2.j0;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str2 = layout2.k0;
                        if (str2 != null) {
                            int[] iArrG2 = g(barrier2, str2);
                            layout2.j0 = iArrG2;
                            barrier2.setReferencedIds(iArrG2);
                        }
                    }
                    barrier2.setType(layout2.g0);
                    barrier2.setMargin(layout2.h0);
                    SharedValues sharedValues = ConstraintLayout.p;
                    ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
                    barrier2.q();
                    constraint2.b(layoutParams2);
                    constraintLayout.addView(barrier2, layoutParams2);
                }
                if (layout2.f2479a) {
                    View guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    SharedValues sharedValues2 = ConstraintLayout.p;
                    ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(-2, -2);
                    constraint2.b(layoutParams3);
                    constraintLayout.addView(guideline, layoutParams3);
                }
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt2 = constraintLayout.getChildAt(i3);
            if (childAt2 instanceof ConstraintHelper) {
                ((ConstraintHelper) childAt2).g(constraintLayout);
            }
        }
    }

    public final void f(ConstraintLayout constraintLayout) {
        int i2;
        HashMap map;
        HashMap map2;
        ConstraintSet constraintSet = this;
        int childCount = constraintLayout.getChildCount();
        HashMap map3 = constraintSet.f2458g;
        map3.clear();
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = constraintLayout.getChildAt(i3);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (constraintSet.f2457f && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!map3.containsKey(Integer.valueOf(id))) {
                map3.put(Integer.valueOf(id), new Constraint());
            }
            Constraint constraint = (Constraint) map3.get(Integer.valueOf(id));
            if (constraint == null) {
                i2 = childCount;
                map = map3;
            } else {
                HashMap map4 = constraintSet.f2456e;
                HashMap map5 = new HashMap();
                Class<?> cls = childAt.getClass();
                for (String str : map4.keySet()) {
                    ConstraintAttribute constraintAttribute = (ConstraintAttribute) map4.get(str);
                    int i4 = childCount;
                    try {
                        if (str.equals("BackgroundColor")) {
                            map2 = map3;
                            try {
                                map5.put(str, new ConstraintAttribute(constraintAttribute, Integer.valueOf(((ColorDrawable) childAt.getBackground()).getColor())));
                            } catch (IllegalAccessException e2) {
                                e = e2;
                                StringBuilder sbY = b.y(" Custom Attribute \"", str, "\" not found on ");
                                sbY.append(cls.getName());
                                Log.e("TransitionLayout", sbY.toString(), e);
                                childCount = i4;
                                map3 = map2;
                            } catch (NoSuchMethodException e3) {
                                e = e3;
                                Log.e("TransitionLayout", cls.getName() + " must have a method " + str, e);
                                childCount = i4;
                                map3 = map2;
                            } catch (InvocationTargetException e4) {
                                e = e4;
                                StringBuilder sbY2 = b.y(" Custom Attribute \"", str, "\" not found on ");
                                sbY2.append(cls.getName());
                                Log.e("TransitionLayout", sbY2.toString(), e);
                                childCount = i4;
                                map3 = map2;
                            }
                        } else {
                            map2 = map3;
                            map5.put(str, new ConstraintAttribute(constraintAttribute, cls.getMethod("getMap" + str, null).invoke(childAt, null)));
                        }
                    } catch (IllegalAccessException e5) {
                        e = e5;
                        map2 = map3;
                    } catch (NoSuchMethodException e6) {
                        e = e6;
                        map2 = map3;
                    } catch (InvocationTargetException e7) {
                        e = e7;
                        map2 = map3;
                    }
                    childCount = i4;
                    map3 = map2;
                }
                i2 = childCount;
                map = map3;
                constraint.f2465g = map5;
                constraint.d(id, layoutParams);
                int visibility = childAt.getVisibility();
                PropertySet propertySet = constraint.f2461c;
                propertySet.f2506b = visibility;
                propertySet.f2508d = childAt.getAlpha();
                float rotation = childAt.getRotation();
                Transform transform = constraint.f2464f;
                transform.f2511b = rotation;
                transform.f2512c = childAt.getRotationX();
                transform.f2513d = childAt.getRotationY();
                transform.f2514e = childAt.getScaleX();
                transform.f2515f = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    transform.f2516g = pivotX;
                    transform.f2517h = pivotY;
                }
                transform.f2519j = childAt.getTranslationX();
                transform.f2520k = childAt.getTranslationY();
                transform.f2521l = childAt.getTranslationZ();
                if (transform.f2522m) {
                    transform.n = childAt.getElevation();
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    boolean allowsGoneWidget = barrier.getAllowsGoneWidget();
                    Layout layout = constraint.f2463e;
                    layout.o0 = allowsGoneWidget;
                    layout.j0 = barrier.getReferencedIds();
                    layout.g0 = barrier.getType();
                    layout.h0 = barrier.getMargin();
                }
            }
            i3++;
            constraintSet = this;
            childCount = i2;
            map3 = map;
        }
    }

    public final Constraint i(int i2) {
        HashMap map = this.f2458g;
        if (!map.containsKey(Integer.valueOf(i2))) {
            map.put(Integer.valueOf(i2), new Constraint());
        }
        return (Constraint) map.get(Integer.valueOf(i2));
    }

    public final Constraint j(int i2) {
        HashMap map = this.f2458g;
        if (map.containsKey(Integer.valueOf(i2))) {
            return (Constraint) map.get(Integer.valueOf(i2));
        }
        return null;
    }

    public final void k(int i2, Context context) {
        XmlResourceParser xml = context.getResources().getXml(i2);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 2) {
                    String name = xml.getName();
                    Constraint constraintH = h(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        constraintH.f2463e.f2479a = true;
                    }
                    this.f2458g.put(Integer.valueOf(constraintH.f2459a), constraintH);
                }
            }
        } catch (IOException e2) {
            Log.e("ConstraintSet", "Error parsing resource: " + i2, e2);
        } catch (XmlPullParserException e3) {
            Log.e("ConstraintSet", "Error parsing resource: " + i2, e3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:123:0x01d2, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(android.content.Context r12, android.content.res.XmlResourceParser r13) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 564
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintSet.l(android.content.Context, android.content.res.XmlResourceParser):void");
    }
}
