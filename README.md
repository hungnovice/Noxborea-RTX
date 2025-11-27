# Miration Shader Bedrock Edition (MSBE)
- A custom Render Dragon shader for minecraft bedrock edition make by CyberGangz Studio.
## Supported platform
- Android
- iOS (Jailbreak only)
- Windows (soon)
## Main Developer
- [ngmvix2010](https://github.com/ngmvix2010) - Dựng build tool, source code, và nền tảng ban đầu cho shader
- [JaggerFinn](https://github.com/JaggerFinn) - Phát triển hiệu ứng phụ cho shader, và đòi nợ msbe (up link 99m) 🫩💔✌️🐧
- [congcq](https://github.com/congcq) - Thêm phần hỗ trợ build cho iOS

## Install Depends

### Ubuntu && Debian based

```
sudo apt install git python3 python3-pip
```

### Fedora based

```
sudo dnf install git python3 python3-pip
```

### Arch Linux based

```
sudo pacman -S git python
```

### Android (Termux)

```
pkg install git python3 python3-pip
```

### iOS
For iOS environment, currently require jailbreak. Both rootful and rootless are supported:

- Add [CongChu's Repository](https://congcq.github.io) to Sileo/Zebra

- Find and install Terminal, git and python3.12

- Open Terminal, run: `sudo python -m ensurepip --upgrade`

## Install lazurite

Run:

```
pip install rich lazurite
```
or
```
python -m pip install rich lazurite
```

For Linux (maybe you need it):

```
pip install --break-system-packages rich lazurite
```
or
```
python -m pip install --break-system-packages rich lazurite
```

For iOS:

```
sudo pip install rich lazurite
```

or

```
sudo python -m pip install rich lazurite
```

For iOS rootless jailbreak, you must patch .so files of python modules (pyjson5, cpuid, raw_aes) from macOS to iOS by `vtool` to be executable:
```
sudo apt install vtool
export PYMP="/var/jb/usr/local/lib/python3.12/site-packages"
sudo vtool -arch arm64 -set-build-version 2 14.0 16.0 -replace -output $PYMP/pyjson5/pyjson5.cpython-312-darwin.so $PYMP/pyjson5/pyjson5.cpython-312-darwin.so
sudo vtool -arch arm64 -set-build-version 2 14.0 16.0 -replace -output $PYMP/Crypto/Util/_cpuid_c.abi3.so $PYMP/Crypto/Util/_cpuid_c.abi3.so
sudo vtool -arch arm64 -set-build-version 2 14.0 16.0 -replace -output $PYMP/Crypto/Cipher/_raw_aes.abi3.so $PYMP/Crypto/Cipher/_raw_aes.abi3.so
```

## How to build

**This build script only support linux, android, windows support soon.**

### Main file script:
```
./build.sh
```
### Usage
```
./build.sh [OPTIONS]

"Options:"
    "  --subpack [action]                      Run subpack script (e.g., create, remove)"
    "  --pack [platform]                       Run packaging script (e.g., android, ios)"
    "  --build -m [material] -p [platform]     build material for platform (e.g., android, ios)"
    "  --help                                  Show this help message"
```
#### Show help:

```
./build.sh --help
```

#### Setup (soon)

```
./build.sh --setup
```

#### Build pack:

```
./build.sh --pack [platform]
```

#### Build materials

```
./build.sh --build -m [material] -p [platform]
```

#### Create subpack

````
./build.sh --subpack create
````

#### Remove subpack

````
./build.sh --subpack remove
````