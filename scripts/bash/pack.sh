#!/bin/bash

MATS=("RenderChunk" "Clouds" "Sky" "LegacyCubemap" "SunMoon")

while [[ $# -gt 0 ]]; do
    key="$1"

    --pack)
            PLATFORM="$2"
            if [ "$PLATFORM" == "android" ]; then
                echo "creating out pack dir..."
                mkdir -p out/platform/android/pack
                sleep 0.1
                echo "copy pack assets to out pack dir..."
                cp -r assets/main/* out/platform/android/pack/
                sleep 0.6

                echo "copy main config to global config...'
                cp include/configs/main/config.cfg global_config/.config
                sleep 0.1
                for mat in "${MATS[@]}"; do
                    echo "building $mat for main pack..."
                    lazurite build ./main -o out/platform/android/pack/renderer/materials/ -p android -m $mat --shaderc env/shaderc 
                    sleep 0.2
                done
                echo "remove global config..."
                rm -rf global_config/.config
                sleep 0.3
            fi

            shift
            shift
            ;;