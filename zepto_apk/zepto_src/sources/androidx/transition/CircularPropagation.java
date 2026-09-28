package androidx.transition;

/* loaded from: classes3.dex */
public class CircularPropagation extends VisibilityPropagation {

    /* renamed from: b, reason: collision with root package name */
    public final float f12066b = 3.0f;

    /* JADX WARN: Removed duplicated region for block: B:17:0x0026  */
    @Override // androidx.transition.TransitionPropagation
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long a(android.view.ViewGroup r10, androidx.transition.Transition r11, androidx.transition.TransitionValues r12, androidx.transition.TransitionValues r13) {
        /*
            r9 = this;
            r0 = 0
            if (r12 != 0) goto L7
            if (r13 != 0) goto L7
            return r0
        L7:
            r2 = 1
            if (r13 == 0) goto L26
            if (r12 != 0) goto Ld
            goto L19
        Ld:
            java.util.HashMap r3 = r12.f12163a
            java.lang.String r4 = "android:visibilityPropagation:visibility"
            java.lang.Object r3 = r3.get(r4)
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 != 0) goto L1c
        L19:
            r3 = 8
            goto L20
        L1c:
            int r3 = r3.intValue()
        L20:
            if (r3 != 0) goto L23
            goto L26
        L23:
            r12 = r13
            r13 = r2
            goto L27
        L26:
            r13 = -1
        L27:
            r3 = 0
            int r4 = androidx.transition.VisibilityPropagation.b(r12, r3)
            int r12 = androidx.transition.VisibilityPropagation.b(r12, r2)
            androidx.transition.Transition$EpicenterCallback r5 = r11.w
            if (r5 != 0) goto L36
            r5 = 0
            goto L3a
        L36:
            android.graphics.Rect r5 = r5.a()
        L3a:
            if (r5 == 0) goto L45
            int r2 = r5.centerX()
            int r3 = r5.centerY()
            goto L72
        L45:
            r5 = 2
            int[] r6 = new int[r5]
            r10.getLocationOnScreen(r6)
            r3 = r6[r3]
            int r7 = r10.getWidth()
            int r7 = r7 / r5
            int r7 = r7 + r3
            float r3 = (float) r7
            float r7 = r10.getTranslationX()
            float r7 = r7 + r3
            int r3 = java.lang.Math.round(r7)
            r2 = r6[r2]
            int r6 = r10.getHeight()
            int r6 = r6 / r5
            int r6 = r6 + r2
            float r2 = (float) r6
            float r5 = r10.getTranslationY()
            float r5 = r5 + r2
            int r2 = java.lang.Math.round(r5)
            r8 = r3
            r3 = r2
            r2 = r8
        L72:
            float r4 = (float) r4
            float r12 = (float) r12
            float r2 = (float) r2
            float r3 = (float) r3
            float r2 = r2 - r4
            float r3 = r3 - r12
            float r2 = r2 * r2
            float r3 = r3 * r3
            float r3 = r3 + r2
            double r2 = (double) r3
            double r2 = java.lang.Math.sqrt(r2)
            float r12 = (float) r2
            int r2 = r10.getWidth()
            float r2 = (float) r2
            int r10 = r10.getHeight()
            float r10 = (float) r10
            r3 = 0
            float r2 = r2 - r3
            float r10 = r10 - r3
            float r2 = r2 * r2
            float r10 = r10 * r10
            float r10 = r10 + r2
            double r2 = (double) r10
            double r2 = java.lang.Math.sqrt(r2)
            float r10 = (float) r2
            float r12 = r12 / r10
            long r10 = r11.f12117c
            int r0 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r0 >= 0) goto La0
            r10 = 300(0x12c, double:1.48E-321)
        La0:
            long r0 = (long) r13
            long r10 = r10 * r0
            float r10 = (float) r10
            float r11 = r9.f12066b
            float r10 = r10 / r11
            float r10 = r10 * r12
            int r10 = java.lang.Math.round(r10)
            long r10 = (long) r10
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.CircularPropagation.a(android.view.ViewGroup, androidx.transition.Transition, androidx.transition.TransitionValues, androidx.transition.TransitionValues):long");
    }
}
