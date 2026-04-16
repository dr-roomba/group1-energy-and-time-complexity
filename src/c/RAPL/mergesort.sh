#!/bin/bash
dist=rand

echo $dist
for i in 25000 50000 75000 100000 200000 300000 400000 500000 600000 700000 800000 900000 1000000; do
	sudo ./main "java -cp $CP MergeSort ${dir}${dist}_$i" mergesort ${dist}_$i
done

dist=sortd

echo $dist
for i in 25000 50000 75000 100000 200000 300000 400000 500000 600000 700000 800000 900000 1000000; do
	sudo ./main "java -cp $CP MergeSort ${dir}${dist}_$i" mergesort ${dist}_$i
done

dist=alt

echo $dist
for i in 25000 50000 75000 100000 200000 300000 400000 500000 600000 700000 800000 900000 1000000; do
	sudo ./main "java -cp $CP MergeSort ${dir}${dist}_$i" mergesort ${dist}_$i
done
