#!/bin/bash

MATS="RenderChunk Clouds Sky LegacyCubemap SunMoon"

while [[ $# -gt 0 ]]; do
    key="$1"
    
    case "$key" in
        --pack)
            PLATFORM="$2"

            # ------ Android ------
            if [ "$PLATFORM" == "android" ]; then
                echo " "
                echo "---------- Make pack assets for $PLATFORM ----------"
                echo "removing out old build file..."
                rm -rf out/platform/android
                sleep 0.5
                echo "creating out pack dir..."
                mkdir -p out/platform/android/pack/renderer/materials
                sleep 0.1
                echo "copy pack assets to out pack dir..."
                cp -r assets/main/* out/platform/android/pack/
                sleep 0.6

                if [ -d "assets/subpacks" ] && find "assets/subpacks" -mindepth 1 -print -quit 2>/dev/null | grep -q .; then
                    echo " "
                    echo "---------- Make subpacks assets for $PLATFORM ----------"
                    echo "creating subpacks pack dir..."
                    mkdir -p out/platform/android/pack/subpacks
                    sleep 0.1
                    echo "copy subpacks assets to out subpacks dir..."
                    cp -r assets/subpacks/* out/platform/android/pack/subpacks/
                    sleep 0.6
                else
                    echo " "
                    echo "---------- Make subpacks assets for $PLATFORM ----------"
                    echo "no subpack asset detected, stop create subpack asset"
                fi

                echo " "
                echo "---------- Building pack materials for $PLATFORM ----------"
                echo "copy main config to global config..."
                # cp include/configs/main/config.cfg global_config/.config
                cat include/configs/main/config.cfg >> global_config/.config
                sleep 0.1
                echo "building main materials..."
                lazurite build ./proj -p android --shaderc env/shaderc
                mv *.material.bin out/platform/android/pack/renderer/materials/
                echo "remove global config..."
                rm -f global_config/.config
                sleep 0.3

                if [ -d "include/configs/subpacks/" ] && find "include/configs/subpacks/" -mindepth 1 -print -quit 2>/dev/null | grep -q .; then
                    for SUBPACK_CONFIG_DIR in include/configs/subpacks/*; do
                        SUBPACK_NAME=$(basename "$SUBPACK_CONFIG_DIR")
                        echo " "
                        echo "---------- Building subpack $SUBPACK_NAME materials for $PLATFORM ----------"
                        echo "copy subpack $SUBPACK_NAME config to global config..."
                        # cp include/configs/subpacks/$SUBPACK_NAME/config.cfg global_config/.config
                        cat include/configs/subpacks/$SUBPACK_NAME/config.cfg >> global_config/.config
                        sleep 0.1

                        echo "building materials for subpack $SUBPACK_NAME..."
                        source include/configs/subpacks/$SUBPACK_NAME/subpack.cfg
                        lazurite build ./proj -p android --shaderc env/shaderc
                        mv *.material.bin out/platform/android/pack/subpacks/$SUBPACK_NAME/renderer/materials/
                        sleep 0.2
                        echo "remove global config..."
                        rm -f global_config/.config
                    done
                else
                    echo " "
                    echo "---------- Building subpacks materials for $PLATFORM ----------"
                    echo "no subpack config detected, stop building subpacks materials"

                echo " "
                echo "---------- Building pack manifest for $PLATFORM ----------"
                echo "Building out/manifest.json"
                python scripts/python/build_manifest.py
                sleep 0.6
                echo "Move manifest.json to pack dir..."
                mv out/manifest.json out/platform/android/pack/manifest.json
                fi

            # ------ iOS ------
            elif [ "$PLATFORM" == "ios" ]; then
                echo " "
                echo "---------- Make pack assets for $PLATFORM ----------"
                echo "removing out old build file..."
                rm -rf out/platform/ios
                sleep 0.5
                echo "creating out pack dir..."
                mkdir -p out/platform/ios/pack/renderer/materials
                sleep 0.1
                echo "copy pack assets to out pack dir..."
                cp -r assets/main/* out/platform/ios/pack/
                sleep 0.6

                if [ -d "assets/subpacks" ] && find "assets/subpacks" -mindepth 1 -print -quit 2>/dev/null | grep -q .; then
                    echo " "
                    echo "---------- Make subpacks assets for $PLATFORM ----------"
                    echo "creating subpacks pack dir..."
                    mkdir -p out/platform/ios/pack/subpacks
                    sleep 0.1
                    echo "copy subpacks assets to out subpacks dir..."
                    cp -r assets/subpacks/* out/platform/ios/pack/subpacks/
                    sleep 0.6
                else
                    echo " "
                    echo "---------- Make subpacks assets for $PLATFORM ----------"
                    echo "no subpack asset detected, stop create subpack asset"
                fi

                echo " "
                echo "---------- Building pack materials for $PLATFORM ----------"
                echo "copy main config to global config..."
                cat include/configs/main/config.cfg >> global_config/.config
                sleep 0.1
                echo "building main materials..."
                lazurite build ./proj -p ios --shaderc env/shaderc # Thay đổi: -p ios
                mv *.material.bin out/platform/ios/pack/renderer/materials/
                echo "remove global config..."
                rm -f global_config/.config
                sleep 0.3

                if [ -d "include/configs/subpacks/" ] && find "include/configs/subpacks/" -mindepth 1 -print -quit 2>/dev/null | grep -q .; then
                    for SUBPACK_CONFIG_DIR in include/configs/subpacks/*; do
                        SUBPACK_NAME=$(basename "$SUBPACK_CONFIG_DIR")
                        echo " "
                        echo "---------- Building subpack $SUBPACK_NAME materials for $PLATFORM ----------"
                        echo "copy subpack $SUBPACK_NAME config to global config..."
                        cat include/configs/subpacks/$SUBPACK_NAME/config.cfg >> global_config/.config
                        sleep 0.1

                        echo "building materials for subpack $SUBPACK_NAME..."
                        source include/configs/subpacks/$SUBPACK_NAME/subpack.cfg
                        lazurite build ./proj -p ios --shaderc env/shaderc # Thay đổi: -p ios
                        mv *.material.bin out/platform/ios/pack/subpacks/$SUBPACK_NAME/renderer/materials/
                        sleep 0.2
                        echo "remove global config..."
                        rm -f global_config/.config
                    done
                else
                    echo " "
                    echo "---------- Building subpacks materials for $PLATFORM ----------"
                    echo "no subpack config detected, stop building subpacks materials"

                echo " "
                echo "---------- Building pack manifest for $PLATFORM ----------"
                echo "Building out/manifest.json"
                python scripts/python/build_manifest.py
                sleep 0.6
                echo "Move manifest.json to pack dir..."
                mv out/manifest.json out/platform/ios/pack/manifest.json
                fi

            # ------ Windows ------
            elif [ "$PLATFORM" == "windows" ]; then
                echo " "
                echo "---------- Make pack assets for $PLATFORM ----------"
                echo "removing out old build file..."
                rm -rf out/platform/windows
                sleep 0.5
                echo "creating out pack dir..."
                mkdir -p out/platform/windows/pack/renderer/materials
                sleep 0.1
                echo "copy pack assets to out pack dir..."
                cp -r assets/main/* out/platform/windows/pack/
                sleep 0.6

                if [ -d "assets/subpacks" ] && find "assets/subpacks" -mindepth 1 -print -quit 2>/dev/null | grep -q .; then
                    echo " "
                    echo "---------- Make subpacks assets for $PLATFORM ----------"
                    echo "creating subpacks pack dir..."
                    mkdir -p out/platform/windows/pack/subpacks
                    sleep 0.1
                    echo "copy subpacks assets to out subpacks dir..."
                    cp -r assets/subpacks/* out/platform/windows/pack/subpacks/
                    sleep 0.6
                else
                    echo " "
                    echo "---------- Make subpacks assets for $PLATFORM ----------"
                    echo "no subpack asset detected, stop create subpack asset"
                fi

                echo " "
                echo "---------- Building pack materials for $PLATFORM ----------"
                echo "copy main config to global config..."
                cat include/configs/main/config.cfg >> global_config/.config
                sleep 0.1
                echo "building main materials..."
                lazurite build ./proj -p windows --shaderc env/shaderc # Thay đổi: -p windows
                mv *.material.bin out/platform/windows/pack/renderer/materials/
                echo "remove global config..."
                rm -f global_config/.config
                sleep 0.3

                if [ -d "include/configs/subpacks/" ] && find "include/configs/subpacks/" -mindepth 1 -print -quit 2>/dev/null | grep -q .; then
                    for SUBPACK_CONFIG_DIR in include/configs/subpacks/*; do
                        SUBPACK_NAME=$(basename "$SUBPACK_CONFIG_DIR")
                        echo " "
                        echo "---------- Building subpack $SUBPACK_NAME materials for $PLATFORM ----------"
                        echo "copy subpack $SUBPACK_NAME config to global config..."
                        cat include/configs/subpacks/$SUBPACK_NAME/config.cfg >> global_config/.config
                        sleep 0.1

                        echo "building materials for subpack $SUBPACK_NAME..."
                        source include/configs/subpacks/$SUBPACK_NAME/subpack.cfg
                        lazurite build ./proj -p windows --shaderc env/shaderc # Thay đổi: -p windows
                        mv *.material.bin out/platform/windows/pack/subpacks/$SUBPACK_NAME/renderer/materials/
                        sleep 0.2
                        echo "remove global config..."
                        rm -f global_config/.config
                    done
                else
                    echo " "
                    echo "---------- Building subpacks materials for $PLATFORM ----------"
                    echo "no subpack config detected, stop building subpacks materials"

                echo " "
                echo "---------- Building pack manifest for $PLATFORM ----------"
                echo "Building out/manifest.json"
                python scripts/python/build_manifest.py
                sleep 0.6
                echo "Move manifest.json to pack dir..."
                mv out/manifest.json out/platform/windows/pack/manifest.json
                fi
            
            fi

            shift
            shift
            ;;
        esac
done
