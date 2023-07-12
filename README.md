# tempname
tempname is an esolang that is so early in the development stage, that it doesn't
even have a name! The point of the esolang is to reverse engineer the esolang based
on examples below (this is totally not inspired by another esolang
whatsoever). If you're stuck, there's always the source code. However, the
interpreter itself is still WIP. Instructions are also not registered 
correctly and are shuffled, so the add instruction might stdout the number
instead of adding it. The interpreter has no error handling, so it will report an
internal Java error instead of a custom error message. It's up to you to
figure out which instruction does what. If you want to retake the challenge, just
delete the seed.bin file.

Happy reverse engineering and good luck!

```
1 | stdio
2 | if
3 | goto 7
4 | goto 5
5 | stdout
6 | end
7 | stdout 1
8 | goto 7
```

```
 1 | stdio
 2 | stdio
 3 | stdio
 4 | dec 1
 5 | nif
 6 | goto 18
 7 | dec 1
 8 | nif
 9 | goto 20
10 | dec 1
11 | nif
12 | goto 22
13 | dec 1
14 | nif
15 | goto 23
16 | dec 1
17 | end
18 | inc
19 | goto 25
20 | dec
21 | goto 25
22 | mul
23 | goto 25
24 | div
25 | stdout
```