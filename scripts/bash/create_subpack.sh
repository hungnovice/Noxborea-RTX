#!/bin/bash

mkdir scripts/cache
touch scripts/cache/subpack.cfg

python "scripts/python/create_subpack.py"

echo ""
echo "---------- Create subpack dir config ----------"

source scripts/cache/subpack.cfg

echo "create subpack dir..."
mkdir -p include/configs/subpacks/$SUBPACK_NAME/
mkdir -p assets/subpacks/$SUBPACK_NAME/
sleep 0.3
echo "copy database to subpack dir..."
cp -r include/configs/database/* include/configs/subpacks/$SUBPACK_NAME/
cp -r assets/db-assets/* assets/subpacks/$SUBPACK_NAME/
cp -r scripts/cache/subpack.cfg include/configs/subpacks/$SUBPACK_NAME/subpack.cfg
sleep 0.9
echo "cleaning cache config..."
rm -rf scripts/cache
sleep 0.5
echo "done!"
