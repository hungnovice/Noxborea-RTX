#!/bin/bash

mkdir scripts/cache
touch scripts/cache/subpack.cfg

echo ""
echo "---------- Removing subpack dir config ----------"
echo "list all subpack:"
ls include/configs/subpacks/
python "scripts/python/remove_subpack.py"
source scripts/cache/subpack.cfg
echo "removing subpack config dir..."
rm -rf include/configs/subpacks/$SUBPACK_NAME/
sleep 0.3
echo "removing subpack asset dir..."
rm -rf assets/subpacks/$SUBPACK_NAME/
sleep 0.55
echo "cleaning cache config..."
rm -rf scripts/cache
sleep 0.5
echo "done!"
