import os

NAME = input("nhap ten subpack muon xoa vao day:")
is_done = False
while is_done == False:
    choice = input("ban co chac muon xoa subpack nay chu (y/n)?: ")
    if choice.lower() == 'y':
        is_done = True
        config_content_bash = (
            f'SUBPACK_NAME="{NAME}"'
        )
        file_path = "scripts/cache/subpack.cfg"
    
        bash_command = f"printf '%s' '{config_content_bash}' > {file_path}"
    
        result = os.system(bash_command)

        if result == 0:
            print("Done!")
        else:
            print("Error.")
    elif choice.lower() == 'n':
        is_done = False
    else:
        print("unknown")
        is_done = False