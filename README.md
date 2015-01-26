# Génération de lambda termes pour du test
Projet AAGA "Générateur de lambda-termes pour du test"

## Termes les plus simples

### Générateur de Boltzmann de types de termes habitables.

On défini la taille d'un type par son nombre de noeuds internes. Cette définition sera conservée pour le reste du document.

Un type est défini par:

    Type ::= Int | Type -> Type
  
La série associée et donc:

    B(z) = 1 + zB²(z)
    
### Construction d'un terme de taille minimale habitant un type

On définit les termes de la façon suivante:
    
    Terme ::= x | λx:σ.M | M N

### Construction d'un terme de taille donnée habitant un type
    
## Termes enrichis

### Des types simples, et d'autres un peu plus construits

La constante `0` est trivialement de type `Int` mais également le terme suivant: `λx:Int.λy:Int.x+y 10 12`.

`λx:Int.x+2` est de type `Int->Int`.

`λx:Int.λy:Int.x+y` est de type `Int->Int->Int`.

### Générateur de Boltzmann de types de termes habitables

On choisit de conserver la représentation des types définie précédemment.

### Construction d'un terme de taille minimale habitant un type

### Construction d'un terme de taille donnée habitant un type

## Termes riches

### Des types simples, et d'autres un peu plus construits

La constante `0` est trivialement de type `Int` mais également le terme suivant: `λx:List[Int].head x`.

### Générateur de Boltzmann de types de termes habitables

### Construction d'un terme de taille minimale habitant un type

### Construction d'un terme de taille donnée habitant un type
