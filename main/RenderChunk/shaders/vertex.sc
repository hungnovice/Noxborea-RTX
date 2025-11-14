/*
* Available Macros:
*
* Passes:
* - ALPHA_TEST_PASS
* - DEPTH_ONLY_PASS (not used)
* - DEPTH_ONLY_OPAQUE_PASS (not used)
* - OPAQUE_PASS (not used)
* - TRANSPARENT_PASS
*
* Dithering:
* - DITHERING__OFF (not used)
* - DITHERING__ON (not used)
*
* Instancing:
* - INSTANCING__OFF
* - INSTANCING__ON
*
* RenderAsBillboards:
* - RENDER_AS_BILLBOARDS__OFF
* - RENDER_AS_BILLBOARDS__ON
*
* Seasons:
* - SEASONS__OFF (not used)
* - SEASONS__ON (not used)
*/

#ifdef TRANSPARENT_PASS
uniform vec4 MeshContext;
uniform vec4 FogAndDistanceControl;
#endif
uniform vec4 ViewPositionAndTime;
uniform vec4 RenderChunkFogAlpha;
uniform vec4 FogColor;
uniform vec4 SubPixelOffset;
#ifndef TRANSPARENT_PASS
uniform vec4 MeshContext;
uniform vec4 FogAndDistanceControl;
#endif
in vec4 a_color0;
in vec2 a_texcoord1;
in vec3 a_position;
in vec2 a_texcoord0;
#ifdef INSTANCING__ON
in vec4 i_data1;
in vec4 i_data2;
in vec4 i_data3;
#endif
centroid out vec2 v_texcoord0;

#include "include.h"

void main() {
#if defined(ALPHA_TEST_PASS) && defined(INSTANCING__OFF) && defined(RENDER_AS_BILLBOARDS__OFF)
    vec4 _575 = u_model[0] * vec4(a_position, 1.0);
    vec3 _576 = _575.xyz;
    vec4 _615 = mix(FogAndDistanceControl, vec4(0.9900000095367431640625, 1.0, 100000.0, 100000.0), bvec4(MeshContext.x > 0.5));
    mat4 _679 = u_proj;
    _679[2].x += SubPixelOffset.x;
    _679[2].y -= SubPixelOffset.y;
    vec4 _702 = _679 * (u_view * vec4(_575.xyz, 1.0));
    vec2 _754 = a_texcoord1;
    uint _721 = uint(floor(_754.x * 255.0));
    uint _731 = uint(floor(_754.y * 255.0));
    v_clipPosition = _702;
#endif
#if defined(ALPHA_TEST_PASS) && defined(INSTANCING__ON) && defined(RENDER_AS_BILLBOARDS__OFF)
    vec4 _944 = i_data1;
    vec4 _945 = i_data2;
    vec4 _946 = i_data3;
#endif
#if defined(INSTANCING__ON) && defined(RENDER_AS_BILLBOARDS__OFF) && defined(TRANSPARENT_PASS)
    vec4 _948 = i_data1;
    vec4 _949 = i_data2;
    vec4 _950 = i_data3;
#endif
// Approximation, matches 56 cases out of 60
#if defined(ALPHA_TEST_PASS) && defined(INSTANCING__ON) && defined(RENDER_AS_BILLBOARDS__OFF)
    mat4 _620;
#endif
#if defined(ALPHA_TEST_PASS) && defined(INSTANCING__ON) && defined(RENDER_AS_BILLBOARDS__OFF)
    _620[0] = vec4(_944.x, _945.x, _946.x, 0.0);
    _620[1] = vec4(_944.y, _945.y, _946.y, 0.0);
    _620[2] = vec4(_944.z, _945.z, _946.z, 0.0);
    _620[3] = vec4(_944.w, _945.w, _946.w, 1.0);
#endif
#if defined(INSTANCING__ON) && defined(RENDER_AS_BILLBOARDS__OFF) && defined(TRANSPARENT_PASS)
    _620[0] = vec4(_948.x, _949.x, _950.x, 0.0);
    _620[1] = vec4(_948.y, _949.y, _950.y, 0.0);
    _620[2] = vec4(_948.z, _949.z, _950.z, 0.0);
    _620[3] = vec4(_948.w, _949.w, _950.w, 1.0);
#endif
// Approximation, matches 56 cases out of 60
#if defined(ALPHA_TEST_PASS) && defined(INSTANCING__ON) && defined(RENDER_AS_BILLBOARDS__OFF)
    vec4 _682 = _620 * vec4(a_position, 1.0);
    vec3 _666 = _682.xyz;
#endif
#if defined(ALPHA_TEST_PASS) && defined(INSTANCING__ON) && defined(RENDER_AS_BILLBOARDS__OFF)
    vec4 _709 = mix(FogAndDistanceControl, vec4(0.9900000095367431640625, 1.0, 100000.0, 100000.0), bvec4(MeshContext.x > 0.5));
    mat4 _773 = u_proj;
    _773[2].x += SubPixelOffset.x;
    _773[2].y -= SubPixelOffset.y;
    vec4 _796 = _773 * (u_view * vec4(_682.xyz, 1.0));
    vec2 _848 = a_texcoord1;
    uint _815 = uint(floor(_848.x * 255.0));
    uint _825 = uint(floor(_848.y * 255.0));
    v_clipPosition = _796;
#endif
// Approximation, matches 56 cases out of 60
#if defined(INSTANCING__OFF) && defined(RENDER_AS_BILLBOARDS__OFF) && !defined(ALPHA_TEST_PASS)
    vec4 _541 = u_model[0] * vec4(a_position, 1.0);
    vec3 _542 = _541.xyz;
    vec4 _562 = mix(FogAndDistanceControl, vec4(0.9900000095367431640625, 1.0, 100000.0, 100000.0), bvec4(MeshContext.x > 0.5));
    mat4 _626 = u_proj;
    _626[2].x += SubPixelOffset.x;
    _626[2].y -= SubPixelOffset.y;
    vec2 _701 = a_texcoord1;
    uint _668 = uint(floor(_701.x * 255.0));
    uint _678 = uint(floor(_701.y * 255.0));
#endif
// Approximation, matches 56 cases out of 60
#if defined(INSTANCING__ON) && defined(RENDER_AS_BILLBOARDS__OFF) && !defined(ALPHA_TEST_PASS)
    vec4 _849 = i_data1;
    vec4 _850 = i_data2;
    vec4 _851 = i_data3;
    mat4 _586;
    _586[0] = vec4(_849.x, _850.x, _851.x, 0.0);
    _586[1] = vec4(_849.y, _850.y, _851.y, 0.0);
    _586[2] = vec4(_849.z, _850.z, _851.z, 0.0);
    _586[3] = vec4(_849.w, _850.w, _851.w, 1.0);
    vec4 _648 = _586 * vec4(a_position, 1.0);
    vec3 _632 = _648.xyz;
    vec4 _656 = mix(FogAndDistanceControl, vec4(0.9900000095367431640625, 1.0, 100000.0, 100000.0), bvec4(MeshContext.x > 0.5));
    mat4 _720 = u_proj;
    _720[2].x += SubPixelOffset.x;
    _720[2].y -= SubPixelOffset.y;
    vec2 _795 = a_texcoord1;
    uint _762 = uint(floor(_795.x * 255.0));
    uint _772 = uint(floor(_795.y * 255.0));
#endif
#if defined(RENDER_AS_BILLBOARDS__OFF) && !defined(TRANSPARENT_PASS)
    v_color0 = a_color0;
#endif
#if defined(ALPHA_TEST_PASS) && defined(INSTANCING__OFF) && defined(RENDER_AS_BILLBOARDS__OFF)
    v_ditheringAndMaskTinting = vec2(float(_731 & 1u), float(_731 & 2u));
    v_fog = vec4(FogColor.xyz, clamp((((length(ViewPositionAndTime.xyz - _576) / _615.z) + RenderChunkFogAlpha.x) - _615.x) / (_615.y - _615.x), 0.0, 1.0));
    v_lightmapUV = vec2(clamp(float(_721 & 15u) * 0.0625, 0.0, 1.0), clamp(float((_721 & 240u) >> uint(4)) * 0.0625, 0.0, 1.0));
#endif
#if defined(ALPHA_TEST_PASS) && defined(INSTANCING__OFF) && defined(RENDER_AS_BILLBOARDS__ON)
    vec4 _637 = u_model[0] * vec4(a_position, 1.0);
    vec3 _638 = _637.xyz;
    vec3 _730 = _638 + vec3(0.5);
    vec3 _737 = normalize(_730 - ViewPositionAndTime.xyz);
    vec3 _740 = normalize(cross(vec3(0.0, 1.0, 0.0), _737));
    vec3 _727 = a_color0.xyz;
    vec3 _760 = _730 - ((cross(_737, _740) * (_727.z - 0.5)) + (_740 * (_727.x - 0.5))); // Attention!
    vec4 _679 = mix(FogAndDistanceControl, vec4(0.9900000095367431640625, 1.0, 100000.0, 100000.0), bvec4(MeshContext.x > 0.5));
    mat4 _796 = u_proj;
    _796[2].x += SubPixelOffset.x;
    _796[2].y -= SubPixelOffset.y;
    vec4 _819 = _796 * (u_view * vec4(_760, 1.0));
    vec2 _871 = a_texcoord1;
    uint _838 = uint(floor(_871.x * 255.0));
    uint _848 = uint(floor(_871.y * 255.0));
    v_clipPosition = _819;
#endif
#if defined(ALPHA_TEST_PASS) && defined(INSTANCING__ON) && defined(RENDER_AS_BILLBOARDS__ON)
    vec4 _1116 = i_data1;
    vec4 _1117 = i_data2;
    vec4 _1118 = i_data3;
#endif
#if defined(INSTANCING__ON) && defined(RENDER_AS_BILLBOARDS__ON) && defined(TRANSPARENT_PASS)
    vec4 _1110 = i_data1;
    vec4 _1111 = i_data2;
    vec4 _1112 = i_data3;
#endif
// Approximation, matches 58 cases out of 60
#if defined(ALPHA_TEST_PASS) && defined(INSTANCING__ON) && defined(RENDER_AS_BILLBOARDS__ON)
    mat4 _682;
#endif
#if defined(ALPHA_TEST_PASS) && defined(INSTANCING__ON) && defined(RENDER_AS_BILLBOARDS__ON)
    _682[0] = vec4(_1116.x, _1117.x, _1118.x, 0.0);
    _682[1] = vec4(_1116.y, _1117.y, _1118.y, 0.0);
    _682[2] = vec4(_1116.z, _1117.z, _1118.z, 0.0);
    _682[3] = vec4(_1116.w, _1117.w, _1118.w, 1.0);
    vec4 _744 = _682 * vec4(a_position, 1.0);
    vec3 _728 = _744.xyz;
    vec3 _824 = _728 + vec3(0.5);
    vec3 _831 = normalize(_824 - ViewPositionAndTime.xyz);
    vec3 _834 = normalize(cross(vec3(0.0, 1.0, 0.0), _831));
    vec3 _821 = a_color0.xyz;
    vec3 _854 = _824 - ((cross(_831, _834) * (_821.z - 0.5)) + (_834 * (_821.x - 0.5))); // Attention!
    vec4 _773 = mix(FogAndDistanceControl, vec4(0.9900000095367431640625, 1.0, 100000.0, 100000.0), bvec4(MeshContext.x > 0.5));
    mat4 _890 = u_proj;
    _890[2].x += SubPixelOffset.x;
    _890[2].y -= SubPixelOffset.y;
    vec4 _913 = _890 * (u_view * vec4(_854, 1.0));
    vec2 _965 = a_texcoord1;
    uint _932 = uint(floor(_965.x * 255.0));
    uint _942 = uint(floor(_965.y * 255.0));
    v_clipPosition = _913;
#endif
// Approximation, matches 58 cases out of 60
#if defined(INSTANCING__OFF) && defined(RENDER_AS_BILLBOARDS__ON) && !defined(ALPHA_TEST_PASS)
    vec3 _604 = (u_model[0] * vec4(a_position, 1.0)).xyz;
    vec3 _677 = _604 + vec3(0.5);
    vec3 _684 = normalize(_677 - ViewPositionAndTime.xyz);
    vec3 _687 = normalize(cross(vec3(0.0, 1.0, 0.0), _684));
    vec3 _674 = a_color0.xyz;
    vec3 _707 = _677 - ((cross(_684, _687) * (_674.z - 0.5)) + (_687 * (_674.x - 0.5))); // Attention!
#endif
#if defined(INSTANCING__OFF) && defined(RENDER_AS_BILLBOARDS__OFF) && defined(TRANSPARENT_PASS)
    vec4 _576 = u_model[0] * vec4(a_position, 1.0);
    vec3 _577 = _576.xyz;
    vec4 _956 = a_color0;
    float _640 = length(ViewPositionAndTime.xyz - _577);
#endif
// Approximation, matches 56 cases out of 60
#if defined(INSTANCING__OFF) && (defined(RENDER_AS_BILLBOARDS__ON) || defined(TRANSPARENT_PASS))
    vec4 _626 = mix(FogAndDistanceControl, vec4(0.9900000095367431640625, 1.0, 100000.0, 100000.0), bvec4(MeshContext.x > 0.5));
#endif
// Approximation, matches 58 cases out of 60
#if defined(INSTANCING__OFF) && defined(RENDER_AS_BILLBOARDS__ON) && !defined(ALPHA_TEST_PASS)
    mat4 _743 = u_proj;
    _743[2].x += SubPixelOffset.x;
    _743[2].y -= SubPixelOffset.y;
    vec2 _818 = a_texcoord1;
    uint _785 = uint(floor(_818.x * 255.0));
    uint _795 = uint(floor(_818.y * 255.0));
#endif
// Approximation, matches 58 cases out of 60
#if defined(INSTANCING__ON) && defined(RENDER_AS_BILLBOARDS__ON) && !defined(ALPHA_TEST_PASS)
    vec4 _1011 = i_data1;
    vec4 _1012 = i_data2;
    vec4 _1013 = i_data3;
    mat4 _648;
    _648[0] = vec4(_1011.x, _1012.x, _1013.x, 0.0);
    _648[1] = vec4(_1011.y, _1012.y, _1013.y, 0.0);
    _648[2] = vec4(_1011.z, _1012.z, _1013.z, 0.0);
    _648[3] = vec4(_1011.w, _1012.w, _1013.w, 1.0);
    vec3 _694 = (_648 * vec4(a_position, 1.0)).xyz;
    vec3 _771 = _694 + vec3(0.5);
    vec3 _778 = normalize(_771 - ViewPositionAndTime.xyz);
    vec3 _781 = normalize(cross(vec3(0.0, 1.0, 0.0), _778));
    vec3 _768 = a_color0.xyz;
    vec3 _801 = _771 - ((cross(_778, _781) * (_768.z - 0.5)) + (_781 * (_768.x - 0.5))); // Attention!
    vec4 _720 = mix(FogAndDistanceControl, vec4(0.9900000095367431640625, 1.0, 100000.0, 100000.0), bvec4(MeshContext.x > 0.5));
    mat4 _837 = u_proj;
    _837[2].x += SubPixelOffset.x;
    _837[2].y -= SubPixelOffset.y;
    vec2 _912 = a_texcoord1;
    uint _879 = uint(floor(_912.x * 255.0));
    uint _889 = uint(floor(_912.y * 255.0));
#endif
#if defined(RENDER_AS_BILLBOARDS__ON) && !defined(TRANSPARENT_PASS)
    v_color0 = vec4(1.0);
#endif
#if defined(ALPHA_TEST_PASS) && defined(INSTANCING__OFF) && defined(RENDER_AS_BILLBOARDS__ON)
    v_ditheringAndMaskTinting = vec2(float(_848 & 1u), float(_848 & 2u));
    v_fog = vec4(FogColor.xyz, clamp((((length(ViewPositionAndTime.xyz - _760) / _679.z) + RenderChunkFogAlpha.x) - _679.x) / (_679.y - _679.x), 0.0, 1.0));
    v_lightmapUV = vec2(clamp(float(_838 & 15u) * 0.0625, 0.0, 1.0), clamp(float((_838 & 240u) >> uint(4)) * 0.0625, 0.0, 1.0));
#endif
#if defined(ALPHA_TEST_PASS) && defined(INSTANCING__ON) && defined(RENDER_AS_BILLBOARDS__OFF)
    v_ditheringAndMaskTinting = vec2(float(_825 & 1u), float(_825 & 2u));
    v_fog = vec4(FogColor.xyz, clamp((((length(ViewPositionAndTime.xyz - _666) / _709.z) + RenderChunkFogAlpha.x) - _709.x) / (_709.y - _709.x), 0.0, 1.0));
    v_lightmapUV = vec2(clamp(float(_815 & 15u) * 0.0625, 0.0, 1.0), clamp(float((_815 & 240u) >> uint(4)) * 0.0625, 0.0, 1.0));
#endif
#if defined(ALPHA_TEST_PASS) && defined(INSTANCING__ON) && defined(RENDER_AS_BILLBOARDS__ON)
    v_ditheringAndMaskTinting = vec2(float(_942 & 1u), float(_942 & 2u));
    v_fog = vec4(FogColor.xyz, clamp((((length(ViewPositionAndTime.xyz - _854) / _773.z) + RenderChunkFogAlpha.x) - _773.x) / (_773.y - _773.x), 0.0, 1.0));
    v_lightmapUV = vec2(clamp(float(_932 & 15u) * 0.0625, 0.0, 1.0), clamp(float((_932 & 240u) >> uint(4)) * 0.0625, 0.0, 1.0));
#endif
// Approximation, matches 56 cases out of 60
#if defined(INSTANCING__OFF) && defined(RENDER_AS_BILLBOARDS__OFF) && !defined(ALPHA_TEST_PASS)
    v_ditheringAndMaskTinting = vec2(float(_678 & 1u), float(_678 & 2u));
    v_fog = vec4(FogColor.xyz, clamp((((length(ViewPositionAndTime.xyz - _542) / _562.z) + RenderChunkFogAlpha.x) - _562.x) / (_562.y - _562.x), 0.0, 1.0));
    v_lightmapUV = vec2(clamp(float(_668 & 15u) * 0.0625, 0.0, 1.0), clamp(float((_668 & 240u) >> uint(4)) * 0.0625, 0.0, 1.0));
#endif
// Approximation, matches 58 cases out of 60
#if defined(INSTANCING__OFF) && defined(RENDER_AS_BILLBOARDS__ON) && !defined(ALPHA_TEST_PASS)
    v_ditheringAndMaskTinting = vec2(float(_795 & 1u), float(_795 & 2u));
    v_fog = vec4(FogColor.xyz, clamp((((length(ViewPositionAndTime.xyz - _707) / _626.z) + RenderChunkFogAlpha.x) - _626.x) / (_626.y - _626.x), 0.0, 1.0));
    v_lightmapUV = vec2(clamp(float(_785 & 15u) * 0.0625, 0.0, 1.0), clamp(float((_785 & 240u) >> uint(4)) * 0.0625, 0.0, 1.0));
#endif
// Approximation, matches 56 cases out of 60
#if defined(INSTANCING__ON) && defined(RENDER_AS_BILLBOARDS__OFF) && !defined(ALPHA_TEST_PASS)
    v_ditheringAndMaskTinting = vec2(float(_772 & 1u), float(_772 & 2u));
    v_fog = vec4(FogColor.xyz, clamp((((length(ViewPositionAndTime.xyz - _632) / _656.z) + RenderChunkFogAlpha.x) - _656.x) / (_656.y - _656.x), 0.0, 1.0));
    v_lightmapUV = vec2(clamp(float(_762 & 15u) * 0.0625, 0.0, 1.0), clamp(float((_762 & 240u) >> uint(4)) * 0.0625, 0.0, 1.0));
#endif
// Approximation, matches 58 cases out of 60
#if defined(INSTANCING__ON) && defined(RENDER_AS_BILLBOARDS__ON) && !defined(ALPHA_TEST_PASS)
    v_ditheringAndMaskTinting = vec2(float(_889 & 1u), float(_889 & 2u));
    v_fog = vec4(FogColor.xyz, clamp((((length(ViewPositionAndTime.xyz - _801) / _720.z) + RenderChunkFogAlpha.x) - _720.x) / (_720.y - _720.x), 0.0, 1.0));
    v_lightmapUV = vec2(clamp(float(_879 & 15u) * 0.0625, 0.0, 1.0), clamp(float((_879 & 240u) >> uint(4)) * 0.0625, 0.0, 1.0));
#endif
#if defined(INSTANCING__OFF) && defined(RENDER_AS_BILLBOARDS__OFF) && defined(TRANSPARENT_PASS)
    mat4 _690 = u_proj;
    _690[2].x += SubPixelOffset.x;
    _690[2].y -= SubPixelOffset.y;
    vec4 _832 = a_color0;
    if (_956.w < 0.949999988079071044921875)
#endif
#if defined(INSTANCING__OFF) && defined(RENDER_AS_BILLBOARDS__ON) && defined(TRANSPARENT_PASS)
    vec3 _639 = (u_model[0] * vec4(a_position, 1.0)).xyz;
    vec4 _1131 = a_color0;
    vec3 _741 = _639 + vec3(0.5);
    vec3 _748 = normalize(_741 - ViewPositionAndTime.xyz);
    vec3 _751 = normalize(cross(vec3(0.0, 1.0, 0.0), _748));
    vec3 _738 = a_color0.xyz;
    vec3 _771 = _741 - ((cross(_748, _751) * (_738.z - 0.5)) + (_751 * (_738.x - 0.5))); // Attention!
    float _710 = length(ViewPositionAndTime.xyz - _771);
    vec4 _690 = mix(FogAndDistanceControl, vec4(0.9900000095367431640625, 1.0, 100000.0, 100000.0), bvec4(MeshContext.x > 0.5));
    mat4 _807 = u_proj;
    _807[2].x += SubPixelOffset.x;
    _807[2].y -= SubPixelOffset.y;
    vec4 _994 = vec4(1.0);
    if (_1131.w < 0.949999988079071044921875)
#endif
#if defined(INSTANCING__ON) && defined(RENDER_AS_BILLBOARDS__OFF) && defined(TRANSPARENT_PASS)
    vec4 _1073 = a_color0;
    float _733 = length(ViewPositionAndTime.xyz - _666);
    vec4 _719 = mix(FogAndDistanceControl, vec4(0.9900000095367431640625, 1.0, 100000.0, 100000.0), bvec4(MeshContext.x > 0.5));
    mat4 _783 = u_proj;
    _783[2].x += SubPixelOffset.x;
    _783[2].y -= SubPixelOffset.y;
    vec4 _925 = a_color0;
    if (_1073.w < 0.949999988079071044921875)
#endif
#if defined(INSTANCING__ON) && defined(RENDER_AS_BILLBOARDS__ON) && defined(TRANSPARENT_PASS)
    _682[0] = vec4(_1110.x, _1111.x, _1112.x, 0.0);
    _682[1] = vec4(_1110.y, _1111.y, _1112.y, 0.0);
    _682[2] = vec4(_1110.z, _1111.z, _1112.z, 0.0);
    _682[3] = vec4(_1110.w, _1111.w, _1112.w, 1.0);
    vec3 _728 = (_682 * vec4(a_position, 1.0)).xyz;
    vec4 _1257 = a_color0;
    vec3 _834 = _728 + vec3(0.5);
    vec3 _841 = normalize(_834 - ViewPositionAndTime.xyz);
    vec3 _844 = normalize(cross(vec3(0.0, 1.0, 0.0), _841));
    vec3 _831 = a_color0.xyz;
    vec3 _864 = _834 - ((cross(_841, _844) * (_831.z - 0.5)) + (_844 * (_831.x - 0.5))); // Attention!
    float _803 = length(ViewPositionAndTime.xyz - _864);
    vec4 _783 = mix(FogAndDistanceControl, vec4(0.9900000095367431640625, 1.0, 100000.0, 100000.0), bvec4(MeshContext.x > 0.5));
    mat4 _900 = u_proj;
    _900[2].x += SubPixelOffset.x;
    _900[2].y -= SubPixelOffset.y;
    vec4 _1087 = vec4(1.0);
    if (_1257.w < 0.949999988079071044921875)
#endif
#ifdef TRANSPARENT_PASS
    {
#endif
#if defined(INSTANCING__OFF) && defined(RENDER_AS_BILLBOARDS__OFF) && defined(TRANSPARENT_PASS)
        vec4 _600 = mix(FogAndDistanceControl, vec4(0.9900000095367431640625, 1.0, 100000.0, 100000.0), bvec4(MeshContext.x > 0.5));
        _832.w = mix(_956.w, 1.0, clamp(_640 / _600.w, 0.0, 1.0));
#endif
#if defined(INSTANCING__OFF) && defined(RENDER_AS_BILLBOARDS__ON) && defined(TRANSPARENT_PASS)
        vec4 _662 = mix(FogAndDistanceControl, vec4(0.9900000095367431640625, 1.0, 100000.0, 100000.0), bvec4(MeshContext.x > 0.5));
        _994.w = mix(_1131.w, 1.0, clamp(_710 / _662.w, 0.0, 1.0));
#endif
#if defined(INSTANCING__ON) && defined(RENDER_AS_BILLBOARDS__OFF) && defined(TRANSPARENT_PASS)
        vec4 _693 = mix(FogAndDistanceControl, vec4(0.9900000095367431640625, 1.0, 100000.0, 100000.0), bvec4(MeshContext.x > 0.5));
        _925.w = mix(_1073.w, 1.0, clamp(_733 / _693.w, 0.0, 1.0));
#endif
#if defined(INSTANCING__ON) && defined(RENDER_AS_BILLBOARDS__ON) && defined(TRANSPARENT_PASS)
        vec4 _755 = mix(FogAndDistanceControl, vec4(0.9900000095367431640625, 1.0, 100000.0, 100000.0), bvec4(MeshContext.x > 0.5));
        _1087.w = mix(_1257.w, 1.0, clamp(_803 / _755.w, 0.0, 1.0));
#endif
#ifdef TRANSPARENT_PASS
    }
#endif
#if defined(INSTANCING__OFF) && defined(RENDER_AS_BILLBOARDS__OFF) && defined(TRANSPARENT_PASS)
    vec2 _774 = a_texcoord1;
    uint _741 = uint(floor(_774.x * 255.0));
    uint _751 = uint(floor(_774.y * 255.0));
    v_color0 = _832;
    v_ditheringAndMaskTinting = vec2(float(_751 & 1u), float(_751 & 2u));
    v_fog = vec4(FogColor.xyz, clamp((((_640 / _626.z) + RenderChunkFogAlpha.x) - _626.x) / (_626.y - _626.x), 0.0, 1.0));
    v_lightmapUV = vec2(clamp(float(_741 & 15u) * 0.0625, 0.0, 1.0), clamp(float((_741 & 240u) >> uint(4)) * 0.0625, 0.0, 1.0));
#endif
#if defined(INSTANCING__OFF) && defined(RENDER_AS_BILLBOARDS__ON) && defined(TRANSPARENT_PASS)
    vec2 _891 = a_texcoord1;
    uint _858 = uint(floor(_891.x * 255.0));
    uint _868 = uint(floor(_891.y * 255.0));
    v_color0 = _994;
    v_ditheringAndMaskTinting = vec2(float(_868 & 1u), float(_868 & 2u));
    v_fog = vec4(FogColor.xyz, clamp((((_710 / _690.z) + RenderChunkFogAlpha.x) - _690.x) / (_690.y - _690.x), 0.0, 1.0));
    v_lightmapUV = vec2(clamp(float(_858 & 15u) * 0.0625, 0.0, 1.0), clamp(float((_858 & 240u) >> uint(4)) * 0.0625, 0.0, 1.0));
#endif
#if defined(INSTANCING__ON) && defined(RENDER_AS_BILLBOARDS__OFF) && defined(TRANSPARENT_PASS)
    vec2 _867 = a_texcoord1;
    uint _834 = uint(floor(_867.x * 255.0));
    uint _844 = uint(floor(_867.y * 255.0));
    v_color0 = _925;
    v_ditheringAndMaskTinting = vec2(float(_844 & 1u), float(_844 & 2u));
    v_fog = vec4(FogColor.xyz, clamp((((_733 / _719.z) + RenderChunkFogAlpha.x) - _719.x) / (_719.y - _719.x), 0.0, 1.0));
    v_lightmapUV = vec2(clamp(float(_834 & 15u) * 0.0625, 0.0, 1.0), clamp(float((_834 & 240u) >> uint(4)) * 0.0625, 0.0, 1.0));
#endif
#if defined(INSTANCING__ON) && defined(RENDER_AS_BILLBOARDS__ON) && defined(TRANSPARENT_PASS)
    vec2 _984 = a_texcoord1;
    uint _951 = uint(floor(_984.x * 255.0));
    uint _961 = uint(floor(_984.y * 255.0));
    v_color0 = _1087;
    v_ditheringAndMaskTinting = vec2(float(_961 & 1u), float(_961 & 2u));
    v_fog = vec4(FogColor.xyz, clamp((((_803 / _783.z) + RenderChunkFogAlpha.x) - _783.x) / (_783.y - _783.x), 0.0, 1.0));
    v_lightmapUV = vec2(clamp(float(_951 & 15u) * 0.0625, 0.0, 1.0), clamp(float((_951 & 240u) >> uint(4)) * 0.0625, 0.0, 1.0));
#endif
    v_texcoord0 = a_texcoord0;
#if defined(ALPHA_TEST_PASS) && defined(INSTANCING__OFF) && defined(RENDER_AS_BILLBOARDS__OFF)
    v_worldPos = _576;
    v_worldPosition = vec4(_575.xyz, 0.0);
    gl_Position = _702;
#endif
#if defined(ALPHA_TEST_PASS) && defined(INSTANCING__OFF) && defined(RENDER_AS_BILLBOARDS__ON)
    v_worldPos = _638;
    v_worldPosition = vec4(_637.xyz, 0.0);
    gl_Position = _819;
#endif
// Approximation, matches 56 cases out of 60
#if defined(ALPHA_TEST_PASS) && defined(INSTANCING__ON) && defined(RENDER_AS_BILLBOARDS__OFF)
    v_worldPos = _666;
#endif
#if defined(ALPHA_TEST_PASS) && defined(INSTANCING__ON) && defined(RENDER_AS_BILLBOARDS__OFF)
    v_worldPosition = vec4(_682.xyz, 0.0);
    gl_Position = _796;
#endif
// Approximation, matches 58 cases out of 60
#if defined(ALPHA_TEST_PASS) && defined(INSTANCING__ON) && defined(RENDER_AS_BILLBOARDS__ON)
    v_worldPos = _728;
#endif
#if defined(ALPHA_TEST_PASS) && defined(INSTANCING__ON) && defined(RENDER_AS_BILLBOARDS__ON)
    v_worldPosition = vec4(_744.xyz, 0.0);
    gl_Position = _913;
#endif
// Approximation, matches 56 cases out of 60
#if defined(INSTANCING__OFF) && defined(RENDER_AS_BILLBOARDS__OFF) && !defined(ALPHA_TEST_PASS)
    v_worldPos = _542;
    gl_Position = _626 * (u_view * vec4(_541.xyz, 1.0));
#endif
// Approximation, matches 58 cases out of 60
#if defined(INSTANCING__OFF) && defined(RENDER_AS_BILLBOARDS__ON) && !defined(ALPHA_TEST_PASS)
    v_worldPos = _604;
    gl_Position = _743 * (u_view * vec4(_707, 1.0));
#endif
// Approximation, matches 56 cases out of 60
#if defined(INSTANCING__ON) && defined(RENDER_AS_BILLBOARDS__OFF) && !defined(ALPHA_TEST_PASS)
    v_worldPos = _632;
    gl_Position = _720 * (u_view * vec4(_648.xyz, 1.0));
#endif
// Approximation, matches 58 cases out of 60
#if defined(INSTANCING__ON) && defined(RENDER_AS_BILLBOARDS__ON) && !defined(ALPHA_TEST_PASS)
    v_worldPos = _694;
    gl_Position = _837 * (u_view * vec4(_801, 1.0));
#endif
#if defined(INSTANCING__OFF) && defined(RENDER_AS_BILLBOARDS__OFF) && defined(TRANSPARENT_PASS)
    v_worldPos = _577;
    gl_Position = _690 * (u_view * vec4(_576.xyz, 1.0));
#endif
#if defined(INSTANCING__OFF) && defined(RENDER_AS_BILLBOARDS__ON) && defined(TRANSPARENT_PASS)
    v_worldPos = _639;
    gl_Position = _807 * (u_view * vec4(_771, 1.0));
#endif
#if defined(INSTANCING__ON) && defined(RENDER_AS_BILLBOARDS__OFF) && defined(TRANSPARENT_PASS)
    gl_Position = _783 * (u_view * vec4(_682.xyz, 1.0));
#endif
#if defined(INSTANCING__ON) && defined(RENDER_AS_BILLBOARDS__ON) && defined(TRANSPARENT_PASS)
    gl_Position = _900 * (u_view * vec4(_864, 1.0));
#endif
}
