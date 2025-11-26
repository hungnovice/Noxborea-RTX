import os

is_done = False

while is_done == False:

    # lay thong tin co ban ve subpack
    print("---------- Create subpack ----------")
    NAME = input("Type subpack name:")
    SUBPACK_DES = input("Type subpack description:")
    print(" ")

    # yeu cau nguoi dung chon material muon build cho subpack
    print("---------- Choose materials ----------")

    IF_CHOOSE_ALL = input("do you want to choose all material? (y/n):")
    if IF_CHOOSE_ALL.lower() == 'y':
        SUBPACK_MATS = "RenderChunk Clouds Sky LegacyCubemap SunMoon "
    elif IF_CHOOSE_ALL.lower() == 'n':
        SUBPACK_MATS = ""

        IS_RDC = input("do you want choose RenderChunk? (y/n):")
        if IS_RDC.lower() == 'y':
            SUBPACK_MATS += "RenderChunk "
    
        IS_CLOUDS = input("do you want choose Clouds? (y/n):")
        if IS_CLOUDS.lower() == 'y':
            SUBPACK_MATS += "Clouds "

        IS_SKY = input("do you want choose Sky? (y/n):")
        if IS_SKY.lower() == 'y':
            SUBPACK_MATS += "Sky "
    
        IS_LCBM = input("do you want choose LegacyCubemap? (y/n):")
        if IS_LCBM.lower() == 'y':
            SUBPACK_MATS += "LegacyCubemap "
    
        IS_SUNMOON = input("do you want choose SunMoon? (y/n):")
        if IS_SUNMOON.lower() == 'y':
            SUBPACK_MATS += "SunMoon "
        
    else:
        print("???")
    print(" ")

    # xem lai tat ca thong tin ve subpack vua tao
    if IF_CHOOSE_ALL.lower() == 'y' or IF_CHOOSE_ALL.lower() == 'n':
        print("---------- Review ----------")

        print("Subpack name:", NAME)
        print("Subpack Description:", SUBPACK_DES)
        print("Subpack materials:", SUBPACK_MATS)
        print(" ")

        print("---------- hmm ----------")

        final_choice = input("agree with this information? (y/n):")

        if final_choice.lower() == 'y':
           print("preparing to create subpack config...")
           is_done = True

        elif final_choice.lower() == 'n':
            print("back to information entry step...")
            is_done = False

        else:
            print("Invalid option, your option must be 'y' or 'n', mark it done and create subpack config.")
            is_done = True

        print(" ")
    else:
        is_done == False

if is_done:
    print("---------- create config ----------")

    materials_cleaned = SUBPACK_MATS.strip()
    
    config_content_bash = (
        f'SUBPACK_NAME="{NAME}"\n'
        f'SUBPACK_DESCRIPTION="{SUBPACK_DES}"\n'
        f'SUBPACK_MATERIALS="{materials_cleaned}"'
    )
    
    file_path = "scripts/cache/subpack.cfg"
    
    bash_command = f"printf '%s' '{config_content_bash}' > {file_path}"
    
    result = os.system(bash_command)

    if result == 0:
        print("Done!")
        print("Config saved at scripts/cache/subpack.cfg")
        print("file content:")
        os.system(f'cat scripts/cache/subpack.cfg')
    else:
        print("Error.")