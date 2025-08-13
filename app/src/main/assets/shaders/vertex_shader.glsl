precision mediump float;

attribute vec3 aPosition;
attribute vec4 aRandom;
attribute vec3 aColor;

uniform mat4 uMVPMatrix;
uniform float uTime;
uniform float uSpread;
uniform float uBaseSize;
uniform float uSizeRandomness;

varying vec4 vRandom;
varying vec3 vColor;

void main() {
    vRandom = aRandom;
    vColor = aColor;

    vec3 pos = aPosition * uSpread;
    pos.z *= 10.0;

    float t = uTime;
    pos.x += sin(t * aRandom.z + 6.283185 * aRandom.w) * mix(0.1, 1.5, aRandom.x);
    pos.y += sin(t * aRandom.y + 6.283185 * aRandom.x) * mix(0.1, 1.5, aRandom.w);
    pos.z += sin(t * aRandom.w + 6.283185 * aRandom.y) * mix(0.1, 1.5, aRandom.z);

    gl_Position = uMVPMatrix * vec4(pos, 1.0);

    float size = uBaseSize * (1.0 + uSizeRandomness * (aRandom.x - 0.5));
    size = clamp(size, 1.0, 25.0);  // تغییر از 8 به 15 برای بزرگ‌تر شدن دایره‌ها
    gl_PointSize = size;
}