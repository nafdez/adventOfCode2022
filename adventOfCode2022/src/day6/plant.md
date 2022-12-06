## Planteamiento Day 5 Part 1
### Método que de una entrada en serie detecte el inicio de un paquete de datos

- Cada inicio de paquete está marcado por cuatro caracteres diferentes.
- Si los caracteres se repiten NO es un marcador.

~~~
mjqjpqmgbljsphdztnvjfqwrcgsmlb
~~~
- "mjqj" La "j" está repetida, no puede ser el inicio.
- "jqjp" Exactamente el mismo caso que arriba.
- "qjpq" "q" repetida.
- "jpqm" Este sería el marcador, ningún caracter está repetido.
- El valor devuelto sería 7, porque ha sido necesario procesar hasta la letra "m" cuya posición es 7.

1. Leer de 4 en 4, el segundo caracter del primer grupo, es el inicio del siguiente.
2. Si dentro de esos 4 alguno está repetido, no es un indicador.
3. Contar caracteres hasta el primer marcador.