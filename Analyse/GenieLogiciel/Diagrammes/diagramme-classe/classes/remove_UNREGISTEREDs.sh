#!/bin/bash

# Supprime les watermarks "UNREGISTERED" de StarUML des fichiers SVG dans un certain
# répertoire. L'exécution de ce script est potentiellement destructrice s'il est placé
# dans le mauvais répertoire.

# Actuellement, le script regarde dans `svg` dans le répertoire courant.
target=svg

[ ! -d $target ] && printf "$0: '$target' directory not found\n" && exit 1

for file in $target/*; do
    printf "Processing $file...\n"
    sed -i 's|UNREGISTERED||g' $file
done

unset file
unset target

printf "Processed all diagrams.\n"
