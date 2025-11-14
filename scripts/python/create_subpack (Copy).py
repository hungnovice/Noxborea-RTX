import os

is_done

#while is_done == False:

# lay thong tin co ban ve subpack
print("---------- Create subpack ----------")
NAME = input("Type subpack name:")
SUBPACK_DES = input("Type subpack description:")

# yeu cau nguoi dung chon material muon build cho subpack
print("---------- Choose materials ----------")

IF_CHOOSE_ALL = input("do you want to choose all material? (y/n):")
if IF_CHOOSE_ALL == 'y' or IF_CHOOSE_ALL == 'Y':
    SUBPACK_MATS = "RenderChunk Clouds Sky LegacyCubemap SunMoon "
elif IF_CHOOSE_ALL == 'n' or IF_CHOOSE_ALL == 'N':
    SUBPACK_MATS = ""

    IS_RDC = input("do you want choose RenderChunk? (y/n):")
    if IS_RDC == 'y' or IS_RDC == 'Y':
        SUBPACK_MATS += "RenderChunk "
    
    IS_CLOUDS = input("do you want choose Clouds? (y/n):")
    if IS_CLOUDS == 'y' or IS_CLOUDS == 'Y':
        SUBPACK_MATS += "Clouds "

    IS_SKY = input("do you want choose Sky? (y/n):")
    if IS_SKY == 'y' or IS_SKY == 'Y':
        SUBPACK_MATS += "Sky "
    
    IS_LCBM = input("do you want choose LegacyCubemap? (y/n):")
    if IS_LCBM == 'y' or IS_LCBM == 'Y':
        SUBPACK_MATS += "LegacyCubemap "
    
    IS_SUNMOON = input("do you want choose SunMoon? (y/n):")
    if IS_SUNMOON == 'y' or IS_SUNMOON == 'Y':
        SUBPACK_MATS += "SunMoon "
        
else:
    print("???")

# xem lai tat ca thong tin ve subpack vua tao
print("---------- Review ----------")
print("Subpack name:", NAME)
print("Subpack Description:", SUBPACK_DES)
print("Subpack materials:", SUBPACK_MATS)

