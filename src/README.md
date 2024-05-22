`n = cantidad de palabras del archivo`

`l = cantidad de letras extremas`

`ls = letras extremas mas repetidas. ls <= l`

`s = palabras asociadas a letra extras más repetida. s <= n` 

* Para lectura `n`
* Para analizar
  * contar la cantidad de repeticiones `n`
  * obtener la/s letras más repetidas con sus palabras asociadas `l`
* Para escritura `ls + s`

Complejidad computacional total = `O(n)`

Dado que la entrada máxima del archivo es de 250 palabras y se considera un número bajo para la complejidad computacional (`O(n)`) del algoritmo, consideramos óptima la complejidad en función del tiempo.

Mientras que en términos de espacio, se utilizan como máximo 4 listas en simultáneo para el manejo de los datos. 
De igual forma que con el tiempo, consideramos que la cantidad de datos posibles es despreciable.


