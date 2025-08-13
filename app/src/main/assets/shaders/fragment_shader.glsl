precision mediump float;

varying vec4 vRandom;
varying vec3 vColor;

uniform float uTime;
uniform float uAlphaParticles;

void main() {
    vec2 uv = gl_PointCoord.xy;
    float d = length(uv - vec2(0.5));

    // discard برای حذف پیکسل‌های خارج از دایره
    if (d > 0.5) {
        discard;
    }

    // رنگ ثابت #4D1300 با opacity 35%
    vec3 base = vec3(77.0 / 255.0, 19.0 / 255.0, 0.0);
    float alpha = 0.35;

    // کمی نویز/تغییر رنگ شبیه نسخه وب (اختیاری)
    vec3 col = base + 0.2 * sin(uv.yxx + uTime + vRandom.y * 6.283185);

    gl_FragColor = vec4(col, alpha);
}