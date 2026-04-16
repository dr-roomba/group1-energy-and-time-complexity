#!/bin/bash
dist=randcsb

echo "$dist"
sleep 1
for i in 25000 50000 75000 100000 200000 300000 400000 500000 600000 700000 800000 900000 1000000; do
	sudo ./main "java -cp $CP CountingSort ${dir}${dist}_$i" countingsort ${dist}_$i
done

dist=randcss

echo "$dist"
sleep 1
for i in 25000 50000 75000 100000 200000 300000 400000 500000 600000 700000 800000 900000 1000000; do
	sudo ./main "java -cp $CP CountingSort ${dir}${dist}_$i" countingsort ${dist}_$i
done
