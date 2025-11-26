import os
import json

is_done = False
NAME = ""
SUBPACK_DES = ""
SUBPACK_MATS_LIST = []

ALL_MATERIALS = [
    "RenderChunk",
    "Clouds",
    "Sky",
    "LegacyCubemap",
    "SunMoon"
]

while not is_done:
    SUBPACK_MATS_LIST = []

    print("---------- Create subpack ----------")
    NAME = input("Type subpack name: ")
    SUBPACK_DES = input("Type subpack description: ")
    print(" ")

    print("---------- Choose materials ----------")

    IF_CHOOSE_ALL = input("Do you want to choose all material? (y/n): ")
    
    if IF_CHOOSE_ALL.lower() == 'y':
        SUBPACK_MATS_LIST = ALL_MATERIALS
    
    elif IF_CHOOSE_ALL.lower() == 'n':
        print("Starting manual selection...")
        for material in ALL_MATERIALS:
            choice = input(f"Do you want to choose {material}? (y/n): ")
            if choice.lower() == 'y':
                SUBPACK_MATS_LIST.append(material)
        
        if not SUBPACK_MATS_LIST:
             print("Warning: No materials selected.")

    else:
        print("Invalid option. Please choose 'y' or 'n'. Restarting...")
        print(" ")
        continue

    print(" ")

    print("---------- Review ----------")
    print("Subpack name:", NAME)
    print("Subpack Description:", SUBPACK_DES)
    print("Subpack materials:", SUBPACK_MATS_LIST)
    print(" ")

    print("---------- Finalize ----------")
    final_choice = input("Agree with this information? (y/n): ")

    if final_choice.lower() == 'y':
       print("Preparing to create subpack config...")
       is_done = True
    elif final_choice.lower() == 'n':
        print("Back to information entry step...")
        is_done = False
    else:
        print("Invalid option. Marking it done and creating subpack config based on current data.")
        is_done = True

    print(" ")

if is_done:
    print("---------- Create Config File ----------")

    mats_formatted_for_bash_array = ' '.join(f'"{mat}"' for mat in SUBPACK_MATS_LIST)
    config_materials_line = f'SUBPACK_MATERIALS=({mats_formatted_for_bash_array})'

    config_content = (
        f'SUBPACK_NAME="{NAME}"\n'
        f'SUBPACK_DESCRIPTION="{SUBPACK_DES}"\n'
        f'{config_materials_line}\n'
    )
    
    file_path = "scripts/cache/subpack.cfg"
    
    try:
        os.makedirs(os.path.dirname(file_path), exist_ok=True)
        
        with open(file_path, 'w') as f:
            f.write(config_content)
        
        print("Done!")
        print(f"Config saved at {file_path}")
        print("File content:")
        print("-" * 20)
        print(config_content)
        print("-" * 20)
        
    except Exception as e:
        print(f"Error writing file: {e}")