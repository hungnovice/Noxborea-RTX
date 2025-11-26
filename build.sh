#!/bin/bash

SCRIPT_BASE="scripts/bash"

show_help() {
    echo "Usage: ./build.sh [OPTIONS]"
    echo ""
    echo "Options:"
    echo "  --config [action]                       Run configuration script (e.g., create)"
    echo "  --pack [platform]                       Run packaging script (e.g., android, ios)"
    echo "  --build -m [material] -p [platform]     build material for platform (e.g., android, ios)"
    echo "  --help                                  Show this help message"
}

if [ $# -eq 0 ]; then
    show_help
    exit 1
fi

while [[ $# -gt 0 ]]; do
    key="$1"

    case $key in
        --subpack)
            ACTION="$2"
            if [ -z "$ACTION" ]; then
                echo "Error: --config requires an argument (e.g., create, remove)."
                exit 1
            fi

            if [ "$ACTION" == "create" ]; then
                TARGET_SCRIPT="$SCRIPT_BASE/create_subpack.sh"
            elif [ "$ACTION" == "remove" ]; then
                TARGET_SCRIPT="$SCRIPT_BASE/remove_subpack.sh"
            else
                echo "Error: unknown command"
            fi

            echo "Starting create subpack: $ACTION..."
            
            if [ -f "$TARGET_SCRIPT" ]; then
                bash "$TARGET_SCRIPT"
            else
                echo "Error: Script '$TARGET_SCRIPT' not found."
            fi
            
            shift
            shift
            ;;

        --pack)
            PLATFORM="$2"
            if [ -z "$PLATFORM" ]; then
                echo "Error: --pack requires a platform argument (e.g., android)."
                exit 1
            fi

            TARGET_SCRIPT="$SCRIPT_BASE/pack.sh"

            echo "Starting packing for platform: $PLATFORM..."

            if [ -f "$TARGET_SCRIPT" ]; then
                bash "$TARGET_SCRIPT" "$PLATFORM"
            else
                echo "Error: Script '$TARGET_SCRIPT' not found."
            fi

            shift
            shift
            ;;

        --help)
            show_help
            exit 0
            ;;

        *)
            echo "Unknown option: $1"
            show_help
            exit 1
            ;;
    esac
done