import json
import uuid
from pathlib import Path
import re
import sys
import toml

with open('include/configs/pack.toml', 'r', encoding='utf-8') as f:
    pack_toml_data = toml.load(f)

SUBPACKS_ROOT = Path("include/configs/subpacks") 
CONFIG_FILENAME = "subpack.cfg"
OUTPUT_FILE = 'out/manifest.json'

def parse_subpack_config(config_path: Path) -> dict:
    config = {}
    
    if not config_path.is_file():
        return config

    try:
        content = config_path.read_text(encoding='utf-8')
        
        def find_config_value(key):
            match = re.search(fr'{key}\s*=\s*(["\']?)(.*?)\1', content, re.IGNORECASE)
            if match:
                return match.group(2).strip()
            return None

        config['SUBPACK_NAME'] = find_config_value('SUBPACK_NAME')
        config['SUBPACK_DESCRIPTION'] = find_config_value('SUBPACK_DESCRIPTION')
        
    except Exception as e:
        print(f"error when reading config {config_path}: {e}", file=sys.stderr)
    
    return config

def discover_subpacks() -> list:
    subpacks_list = []
    
    if not SUBPACKS_ROOT.is_dir():
        print(f"subpacks folder doesn't exist: {SUBPACKS_ROOT}")
        return subpacks_list

    for folder in SUBPACKS_ROOT.iterdir():
        if folder.is_dir():
            folder_name = folder.name
            config_path = folder / CONFIG_FILENAME
            
            config = parse_subpack_config(config_path)
            
            if config.get('SUBPACK_NAME'):
                print(f"found subpack: {config['SUBPACK_NAME']} ({folder_name})")
                
                subpacks_list.append({
                    "folder_name": folder_name,
                    "name": config['SUBPACK_NAME'],
                    "memory_tier": 1 
                })
            else:
                if config_path.is_file():
                     print(f"skip {folder_name}: folder, missing SUBPACK_NAME in {CONFIG_FILENAME}.", file=sys.stderr)
                else:
                    print(f"skip {folder_name}: folder, {CONFIG_FILENAME} not found.", file=sys.stderr)

    return subpacks_list

def generate_manifest():
    subpacks_discovered = discover_subpacks()
    
    module_uuid = "528770c5-5138-4cb9-82be-d438671779a0"
    formatted_description = f"\u00a7b{pack_toml_data['description']}\n\u00a77- Shader được phát triển bởi CyberGangz Studio.\n"
    
    manifest_data = {
        "format_version": 2,
        "header": {
            "name": pack_toml_data["name"],
            "description": formatted_description, 
            "uuid": pack_toml_data["uuid"], 
            "version": pack_toml_data["version"], 
            "min_engine_version": pack_toml_data["min_supported_mc_version"] 
        },
        "modules": [
            {
                "type": "resources",
                "uuid": module_uuid, 
                "version": pack_toml_data["version"]
            }
        ],
        "metadata": {
            "authors": pack_toml_data["authors"],
            "url": pack_toml_data["url"]
        }
    }
    
    if subpacks_discovered:
        default_subpack = {
            "folder_name": "default",
            "name": "Default",
            "memory_tier": 1
        }
        
        final_subpacks = [default_subpack] + subpacks_discovered
        
        manifest_data["subpacks"] = final_subpacks
        print(f"\n added 'subpacks' with count {len(final_subpacks)} subpack.")
    else:
        print("\n can not find any subpack config. 'subpacks' will be skip.")

    try:
        with open(OUTPUT_FILE, 'w', encoding='utf-8') as f:
            json.dump(manifest_data, f, ensure_ascii=False, indent=4)
            
        print(f"file created succesfuly: {OUTPUT_FILE}")
        
    except IOError:
        print(f"Error: can't write file {OUTPUT_FILE}.", file=sys.stderr)

if __name__ == "__main__":
    generate_manifest()