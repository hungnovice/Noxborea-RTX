# Miration Shader Bedrock Edition (MSBE)
- A custom Render Dragon shader for minecraft bedrock edition make by CyberGangz Studio.
## Supported platform
- Android
- iOS (soon)
- Windows (soon)
## Main Developer
- [ngmvix2010](https://github.com/ngmvix2010)
- [JaggerFinn](https://github.com/JaggerFinn)

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

## Install lazurite

```
pip install rich lazurite
```
or
```
python -m pip install rich lazurite
```

for linux (maybe u need it)

```
pip install --break-system-packages rich lazurite
```
or
```
python -m pip install --break-system-packages rich lazurite
```

## how to build

**this build script only support linux, android, windows support soon.**

### main file script:
```
./build.sh
```
### usage
```
./build.sh [OPTIONS]

"Options:"
    "  --subpack [action]                      Run subpack script (e.g., create, remove)"
    "  --pack [platform]                       Run packaging script (e.g., android, ios)"
    "  --build -m [material] -p [platform]     build material for platform (e.g., android, ios)"
    "  --help                                  Show this help message"
```
#### show help:

```
./build.sh --help
```

#### setup (soon)

```
./build.sh --setup
```

#### build pack:

```
./build.sh --pack [platform]
```

#### build materials

```
./build.sh --build -m [material] -p [platform]
```

#### create subpack

````
./build.sh --subpack create
````

#### remove subpack

````
./build.sh --subpack remove
````