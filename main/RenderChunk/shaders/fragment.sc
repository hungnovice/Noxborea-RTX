/*
* Available Macros:
*
* Passes:
* - ALPHA_TEST_PASS
* - DEPTH_ONLY_PASS
* - DEPTH_ONLY_OPAQUE_PASS
* - OPAQUE_PASS
* - TRANSPARENT_PASS
*
* Dithering:
* - DITHERING__OFF
* - DITHERING__ON
*
* Instancing:
* - INSTANCING__OFF (not used)
* - INSTANCING__ON (not used)
*
* RenderAsBillboards:
* - RENDER_AS_BILLBOARDS__OFF (not used)
* - RENDER_AS_BILLBOARDS__ON (not used)
*
* Seasons:
* - SEASONS__OFF
* - SEASONS__ON
*/

precision mediump float;
precision highp int;
#ifdef ALPHA_TEST_PASS
uniform highp mat4 u_view;
#endif
uniform highp vec4 FogColor;
SAMPLER2D_HIGHP_AUTOREG(s_LightMapTexture);
#ifndef DEPTH_ONLY_OPAQUE_PASS
SAMPLER2D_HIGHP_AUTOREG(s_MatTexture);
#endif
// Approximation, matches 58 cases out of 60
#if defined(OPAQUE_PASS) && defined(SEASONS__ON)
SAMPLER2D_HIGHP_AUTOREG(s_SeasonsTexture);
#endif
#if defined(ALPHA_TEST_PASS) && defined(DITHERING__ON)
uniform highp vec4 DitherParams;
uniform highp vec4 DitherParams2;
#endif
#if defined(ALPHA_TEST_PASS) && defined(DITHERING__ON) && defined(SEASONS__ON)
SAMPLER2D_HIGHP_AUTOREG(s_SeasonsTexture);
#endif
#ifdef ALPHA_TEST_PASS
uniform highp vec4 ViewPositionAndTime;
#endif
#if defined(ALPHA_TEST_PASS) && defined(DITHERING__ON)
in highp vec4 v_clipPosition;
#endif
#if !defined(DEPTH_ONLY_OPAQUE_PASS) && !defined(DEPTH_ONLY_PASS)
in highp vec4 v_color0;
#endif
#ifdef ALPHA_TEST_PASS
in highp vec2 v_ditheringAndMaskTinting;
#endif
in highp vec4 v_fog;
in highp vec2 v_lightmapUV;
#ifndef DEPTH_ONLY_OPAQUE_PASS
centroid in highp vec2 v_texcoord0;
#endif
#if defined(ALPHA_TEST_PASS) && defined(DITHERING__ON)
in highp vec4 v_worldPosition;
#endif
layout(location = 0) out highp vec4 gl_FragColor;
void main() {
#ifdef ALPHA_TEST_PASS
    highp mat4 View = u_view;
#endif
#if defined(ALPHA_TEST_PASS) && defined(DITHERING__OFF) && defined(SEASONS__OFF)
    highp vec2 _1103 = v_ditheringAndMaskTinting;
    highp vec4 _731 = texture(s_MatTexture, v_texcoord0);
    highp vec2 _1000 = vec2(0.0);
    bool _1186;
    if (_1103.x > 0.5)
#endif
#if defined(ALPHA_TEST_PASS) && defined(DITHERING__OFF) && defined(SEASONS__ON)
    highp vec4 _1254 = v_color0;
    highp vec2 _1179 = v_ditheringAndMaskTinting;
    highp vec4 _768 = texture(s_MatTexture, v_texcoord0);
    highp vec2 _1076 = vec2(0.0);
    bool _1264;
    if (_1179.x > 0.5)
#endif
#if defined(ALPHA_TEST_PASS) && defined(DITHERING__ON) && defined(SEASONS__OFF)
    highp vec2 _1157 = v_ditheringAndMaskTinting;
    highp vec4 _750 = texture(s_MatTexture, v_texcoord0);
    highp vec4 _1051 = v_clipPosition;
    highp vec2 _1054 = vec2(DitherParams.z, DitherParams.w);
    bool _1244;
    if (_1157.x > 0.5)
#endif
#if defined(ALPHA_TEST_PASS) && defined(DITHERING__ON) && defined(SEASONS__ON)
    highp vec4 _1312 = v_color0;
    highp vec2 _1233 = v_ditheringAndMaskTinting;
    highp vec4 _787 = texture(s_MatTexture, v_texcoord0);
    highp vec4 _1127 = v_clipPosition;
    highp vec2 _1130 = vec2(DitherParams.z, DitherParams.w);
    bool _1322;
    if (_1233.x > 0.5)
#endif
#ifdef DEPTH_ONLY_PASS
    highp vec4 _499 = texture(s_MatTexture, v_texcoord0);
    if (_499.w < 0.5)
#endif
#if defined(ALPHA_TEST_PASS) || defined(DEPTH_ONLY_PASS)
    {
#endif
#if defined(ALPHA_TEST_PASS) && defined(DITHERING__OFF) && defined(SEASONS__OFF)
        highp vec2 _902 = floor(vec2(0.0));
        highp vec2 _876 = _902;
        highp vec2 _916 = floor(vec2(0.0));
        highp vec2 _877 = _916;
        highp vec2 _930 = floor(vec2(0.0));
        highp vec2 _878 = _930;
        _1186 = smoothstep(_1000.x, _1000.y, dot(-normalize(vec3(View[0].z, View[1].z, View[2].z)), -ViewPositionAndTime.xyz)) <= (((((((fract((_876.x * 0.5) + ((_876.y * _876.y) * 0.75)) * 0.25) + fract((_877.x * 0.5) + ((_877.y * _877.y) * 0.75))) * 0.25) + fract((_878.x * 0.5) + ((_878.y * _878.y) * 0.75))) * 64.0) + 0.5) * 0.015625);
#endif
#if defined(ALPHA_TEST_PASS) && defined(DITHERING__OFF) && defined(SEASONS__ON)
        highp vec2 _941 = floor(vec2(0.0));
        highp vec2 _915 = _941;
        highp vec2 _955 = floor(vec2(0.0));
        highp vec2 _916 = _955;
        highp vec2 _969 = floor(vec2(0.0));
        highp vec2 _917 = _969;
        _1264 = smoothstep(_1076.x, _1076.y, dot(-normalize(vec3(View[0].z, View[1].z, View[2].z)), -ViewPositionAndTime.xyz)) <= (((((((fract((_915.x * 0.5) + ((_915.y * _915.y) * 0.75)) * 0.25) + fract((_916.x * 0.5) + ((_916.y * _916.y) * 0.75))) * 0.25) + fract((_917.x * 0.5) + ((_917.y * _917.y) * 0.75))) * 64.0) + 0.5) * 0.015625);
#endif
#if defined(ALPHA_TEST_PASS) && defined(DITHERING__ON) && defined(SEASONS__OFF)
        highp vec2 _904 = floor(((((v_clipPosition.xyz / vec3(_1051.w)).xy * 0.5) + vec2(0.5)) * DitherParams.xy) / vec2(DitherParams2.x)) * DitherParams2.x;
        highp vec2 _914 = floor(_904 * 0.25);
        highp vec2 _915 = floor(_904 * 0.5);
        highp vec2 _916 = floor(_904);
        _1244 = smoothstep(_1054.x, _1054.y, dot(-normalize(vec3(View[0].z, View[1].z, View[2].z)), v_worldPosition.xyz - ViewPositionAndTime.xyz)) <= (((((((fract((_914.x * 0.5) + ((_914.y * _914.y) * 0.75)) * 0.25) + fract((_915.x * 0.5) + ((_915.y * _915.y) * 0.75))) * 0.25) + fract((_916.x * 0.5) + ((_916.y * _916.y) * 0.75))) * 64.0) + 0.5) * 0.015625);
#endif
#if defined(ALPHA_TEST_PASS) && defined(DITHERING__ON) && defined(SEASONS__ON)
        highp vec2 _943 = floor(((((v_clipPosition.xyz / vec3(_1127.w)).xy * 0.5) + vec2(0.5)) * DitherParams.xy) / vec2(DitherParams2.x)) * DitherParams2.x;
        highp vec2 _953 = floor(_943 * 0.25);
        highp vec2 _954 = floor(_943 * 0.5);
        highp vec2 _955 = floor(_943);
        _1322 = smoothstep(_1130.x, _1130.y, dot(-normalize(vec3(View[0].z, View[1].z, View[2].z)), v_worldPosition.xyz - ViewPositionAndTime.xyz)) <= (((((((fract((_953.x * 0.5) + ((_953.y * _953.y) * 0.75)) * 0.25) + fract((_954.x * 0.5) + ((_954.y * _954.y) * 0.75))) * 0.25) + fract((_955.x * 0.5) + ((_955.y * _955.y) * 0.75))) * 64.0) + 0.5) * 0.015625);
#endif
#ifdef ALPHA_TEST_PASS
    }
    else
    {
#endif
#if defined(ALPHA_TEST_PASS) && defined(DITHERING__OFF) && defined(SEASONS__OFF)
        _1186 = false;
#endif
#if defined(ALPHA_TEST_PASS) && defined(DITHERING__OFF) && defined(SEASONS__ON)
        _1264 = false;
#endif
#if defined(ALPHA_TEST_PASS) && defined(DITHERING__ON) && defined(SEASONS__OFF)
        _1244 = false;
#endif
#if defined(ALPHA_TEST_PASS) && defined(DITHERING__ON) && defined(SEASONS__ON)
        _1322 = false;
#endif
#ifdef ALPHA_TEST_PASS
    }
#endif
#if defined(ALPHA_TEST_PASS) && defined(DITHERING__OFF) && defined(SEASONS__OFF)
    if (_1186 || (_731.w < 0.5))
#endif
#if defined(ALPHA_TEST_PASS) && defined(DITHERING__OFF) && defined(SEASONS__ON)
    if (_1264 || (_768.w < 0.5))
#endif
#if defined(ALPHA_TEST_PASS) && defined(DITHERING__ON) && defined(SEASONS__OFF)
    if (_1244 || (_750.w < 0.5))
#endif
#if defined(ALPHA_TEST_PASS) && defined(DITHERING__ON) && defined(SEASONS__ON)
    if (_1322 || (_787.w < 0.5))
#endif
#ifdef ALPHA_TEST_PASS
    {
#endif
#if defined(ALPHA_TEST_PASS) || defined(DEPTH_ONLY_PASS)
        discard;
    }
#endif
#if defined(ALPHA_TEST_PASS) && defined(DITHERING__OFF) && defined(SEASONS__OFF)
    highp vec4 _754 = _731;
    highp vec3 _756 = _754.xyz * v_color0.xyz;
    _731 = vec4(_756.x, _756.y, _756.z, _754.w);
    highp vec4 _963 = vec4(texture(s_LightMapTexture, v_lightmapUV).xyz * _756.xyz, _731.w);
    highp vec4 _1148 = v_fog;
    highp vec3 _983 = mix(_963.xyz, FogColor.xyz, vec3(_1148.w));
    gl_FragColor = vec4(_983.x, _983.y, _983.z, _963.w);
#endif
#if defined(ALPHA_TEST_PASS) && defined(DITHERING__OFF) && defined(SEASONS__ON)
    highp vec3 _775 = v_color0.xyz;
    highp vec3 _1004 = (_768.xyz * mix(vec3(1.0), texture(s_SeasonsTexture, v_color0.xy).xyz * 2.0, vec3(_775.z))).xyz * vec3(_1254.w);
    highp vec4 _777 = vec4(_1004.x, _1004.y, _1004.z, _768.w);
    _777.w = 1.0;
    _768 = _777;
    highp vec4 _1039 = vec4(texture(s_LightMapTexture, v_lightmapUV).xyz * _777.xyz, _768.w);
    highp vec4 _1226 = v_fog;
    highp vec3 _1059 = mix(_1039.xyz, FogColor.xyz, vec3(_1226.w));
    gl_FragColor = vec4(_1059.x, _1059.y, _1059.z, _1039.w);
#endif
#if defined(ALPHA_TEST_PASS) && defined(DITHERING__ON) && defined(SEASONS__OFF)
    highp vec4 _792 = _750;
    highp vec3 _794 = _792.xyz * v_color0.xyz;
    _750 = vec4(_794.x, _794.y, _794.z, _792.w);
    highp vec4 _1001 = vec4(texture(s_LightMapTexture, v_lightmapUV).xyz * _794.xyz, _750.w);
    highp vec4 _1206 = v_fog;
    highp vec3 _1021 = mix(_1001.xyz, FogColor.xyz, vec3(_1206.w));
    gl_FragColor = vec4(_1021.x, _1021.y, _1021.z, _1001.w);
#endif
#if defined(ALPHA_TEST_PASS) && defined(DITHERING__ON) && defined(SEASONS__ON)
    highp vec3 _794 = v_color0.xyz;
    highp vec3 _1042 = (_787.xyz * mix(vec3(1.0), texture(s_SeasonsTexture, v_color0.xy).xyz * 2.0, vec3(_794.z))).xyz * vec3(_1312.w);
    highp vec4 _796 = vec4(_1042.x, _1042.y, _1042.z, _787.w);
    _796.w = 1.0;
    _787 = _796;
    highp vec4 _1077 = vec4(texture(s_LightMapTexture, v_lightmapUV).xyz * _796.xyz, _787.w);
    highp vec4 _1284 = v_fog;
    highp vec3 _1097 = mix(_1077.xyz, FogColor.xyz, vec3(_1284.w));
    gl_FragColor = vec4(_1097.x, _1097.y, _1097.z, _1077.w);
#endif
#ifdef DEPTH_ONLY_PASS
    highp vec4 _535 = vec4(texture(s_LightMapTexture, v_lightmapUV).xyz, 1.0);
    highp vec4 _647 = v_fog;
    highp vec3 _555 = mix(_535.xyz, FogColor.xyz, vec3(_647.w));
    gl_FragColor = vec4(_555.x, _555.y, _555.z, _535.w);
#endif
#ifdef DEPTH_ONLY_OPAQUE_PASS
    highp vec4 _507 = vec4(texture(s_LightMapTexture, v_lightmapUV).xyz, 1.0);
    highp vec4 _609 = v_fog;
    highp vec3 _527 = mix(_507.xyz, FogColor.xyz, vec3(_609.w));
    gl_FragColor = vec4(_527.x, _527.y, _527.z, _507.w);
#endif
#if defined(OPAQUE_PASS) && defined(SEASONS__OFF)
    highp vec4 _719 = v_color0;
    highp vec4 _537 = texture(s_MatTexture, v_texcoord0);
    highp vec3 _519 = _537.xyz * v_color0.xyz;
    highp vec4 _510 = vec4(_519.x, _519.y, _519.z, _537.w);
    _510.w = _719.w;
    highp vec4 _559 = vec4(texture(s_LightMapTexture, v_lightmapUV).xyz * _510.xyz, _510.w);
    highp vec4 _695 = v_fog;
    highp vec3 _579 = mix(_559.xyz, FogColor.xyz, vec3(_695.w));
    gl_FragColor = vec4(_579.x, _579.y, _579.z, _559.w);
#endif
#if defined(OPAQUE_PASS) && defined(SEASONS__ON)
    highp vec4 _801 = v_color0;
    highp vec4 _582 = texture(s_MatTexture, v_texcoord0);
    highp vec3 _558 = v_color0.xyz;
    highp vec3 _606 = (_582.xyz * mix(vec3(1.0), texture(s_SeasonsTexture, v_color0.xy).xyz * 2.0, vec3(_558.z))).xyz * vec3(_801.w);
    highp vec4 _560 = vec4(_606.x, _606.y, _606.z, _582.w);
    _560.w = 1.0;
    highp vec4 _556 = _560;
    highp vec4 _641 = vec4(texture(s_LightMapTexture, v_lightmapUV).xyz * _560.xyz, _556.w);
    highp vec4 _777 = v_fog;
    highp vec3 _661 = mix(_641.xyz, FogColor.xyz, vec3(_777.w));
    gl_FragColor = vec4(_661.x, _661.y, _661.z, _641.w);
#endif
#ifdef TRANSPARENT_PASS
    highp vec4 _725 = v_color0;
    highp vec4 _513 = texture(s_MatTexture, v_texcoord0);
    _513.w *= _725.w;
    highp vec4 _526 = _513;
    highp vec3 _528 = _526.xyz * v_color0.xyz;
    _513 = vec4(_528.x, _528.y, _528.z, _526.w);
    highp vec4 _565 = vec4(texture(s_LightMapTexture, v_lightmapUV).xyz * _528.xyz, _513.w);
    highp vec4 _701 = v_fog;
    highp vec3 _585 = mix(_565.xyz, FogColor.xyz, vec3(_701.w));
    gl_FragColor = vec4(_585.x, _585.y, _585.z, _565.w);
#endif
}
