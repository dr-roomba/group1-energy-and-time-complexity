#!/bin/bash
dist=rand

echo $dist
for i in 25000 50000 75000 100000 200000; do
	sudo ./main "java -cp $CP QuickSort ${dir}${dist}_$i" quicksort ${dist}_$i
done

dist=qb

echo $dist
for i in 25000 50000 75000 100000 200000 300000 400000 500000 600000 700000 800000 900000 1000000; do
	sudo ./main "java -cp $CP QuickSort ${dir}${dist}_$i" quicksort ${dist}_$i
done

dist=rev

echo $dist
for i in 25000 50000 75000 100000 200000 300000 400000 500000 600000 700000 800000 900000 1000000; do
	sudo ./main "java -cp $CP QuickSort ${dir}${dist}_$i" quicksort ${dist}_$i
done
